package listener;

import java.util.Iterator;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

/**
 * 本类是自定义的监听类，定制了测试开始、过程中、结束时的一些功能方法
 * 
 * @author Administrator
 *
 */
public class MyExecutionListener implements ITestListener {

	@Override
	public void onFinish(ITestContext context) {// 这个结束是整个测试完成之后执行的方法
		// 下面这几行代码是对失败用例做了去重
		Iterator<ITestResult> listOfFailedTests = context.getFailedTests().getAllResults().iterator();// 这个得到的是所有的失败test，包括重跑的
		while (listOfFailedTests.hasNext()) {
			ITestResult failedTest = listOfFailedTests.next();// 这个是单个的失败test
			ITestNGMethod method = failedTest.getMethod();// 这个是由失败test得到的method
			if (context.getFailedTests().getResults(method).size() > 1) {
				listOfFailedTests.remove();// 如果从context中得到的失败Tests中得到的method数量大于1，就将其从list中去除掉
			}
		}
		
		System.out.println(context.getPassedTests().size());// 这3行是测试完成后的通过、失败、跳过的用例数
		System.out.println(context.getFailedTests().size());// 失败的用例数已去重
		System.out.println(context.getSkippedTests().size());
	}

	@Override
	public void onStart(ITestContext context) {// 这个开始是指在整个测试开始之前就执行的方法（连driver都没启之前）
		System.out.println("测试开始执行，为所有测试用例添加失败重跑机制！");
		for (ITestNGMethod method : context.getAllTestMethods()) {// 遍历所有的方法
			method.setRetryAnalyzer(new TestRetryAnalyzer());// 每遍历一个方法，就给这个方法添加失败重跑
			System.out.println(method.getMethodName() + "-->set retry");// 并打印这个方法名+set
																		// retry
		}
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

	}

	@Override
	public void onTestFailure(ITestResult arg0) {

	}

	@Override
	public void onTestSkipped(ITestResult arg0) {

	}

	@Override
	public void onTestStart(ITestResult arg0) {// 而这个开始是指，每个@Test开始之前就会执行的方法
		System.out.println("TestStart");
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {

	}

}
