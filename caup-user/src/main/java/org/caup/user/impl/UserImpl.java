/*
 * Copyright (C) 2003-2012 Caup
 */
package org.caup.user.impl;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.caup.user.User;
/**
 * Created by Caup
 * Author : Lai Trung Hieu 
 *          hieulaitrung@gmail.com
 * May 12, 2012  
 */
@Entity
@Table(name = UserContraint.TABLES.USER)
public class UserImpl implements User {
  
  private String userName;

  private String password;

  private String email;

  private Date createdDate;

  private String displayName;

  private String groupName;

  @Id
  @Column(name = UserContraint.COLLUMS.NAME)
  @NotNull
  public String getUserName() {
    return this.userName;
  }

  public void setUserName(String s) {
    userName = s;
  }

  @Column(name = UserContraint.COLLUMS.PASSWORD)
  @NotNull
  public String getPassword() {
    return this.password;
  }

  public void setPassword(String s) {
    password = s;

  }

  @Column(name = UserContraint.COLLUMS.EMAIL)
  @NotNull
  public String getEmail() {
    return this.email;
  }

  public void setEmail(String s) {
    email = s;

  }

  @Column(name = UserContraint.COLLUMS.CREATED_DATE)
  @NotNull
  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date t) {
    this.createdDate = t;

  }

  @Column(name= UserContraint.COLLUMS.DISPLAY_NAME)
  @NotNull
  public String getDisplayName() {

    return this.displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;

  }

  @Transient
  public String getGroupName() {
    return groupName;
  }

  public void setGroupName(String groupName) {
    this.groupName = groupName;
  }

}
