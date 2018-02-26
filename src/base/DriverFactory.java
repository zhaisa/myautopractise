package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {
	private DriverFactory() {
	}

	private static WebDriver driver = null;

	public static synchronized WebDriver getDriver(String type) {
		if (driver == null) {
			driver = createDriver(type);
		}
		return driver;
	}

	private static WebDriver createDriver(String type) {
		switch (type.toLowerCase()) {
		case "firefox":
			driver = createFirefoxDriver();
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "source/chromedriver.exe");
			driver = createChromeDriver();
			break;
		case "ie":
			System.setProperty("webdriver.ie.driver", "source/IEDriverServer.exe");
			driver = createInternetExplorerDriver();
			break;
		default:
			System.out.println("Error: Invalid Browser Type!");
			break;
		}
		
		return driver;
	}

	private static WebDriver createInternetExplorerDriver() {
		return new InternetExplorerDriver();
	}

	private static WebDriver createChromeDriver() {
		return new ChromeDriver();
	}

	private static WebDriver createFirefoxDriver() {
		return new FirefoxDriver();
	}
}
