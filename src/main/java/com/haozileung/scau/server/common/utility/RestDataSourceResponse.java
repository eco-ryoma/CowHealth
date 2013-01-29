package com.haozileung.scau.server.common.utility;

import java.util.List;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

import com.haozileung.scau.server.common.dto.IDataTransferObject;

public class RestDataSourceResponse<O extends IDataTransferObject> {
	
	private int status;
	private int startRow;
	private int endRow;
	private long totalRow;
	private List<O> data;
	private Map<String, Object> errors;
	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	/**
	 * @return the startRow
	 */
	public int getStartRow() {
		return startRow;
	}
	/**
	 * @param startRow the startRow to set
	 */
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	/**
	 * @return the endRow
	 */
	public int getEndRow() {
		return endRow;
	}
	/**
	 * @param endRow the endRow to set
	 */
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	/**
	 * @return the totalRow
	 */
	public long getTotalRow() {
		return totalRow;
	}
	/**
	 * @param totalRow the totalRow to set
	 */
	public void setTotalRow(long totalRow) {
		this.totalRow = totalRow;
	}
	/**
	 * @return the data
	 */
	@JSON(serialize=true) 
	public List<O> getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(List<O> data) {
		this.data = data;
	}
	/**
	 * @return the errors
	 */
	@JSON(serialize=true) 
	public Map<String, Object> getErrors() {
		return errors;
	}
	/**
	 * @param errors the errors to set
	 */
	public void setErrors(Map<String, Object> errors) {
		this.errors = errors;
	}
}
