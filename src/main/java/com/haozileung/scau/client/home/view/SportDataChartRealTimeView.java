package com.haozileung.scau.client.home.view;

import java.util.HashMap;
import java.util.Map;

import org.moxieapps.gwt.highcharts.client.Axis;
import org.moxieapps.gwt.highcharts.client.Chart;
import org.moxieapps.gwt.highcharts.client.Chart.ZoomType;
import org.moxieapps.gwt.highcharts.client.Credits;
import org.moxieapps.gwt.highcharts.client.DateTimeLabelFormats;
import org.moxieapps.gwt.highcharts.client.Global;
import org.moxieapps.gwt.highcharts.client.Highcharts;
import org.moxieapps.gwt.highcharts.client.Lang;
import org.moxieapps.gwt.highcharts.client.Series;
import org.moxieapps.gwt.highcharts.client.Series.Type;
import org.moxieapps.gwt.highcharts.client.ToolTip;
import org.moxieapps.gwt.highcharts.client.plotOptions.LinePlotOptions;
import org.moxieapps.gwt.highcharts.client.plotOptions.Marker;
import org.moxieapps.gwt.highcharts.client.plotOptions.PlotOptions.Cursor;
import org.moxieapps.gwt.highcharts.client.plotOptions.SeriesPlotOptions;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Timer;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Label;
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
public class SportDataChartRealTimeView extends HLayout {
	private final VLayout leftPanel = new VLayout();
	private final VLayout rightPanel = new VLayout();
	private Chart chart;
	private boolean running = false;
	private Timer timer;
	private int isWebSocket = 1;
	private long updateTimeStr;
	private Label label = new Label();
	
	private void initLeft(){
		leftPanel.addMember(label);
		leftPanel.setWidth("20%");
		this.addMember(leftPanel);
	}

	private void initChart() {
		Highcharts.setOptions(new Highcharts.Options().setLang(
				new Lang()
						.setMonths(
								new String[] { "一月", "二月", "三月", "四月", "五月",
										"六月", "七月", "八月", "九月", "十月", "十一月",
										"十二月" })
						.setWeekdays(
								new String[] { "星期一", "星期二", "星期三", "星期四",
										"星期五", "星期六", "星期天" })
						.setResetZoom("重置").setResetZoomTitle("重置到初始样式"))
				.setGlobal(new Global().setUseUTC(false)));
		chart = new Chart();
		chart.setToolTip(new ToolTip().setEnabled(true).setShadow(true)
				.setXDateFormat("%Y年%B%e日%H时 %A"));
		chart.setZoomType(ZoomType.X);
		chart.setSpacingRight(20);
		chart.setChartTitleText("奶牛运动数据曲线图");
		chart.setCredits(new Credits().setHref("http://www.haozileung.com")
				.setText("Haozi Leung 制作"));
		chart.getXAxis()
				.setType(Axis.Type.DATE_TIME)
				.setMaxZoom(24 * 3600000)
				.setDateTimeLabelFormats(
						new DateTimeLabelFormats().setWeek("%B%e日")
								.setDay("%B%e日").setHour("%H:%M")
								.setMonth("%Y年%B").setYear("%Y年"));
		chart.getYAxis().setAxisTitleText("运动量");
		chart.setSeriesPlotOptions(new SeriesPlotOptions().setCursor(
				Cursor.POINTER).setMarker(new Marker().setLineWidth(1)));
		rightPanel.setWidth("80%");
		rightPanel.addMember(chart);
		this.addMember(rightPanel);
	}

	public SportDataChartRealTimeView() {
		initLeft();
		initChart();
		timer = new Timer() {

			@Override
			public void run() {
				if (running == false) {
					getSportData(null);
				}
			}

		};
		start(this);
	}

	public void startTimer() {
		timer.scheduleRepeating(1000);
	}

