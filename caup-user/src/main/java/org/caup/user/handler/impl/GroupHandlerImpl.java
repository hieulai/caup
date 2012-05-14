/*
 * Copyright (C) 2003-2012 Caup
 */
package org.caup.user.handler.impl;

import java.util.Iterator;

import org.caup.user.Group;
import org.caup.user.event.EventListener;
import org.caup.user.handler.GroupHandler;
import org.xwiki.component.annotation.Component;

/**
 * Created by Caup
 * Author : Lai Trung Hieu
 *          hieulaitrung@gmail.com
 * May 12, 2012  
 */
@Component
public class GroupHandlerImpl implements GroupHandler {

  public void createGroup(Group group, boolean broadcast) throws Exception {
    // TODO Auto-generated method stub
    
  }

  public void saveGroup(Group group, boolean broadcast) throws Exception {
    // TODO Auto-generated method stub
    
  }

  public Group removeGroup(Group group, boolean broadcast) throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

  public Group findGroupById(String groupId) throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

  public Iterator<Group> findGroupsOfUser(String user) throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

  public Iterator<Group> getAllGroups() throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

  public void addGroupEventListener(EventListener listener) {
    // TODO Auto-generated method stub
    
  }

  public void removeGroupEventListener(EventListener listener) {
    // TODO Auto-generated method stub
    
  }

}
