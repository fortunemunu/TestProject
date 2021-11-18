package LinkCounts;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinkCount {


	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		
		//Give me the counts of the links on the page
		//a means anchor and all links start with a
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		// Limiting webdriver scope to footer section
		//Count of links on the footer section
		WebElement footerdriver = driver.findElement(By.id("gf-BIG"));
		System.out.println(footerdriver.findElements(By.tagName("a")).size());
		
		
		// Limiting webdriver scope to first column in the footer section
		//Count of links first column in the footer section
		WebElement columndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td/ul"));
		System.out.println(columndriver.findElements(By.tagName("a")).size());
		
		//4- click on each link in the column and check if the pages are opening-
				for(int i=1;i<columndriver.findElements(By.tagName("a")).size();i++)
				{
					
					String clickonlinkTab=Keys.chord(Keys.CONTROL,Keys.ENTER);
					
					columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
					Thread.sleep(5000L);
					
				}// opens all the tabs
				Set<String> abc=driver.getWindowHandles();//4
				Iterator<String> it=abc.iterator();
				
				while(it.hasNext())
				{
					
				   driver.switchTo().window(it.next());
				   System.out.println(driver.getTitle());
				
				
				

}
}

}