	public native void start(SportDataChartRealTimeView t)/*-{
		var ws = null;
		var heart_beat_timer;
		var moduleName = $moduleName;
		var baseUrl = $moduleBase;
		var regModuleName = new RegExp(moduleName + '/$');
		var regProtocalName = new RegExp('^http://');
		var regPoint = new RegExp(':[0-9]+', 'g');
		var wsUrl = baseUrl.replace(regModuleName, '');
		wsUrl = wsUrl.replace(regProtocalName, 'ws://');
		wsUrl = wsUrl + 'ws/mywebsocket.ws';
		if (!$wnd.WebSocket) {
			t.@com.haozileung.scau.client.home.view.SportDataChartRealTimeView::isWebSocket = 0;
			t.@com.haozileung.scau.client.home.view.SportDataChartRealTimeView::startTimer()();
		} else {
			t.@com.haozileung.scau.client.home.view.SportDataChartRealTimeView::isWebSocket = 1;
			// 创建WebSocket
			ws = new WebSocket(wsUrl);
			// 收到消息时走这个方法
			ws.onmessage = function(evt) {
				t.@com.haozileung.scau.client.home.view.SportDataChartRealTimeView::setData(Ljava/lang/String;)(evt.data);
			};
			// 断开时会走这个方法
			ws.onclose = function() {
				t.@com.haozileung.scau.client.home.view.SportDataChartRealTimeView::isWebSocket = 0;
				t.@com.haozileung.scau.client.home.view.SportDataChartRealTimeView::startTimer()();
			};
			// 连接上时走这个方法
			ws.onopen = function() {
				heart_beat_timer = setInterval(function() {
					ws.send('{online:1}');
				}, 240000);
			};
		}
	}-*/;

	public void getSportData(final String cowId) {
		running = true;
		String data = null;
		String url = "data/getSportData.action";
		if (cowId != null && !cowId.isEmpty()) {
			data = "?cowId=" + cowId;
			url += data;
			url += "&updateTimeStr=" + updateTimeStr;
		} else {
			url += "?updateTimeStr=" + updateTimeStr;
		}
		RequestBuilder req = new RequestBuilder(RequestBuilder.GET,
				URL.encode(url));
		req.setTimeoutMillis(300000);
		req.setHeader("If-Modified-Since", "0");
		req.setCallback(new RequestCallback() {

			@Override
			public void onError(Request arg0, Throwable arg1) {
				SC.say("请求运动数据出错！");
				running = false;
			}

			@Override
			public void onResponseReceived(Request request, Response response) {
				String json = response.getText();
				setData(json);
				running = false;
			}
		});

		try {
			req.send();
		} catch (RequestException e) {
			SC.say("发送请求失败！");
		}
	}

	public void setData(String json) {
		JSONValue jv = JSONParser.parseStrict(json).isObject().get("response");
		if (jv != null) {
			JSONValue jvData = jv.isObject().get("data");
			JSONValue updateTime = jv.isObject().get("updateTime");
			if (updateTime != null) {
				updateTimeStr = (new Double(jv.isObject().get("updateTime")
						.isNumber().doubleValue())).longValue();
			}
			if (jvData != null) {
				JSONArray ja = jvData.isArray();
				JSONValue jvCow = null;
				Map<String, Series> seriesMap = new HashMap<String, Series>();
				for (int i = 0; i < ja.size(); i++) {
					jvCow = ja.get(i);
					if (jvCow != null) {
						String cowName = null;
						String startDate = null;
						String[] dataStr = jvCow.isObject().get("data")
								.isString().stringValue().split(",");
						if (dataStr.length > 0) {

							cowName = jvCow.isObject().get("cowName")
									.isString().stringValue();
							startDate = jvCow.isObject().get("currentDate")
									.isString().stringValue();

							if (seriesMap.containsKey(cowName)) {
								Series series = seriesMap.get(cowName);
								for (int j = 0; j < dataStr.length; j++) {
									if (!"".equals(dataStr[j])) {
										float f = Float.valueOf(dataStr[j]);
										series.addPoint(f < 0 ? 0 : f);
									}
								}
							} else {
								Series series = chart
										.createSeries()
										.setName("奶牛:" + cowName)
										.setType(Type.LINE)
										.setPlotOptions(
												new LinePlotOptions()
														.setPointInterval(
																3600000)
														.setPointStart(
																(DateTimeFormat
																		.getFormat("yyyy-MM-dd")
																		.parse(startDate))
																		.getTime()));
								seriesMap.put(cowName, series);
							}
						}
					}
				}
				chart.removeAllSeries();
				String contents = new String("<h1>当前通过的奶牛：</h1>");
				for (String cowName : seriesMap.keySet()) {
					chart.addSeries(seriesMap.get(cowName));
					contents += "<h1>奶牛："+cowName+"</h1>";
				}
				label.setContents(contents);
			}

		}
	}
}
