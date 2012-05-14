/*
 * Copyright (C) 2003-2012 Caup
 */
package org.caup.user.handler.impl;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.caup.transaction.TransactionManager;
import org.caup.transaction.TransactionSession;
import org.caup.user.Group;
import org.caup.user.event.EventListener;
import org.caup.user.event.EventType;
import org.caup.user.handler.GroupHandler;
import org.xwiki.component.annotation.Component;

/**
 * Created by Caup
 * Author : Lai Trung Hieu
 *          hieulaitrung@gmail.com
 * May 12, 2012  
 */
@Component
public class GroupHandlerImpl extends EntityHandlerImpl implements GroupHandler {
  
  @Inject
  private TransactionManager txManager; 

  public Group createGroup(Group group, boolean broadcast) throws Exception {
    TransactionSession session = txManager.openSession();
    session.save(group);
    session.commit();
    session.close();
    
    if (broadcast) {
      for (EventListener listener : this.listeners) {
        if (EventType.ADD == listener.getType()) {
          listener.execute();
        }
      }
    }
    return group;     
    
  }

  public Group saveGroup(Group group, boolean broadcast) throws Exception {
    TransactionSession session = txManager.openSession();
    session.update(group);
    session.commit();
    session.close();
    
    if (broadcast) {
      for (EventListener listener : this.listeners) {
        if (EventType.SAVE == listener.getType()) {
          listener.execute();
        }
      }
    }    
    return group;    
  }

  public void removeGroup(String groupName, boolean broadcast) throws Exception {
    TransactionSession session = txManager.openSession();
    Group group = findGroupByName(groupName);
    if (group != null) {
      session.delete(group);
    }
    session.commit();
    session.close();

    if (broadcast) {
      for (EventListener listener : this.listeners) {
        if (EventType.REMOVE == listener.getType()) {
          listener.execute();
        }
      }
    }
  }

  public Group findGroupByName(String groupName) throws Exception {
    Group group = null;
    TransactionSession session = txManager.openSession();
    List<Group> result = session.createQuery(String.format("from GroupImpl where name='%s'", groupName)).list();
    if (result.size() > 0) {
      group = result.get(0);
    }
    session.commit();
    session.close();
    return group;
  }

  public Iterator<Group> findGroupsOfUser(String user) throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

  public Iterator<Group> getAllGroups() throws Exception {
    TransactionSession session = txManager.openSession();
    Iterator<Group> result = session.createQuery("from GroupImpl").iterate();
    session.commit();
    session.close();
    return result;
  }

}
