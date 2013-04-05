package com.haozileung.scau.server.common.websocket;

import org.eclipse.jetty.websocket.WebSocket.OnTextMessage;

import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.haozileung.scau.server.common.listener.WebApplicationInitListener;

public class MyWebSocket implements OnTextMessage {

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
		System.out.println("disconnected...");
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
		System.out.println("new WebSocket...");
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
		JSONValue jv = JSONParser.parseStrict(data).isObject().get("online");
		if (jv != null && jv.isNumber().doubleValue() != 1.0) {
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
