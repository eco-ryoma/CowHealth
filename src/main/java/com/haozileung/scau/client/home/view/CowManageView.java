package com.haozileung.scau.client.home.view;

import com.google.gwt.core.shared.GWT;
import com.haozileung.scau.client.home.ds.CowDataSource;
import com.haozileung.scau.shared.Messages;
import com.smartgwt.client.types.VerticalAlignment;
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
 * <p>类的简介说明</p>
 * 创建时间：2013-3-20 下午5:17:20 
 * @author lianghaopeng
 * @version V1.0
 */
public class CowManageView extends VLayout{
	final private Messages message = GWT.create(Messages.class);
	public CowManageView(){
		super();
		setWidth100();
		setHeight100();
		initView();
	}
	
	public void initView(){
		final CowDataSource cowDS = CowDataSource.getInstance();
		final ListGrid cowList = new ListGrid();
		final DynamicForm form = new DynamicForm();
		form.setIsGroup(true);
		form.setGroupTitle(message.editFormTitle());
		form.setNumCols(8);
		form.setDataSource(cowDS);
		form.getField("cowId").hide();
		
		form.setHeight("50%");
		IButton newButton = new IButton(message.newButton());
		newButton.setWidth(80);
		newButton.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				form.editNewRecord();
			}
		});

		IButton saveButton = new IButton(message.addButton());
		saveButton.setWidth(80);
		saveButton.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				form.saveData();
			}
		});

		IButton removeButton = new IButton(message.deleteButton());
		removeButton.setWidth(80);
		removeButton.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				cowList.removeSelectedData();
			}
		});

		VLayout editorLayout = new VLayout();

		HLayout buttonPanel = new HLayout();
		buttonPanel.setWidth100();
		buttonPanel.setAlign(VerticalAlignment.CENTER);
		buttonPanel.addMember(newButton);
		buttonPanel.addMember(saveButton);
		buttonPanel.addMember(removeButton);
		
		editorLayout.addMember(form);
		editorLayout.addMember(buttonPanel);
		editorLayout.setHeight("30%");
		

		cowList.setDataSource(cowDS);
		cowList.setEmptyCellValue("-");
		cowList.setSortField(0);
		cowList.setDataPageSize(50);
		cowList.setAutoFetchData(true);
		cowList.addRecordClickHandler(new RecordClickHandler() {
			public void onRecordClick(RecordClickEvent event) {
				form.reset();
				form.editSelectedData(cowList);
			}
		});
		addMember(cowList);
		addMember(editorLayout);
	}
}
