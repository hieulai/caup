/*
 * Copyright (C) 2003-2012 Caup
 */
package org.caup.user.handler.impl;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.caup.transaction.TransactionManager;
import org.caup.transaction.exception.TransactionException;
import org.caup.user.entity.User;
import org.caup.user.entity.impl.UserContraint;
import org.caup.user.event.EventListener;
import org.caup.user.event.EventType;
import org.caup.user.exception.IdentityException;
import org.caup.user.exception.UserNotFoundException;
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

  @Override
  public User createUser(User user, boolean broadcast) throws TransactionException {    
    txManager.getSession().save(user);
    txManager.getSession().commit();    
    
    if (broadcast) {
      for (EventListener listener : this.listeners) {
        if (EventType.ADD == listener.getType()) {
          listener.execute();
        }
      }
    }
    return user;        
  }

  @Override
  public User saveUser(User user, boolean broadcast) throws TransactionException {    
    txManager.getSession().update(user);
    txManager.getSession().commit();    
    if (broadcast) {
      for (EventListener listener : this.listeners) {
        if (EventType.SAVE == listener.getType()) {
          listener.execute();
        }
      }
    }
    
    return user;
  }

  @Override
  public void removeUser(String userName, boolean broadcast) throws TransactionException {    
    User user = findUserByName(userName);
    if (user != null) {
      txManager.getSession().delete(user);
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

  @Override
  public User findUserByName(String userName) throws UserNotFoundException {
    User user = null;    
    List<User> result = txManager.getSession().createQuery(String.format("from UserImpl where %s='%s'",UserContraint.COLLUMS.USER_NAME, userName)).list();
    if (result.size() > 0) {
      user = result.get(0);
    }
    txManager.getSession().commit();    
    return user;
  }
  
  @Override
  public Iterator<User> findAllUsers(){    
    Iterator<User> result = txManager.getSession().createQuery("from UserImpl").iterate();
    txManager.getSession().commit();        
    return result;
  }

  @Override
  public Iterator<User> findUsersByQuery(String query){    
    Iterator<User> result = txManager.getSession().createQuery(query).iterate();
    txManager.getSession().commit();        
    return result;
  }

  @Override
  public boolean authenticate(String username, String password) throws IdentityException {
    User user = findUserByName(username);
    if (user.getPassword().equals(password))
      return true;
    return false;
  }

}
