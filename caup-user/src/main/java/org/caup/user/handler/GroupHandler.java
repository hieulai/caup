/*
 * Copyright (C) 2003-2012 Caup
 */
package org.caup.user.handler;

import java.util.Iterator;

import org.caup.user.Group;
import org.xwiki.component.annotation.ComponentRole;

/**
 * Created by Caup
 * Author : Lai Trung Hieu
 *          hieulaitrung@gmail.com
 * May 12, 2012  
 */
@ComponentRole
public interface GroupHandler extends EntityHandler {
  
  public Group createGroup(Group group, boolean broadcast) throws Exception;

  /**
   * Use this method to update the properties of an existed group. Usually you
   * should use the method findGroupById(..) to find the group, use the methods
   * set to change the data of the group and then call this method to persisted
   * the updated information. You should not call this method with the group
   * instance you get from the createGroupInstance()
   * 
   * @param group The group object with the updated information.
   * @param broadcast Broadcast the event to all the registered listener if the
   *          broadcast value is true
   * @throws Exception An exception is thrown if the method cannot access the
   *           database or any listener fail to handle the event
   */
  public Group saveGroup(Group group, boolean broadcast) throws Exception;

  /**
   * Use this method to remove a group from the group database. If the group has
   * the children group. The method should not remove the group and throw and
   * exception
   * 
   * @param group The group to be removed. The group parameter should be
   *          obtained form the findGroupId(..) method. When the group is
   *          removed, the memberships of the group should be removed as well.
   * @param broadcast Broadcast the event to the registered listener if the
   *          broadcast value is 'true'
   * @return Return the removed group.
   * @throws Exception An exception is thrown if the method fail to remove the
   *           group from the database, the group is not existed in the
   *           database, or any listener fail to handle the event.
   */
  public void removeGroup(String groupName, boolean broadcast) throws Exception;

  /**
   * Use this method to search for a group
   * 
   * @param groupName the id of the group that you want to search for
   * @return null if no record matched the group id or the found group
   * @throws Exception An exception is thrown if the method cannot access the
   *           database or more than one group is found.
   */
  public Group findGroupByName(String groupName) throws Exception;

  /**
   * use this method to look all the group that the user has at least one
   * membership.
   * 
   * @param user The user name of the user
   * @return A collection of the found group. The return collection cannot be
   *         null, but it can be empty if no group is found.
   * @throws Exception An exception is thrown if the method cannot access the
   *           database.
   */
  public Iterator<Group> findGroupsOfUser(String user) throws Exception;

  /**
   * Use this method to get all the groups. But the third party should not use
   * this method
   */
  public Iterator<Group> getAllGroups() throws Exception;
  
  /**
   * This method search for the groups according to a search criteria, the query
   *
   * @param query The query object contains the search criteria.
   * @return return the found users in a iterator according to the query.
   * @throws Exception throw exception if the service cannot access the database
   */
  public Iterator<Group> findGroupsByQuery(String query) throws Exception;
}
