package day4;

import org.testng.annotations.Test;

public class Case1 {

	@Test
	public void test() {
		System.out.println("case01");
	}

	@Test
	public void c01_test02() {
		System.out.println("使用include，包含这个方法");
	}

	// 对应CheckPoint里的场景一
	// @Test
	// public void test1(){
	// CheckPoint.equals(0, 1);
	// }

	// 对应CheckPoint里的场景二
	// @Test
	// public void test1(){
	// CheckPoint checkPoint=new CheckPoint();
	// checkPoint.equals(0, 2);
	// checkPoint.equals(0, 0);
	// checkPoint.result("");
	// }
}
