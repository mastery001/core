package org.web.dao.core.support;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.web.access.factory.DaoAdviceFactory;
import org.web.dao.core.DaoAdvice;
import org.web.exception.DBException;
import org.web.po.User;

public class AbstractPoDaoAdviceTest {

	@Test
	public void testAbstractPoDaoAdvice() throws DBException {
		User user = new User();
		user.setU_id("11");
		execute(user);
	}

	private void execute(Object obj) throws DBException {
		DaoAdvice dao = DaoAdviceFactory.getDao(obj.getClass().getSimpleName());
		dao.save(obj);
	}
	
	@Test
	public void testSave() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
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
