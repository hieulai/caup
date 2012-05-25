/*
 * Copyright (C) 2003-2012 Caup
 */
package org.caup;

import org.caup.test.AbstractTestCase;
import org.caup.user.impl.GroupImpl;
import org.caup.user.service.UserService;

/**
 * Created by Caup
 * Author : Lai Trung Hieu
 *          hieulaitrung@gmail.com
 * May 15, 2012  
 */
public class TestGroupHandler extends AbstractTestCase {
  private UserService userService;

  @Override
  protected void setUp() throws Exception {
    super.setUp();
    userService = componentManager.lookup(UserService.class);
  }

  public void testCreateGroup() throws Exception{
    GroupImpl group = createNewGroup();
    userService.getGroupHandler().createGroup(group, true);   
    assertNotNull(userService.getGroupHandler().findGroupByName("caup"));    
  }
  
  public void testUpdateGroup() throws Exception {
    GroupImpl group = createNewGroup();
    userService.getGroupHandler().createGroup(group, true);
    assertNotNull(userService.getGroupHandler().findGroupByName("caup"));
    group.setDescription("Work seriously");
    userService.getGroupHandler().saveGroup(group, true);
    assertEquals("Work seriously", userService.getGroupHandler().findGroupByName("caup").getDescription());
  }

  public void testRemoveGroup() throws Exception {
    GroupImpl group = createNewGroup();
    userService.getGroupHandler().createGroup(group, true);
    assertNotNull(userService.getGroupHandler().findGroupByName("caup"));
    userService.getGroupHandler().removeGroup("caup", true);
    assertNull(userService.getGroupHandler().findGroupByName("caup"));
  }

  public void testFindGroupByQuery() throws Exception {
    String query = "From GroupImpl where description like '%fun%'";
    GroupImpl group = createNewGroup();
    userService.getGroupHandler().createGroup(group, true);
    assertTrue(userService.getGroupHandler().findGroupsByQuery(query).hasNext());
  }
  
  private GroupImpl createNewGroup(){
    GroupImpl group = new GroupImpl();
    group.setGroupName("caup");
    group.setDescription("Having fun");
    return group;
  }
}
