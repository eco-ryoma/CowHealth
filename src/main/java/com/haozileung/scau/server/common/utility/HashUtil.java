/**
 * 
 */
package com.haozileung.scau.server.common.utility;

import java.util.Date;

/**
 * 加密解密工具
 */
public class HashUtil {
	public static String doHash(String str, String salt){
		if (null == salt){
			salt = MD5.getMD5ofStr(MD5.getMD5ofStr(String.valueOf((new Date()).getTime()))).substring(0,20);
		} else {
			salt = salt.substring(0,20);
		}
		
		return salt + SHA1.getDigestOfString((salt + str).getBytes());
	}
	
	public static String doHash(String str){
		return doHash(str,null);
	}
	
	public static boolean hashValidate(String source, String target){
		return doHash(source, target).equals(target);
	}
}
