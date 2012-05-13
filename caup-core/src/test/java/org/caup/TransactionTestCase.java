/*
 * Copyright (C) 2003-2012 Caup
 */
package org.caup;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.caup.test.AbstractTestCase;
import org.caup.transaction.TransactionManager;
import org.caup.transaction.TransactionSession;
import org.caup.transaction.exception.TransactionException;

/**
 * Created by Caup
 * Author : Lai Trung Hieu
 *          hieulaitrung@gmail.com
 * May 13, 2012  
 */
public class TransactionTestCase extends AbstractTestCase {
  
  private TransactionManager txManager;

  @Override
  protected void setUp() throws Exception {
    super.setUp();
    txManager = componentManager.lookup(TransactionManager.class);
  }
  
  public void testTransActionManager() throws TransactionException{
    TransactionSession session = txManager.openSession();
    Dummy dummy = new Dummy();
    dummy.setName("dummy");
    dummy.setCreatedDate(new Date());
    dummy.setCode("1");

    // Save an entity
    session.save(dummy);
    session.commit();

    // Up date an entity
    dummy.setCode("2");
    session.refresh(dummy);
    assertEquals("1", dummy.getCode());
    dummy.setCode("2");
    session.update(dummy);
    session.commit();

    // Query an entity
    List<Dummy> list = session.createQuery(String.format("from Dummy where name='%s'", "dummy")).list();
    assertEquals(1, list.size());
    assertEquals("2", list.get(0).getCode());

    // Delete an entity
    session.delete(dummy);
    session.commit();
    Iterator<Dummy> iter = session.createQuery(String.format("from Dummy where name='%s'", "dummy")).iterate();
    assertEquals(false, iter.hasNext());

    session.close();
  }
  
}
