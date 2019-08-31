

package in.sathya.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import in.sathya.base.Baseclass;

public class Homepage extends Baseclass {
	
	@FindBy(xpath="(//a[@class='nav-link dropdown-toggle'])[3]")
	WebElement Electronics;
	
	@FindBy(id="dropdown-heading-38")
	WebElement laptops;
	
	public Homepage() throws Exception {
		PageFactory.initElements(driver, this);
	}
	
	public Laptopspage clickonlaptops() throws Exception {
		Actions action=new Actions(driver);
		Thread.sleep(5000);
		action.moveToElement(Electronics).build().perform();
		Thread.sleep(5000);
		action.moveToElement(laptops).click().perform();
		return new Laptopspage();
	}

}
