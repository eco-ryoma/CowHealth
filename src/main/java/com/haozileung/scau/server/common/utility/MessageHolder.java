package com.haozileung.scau.server.common.utility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * 配置文件信息持有器
 */
public class MessageHolder{
	private static Log LOG = LogFactory.getLog(MessageHolder.class);
	
	//读入配置文件资源
	private static ResourceBundleMessageSource messageSource;
	
	public MessageHolder(){
		
	}
	
	public MessageHolder(ResourceBundleMessageSource messageSource){
		init(messageSource);
	}
	
	public ResourceBundleMessageSource getMessageSource() {
		return messageSource;
	}
	
	public void setMessageSource(ResourceBundleMessageSource messageSource) {
		init(messageSource);
	}
	
	private static void init(ResourceBundleMessageSource messageSource){
		MessageHolder.messageSource = messageSource;
	}
	
	/**
	 * 读出配置文件megKey对应的值
	 * @param megKey
	 * @return
	 */
	public static String getMessage(String megKey){
		return getMessage(megKey, null);
	}
	
	/**
	 * 读取消息，将args中的内容替换掉消息中的占位符
	 * @param megKey
	 * @param args
	 * @return
	 */
	public static String getMessage(String megKey, Object[] args){
		if(megKey==null) return null;
		if(messageSource==null){
			LOG.error("MessageHolder未正确实例化！");
			return null;
		}
		return messageSource.getMessage(megKey, args, null);
	}

}
