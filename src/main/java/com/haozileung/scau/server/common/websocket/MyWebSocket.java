package com.haozileung.scau.server.common.websocket;

import org.eclipse.jetty.websocket.WebSocket.OnTextMessage;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.haozileung.scau.server.common.listener.WebApplicationInitListener;

public class MyWebSocket implements OnTextMessage {

	private final static Logger logger = LoggerFactory
			.getLogger(MyWebSocket.class);

	private Connection conn;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jetty.websocket.WebSocket#onClose(int, java.lang.String)
	 * 一个客户端断开时,从List中移除
	 */
	@Override
	public void onClose(int arg0, String arg1) {
		WebApplicationInitListener.getSocketList().remove(this);
		if (logger.isDebugEnabled()) {
			logger.debug("disconnected..." + conn.getMaxIdleTime());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jetty.websocket.WebSocket#onOpen(org.eclipse.jetty.websocket
	 * .WebSocket.Connection) 一个客户端连上来时,将它加入List
	 */
	@Override
	public void onOpen(Connection conn) {
		// 如果客户端在这个MaxIdleTime中都没有活动,则它会自动结束
		this.conn = conn;
		WebApplicationInitListener.getSocketList().add(this);
		if (logger.isDebugEnabled()) {
			logger.debug("new WebSocket connected..." + conn.getMaxIdleTime());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jetty.websocket.WebSocket.OnTextMessage#onMessage(java.lang
	 * .String) 一个客户端发送数据后,触发它自己的onMessage方法,在这个方法里给所有在线的客户端发送这条消息
	 */
	@Override
	public void onMessage(String data) {
		JSONObject jo = null;
		try {
			jo = new JSONObject(data);
		} catch (JSONException e) {
			logger.error("无法解析的心跳包！" + e.getMessage());
		}
		if (jo != null && jo.isNull("online")) {
			WebApplicationInitListener.getSocketList().remove(this);
		}
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

}
