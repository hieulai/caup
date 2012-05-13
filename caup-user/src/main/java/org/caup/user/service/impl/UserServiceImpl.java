/*
 * Copyright (C) 2003-2012 Caup
 */
package org.caup.user.service.impl;

import org.caup.plugin.Plugin;
import org.caup.user.handler.GroupHandler;
import org.caup.user.handler.UserHandler;
import org.caup.user.handler.impl.GroupHandlerImpl;
import org.caup.user.handler.impl.UserHandlerImpl;
import org.caup.user.service.UserService;
import org.xwiki.component.annotation.Component;

/**
 * Created by Caup
 * Author : Lai Trung Hieu
 *          hieulaitrung@gmail.com
 * May 12, 2012  
 */
@Component
public class UserServiceImpl implements UserService  {

  protected UserHandler userHandler;

  protected GroupHandler groupHandler;  

  public UserServiceImpl() {
    userHandler = new UserHandlerImpl();
    groupHandler = new GroupHandlerImpl();
  }

  @Override
  public UserHandler getUserHandler() {
    return userHandler;
  }

  @Override
  public GroupHandler getGroupHandler() {
    return groupHandler;
  }

  synchronized public void addListenerPlugin(Plugin listener) throws Exception {
  }

}
