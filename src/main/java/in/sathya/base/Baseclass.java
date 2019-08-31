package in.sathya.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Baseclass {
	
	public static WebDriver driver;
	public static Properties prop;
	public static XSSFSheet sheet;
	public static XSSFWorkbook wb;
	public static FileOutputStream out;
	
public Baseclass() throws Exception {
	
	prop=new Properties();
	FileInputStream fis=new FileInputStream("C:\\Users\\Saran\\eclipse-workspace\\Sathyaproject\\src\\main\\java\\in\\sathya\\environmentvariables\\in.properties");
	prop.load(fis);
	
	//excelwrite
	File src = new File("C:\\Users\\Saran\\eclipse-workspace\\Sathyaproject\\src\\main\\java\\in\\sathya\\exceldata\\HPLaptopdetails.xlsx");
	src.createNewFile();
	out = new FileOutputStream(src);
	wb=new XSSFWorkbook();
	sheet = wb.createSheet("HPlaptop details");
	
	}
	
public static void initilization() {
	
	String browsername=prop.getProperty("browser");
	if(browsername.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Saran\\Downloads\\selenium\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	else if(browsername.equals("Firefox")) {
		System.setProperty("webdriver.gecko.driver","\\C:\\Users\\Saran\\Downloads\\selenium\\firefoxdriver.exe");
		driver=new FirefoxDriver();
	}
	else {
		System.out.println("There is no properties assigned for the browser");
	}
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.get(prop.getProperty("url"));
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
}
