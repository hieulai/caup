/*
 * Copyright (C) 2003-2012 Caup
 */
package org.caup.user;


/**
 * Created by Caup
 * Author : Lai Trung Hieu
 *          hieulaitrung@gmail.com
 * May 12, 2012  
 */
public interface EventListener {
  public EventType getType();

  public boolean execute() throws Exception;
  
}
