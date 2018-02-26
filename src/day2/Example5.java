package day2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import base.DriverFactory;

/**
 * 浏览器页面及窗口的操作方法
 * @author Administrator
 *
 */
public class Example5 {
	public static String url1 = "https://www.baidu.com";
	public static String url2 = "http://www.huicewang.com";
	public static WebDriver driver = DriverFactory.getDriver("firefox");

	public static void main(String[] args) {
		/*
		driver.get(url1);
		// 1.拿到上述网页的url地址
		System.out.println(driver.getCurrentUrl());

		// 2.获取页面源码
		// String pageSource = driver.getPageSource();
		// write("C:\\Users\\Administrator\\Desktop\\baiduPageSource.txt",
		// pageSource);

		// 3.获取页面的title
		System.out.println(driver.getTitle());
		*/
		
		// 4.页面导航，即页面的前后跳转
		driver.get(url1);
		driver.get(url2);
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().to(url1);
		
		// 5.
		driver.manage().window().maximize();// 浏览器窗口最大化
		driver.manage().window().fullscreen();// 浏览器窗口全屏

		driver.close();
		driver.quit();
	}

	private static void write(String destPath, String pageSource) {
		File dest = new File(destPath);
		if (!dest.exists()) {
			try {
				dest.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("创建新文件失败！");
			}
		}

		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(dest));
			bw.write(pageSource);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("流输出失败！");
		} finally {
			try {
				bw.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("流关闭失败！");
				}
			}
		}
	}

}
