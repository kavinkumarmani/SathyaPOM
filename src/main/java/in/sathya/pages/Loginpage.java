package in.sathya.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import in.sathya.base.Baseclass;

public class Loginpage extends Baseclass {
	
	//pagefactory or object repository
	@FindBy(xpath="(//span[contains(text(),'Log in')])[1]")
	WebElement signin;
	
	@FindBy(name="Email")
	WebElement username;
	
	@FindBy(name="Password")
	WebElement password;
	
	@FindBy(xpath="//button[@class='btn btn-primary btn-lg btn-block btn-login']")
	WebElement loginbutton;
	
	//initilization
	public Loginpage() throws Exception {
		PageFactory.initElements(driver, this);
	}
	
	//action
	public Homepage login(String emailid,String pwd) throws Exception {
		signin.click();
		username.sendKeys(emailid);
		password.sendKeys(pwd);
		loginbutton.click();
		return new Homepage();
	}

	public String validatepagetitle() {
		return driver.getTitle();
	}
}
