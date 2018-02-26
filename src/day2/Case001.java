package day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import base.DriverFactory;

public class Case001 {

	public static void main(String[] args) {
		WebDriver driver = DriverFactory.getDriver("FIREFOX");
		driver.get("http://www.huicewang.com/ecshop/");

		// 1.搜索区-下拉框，选【GSM手机】
		WebElement e = driver.findElement(By.id("category"));
		Select s = new Select(e);
		s.selectByValue("3");

		// 2.搜索区-输入框，填【诺基亚】
		WebElement e2 = driver.findElement(By.id("keyword"));
		e2.sendKeys("诺基亚");

		// 3.搜索区-搜索按钮-点击
		driver.findElement(By.name("imageField")).click();

		List<WebElement> list = driver.findElements(By.xpath("//div[@class='goodsItem']"));
		if (list.size() > 0) {
			System.out.println("测试通过！");
		} else {
			System.out.println("测试失败！");
		}
	}

}
