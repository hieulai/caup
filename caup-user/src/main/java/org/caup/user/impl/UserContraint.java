/*
 * Copyright (C) 2003-2012 Caup
 */
package org.caup.user.impl;

/**
 * Created by Caup 
 * Author : Lai Trung Hieu 
 *          hieulaitrung@gmail.com 
 * May 12, 2012
 */
public interface UserContraint {

  public interface TABLES {

    public static final String USER = "User";

    public static final String GROUP = "Group";
  }

  public interface COLLUMS {
    public static final String NAME = "name";
    public static final String PASSWORD = "password";
    
    public static final String CREATED_DATE = "create_date";
    
    public static final String EMAIL = "email";
    
    public static final String DISPLAY_NAME = "display";
    
    public static final String DESCRIPTION = "description";
    
    
  }
}
