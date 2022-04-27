package week4.day2.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragandDrop1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/drag.html");//load url
		driver.manage().window().maximize();
		Actions builder = new Actions(driver);
		builder.dragAndDropBy(driver.findElement(By.id("draggable")), 125, 130).perform();


	}

}
