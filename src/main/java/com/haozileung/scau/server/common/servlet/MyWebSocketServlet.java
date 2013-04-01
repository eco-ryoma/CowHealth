package com.haozileung.scau.server.common.servlet;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.jetty.websocket.WebSocket;
import org.eclipse.jetty.websocket.WebSocketServlet;

import com.haozileung.scau.server.common.websocket.MyWebSocket;

public class MyWebSocketServlet extends WebSocketServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1887606649574107279L;

	@Override
	public WebSocket doWebSocketConnect(HttpServletRequest request, String protocol) {
		return new MyWebSocket();
	}

}
