package day4;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Case3 {

	@Test
	@Parameters("desc")
	public void test(String desc) {
		System.out.println(desc + "：本类只有一个方法");
	}
}
