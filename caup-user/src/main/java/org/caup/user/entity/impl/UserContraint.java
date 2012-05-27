/*
 * Copyright (C) 2003-2012 Caup
 */
package org.caup.user.entity.impl;

/**
 * Created by Caup 
 * Author : Lai Trung Hieu 
 *          hieulaitrung@gmail.com 
 * May 12, 2012
 */
public interface UserContraint {

  public interface TABLES {

    public static final String USER = "tbl_User";

    public static final String GROUP = "tbl_Group";
    
    public static final String USER_GROUP = "tbl_User_Group";
  }

  public interface COLLUMS {
    public static final String USER_NAME = "user_name";

    public static final String GROUP_NAME = "group_name";
    public static final String PASSWORD = "password";

    public static final String CREATED_DATE = "create_date";

    public static final String EMAIL = "email";

    public static final String DISPLAY_NAME = "display";

    public static final String DESCRIPTION = "description";
    
    
  }
}
