package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

	@FindBy(how=How.NAME,using="username")
	WebElement loginname;
	
	@FindBy(how=How.NAME,using="password")
	WebElement password;
	
	WebElement submit;
	
	public void loginAction(String name,String pwd){
		loginname.sendKeys(name);
		password.sendKeys(pwd);
		submit.click();
	}
}
