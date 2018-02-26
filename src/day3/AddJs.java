package day3;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 * 添加执行JS脚本
 * @author Administrator
 *
 */
public class AddJs {
	
	// 1.添加js脚本
	private static void addJS(WebDriver driver, String jsCodes) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript(jsCodes);
	}
	public static void scrollToBottom(WebDriver driver) {// 滚屏到底部
		addJS(driver, "scrollTo(0, 10000);");
	}
	
	// 2.移除input输入框的只读属性
	public static void removeReadOnly(WebDriver driver, String id) {
		String jsCodes = "document.getElementById(\"" + id + "\").removeAttribute(\"readonly\");";// document.getElementById("id").removeAttribute("readonly");
		addJS(driver, jsCodes);
	}
}
