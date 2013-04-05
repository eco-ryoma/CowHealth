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

	public void initView(){
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
				form.saveData();
			}
		});

		
		removeButton.setWidth(80);
		removeButton.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				listGrid.removeSelectedData();
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
}
