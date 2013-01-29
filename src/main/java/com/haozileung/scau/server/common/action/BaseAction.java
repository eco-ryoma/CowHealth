package com.haozileung.scau.server.common.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * <b>类名称：</b>BaseAction<br/>
 * <b>类描述：</b>Action的基类<br/>
 * <b>创建人：</b>lianghaopeng<br/>
 * <b>修改人：</b>lianghaopeng<br/>
 * <b>修改时间：</b>2012-12-7 下午2:04:07<br/>
 * <b>修改备注：</b><br/>
 * 
 * @version 1.0.0<br/>
 * 
 */
public class BaseAction extends ActionSupport implements SessionAware,
		ServletRequestAware {
	private static final long serialVersionUID = 1L;
	protected Map<String, Object> session;
	protected HttpServletRequest request;
	protected int _startRow;
	protected int _endRow;
	protected String _sortBy;

	protected Log logger = LogFactory.getLog(getClass().getName());

	public String exit() {
		session.clear();
		return "exit";
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 * @return the _startRow
	 */
	public int get_startRow() {
		return _startRow;
	}

	/**
	 * @param _startRow
	 *            the _startRow to set
	 */
	public void set_startRow(int _startRow) {
		this._startRow = _startRow;
	}

	/**
	 * @return the _endRow
	 */
	public int get_endRow() {
		return _endRow;
	}

	/**
	 * @param _endRow
	 *            the _endRow to set
	 */
	public void set_endRow(int _endRow) {
		this._endRow = _endRow;
	}

	/**
	 * @return the _sortBy
	 */
	public String get_sortBy() {
		return _sortBy;
	}

	/**
	 * @param _sortBy
	 *            the _sortBy to set
	 */
	public void set_sortBy(String _sortBy) {
		this._sortBy = _sortBy;
	}
}
