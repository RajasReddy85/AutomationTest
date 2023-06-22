package mercator.driver;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BasePage {

    public WebDriver driver;

    public WebDriverWait wait;

    public BasePage () {
        driver = Driver.getChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(getProperty("wait"))));
        PageFactory.initElements(driver, this);
    }

    public static String getProperty(String property) {
        Properties properties;
        try {
            properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/properties/test.properties");
            properties.load(fileInputStream);
        } catch(FileNotFoundException e) {
            throw new RuntimeException("FileNotFoundException", e);
        } catch (IOException e) {
            throw new RuntimeException("IOException", e);
        }
        return properties.getProperty(property);
    }

    public void openUrl(String url) {
        driver.navigate().to(url);
    }

    public String getPageTitle() {
        return driver.findElement(By.className("title")).getText();
    }

    public static void setText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public static void clickElement(WebElement element) {
        element.click();
    }

    public static boolean isElementExists(WebElement element) {
        boolean found = false;
        try {
            found =  element.isEnabled();
        } catch (Exception e) {
        }
        return found;
    }

    public static void assertElement(WebElement element) {
        Assert.assertTrue("WebElement not found in 20 seconds: " + element, isElementExists(element));
    }

}