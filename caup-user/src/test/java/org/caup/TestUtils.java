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
 * May 25, 2012  
 */
public class TestUtils {

  public static GroupImpl createNewGroup() {
    GroupImpl group = new GroupImpl();
    group.setGroupName("caup");
    group.setDescription("Having fun");
    return group;
  }

  public static UserImpl createNewUser() {
    UserImpl user = new UserImpl();
    user.setUserName("hieu");
    user.setDisplayName("Lai Trung Hieu");
    user.setPassword("hieu");
    user.setEmail("hieulaitrung@gmail.com");
    return user;
  }
}
