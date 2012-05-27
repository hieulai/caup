/*
 * Copyright (C) 2003-2012 Caup
 */
package org.caup;

import org.caup.user.entity.impl.UserImpl;
import org.caup.user.service.UserService;

/**
 * Created by Caup
 * Author : Lai Trung Hieu
 *          hieulaitrung@gmail.com
 * May 12, 2012  
 */
public class TestUserHandler extends AbstractTestHandler {
  
  private UserService userService;

  @Override
  protected void setUp() throws Exception {
    super.setUp();
    userService = componentManager.lookup(UserService.class);
  }

  public void testAddUser() throws Exception{
    txManager.openSession();
    UserImpl user = TestUtils.createNewUser();
    userService.getUserHandler().createUser(user, true);
    assertNotNull(userService.getUserHandler().findUserByName("hieu"));
    txManager.closeSession();
  }
  
  public void testUpdateUser() throws Exception {
    txManager.openSession();
    UserImpl user = TestUtils.createNewUser();
    userService.getUserHandler().createUser(user, true);
    user.setDisplayName("Hieu Lai Trung");
    userService.getUserHandler().saveUser(user, true);
    user = (UserImpl) userService.getUserHandler().findUserByName("hieu");
    assertEquals("Hieu Lai Trung", user.getDisplayName());
    txManager.closeSession();
  }
  
  public void testDeleteUser() throws Exception {
    txManager.openSession();
    UserImpl user = TestUtils.createNewUser();
    userService.getUserHandler().createUser(user, true);
    userService.getUserHandler().removeUser("hieu", true);
    assertNull(userService.getUserHandler().findUserByName("hieu"));
    txManager.closeSession();
  }
  
  public void testAuthenticateUser() throws Exception {
    txManager.openSession();
    UserImpl user = TestUtils.createNewUser();
    userService.getUserHandler().createUser(user, true);
    assertTrue(userService.getUserHandler().authenticate("hieu", "hieu"));
    txManager.closeSession();
  }
  
  public void testFindUsersByQuery() throws Exception{
    txManager.openSession();
    String query = "From UserImpl where email like 'hieulaitrung%'";    
    UserImpl user = TestUtils.createNewUser();
    userService.getUserHandler().createUser(user, true);
    assertTrue(userService.getUserHandler().findUsersByQuery(query).hasNext());
    txManager.closeSession();
  }
}
