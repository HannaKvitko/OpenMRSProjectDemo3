package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.US_406_PatientSearchinPatientListPages;
import utilities.CommonMethods;
import utilities.DriverClass;

import java.time.Duration;

public class US_406_PatientListStepDefinitions extends CommonMethods {
    US_406_PatientSearchinPatientListPages pages = new US_406_PatientSearchinPatientListPages();
    WebDriver driver = DriverClass.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    @Given("The doctor successfully accesses the homepage as an admin")
    public void the_doctor_succesfully_access_for_homepage_as_a_admin() {
        try {
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
            driver.get("https://o3.openmrs.org/openmrs/spa/login");

            wait.until(ExpectedConditions.elementToBeClickable(pages.usernameTextBox)).click();
            pages.sendKeys(pages.usernameTextBox, "admin");
            pages.clickElement(pages.clickContinueButton);

            wait.until(ExpectedConditions.elementToBeClickable(pages.passwordTextBox)).click();
            pages.sendKeys(pages.passwordTextBox, "Admin123");
            pages.clickElement(pages.LoginButton);

            wait.until(ExpectedConditions.elementToBeClickable(pages.inpatientWards)).click();
            pages.clickJSExecutor(pages.clickContinue);
        } catch (TimeoutException e) {
            System.out.println("Page load timeout occurred: " + e.getMessage());
        }
    }

    @When("The doctor clicks on the find patient button")
    public void the_doctor_click_on_the_find_patient_button() {
        wait.until(ExpectedConditions.elementToBeClickable(pages.searchButton)).click();
    }

    @Then("The doctor successfully searches for a patient using name, ID, or surname")
    public void the_doctor_succesfully_searches_for_a_patient_using_name_id_or_surname() {
        wait.until(ExpectedConditions.visibilityOf(pages.searchTextBox)).sendKeys("Mark Smith");
        pages.searchTextBox.sendKeys(Keys.ENTER);
    }

    @Then("The doctor should see and click on the search result")
    public void the_doctor_should_be_see_and_click_for_search_result() {
        wait.until(ExpectedConditions.elementToBeClickable(pages.clickPatirentForDetails)).click();
        Assert.assertTrue(isWebElementDisplayed(pages.PatientNameİsDisplayed));
    }

    @Then("The doctor sees medical history, appointments, and other information after clicking the search result")
    public void the_doctor_see_medical_history_and_appointments_and_other_information_after_click_search_result() {
        Assert.assertTrue(isWebElementDisplayed(pages.Seeappointment));
    }

    @Then("The doctor should see {string} after searching for an old patient")
    public void the_doctor_should_see_after_seach_old_patient(String warningMessage) {
        pages.clickElement(pages.clickHomePages);

        wait.until(ExpectedConditions.elementToBeClickable(pages.searchButton)).click();
        pages.sendKeys(pages.searchTextBox, "Hamza Gökçe");
        pages.searchTextBox.sendKeys(Keys.ENTER);

        String actualWarningMessage = wait.until(ExpectedConditions.visibilityOf(pages.warningMessage)).getText();
        Assert.assertEquals(actualWarningMessage, warningMessage);
    }
}
