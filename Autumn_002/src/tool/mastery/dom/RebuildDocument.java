package tool.mastery.dom;

import org.dom4j.DocumentException;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;

/**
 * 若有需要则需对xml进行重建
 * @author mastery
 * @Time 2015-3-11 下午6:59:57
 * 
 */
public interface RebuildDocument {

	static final DocumentFactory DF = new DocumentFactory();

	public Element rebuildDocument(Element rootElement)
			throws DocumentException;

}
