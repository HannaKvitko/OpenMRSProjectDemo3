package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import pages.US_402_LoginPages;
import utilities.DriverClass;

public class US_402_LoginStepdefinitions {

    US_402_LoginPages page = new US_402_LoginPages();

    @Given("Navigate to webpage")
    public void navigate_to_webpage() {
        DriverClass.getDriver().get("https://openmrs.org/");
        page.waitTime(2);

    }

    @When("user clicks on the DEMO button")
    public void user_clicks_on_the_DEMO_button() {
        page.clickElement(page.Demobutton);
        page.waitTime(2);
    }

    @Then("user selects Explore OpenMRS 3")
    public void user_selects_Explore_OpenMRS_3() {
        page.clickElement(page.OpenMRS3);
        page.waitTime(2);
    }

    @When("click on Enter OpenMRS 3 and navigate to the login page")
    public void click_on_Enter_OpenMRS_3_and_navigate_to_the_login_page() {
        page.clickElement(page.EnterOpenMRS3);
        page.waitTime(2);
    }

    @Then("user enters the username {string}")
    public void user_enters_the_username(String username) {
        page.sendKeys(page.usernameTextBox, username);
        page.waitTime(2);
    }

    @Then("user click on Continue button")
    public void user_click_on_continue_button() {

        page.clickElement(page.ContinueButton);
        page.waitTime(2);
    }

    @Then("user enters password {string}")
    public void user_enters_password(String password) {
        page.sendKeys(page.userpasswordTextBox, password);
        page.waitTime(2);
    }

    @And("user should be able click on Login button")
    public void user_should_be_able_click_on_Login_button() {
        page.clickElement(page.LoginButton);
        page.waitTime(2);
    }
}


