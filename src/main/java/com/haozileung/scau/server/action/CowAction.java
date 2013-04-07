/**
 * 
 * <b>项目名：</b>CowHealth<br />
 * <b>包名：</b>com.haozileung.scau.server.action<br />
 * <b>文件名：</b>CowAction.java<br />
 * <b>文件描述：</b>TODO<br />
 * <b>创建人：</b>lianghaopeng<br />
 * <b>修改人：</b>lianghaopeng<br />
 * <b>修改时间：</b>2013-1-30 下午2:09:37<br />
 * <b>修改备注：</b><br />
 * 
 * @version 1.0.0
 * 
 */
package com.haozileung.scau.server.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import com.haozileung.scau.server.common.action.BaseAction;
import com.haozileung.scau.server.common.dto.RestDataSourceResponse;
import com.haozileung.scau.server.dto.CowInfo;
import com.haozileung.scau.server.service.ICowService;

/**
 * 
 * <b>类名称：</b>CowAction<br/>
 * <b>类描述：</b>TODO<br/>
 * <b>创建人：</b>lianghaopeng<br/>
 * <b>修改人：</b>lianghaopeng<br/>
 * <b>修改时间：</b>2013-1-30 下午2:09:37<br/>
 * <b>修改备注：</b><br/>
 * 
 * @version 1.0.0
 * 
 */

@Namespace("/cow")
public class CowAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8059333964126602031L;

	@Autowired
	private ICowService cowService;

	private String cowId;

	private String name;

	private int age;

	private String sex;

	private RestDataSourceResponse<CowInfo> response = new RestDataSourceResponse<CowInfo>();

	@Action(value = "getCow")
	public String getCowInfoList() {
		response.setData(cowService.getAllCow());
		response.setStartRow(0);
		response.setEndRow(cowService.getAllCow() == null ? 0 : cowService
				.getAllCow().size());
		response.setTotalRow(cowService.getAllCow() == null ? 0 : cowService
				.getAllCow().size());
		if (cowService.getAllCow() == null) {
			response.setStatus(-1);
		} else {
			response.setStatus(0);
		}
		return SUCCESS;
	}

	@Action(value = "addCow")
	public String addCowInfo() {
		CowInfo cowInfo = new CowInfo();
		cowInfo.setAge(age);
		cowInfo.setName(name);
		cowInfo.setSex(sex);
		boolean flag = cowService.saveCow(cowInfo);
		if (flag) {
			response.setStartRow(0);
		} else {
			response.setStartRow(1);
		}
		return SUCCESS;
	}

	@Action(value = "updateCow")
	public String updateCowInfo() {
		CowInfo cowInfo = new CowInfo();
		cowInfo.setAge(age);
		cowInfo.setCowId(cowId);
		cowInfo.setName(name);
		cowInfo.setSex(sex);
		boolean flag = cowService.saveCow(cowInfo);
		if (flag) {
			response.setStartRow(0);
		} else {
			response.setStartRow(-1);
		}
		return SUCCESS;
	}

	@Action(value = "deleteCow")
	public String deleteCowInfo() {
		if (cowId != null && cowService.deleteCowById(new ObjectId(cowId))) {
			response.setStatus(0);
		} else {
			response.setStatus(-1);
		}
		return SUCCESS;
	}

	@Action(value = "refreshCowList")
	public String getCurrentCowList() {
		return SUCCESS;
	}

	public String getCowId() {
		return cowId;
	}

	public void setCowId(String cowId) {
		this.cowId = cowId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public RestDataSourceResponse<CowInfo> getResponse() {
		return response;
	}

	public void setResponse(RestDataSourceResponse<CowInfo> response) {
		this.response = response;
	}

}
