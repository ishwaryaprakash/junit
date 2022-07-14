package flipkard.com;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Driver;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
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

public class Realme {
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
		search.sendKeys("redmi mobiles", Keys.ENTER);
		Thread.sleep(4000);
	}
	@Test
	public void  method3() throws Throwable {
		WebElement a = driver.findElement(By.xpath("(//div[contains(@class,'_4rR01T')])[1]"));
	    a.click();
	    Thread.sleep(4000);
		String text = a.getText();
		System.out.println("mobile name : "+text);
		
	}	
	@Test
	public void  method4() throws InterruptedException, IOException {
		String parentID = driver.getWindowHandle();
		System.out.println("Parent Window ID:"+parentID);
		Set<String> childID = driver.getWindowHandles();
		for(String x : childID)
			driver.switchTo().window(x);
				Thread.sleep(3000);
				WebElement b = driver.findElement(By.xpath("//span[@class='B_NuCI']"));
			    String text1 = b.getText();
				
				File file = new File("C:\\Users\\rajap\\eclipse-workspace\\Junit\\driver\\test cases (1).xlsx");
				 FileOutputStream f = new FileOutputStream(file);
			     XSSFWorkbook work = new XSSFWorkbook();
			    XSSFSheet sheet = work.createSheet("mobile name");
			    XSSFRow row = sheet.createRow(0);
			    XSSFCell cell = row.createCell(0);
		        cell. setCellValue(text1);
			    work.write(f);
			    work.close();
			}
	
	@Test
	public void  method5() throws IOException {
		 TakesScreenshot tk = (TakesScreenshot)driver;
		 File filetype = tk.getScreenshotAs(OutputType.FILE);
		 File location = new File("C:\\Users\\rajap\\eclipse-workspace\\Junit\\target\\flipkard");
		 FileUtils.copyFile(filetype,location);
				
		System.out.println("screnshot");
		
		String s = "ishwarya";
		Assert.assertEquals(s, "priya");
		Assert.assertTrue(s.equals("priya"));
	}
	@Ignore
	@AfterClass
	public static void browserquit() {
		
		driver.quit();
		System.out.println("Browserquite");
	
	}




	}


