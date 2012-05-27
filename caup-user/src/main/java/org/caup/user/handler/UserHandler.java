/*
 * Copyright (C) 2003-2012 Caup
 */
package org.caup.user.handler;

import java.util.Iterator;

import org.caup.transaction.exception.TransactionException;
import org.caup.user.entity.User;
import org.caup.user.exception.IdentityException;
import org.caup.user.exception.UserNotFoundException;
import org.xwiki.component.annotation.ComponentRole;

/**
 * Created by Caup
 * Author : Lai Trung Hieu
 *          hieulaitrung@gmail.com
 * May 12, 2012  
 */
@ComponentRole
public interface UserHandler extends EntityHandler {
  /**
   * This method is used to persist a new user object.
   * 
   * @param user: The user object to save
   * @param broadcast: If the broadcast value is true , then the UserHandler
   *          should broadcast the event to all the listener that register with
   *          the organization service. For example, the portal service register
   *          an user event listener with the organization service. when a new
   *          account is created, a portal configuration should be created for
   *          the new user account at the same time. In this case the portal
   *          user event listener will be called in the createUser method.
   * @throws TransactionException: The exception can be thrown if the the UserHandler
   *           cannot persist the user object or any listeners fail to handle
   *           the user event.
   */
  public User createUser(User user, boolean broadcast) throws TransactionException;

  /**
   * This method is used to update an existing User object
   * 
   * @param user The user object to update
   * @param broadcast If the broadcast is true , then all the user event
   *          listener that register with the organization service will be
   *          called
   * @throws TransactionException The exception can be thrown if the the UserHandler
   *           cannot save the user object or any listeners fail to handle the
   *           user event.
   */
  public User saveUser(User user, boolean broadcast) throws TransactionException;

  /**
   * Remove an user and broadcast the event to all the registered listener. When
   * the user is removed , the user profile and all the memberships of the user
   * should be removed as well.
   * 
   * @param userName The user should be removed from the user database
   * @param broadcast If broadcast is true, the the delete user event should be
   *          broadcasted to all registered listener
   * @return return the User object after that user has been removed from
   *         database
   * @throws TransactionException if removing process is fail    
   */
  public void removeUser(String userName, boolean broadcast) throws TransactionException;

  /**
   * @param userName the user that the user handler should search for
   * @return The method return null if there no user matches the given user name.
   *         The method return an User object if an user that matches the
   *         user name.
   * @throws UserNotFoundException The exception is thrown if the method fail to access the
   *           user database or more than one user object with the same user name
   *           is found
   */
  public User findUserByName(String userName) throws UserNotFoundException;  

  /**
   * This method is used to get all the users in the database
   *
   * @return return a user iterator
   */
  public Iterator<User> findAllUsers();

  /**
   * This method search for the users according to a search criteria, the query
   *
   * @param query The query object contains the search criteria.
   * @return return the found users in a iterator according to the query.
   */
  public Iterator<User> findUsersByQuery(String query);

  /**
   * Check if the user name and the password of an user is valid.
   * 
   * @param username
   * @param password
   * @return return true if the user name and the password is match with an user
   *         record in the database, else return false.
   * @throws IdentityException throw an exception if cannot access the database
   */
  public boolean authenticate(String username, String password) throws IdentityException;

 
}
