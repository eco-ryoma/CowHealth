package com.haozileung.scau.client.home.view;

import com.google.gwt.core.shared.GWT;
import com.haozileung.scau.client.home.ds.CowDataSource;
import com.haozileung.scau.shared.Messages;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.grid.ListGrid;
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
		final DynamicForm editForm = new DynamicForm();
		final DynamicForm form = new DynamicForm();
		form.setIsGroup(true);
		form.setGroupTitle(message.editFormTitle());
		form.setNumCols(4);
		form.setDataSource(cowDS);
		form.getField("cowId").hide();
	}
}
