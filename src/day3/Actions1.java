package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import base.DriverFactory;

public class Actions1 {
	public static WebDriver driver = DriverFactory.getDriver("firefox");
	
	public static void main(String[] args) throws InterruptedException {
		// 1.鼠标操作
//		mouseActions();
		
		// 2.键盘操作
		keyBoardActions();
	}
	
	// 1.鼠标操作
	public static void mouseActions(){
		String url = "file:///C:/Users/Administrator/Desktop/demo.html";
		driver.get(url);
		driver.manage().window().maximize();
		Actions a = new Actions(driver);

		// 1.单一操作
//		a.click(driver.findElement(By.linkText("baidu"))).perform();

		// 2.组合操作，方式一
//		((JavascriptExecutor) driver).executeScript("scrollTo(0, 3000)");// 利用js脚本执行滚屏操作
//		WebElement e = driver.findElement(By.className("over"));
//		a.moveToElement(e);
//		Thread.sleep(2000);
//		a.click(e);
//		a.perform();// perform是必须写的，不写前面的操作是执行不了的
		
		// 3.组合操作，方式三
		((JavascriptExecutor) driver).executeScript("scrollTo(0, 3000)");// 利用js脚本执行滚屏操作
		WebElement e = driver.findElement(By.className("over"));
		a.moveToElement(e).click(e).build().perform();
		
//		driver.close();
//		driver.quit();
	}
	
	// 2.键盘操作
	public static void keyBoardActions(){
		driver.get("https://www.baidu.com");
		WebElement e = driver.findElement(By.id("kw"));
		e.click();
		driver.manage().window().maximize();
		Actions a = new Actions(driver);
		a.sendKeys("慧测");// 搜索框输入数据
		a.sendKeys(Keys.ENTER);// 按回车键
		a.sendKeys(Keys.CONTROL + "a");// 组合快捷键，全选
		a.perform();
	}

}
