package com.fhec.config.ini;

import java.beans.PropertyDescriptor;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.configuration2.SubnodeConfiguration;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import com.fhec.context.Temporary;
import com.fhec.log.Log;

public class INIConfigObject {

	private String filename;

	private INIConfiguration iniConfiguration;

	public INIConfigObject(String filename) {
		this.filename = filename;
		iniConfiguration = new INIConfiguration();
		iniConfiguration.setSupportlineContinue(false);
	}

	public <T> T toJavaObject(Class<T> clazz) throws Exception {
		FileReader fileReader = new FileReader(filename);
		try {

			iniConfiguration.read(fileReader);

			T object = clazz.newInstance();

			mapping(iniConfiguration, object, clazz);
			return object;
		} finally {
			fileReader.close();
		}
	}

	public static <T> T toJavaObject(String filename, Class<T> clazz) throws Exception {
		INIConfigObject iniConfigObject = new INIConfigObject(filename);
		return iniConfigObject.toJavaObject(clazz);
	}

	private Map<String, SubnodeConfiguration> getSectionMap(INIConfiguration iniConfiguration) {
		HashMap<String, SubnodeConfiguration> map = new HashMap<String, SubnodeConfiguration>();
		Set<String> sections = iniConfiguration.getSections();
		for (String name : sections) {
			SubnodeConfiguration subnodeConfiguration = iniConfiguration.getSection(name);
			map.put(name, subnodeConfiguration);
		}

		return map;
	}

	private <T> Map<String, SectionField> getSectionMap(Class<T> clazz) {
		HashMap<String, SectionField> map = new HashMap<String, SectionField>();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			INISection iniSection = field.getAnnotation(INISection.class);
			if (iniSection == null) {
				continue;
			}
			String name = iniSection.name();
			if (StringUtils.isEmpty(name)) {
				name = field.getName();
			}
			map.put(name, new SectionField(field, iniSection));
		}
		return map;
	}

	private Map<String, SectionNodeField> getSectionNodeMap(Class<?> type) {
		HashMap<String, SectionNodeField> map = new HashMap<String, SectionNodeField>();
		Field[] fields = type.getDeclaredFields();
		for (Field field : fields) {
			INISectionNode iniSectionNode = field.getAnnotation(INISectionNode.class);
			if (iniSectionNode == null) {
				continue;
			}
			String name = iniSectionNode.name();
			if (StringUtils.isEmpty(name)) {
				name = field.getName();
			}
			if (name.contains(iniSectionNode.delimiter())) {
				name = StringUtils.replace(name, iniSectionNode.delimiter(),
						iniSectionNode.escape() + iniSectionNode.delimiter());
			}
			map.put(name, new SectionNodeField(field, iniSectionNode));
		}
		return map;
	}

	private <T> void mapping(INIConfiguration iniConfiguration, Object object, Class<T> clazz) throws Exception {
		Map<String, SubnodeConfiguration> sectionConfigMap = getSectionMap(iniConfiguration);
		Map<String, SectionField> sectionFieldMap = getSectionMap(clazz);
		mapping(sectionConfigMap, object, clazz, sectionFieldMap);
	}

	private <T> void mapping(Map<String, SubnodeConfiguration> configMap, Object object, Class<T> clazz,
			Map<String, SectionField> objectMap) throws Exception {

		for (Entry<String, SectionField> entry : objectMap.entrySet()) {
			INISection iniSection = entry.getValue().getIniSection();
			if (!iniSection.isRequired()) {
				continue;
			}
			if (configMap.containsKey(entry.getKey())) {
				continue;
			}
//			throwRequiredException(entry.getKey());
		}

		for (Entry<String, SubnodeConfiguration> entry : configMap.entrySet()) {
			if (StringUtils.isEmpty(entry.getKey())) {
				mapping(entry.getValue(), object);
				continue;
			}
			SectionField sectionField = objectMap.get(entry.getKey());
			if (sectionField == null) {
				continue;
//				throwMappingException(entry.getKey());
			}

			Field field = sectionField.getField();
			Class<?> type = field.getType();
			PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), object.getClass());
			Method getterMethod = propertyDescriptor.getReadMethod();
			Object value = getterMethod.invoke(object);
			if (value == null) {
				Method setterMethod = propertyDescriptor.getWriteMethod();
				value = type.newInstance();
				setterMethod.invoke(object, value);
			}
			mapping(entry.getValue(), value);
		}
	}

	private void mapping(SubnodeConfiguration configuration, Object object) throws Exception {
		Map<String, SectionNodeField> objectMap = getSectionNodeMap(object.getClass());
		mapping(configuration, object, objectMap);
	}

	private void mapping(SubnodeConfiguration configuration, Object object, Map<String, SectionNodeField> objectMap)
			throws Exception {

		String sectionName = configuration.getRootElementName();
		Iterator<String> keys = configuration.getKeys();

		HashSet<String> set = new HashSet<String>();
		for (Iterator<String> iterator = keys; iterator.hasNext();) {
			String key = iterator.next();
			set.add(key);
			SectionNodeField sectionNodeField = objectMap.get(key);
			if (sectionNodeField == null) {
//				throwMappingException(sectionName, key);
				continue;
			}
			Field field = sectionNodeField.getField();

			PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), object.getClass());
			Method setterMethod = propertyDescriptor.getWriteMethod();

			Object value = configuration.get(field.getType(), key);
			INISectionNode sectionNode = sectionNodeField.getIniSectionNode();
			if (sectionNode.isRequired() && ObjectUtils.isEmpty(value)) {
				continue;
//				throwRequiredException(sectionName, key);
			}
			setterMethod.invoke(object, value);

			if (Temporary.path != null) {
				Log.info(key + " : " + value);
			}

		}
		for (Entry<String, SectionNodeField> entry : objectMap.entrySet()) {
			INISectionNode sectionNode = entry.getValue().getIniSectionNode();
			if (!sectionNode.isRequired()) {
				continue;
			}
			if (set.contains(entry.getKey())) {
				continue;
			}
//			throwRequiredException(sectionName, entry.getKey());
		}
	}

	private void throwRequiredException(String sectionName) throws Exception {
		throw new Exception("file: " + filename + "\r\n section: " + sectionName + " must be required. ");
	}

	private void throwRequiredException(String sectionName, String nodename) throws Exception {
		throw new Exception(
				"file: " + filename + "\r\n section: " + sectionName + " node: " + nodename + " must be required. ");
	}

	private void throwMappingException(String sectionName) throws Exception {
		throw new Exception("file: " + filename + "\r\n section: " + sectionName + " mapping failed. ");
	}

	private void throwMappingException(String sectionName, String nodename) throws Exception {
		throw new Exception(
				"file: " + filename + "\r\n section: " + sectionName + " node: " + nodename + " mapping failed. ");
	}

	public class SectionField {

		private Field field;

		private INISection iniSection;

		public SectionField(Field field, INISection iniSection) {

			this.field = field;
			this.iniSection = iniSection;
		}

		public Field getField() {
			return field;
		}

		public INISection getIniSection() {
			return iniSection;
		}

	}

	public class SectionNodeField {

		private Field field;

		private INISectionNode iniSectionNode;

		public SectionNodeField(Field field, INISectionNode iniSectionNode) {

			this.field = field;
			this.iniSectionNode = iniSectionNode;
		}

		public Field getField() {
			return field;
		}

		public INISectionNode getIniSectionNode() {
			return iniSectionNode;
		}

	}

}
