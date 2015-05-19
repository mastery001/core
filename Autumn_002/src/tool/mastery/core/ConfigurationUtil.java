package tool.mastery.core;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.dom4j.DocumentException;
import org.dom4j.Element;

import tool.mastery.dom.ReadXmlUtils;
import tool.mastery.dom.RebuildDocument;

/**
 * 配置工具类，通过配置从xml或者properties中获取内容
 * 
 * @author mastery
 * @Time 2015-3-11 下午12:57:10
 * 
 */
public class ConfigurationUtil {

	public static Properties configByProperties(String fileName)
			throws IOException {
		InputStream is = ToolKit.getResourceAsStream(fileName);
		Properties prop = new Properties();
		try {
			prop.load(is);
		} catch (IOException e) {
			ToolKit.close(is);
			throw e;
		}
		return prop;
	}

	public static Element configByXml(RebuildDocument rd, String fileName)
			throws DocumentException {
		Element rootElement = ReadXmlUtils.getRootElementByPath(fileName);
		if(rd != null) {
			rootElement = rd.rebuildDocument(rootElement);
		}
		return rootElement;
	}
}
