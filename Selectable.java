package week4.day2.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selectable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/selectable.html");//load URL
		WebElement item3 = driver.findElement(By.xpath("//li[contains(text(),'Item 3')]"));//locate item3
		WebElement item6 = driver.findElement(By.xpath("//li[contains(text(),'Item 6')]"));//locate item
		Actions builder=new Actions(driver);
		builder.clickAndHold(item3).moveToElement(item6).release(item6).perform();
	}

}
