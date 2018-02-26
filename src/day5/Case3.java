package day5;

import java.util.Map;
import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.CheckPoint;

/**
 * 数据驱动，@DataProvider的使用
 * 
 * @author Administrator
 *
 */
public class Case3 {
	// @Test(dataProvider = "getData") // 调数据提供者的方法或别名
	public void test(int a, int b) {
		System.out.println(a + b);
	}

	// @Test(dataProviderClass = DemoDataProvider.class, dataProvider = "data")
	public void test1(int a, int b) {
		System.out.println(a * b);
	}

	// @Test(dataProviderClass = DemoDataProvider.class, dataProvider = "user")
	public void test2(Map<String, String> data) {
		System.out.println(data.get("username"));
		System.out.println(data.get("pwd"));
	}

	// 自定义的失败重跑机制的测试
	@Test(retryAnalyzer = listener.TestRetryAnalyzer.class)
	public void test3() {
		System.out.println("run retryAnalyzer");
		CheckPoint cp = new CheckPoint();
		for (int i = 0; i < 10; i++) {
			cp.equals(new Random().nextInt(2), 0);
		}
		cp.result("验证成功！");
	}

	// 数据提供者
	@DataProvider
	public static Object[][] getData() {
		return new Object[][] { new Object[] { 1, 2 }, new Object[] { 3, 4 } };
	}
}
