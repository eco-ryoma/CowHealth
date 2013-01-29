/**
 * 
 */
package com.haozileung.scau.server.common.utility;

import java.util.UUID;
import java.util.regex.Pattern;

/**
 * 字符串的工具类
 */
public class StringUtil {
	
	/**
	 * 该方法是trim一个字符串，返回trim后的字符串
	 * @param s String
	 * @return 如果传入一个null，则返回一个null，如果是字符串，则返回trim后的字符串
	 */
	public static String trim(String s) {
		return s==null?null:s.trim();
	}
	
	public static boolean isEmpty(String s) {
		if(s == null || s.trim().length() == 0)
		    return true;
		else return false;
	}
	
	/**
	 * 把指定的整形数据转换成指定长度的序列号，前面补0
	 * @param number
	 * @param length
	 * @return
	 */
	public static String generateSequenceNumber(int number,int length){
		return generateSequenceNumber((long)number, length);
	}
	
	/**
	 * 把指定的整形数据转换成指定长度的序列号，前面补0
	 * @param number
	 * @param length
	 * @return
	 */
	public static String generateSequenceNumber(long number,int length){
		String num = String.valueOf(number);
		if(num.length()>length)
			throw new IllegalArgumentException("number is longer than length!");
		if(num.length()==length)
			return num;
		int zeroLength = length - num.length();
		StringBuilder zeros = new StringBuilder();
		String zero = "0";
		for(int i=0;i<zeroLength;i++) {
			zeros.append(zero);
		}
		return zeros+num;
	}
	
	/**
	 * 获取36位长度的UUID字符串
	 * @return
	 */
	public static String getUUID36(){
		return UUID.randomUUID().toString();
	}
	/**
	 * 获取32位长度的UUID字符串
	 * @return
	 */
	public static String getUUID32(){
		return getUUID36().replaceAll("-", "");
	}
	
	
	/**
	* 方法用途和描述: 判断字符是否为数字
	* @param c
	* @return
	*/
	public static boolean isNumber(char c){
		return (c > 48 && c < 57);
	}
	
	/**
	* 方法用途和描述: 判断字符是否为字母
	* @param c
	* @return
	*/
	public static boolean isLetter(char c){
		return (c > 65 && c < 90) || (c > 97 && c <122) ;
	}
	
	/**
	 * 替换掉非字母跟数字的字符
	 * @param str 原字符串
	 * @param replaceChar 用来替换的字符
	 * @return
	 */
	public static String replaceSpecialCharacters(String str, String replaceChar){
		if(str==null || "".equals(str.trim()))
			return "";
		StringBuffer sb = new StringBuffer(str.length());
		for(int index=0; index<str.length(); index++){
			char c = str.charAt(index);
			if(isNumber(c) || isLetter(c))
				sb.append(c);
			else
				sb.append(replaceChar);
		}
		return sb.toString();
	}
	
	/**
	 * 把一些html标签转成转义字符（比如把"<"转成"&lt;"）
	 * @param html
	 * @return
	 */
    public static String htmlToWeb(String html) {
        if (html == null || html.length() == 0) return "";
        char[] c = html.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < c.length; i++) {
            switch (c[i]) {
                case'>':
                    sb.append("&gt;");
                    break;
                case'<':
                    sb.append("&lt;");
                    break;
                case'&':
                    sb.append("&amp;");
                    break;
                default:
                    sb.append(c[i]);
            }
        }
        return sb.toString();
    }
    
    
    /**
     * 判断字符串是否为数字
     * @param str
     * @return
     */
    public static boolean isNumber(String str) {
    	
    	Pattern pattern = Pattern.compile("[0-9]*");
    	return pattern.matcher(str).matches();    
    }
	
}
