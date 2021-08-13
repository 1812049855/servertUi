package com.fhec.config.ini;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ini配置文件段
 * 
 * @author wjianhua
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface INISection {

	/**
	 * 段名称
	 * 
	 * @return
	 */
	public String name();

	/**
	 * 是否一定需要
	 * 
	 * @return
	 */
	public boolean isRequired() default true;
}
