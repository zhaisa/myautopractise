package day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import base.DriverFactory;

public class Example6 {
	public static String url1 = "https://www.ctrip.com";
	public static WebDriver driver = DriverFactory.getDriver("firefox");

	public static void main(String[] args) {
		driver.get(url1);
		driver.manage().window().maximize();

		// 1.input，即输入框
		/*
		WebElement e = driver.findElement(By.id("_allSearchKeyword"));
		System.out.println(e.getText());// 获取输入框的文本值
		System.out.println(e.getAttribute("placeholder"));// 获取输入框的某属性
		driver.findElement(By.id("HD_TxtKeyword")).click();
		driver.findElement(By.id("HD_TxtKeyword")).clear();
		driver.findElement(By.id("HD_TxtKeyword")).sendKeys("丽江");
		*/

		// 2.a，即超链接
		/*
		WebElement e = driver.findElement(By.id("nav_hotel"));
		String href = e.getAttribute("href");// 获取这个元素的href属性（一个链接地址）
		System.out.println(href);
		driver.get(href);// 将上面获取到的地址直接driver.get，其作用就相当于driver.findElement(By.id("nav_hotel")).click()
		*/
		
		// 3.select，即下拉列表
		/*
		driver.findElement(By.id("nav_hotel")).click();
		WebElement we = driver.findElement(By.id("searchHotelLevelSelect"));
		Select s = new Select(we);
		s.selectByIndex(2);// 选列表中下标为2的，即列表的第3个选项
		s.selectByValue("2");// 选value值是2的选项
		s.selectByVisibleText("五星级/豪华");// 选择文本值为"五星级/豪华"的选项
		
		List<WebElement> elements = s.getOptions();// 把下拉框内的选项都拿到
		for (WebElement e : elements) {
			System.out.println(e.getText());
		}
		*/
		
		// 4.radiobox，即单选框
		/*
		driver.get("https://flights.ctrip.com");
		List<WebElement> elements = driver.findElements(By.name("FlightSearchType"));
		elements.get(2).click();
		boolean isSelected = elements.get(2).isSelected();// 判断上述单选项是否被点中
		System.out.println("上述单选项是否被点中：" + isSelected);
		*/
		
		// 5.checkbox，即复选框
		/*
		driver.get("https://flights.ctrip.com");
		List<WebElement> elements = driver.findElements(By.xpath("//input[@type='checkbox']"));
		elements.get(1).click();
		boolean isSelected = elements.get(1).isSelected();// 判断上述复选项是否被点中
		System.out.println("上述复选项是否被点中：" + isSelected);
		*/
		
		// 6.button，即按钮
		WebElement e = driver.findElement(By.id("HD_Btn"));
		boolean can = e.isEnabled();
		System.out.println("按钮是否可用：" + can);
		e.click();
		
//		driver.close();
//		driver.quit();
	}

}
