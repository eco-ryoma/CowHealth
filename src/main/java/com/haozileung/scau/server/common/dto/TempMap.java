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
	
	private boolean status = false;
	
	private Map<String, Object> map = new HashMap<String, Object>();

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

}
