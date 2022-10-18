package test_data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {

	
	public String[][] ReadExcelData() throws Exception {
		File src=new File("D:\\WORKSPACE\\orion_automation\\src\\test\\java\\test_data\\test_data.xlsx");
		FileInputStream fis = new FileInputStream(src);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheetName = wb.getSheet("accounts");
		int totalRows=sheetName.getLastRowNum();
		Row rowcell = sheetName.getRow(0);
		int totalCells = rowcell.getLastCellNum();
		DataFormatter formater = new DataFormatter();
		String testData[][] = new String[totalRows][totalCells];
		for(int i=1;i<=totalRows;i++)
		{
			for(int j=0;j<totalCells;j++)
			{
				testData[i-1][j]=formater.formatCellValue(sheetName.getRow(i).getCell(j));
			}
		}
		return testData;
		
	}
	
	
}
