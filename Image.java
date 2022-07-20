package week2.day2;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Image {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//We have to call WDM for the browser driver!!
		WebDriverManager.chromedriver().setup();

		//Launch the browser(chrome)
		ChromeDriver driver=new ChromeDriver();

		//Load the url
		driver.get("http://leafground.com/pages/Image.html");

		//Maximize the browser
		driver.manage().window().maximize();
		
		//Home image
		driver.findElement(By.xpath("//label[text()='Click on this image to go home page']/following-sibling::img")).click();
		driver.navigate().back();
		
		//to find broken img
		WebElement broken=driver.findElement(By.xpath("//label[text()='Am I Broken Image?']/following-sibling::img"));
		String naturalwidth=broken.getAttribute("naturalWidth");
		
		if(naturalwidth.equals("0"))
		{
			System.out.println("Image is broken since it has natural width as "+naturalwidth);
		}
		
		//action to navigate to home
		driver.findElement(By.xpath("//label[text()='Click me using Keyboard or Mouse']/following-sibling::img")).click();
			
	}

}
