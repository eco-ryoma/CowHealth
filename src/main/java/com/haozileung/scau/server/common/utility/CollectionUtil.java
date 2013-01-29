/**
 * 
 */
package com.haozileung.scau.server.common.utility;

import java.util.Collection;

/**
 * 类集框架工具
 */
public class CollectionUtil {
	
	/**
	 * 
	 * @param collection
	 * @return 如果传入集合为null或者集合为empty，则返回true
	 */
	public static boolean isEmpty(Collection<?> collection) {
		if(collection==null || collection.isEmpty())
			return true;
		return false;
	}
}
