package in.sathya.pages;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import in.sathya.base.Baseclass;

public class HPLaptopspage extends Baseclass {
	@FindBy(xpath="//h1[@class='pd-name pd-name-sm']")
	WebElement name;
	@FindBy(xpath="//div[@class='pd-price-block']")
	WebElement price;
	@FindBy(xpath="//span[@class='pd-saving-percent']")
	WebElement Offer;
	@FindBy(xpath="//a[contains(text(),'Features')]")
	WebElement Features;
	@FindBy(xpath="//td[contains(text(),'RAM Capacity')]//following-sibling::td[1]")
	WebElement RAM;
	public HPLaptopspage() throws Exception {
		PageFactory.initElements(driver, this);
	}
	public void clickonHPlaptops() throws Exception {
		List<WebElement>HPlaptops=driver.findElements(By.xpath("//article[@class='art']"));
		int names=HPlaptops.size();
		System.out.println(names);
		int rownum=0;
		Row row=sheet.createRow(rownum++);
		row.createCell(0).setCellValue("PRODUCT NAME");
		row.createCell(1).setCellValue("PRODUCT PRICE");
		row.createCell(2).setCellValue("PRODUCT OFFER");
		row.createCell(3).setCellValue("RAM CAPACITY");
		for(int i=0;i<names;i++) {
			//(//article[@class='art'])[1]
			//clicking on individual laptop
			driver.findElement(By.xpath("(//article[@class='art'])["+(i+1)+"]")).click();
			//get name and price
			Thread.sleep(5000);
			String Productname=name.getText();
			String Productprice=price.getText();
			//get offer if available
			Thread.sleep(3000);
			String Productoffer="0";
			try{
				Productoffer=Offer.getText();
			}
			catch(Exception e) {
				Productoffer="0";
			}
			//get RAM capacity
			Features.click();
			Thread.sleep(4000);
			String RAMcapacity="Not available";
			try{
				RAMcapacity=RAM.getText();
			}
			catch(Exception e) {
				RAMcapacity="Not available";
			}
			//create rows
			row = sheet.createRow(rownum++);
			row.createCell(0).setCellValue(Productname);
			row.createCell(1).setCellValue(Productprice);
			row.createCell(2).setCellValue(Productoffer);
			row.createCell(3).setCellValue(RAMcapacity);
			//return back to HPlaptop page
			driver.navigate().back();
			}
		wb.write(out);
        wb.close();
	}
}
