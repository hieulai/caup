/*
 * Copyright (C) 2003-2012 Caup
 */
package org.caup;

import org.caup.test.AbstractTestCase;
import org.caup.user.service.UserService;

/**
 * Created by Caup
 * Author : Lai Trung Hieu
 *          hieulaitrung@gmail.com
 * May 26, 2012  
 */
public class AbstractTestHandler extends AbstractTestCase {

  protected UserService userService;

  @Override
  protected void setUp() throws Exception {
    super.setUp();
    userService = componentManager.lookup(UserService.class);
  }
}
