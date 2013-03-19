/**
 * 
 * <b>项目名：</b>CowHealth<br />
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
@Results({ @Result(name = "success", location = "/index.jsp"),
		@Result(name = "error", location = "/error.html") })
@ExceptionMappings({ @ExceptionMapping(exception = "java.lange.RuntimeException", result = "error") })
public class EquipmentAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2749244337613640317L;
	
	@Autowired
	private IEquipmentService equimentService;

	public IEquipmentService getEquimentService() {
		return equimentService;
	}

	public void setEquimentService(IEquipmentService equimentService) {
		this.equimentService = equimentService;
	}

}
