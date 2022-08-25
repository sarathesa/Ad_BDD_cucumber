package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

	public static void getDriver(String browserName) {

		switch (browserName) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "IE":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;

		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			break;
		}

	}

	public static String getPropertyValue(String key) throws IOException {
		Properties properties = new Properties();
		FileInputStream stream = new FileInputStream(
				System.getProperty("user.dir") + "/src/test/resources/config.properties");
		properties.load(stream);
		String value = (String) properties.get(key);

		return value;
	}

	public static void implicitywait(int sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}

	public static void loadUrl(String url) {
		driver.get(url);
	}

	public static void click(WebElement element) {
		element.click();
	}

	public String getEnterdUrl(String url) {
		String surl = driver.getCurrentUrl();
		return surl;
	}

	public String getTextWeb(WebElement element) {
		String text = element.getText();
		return text;

	}

	public static void maximize() {
		driver.manage().window().maximize();

	}

	public WebElement findElementById(String attributeName) {
		WebElement findElementID = driver.findElement(By.id(attributeName));
		return findElementID;
	}

	public void selectByID(WebElement element, int id) {
		Select select = new Select(element);
		select.selectByIndex(id);
	}

	public void selectByText(WebElement element, String data) {
		Select select = new Select(element);
		select.selectByVisibleText(data);
	}

	public WebElement findElementByIdDate(String attributeName) {
		WebElement findElementID = driver.findElement(By.id(attributeName));
		return findElementID;
	}

	public void typeText(WebElement element, String Data) {
		element.sendKeys(Data);

	}

	public void insertText(WebElement element, String Data) {
		element.sendKeys(Data);
	}

	public String getValueAttribute(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;
	}

	public String getData(String Sheet, int Rowno, int Cellno) throws IOException {
		String res = null;
		File file = new File("C:\\Users\\sarath esa\\eclipse-workspace\\MavenProject\\Excel File\\bass 1.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(Sheet);
		Row row = sheet.getRow(Rowno);
		Cell cell = row.getCell(Cellno);
		CellType cellType = cell.getCellType();
		switch (cellType) {
		case STRING:
			res = cell.getStringCellValue();
			// System.out.println(stringCellValue);
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");
				res = format.format(dateCellValue);
				// System.out.println(date);
			} else {
				double numericCellValue = cell.getNumericCellValue();
				BigDecimal valueOf = BigDecimal.valueOf(numericCellValue);
				res = valueOf.toString();
				// System.out.println(string);
			}
			break;
		default:
			break;

		}
		return res;
	}

	public void inputToExcel(String Sheet, int Rowno, int Cellno, String newdata) throws IOException {
		File file = new File("C:\\Users\\sarath esa\\eclipse-workspace\\MavenProject\\Excel File\\bass 1.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(Sheet);
		Row row = sheet.getRow(Rowno);
		Cell createCell = row.createCell(Cellno);
		createCell.setCellValue(newdata);
		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);
	}

}
