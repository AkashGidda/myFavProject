/**
 * 
 */
package Writer;

import java.io.File;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import DataModel.entryModel;

/**
 * @author gidakash
 *
 */
public class fileWriter implements writer{

	public static int rownum = 0;

	//Blank workbook
	XSSFWorkbook workbook = new XSSFWorkbook();

	//Create a blank sheet
	XSSFSheet sheet = workbook.createSheet("bestStocks");

	// Output file.
	FileOutputStream out = null;

	public fileWriter() {
		try
		{
			//Write the workbook in file system
			this.out = new FileOutputStream(new File("StockScreening.xlsx"));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		init();
	}

	public fileWriter(String fileName) {
		try
		{
			//Write the workbook in file system
			this.out = new FileOutputStream(new File(fileName));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		init();
	}

	public void init() {
		
		XSSFRow row = sheet.createRow(rownum++);
		XSSFCell cell = row.createCell(0);
		cell.setCellValue("CompanyName");
		cell = row.createCell(1);
		cell.setCellValue("CurrentPrice");
		cell = row.createCell(2);
		cell.setCellValue("IntrinsicValue");
		cell = row.createCell(3);
		cell.setCellValue("BuyORNoBuy");
		cell = row.createCell(4);
		cell.setCellValue("Years to hold");
		cell = row.createCell(5);
		cell.setCellValue("URL");
		
	}



	@Override
	public void writeEntry(entryModel entry) {

		XSSFRow row = sheet.createRow(rownum++);
		int cellnum = 0;

		XSSFCell cell = row.createCell(cellnum++);
		cell.setCellValue(entry.getCompanyName());
		cell = row.createCell(cellnum++);
		cell.setCellValue(entry.getPrice());
		cell = row.createCell(cellnum++);
		cell.setCellValue(entry.getIntrinsicValue());
		cell = row.createCell(cellnum++);
		cell.setCellValue(entry.getBuyNoBuy());
		cell = row.createCell(cellnum++);
		cell.setCellValue(entry.getTermToHold());
		cell = row.createCell(cellnum++);
		cell.setCellValue(entry.getURL());
	}

	public void close() {
		try
		{
			System.out.println(this.out.toString());
			workbook.write(this.out);
			this.out.close();
			System.out.println("Task successful.");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}


}

