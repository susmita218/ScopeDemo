import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class SoftAssertionBrokenlink {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Susmita\\chromedriver_win32_update\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> links=driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		SoftAssert s=new SoftAssert();
		
		for(WebElement link:links)
		{
		String url=link.getAttribute("href");
		HttpURLConnection conn=(HttpURLConnection) new URL(url).openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		int respcode=conn.getResponseCode();
		System.out.println(respcode);
		
		//hard assertion==> Assert.assertTrue(respcode<400, "The link with text "+link.getText()+"failed with response code"+respcode);
		//alternatively used soft assertion
		s.assertTrue(respcode<400, "The link with text "+link.getText()+"failed with response code"+respcode);
		
		//if block got deleted for soft assertion
		
		}
		s.assertAll();
	}

}
