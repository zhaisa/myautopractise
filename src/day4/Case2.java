package day4;

import org.testng.annotations.Test;

public class Case2 {

	@Test
	public void test() {
		System.out.println("使用exclude，不包含本方法");
	}

	@Test
	public void c02_test02() {
		System.out.println("include这个方法");
	}
}
