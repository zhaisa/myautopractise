package day3;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.API;
import base.DriverFactory;

/**
 * 关于页面跳转的一些操作
 * @author Administrator
 *
 */
public class Windows1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = DriverFactory.getDriver("firefox");
		String url = "file:///C:/Users/Administrator/Desktop/demo.html";
		driver.get(url);
		driver.manage().window().maximize();
		
		// 1.Alert，警告弹窗
//		driver.findElement(By.className("alert")).click();// 点出那个Alert弹窗
//		Alert alert = driver.switchTo().alert();// 切到那个Alert弹窗上
//		System.out.println(alert.getText());
//		Thread.sleep(2000);
//		alert.accept();// 确定关闭弹窗
		
		// 2.Iframe，页面中内嵌的窗口
//		driver.switchTo().frame(0);// 1.使用frame的索引
//		driver.switchTo().frame("aa");// 2.使用frame的名字
//		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='aa']")));// 3.使用frame的xpath
//		driver.findElement(By.id("user")).sendKeys("百度");
//		driver.switchTo().defaultContent();// 只切回退到该frame的上一层
		
		// 3.windows，页面窗口
//		String h = driver.getWindowHandle();// 获取一个窗口的句柄
//		System.out.println(h);
//		driver.findElement(By.linkText("Open huice")).click();
//		driver.findElement(By.linkText("Open baidu")).click();
//		switchLastWindow(driver);
//		driver.findElement(By.linkText("自动化测试")).click();
//		if(API.switchWindowByTitle(driver, "慧测")) {
//			driver.findElement(By.linkText("自动化测试")).click();
//		}
		
		// 4.滚屏
//		API.scrollToBottom(driver);
		
		// 5.去除只读属性
		API api = new API(driver);
		api.removeReadOnly("user");
	}
}
