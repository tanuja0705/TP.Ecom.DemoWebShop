package ecom.Demowebshop.genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadWriteInExcel {
	public FileInputStream fis;
	public Workbook wb;
	public int getNumberOfRows(String sh) throws Exception {
		fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		wb = WorkbookFactory.create(fis);
		return wb.getSheet(sh).getPhysicalNumberOfRows();
	}
	
	public int getNumberOfCells(String sh,int row) throws Exception {
		fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		wb = WorkbookFactory.create(fis);
		return wb.getSheet(sh).getRow(row).getPhysicalNumberOfCells();
	}
	
	public String readDataFromExcel(String sh, int row,int cell) throws Exception {
		fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		wb = WorkbookFactory.create(fis);
		return wb.getSheet(sh).getRow(row).getCell(cell).toString();
	}
	
	public void writeDataInNewCellInExcel(String sh,int row,int cell,String data) throws Exception {
		fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		wb = WorkbookFactory.create(fis);
		wb.getSheet(sh).getRow(row).createCell(cell).setCellValue(data);
		
		FileOutputStream fos = new FileOutputStream("./src/test/resources/TestData.xlsx");
		wb.write(fos);
		wb.close();
	}
	
	public void overRideCellDataInExcel(String sh,int row,int cell,String data) throws Exception {
		fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		wb = WorkbookFactory.create(fis);
		wb.getSheet(sh).getRow(row).getCell(cell).setCellValue(data);
		
		FileOutputStream fos = new FileOutputStream("./src/test/resources/TestData.xlsx");
		wb.write(fos);
		wb.close();
	}
	
	public void closeWorkbook() throws Exception {
		wb.close();
	}
}
