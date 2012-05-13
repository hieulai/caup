/*
 * Copyright (C) 2003-2012 Caup
 */
package org.caup.test;

import org.xwiki.component.embed.EmbeddableComponentManager;

import junit.framework.TestCase;

/**
 * An abstract test case
 * 
 * Created by Caup
 * Author : Lai Trung Hieu
 *          hieulaitrung@gmail.com
 * May 13, 2012  
 */
public class AbstractTestCase extends TestCase {
  
  protected EmbeddableComponentManager componentManager;

  @Override
  protected void setUp() throws Exception {
    this.componentManager = new EmbeddableComponentManager();
    this.componentManager.initialize(this.getClass().getClassLoader());
    super.setUp();
  }

  @Override
  protected void tearDown() throws Exception {
    super.tearDown();
  }

}
