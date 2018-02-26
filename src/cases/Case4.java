package cases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.TestBase;

/**
 * 本case实现对[首页-精品推荐区-所有商品价格]的遍历验证的功能
 * @author Administrator
 *
 */
public class Case4 extends TestBase {

	@Test
	public void demo() {
		driver.get("http://www.huicewang.com/ecshop/index.php");
		driver.manage().window().maximize();
		api.scrollToBottom();

		List<WebElement> goodsTab = driver.findElements(By.xpath("//div[@id='itemBest']/h2/a"));// 首页的商品展示区的Tab页签
		for (WebElement tab : goodsTab) {
			tab.click();
			api.wait(1);
			/**
			 * 下面这行代码的作用：传入的参数是一个by对象
			 * 1.这是每个页签内的所有商品价格的集合
			 * 2.为商品的价格new一个容器
			 * 3.将商品价格加进容器中，返回
			 */
			List<String> goodsPrice = api.getElementsText(By.xpath("//div[@id='show_best_area']/div[@class='goodsItem']/font"));
			cp.notEquals(goodsPrice, null, "商品价格异常：null！");
			cp.notEquals(goodsPrice, " ", "商品价格异常：\" \"！");
		}
		cp.result("首页-精品推荐区-所有商品价格无null值！");
	}
}
