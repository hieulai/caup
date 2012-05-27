/*
 * Copyright (C) 2003-2012 Caup
 */
package org.caup.user.handler.impl;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.caup.transaction.TransactionManager;
import org.caup.transaction.exception.TransactionException;
import org.caup.user.entity.Group;
import org.caup.user.entity.impl.UserContraint;
import org.caup.user.event.EventListener;
import org.caup.user.event.EventType;
import org.caup.user.exception.GroupNotFoundException;
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

  public Group createGroup(Group group, boolean broadcast) throws TransactionException {
    txManager.getSession().save(group);
    txManager.getSession().commit();
    
    if (broadcast) {
      for (EventListener listener : this.listeners) {
        if (EventType.ADD == listener.getType()) {
          listener.execute();
        }
      }
    }
    return group;     
    
  }

  public Group saveGroup(Group group, boolean broadcast) throws TransactionException {
    txManager.getSession().update(group);
    txManager.getSession().commit();
    
    if (broadcast) {
      for (EventListener listener : this.listeners) {
        if (EventType.SAVE == listener.getType()) {
          listener.execute();
        }
      }
    }    
    return group;    
  }

  public void removeGroup(String groupName, boolean broadcast) throws TransactionException {
    Group group = findGroupByName(groupName);
    if (group != null) {
      txManager.getSession().delete(group);
    }
    txManager.getSession().commit();

    if (broadcast) {
      for (EventListener listener : this.listeners) {
        if (EventType.REMOVE == listener.getType()) {
          listener.execute();
        }
      }
    }
  }

  public Group findGroupByName(String groupName) throws GroupNotFoundException {
    Group group = null;
    List<Group> result = txManager.getSession().createQuery(
        String.format("from GroupImpl where %s='%s'", UserContraint.COLLUMS.GROUP_NAME, groupName)).list();
    if (result.size() > 0) {
      group = result.get(0);
    }
    txManager.getSession().commit();
    return group;
  }

  public Iterator<Group> getAllGroups(){
    Iterator<Group> result = txManager.getSession().createQuery("from GroupImpl").iterate();
    txManager.getSession().commit();
    return result;
  }

  @Override
  public Iterator<Group> findGroupsByQuery(String query){    
    Iterator<Group> result = txManager.getSession().createQuery(query).iterate();
    txManager.getSession().commit();   
    return result;
  }

}
