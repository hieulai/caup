/*
 * Copyright (C) 2003-2012 Caup
 */
package org.caup.user.entity.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.caup.user.entity.User;
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
  
  public List<GroupImpl> groups = new ArrayList<GroupImpl>();

  @Id
  @Column(name = UserContraint.COLLUMS.USER_NAME)
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
  
  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinTable(name = UserContraint.TABLES.USER_GROUP, joinColumns = { @JoinColumn(name = UserContraint.COLLUMS.USER_NAME, nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = UserContraint.COLLUMS.GROUP_NAME, nullable = false, updatable = false) })
  @Override
  public List<GroupImpl> getGroups() {
    return this.groups;
  }
  
  public void setGroups(List<GroupImpl> groups) {
    this.groups = groups;
  }
  
  public void addGroup(GroupImpl group){
    getGroups().add(group);
  }
  
  public void removeGroup(GroupImpl group){
    getGroups().remove(group);
  }
  
}
