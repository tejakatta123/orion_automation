package TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Resources.ExtentReportComp;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils_orion.CommonUtils;
import utils_orion.Constants;

public class BaseTest {

	public WebDriver driver;
	public ExtentReports extent = ExtentReportComp.getExtentReports();
	public static ExtentTest test;

	@BeforeTest(alwaysRun = true)
	public WebDriver IntializeBrowser() throws Exception {

		Properties prop = CommonUtils.loadProperties();
		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.manage().window().maximize();
		return driver;

	}

	/*
	 * @AfterTest public void tearDown() { driver.close();
	 * 
	 * }
	 */

	public String[][] ReadExcelData(String excelSheetName) throws Exception {
		File src = new File(Constants.TESTDATA_EXCELFILE);
		FileInputStream fis = new FileInputStream(src);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheetName = wb.getSheet(excelSheetName);
		int totalRows = sheetName.getLastRowNum();
		Row rowcell = sheetName.getRow(0);
		int totalCells = rowcell.getLastCellNum();
		DataFormatter formater = new DataFormatter();
		String testData[][] = new String[totalRows][totalCells];
		for (int i = 1; i <= totalRows; i++) {
			for (int j = 0; j < totalCells; j++) {
				testData[i - 1][j] = formater.formatCellValue(sheetName.getRow(i).getCell(j));
			}
		}
		return testData;
	}

	public String getScreenShot(String testcaseName, WebDriver driver) throws Exception {

		String filepath = System.getProperty("user.dir") + "//screenshots//reports" + testcaseName + ".png";
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(filepath);
		FileUtils.copyFile(source, file);
		return filepath;

	}

	public List<HashMap<String, String>> getjsonDataToMap(String filepath) throws IOException {
		System.out.println("debugging" + filepath);

		String jsonContent = FileUtils.readFileToString(new File(filepath), StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;

	}

}
