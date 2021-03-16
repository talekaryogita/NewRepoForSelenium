package stepdef;

import org.junit.Assert;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.HomePage;

public class HomeStepDef {
	HomePage login;
	

	@Given("user is on home page")
	public void user_is_on_home_page() {
		login=new HomePage();
	    
	}
	@When("user click on search button")
	public void user_click_on_search_button() {
		login.sendkeysToTextbox();
		login.clickSearch();
	   
	}
	@When("user click on sign in button")
	public void user_click_on_sign_in_button() {
		login.moveToLogin();
		login.clicksignIn();
	   
	}
	@Then("user is on sign in page")
	public void user_is_on_sign_in_page() {
		Assert.assertTrue(login.getTitle().contains("Amazon"));
	   
	}

}
