package in.sathya.test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import in.sathya.base.Baseclass;
import in.sathya.pages.HPLaptopspage;
import in.sathya.pages.Homepage;
import in.sathya.pages.Laptopspage;
import in.sathya.pages.Loginpage;

public class HPLaptopspagetest extends Baseclass{
	Loginpage loginpage;
	Homepage homepage;
	Laptopspage laptopspage;
	HPLaptopspage hplaptopspage;
	
	public HPLaptopspagetest() throws Exception {
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
	}
	@Test(priority=1)
	public void IndividualLaptoptest() throws Exception {
		hplaptopspage.clickonHPlaptops();
	}
	@AfterMethod
	public void teardown() {
	driver.quit();
	}
}



