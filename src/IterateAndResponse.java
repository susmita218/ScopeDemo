import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class IterateAndResponse {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Susmita\\chromedriver_win32_update\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> links=driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		for(WebElement link:links)
		{
		String url=link.getAttribute("href");
		HttpURLConnection conn=(HttpURLConnection) new URL(url).openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		int respcode=conn.getResponseCode();
		System.out.println(respcode);
		
		if (respcode>400)
		{System.out.println("The link with text "+link.getText()+"failed with response code"+respcode);
			Assert.assertTrue(false);
			
		}
		
		}
	}

}
