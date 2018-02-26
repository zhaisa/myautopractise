package day3;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import base.DriverFactory;

public class Cookies {

	public static void main(String[] args) {
		WebDriver driver = DriverFactory.getDriver("firefox");
		driver.get("http://www.huicewang.com/ecshop");
		addCookie(driver);
	}

	private static void addCookie(WebDriver driver) {
		Cookie cookie_username = new Cookie("ECS[username]", "bulanni");
		Cookie cookie_password = new Cookie("ECS[password]", "c7ae930865695e29683dd679ff1f2911");
		Cookie cookie_userid = new Cookie("ECS[user_id]", "153");
		driver.manage().addCookie(cookie_username);// 动态加载了这些cookie后，就能实现了自动登录的功能
		driver.manage().addCookie(cookie_password);
		driver.manage().addCookie(cookie_userid);
		driver.get("http://www.huicewang.com/ecshop");
		System.out.println(driver.manage().getCookies());
	}

}
