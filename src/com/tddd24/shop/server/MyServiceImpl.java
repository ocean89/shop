package com.tddd24.shop.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.tddd24.shop.client.MyService;


public class MyServiceImpl extends RemoteServiceServlet implements
    MyService {

  public String testMethod(String s) {
    return s;
  }
}