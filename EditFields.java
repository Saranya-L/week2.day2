package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditFields {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//We have to call WDM for the browser driver!!
		WebDriverManager.chromedriver().setup();

		//Launch the browser(chrome)
		ChromeDriver driver=new ChromeDriver();

		//Load the url
		driver.get("http://leafground.com/pages/Edit.html");

		//Maximize the browser
		driver.manage().window().maximize();

		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//email text box edit
		driver.findElement(By.id("email")).sendKeys("abc@gmail.com");

		//append text box edit
		driver.findElement(By.xpath("//label[text()='Append a text and press keyboard tab']/following-sibling::input")).sendKeys("Characters");

		//Get default text
		WebElement defaulttext=driver.findElement(By.xpath("(//input[@name='username'])[1]"));

		String text=defaulttext.getAttribute("value");

		System.out.println("Default text is "+text);

		//Clear the text
		driver.findElement(By.xpath("(//input[@name='username'])[2]")).clear();

		//Is enabled or not
		WebElement disabledelement=driver.findElement(By.xpath("//label[text()='Confirm that edit field is disabled']/following-sibling::input"));
		Boolean disabled=disabledelement.isEnabled();

		if(disabled==true)
		{System.out.println("Enabled");}else
		{System.out.println("Disabled");}

	}

}
