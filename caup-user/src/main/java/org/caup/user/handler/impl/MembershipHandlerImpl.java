/*
 * Copyright (C) 2003-2012 Caup
 */
package org.caup.user.handler.impl;

import java.util.List;

import javax.inject.Inject;

import org.caup.transaction.exception.TransactionException;
import org.caup.user.entity.impl.GroupImpl;
import org.caup.user.entity.impl.UserImpl;
import org.caup.user.handler.GroupHandler;
import org.caup.user.handler.MembershipHandler;
import org.caup.user.handler.UserHandler;
import org.xwiki.component.annotation.Component;

/**
 * Created by Caup
 * Author : Lai Trung Hieu
 *          hieulaitrung@gmail.com
 * May 26, 2012  
 */
@Component
public class MembershipHandlerImpl extends EntityHandlerImpl implements MembershipHandler {
  
  @Inject
  private UserHandler userHandler;
  
  @Inject
  private GroupHandler groupHandler;

  @Override
  public List<UserImpl> findUserOfGroup(String groupName) {
    GroupImpl group = (GroupImpl) groupHandler.findGroupByName(groupName);
    return group.getUsers();
  }

  @Override
  public List<GroupImpl> findGroupsOfUser(String userName) {
    UserImpl user = (UserImpl) userHandler.findUserByName(userName);
    return user.getGroups();
  }

  @Override
  public void addUserToGroup̣(String userName, String groupName, boolean broadcast) throws TransactionException {
    UserImpl user = (UserImpl) userHandler.findUserByName(userName);
    GroupImpl group = (GroupImpl) groupHandler.findGroupByName(groupName);
    if (group != null && user != null){
      group.addUser(user);
      user.addGroup(group);
    }
  }

  @Override
  public void removeUserFromGroup(String userName,  String groupName, boolean broadcast) throws TransactionException {
    UserImpl user = (UserImpl) userHandler.findUserByName(userName);
    GroupImpl group = (GroupImpl) groupHandler.findGroupByName(groupName);
    if (group != null && user != null){
      group.removeUser(user);
      user.removeGroup(group);
    }
  }

}
