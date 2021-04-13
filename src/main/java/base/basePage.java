package base;

import java.io.FileInputStream;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.io.File;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class basePage 
 {
	 public static WebDriver driver;
	 public static Properties prop;
	 public static ExtentHtmlReporter exthtml;
	 public static ExtentReports report;
	 public static ExtentTest testlog;
	    
	 @BeforeSuite
	 public void initialize()
	 {
		 
		 WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		 driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		 prop= new Properties();
		 try 
		    {
			 prop.load(new FileInputStream("src/main/java/config/data.properties"));
			 }
		 catch(Exception e) {}
	   exthtml = new ExtentHtmlReporter(prop.getProperty("reportslocation")+"QATools.html");
	   report = new ExtentReports();
	   report.attachReporter(exthtml);
	   report.setSystemInfo("Host Name", "Test"); 
	   report.setSystemInfo("Environment", "Test Env");
	   report.setSystemInfo("User Name", "Ramya");
	   
	   exthtml.config().setDocumentTitle("QATools");
	   exthtml.config().setReportName("QATools Functional Testing");
	   exthtml.config().setTestViewChartLocation(ChartLocation.TOP);
	   exthtml.config().setTheme(Theme.STANDARD);
      
  }
  public void takescreenshot(String filename)
  {
  	try
  	{
  	File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
  	FileUtils.copyFile(f,new File(prop.getProperty("screens")+filename));
  	
  	testlog.addScreenCaptureFromPath(prop.getProperty("screens")+filename);
  	}catch(Exception e) {}
  	
  	
  }
  @AfterSuite
  public void teardown()
  {

      driver.quit();
      report.flush();
     }
}
	 

	
