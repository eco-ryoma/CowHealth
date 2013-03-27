package com.haozileung.scau.server.common.websocket;

import java.io.IOException;
import java.util.List;

import org.eclipse.jetty.websocket.WebSocket.OnTextMessage;

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
		// 如果客户端在MaxIdleTime中都没有活动,则它会自动结束
		this.conn = conn;
		this.conn.setMaxIdleTime(999999999);
		WebApplicationInitListener.getSocketList().add(this);
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
		List<MyWebSocket> socketList = WebApplicationInitListener
				.getSocketList();
		for (MyWebSocket socket : socketList) {
			try {
				socket.getConn().sendMessage(data);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

}
