/*
 * Copyright (C) 2003-2012 Caup
 */
package org.caup;

import org.caup.user.entity.impl.GroupImpl;

/**
 * Created by Caup
 * Author : Lai Trung Hieu
 *          hieulaitrung@gmail.com
 * May 15, 2012  
 */
public class TestGroupHandler extends AbstractTestHandler {

  public void testCreateGroup() throws Exception{
    txManager.openSession();
    GroupImpl group = TestUtils.createNewGroup();
    userService.getGroupHandler().createGroup(group, true);
    assertNotNull(userService.getGroupHandler().findGroupByName("caup"));
    txManager.closeSession();
  }
  
  public void testUpdateGroup() throws Exception {
    txManager.openSession();
    GroupImpl group = TestUtils.createNewGroup();
    userService.getGroupHandler().createGroup(group, true);
    assertNotNull(userService.getGroupHandler().findGroupByName("caup"));
    group.setDescription("Work seriously");
    userService.getGroupHandler().saveGroup(group, true);
    assertEquals("Work seriously", userService.getGroupHandler().findGroupByName("caup").getDescription());
    txManager.closeSession();
  }

  public void testRemoveGroup() throws Exception {
    txManager.openSession();
    GroupImpl group = TestUtils.createNewGroup();
    userService.getGroupHandler().createGroup(group, true);
    assertNotNull(userService.getGroupHandler().findGroupByName("caup"));
    userService.getGroupHandler().removeGroup("caup", true);
    assertNull(userService.getGroupHandler().findGroupByName("caup"));
    txManager.closeSession();
  }

  public void testFindGroupByQuery() throws Exception {
    txManager.openSession();
    String query = "From GroupImpl where description like '%fun%'";
    GroupImpl group = TestUtils.createNewGroup();
    userService.getGroupHandler().createGroup(group, true);
    assertTrue(userService.getGroupHandler().findGroupsByQuery(query).hasNext());
    txManager.closeSession();
  }
}
