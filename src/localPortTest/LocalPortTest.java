package localPortTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LocalPortTest {

	WebDriver driver = new ChromeDriver();

	@BeforeTest
	public void setup() {
		driver.manage().window().maximize();
		driver.get("http://127.0.0.1:5500/Index.html");
	}

	@Test(priority = 1)
	public void submitTest() {

		WebElement userNameInput = driver.findElement(By.id("input1"));
		WebElement emailInput = driver.findElement(By.id("input2"));
		WebElement passwordInput = driver.findElement(By.id("input3"));
		WebElement mobileInput = driver.findElement(By.id("input4"));
		WebElement birthDateInput = driver.findElement(By.id("input5"));
		// WebElement colorInput = driver.findElement(By.id("input6"));

		userNameInput.sendKeys("Dania Hussam Jarad");
		emailInput.sendKeys("DaniaHJarad@gmail.com");
		passwordInput.sendKeys("1234567");
		mobileInput.sendKeys("07777777777");
		birthDateInput.sendKeys("1/10/1997");
		// colorInput.sendKeys("(105,28,28)");

		// "//tagName[@attribute = '']"
		WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));

		submitButton.click();

	}

	@Test(priority = 2)
	public void resetTest() {

		// back to the last site
		// driver.navigate().back();

		try {
			// break before to continue
			Thread.sleep(500);

			WebElement resetButton = driver.findElement(By.xpath("//button[@type='reset']"));
			resetButton.click();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 4)
	public void linksTest() {

		// Test by Xpath selector
//		WebElement fasebookLink = driver.findElement(By.xpath("//a[@href='https://www.facebook.com/']"));
//		fasebookLink.click();
//
//		driver.navigate().back();
//
//		WebElement instagramLink = driver.findElement(By.xpath("//a[@href='https://www.instagram.com/']"));
//		instagramLink.click();

		// Test by linkTest selector
		WebElement fasebookLink = driver.findElement(By.linkText("Fasebook bage"));
		fasebookLink.click();

		driver.navigate().back();

		// Test by partial link text selector
		WebElement instagramLink = driver.findElement(By.partialLinkText("Instagram"));
		instagramLink.click();

	}

	@Test(priority = 3)
	public void imageTest() {

		WebElement imageLink = driver
				.findElement(By.xpath("//img[@src='https://www.qa.com/media/2rgp0d4q/sqaure_logo.jpg?width=400']"));
		imageLink.click();
		driver.navigate().back();

	}
}
