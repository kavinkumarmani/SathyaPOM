package in.sathya.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import in.sathya.base.Baseclass;

public class Laptopspage extends Baseclass {
	
	@FindBy(xpath="//span[text()='HP']")
	WebElement HPlaptops;
	
	@FindBy(xpath="//a[contains(text(),'Processor Type')]")
	WebElement ProcessorType;
	
	@FindBy(xpath="//span[contains(text(),'Intel Core i7')]")
	WebElement Processor;
	
	@FindBy(xpath="//span[contains(text(),'up to ₹ 1,75,000.00')]")
	WebElement pricelimit;

	public Laptopspage() throws Exception {
		PageFactory.initElements(driver, this);
	}
	
	public HPLaptopspage clickonHPlaptops() throws Exception {
		Thread.sleep(5000);
		HPlaptops.click();
		Thread.sleep(4000);
		ProcessorType.click();
		Thread.sleep(3000);
		Processor.click();
		Thread.sleep(3000);
		//driver.navigate().refresh();
		pricelimit.click();
		return new HPLaptopspage();
	}

}
