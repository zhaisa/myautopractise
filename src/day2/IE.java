package day2;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class IE {

	public static void main(String[] args) throws IOException {
		// 1.普通启动
//		System.setProperty("webdriver.ie.driver", "source/IEDriverServer.exe");
//		InternetExplorerDriver ied = new InternetExplorerDriver();
//		ied.get("https://www.baidu.com");
		
		// 2.指定端口启动
//		System.setProperty("webdriver.ie.driver", "source/IEDriverServer.exe");
//		InternetExplorerDriver ied = new InternetExplorerDriver(8888);
//		ied.get("https://www.baidu.com");
		
		// 3.设置浏览器属性，DesiredCapabilities
		// IE默认启动保护模式，要么手动在浏览器的设置中关闭保护模式，要么在代码中设置，
		// 但手动设置的只对本机有效，换了电脑就需要再进行设置，所以通过代码设置最好
//		System.setProperty("webdriver.ie.driver", "source/IEDriverServer.exe");
//		DesiredCapabilities dc = new DesiredCapabilities();
//		dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);// 刘则说这个是解决IE浏览器的版本兼容的问题的
//		dc.setCapability("ignoreProtectedModeSettings", true);// 关闭保护模式
//		InternetExplorerDriver ied = new InternetExplorerDriver(dc);
//		ied.get("https://www.baidu.com");
		
		// 4.利用Service设置启动参数
		InternetExplorerDriverService ieds = new InternetExplorerDriverService.Builder()
				.usingDriverExecutable(new File("source/IEDriverServer.exe"))
				.withLogFile(new File("myIELog")).usingPort(8888).build();
		ieds.start();
		InternetExplorerDriver ied = new InternetExplorerDriver(ieds);
		ied.get("https://www.baidu.com");
		ieds.stop();
	}

}
