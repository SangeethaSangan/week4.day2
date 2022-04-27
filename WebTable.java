package week4.day2.assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/table.html");// get url
		driver.manage().window().maximize();
		List<WebElement> rows = driver.findElements(By.xpath("//table//tr"));// get list of row

		List<WebElement> colms = driver.findElements(By.xpath("//table//tr[2]/td"));// get list of column
		System.out.println("no fo rows:" + rows.size());// print row size
		System.out.println("no fo colms:" + colms.size());// print col size

		// Get list of progress value without % symbol and add into new arraylist
		List<Integer> progValueList = new ArrayList<Integer>();
		for (int i = 2; i < rows.size() + 1; i++) {
			int progValue = Integer.parseInt(
					driver.findElement(By.xpath("//table//tr[" + i + "]/td[2]")).getText().replaceAll("[^0-9]", ""));

			progValueList.add(progValue);
		}
		Integer m = Collections.min(progValueList);// find minimum value in progress value
		System.out.println("min value:" + m);

		// Check the vital task for the least completed progress.
		driver.findElement(By.xpath("//font[contains(text(),'" + m + "')]//following::input[@type='checkbox']"))
				.click();
		// Get the progress value of 'Learn to interact with Elements'
		for (int k = 2; k < rows.size() + 1; k++) {
			WebElement learningDetails = driver.findElement(By.xpath("//table//tr[" + k + "]//td[1]"));
			if (learningDetails.getText().toLowerCase().equalsIgnoreCase("Learn to interact with Elements")) {
				WebElement progValue = driver.findElement(By.xpath("//table//tr[" + k + "]//td[2]"));
				System.out.println(learningDetails.getText() + ":" + progValue.getText());
			}
		}

	}
}
