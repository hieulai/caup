/*
 * Copyright (C) 2003-2012 Caup
 */
package org.caup;

import org.caup.user.entity.impl.GroupImpl;
import org.caup.user.entity.impl.UserImpl;


/**
 * Created by Caup
 * Author : Lai Trung Hieu
 *          hieulaitrung@gmail.com
 * May 26, 2012  
 */
public class TestMembershipHandler extends AbstractTestHandler {
  
  public void testAddMembership() {
    txManager.openSession();
    GroupImpl group = TestUtils.createNewGroup();
    userService.getGroupHandler().createGroup(group, true);
    assertNotNull(userService.getGroupHandler().findGroupByName("caup"));
    UserImpl user = TestUtils.createNewUser();
    userService.getUserHandler().createUser(user, true);
    assertNotNull(userService.getUserHandler().findUserByName("hieu"));
    userService.getMembershipHandler().addUserToGroup̣("hieu", "caup", true);
    assertTrue(user.getGroups().size() > 0);
    assertTrue(group.getUsers().size() > 0);
    txManager.closeSession();
  }
  
  public void testRemoveMembership() {
    txManager.openSession();
    GroupImpl group = TestUtils.createNewGroup();
    userService.getGroupHandler().createGroup(group, true);
    assertNotNull(userService.getGroupHandler().findGroupByName("caup"));
    UserImpl user = TestUtils.createNewUser();
    userService.getUserHandler().createUser(user, true);
    assertNotNull(userService.getUserHandler().findUserByName("hieu"));
    userService.getMembershipHandler().addUserToGroup̣("hieu", "caup", true);
    userService.getMembershipHandler().removeUserFromGroup("hieu", "caup", true);
    assertTrue(user.getGroups().size() == 0);
    assertTrue(group.getUsers().size() == 0);
    txManager.closeSession();
  }
}
