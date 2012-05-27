/*
 * Copyright (C) 2003-2012 Caup
 */
package org.caup.user.service.impl;

import javax.inject.Inject;

import org.caup.plugin.Plugin;
import org.caup.user.handler.GroupHandler;
import org.caup.user.handler.MembershipHandler;
import org.caup.user.handler.UserHandler;
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

  @Inject
  private UserHandler userHandler;

  @Inject
  private GroupHandler groupHandler;
  
  @Inject
  private MembershipHandler membershipHandler;

  @Override
  public UserHandler getUserHandler() {
    return userHandler;
  }

  @Override
  public GroupHandler getGroupHandler() {
    return groupHandler;
  }
  
  @Override
  public MembershipHandler getMembershipHandler() {
    return membershipHandler;
  }

  synchronized public void addListenerPlugin(Plugin listener) throws Exception {
  }


}
