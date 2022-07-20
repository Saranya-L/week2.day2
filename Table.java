package week2.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Table {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//We have to call WDM for the browser driver!!
				WebDriverManager.chromedriver().setup();

				//Launch the browser(chrome)
				ChromeDriver driver=new ChromeDriver();

				//Load the url
				driver.get("http://www.leafground.com/pages/table.html");

				//Maximize the browser
				driver.manage().window().maximize();
				
				//Column size
				List<WebElement> columns=driver.findElements(By.tagName("th"));
				int columnsize=columns.size();
				System.out.println("Total columns : "+columnsize);
				
				//row size
				List<WebElement> rows=driver.findElements(By.tagName("tr"));
				int rowsize=rows.size();
				System.out.println("Total columns : "+rowsize);
				
				//the progress value of 'Learn to interact with Elements'
				List<WebElement> learn=driver.findElements(By.xpath("//td[normalize-space()='Learn to interact with Elements']/following::td[1]"));
				for (WebElement each : learn) {
					String text=each.getText();
					System.out.println("The Progress value for Learn to interact with Elements is "+text);
				}
				
				//min value progress percentage
				List<WebElement> progressValues=driver.findElements(By.xpath("//td[2]"));
				List<Integer> storeprogress=new ArrayList<Integer>(); //creating a new list
				
				for (WebElement integer : progressValues) 
				{
					String numberasstring=integer.getText().replace("%", "");
					int valueinint=Integer.parseInt(numberasstring); //string to integer
					storeprogress.add(valueinint);
				}
				System.out.println("total progress values"+storeprogress);
				int small=Collections.min(storeprogress);
				System.out.println("Minimum value"+small);
				
				String valueofsmall=Integer.toString(small)+"%"; //need to convert to string before giving xpath
				System.out.println("Minimum value"+valueofsmall);
				
				String xpathofminlocation="//td[normalize-space()="+"\""+valueofsmall+"\""+"]"+"//following::td[1]";
				//System.out.println(xpathofminlocation);
				
				WebElement Happytofinish=driver.findElement(By.xpath(xpathofminlocation));
				Happytofinish.click();
				
				System.out.println("Minimun progress checkbox is checked");
				

	}

}
