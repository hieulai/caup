/*
 * Copyright (C) 2003-2012 Caup
 */
package org.caup;

import java.util.Date;

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

  public void testUserHandler() throws Exception{    
    UserService userService = componentManager.lookup(UserService.class);
    UserImpl user = new UserImpl();
    user.setUserName("hieu");
    user.setDisplayName("Lai Trung Hieu");
    user.setPassword("hieu");
    user.setEmail("hieulaitrung@gmail.com");
    user.setCreatedDate(new Date());
    userService.getUserHandler().createUser(user, true);   
    assertNotNull(userService.getUserHandler().findUserByName("hieu"));    
  }
}
