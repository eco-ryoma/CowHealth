package com.haozileung.scau.client.home.view;

import java.util.LinkedHashMap;

import org.moxieapps.gwt.highcharts.client.Chart;
import org.moxieapps.gwt.highcharts.client.Series;

import com.google.gwt.core.shared.GWT;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
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

	private VLayout leftPanel;

	private VLayout rightPanel;

	public SportDataChartView() {
		leftPanel = new VLayout();
		leftPanel.setWidth("20%");
		DynamicForm form = new DynamicForm();
		SelectItem selectItem = new SelectItem();
		LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("1", "1111");
		map.put("2", "2222");
		map.put("3", "3333");
		selectItem.setValueMap(map);
		selectItem.setName("CowNumber");
		form.setItems(selectItem);
		leftPanel.addMember(form);
		rightPanel = new VLayout();
		rightPanel.setWidth("80%");
		Chart chart = new Chart();
		Series series = chart.createSeries().setName("Moles per Yard")
				.setPoints(new Number[] { 163, 203, 276, 408, 547, 729, 628 });
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
