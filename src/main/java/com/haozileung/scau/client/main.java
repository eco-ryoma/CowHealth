package com.haozileung.scau.client;

import com.google.gwt.core.client.EntryPoint;
import com.haozileung.scau.client.home.view.UserManageView;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class main implements EntryPoint {

	// private final Messages messages = GWT.create(Messages.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		UserManageView umv = new UserManageView();
		umv.draw();

	}
}
