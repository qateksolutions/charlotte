package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import utility.Constant;

public class ExcelUtils {

	private static FileInputStream ExcelFile;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFSheet ExcelWSheet;
	private static XSSFCell Cell;
	private static XSSFRow SheetRow;
	private static FileOutputStream fileOut;

	public static void SetExcelFile(String path, String sheetName) throws Exception
	{
		try {
			ExcelFile = new FileInputStream(path);
			ExcelWBook = new  XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(sheetName);				
		} catch (Exception e) {
			Log.error("Excel File is not exist");
			throw (e);
		}
	}

	public static String GetCellData(int rowNum, int colNum) throws Exception {
		String cellData = "";
		try {
			Cell = ExcelWSheet.getRow(rowNum).getCell(colNum);
			//Setting the cell type value into String
			cellData = Cell.getStringCellValue();
			ExcelWBook.close();
			ExcelFile.close();					
		} catch (Exception e) {
			Log.error("Cell Value is empty");
			throw (e);
		}			
		return cellData;
	}

	public static void SetCellData(int rowNum, int colNum, String result) throws Exception {
		try {
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
			fileOut = new FileOutputStream(Constant.Path_TestData + Constant.File_TestData);
			ExcelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();						
		} catch (Exception e) {
			throw (e);
		}		
	}		
}
