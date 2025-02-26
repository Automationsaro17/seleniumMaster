package nbcu.automation.ui.validation.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static int totalRow;

	public Map<String, String> getData(String excelFilePath, String sheetName, String scenario_name) throws Exception {

		InputStream inp = new FileInputStream(new File("").getAbsolutePath() + "\\src\\test\\resources\\excelFiles\\"+excelFilePath+".xlsx");
		Workbook wb = WorkbookFactory.create(inp);
		Sheet sheet = wb.getSheet(sheetName);
		
		//XSSFWorkbook workbook = (XSSFWorkbook) WorkbookFactory.create(new File("").getAbsolutePath() + "\\src\\test\\resources\\excelFiles\\"+excelFilePath+".xlsx");
		//XSSFSheet sheet = workbook.getSheet(sheetName);
		wb.close();
		return readSheet(sheet, scenario_name);
	}

	private Map<String, String> readSheet(Sheet sheet, String scenario_name) {

		Row row;
		Cell cell;
		int rownum = 0;
		totalRow = sheet.getLastRowNum();
		
		for(int i = 1; i <=  totalRow; i++) {
			row = sheet.getRow(i);
			cell = row.getCell(0);
			String value = cell.getStringCellValue();
			if(value.equals(scenario_name)) {
				rownum = i;
				break;
			}
		}
		row = sheet.getRow(rownum);
		int totalColumn = row.getLastCellNum();

		Map<String, String> columnmapdata = new HashMap<String, String>();

		for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
			cell = row.getCell(currentColumn);
			String columnheadername = sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn).getStringCellValue();
			columnmapdata.put(columnheadername,  null == cell ? "": cell.getStringCellValue());
		}
		return columnmapdata;
	}
}
