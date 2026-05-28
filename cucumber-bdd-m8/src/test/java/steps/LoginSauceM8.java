package steps;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import base.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSauceM8 extends BaseTest{
//	WebDriver driver;

//	@Given("browser is opened for tazeen")
//	public void browser_is_opened_for_tazeen() {
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//	}

	@When("tazeen enters un and pwd")
	public void tazeen_enters_un_and_pwd() {
		driver.get("https://www.saucedemo.com/");
		new Actions(driver).sendKeys(Keys.TAB + "standard_user" + Keys.TAB + "secret_sauce" + Keys.ENTER).perform();
	}

	@When("tazeen enters invalid un and pwd")
	public void tazeen_enters_invalid_un_and_pwd() {
		driver.get("https://www.saucedemo.com/");
		new Actions(driver).sendKeys(Keys.TAB + "locked_out_user" + Keys.TAB + "secret_sauce" + Keys.ENTER).perform();		
	}

	@And("tazeen clicks on loginBtn")
	public void tazeen_clicks_on_login_btn() {
		System.out.println("clicked on login btn...");
	}

	@Then("she should redirect to homepage")
	public void she_should_redirect_to_homepage() {
		boolean status = driver.getCurrentUrl().contains("inventory");
		Assert.assertTrue(status);
	}

	@Then("she should not redirect to homepage")
	public void she_should_not_redirect_to_homepage() {
		boolean status = driver.getCurrentUrl().contains("inventory");
   
		Assert.assertFalse(status);		
	    System.out.println("End Of The Test Script");
  }

//	@And("browser should be closed for her")
//	public void browser_should_be_closed_for_her() {
//		driver.quit();
//	}

}
