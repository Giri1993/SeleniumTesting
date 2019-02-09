
package Sample;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTest {
	WebDriver driver=null;
  @Test(dataProvider = "dp")
  public void f(String n, String s) throws InterruptedException, IOException {
	  	driver.findElement(By.name("uid")).sendKeys(n);
		driver.findElement(By.name("password")).sendKeys(s);
		driver.findElement(By.name("btnLogin")).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		EventFiringWebDriver e1=new EventFiringWebDriver(driver);
		File f1=e1.getScreenshotAs(OutputType.FILE);
		File f2=new File(".\\screenshot\\accHomepage.jpg");
		FileUtils.copyFile(f1, f2);
		driver.findElement(By.linkText("Log out")).click();
		driver.switchTo().alert().dismiss();
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "mngr175232", "unubYnU" },
      new Object[] { "mngr175232", "unub456" },
      new Object[] { "ahvbgdadf2", "unubYnU"},
      new Object[] { "fhjhhfnfv7", "fdfhhfh34"},
      new Object[] { "mngr175232", "unubYnU" },
    };
  }
  @BeforeTest
  public void beforeTest() {
	  driver=new FirefoxDriver();
		driver.get("http://www.demo.guru99.com/V4/");
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }
}
