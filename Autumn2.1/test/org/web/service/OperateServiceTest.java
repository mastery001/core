package org.web.service;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.web.exception.BeanInitializationException;
import org.web.exception.ErrorException;

import tool.mastery.core.CollectionUtil;

public class OperateServiceTest {

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
	public void testExecute() throws BeanInitializationException, ErrorException {
		OperateService service = new DefaultOperateService();
		service.execute(CollectionUtil.convertObjectToList(new Object()), "add");
	}

}
