package org.web.dao.core.support;

import org.junit.Test;
import org.web.access.factory.DaoAdviceFactory;
import org.web.vo.Hazards;

public class HazardsDaoTest {

	@Test
	public void test() throws Throwable {
		Hazards obj = new Hazards();
		obj.setB_name("11");
		DaoAdviceFactory.getDao(obj.getClass().getSimpleName()).save(obj);
	}
}
