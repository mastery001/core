package org.web.framework.action.support;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.web.framework.ConfigLibrary;

public class XmlConfigurationProviderTest {

	@Test
	public void testXmlConfigurationProvider() {
		XmlConfigurationProvider xcp = new XmlConfigurationProvider(
				ConfigLibrary.ACTIONXMLPATH);
		xcp.register();
	}

	@Test
	public void testRegister() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetConfig() {
		fail("Not yet implemented");
	}

}
