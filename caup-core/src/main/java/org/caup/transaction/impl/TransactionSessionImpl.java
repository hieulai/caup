/*
 * Copyright (C) 2003-2012 Caup
 */
package org.caup.transaction.impl;

import org.caup.transaction.Query;
import org.caup.transaction.TransactionSession;
import org.hibernate.Session;

/**
 * Created by Caup
 * Author : Lai Trung Hieu
 *          hieulaitrung@gmail.com
 * May 13, 2012  
 */
public class TransactionSessionImpl implements TransactionSession {
  
  private Session hibernateSession;

  Session getHibernateSession() {
    return hibernateSession;
  }

  void setHibernateSession(Session hibernateSession) {
    this.hibernateSession = hibernateSession;
  }

  void beginTransaction() {
    hibernateSession.beginTransaction();
  }

  @Override
  public void commit() {
    hibernateSession.beginTransaction().commit();
  }

  @Override
  public void save(Object object) {
    hibernateSession.save(object);
  }

  @Override
  public void update(Object object) {
    hibernateSession.update(object);
  }

  @Override
  public void delete(Object object) {
    hibernateSession.delete(object);
  }

  @Override
  public void refresh(Object object) {
    hibernateSession.refresh(object);
  }
  
  @Override
  public Query createQuery(String queryString) {
    org.hibernate.Query query = hibernateSession.createQuery(queryString);
    QueryImpl txQuery = new QueryImpl();
    txQuery.setHibernateQuery(query);
    return txQuery;
  }

  @Override
  public void close() {
    hibernateSession.clear();
  }

}
