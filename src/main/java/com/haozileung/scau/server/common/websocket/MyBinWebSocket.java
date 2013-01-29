/**
 * 
 * <b>项目名：</b>CowHealth<br />
 * <b>包名：</b>com.haozileung.scau.server.common.websocket<br />
 * <b>文件名：</b>MyBinWebSocket.java<br />
 * <b>文件描述：</b>2进制传输<br />
 * <b>创建人：</b>lianghaopeng<br />
 * <b>修改人：</b>lianghaopeng<br />
 * <b>修改时间：</b>2013-1-6 下午1:48:21<br />
 * <b>修改备注：</b><br />
 * 
 * @version 1.0.0
 * 
 */
package com.haozileung.scau.server.common.websocket;

import org.eclipse.jetty.websocket.WebSocket.OnBinaryMessage;

/**
 * 
 * <b>类名称：</b>MyBinWebSocket<br/>
 * <b>类描述：</b>2进制传输<br/>
 * <b>创建人：</b>lianghaopeng<br/>
 * <b>修改人：</b>lianghaopeng<br/>
 * <b>修改时间：</b>2013-1-6 下午1:48:21<br/>
 * <b>修改备注：</b><br/>
 * 
 * @version 1.0.0
 * 
 */
public class MyBinWebSocket implements OnBinaryMessage {

	/* (non-Javadoc)
	 * @see org.eclipse.jetty.websocket.WebSocket#onClose(int, java.lang.String)
	 */
	@Override
	public void onClose(int code, String arg1) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.eclipse.jetty.websocket.WebSocket#onOpen(org.eclipse.jetty.websocket.WebSocket.Connection)
	 */
	@Override
	public void onOpen(Connection conn) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.eclipse.jetty.websocket.WebSocket.OnBinaryMessage#onMessage(byte[], int, int)
	 */
	@Override
	public void onMessage(byte[] data, int offset, int length) {
		// TODO Auto-generated method stub

	}

}
