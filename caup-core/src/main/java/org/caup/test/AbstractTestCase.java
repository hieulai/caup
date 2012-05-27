/*
 * Copyright (C) 2003-2012 Caup
 */
package org.caup.test;

import junit.framework.TestCase;

import org.caup.transaction.TransactionManager;
import org.xwiki.component.embed.EmbeddableComponentManager;

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
  protected TransactionManager txManager;

  @Override
  protected void setUp() throws Exception {
    this.componentManager = new EmbeddableComponentManager();
    this.componentManager.initialize(this.getClass().getClassLoader());
    this.txManager = componentManager.lookup(TransactionManager.class);
    super.setUp();
  }

  @Override
  protected void tearDown() throws Exception {
    this.componentManager = null;
    super.tearDown();
  }

}
