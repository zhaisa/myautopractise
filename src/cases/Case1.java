package cases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.TestBase;

/**
 * 本case是在ecshop首页搜索诺基亚手机的功能
 * 
 * @author Administrator
 *
 */
public class Case1 extends TestBase {

	@Test
	public void case1() {
		driver.get("http://www.huicewang.com/ecshop/");
		driver.manage().window().maximize();

		api.selectByValue(By.id("category"), "3");// 搜索下拉框内选择【GSM手机】
		driver.findElement(By.id("keyword")).sendKeys("诺基亚");// 搜索框内输入【诺基亚】
		driver.findElement(By.name("imageField")).click();// 点击搜索按钮

		cp.equals(api.elementsIsPresent(By.xpath("//div[@class='goodsItem']")), true, "未搜索到商品：GSM-诺基亚！");
		cp.result("首页搜索功能正常！");
	}

}
