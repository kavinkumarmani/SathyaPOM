package in.sathya.test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import in.sathya.base.Baseclass;
import in.sathya.pages.HPLaptopspage;
import in.sathya.pages.Homepage;
import in.sathya.pages.Laptopspage;
import in.sathya.pages.Loginpage;
import in.sathya.pages.ProductOrderpage;
import in.sathya.utilities.Datautilities;

public class ProductOrdertest extends Baseclass {
	Loginpage loginpage;
	Homepage homepage;
	Laptopspage laptopspage;
	HPLaptopspage hplaptopspage;
	ProductOrderpage productorderpage;
	
	public ProductOrdertest() throws Exception {
		super();
	}
	
	@BeforeMethod
	public void setup() throws Exception {
		initilization();
		loginpage=new Loginpage();
		homepage=new Homepage();
		homepage=loginpage.login(prop.getProperty("emailid"), prop.getProperty("password"));
		laptopspage=new Laptopspage();
		laptopspage=homepage.clickonlaptops();
		hplaptopspage=new HPLaptopspage();
		hplaptopspage=laptopspage.clickonHPlaptops();
		productorderpage=new ProductOrderpage();
	}
	
	@DataProvider
	public Object[][] getdata() throws Exception {
	Object[][] data=Datautilities.getexceldata();
	return data;
	}

	
	@Test(dataProvider="getdata")
	public void Orderproduct(String FIRSTNAME,String LASTNAME,String ADDRESS,String CITY,String ZIPCODE,String EMAIL,String PHONENUMBER) throws Exception {
		
		productorderpage.selectproduct();
		driver.findElement(By.id("NewAddress_FirstName")).sendKeys(FIRSTNAME);
		driver.findElement(By.id("NewAddress_LastName")).sendKeys(LASTNAME);
		driver.findElement(By.id("NewAddress_Address1")).sendKeys(ADDRESS);
		driver.findElement(By.id("NewAddress_City")).sendKeys(CITY);
		driver.findElement(By.id("NewAddress_ZipPostalCode")).sendKeys(ZIPCODE);
		Select select=new Select(driver.findElement(By.id("NewAddress_CountryId")));
		select.selectByVisibleText("India");
		driver.findElement(By.id("NewAddress_Email")).sendKeys(EMAIL);
		driver.findElement(By.id("NewAddress_PhoneNumber")).sendKeys(PHONENUMBER);
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Ship to this address')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}

