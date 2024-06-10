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
        error.waitTime(2);
    }
    @When("the user selects {string}  {string}  {string}")
    public void the_user_selects(String string, String string2, String string3) {
        error.clickJSExecutor(error.demoButton);
        error.waitTime(1);
        error.scrollToElement(error.ExploreOpenMRS);
        error.waitTime(1);


    }
    @Then("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        error.clickJSExecutor(error.ExploreOpenMRS);
        error.waitTime(1);

    }
    @When("the user enters invalid credentials and clicks {string}")
    public void the_user_enters_invalid_credentials_and_clicks(String string) {
        error.clickJSExecutor(error.sentUsername);
        error.waitTime(1);
        error.sendKeys(error.sentUsername, "just");
        error.waitTime(1);

    }
    @Then("the user sees a {string} warning")
    public void the_user_sees_a_warning(String string) {
        error.clickJSExecutor(error.sentPassword);
        error.waitTime(1);
        error.sendKeys(error.sentPassword, "just");
        error.waitTime(1);

    }
    @When("the user selects {string} and enters invalid credentials again")
    public void the_user_selects_and_enters_invalid_credentials_again(String string) {
        error.clickJSExecutor(error.inpatientWord);
        error.waitTime(1);

    }
    @Then("the user sees an {string} warning")
    public void the_user_sees_an_warning(String string) {
        error.clickJSExecutor(error.loginButton);
        error.waitTime(1);
        error.waitUntilVisible(error.visible);
    }
    @When("the user enters valid credentials")
    public void the_user_enters_valid_credentials() {

    }
    @Then("the user logs in successfully")
    public void the_user_logs_in_successfully() {

    }


}
