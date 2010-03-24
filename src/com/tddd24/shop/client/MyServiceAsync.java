package com.tddd24.shop.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface MyServiceAsync {

	void testMethod(String s, AsyncCallback<String> callback);

}
