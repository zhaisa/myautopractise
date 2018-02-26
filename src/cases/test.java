package cases;

import java.util.Map;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import base.API;
import base.CheckPoint;
import base.DriverFactory;
import pages.LoginPage;

public class test {

	public static void main(String[] args) {
		WebDriver wd=DriverFactory.getDriver("firefox");
		API api=new API(wd);
		CheckPoint cp=new CheckPoint();
		
		wd.get("http://www.huicewang.com/ecshop/user.php");// 进入登录页面
		wd.manage().window().maximize();
		LoginPage lp = PageFactory.initElements(wd, LoginPage.class);// 实例化一个LoginPage对象
		lp.loginAction("bulanni", "123456");// 输入用户名、密码，登录
		
		String orderID="2018020563742";
//		String orderID=null;
		Map<String, String> map=api.searchOrderInfo(orderID);
		cp.assertNotEquals(orderID, null, "下单失败");
		cp.equals(orderID, "2018020563744", "订单不一样");
		Set<String> set=map.keySet();
		for (String string : set) {
			System.out.println(map.get(string));
		}
	}

}
