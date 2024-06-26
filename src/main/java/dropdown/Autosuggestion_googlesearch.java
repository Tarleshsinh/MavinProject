package dropdown;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Autosuggestion_googlesearch {
public WebDriver driver;


@Test
public void googlesearch () throws Exception {
	ChromeOptions options = new ChromeOptions();
    // Add any necessary options here
    options.addArguments("--remote-allow-origins=*");
    //options.addArguments("--start-maximized"); // Maximize window
    options.addArguments("--disable-extensions"); // Disable extensions
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\Sarthak Selenium\\Browsers drivers\\chromedriver.exe");
    WebDriver driver = new ChromeDriver(options);
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); // Change the duration to 20 seconds
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // Change the duration to 20 seconds
    driver.manage().deleteAllCookies();
    driver.get("https://www.google.com");
    driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("switzerlandholiday Package");
Thread.sleep(2000); 

List<WebElement>list= driver.findElements(By.xpath("//div[@id='jZ2SBf']//div[1]//span[1]"));
	System.out.println("Size of Autosuggestion list------" + list.size());
	
	for(WebElement switzerlandpkg:list)
	{
		if (switzerlandpkg.getText().contains ("switzerland holiday packages from south africa")) {
			switzerlandpkg.click();
			break;
		}
	}
	
	//WebElement Validate= driver.findElement(By.xpath("//div[@class='a4bIc']//input[@type='text']"));
	 Assert.assertTrue(driver.findElement(By.xpath("//h3[contains(text(),'Switzerland Holidays & Tours from South Africa')]")).isDisplayed());
	 String validation= driver.findElement(By.xpath("//h3[contains(text(),'Switzerland Holidays & Tours from South Africa')]")).getText();
	 Assert.assertEquals("Switzerland Holidays & Tours from South Africa", validation);
	 Assert.assertTrue(validation.contains("Switzerland Holidays & Tours from South Africa"));
	driver.quit();
	
}
}
