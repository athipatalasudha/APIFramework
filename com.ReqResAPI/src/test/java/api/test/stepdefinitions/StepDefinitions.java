package api.test.stepdefinitions;

import io.cucumber.java.en.*;

import java.util.Properties;

import org.testng.Assert;

import api.test.utilities.CommonUtilities;

import api.test.base.BaseAPI;
public class StepDefinitions extends BaseAPI
{
	
	@Given("Base URI {string}")
	public void base_uri(String string) {
	  set_URI(string);
	}

	@When("User logs in with valid credentials")
	public void user_logs_in_with_valid_credentials() {
	   LogintoAPI();
	}

	@Then("Valid statuscode {string} is generated")
	public void valid_statuscode_is_generated(String string) {
		validate_statuscode(Integer.parseInt(string));
	}

	@Then("Token is generated")
	public void token_is_generated() {
	   validate_token();
	}
	@When("User logs in with missing password")
	public void user_logs_in_with_missing_password() {
	    InvalidLogintoAPI();
	}

	@Then("Error message {string} is displayed")
	public void error_message_is_displayed(String string) {
	    Assert.assertEquals(error_msg_login(), string);
	}
	
	@When("User requests a single user details")
	public void user_requests_a_single_user_details() {
	   getSingleUser();
	}

	@Then("User details are displayed")
	public void user_details_are_displayed() {
	  displaySingleUser();
	}
	
	@When("User requests all user details")
	public void user_requests_all_user_details() {
	  
	}

	@Then("All User details are displayed")
	public void all_user_details_are_displayed() {
	 
	}
	@When("user privides new user details to create")
	public void user_privides_new_user_details_to_create() {
		createNewUser();
	}

	@Then("Id id generated for the new user")
	public void id_id_generated_for_the_new_user() {
		createNewUserResp();
	}
	
	@When("user privides user details to update")
	public void user_privides_user_details_to_update() {
		updateUserReq();
	}

	@Then("Updated details are displayed")
	public void updated_details_are_displayed() {
		updateUserResp();
	}


}
