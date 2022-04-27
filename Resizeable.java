package week4.day2.assignment;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Resizeable 
{

	public static void main(String[] args) 
	{

		// setting up chromedriver with latest version using webdriver manager
		WebDriverManager.chromedriver().setup();

		// driver object for chromdriver class
		ChromeDriver driver = new ChromeDriver();

		// launch url
		driver.get("https://jqueryui.com/resizable/");

		// implicit wait of 10 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// maximize browser
		driver.manage().window().maximize();

		// create Object for action class-builder
		Actions builder = new Actions(driver);

		// switching to frame1
		driver.switchTo().frame(0);
		WebElement target = driver.findElement(By.xpath("//div[contains(@class,'gripsmall-diagonal-se')]"));
		// using builder object to click and drag
		builder.dragAndDropBy(target, 50, 50).perform();

		// switching back to default content
		driver.switchTo().defaultContent();

	}

}