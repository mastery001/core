package org.web.dao.core.support;

import static org.junit.Assert.*;

import org.junit.Test;
import org.web.access.factory.DaoAdviceFactory;
import org.web.exception.BeanInitializationException;
import org.web.exception.DBException;
import org.web.po.Article;

public class AbstractPoDaoAdviceTest {

	@Test
	public void testAbstractPoDaoAdvice() throws BeanInitializationException, DBException {
	}

	@Test
	public void testSetConnection() {
		fail("Not yet implemented");
	}

	@Test
	public void testSave() throws BeanInitializationException, DBException {
		Article a = new Article();
		a.setTitle("1");
		DaoAdviceFactory.getDao(a.getClass().getSimpleName()).save(a);
	}

	@Test
	public void testUpdate() throws BeanInitializationException, DBException {
		Article a = new Article();
		a.setA_id(14);
		a.setTitle("1");
		a.setContent("111");
		DaoAdviceFactory.getDao(a.getClass().getSimpleName()).update(a);
	}

	@Test
	public void testDelete() throws BeanInitializationException, DBException {
		Article a = new Article();
		a.setP_id(5);
		DaoAdviceFactory.getDao(a.getClass().getSimpleName()).delete(a);
	}

	@Test
	public void testQuery() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetResult() {
		fail("Not yet implemented");
	}

	@Test
	public void testGet() {
		fail("Not yet implemented");
	}

	@Test
	public void testContainsEntity() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaveBeforeQuery() {
		fail("Not yet implemented");
	}

}
