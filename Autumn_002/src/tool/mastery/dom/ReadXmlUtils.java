package tool.mastery.dom;

import java.io.InputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import tool.mastery.core.ToolKit;

public class ReadXmlUtils {

	// dom4j中读取xml文件的类
	private static SAXReader saxReader;
	

	static {
		saxReader = new SAXReader();
	}

	private ReadXmlUtils() {
	}

	/**
	 * 通过路径来获取根节点
	 * 
	 * @param path
	 * @return
	 * @throws DocumentException
	 */
	public static Element getRootElementByPath(String path)
			throws DocumentException {
		return getRootElementByPath(ToolKit.getResourceAsStream(path));
	}

	/**
	 * 通过InputStream流来获取根节点
	 * 
	 * @param path
	 * @return
	 * @throws DocumentException
	 */
	public static Element getRootElementByPath(InputStream is)
			throws DocumentException {
		Document document = getDocument(is);
		Element rootElement = document.getRootElement();
		return rootElement;
	}

	/**
	 * 根据路径来返回xml文档的文档对象(document)
	 * 
	 * @param path
	 * @return
	 * @throws DocumentException
	 */
	@SuppressWarnings("unused")
	private static Document getDocument(String path) throws DocumentException {
		InputStream is = ToolKit.getResourceAsStream(path);
		return getDocument(is);
	}

	/**
	 * 根据路径来返回xml文档的文档对象(document)
	 * 
	 * @param path
	 * @return
	 */
	private static Document getDocument(InputStream is)
			throws DocumentException {
		Document document = null;

		try {
			document = saxReader.read(is);
		} catch (DocumentException e) {
			ToolKit.close(is);
			throw e;
		}
		return document;
	}
}
