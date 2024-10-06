package roughWork;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingDataFromExcel {

	//Excel file --> Workbook --> Sheets --> Rows --> Cells
	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\testData\\Data.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		//XSSFSheet sheet = workbook.getSheet("Sheet1");
		XSSFSheet sheet = workbook.getSheetAt(0);
		int totalRows = sheet.getLastRowNum();
		int totalCells = sheet.getRow(0).getLastCellNum();
		System.out.println("Total rows: " + totalRows);
		System.out.println("Total rows: " + totalCells);
		
		for(int r=0; r<=totalRows; r++) {
			
			XSSFRow activeRow = sheet.getRow(r);
			for(int c=0; c<totalCells; c++) {
				XSSFCell currentCell = activeRow.getCell(c);
				System.out.print(currentCell.toString() + "  ");
			}
			
			System.out.println();
		}
		
		workbook.close();
		fis.close();
		
	}
	
	
	
	
	
}
