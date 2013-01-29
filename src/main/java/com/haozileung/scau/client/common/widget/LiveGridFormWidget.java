package com.haozileung.scau.client.common.widget;

import com.google.gwt.core.shared.GWT;
import com.haozileung.scau.client.Messages;
import com.haozileung.scau.client.common.BaseDataSource;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.CloseClickEvent;
import com.smartgwt.client.widgets.events.CloseClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.events.RecordDoubleClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordDoubleClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class LiveGridFormWidget extends VLayout {

	private static Messages messages = GWT.create(Messages.class);

	/**
	 * 领域对象名
	 */
	private String objectName;

	/**
	 * 组件数据源
	 */
	private BaseDataSource dataSource;

	/**
	 * 搜索表单
	 */
	private DynamicForm searchForm;

	/**
	 * 搜索面板
	 */
	private HLayout searchFormLayout;

	/**
	 * 面板按钮容器
	 */
	private HLayout buttonLayout;

	/**
	 * 新建记录按钮
	 */
	private IButton newButton;

	/**
	 * 查询按钮
	 */
	private IButton searchButton;

	/**
	 * 数据列表
	 */
	private ListGrid liveGrid;

	public LiveGridFormWidget() {

	}

	public LiveGridFormWidget(BaseDataSource dataSource, String objectName) {
		this.dataSource = dataSource;
		this.objectName = objectName;
		setWidth100();
		setHeight100();
		liveGrid = new ListGrid();
		liveGrid.setWidth100();
		liveGrid.setHeight100();
		liveGrid.setEmptyCellValue("--");
		liveGrid.setSortField(0);
		liveGrid.setDataPageSize(20);
		liveGrid.setAutoFetchData(true);
		liveGrid.setDataSource(dataSource);
		liveGrid.addRecordDoubleClickHandler(new RecordDoubleClickHandler() {
			boolean isChange = false;

			@Override
			public void onRecordDoubleClick(RecordDoubleClickEvent event) {
				final Window winModal = new Window();

				winModal.setWidth(300);
				winModal.setHeight(200);
				final DynamicForm form = new DynamicForm();
				final HLayout winButtonLayout = new HLayout();
				winButtonLayout.setMembersMargin(20);
				final IButton saveBtn = new IButton("Save");
				saveBtn.addClickHandler(new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						form.saveData();
						isChange = true;
					}
				});
				final IButton cancelBtn = new IButton("Close");
				cancelBtn.addClickHandler(new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						if (isChange) {
							liveGrid.invalidateCache();
							isChange = false;
						}
						winModal.destroy();
					}
				});
				winButtonLayout.addMember(cancelBtn);
				winButtonLayout.addMember(saveBtn);
				winButtonLayout.setAlign(Alignment.CENTER);
				form.setDataSource(getDataSource());
				form.editSelectedData(liveGrid);
				form.getField("userId").hide();
				winModal.setTitle("Details");
				winModal.addItem(form);
				winModal.addItem(winButtonLayout);
				winModal.setShowMinimizeButton(false);
				winModal.setIsModal(true);
				winModal.setShowModalMask(true);
				winModal.centerInPage();
				winModal.addCloseClickHandler(new CloseClickHandler() {

					@Override
					public void onCloseClick(CloseClickEvent event) {
						if (isChange) {
							liveGrid.invalidateCache();
							isChange = false;
						}
						winModal.destroy();
					}
				});
				winModal.show();
			}
		});

		buttonLayout = new HLayout();
		searchButton = new IButton(messages.searchButton());
		searchButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				liveGrid.invalidateCache();
				liveGrid.fetchData(searchForm.getValuesAsCriteria());
			}
		});
		newButton = new IButton(messages.newButton());
		newButton.addClickHandler(new ClickHandler() {
			boolean isChange=false;
			
			@Override
			public void onClick(ClickEvent event) {
				final Window winModal = new Window();

				winModal.setWidth(400);
				winModal.setHeight(300);
				final DynamicForm form = new DynamicForm();
				final HLayout winButtonLayout = new HLayout();
				winButtonLayout.setMembersMargin(20);
				final IButton saveBtn = new IButton("Save");
				saveBtn.addClickHandler(new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						form.saveData();
						isChange = true;
					}
				});
				final IButton cancelBtn = new IButton("Close");
				cancelBtn.addClickHandler(new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						if (isChange) {
							liveGrid.invalidateCache();
							isChange = false;
						}
						winModal.destroy();
					}
				});
				winButtonLayout.addMember(cancelBtn);
				winButtonLayout.addMember(saveBtn);
				winButtonLayout.setAlign(Alignment.CENTER);
				form.setDataSource(getDataSource());
				form.getField("userId").hide();
				form.getField("age").hide();
				winModal.setTitle("Details");
				winModal.addItem(form);
				winModal.addItem(winButtonLayout);
				winModal.setShowMinimizeButton(false);
				winModal.setIsModal(true);
				winModal.setShowModalMask(true);
				winModal.centerInPage();
				// winModal.addItem(new EquipmentManageView());
				winModal.addCloseClickHandler(new CloseClickHandler() {

					@Override
					public void onCloseClick(CloseClickEvent event) {
						if (isChange) {
							liveGrid.invalidateCache();
							isChange = false;
						}
						winModal.destroy();
					}
				});
				winModal.show();
			}
		});
		buttonLayout.addMember(searchButton);
		buttonLayout.addMember(newButton);
		buttonLayout.setMembersMargin(20);

		searchForm = new DynamicForm();
		searchForm.setDataSource(dataSource);
		searchForm.setNumCols(4);
		searchForm.setWidth100();
		TextItem nameItem = new TextItem("name", "姓名");
		searchForm.setFields(nameItem);
		searchFormLayout = new HLayout();
		searchFormLayout.addMember(searchForm);
		searchFormLayout.addMember(buttonLayout);
		searchFormLayout.setMembersMargin(20);
		searchFormLayout.setHeight(30);
		
		addMember(searchFormLayout);
		addMember(liveGrid);
	}

	/**
	 * @return the objectName
	 */
	public String getObjectName() {
		return objectName;
	}

	/**
	 * @param objectName
	 *            the objectName to set
	 */
	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	/**
	 * @return the dataSource
	 */
	public BaseDataSource getDataSource() {
		return dataSource;
	}

	/**
	 * @param dataSource
	 *            the dataSource to set
	 */
	public void setDataSource(BaseDataSource dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * @return the searchForm
	 */
	public DynamicForm getSearchForm() {
		return searchForm;
	}

	/**
	 * @param searchForm
	 *            the searchForm to set
	 */
	public void setSearchForm(DynamicForm searchForm) {
		this.searchForm = searchForm;
	}

	/**
	 * @return the searchFormLayout
	 */
	public HLayout getSearchFormLayout() {
		return searchFormLayout;
	}

	/**
	 * @param searchFormLayout
	 *            the searchFormLayout to set
	 */
	public void setSearchFormLayout(HLayout searchFormLayout) {
		this.searchFormLayout = searchFormLayout;
	}

	/**
	 * @return the buttonLayout
	 */
	public HLayout getButtonLayout() {
		return buttonLayout;
	}

	/**
	 * @param buttonLayout
	 *            the buttonLayout to set
	 */
	public void setButtonLayout(HLayout buttonLayout) {
		this.buttonLayout = buttonLayout;
	}

	/**
	 * @return the newButton
	 */
	public IButton getNewButton() {
		return newButton;
	}

	/**
	 * @param newButton
	 *            the newButton to set
	 */
	public void setNewButton(IButton newButton) {
		this.newButton = newButton;
	}

	/**
	 * @return the searchButton
	 */
	public IButton getSearchButton() {
		return searchButton;
	}

	/**
	 * @param searchButton
	 *            the searchButton to set
	 */
	public void setSearchButton(IButton searchButton) {
		this.searchButton = searchButton;
	}

	/**
	 * @return the liveGrid
	 */
	public ListGrid getLiveGrid() {
		return liveGrid;
	}

	/**
	 * @param liveGrid
	 *            the liveGrid to set
	 */
	public void setLiveGrid(ListGrid liveGrid) {
		this.liveGrid = liveGrid;
	}

}
