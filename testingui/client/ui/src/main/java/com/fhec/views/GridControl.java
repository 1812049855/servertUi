package com.fhec.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Panel;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.apache.commons.lang3.StringUtils;

public class GridControl extends Panel {

	private List<Column> columns;

	private List<Object> datas;

	private DefaultTableModel tableModel;

	private JTable gridview;
	private JScrollPane scrollPane;

	private Object[][] rowvalues;

	/**
	 * Creates new form GridViewPanel
	 */
	public GridControl(List<Column> columns, List<Object> datas, Object[][] rowvalues) {
		this.columns = columns == null ? new ArrayList<Column>() : columns;
		this.datas = datas == null ? new ArrayList<Object>() : datas;
		this.rowvalues = rowvalues == null ? new Object[][] {} : rowvalues;
		initialize();
	}

	public GridControl() {

	}

	public TableModel getModel() {
		return tableModel;
	}

	public JTable getGridView() {
		return gridview;
	}

	private Object[][] getvls() {
		return null;

	}

	public void initialize() {
		this.scrollPane = new javax.swing.JScrollPane();
		this.gridview = new javax.swing.JTable();
		//边框
		this.gridview.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		this.gridview.setGridColor(Color.LIGHT_GRAY);
		this.gridview.setEnabled(false);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setPreferredSize(new Dimension(500, 500));

		this.gridview.setRowHeight(30);
		this.scrollPane.setViewportView(gridview);

		tableModel = new DefaultTableModel(rowvalues, getColumnNames());
		tableModel.setDataVector(rowvalues, getColumnNames());
		gridview.setModel(tableModel);

		// 显示表格线 水平线
		gridview.setShowHorizontalLines(true);

		// 垂直线
		gridview.setShowVerticalLines(true);

		this.add(scrollPane);
	}

	public void SetData(Object[][] rowvalues) { 
			tableModel.setDataVector(rowvalues, getColumnNames());
	}

	public void AddRow(Object data) {
		try {
			Object[] values = getValues(data);
			this.tableModel.addRow(values);
			datas.add(values);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public void AddRow(Object[] values) {
		try {
			this.tableModel.addRow(values);
			datas.add(values);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	private Object[] getColumnNames() {
		Object[] names = new Object[columns.size()];
		for (int i = 0; i < columns.size(); i++) {
			Column column = columns.get(i);
			names[i] = column.caption;
		}
		return names;
	}

	private Object[][] getValues() {
		Object[][] values = new Object[datas.size()][];
		for (int i = 0; i < datas.size(); i++) {
			Object data = datas.get(i);

			try {
				Object[] value = getValues(data);
				values[i] = value;
			} catch (Exception e) {
				throw new RuntimeException(e);
			}

		}

		return values;

	}

	private Object[] getValues(Object data) throws Exception {
		Object[] values = new Object[columns.size()];
		if (data == null) {
			return values;
		}
		Class<?> clazz = data.getClass();
		Field[] fields = clazz.getDeclaredFields();
		HashMap<String, Field> map = new HashMap<String, Field>();
		for (Field field : fields) {
			map.put(field.getName(), field);
		}
		for (int i = 0; i < columns.size(); i++) {
			Column column = columns.get(i);
			if (StringUtils.isEmpty(column.fieldName)) {
				continue;
			}
			Field field = map.get(column.fieldName);
			if (field == null) {
				continue;
			}
			PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), clazz);
			Method method = propertyDescriptor.getReadMethod();
			values[i] = method.invoke(data);
		}

		return values;
	}

	public static class Column {

		private String caption;

		private String fieldName;

		public Column(String caption, String fieldName) {
			this.caption = caption;
			this.fieldName = fieldName;
		}
	}

}
