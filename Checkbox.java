package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Checkbox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//We have to call WDM for the browser driver!!
				WebDriverManager.chromedriver().setup();

				//Launch the browser(chrome)
				ChromeDriver driver=new ChromeDriver();

				//Load the url
				driver.get("http://leafground.com/pages/checkbox.html");

				//Maximize the browser
				driver.manage().window().maximize();
				
				//Select known language
				driver.findElement(By.xpath("//label[text()='Select the languages that you know?']/following-sibling::input[1]")).click();
				driver.findElement(By.xpath("//label[text()='Select the languages that you know?']/following-sibling::input[5]")).click();
				
				//selected or not
				WebElement selected=driver.findElement(By.xpath("//label[text()='Confirm Selenium is checked']/following-sibling::input"));
				Boolean check=selected.isSelected();
				
				if(check==true)
				{
					System.out.println("Checkbox is selected");
				}else
				{
					System.out.println("Checkbox is not selected");
				}
				
				//deselect if selected
				WebElement element1=driver.findElement(By.xpath("//label[text()='DeSelect only checked']/following-sibling::input[1]"));
				Boolean deselect1=element1.isSelected();
				if(deselect1==true)
				{
					element1.click();
					System.out.println("Iam deselected");
				}else
				{
					System.out.println("Iam deselected already");
				}
				
				WebElement element2=driver.findElement(By.xpath("//label[text()='DeSelect only checked']/following-sibling::input[2]"));
				Boolean deselect2=element2.isSelected();
				if(deselect2==true)
				{
					element2.click();
					System.out.println("Iam deselected");
				}else
				{
					System.out.println("Iam deselected already");
				}
				
				//select all checkbox
				List<WebElement> selectall=driver.findElements(By.xpath("//label[text()='Select all below checkboxes ']/following-sibling::input"));
				
				for (WebElement onebyone : selectall) {
					onebyone.click();
				}
	}

}
