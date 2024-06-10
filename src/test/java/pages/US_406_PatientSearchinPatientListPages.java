package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.CommonMethods;

public class US_406_PatientSearchinPatientListPages extends CommonMethods {

    @FindBy(xpath= "//a[@class='zak-button']")
    public WebElement Demobutton1;

    @FindBy(xpath= "//span[contains(text(),'Explore OpenMRS 3')]")
    public WebElement openMrsButton;

    @FindBy(xpath= "//span[contains(text(),'Enter the OpenMRS 3 Demo')]")
    public WebElement openMrsButton1;

    @FindBy(xpath= "//input[@id='username']")
    public WebElement usernameTextBox;

    @FindBy(xpath= "//button[normalize-space()='Continue']")
    public WebElement clickContinueButton;

    @FindBy(xpath= "//input[@id='password']")
    public WebElement passwordTextBox;

    @FindBy(xpath= "//span[normalize-space()='Log in']")
    public WebElement LoginButton;

    @FindBy(xpath= "//span[normalize-space()='Inpatient Ward']")
    public WebElement inpatientWards;

    @FindBy(xpath= "//button[@type='submit']")
    public WebElement clickContinue;

    @FindBy(xpath= "//button[@name='SearchPatientIcon']//*[name()='svg']")
    public WebElement searchButton;

    @FindBy(xpath= "(//input[@class='cds--search-input'])[1]")
    public WebElement searchTextBox;

    @FindBy(xpath= "//span[contains(text(),'MS')]")
    public WebElement PatientNameİsDisplayed;

    @FindBy(xpath= "//a[@class='-esm-patient-search__patient-banner__patientBanner___KiO__']")
    public WebElement clickPatirentForDetails;

    @FindBy(xpath= "//span[@class='-esm-patient-vitals__vitals-header__heading___wDqjW']")
    public WebElement Seeappointment;

    @FindBy(xpath= "//div[@class='-esm-primary-navigation__navbar__spacedLogo___P2WIw']//*[name()='svg']")
    public WebElement clickHomePages;


    @FindBy(xpath= "//p[@class='-esm-patient-search__patient-search-lg__emptyResultText___nWUy3']")
    public WebElement warningMessage;
}
