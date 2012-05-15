/*
 * Copyright (C) 2003-2012 Caup
 */
package org.caup;

import org.caup.test.AbstractTestCase;
import org.caup.user.impl.UserImpl;
import org.caup.user.service.UserService;

/**
 * Created by Caup
 * Author : Lai Trung Hieu
 *          hieulaitrung@gmail.com
 * May 12, 2012  
 */
public class TestUserHandler extends AbstractTestCase {
  
  private UserService userService;

  @Override
  protected void setUp() throws Exception {
    super.setUp();
    userService = componentManager.lookup(UserService.class);
  }

  public void testAddUser() throws Exception{
    UserImpl user = createNewUser();
    userService.getUserHandler().createUser(user, true);
    assertNotNull(userService.getUserHandler().findUserByName("hieu"));    
  }
  
  public void testUpdateUser() throws Exception {
    UserImpl user = createNewUser();
    userService.getUserHandler().createUser(user, true);
    user.setDisplayName("Hieu Lai Trung");
    userService.getUserHandler().saveUser(user, true);
    user = (UserImpl) userService.getUserHandler().findUserByName("hieu");
    assertEquals("Hieu Lai Trung", user.getDisplayName());
  }
  
  public void testDeleteUser() throws Exception {
    UserImpl user = createNewUser();
    userService.getUserHandler().createUser(user, true);
    userService.getUserHandler().removeUser("hieu", true);
    assertNull(userService.getUserHandler().findUserByName("hieu"));
  }
  
  public void testAuthenticateUser() throws Exception {
    UserImpl user = createNewUser();
    userService.getUserHandler().createUser(user, true);
    assertTrue(userService.getUserHandler().authenticate("hieu", "hieu"));
  }
  
  public void testFindUsersByQuery() throws Exception{
    String query = "From UserImpl where email like 'hieulaitrung%'";    
    UserImpl user = createNewUser();
    userService.getUserHandler().createUser(user, true);
    assertTrue(userService.getUserHandler().findUsersByQuery(query).hasNext());    
  }

  private UserImpl createNewUser(){
    UserImpl user = new UserImpl();
    user.setUserName("hieu");
    user.setDisplayName("Lai Trung Hieu");
    user.setPassword("hieu");
    user.setEmail("hieulaitrung@gmail.com");
    return user;
  }
}
