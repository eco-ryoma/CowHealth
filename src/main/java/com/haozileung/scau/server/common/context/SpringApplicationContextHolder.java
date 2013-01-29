package com.haozileung.scau.server.common.context;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;

/**
 * Spring中的ApplicationContext的保持器
 */
public class SpringApplicationContextHolder {
	private static ApplicationContext ctx;
	
	/**
	 * 初始化应用上下文持有器
	 * @param ctx
	 */
	public static void init(ApplicationContext ctx) {
		SpringApplicationContextHolder.ctx = ctx;
	}
	
	/**
	 * 获取指定名称的Bean对象
	 * @param beanName
	 * @return
	 */
	public static Object getBean(String beanName) {
		Object bean = ctx.getBean(beanName);
		return bean;
	}
	
	/**
	 * 根据指定名称和类型来获取Bean对象
	 * @param <T>
	 * @param beanName
	 * @param requiredType
	 * @return
	 */
	public static <T>T getBean(String beanName, Class<T> requiredType){
		T bean = (T)ctx.getBean(beanName, requiredType);
		return bean;
	}
	
	/**
	 * 根据类型获取此类型的Bean的集合
	 * @param type
	 * @return
	 */
	public static Map<String, ?> getBeansOfType(Class<?> type){
		Map<String, ?> beans = ctx.getBeansOfType(type);
		if(beans==null)
			return new HashMap<String, Object>();
		return beans;
	}
	
	/**
	 * 销毁应用上下文持有器
	 */
	public static void destroy() {
		ctx=null;
	}
}
