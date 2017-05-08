package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	private static FileInputStream ExcelFile;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFSheet ExcelWSheet;
	private static XSSFCell Cell;
	private static XSSFRow SheetRow;
	private static FileOutputStream fileOut;
	
	public static String GetCellData(File path, String sheetName, int rowNum, int colNum) throws Exception {
		ExcelFile = new FileInputStream(path);
		ExcelWBook = new  XSSFWorkbook(ExcelFile);
		ExcelWSheet = ExcelWBook.getSheet(sheetName);
		Cell = ExcelWSheet.getRow(rowNum).getCell(colNum);
		String cellData = Cell.getStringCellValue();
		ExcelWBook.close();
		ExcelFile.close();		
		return cellData;
}

public static void SetCellData(File path, String sheetName, int rowNum, int colNum, String result) throws Exception {
	ExcelFile = new FileInputStream(path);
	ExcelWBook = new  XSSFWorkbook(ExcelFile);
	ExcelWSheet = ExcelWBook.getSheet(sheetName);
	//Retrieve the row and check for Null
	SheetRow = ExcelWSheet.getRow(rowNum);		
	if (SheetRow == null) {
		SheetRow = ExcelWSheet.createRow(rowNum);
	}
	//Update the value of the cell
	Cell = SheetRow.getCell(colNum);
	if (Cell == null) {
		Cell = SheetRow.createCell(colNum);
	}
	Cell.setCellValue(result);
	fileOut = new FileOutputStream(path);
	ExcelWBook.write(fileOut);
	fileOut.flush();
	fileOut.close();
}

}
