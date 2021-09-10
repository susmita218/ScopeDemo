import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SSLCertificationAccept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//general chrome profile
		DesiredCapabilities c= DesiredCapabilities.chrome();
		//c.acceptInsecureCerts();
		c.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

		c.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		//Belongs to your locl browser
		ChromeOptions ch=new ChromeOptions();
		ch.merge(c);
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Susmita\\chromedriver_win32_update\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(ch);
		
	}

}
