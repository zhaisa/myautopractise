package day3;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.DriverFactory;

public class ExpectedConditions1 {

	public static void main(String[] args) {
		WebDriver driver = DriverFactory.getDriver("firefox");
		driver.get("https://www.baidu.com");
//		System.out.println(titleIs(driver, "百度一下，你就知道"));
		System.out.println(elementsIsPresent(driver, By.id("css_index")));
	}

	// 1.利用ExpectedConditions已经封装好的方法，判断title是否符合预期值
	public static boolean titleIs(WebDriver driver, String title) {
		return ExpectedConditions.titleIs(title).apply(driver);
	}

	// 2.利用ExpectedConditions已经封装好的方法，判断alert是否存在
	public static Alert alertIsPresent(WebDriver driver) {
		return ExpectedConditions.alertIsPresent().apply(driver);
	}

	// 3.自定义ExpectedConditions，实现判断多对象是否存在
	private static ExpectedCondition<Boolean> elementsIs(final By by) {
		return new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				if (driver.findElements(by).size() > 0) {
					return true;
				}
				return false;
			}
		};
	}

	public static boolean elementsIsPresent(WebDriver driver, By by) {
		return elementsIs(by).apply(driver);
	}

}
