package in.sathya.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Datautilities {
	
	public static Object[][] getexceldata() throws Exception {
		
		File src=new File("C:\\Users\\Saran\\eclipse-workspace\\Sathyaproject\\src\\main\\java\\in\\sathya\\exceldata\\Addressdetails.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(0);
		
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		//iterate the values and store in object array
		for(int i=0;i<sheet.getLastRowNum();i++) {
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;
		
	}

}
