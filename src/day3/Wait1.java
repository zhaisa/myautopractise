package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait1 {

	// 1.普通线程等待，传进来的是一个秒数
	public static void wait(int seconds) {
		int millis = seconds * 1000;
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("当前线程正处于等待状态！");
		}
	}

	// 2.智能等待（等到某元素出现就不等了，最长等XX秒），返回值是一个WebElement
	public static WebElement waitForElement(WebDriver driver, final By by, int timeOut) {
		WebElement e = null;
		try {
			e = new WebDriverWait(driver, timeOut).until(new ExpectedCondition<WebElement>() {
				@Override
				public WebElement apply(WebDriver driver) {
					return driver.findElement(by);
				}
			});
		} catch (Exception e1) {
			e1.printStackTrace();
			System.out.println(by + "等待" + timeOut + "秒后未出现！");
		}
		return e;
	}

	// 3.智能等待（判断一个元素是否存在），返回值是一个布尔类型
	public static boolean elementIsPresent(WebDriver driver, final By by, int timeOut) {
		return new WebDriverWait(driver, timeOut).until(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					driver.findElement(by);
					return true;
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
			}
		});
	}

	// 4.智能等待（判断多个元素是否存在），返回值是一个布尔类型
	public static boolean elementsIsPresent(WebDriver driver, final By by, int timeOut) {
		return new WebDriverWait(driver, timeOut).until(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				if (driver.findElements(by).size() > 0) {
					return true;
				} else {
					return false;
				}
			}
		});
	}

	// 5.智能等待（判断页面是否加载完成），firefox可能不支持
	public static boolean waitForPageLoad(WebDriver driver, int timeOut) {
		return new WebDriverWait(driver, timeOut).until(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("retuen document.readyState").equals("complete");
			}
		});
	}

}
