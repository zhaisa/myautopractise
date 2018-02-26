package day5;

import java.util.List;

import org.dom4j.Element;
import org.testng.annotations.DataProvider;

import utils.XmlParser_zhengshi;

public class DemoDataProvider {
	// 数据提供者
	@DataProvider(name = "data") // 可为DataProvider起别名，别人调用时写该别名就能调
	public static Object[][] getData() {
		return new Object[][] { new Object[] { 1, 2 }, new Object[] { 3, 4 } };
	}

	@DataProvider(name = "user")
	public static Object[][] getUser() {
		XmlParser_zhengshi xp = new XmlParser_zhengshi("demo2_dengluzhanghu.xml");
		List<Element> elements = xp.getElements("/data/case01");// 这行获得的是有几个case01
		Object[][] object = new Object[elements.size()][];// 第一维：case01的个数
		for (int i = 0; i < elements.size(); i++) {// 遍历所有case01
			Object[] temp = new Object[] { xp.getChildrenInfoByElement(elements.get(i)) };// 将case01这个元素传给xp.getChildrenInfoByElement，通过这个方法得到case01下的所有一级子节点的name和text
			object[i] = temp;// 这个object[i]的值就是上面那个二维数组的第二维
		}
		return object;
	}
}
