package flipkard.com;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class excel {
	static WebDriver driver;
	static long start; 
	@BeforeClass
	public static void browse() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rajap\\eclipse-workspace\\Junit\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
	}
		
	
	
	@Before
	public void starttime() {
		System.out.println("Before");
		start = System.currentTimeMillis();
		
	}
	@After
	public void endtime() {
		long end = System.currentTimeMillis();
		System.out.println("After time :"+(+end-start));
	}
	@Test
	public void  method1() {
		WebElement close=driver.findElement(By.xpath("//button[text()='✕']"));
		close.click();
		System.out.println("login");
		}
	@Test
	public void  method2() throws Throwable   {
		
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("redmi tv", Keys.ENTER);
		Thread.sleep(4000);
	}
	@Test
	public void  method3() throws Throwable {
		WebElement a = driver.findElement(By.xpath("(//div[contains(@class,'_4rR01T')])[1]"));
	    a.click();
	    Thread.sleep(4000);
		String textt = a.getText();
		System.out.println("Tv name : "+textt);
		
	}	
	@Test
	public void  method4() throws InterruptedException, IOException {
		String parentID = driver.getWindowHandle();
		System.out.println("Parent Window ID:"+parentID);
		Set<String> childID = driver.getWindowHandles();
		for(String y : childID)
			driver.switchTo().window(y);
				Thread.sleep(3000);
				WebElement q = driver.findElement(By.xpath("//span[contains(@class,'B_NuCI')]"));
			    String text2 = q.getText();
				
				File file1 = new File("C:\\Users\\rajap\\eclipse-workspace\\Junit\\driver\\test cases (1).xlsx");
				 FileOutputStream f = new FileOutputStream(file1);
			     XSSFWorkbook work = new XSSFWorkbook();
			    XSSFSheet sheet = work.createSheet("Tv name");
			    XSSFRow row = sheet.createRow(1);
			    XSSFCell cell = row.createCell(1);
		        cell. setCellValue(text2);
			    work.write(f);
			    work.close();
			}
	
	@Test
	public void  method5() throws IOException {
		 TakesScreenshot tk1 = (TakesScreenshot)driver;
		 File filetype = tk1.getScreenshotAs(OutputType.FILE);
		 File location = new File("C:\\Users\\rajap\\eclipse-workspace\\Junit\\target\\flipkard1.png");
		 FileUtils.copyFile(filetype,location);
				
		System.out.println("screnshot");
	}
	@Ignore
	@AfterClass
	public static void browserquit() {
		driver.quit();
		System.out.println("Browserquite");
	}

	}
	
