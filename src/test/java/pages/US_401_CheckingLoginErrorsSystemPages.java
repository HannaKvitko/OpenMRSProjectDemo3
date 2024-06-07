package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.CommonMethods;

public class US_401_CheckingLoginErrorsSystemPages extends CommonMethods {
    @FindBy(xpath = "(//a[@class='zak-button'])[1]")
    public WebElement demoButton;
    @FindBy(xpath = "//span[contains(text(),'Enter the OpenMRS 2 Demo')]")
    public WebElement ExploreOpenMRS;
    @FindBy(xpath = "//input[@id='username']")
    public WebElement sentUsername;
    @FindBy(xpath = "//input[@id='password']")
    public WebElement sentPassword;
    @FindBy(xpath = "//input[@id='loginButton']")
    public WebElement loginButton;
    @FindBy(xpath = "//div[@id='error-message']")
    public WebElement visible;
    @FindBy(xpath = "//li[@id='Inpatient Ward']")
    public WebElement inpatientWord;

}
