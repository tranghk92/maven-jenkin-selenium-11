package selenium;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class runTestcaseDemoFF {
	WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {
		//WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("http://demo.guru99.com/V4/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	@Test
	public void TC_01_DemoRunOnJenkins() {
		String loginTitle = driver.getTitle();
		Assert.assertEquals("Guru99 Bank Home Page", loginTitle);
		WebElement userTxt = driver.findElement(By.xpath("//input[@name='uid']"));
		Assert.assertTrue(userTxt.isDisplayed());
	}
  @Test
  public void TC_02_getURL() {
	  String loginUrl = driver.getCurrentUrl();
	  Assert.assertEquals("http://demo.guru99.com/V4/", loginUrl);
	  
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
