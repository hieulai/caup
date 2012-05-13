/*
 * Copyright (C) 2003-2012 Caup
 */
package org.caup.plugin;

/**
 * A component plugin
 * 
 * Created by Caup
 * Author : Lai Trung Hieu
 *          hieulaitrung@gmail.com
 * May 12, 2012  
 */
public interface Plugin {
  /**
   * Get plugin name
   * @return
   */
  public String getName();

  /**
   * Set nae for plugin
   * @param s name
   */
  public void setName(String s);

  /**
   * Get description of plugin
   * @return
   */
  public String getDescription();

  /**
   * Set desciption for plugin
   * @param s description
   */
  public void setDescription(String s);
}
