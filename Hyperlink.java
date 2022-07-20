package week2.day2;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Hyperlink {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				//We have to call WDM for the browser driver!!
				WebDriverManager.chromedriver().setup();

				//Launch the browser(chrome)
				ChromeDriver driver=new ChromeDriver();

				//Load the url
				driver.get("http://leafground.com/pages/Link.html#");

				//Maximize the browser
				driver.manage().window().maximize();
				
				//Click the home page hyperlink
				WebElement homelink=driver.findElement(By.linkText("Go to Home Page"));
				
				homelink.click();
				
				driver.navigate().back();
				
				//Where the link is supposed to go
				WebElement linkto=driver.findElement(By.partialLinkText("Find where am"));
				
				String address=linkto.getAttribute("href");
				
				System.out.println("The link goes to "+address);
				
				//verify whether its broken or not
				WebElement broken=driver.findElement(By.linkText("Verify am I broken?"));
				broken.click();
				String title=driver.getTitle();
				if(title.contains("404"))
				{
					System.out.println("The page is broken with title - "+title);
				}
				
				driver.navigate().back();
				
				//click home link again using same web element used before
				homelink.click();
				
				driver.navigate().back();
				
				//Number of link in the page
				List<WebElement> NumLink=driver.findElements(By.tagName("a"));
				int linkcount=NumLink.size();
				
				System.out.println("Total links in the page is "+linkcount);

	}

}
