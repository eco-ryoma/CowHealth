/**
 * 
 * <b>项目名：</b>CowHealth<br />
 * <b>包名：</b>com.haozileung.scau.server.action<br />
 * <b>文件名：</b>SportDataAction.java<br />
 * <b>文件描述：</b>TODO<br />
 * <b>创建人：</b>lianghaopeng<br />
 * <b>修改人：</b>lianghaopeng<br />
 * <b>修改时间：</b>2013-1-30 下午2:11:56<br />
 * <b>修改备注：</b><br />
 * 
 * @version 1.0.0
 * 
 */
package com.haozileung.scau.server.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.haozileung.scau.server.common.action.BaseAction;
import com.haozileung.scau.server.common.context.SpringApplicationContextHolder;
import com.haozileung.scau.server.common.dto.RestDataSourceResponse;
import com.haozileung.scau.server.common.dto.TempMap;
import com.haozileung.scau.server.dto.EquipmentInfo;
import com.haozileung.scau.server.dto.SportDataInfo;
import com.haozileung.scau.server.service.IEquipmentService;
import com.haozileung.scau.server.service.ISportDataService;
import com.haozileung.scau.shared.SharedConfig;

/**
 * 
 * <b>类名称：</b>SportDataAction<br/>
 * <b>类描述：</b>TODO<br/>
 * <b>创建人：</b>lianghaopeng<br/>
 * <b>修改人：</b>lianghaopeng<br/>
 * <b>修改时间：</b>2013-1-30 下午2:11:56<br/>
 * <b>修改备注：</b><br/>
 * 
 * @version 1.0.0
 * 
 */
@Namespace("/data")
public class SportDataAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7258562747191660019L;

	private RestDataSourceResponse<SportDataInfo> response = new RestDataSourceResponse<SportDataInfo>();

	@Autowired
	private ISportDataService sportDataService;

	@Autowired
	private IEquipmentService equipmentService;

	private String cowId;

	private String dateCount;

	private String updateTimeStr;

	public String getCowId() {
		return cowId;
	}

	public void setCowId(String cowId) {
		this.cowId = cowId;
	}

	public String getDateCount() {
		return dateCount;
	}

	public void setDateCount(String dateCount) {
		this.dateCount = dateCount;
	}

	@Action(value = "getSportData")
	public String getSportDataInfoList() {
		boolean flag = true;
		int hearttime = 100;// 当不发送消息的时候，保持50秒一次长轮询
		int heartbeat = 0;
		if (cowId != null) {
			response.setData(new ArrayList<SportDataInfo>());
			EquipmentInfo equipmentInfo = equipmentService
					.getEquipmentByCowId(cowId);
			List<SportDataInfo> sportDatas = null;
			sportDatas = sportDataService.getSportDataByEquipmentId(
					equipmentInfo.getEquipmentId(), new Date(),
					Integer.parseInt(dateCount));
			if (sportDatas != null) {
				response.getData().addAll(sportDatas);
			}
			return SUCCESS;
		}
		while (flag) {
			heartbeat++;
			TempMap tmpMap = (TempMap) SpringApplicationContextHolder
					.getBean("tmpMap");
			long updateTime = updateTimeStr != null && !updateTimeStr.isEmpty() ? Long
					.valueOf(updateTimeStr) : 0L;
			if (tmpMap != null && updateTime < tmpMap.getUpdateTime()) {
				response.setData(new ArrayList<SportDataInfo>());
				for (String equipmentId : tmpMap.getMap().keySet()) {
					List<SportDataInfo> sportDatas = sportDataService
							.getSportDataByEquipmentId(equipmentId, new Date(),
									SharedConfig.defaultDateCount);
					if (sportDatas != null) {
						response.getData().addAll(sportDatas);
					}
				}
				response.setUpdateTime(tmpMap.getUpdateTime());
				flag = false;
				return SUCCESS;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (heartbeat == hearttime) {
				flag = false;
			}
		}
		return SUCCESS;
	}

	public RestDataSourceResponse<SportDataInfo> getResponse() {
		return response;
	}

	public void setResponse(RestDataSourceResponse<SportDataInfo> response) {
		this.response = response;
	}

	public String getUpdateTimeStr() {
		return updateTimeStr;
	}

	public void setUpdateTimeStr(String updateTimeStr) {
		this.updateTimeStr = updateTimeStr;
	}
}
