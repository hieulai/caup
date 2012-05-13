/*
 * Copyright (C) 2003-2012 Caup
 */
package org.caup.transaction;

import java.util.Iterator;
import java.util.List;

import org.caup.transaction.exception.TransactionException;

/**
 * 
 * A query for transaction session
 * 
 * Created by Caup
 * Author : Lai Trung Hieu
 *          hieulaitrung@gmail.com
 * May 13, 2012  
 */
public interface Query {
  /**
   * Iterate the result
   * @return <code>Iterator</code>
   * @throws TransactionException
   */
  public Iterator iterate() throws TransactionException;

  /**
   * List the result
   * @return <code>List</code>
   * @throws TransactionException
   */
  public List list() throws TransactionException;
}
