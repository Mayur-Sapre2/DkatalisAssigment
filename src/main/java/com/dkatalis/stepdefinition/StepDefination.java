/**
 * 
 */
package com.dkatalis.stepdefinition;

import com.dkatalis.DkatalisAssignment.CommonUtilities;
import com.dkatalis.DkatalisAssignment.Setup;
import com.dkatalis.DkatalisAssignment.TimeUtil;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author gslab
 *
 */
public class StepDefination extends Setup {
	
	CommonUtilities util=new CommonUtilities();
	TimeUtil time_util=new TimeUtil();
	
	@Given("user launch {string}")
	public void user_launch(String url) throws Exception {
		openBrowserAndLaunchUrl(url);
	}
	
	@When("click on \"([^\"]*)\" button")
	public void click_on_button(String text) throws Exception {
		util.clickOnButtonByText(text);
		time_util.waitForMediumtime();
	}

	@When("enter amount as {string} inspite of {string}")
	public void amount_as(String new_value,String value) throws Exception {
		util.clearTextInTextBoxByValue(value);
		util.enterTextInTextBoxByLabel(value,new_value);
		
	}

	@When("enter name as {string} inspite of {string}")
	public void enter_name_as(String new_value,String value) throws Exception {
		util.clearTextInTextBoxByValue(value);
		util.enterTextInTextBoxByLabel(value,new_value);
	}

	@When("email as {string} inspite of {string}")
	public void email_as(String new_value,String value) throws Exception {
		util.clearTextInTextBoxByValue(value);
		util.enterTextInTextBoxByLabel(value,new_value);
	}

	@When("phone number as {string} inspite of {string}")
	public void phone_number_as(String new_value,String value) throws Exception {
		util.clearTextInTextBoxByValue(value);
		util.enterTextInTextBoxByLabel(value,new_value);
	}

	@When("city as {string} inspite of {string}")
	public void city_as(String new_value,String value) throws Exception {
		util.clearTextInTextBoxByValue(value);
		util.enterTextInTextBoxByLabel(value,new_value);
	}

	@When("address as {string} inspite of {string}")
	public void address_as(String name,String new_name) throws Exception {
		util.enterTextInTextboxByName(new_name,name);
	}

	@When("postalcode as {string} inspite of {string}")
	public void postalcode_as(String new_value,String value) throws Exception {
		util.clearTextInTextBoxByValue(value);
		util.enterTextInTextBoxByLabel(value,new_value);
	}

	@Then("select payment option as \"([^\"]*)\"")
	public void select_payment_option_as(String classname,String value) throws Exception {
	   util.clickOnValueInsideCLass(classname, value);
	}

	@Then("^enter the \"([^\"]*)\" in \"([^\"]*)\" field$")
	public void enter_and(String placeholder,String value) throws Exception {
	   util.enterTextInFieldByFieldPlaceholder(placeholder,value);
	}

	@Then("verify {string},{string} and {string}")
	public void verify_and(String string, String string2, String string3) {
	   
	}
	
	@When("switch to frame {string}")
	public void switch_to_frame(String framename) {
	    util.switchToFrame(framename);
	}
}
