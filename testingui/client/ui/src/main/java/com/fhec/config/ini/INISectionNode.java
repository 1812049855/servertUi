package com.fhec.config.ini;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * INI配置文件下节点；支持基本类型，数组；不支持集合 map
 * 
 * @author wjianhua
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface INISectionNode {

	/***
	 * ini节点名称，不填写默认取当前变量名称
	 * 
	 * @return
	 */
	public String name() default "";

	/**
	 * 分隔符，一般情况下不需要进行调整，ExpressionEngine 默认为 DefaultExpressionEngine，非默认值需要考虑是否进行调整
	 * 
	 * @return
	 */
	public String delimiter() default ".";

	/**
	 * 分隔符转义字符，一般情况下不需要进行调整，ExpressionEngine 默认为
	 * DefaultExpressionEngine，非默认值需要考虑是否进行调整
	 * 
	 * @return
	 */
	public String escape() default ".";

	/**
	 * 是否必填
	 * 
	 * @return
	 */
	public boolean isRequired() default true;

	/**
	 * 多值下，指定值数量
	 * 
	 * @return
	 */
	public int arrayCount() default 0;
}
