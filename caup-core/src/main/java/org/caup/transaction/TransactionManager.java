/*
 * Copyright (C) 2003-2012 Caup
 */
package org.caup.transaction;

import org.caup.transaction.exception.TransactionException;
import org.xwiki.component.annotation.ComponentRole;

/**
 * Manage data transactions
 * 
 * Created by Caup
 * Author : Lai Trung Hieu
 *          hieulaitrung@gmail.com
 * May 12, 2012  
 */
@ComponentRole
public interface TransactionManager {
  /**
   * Open and return a transaction session
   * @return <code>TransactionSession</code>
   * @throws TransactionException
   */
  public TransactionSession openSession() throws TransactionException;
  
  /**
   * Get current and opened sessoin
   * @return <code>TransactionSession</code>
   */
  public TransactionSession getSession();

  /**
   * Close current session
   * @throws TransactionException
   */
  public void closeSession() throws TransactionException;
  
  /**
   * Shut down
   */
  public void shutdown();
}
