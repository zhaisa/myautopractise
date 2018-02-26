package cases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.TestBase;

/**
 * 本case是在ecshop系统中提交留言的功能
 * 
 * @author Administrator
 *
 */
public class Case2 extends TestBase {
	@Test
	public void case02() {
		driver.get("http://www.huicewang.com/ecshop/");
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("留言板")).click();// 点击首页上的留言板按钮
		driver.findElement(By.name("user_email")).sendKeys("123@163.com");// 填邮箱
		driver.findElement(By.xpath("//input[@name='msg_type' and @value='1']")).click();// 点[投诉]单选按钮
		driver.findElement(By.name("msg_title")).sendKeys("我要投诉");// 填标题
		driver.findElement(By.name("msg_content")).sendKeys("上午上课桌面老是断，请速解决！");// 填内容
		driver.findElement(By.className("bnt_blue_1")).click();// 点提交按钮
		
		String promtText = driver.findElement(By.xpath("//div[@class='boxCenterList RelaArticle']//p")).getText();
		// 上一行代码中的xpath是通过用LR录脚本，然后从响应信息里找到的，
		// 因为提示"您的留言已成功发表"这个页面总是一闪而过，我从页面找不到这个xpath，所以使用了这个曲折的办法
		cp.contains(promtText, "您的留言已成功发表", "发表留言失败！");
		cp.result("发表留言功能正常！");
	}
}
