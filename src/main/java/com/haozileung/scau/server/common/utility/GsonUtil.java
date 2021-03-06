package com.haozileung.scau.server.common.utility;

import java.lang.reflect.Type;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * gson工具类
 */
public class GsonUtil {
	public static final String SHORT = "yyyy-MM-dd";
	public static final String MEDIUM = "yyyy-MM-dd HH:mm";
	public static final String LONG = "yyyy-MM-dd HH:mm:ss";

	/**
	 * （bean中没有Date类型属性）javabean转换成json
	 * 
	 * @param bean
	 *            要转换成json的对象
	 * @param isHandleAllFields
	 *            是否需要处理全部的属性，若是，则不需要传入该参数；若不是，则该参数传入false，且对需要处理的属性添加Expose注解
	 * @return
	 */
	public static String bean2json(Object bean, boolean... isHandleAllFields) {
		return getGson(isHandleAllFields).toJson(bean);
	}

	/**
	 * （bean中有Date类型属性）javabean转换成json
	 * 
	 * @param bean
	 *            要转换成json的对象
	 * @param pattern
	 *            按此格式转换日期，要传入与GsonUtil的SHORT、MEDIUM、LONG相同的参数
	 * @param isHandleAllFields
	 *            是否需要处理全部的属性，若是，则不需要传入该参数；若不是，则该参数传入false，且对需要处理的属性添加Expose注解
	 * @return
	 */
	public static String bean2jsonWithTimestamp(Object bean, String pattern,
			boolean... isHandleAllFields) {
		if (!isPatternMatchRule(pattern)) {
			return null;
		}
		return getGson(isHandleAllFields, pattern).toJson(bean);
	}

	/**
	 * （bean中没有Date类型属性）json转换成javabean，只要type参数传入对象的class即可（较方便），或传入new
	 * TypeToken< <code>className
	 * </code>>() {}.getType()；<br/>
	 * 也可用于转换成某javabean的list，只要type参数传入new TypeToken<
	 * <code>List<<code>className</code>> </code>>() {}.getType()即可
	 * 
	 * @param json
	 *            源json字符串，为null或空字符串时范围javabean对象或size=0的list对象
	 * @param type
	 *            要转换的目标对象类型
	 * @param isHandleAllFields
	 *            是否需要处理全部的属性，若是，则不需要传入该参数；若不是，则该参数传入false，且对需要处理的属性添加Expose注解
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T json2bean(String json, Type type,
			boolean... isHandleAllFields) {
		return (T) (getGson(isHandleAllFields).fromJson(
				getTrueJson(json, type), type));
	}

	/**
	 * （bean中有Date类型属性）json转换成javabean，只要type参数传入对象的class即可（较方便），或传入new
	 * TypeToken< <code>className
	 * </code>>() {}.getType()；<br/>
	 * 也可用于转换成某javabean的list，只要type参数传入new TypeToken<
	 * <code>List<<code>className</code>> </code>>() {}.getType()即可
	 * 
	 * @param json
	 *            源json字符串，为null或空字符串时范围javabean对象或size=0的list对象
	 * @param type
	 *            要转换的目标对象类型
	 * @param pattern
	 *            按此格式转换日期，要传入与GsonUtil的SHORT、MEDIUM、LONG相同的参数
	 * @param isHandleAllFields
	 *            是否需要处理全部的属性，若是，则不需要传入该参数；若不是，则该参数传入false，且对需要处理的属性添加Expose注解
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T json2beanWithTimestamp(String json, Type type,
			String pattern, boolean... isHandleAllFields) {
		if (!isPatternMatchRule(pattern)) {
			return null;
		}
		return (T) (getGson(isHandleAllFields, pattern).fromJson(
				getTrueJson(json, type), type));
	}

	/**
	 * 获取gson构造器
	 * 
	 * @param isHandleAllFields
	 *            是否处理全部的属性
	 * @param pattern
	 * @return
	 */
	private static Gson getGson(boolean[] isHandleAllFields, String... pattern) {
		GsonBuilder gsonBuilder = new GsonBuilder();
		if (null != isHandleAllFields && isHandleAllFields.length > 0
				&& !isHandleAllFields[0]) {
			// 如果参数传入为false，则表示有的属性不需要处理，只处理带有Expose注解的属性
			gsonBuilder = gsonBuilder.excludeFieldsWithoutExposeAnnotation();
		}
		if (null != pattern && pattern.length > 0) {
			// 添加日期类型属性的处理
			gsonBuilder = gsonBuilder.registerTypeAdapter(Date.class,
					new DateAdapter(pattern[0])).setDateFormat(pattern[0]);
		}
		return gsonBuilder.create();
	}

	/**
	 * 判断要转换的日期格式是否符合规范
	 * 
	 * @param pattern
	 * @return
	 */
	private static boolean isPatternMatchRule(String pattern) {
		try {
			if (null != pattern
					&& (pattern.equals(SHORT) || pattern.equals(MEDIUM) || pattern
							.equals(LONG))) {
				return true;
			} else {
				throw new Exception("要转换的日期格式不规范，返回null值");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 获取真正有用的json字符串
	 * 
	 * @param json
	 * @return
	 */
	private static String getTrueJson(String json, Type type) {
		if (null == json || "".equals(json)) {
			// 如果json为空则赋值为"{}"或"[]"，保证了json转换成对象的时候不返回null
			String typeStr = type.toString();
			if (typeStr.contains("List") || typeStr.contains("Map")
					|| typeStr.contains("Set")) {
				// 如果是这种情况，则表示要转换成list对象
				json = "[]";
			} else {
				// 否则表示要转换成单独的一个javabean
				json = "{}";
			}
		}
		return json;
	}
}