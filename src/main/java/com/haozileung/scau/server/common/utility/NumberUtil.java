/**
 * 
 */
package com.haozileung.scau.server.common.utility;

import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * 数字格式化处理工具
 */
public class NumberUtil {
	
	/**
	 * 转换成价格的格式 ( 如: 99.00 ) 
	 * @return
	 */
	public static String convert2price(BigDecimal bigDecimal){
		if(bigDecimal==null) return null;
		NumberFormat formater = NumberFormat.getInstance();
		formater.setMaximumFractionDigits(2);
		formater.setMinimumFractionDigits(2);
		return formater.format(bigDecimal);
	}
	
	/**
	 * 判断一个字符串是否是数字
	 * @param numStr
	 * @return
	 */
	public static boolean isNum(String numStr){
		if(numStr==null)
			return false;
		try{
			Double.valueOf(numStr);
		}catch(Throwable nfe){
			return false;
		}
		return true;
	}	
}
