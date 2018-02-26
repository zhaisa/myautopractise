package day5;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 本类是解析xml文件的工具类
 * 
 * @author Administrator
 *
 */
public class XmlParser {

	public XmlParser(String xmlPath) {
		File xmlFile = new File(xmlPath);
		SAXReader sr = new SAXReader();
		try {
			Document d = sr.read(xmlFile);
			
			/*1.获取根节点的name
			Element e = d.getRootElement();// 找到根节点
			System.out.println(e.getName());//获取根节点的name
			*/
			
			/*2.获取多个节点及其值
			List<Element> books = d.selectNodes("//book");
			for (Element book : books) {
				System.out.println(book.attribute("category").getValue());
			}*/
			
			/*3.获取单个节点及其值
			Node node = d.selectSingleNode("//title[text()='Harry Potter']/../author");
			System.out.println(node.getText());
			*/
			
			Element e = (Element) d.selectSingleNode("//title[text()='Harry Potter']/..");
			List<Element> list = e.elements();
			for (Element element : list) {
				System.out.println(element.getText());
			}

		} catch (DocumentException e) {
			e.printStackTrace();
			System.out.println("xml文件加载异常！");
		}
	}
}
