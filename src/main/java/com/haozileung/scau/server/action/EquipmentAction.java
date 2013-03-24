/**
 * 
 * <b>项目名：</b>EquipmentHealth<br />
 * <b>包名：</b>com.haozileung.scau.server.action<br />
 * <b>文件名：</b>EquipmentAction.java<br />
 * <b>文件描述：</b>TODO<br />
 * <b>创建人：</b>lianghaopeng<br />
 * <b>修改人：</b>lianghaopeng<br />
 * <b>修改时间：</b>2013-1-30 下午2:10:46<br />
 * <b>修改备注：</b><br />
 * 
 * @version 1.0.0
 * 
 */
package com.haozileung.scau.server.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.ExceptionMappings;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.haozileung.scau.server.common.action.BaseAction;
import com.haozileung.scau.server.service.IEquipmentService;

/**
 * 
 * <b>类名称：</b>EquipmentAction<br/>
 * <b>类描述：</b>TODO<br/>
 * <b>创建人：</b>lianghaopeng<br/>
 * <b>修改人：</b>lianghaopeng<br/>
 * <b>修改时间：</b>2013-1-30 下午2:10:46<br/>
 * <b>修改备注：</b><br/>
 * 
 * @version 1.0.0
 * 
 */
@ParentPackage("json-default")
@Namespace("/equipment")
@Results({ @Result(name = "success", location = "/index.html"),
		@Result(name = "error", location = "/error.html") })
@ExceptionMappings({ @ExceptionMapping(exception = "java.lange.RuntimeException", result = "error") })
public class EquipmentAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2749244337613640317L;
	
	@Autowired
	private IEquipmentService equimentService;
	@Action(value = "getEquipment", results = { @Result(name = SUCCESS, type = "json", params = {
			"includeProperties",
			"response\\.\\w+,response\\.data\\[\\d+\\]\\.\\w+",
			"ignoreHierarchy", "false", "excludeNullProperties", "true" }) })
	public String getEquipmentInfoList() {
		return null;
	}
	@Action(value = "addEquipment", results = { @Result(name = SUCCESS, type = "json", params = {
			"includeProperties",
			"response\\.\\w+,response\\.data\\[\\d+\\]\\.\\w+",
			"ignoreHierarchy", "false", "excludeNullProperties", "true" }) })
	public String addEquipmentInfo() {
		return null;
	}
	@Action(value = "updateEquipment", results = { @Result(name = SUCCESS, type = "json", params = {
			"includeProperties",
			"response\\.\\w+,response\\.data\\[\\d+\\]\\.\\w+",
			"ignoreHierarchy", "false", "excludeNullProperties", "true" }) })
	public String updateEquipmentInfo(){
		return null;
	}
	@Action(value = "deleteEquipment", results = { @Result(name = SUCCESS, type = "json", params = {
			"includeProperties",
			"response\\.\\w+,response\\.data\\[\\d+\\]\\.\\w+",
			"ignoreHierarchy", "false", "excludeNullProperties", "true" }) })
	public String deleteEquipmentInfo(){
		return null;
	}

}
