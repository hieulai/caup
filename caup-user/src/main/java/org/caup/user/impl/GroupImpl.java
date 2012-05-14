/*
 * Copyright (C) 2003-2012 Caup
 */
package org.caup.user.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.caup.user.Group;

/**
 * Created by Caup
 * Author : Lai Trung Hieu
 *          hieulaitrung@gmail.com
 * May 12, 2012  
 */
@Entity
@Table(name = UserContraint.TABLES.GROUP)
public class GroupImpl implements Group {

  private String groupName;

  private String desc;

  @Id
  @NotNull
  @Column(name = UserContraint.COLLUMS.NAME)
  public String getGroupName() {
    return groupName;
  }

  public void setGroupName(String name) {
    this.groupName = name;
  }

  @Column(name= UserContraint.COLLUMS.DESCRIPTION)
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
