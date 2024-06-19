package Steps;
 
import java.io.IOException;
 
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
 
import com.qa.factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
 
public class ApplicationHooks {
 
	
	private DriverFactory driverFactory;
	private WebDriver driver;
	private com.qa.util.configReader configReader;
	java.util.Properties prop;
	
	@Before(order=0)
		public void getProperty() throws IOException {
		
			configReader=new com.qa.util.configReader();
			prop=configReader.init_prop();
		}
	
	@Before(order=1)
		
		public void launchBrowser() {
		
		String browserName =prop.getProperty("browser");
		driverFactory=new DriverFactory();
		driver=driverFactory.intit_driver(browserName);
	}
	
	@After(order=0)
	public void  quitBrowser() {
		
		driver.quit();
				
	}
	
	@After(order = 1)
	public void tearDown(Scenario scenario) {
	if (scenario.isFailed()) {
	// take screenshot:
	String screenshotName = scenario.getName().replaceAll(" ", "_");
	byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	scenario.attach(sourcePath, "image/png", screenshotName);
	}
	
	}
	
	}