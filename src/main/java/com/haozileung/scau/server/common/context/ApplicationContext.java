package com.haozileung.scau.server.common.context;

import java.util.Set;

/**
 * 接口或类的说明: 应用程序上下文
 */
public interface ApplicationContext {
	
	/**
	 * 将contextKey对应的值放到应用上下文中
	 * @param contextKey
	 * @param keyValue
	 */
	public void put(String contextKey, Object keyValue);
	/**
	 * 将contextKey对应的值放到应用上下文中，其有效时间为TTL，单位为秒
	 * @param contextKey
	 * @param keyValue
	 * @param TTL
	 */
	public void put(String contextKey, Object keyValue, int TTL);
	/**
	 * 从应用上下文中获取contextKey对应的值
	 * @param contextKey
	 * @return
	 */
	public Object get(String contextKey);
	/**
	 * 从应用上下文中移除contextKey
	 * @param contextKey
	 */
	public Object remove(String contextKey);

	/**
	 * 返回上下文中所有Key的SET集合
	 * @return
	 */
	public Set<String> keySet();
	
}
