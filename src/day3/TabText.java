package day3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * 本类是实现通过页面内页签名进行点击的方法的封装
 * 
 * @author Administrator
 *
 */
public class TabText {

	public static void clickTab(WebDriver driver, String linkName) {
		List<WebElement> list = driver.findElements(By.xpath("//div[@id='mainNav']/a"));
		System.out.println(list.size());
		for (WebElement e : list) {
			if (e.getText().equals(linkName)) {
				e.click();
				break;
			}
		}
	}
}
