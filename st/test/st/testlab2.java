package st;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
 
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
public class testlab2 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  public static String[][] arr = new String[143][3];



  @Before
  public void setUp() throws Exception {
	  String driverPath = "C:\\Program Files\\Java\\geckodriver.exe";
	  System.setProperty("webdriver.gecko.driver", driverPath);
	  driver = new FirefoxDriver();
	  baseUrl = "http://121.193.130.195:8800";
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testBaidu() throws Exception {
		XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(new File("E:\\软件测试名单.xlsx")));
		XSSFSheet sheet = workbook.getSheetAt(0);
		for (int i = 2; i < sheet.getPhysicalNumberOfRows(); i++) {
			//取一行操作
			XSSFRow row = sheet.getRow(i);
			XSSFCell id = row.getCell(1);
			XSSFCell name = row.getCell(2);
			XSSFCell url = row.getCell(3);
			id.setCellType(HSSFCell.CELL_TYPE_STRING);
			arr [i-2][0]=id.toString();
			arr [i-2][1]=name.toString();
			arr [i-2][2]=url.toString();
            
		}
		arr[113][2]=arr[113][2].substring(0, arr[113][2].length()-1);
				//s = s.Substring(0,s.Length - 1)
    driver.get(baseUrl + "/");
   
    for(int i=0;i<143;i++){
    driver.findElement(By.name("id")).click();
    driver.findElement(By.name("id")).clear();
    driver.findElement(By.name("id")).sendKeys(arr[i][0]);
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys(arr[i][0].substring(4));
    driver.findElement(By.id("btn_login")).click();
    assertEquals(arr[i][0], driver.findElement(By.id("student-id")).getText());
    assertEquals(arr[i][1], driver.findElement(By.id("student-name")).getText());
    assertEquals(arr[i][2], driver.findElement(By.id("student-git")).getText());
    driver.findElement(By.id("btn_logout")).click();
    driver.findElement(By.id("btn_return")).click();
    }
  }

  @After
  public void tearDown() throws Exception {
//    driver.quit();
//    String verificationErrorString = verificationErrors.toString();
//    if (!"".equals(verificationErrorString)) {
//      fail(verificationErrorString);
//    }
  }

 
}
