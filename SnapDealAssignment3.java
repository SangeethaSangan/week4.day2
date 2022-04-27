package week4.day2.assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDealAssignment3 {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		// disable browser notification
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.get("https://www.snapdeal.com/");// get application URL
		driver.manage().window().maximize();

		WebElement element1 = driver.findElement(By.xpath("//span[contains(text(),'Men')][@class='catText']"));// locate
																												// mens
																												// fashion
		Actions builder = new Actions(driver);
		builder.moveToElement(element1).perform();// mouse hover on Mens fashion

		driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();// click sports shoes
		String shoesCount = driver.findElement(By.xpath("//span[contains(@class,'category-name category-count')]"))
				.getText();// get count of sports shoes
		System.out.println("total no of shorts shoes:" + shoesCount);
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();// click training shoes
		Thread.sleep(5000);
		WebElement SortDropDown = driver.findElement(By.xpath("//span[contains(text(),'Sort')]"));// locate sort by
																									// dropdown
		SortDropDown.click();
		driver.findElement(By.xpath("//li[@data-sorttype='plth']")).click();// click pricelowtohigh
		Thread.sleep(5000);
		List<WebElement> prices = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		System.out.println("prduct prices in low to high");
		for (int i = 0; i < prices.size(); i++) {
			System.out.println(prices.get(i).getText());
		}

		WebElement minPrice = driver.findElement(By.name("fromVal"));
		minPrice.clear();
		minPrice.sendKeys("900");// set min value
		WebElement maxPrice = driver.findElement(By.name("toVal"));
		maxPrice.clear();
		maxPrice.sendKeys("2000");// set max value

		driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();// click GO
		Thread.sleep(5000);
		WebElement color = driver.findElement(By.xpath("//label[@for='Color_s-Navy']"));// click color as Navy
		color.click();// click navy
		System.out.println("verify colour navy is selected?" + color.isSelected());
		Thread.sleep(5000);
		WebElement product1 = driver.findElement(By.xpath("//picture[@class='picture-elem']"));// select first displayed
																								// product
		Actions Builder = new Actions(driver);
		Builder.moveToElement(product1).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//DIV[contains(text(),'Quick')]")).click();
		String price = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
		String discount = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
		System.out.println("price is" + price + "discount % is" + discount);
		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("./snaps/screenshot.png");
		FileUtils.copyFile(source, destination);
		driver.close();
	}

}
