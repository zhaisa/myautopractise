package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.DriverFactory;
import pages.LoginPage;

public class test {

	public static void main(String[] args) {
		WebDriver driver = DriverFactory.getDriver("FIREFOX");
		driver.get("http://www.huicewang.com/ecshop/user.php");
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		lp.loginAction("bulanni", "123456");

		// 1.搜索区-下拉框，随机选择一个分类
		// WebElement e = driver.findElement(By.id("category"));
		// RandomSelect.doRandomSelect(e, 5);

		// 2.点击首页上部-Tab页签
		// TabText.clickTab(driver, "团购商品");
	}

}
