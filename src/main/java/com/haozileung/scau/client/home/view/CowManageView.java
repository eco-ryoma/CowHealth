package com.haozileung.scau.client.home.view;

import java.util.LinkedHashMap;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;
import com.haozileung.scau.client.CowHealth;
import com.haozileung.scau.client.home.ds.CowDataSource;
import com.haozileung.scau.shared.Messages;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

/**
 * <p>
 * 类的简介说明
 * </p>
 * 创建时间：2013-3-20 下午5:17:20
 * 
 * @author lianghaopeng
 * @version V1.0
 */
public class CowManageView extends VLayout {
	final private Messages message = GWT.create(Messages.class);

	public CowManageView() {
		super();
		setWidth100();
		setHeight100();
		initView();
	}

	public void initView() {
		final CowDataSource dataSource = CowDataSource.getInstance();
		final ListGrid listGrid = new ListGrid();
		final DynamicForm form = new DynamicForm();
		final IButton newButton = new IButton(message.newButton());
		final IButton freshButton = new IButton(message.freshButton());
		final IButton saveButton = new IButton(message.addButton());
		final IButton removeButton = new IButton(message.deleteButton());
		final VLayout editorLayout = new VLayout();
		final HLayout buttonPanel = new HLayout(20);

		form.setIsGroup(true);
		form.setGroupTitle(message.editFormTitle());
		form.setNumCols(6);
		form.setDataSource(dataSource);
		form.getField("cowId").hide();

		newButton.setWidth(80);
		newButton.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				form.editNewRecord();
			}
		});

		freshButton.setWidth(80);
		freshButton.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				listGrid.invalidateCache();
			}
		});

		saveButton.setWidth(80);
		saveButton.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				if (form.validate()) {
					form.saveData(new DSCallback() {

						@Override
						public void execute(DSResponse response,
								Object rawData, DSRequest request) {
							getCowList();
						}
					});
				}

			}
		});

		removeButton.setWidth(80);
		removeButton.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				listGrid.removeSelectedData();
				form.clear();
			}
		});

		buttonPanel.setWidth100();
		buttonPanel.setAlign(VerticalAlignment.CENTER);
		buttonPanel.addMember(newButton);
		buttonPanel.addMember(saveButton);
		buttonPanel.addMember(removeButton);
		buttonPanel.addMember(freshButton);

		editorLayout.addMember(form);
		editorLayout.addMember(buttonPanel);
		editorLayout.setHeight("30%");

		listGrid.setDataSource(dataSource);
		listGrid.setEmptyCellValue("-");
		listGrid.setSortField(0);
		listGrid.setDataPageSize(50);
		listGrid.setAutoFetchData(true);
		listGrid.addRecordClickHandler(new RecordClickHandler() {
			public void onRecordClick(RecordClickEvent event) {
				form.reset();
				form.editSelectedData(listGrid);
			}
		});
		addMember(listGrid);
		addMember(editorLayout);
	}

	public void getCowList() {
		RequestBuilder req = new RequestBuilder(RequestBuilder.GET,
				"cow/getCow.action");
		try {
			req.sendRequest(null, new RequestCallback() {

				@Override
				public void onError(Request arg0, Throwable arg1) {
					SC.say("请求奶牛列表出错！");

				}

				@Override
				public void onResponseReceived(Request request,
						Response response) {
					String json = response.getText();
					JSONValue jv = JSONParser.parseStrict(json).isObject()
							.get("response");
					if (jv != null) {
						JSONValue jvData = jv.isObject().get("data");
						if (jvData != null) {
							JSONArray ja = jvData.isArray();
							JSONValue jvCow = null;
							for (int i = 0; i < ja.size(); i++) {
								jvCow = ja.get(i);
								if(CowHealth.cowMap == null){
									CowHealth.cowMap = new LinkedHashMap<String,Object>();
								}
								if (jvCow != null) {
									String cowId = jvCow.isObject()
											.get("cowId").isString()
											.stringValue();
									String cowName = jvCow.isObject()
											.get("name").isString()
											.stringValue();
									CowHealth.cowMap.put(cowId, cowName);
								}
							}
							CowHealth.equipment.getForm().getField("cowId")
									.setValueMap(CowHealth.cowMap);
							CowHealth.sportData.getSelectItem().setValueMap(
									CowHealth.cowMap);
						}
					}
				}
			});
		} catch (RequestException e) {
		}

	}
}
