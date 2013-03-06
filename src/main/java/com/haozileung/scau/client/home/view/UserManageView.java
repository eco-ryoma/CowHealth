package com.haozileung.scau.client.home.view;

import com.google.gwt.core.shared.GWT;
import com.haozileung.scau.shared.Messages;
import com.haozileung.scau.client.home.ds.UserDataSource;
import com.smartgwt.client.types.Alignment;
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

public class UserManageView extends VLayout {
	
	final private Messages message = GWT.create(Messages.class);

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

		VLayout editorLayout = new VLayout(5);
		editorLayout.setAlign(Alignment.CENTER);
		editorLayout.setHeight("25%");
		editorLayout.addMember(form);

		HLayout buttonPanel = new HLayout(20);
		buttonPanel.setBackgroundColor("gray");
		buttonPanel.setWidth100();
		//buttonPanel.setAlign(Alignment.CENTER);
		buttonPanel.setAlign(VerticalAlignment.CENTER);
		buttonPanel.addMember(newButton);
		buttonPanel.addMember(saveButton);
		buttonPanel.addMember(removeButton);
		editorLayout.addMember(buttonPanel);

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
		addMember(editorLayout);
		addMember(userGrid);
		setAlign(Alignment.CENTER);
	}

}
