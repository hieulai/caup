/*
 * Copyright (C) 2003-2012 Caup
 */
package org.caup.user.entity;

import java.util.List;


/**
 * Created by Caup
 * Author : Lai Trung Hieu
 *          hieulaitrung@gmail.com
 * May 12, 2012  
 */
public interface Group {
  /**
   * @return the local name of the group
   */
  public String getGroupName();

  /**
   * @param name
   *          the local name for the group
   */
  public void setGroupName(String name);

  /**
   * @return The group description
   */
  public String getDescription();

  /**
   * @param desc
   *          The new description of the group
   */
  public void setDescription(String desc);
  
  /**
   * Get list of group's users
   * @return users
   */
  public List<? extends User> getUsers();
}
