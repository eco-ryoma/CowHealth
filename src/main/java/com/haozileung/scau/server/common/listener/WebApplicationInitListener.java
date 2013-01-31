package com.haozileung.scau.server.common.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.haozileung.scau.server.common.websocket.MyWebSocket;

/**
 * 
 * <b>类名称：</b>WebApplicationInitListener<br/>
 * <b>类描述：</b><br/>
 * <b>创建人：</b>lianghaopeng<br/>
 * <b>修改人：</b>lianghaopeng<br/>
 * <b>修改时间：</b>2012-12-7 下午2:08:00<br/>
 * <b>修改备注：</b><br/>
 * 
 * @version 1.0.0<br/>
 * 
 */
public class WebApplicationInitListener implements ServletContextListener {

	// private PassportService passportService;

	private static List<MyWebSocket> socketList;

	public static synchronized List<MyWebSocket> getSocketList() {
		return WebApplicationInitListener.socketList;
	}

	public void contextInitialized(ServletContextEvent sce) {
		// ServletContext sc = sce.getServletContext();
		// ApplicationContext beans = WebApplicationContextUtils
		// .getRequiredWebApplicationContext(sc);
		// passportService = (PassportService) beans.getBean("passportService");
		// if (passportService.findPassportByUserName("admin") == null) {
		// PassportInfo p = new PassportInfo();
		// p.setUserName("admin");
		// p.setPassword(HashUtil.doHash("123456"));
		// p.setEmail("haozileung.cn@gmail.com");
		// passportService.addPassport(p);
		// }
		WebApplicationInitListener.socketList = new ArrayList<MyWebSocket>();
	}

	public void contextDestroyed(ServletContextEvent sce) {
		// PassportInfo p = passportService.findPassportByUserName("admin");
		// if (null != p){
		// passportService.deletePassport(p.getPassportId());
		// }
	}
}
