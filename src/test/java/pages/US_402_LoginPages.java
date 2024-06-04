package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.CommonMethods;

public class US_402_LoginPages extends CommonMethods {

    @FindBy(xpath = "//a[@class='zak-button']")
    public WebElement Demobutton;

    @FindBy(xpath = "//span[contains(text(),'Explore OpenMRS 3')]")
    public WebElement OpenMRS3;

    @FindBy(xpath = "//span[contains(text(),'Enter the OpenMRS 3 Demo')]")
    public WebElement EnterOpenMRS3;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement usernameTextBox;

    @FindBy(xpath = "//button[normalize-space()='Continue']")
    public WebElement ContinueButton;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement userpasswordTextBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement LoginButton;
}

