package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.CommonMethods;

public class US_401_CheckingLoginErrorsSystemPages extends CommonMethods {
    @FindBy(xpath = "(//a[@class='zak-button'])[1]")
    public WebElement demoButton;
    @FindBy(xpath = "//span[contains(text(),'Enter the OpenMRS 3 Demo')]")
    public WebElement ExploreOpenMRS3;
    @FindBy(xpath = "//input[@id='username']")
    public WebElement sentUsername;
    @FindBy(xpath = "//button[normalize-space()='Continue']")
    public WebElement sentContinue;



}
