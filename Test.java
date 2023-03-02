package testPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\dasa3001\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		
		Assert.assertEquals(driver.getTitle(), "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
		System.out.println("My Title is : " + driver.getTitle());
		
		WebElement closeLogIn = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
		closeLogIn.click();
		
		WebElement searchbx = driver.findElement(By.xpath("//input[@name ='q' and @type='text']"));
		searchbx.sendKeys("iphone");
		driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
		List<WebElement> results = driver.findElements(By.xpath("//div[@class='_13oc-S']"));
		
		Assert.assertEquals(driver.getTitle(), "Iphone- Buy Products Online at Best Price in India - All Categories | Flipkart.com");
		System.out.println("Search Results Page : " + driver.getTitle());
		Thread.sleep(5000);
		results.get(0).click();
		
		ArrayList<String> wid = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(wid.get(1));
		
		Assert.assertEquals(driver.getTitle(), "APPLE iPhone 11 ( 128 GB Storage, 0 GB RAM ) Online at Best Price On Flipkart.com");
		System.out.println("Product page : " + driver.getTitle());
		WebElement product = driver.findElement(By.xpath("//span[@class='B_NuCI']"));
		System.out.println("Product name : " + product.getText());
		Thread.sleep(5000);
		
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		List<WebElement> storage = driver.findElements(By.xpath("//li[contains(@id, 'storage')]"));
		List<String> expectedStorage = new ArrayList<String>();
		expectedStorage.add("64 GB");
		expectedStorage.add("128 GB");
		for(int i=0;i<storage.size();i++)
			Assert.assertEquals(storage.get(i).getText(), expectedStorage.get(i));
		for(int i=0;i<storage.size();i++)
			System.out.println(storage.get(i).getText());
		driver.findElement(By.xpath("//*[@id='swatch-0-storage']")).click();
		System.out.println("Storage choosen.");
		Thread.sleep(5000);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[6]/div/div[1]/div[1]/div/ul/li[4]/span")).click();
		Thread.sleep(5000);
		List<WebElement> colours = driver.findElements(By.xpath("//li[contains(@id, 'color')]"));
		Assert.assertTrue(colours.size()==6);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='swatch-1-color']")));
		driver.findElement(By.xpath("//*[@id='swatch-1-color']")).click();
		System.out.println("Colour choosen.");
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[6]/div/div/a/span")).click();
		WebElement cartText = driver.findElement(By.xpath("//span[contains(text(),'Price details')]"));
		Assert.assertEquals(cartText.isDisplayed(), true);
		Assert.assertEquals(driver.getTitle(), "Shopping Cart | Flipkart.com");
		System.out.println("Cart : " + driver.getTitle());
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div/div/div[1]/div/div[4]/div/form/button/span")).click();
		Assert.assertEquals(driver.getTitle(), "Flipkart.com: Secure Payment: Login > Select Shipping Address > Review Order > Place Order");
		System.out.println("Place order page : " + driver.getTitle());
	}

}
