package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*http://leaftaps.com/opentaps/control/main
		
		* 1	Launch the browser
		* 2	Enter the username
		* 3	Enter the password
		* 4	Click Login
		* 5	Click crm/sfa link
		* 6	Click Leads link
		* 7	Click Find leads
		* 8	Enter first name
		* 9	Click Find leads button
		* 10 Click on first resulting lead
		* 11 Verify title of the page
		* 12 Click Edit
		* 13 Change the company name
		* 14 Click Update
		* 15 Confirm the changed name appears
		* 16 Close the browser (Do not log out)
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
				
				//Find first name field and give values
				driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Saranya");
				
				//click find lead
				driver.findElement(By.xpath("(//button[@class='x-btn-text'])[7]")).click();
				
				//click on first displayed name
				driver.findElement(By.xpath("(//a[text()='Saranya'])[1]")).click();
				
				//verify the view leads page
				String titles=driver.getTitle();
				if(titles.equals("View Lead | opentaps CRM"))
				{
					System.out.println(titles);
				}
				
				//edit with new company name
				driver.findElement(By.xpath("//a[text()='Edit']")).click();
				
			
				
				WebElement company=driver.findElement(By.xpath("(//input[@name='companyName'])[2]"));
				company.clear();
				company.sendKeys("HCL");
				
				driver.findElement(By.xpath("(//input[@name='submitButton'])[1]")).click();
				
				//verify new company name
				WebElement newcompany=driver.findElement(By.id("viewLead_companyName_sp"));
				String newcompanytext=newcompany.getText();
				
				if(newcompanytext.contains("HCL"))
				{
					System.out.println("Successfully edited company name as HCL");
				}
				
				//close browser
				driver.close();


	}

}
