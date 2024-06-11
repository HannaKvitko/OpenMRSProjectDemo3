package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.US_401_CheckingLoginErrorsSystemPages;
import utilities.DriverClass;

public class US_401_CheckingLoginErrorsSystemStepdefinition {
    US_401_CheckingLoginErrorsSystemPages error = new US_401_CheckingLoginErrorsSystemPages();
    @Given("the user navigates to the home page")
    public void the_user_navigates_to_the_home_page() {
        DriverClass.getDriver().get("https://openmrs.org/");
        error.waitTime(1);
    }
    @When("the user selects Enter the OpenMRS3 Demo")
    public void the_user_selects_enter_the_open_mrs3_demo() {
        error.clickJSExecutor(error.demoButton);
        error.waitTime(1);
        error.scrollToElement(error.ExploreOpenMRS3);
        error.waitTime(1);
    }
    @When("the user enters invalid credentials and clicksLogin")
    public void the_user_enters_invalid_credentials_and_clicks_login() {
        error.clickJSExecutor(error.ExploreOpenMRS3);
        error.waitTime(1);
    }
    @When("the user enters valid credentials")
    public void the_user_enters_valid_credentials() {
        error.clickJSExecutor(error.sentUsername);
        error.waitTime(1);
        error.sendKeys(error.sentUsername, "just");
        error.waitTime(1);
    }
    @Then("the user logs in successfully")
    public void the_user_logs_in_successfully() {
        error.clickJSExecutor(error.sentContinue);

    }


}
