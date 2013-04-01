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

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

import com.haozileung.scau.server.common.action.BaseAction;

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

	// @Autowired
	// private ISportDataService sportDataService;

	@Action(value="getSportDataList")
	public String getSportDataInfoList() {
		boolean flag = true;
		int hearttime = 100;// 当不发送消息的时候，保持50秒一次长轮询
		int heartbeat = 0;
		while (flag) {
			heartbeat++;
			//TODO 添加后台代码
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
}
