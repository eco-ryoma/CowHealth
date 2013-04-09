/**
 * 
 */
package com.haozileung.scau.server.common.dto;

import java.util.HashMap;
import java.util.Map;

/**
 * @author haozi
 * 
 */
public class TempMap {

	private long updateTime = 0;

	private Map<String, Object> map = new HashMap<String, Object>();

	public long getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(long updateTime) {
		this.updateTime = updateTime;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

}
