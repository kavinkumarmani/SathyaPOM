package in.sathya.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import in.sathya.base.Baseclass;

public class ProductOrderpage extends Baseclass {
	@FindBy(xpath="//span[contains(text(),'Add to cart')]")
	WebElement Addcart;
	@FindBy(xpath="//span[contains(text(),'Checkout')]")
	WebElement checkout;
	
	public ProductOrderpage() throws Exception {
		PageFactory.initElements(driver, this);
	}
	
	public void selectproduct() {
		List<WebElement>totalproduct=driver.findElements(By.xpath("//article[@class='art']"));
		int totalavail=totalproduct.size();
		for(int i=0;i<totalavail;i++) {	
			driver.findElement(By.xpath("(//article[@class='art'])["+(i+1)+"]")).click();
			try {
				Addcart.click();
				checkout.click();
				break;
				}
			catch(Exception e) {
				System.out.println("Requested product currently not available");;
				driver.navigate().back();
			}
		}
	}
}




