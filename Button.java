package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Button {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//We have to call WDM for the browser driver!!
		WebDriverManager.chromedriver().setup();

		//Launch the browser(chrome)
		ChromeDriver driver=new ChromeDriver();

		//Load the url
		driver.get("http://leafground.com/pages/Button.html");

		//Maximize the browser
		driver.manage().window().maximize();

		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//clicking on button to navigate to home page
		driver.findElement(By.xpath("//label[text()='Click button to travel home page']/following-sibling::button")).click();
		
		driver.navigate().back();
		
		//Get position
		WebElement position=driver.findElement(By.id("position"));
		
		int xvalue=position.getLocation().getX();
		
		int yvalue=position.getLocation().getY();
		
		System.out.println("(xValue,yValue)="+"("+xvalue+","+yvalue+")");
		
		//Get color
		WebElement color=driver.findElement(By.id("color"));
		
		String colorvalue=color.getCssValue("background-color");
		
		System.out.println("Colorvalue="+colorvalue);
		
		//get size
		WebElement size=driver.findElement(By.id("size"));
		
		int height=size.getSize().height;
		int width=size.getSize().width;
		
		System.out.println("Height:"+height+"  Width:"+width);
	}

}
