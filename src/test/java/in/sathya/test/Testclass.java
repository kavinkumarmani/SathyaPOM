package in.sathya.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import in.sathya.base.Baseclass;
import in.sathya.pages.HPLaptopspage;
import in.sathya.pages.Homepage;
import in.sathya.pages.Laptopspage;
import in.sathya.pages.Loginpage;
import in.sathya.utilities.Datautilities;

public class Testclass extends Baseclass {
	
	Loginpage loginpage;
	Homepage homepage;
	SoftAssert sa;
	Laptopspage laptopspage;
	HPLaptopspage hplaptopspage;
	

	public Testclass() throws Exception {
		super();
	}
	
	@BeforeMethod
	public void setup() throws Exception {
		initilization();
		loginpage=new Loginpage();
		homepage=new Homepage();
		laptopspage=new Laptopspage();
		hplaptopspage=new HPLaptopspage();
	}
		
	@Test(priority=1,groups="title")
	public void logintest() throws Exception{
		homepage=loginpage.login(prop.getProperty("emailid"), prop.getProperty("password"));
	}
	
	@Test(priority=2)
	public void clickonlaptopstest() throws Exception {
		laptopspage=homepage.clickonlaptops();
	}
	@Test(priority=3)
	public void clickonHPlaptops() throws Exception {
		homepage=loginpage.login(prop.getProperty("emailid"), prop.getProperty("password"));
		laptopspage=homepage.clickonlaptops();
		hplaptopspage=laptopspage.clickonHPlaptops();
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
