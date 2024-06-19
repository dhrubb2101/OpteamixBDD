package Steps;

import org.junit.Assert;

import com.pages.LoginPage;
import com.pages.WindowPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WindowSteps {
	
	private static String title;
		
	private WindowPage wp = new WindowPage(DriverFactory.getDriver());
	

@Given("User is on parent page")
public void user_is_on_parent_page() {
	
	DriverFactory.getDriver().get("https://rahulshettyacademy.com/AutomationPractice/");
    
}

@When("User clicks on open tab button")
public void user_clicks_on_open_tab_button() throws InterruptedException {
	Thread.sleep(3000);
	wp.verifyopentab();
   
}



@Then("child page is displayed and reads information {string}")
public void child_page_is_displayed_and_reads_information(String expectedstring) {
	Assert.assertTrue(title.contains(expectedstring));

}



}