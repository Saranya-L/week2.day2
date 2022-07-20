package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ZoomCar {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://www.zoomcar.com/in/bangalore");
		
		driver.findElement(By.xpath("//div[@class='placeholder']")).click();
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofseconds(30));
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[@class='suggested']/div[1]")).click();
		
		driver.findElement(By.xpath("//span[@class='field-date start-time']")).click();
		
		Thread.sleep(3000);
		WebElement firstclick=driver.findElement(By.xpath("(//td[contains(text(),'19')])[1]"));
		firstclick.click();
		firstclick.click();
		
		driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
		
		driver.findElement(By.xpath("//button[contains(text(),'Find')]")).click();
		
		Thread.sleep(10000);

		WebElement getprice=driver.findElement(By.xpath("(//h3[text()='Maruti Swift Dzire']//following::div[@class='price-book-ctr']/div/div)[1]"));
		
		String price=getprice.getText();
		System.out.println(price);
		
		
	}

}
