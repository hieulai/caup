/*
 * Copyright (C) 2003-2012 Caup
 */
package org.caup.user.handler;

import java.util.Iterator;
import java.util.List;

import org.caup.user.Query;
import org.caup.user.User;
import org.caup.user.EventListener;

/**
 * Created by Caup
 * Author : Lai Trung Hieu
 *          hieulaitrung@gmail.com
 * May 12, 2012  
 */
public interface UserHandler {
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
   * @throws Exception: The exception can be throwed if the the UserHandler
   *           cannot persist the user object or any listeners fail to handle
   *           the user event.
   */
  public User createUser(User user, boolean broadcast) throws Exception;

  /**
   * This method is used to update an existing User object
   * 
   * @param user The user object to update
   * @param broadcast If the broadcast is true , then all the user event
   *          listener that register with the organization service will be
   *          called
   * @throws Exception The exception can be throwed if the the UserHandler
   *           cannot save the user object or any listeners fail to handle the
   *           user event.
   */
  public User saveUser(User user, boolean broadcast) throws Exception;

  /**
   * Remove an user and broadcast the event to all the registerd listener. When
   * the user is removed , the user profile and all the membershisp of the user
   * should be removed as well.
   * 
   * @param userName The user should be removed from the user database
   * @param broadcast If broadcast is true, the the delete user event should be
   *          broadcasted to all registered listener
   * @return return the User object after that user has beed removed from
   *         database
   * @throws Exception    
   */
  public User removeUser(String userName, boolean broadcast) throws Exception;

  /**
   * @param userName the user that the user handler should search for
   * @return The method return null if there no user matchs the given username.
   *         The method return an User object if an user that mathch the
   *         username.
   * @throws Exception The exception is throwed if the method fail to access the
   *           user database or more than one user object with the same username
   *           is found
   */
  public User findUserByName(String userName) throws Exception;

  
  /**
   * This method should search and return the list of the users in a given
   * group.
   *
   * @param groupId id of the group. The return users list should be in this
   *          group
   * @return return a page list iterator of a group of the user in the database
   * @throws Exception any exception
   */
  public List<User> findUsersByGroupId(String groupId) throws Exception;

  /**
   * This method is used to get all the users in the database
   *
   * @return return a user iterator
   * @throws Exception any exception
   */
  public Iterator<User> findAllUsers() throws Exception;

  /**
   * This method search for the users according to a search criteria, the query
   * 
   * @param query The query object contains the search criteria.
   * @return return the found users in a page list according to the query.
   * @throws Exception throw exception if the service cannot access the database
   * @deprecated use {@link #findUsersByQuery(Query)} instead
   */
  @Deprecated
  public Iterator<User> findUsers(Query query) throws Exception;

  /**
   * This method search for the users accordding to a search criteria, the query
   *
   * @param query The query object contains the search criteria.
   * @return return the found users in a iterator according to the query.
   * @throws Exception throw exception if the service cannot access the database
   */
  public Iterator<User> findUsersByQuery(Query query) throws Exception;

  /**
   * Check if the username and the password of an user is valid.
   * 
   * @param username
   * @param password
   * @return return true if the username and the password is match with an user
   *         record in the database, else return false.
   * @throws Exception throw an exception if cannot access the database
   */
  public boolean authenticate(String username, String password) throws Exception;

  /**
   * This method is used to register an user event listener
   * 
   * @param listener
   */
  public void addUserEventListener(EventListener listener);

  /**
   * This method is used to unregister an user event listener
   * 
   * @param listener
   */
  public void removeUserEventListener(EventListener listener);
}
