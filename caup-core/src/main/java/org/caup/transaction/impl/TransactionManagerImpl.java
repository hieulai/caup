/*
 * Copyright (C) 2003-2012 Caup
 */
package org.caup.transaction.impl;

import org.apache.log4j.Logger;
import org.caup.transaction.TransactionManager;
import org.caup.transaction.TransactionSession;
import org.caup.transaction.exception.TransactionException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.xwiki.component.annotation.ComponentRole;
import org.xwiki.component.phase.Initializable;
import org.xwiki.component.phase.InitializationException;

/**
 * Created by Caup
 * Author : Lai Trung Hieu
 *          hieulaitrung@gmail.com
 * May 12, 2012  
 */
@ComponentRole
public class TransactionManagerImpl implements TransactionManager, Initializable {

  private static final Logger LOG = Logger.getLogger(TransactionManagerImpl.class.getName());

  private SessionFactory sessionFactory;

  private TransactionSession currentSession;

  @Override
  public void initialize() throws InitializationException {
    try {
      // Create the SessionFactory from hibernate.cfg.xml
      this.sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
    } catch (Exception ex) {
      LOG.error("Failed to init session factory", ex);
    }
  }

  @Override
  public TransactionSession openSession() throws TransactionException {
    Session session = sessionFactory.openSession();
    currentSession = new TransactionSessionImpl();
    ((TransactionSessionImpl)currentSession).setHibernateSession(session);
    ((TransactionSessionImpl)currentSession).beginTransaction();
    return currentSession;
  }

  @Override
  public void closeSession() throws TransactionException {
    ((TransactionSessionImpl) currentSession).close();
  }

  @Override
  public TransactionSession getSession() {
    return currentSession;
  }

  @Override
  public void shutdown() {
    // Close caches and connection pools
    sessionFactory.close();
  }
}
