package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DriverClass {

    public static WebDriver driver;

    public static WebDriver getDriver(){
        if(driver==null){
            Logger logger = Logger.getLogger("");
            logger.setLevel(Level.SEVERE);
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;

    }
    public static void  quitDriver(){
        if (driver==null){
            driver.quit();
            driver=null;
        }
    }
}



