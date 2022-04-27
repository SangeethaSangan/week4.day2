package week4.day2.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragandDrop2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/drop.html");//load URL
		WebElement drag = driver.findElement(By.id("draggable"));//locate drag element
		WebElement drop = driver.findElement(By.id("droppable"));//locate drop element
		Actions builder = new Actions(driver);
		builder.dragAndDrop(drag, drop).perform();
	}

}
