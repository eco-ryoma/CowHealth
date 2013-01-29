package com.haozileung.scau.server.common.context;

import java.util.HashMap;
import java.util.Map;

/**
 * 应用程序配置参数上下文
 * 
 * @author haozi
 * @date 2012.12.15
 */
public class ApplicationConfigurationContext {

	private Map<String, String> configArgs = new HashMap<String, String>();

	public Map<String, String> getConfigArgs() {
		return configArgs;
	}

	public void setConfigArgs(Map<String, String> configArgs) {
		this.configArgs = configArgs;
	}

	public String getConfigurationValue(String key) {
		return configArgs.get(key);
	}

}
