/*
 * Copyright (C) 2003-2012 Caup
 */
package org.caup.user.service;

import org.caup.user.handler.GroupHandler;
import org.caup.user.handler.UserHandler;
import org.xwiki.component.annotation.ComponentRole;

/**
 * Created by Caup
 * Author : Lai Trung Hieu
 *          hieulaitrung@gmail.com
 * May 12, 2012  
 */
@ComponentRole
public interface UserService {
  /**
   * This method return an UserHandler object that use to manage the user
   * opeation such create, update , detele , find user.
   * 
   * @see UserHandler
   **/
  public UserHandler getUserHandler();

  /**
   * @return return an GroupHandler implementation instance.
   * @see GroupHandler
   */
  public GroupHandler getGroupHandler();

  /**
   * @return return a MembershipTypeHandler implementation instance
   * @see MembershipTypeHandler
   */  
}
