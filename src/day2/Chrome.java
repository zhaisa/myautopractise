package day2;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome {

	public static void main(String[] args) throws IOException {
		// 1.普通启动
//		System.setProperty("webdriver.chrome.driver", "source/chromedriver.exe");
//		ChromeDriver cd = new ChromeDriver();
//		cd.get("https://www.baidu.com");
		
		// 2.加载插件
//		System.setProperty("webdriver.chrome.driver", "source/chromedriver.exe");
//		ChromeOptions co = new ChromeOptions();
//		co.addExtensions(new File("source/chrome-youtube-downloader-2.6.20.crx"));
//		ChromeDriver cd = new ChromeDriver(co);
//		cd.get("https://www.baidu.com");
		
		// 3.加载用户配置
//		System.setProperty("webdriver.chrome.driver", "source/chromedriver.exe");
//		File f = new File("C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\User Data");// chrome浏览器的配置文件
//		ChromeOptions co = new ChromeOptions();
//		co.addArguments("user-data-dir=" + f.getAbsolutePath());
//		co.addArguments("--test-type");
//		co.addArguments("start-maximized");// 使窗口最大化
//		ChromeDriver cd = new ChromeDriver(co);
//		cd.get("https://www.baidu.com");
		
		// 4.利用ChromeDriverService设置启动参数
		ChromeDriverService cds = new ChromeDriverService.Builder()// new一个chrome服务对象
				.usingDriverExecutable(new File("source/chromedriver.exe"))// 使用驱动
				.withLogFile(new File("myChromeLog")).usingPort(8888).build();// 1.保存日志至指定路径；2.指定端口
		cds.start();// 启动服务
		ChromeDriver cd = new ChromeDriver(cds);
		cd.get("https://www.baidu.com");
		cds.stop();// 关闭服务
	}

}
