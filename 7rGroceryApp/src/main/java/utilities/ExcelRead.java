package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	public String readFromExcelFile(int i, int j) {

		String excelFilePathString = System.getProperty("user.dir")
				+ "\\src\\main\\resources\\excelRead\\ExcelRead.xlsx";
		FileInputStream inputStream;
		String data = null;
		try {
			inputStream = new FileInputStream(excelFilePathString);
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
			XSSFSheet sheet = workbook.getSheet("sheet1");
			XSSFRow row = sheet.getRow(i);
			XSSFCell cell = row.getCell(j);
			CellType type = cell.getCellType();

			switch (type) {
			case NUMERIC:
				double data1 = cell.getNumericCellValue();
				data = String.valueOf(data1);

			case STRING:
				data = cell.getStringCellValue();

			default:
				break;

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}

}
