package com.haozileung.scau.client.home.view;

import com.haozileung.scau.client.home.ds.UserDataSource;
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

public class UserManageView extends HLayout {

	public UserManageView() {
		super();
		setWidth100();
		setHeight100();
		initView();
	}

	public void initView() {
		final UserDataSource userDataSource = UserDataSource.getInstance();
		final ListGrid userGrid = new ListGrid();
		final DynamicForm form = new DynamicForm();
		form.setIsGroup(true);
		form.setGroupTitle("Details");
		form.setNumCols(4);
		form.setDataSource(userDataSource);
		form.getField("userId").hide();
		form.getField("age").disable();
		form.setWidth(500);
		form.setHeight(194);
		IButton newButton = new IButton("新建");
		newButton.setWidth(80);
		newButton.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				form.editNewRecord();
			}
		});

		IButton saveButton = new IButton("保存");
		saveButton.setWidth(80);
		saveButton.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				form.saveData();
			}
		});

		IButton removeButton = new IButton("删除");
		removeButton.setWidth(80);
		removeButton.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				userGrid.removeSelectedData();
			}
		});

		VLayout editorLayout = new VLayout(5);
		editorLayout.setHeight(250);
		editorLayout.setAlign(VerticalAlignment.TOP);
		editorLayout.addMember(form);
			
		HLayout buttonPanel = new HLayout(20);
		buttonPanel.addMember(newButton);
		buttonPanel.addMember(saveButton);
		buttonPanel.addMember(removeButton);
		editorLayout.addMember(buttonPanel);

		userGrid.setWidth(500);
		userGrid.setHeight(224);
		userGrid.setDataSource(userDataSource);
		userGrid.setEmptyCellValue("--");
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
