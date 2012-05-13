/*
 * Copyright (C) 2003-2012 Caup
 */
package org.caup.user.impl;

import org.caup.user.Group;

/**
 * Created by Caup
 * Author : Lai Trung Hieu
 *          hieulaitrung@gmail.com
 * May 12, 2012  
 */
public class GroupImpl implements Group {

  private String groupName;

  private String desc;

  public GroupImpl() {

  }

  public GroupImpl(String name) {
    groupName = name;
  }

  /**
   * @hibernate.property
   **/
  public String getGroupName() {
    return groupName;
  }

  public void setGroupName(String name) {
    this.groupName = name;
  }

  /**
   * @hibernate.property
   **/
  public String getDescription() {
    return desc;
  }

  public void setDescription(String s) {
    desc = s;
  }

  public String toString() {
    return "Group[" + groupName + "]";
  }

  /**
   * {@inheritDoc}
   **/
  public GroupImpl clone() {
    try {
      return (GroupImpl) super.clone();
    } catch (CloneNotSupportedException e) {
      return this;
    }
  }
}
