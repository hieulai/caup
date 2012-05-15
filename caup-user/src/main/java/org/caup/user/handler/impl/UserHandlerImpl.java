/*
 * Copyright (C) 2003-2012 Caup
 */
package org.caup.user.handler.impl;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.caup.transaction.TransactionManager;
import org.caup.transaction.TransactionSession;
import org.caup.user.User;
import org.caup.user.event.EventListener;
import org.caup.user.event.EventType;
import org.caup.user.handler.UserHandler;
import org.xwiki.component.annotation.Component;

/**
 * Created by Caup
 * Author : Lai Trung Hieu
 *          hieulaitrung@gmail.com
 * May 12, 2012  
 */
@Component
public class UserHandlerImpl extends EntityHandlerImpl implements UserHandler {
  
  @Inject
  private TransactionManager txManager;

  public User createUser(User user, boolean broadcast) throws Exception {
    TransactionSession session = txManager.openSession();
    session.save(user);
    session.commit();
    session.close();
    
    if (broadcast) {
      for (EventListener listener : this.listeners) {
        if (EventType.ADD == listener.getType()) {
          listener.execute();
        }
      }
    }
    return user;        
  }

  public User saveUser(User user, boolean broadcast) throws Exception {
    TransactionSession session = txManager.openSession();
    session.update(user);
    session.commit();
    session.close();
    
    if (broadcast) {
      for (EventListener listener : this.listeners) {
        if (EventType.SAVE == listener.getType()) {
          listener.execute();
        }
      }
    }
    
    return user;
  }

  public void removeUser(String userName, boolean broadcast) throws Exception {
    TransactionSession session = txManager.openSession();
    User user = findUserByName(userName);
    if (user != null) {
      session.delete(user);
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

  public User findUserByName(String userName) throws Exception {
    User user = null;
    TransactionSession session = txManager.openSession();
    List<User> result = session.createQuery(String.format("from UserImpl where name='%s'", userName)).list();
    if (result.size() > 0) {
      user = result.get(0);
    }
    session.commit();
    session.close();
    return user;
  }

  public List<User> findUsersByGroupId(String groupId) throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

  public Iterator<User> findAllUsers() throws Exception {
    TransactionSession session = txManager.openSession();
    Iterator<User> result = session.createQuery("from UserImpl").iterate();
    session.commit();
    session.close();    
    return result;
  }

  public Iterator<User> findUsersByQuery(String query) throws Exception {
    TransactionSession session = txManager.openSession();
    Iterator<User> result = session.createQuery(query).iterate();
    session.commit();
    session.close();    
    return result;
  }

  public boolean authenticate(String username, String password) throws Exception {
    User user = findUserByName(username);
    if (user.getPassword().equals(password))
      return true;
    return false;
  }

}
