/*
 * Copyright (C) 2003-2012 Caup
 */
package org.caup.transaction.impl;

import java.util.Iterator;
import java.util.List;

import org.caup.transaction.Query;
import org.caup.transaction.exception.TransactionException;

/**
 * Created by Caup
 * Author : Lai Trung Hieu
 *          hieulaitrung@gmail.com
 * May 13, 2012  
 */
public class QueryImpl implements Query {

  private org.hibernate.Query hibernateQuery;

  public org.hibernate.Query getHibernateQuery() {
    return hibernateQuery;
  }

  public void setHibernateQuery(org.hibernate.Query hibernateQuery) {
    this.hibernateQuery = hibernateQuery;
  }

  @Override
  public Iterator iterate() throws TransactionException {
    return hibernateQuery.iterate();
  }

  @Override
  public List list() throws TransactionException {
    // TODO Auto-generated method stub
    return hibernateQuery.list();
  }
}
