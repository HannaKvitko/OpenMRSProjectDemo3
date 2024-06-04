package utilities;

import com.mongodb.annotations.ThreadSafe;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.AWTException;




public class CommonMethods {


    public CommonMethods() {
        PageFactory.initElements(DriverClass.getDriver(), this);
    }

    protected static final Logger log = LogManager.getLogger();
    public WebDriverWait wait = new WebDriverWait(DriverClass.getDriver(), Duration.ofSeconds(10));




    public void waitUntilVisible(WebElement element) {

        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverClass.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void clickElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        scrollToElement(element);
        element.click();
    }

    public void verifyContainsText(WebElement element, String value) {
        wait.until(ExpectedConditions.textToBePresentInElement(element, value));
        Assert.assertTrue(element.getText().toLowerCase().contains(value.toLowerCase()));
        new Actions(DriverClass.getDriver()).sendKeys(Keys.ESCAPE).build().perform();
    }

    public void clickJSExecutor(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        scrollToElement(element);
        JavascriptExecutor js = (JavascriptExecutor) DriverClass.getDriver();
        js.executeScript("arguments[0].click();", element);
    }

    public boolean isWebElementDisplayed(WebElement webElement) {
        log.trace("isWebElementDisplayed(" + webElement + ")");

        return webElement.isDisplayed();
    }

    public void sendKeys(WebElement element, String key) {

        element.sendKeys(key);

    }

    public void actionClick(WebElement element) {
        Actions action = new Actions(DriverClass.getDriver());
        action.moveToElement(element).click(element).build().perform();
    }

    public void clickMethod(WebElement element) {
        waitUntilClickable(element);
        scrollToElement(element);
        element.click();
    }

    public void navigateBack() {
        DriverClass.getDriver().navigate().back();
    }



    public void waitTime(int seconds) {

        try {
            Thread.sleep(1000L * seconds);
        } catch (InterruptedException e) {
            log.warn("InterruptedException in Thread.sleep(). Message: " + e.getMessage());
        }
    }


    public void uploadFileWithRobot(String filePath) {
        StringSelection stringSelection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
            return;
        }

        // Press CTRL+V to paste the file path
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.delay(500);

        // Press Enter to close the dialog and upload the file
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(500);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }


    public void screenShot(WebDriver driver) {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        LocalDateTime timeOfBug = LocalDateTime.now();
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("MMddyyyyhhmmss");
        String date = timeOfBug.format(timeFormat);
        String filePath = "src/test/java/screenshots/image_" + date + ".jpeg";
        File fullPage = new File(filePath);
        File tempFile = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            // Which Dependency are we use for FileUtils in Java Selenium
            FileUtils.copyFile(tempFile, fullPage);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }
}

