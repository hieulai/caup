/*
 * Copyright (C) 2003-2012 Caup
 */
package org.caup.transaction;


/**
 * A transaction session
 * 
 * Created by Caup
 * Author : Lai Trung Hieu
 *          hieulaitrung@gmail.com
 * May 13, 2012  
 */
public interface TransactionSession {
  /**
   * Commit a transaction
   */
  public void commit();

  /**
   * Persist an object
   * @param object
   */
  public void save(Object object);

  /**
   * Update an object
   * @param object
   */
  public void update(Object object);

  /**
   * Remove an object
   * @param object
   */
  public void delete(Object object);
  
  /**
   * Refresh an object
   * @param object
   */
  public void refresh(Object object);
  
  /**
   * Create a Query with a given query string
   * @param query
   * @return <code>Query</code>
   */
  public Query createQuery(String query);
  
  /**
   * Close session
   */
  public void close();
  
}
