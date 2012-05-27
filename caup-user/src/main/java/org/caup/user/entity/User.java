/*
 * Copyright (C) 2003-2012 Caup
 */
package org.caup.user.entity;

import java.util.Date;
import java.util.List;

/**
 * Created by Caup
 * Author : Lai Trung Hieu
 *          hieulaitrung@gmail.com
 * May 12, 2012  
 */
public interface User {
  /**
   * This method should return the username of the user. The username should be
   * unique and the user database should not have 2 user record with the same
   * username
   * 
   * @return
   */
  public String getUserName();

  /**
   * This method is used to change the username
   * 
   * @param s   
   */
  public void setUserName(String s);

  /**
   * @return This method return the password of the user account
   */
  public String getPassword();

  /**
   * This method is used to change the user account password.
   * 
   * @param s
   */
  public void setPassword(String s);
  
  /**
   * @return The email address of the user
   */
  public String getEmail();

  /**
   * @param s The new user email address
   */
  public void setEmail(String s);

  /**
   * @return The date that the user register or create the account
   */
  public Date getCreatedDate();

  /**
   * @param t input created date
   */
  public void setCreatedDate(Date t);

  
  /**
   * @return return the display name
   */
  public String getDisplayName();

  /**
   * @param displayName The name that should show in the display name
   */
  public void setDisplayName(String displayName);  
  
  /**
   * Get list group that user belongs to
   * @return List of group
   */
  public List<? extends Group> getGroups();
}