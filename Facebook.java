package week2.day2;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

//Step 1: Download and set the path 
//Step 2: Launch the chromebrowser
//Step 3: Load the URL https://en-gb.facebook.com/
//Step 4: Maximise the window
//Step 5: Add implicit wait
//Step 6: Click on Create New Account button
//Step 7: Enter the first name
//Step 8: Enter the last name
//Step 9: Enter the mobile number
//Step 10: Enterthe password
//Step 11: Handle all the three drop downs
//Step 12: Select the radio button "Female"  ( A normal click will do for this step) 

public class Facebook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver=new ChromeDriver();

		driver.get("https://en-gb.facebook.com/");

		//Maximize the browser
		driver.manage().window().maximize();

		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//clicking on create new account and filling up required details in text box
		driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Saran");

		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("L");

		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("9898989898");

		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("Welcome@123");

		//choosing required day,month,year from the given dropdown
		WebElement day=driver.findElement(By.xpath("//select[@name='birthday_day']"));

		Select dayselect=new Select(day);

		dayselect.selectByVisibleText("26");

		WebElement month=driver.findElement(By.xpath("//select[@name='birthday_month']"));

		Select monthselect=new Select(month);

		monthselect.selectByVisibleText("Aug");

		WebElement year=driver.findElement(By.xpath("//select[@name='birthday_year']"));

		Select yearselect=new Select(year);

		yearselect.selectByVisibleText("1996");

		//choosing Female radio button
		driver.findElement(By.xpath("//label[text()='Female']/following-sibling::input")).click();

		//clicking on submit button
		driver.findElement(By.xpath("//button[@name='websubmit']")).click();

	}

}
