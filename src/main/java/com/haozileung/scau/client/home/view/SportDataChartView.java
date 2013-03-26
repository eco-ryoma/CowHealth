package com.haozileung.scau.client.home.view;

import org.moxieapps.gwt.highcharts.client.Chart;
import org.moxieapps.gwt.highcharts.client.Series;
import org.moxieapps.gwt.highcharts.client.Series.Type;

import com.google.gwt.core.shared.GWT;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

/**
 * <p>
 * 类的简介说明
 * </p>
 * 创建时间：2013-3-20 上午9:43:17
 * 
 * @author lianghaopeng
 * @version V1.0
 */
public class SportDataChartView extends HLayout {

	public SportDataChartView() {
		final VLayout leftPanel = new VLayout();
		final VLayout rightPanel = new VLayout();
		leftPanel.setWidth("20%");

		rightPanel.setWidth("80%");
		Chart chart = new Chart();
		Series series = chart.createSeries().setName("Moles per Yard")
				.setPoints(new Number[] { 163, 203, 276, 308, 347, 150, 99 });
		series.setType(Type.AREA);
		chart.addSeries(series);
		rightPanel.addMember(chart);
		addMember(leftPanel);
		addMember(rightPanel);
		// initWebSocket();
	}

	public native void initWebSocket()/*-{
		var ws = null;
		if (!$wnd.WebSocket) {
			$wnd.alert("WebSocket not supported by this browser!");
		} else {
			// 创建WebSocket  
			ws = new WebSocket(
					"ws://localhost:8080/CowHealth/ws/mywebsocket.ws");
			// 收到消息时在消息框内显示  
			ws.onmessage = function(evt) {
				@com.haozileung.scau.client.home.view.SportDataChartView::setData(Ljava/lang/String;)(evt.data);
			};
			// 断开时会走这个方法
			ws.onclose = function() {
				$wnd.alert('WebSocket连接断开！');
			};
			// 连接上时走这个方法
			ws.onopen = function() {
				$wnd.alert('WebSocket连接成功！');
			};
		}
	}-*/;

	public static void setData(String s) {
		GWT.log(s);
	}
}
