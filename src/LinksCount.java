import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksCount {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Susmita\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println("Links count of the entire page is : "+driver.findElements(By.tagName("a")).size());
		
		
		//count of footer section
		WebElement footerdriver=driver.findElement(By.cssSelector("[id='gf-BIG']"));
		System.out.println("Links count of the footer section of the page is : "+footerdriver.findElements(By.tagName("a")).size());
		
		
		WebElement block1=footerdriver.findElement(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td/ul"));
		System.out.println("Links count of the block 1 of footer section of the page is : " + block1.findElements(By.tagName("a")).size());
		
		//click on each link and check if the pages are opening
		for(int i=1; i<block1.findElements(By.tagName("a")).size(); i++ )
		{
			String clickonlink=Keys.chord(Keys.CONTROL,Keys.ENTER);
			//block1.findElements(By.tagName("a")).get(i).click();
			
			block1.findElements(By.tagName("a")).get(i).sendKeys(clickonlink);	
			Thread.sleep(6000L);
			
				
		}
		Set<String> winhandle=driver.getWindowHandles();//4
		Iterator<String> tab=winhandle.iterator();
		while(tab.hasNext())
		{
		driver.switchTo().window(tab.next());
		System.out.println(driver.getTitle());
		}

	}

}
