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
    GroupImpl group = new GroupImpl();
    group.setGroupName("caup");
    group.setDescription("Having fun");
    userService.getGroupHandler().createGroup(group, true);   
    assertNotNull(userService.getGroupHandler().findGroupByName("caup"));    
  }
}
