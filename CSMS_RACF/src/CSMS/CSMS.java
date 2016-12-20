package CSMS;



import org.testng.annotations.Test;

import com.sun.jna.platform.unix.X11.Screen;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;



public class CSMS 
{
	WebDriver driver;
  @Test(priority=1)
  public void ApplicationMangement()
  {
	driver.findElement(By.xpath("//*[@id='mainnav-menu']/li[3]/a/i")).click();
	driver.quit();
	
  }
  

@Parameters({ "browser" })
@BeforeTest
	public void beforeTest(String browser) throws FileNotFoundException, IOException {
		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}

		else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "F:\\Widget\\Brow\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();

		} else if (browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "F:\\selenium\\IEDriverServer_Win32_2.53.1\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();

		}
		
		driver.get("http://192.168.10.15:7086");
		driver.navigate().to("http://caparna:Undertakerjohn@10@192.168.10.15:7086");
		
	}


@AfterTest
	public void afterTest() {
	driver.quit();
	}

}

