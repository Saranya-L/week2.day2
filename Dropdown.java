package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//We have to call WDM for the browser driver!!
				WebDriverManager.chromedriver().setup();

				//Launch the browser(chrome)
				ChromeDriver driver=new ChromeDriver();

				//Load the url
				driver.get("http://www.leafground.com/pages/Dropdown.html");

				//Maximize the browser
				driver.manage().window().maximize();
				
				//select by index
				WebElement index=driver.findElement(By.id("dropdown1"));
				
				Select byindex=new Select(index);
				
				byindex.selectByIndex(1);
				
				//select by text
				WebElement text=driver.findElement(By.name("dropdown2"));
				
				Select bytext=new Select(text);
				
				bytext.selectByVisibleText("UFT/QTP");
				
				//select by Value
				WebElement value=driver.findElement(By.id("dropdown3"));
				
				Select byvalue=new Select(value);
				
				byvalue.selectByValue("4");
				
				//options count
				WebElement num=driver.findElement(By.className("dropdown"));
				Select totaloption=new Select(num);
				List<WebElement> options=totaloption.getOptions();
				int count=options.size();
				
				System.out.println("Total number of options are "+count);
				
				//Sendkeys and select
				WebElement sendletter=driver.findElement(By.xpath("(//div[@class='example'])[5]/select"));
				sendletter.sendKeys("A");
				
				//multiple select
				
				WebElement multiple=driver.findElement(By.xpath("(//div[@class='example'])[6]/select"));
				Select multiselect=new Select(multiple);
				multiselect.selectByIndex(1);
				multiselect.selectByIndex(3);
				
	}

}
