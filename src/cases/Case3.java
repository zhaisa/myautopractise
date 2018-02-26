package cases;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;

/**
 * 本case是在ecshop系统中下订单并且打印订单信息的功能
 * @author Administrator
 *
 */
public class Case3 extends TestBase {

	@Test
	public void order() {
		String baseUrl = "http://www.huicewang.com/ecshop/";
		String orderID = null;
		
		// 1.登录
		driver.get(baseUrl + "user.php");// 进入登录页面
		driver.manage().window().maximize();
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);// 实例化一个LoginPage对象
		lp.loginAction("bulanni", "123456");// 输入用户名、密码，登录
		
		// 2.搜索商品
		api.selectByValue(By.id("category"), "3");// 搜索下拉框内选择【GSM手机】
		driver.findElement(By.id("keyword")).sendKeys("诺基亚");// 搜索框内输入【诺基亚】
		driver.findElement(By.name("imageField")).click();// 点击搜索按钮

		// 3.下订单并打印订单信息
		List<WebElement> goodsList = driver.findElements(By.xpath("//div[@class='goodsItem']"));// 进入商品列表页，找到所有搜索出的商品并放进list中
		if (goodsList.size() > 0) {
			WebElement good1 = goodsList.get(0);// 商品列表中的第一个商品
			good1.findElement(By.linkText("购买")).click();// 点第一个商品的[购买]按钮
			api.wait(1);
			driver.findElement(By.xpath("//div[@id='speDiv']/center/a[contains(text(),'购买')]")).click();// 点击弹窗的的[购买]按钮
			api.wait(1);
			driver.findElement(By.xpath("//a[@href='flow.php?step=checkout']")).click();// 点击“结算中心”按钮
			// 要想使用脚本自动化下单，必须之前下单成功过，因为有个填收货地址的页面必须之前下过单系统才会记住，以后下单时就不用再填了
			driver.findElements(By.name("shipping")).get(0).click();// 配送方式选“申通快递”
			driver.findElements(By.name("payment")).get(1).click();// 支付方式选“银行汇款/转帐”
			driver.findElement(By.xpath("//input[@type='image']")).click();// 点击“提交订单”按钮
			orderID = driver.findElement(By.xpath("//div[@class='flowBox']/h6/font")).getText().trim();// trim()方法用来去除字符串的首尾空格

			// assertEquals方法判断[实际结果]和[预期结果]不一致就是错的，而assertNotEquals判断[实际结果]和[预期结果]一致就是错的
			cp.assertNotEquals(orderID, null, "下单失败");// 如果实际结果为null就走失败，如果实际结果是一个订单号就走成功
			Map<String, String> orderInfo = api.searchOrderInfo(orderID);
			System.out.println(orderInfo);
		} else {
			cp.isFailed("未搜索到产品，无法下单！");
		}
		cp.result("下单成功，用户中心已生成订单号：" + orderID);
	}

}
