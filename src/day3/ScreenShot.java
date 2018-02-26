package day3;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {

	// 1.截图的方法，参数有driver和图片存放的位置
	private static void takeScreenShot(WebDriver driver, String destPath) {
		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(f, new File(destPath));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("截图异常！");
		}
	}

	// 2.截图的方法，参数只有driver，但本方法调用了方法1
	public static void takeScreenShot(WebDriver driver) {
		String nowTime = DateHandler.getNowTimeStr();
		String screenName = String.valueOf(nowTime + ".jpg");// 图片名称：即时间戳+.jpg
		File screenPath = new File("test-output/snapshot");// 图片将要存放的位置
		if (!screenPath.exists()) {
			screenPath.mkdirs();
		}
		String dest = screenPath.getAbsolutePath() + "/" + screenName;// 这是快照存放的路径+快照名
		takeScreenShot(driver, dest);// 调用上面那个方法
	}
}
