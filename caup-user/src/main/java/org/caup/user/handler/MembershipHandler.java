/*
 * Copyright (C) 2003-2012 Caup
 */
package org.caup.user.handler;

import java.util.List;

import org.caup.transaction.exception.TransactionException;
import org.caup.user.entity.Group;
import org.caup.user.entity.User;
import org.xwiki.component.annotation.ComponentRole;

/**
 * Created by Caup
 * Author : Lai Trung Hieu
 *          hieulaitrung@gmail.com
 * May 26, 2012  
 */
@ComponentRole
public interface MembershipHandler {
  
  /**
   * use this method to look all the user that the group contains
   * 
   * @param groupName the name of group
   * @return a list of user
   */
  public List<? extends User> findUserOfGroup(String groupName);
  
  /**
   * This method should search and return the list of the groups in a given
   * user.
   *
   * @param userName name of the user. The return groups list that user is in
   *          
   * @return return a page list iterator of a group of the user in the database
   */
  public List<? extends Group> findGroupsOfUser(String userName);
  
  /**
   * Add an user to a group
   * @param userName the name of user to add
   * @param groupName the group name
   * @param broadcast broadcast events or not
   * @throws TransactionException if the adding process is fail
   */
  public void addUserToGroup̣(String userName, String groupName, boolean broadcast) throws TransactionException;
  
  /**
   * Remove an user from a group
   * @param userName the name of user to remove
   * @param groupName the group name
   * @param broadcast broadcast events or not
   * @throws TransactionException if the removing process is fail
   */
  public void removeUserFromGroup(String userName, String groupName, boolean broadcast) throws TransactionException;
}
