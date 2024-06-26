package dropdown;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Autosuggest_dropdown_bingsearch {
public WebDriver driver;




@Test
public void autosuggest_Bing () throws InterruptedException {
	//WebDriverManager.chromedriver().setup();
	
    ChromeOptions options = new ChromeOptions();
    // Add any necessary options here
    options.addArguments("--remote-allow-origins=*");
    options.addArguments("--start-maximized"); // Maximize window
    options.addArguments("--disable-extensions"); // Disable extensions
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\Sarthak Selenium\\Browsers drivers\\chromedriver.exe");
    WebDriver driver = new ChromeDriver(options);
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); // Change the duration to 20 seconds
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // Change the duration to 20 seconds
    driver.manage().deleteAllCookies();

    driver.get("https://www.bing.com/");
	driver.findElement(By.xpath("//textarea[@id='sb_form_q']")).sendKeys("Selenium");
	
	List<WebElement>list= driver.findElements(By.xpath("//span[@class='sa_tm_text']//strong"));
	System.out.println("This is the size of list----"+list.size());
	Thread.sleep(2000);

	for(WebElement listitem:list)
	{
		if (listitem.getText().contains("selenium download")) {
			listitem.click();
			break;
		}
	}
	Assert.assertTrue(driver.findElement(By.xpath("//span[@class='l_ecrd_imcolheader_ttl l_ecrd_txt_heros']//a[normalize-space()='Selenium']")).isEnabled());
	String validate=driver.findElement(By.xpath("//span[@class='l_ecrd_imcolheader_ttl l_ecrd_txt_heros']//a[normalize-space()='Selenium']")).getText();
	Assert.assertTrue(validate.contains("Selenium"));
	Assert.assertEquals(validate, "Selenium");
	driver.quit();
}
	
	
	
	
}
