package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		/*http://leaftaps.com/opentaps/control/main

		Delete Lead:
		1	Launch the browser
		2	Enter the username
		3	Enter the password
		4	Click Login
		5	Click crm/sfa link
		6	Click Leads link
		7	Click Find leads
		8	Click on Phone
		9	Enter phone number
		10	Click find leads button
		11	Capture lead ID of First Resulting lead
		12	Click First Resulting lead
		13	Click Delete
		14	Click Find leads
		15	Enter captured lead ID
		16	Click find leads button
		17	Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		18	Close the browser (Do not log out)
		 */

		//We have to call WDM for the browser driver!!
		WebDriverManager.chromedriver().setup();

		//Launch the browser(chrome)
		ChromeDriver driver=new ChromeDriver();

		//Load the url
		driver.get("http://leaftaps.com/opentaps");

		//Maximize the browser
		driver.manage().window().maximize();

		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//inspect user name and send username text
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");

		//inspect password and send password text
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		//click login button
		driver.findElement(By.className("decorativeSubmit")).click();

		//click CRM/SFA
		driver.findElement(By.linkText("CRM/SFA")).click();

		//click leads tab
		driver.findElement(By.linkText("Leads")).click();

		//click find leads
		driver.findElement(By.linkText("Find Leads")).click();

		//click on phone tab
		driver.findElement(By.xpath("//span[text()='Phone']")).click();

		//Send phone number
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("9994449956");

		//click find lead
		driver.findElement(By.xpath("(//button[@class='x-btn-text'])[7]")).click();

		//choose first member
		WebElement firstmember=driver.findElement(By.xpath("(//a[@class='linktext'])[4]"));

		String id=firstmember.getText();

		System.out.println(id);
		
		//to avoid Stale Element Reference Exception
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", firstmember);

		//delete the member
		driver.findElement(By.xpath("//a[text()='Delete']")).click();

		//click find leads
		driver.findElement(By.linkText("Find Leads")).click();

		//Search the deleted member through ID
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(id);

		//click find lead
		driver.findElement(By.xpath("(//button[@class='x-btn-text'])[7]")).click();

		//Get the search content
		WebElement page=driver.findElement(By.xpath("//div[text()='No records to display']"));

		String pagecontent=page.getText();

		System.out.println(pagecontent);

		if(pagecontent.equals("No records to display"))
		{
			System.out.println("The first displayed lead is successfully deleted");
		}


	}

}
