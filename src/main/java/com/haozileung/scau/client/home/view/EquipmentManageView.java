package com.haozileung.scau.client.home.view;

import com.google.gwt.core.shared.GWT;
import com.haozileung.scau.client.home.ds.EquipmentDataSource;
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
 * 创建时间：2013-3-20 下午5:18:09 
 * @author lianghaopeng
 * @version V1.0
 */
public class EquipmentManageView extends VLayout{
	final private Messages message = GWT.create(Messages.class);
	
	public EquipmentManageView(){
		super();
		setWidth100();
		setHeight100();
		initView();
	}
	
	public void initView() {
		final EquipmentDataSource equipmentDataSource = EquipmentDataSource.getInstance();
		final ListGrid userGrid = new ListGrid();
		final DynamicForm form = new DynamicForm();
		form.setIsGroup(true);
		form.setGroupTitle(message.editFormTitle());
		form.setNumCols(8);
		form.setDataSource(equipmentDataSource);
		form.getField("equipmentId").hide();
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
				userGrid.removeSelectedData();
			}
		});

		VLayout editorLayout = new VLayout();

		HLayout buttonPanel = new HLayout(20);
		buttonPanel.setWidth100();
		buttonPanel.setAlign(VerticalAlignment.CENTER);
		buttonPanel.addMember(newButton);
		buttonPanel.addMember(saveButton);
		buttonPanel.addMember(removeButton);
		
		editorLayout.addMember(form);
		editorLayout.addMember(buttonPanel);
		editorLayout.setHeight("30%");
		

		userGrid.setDataSource(equipmentDataSource);
		userGrid.setEmptyCellValue("-");
		userGrid.setSortField(0);
		userGrid.setDataPageSize(50);
		userGrid.setAutoFetchData(true);
		userGrid.addRecordClickHandler(new RecordClickHandler() {
			public void onRecordClick(RecordClickEvent event) {
				form.reset();
				form.editSelectedData(userGrid);
			}
		});
		addMember(userGrid);
		addMember(editorLayout);
	}
}
