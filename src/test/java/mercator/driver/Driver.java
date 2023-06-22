package mercator.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Driver {

    private static WebDriver chromeDriver;

    public static WebDriver getChromeDriver() {
        if (chromeDriver == null) {
            ChromeOptions option = new ChromeOptions();
            option.addArguments("--remote-allow-origins=*");

            WebDriverManager.chromedriver().setup();
            chromeDriver = new ChromeDriver(option);
            chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            chromeDriver.manage().window().maximize();
        }
        return chromeDriver;
    }

    public static void stopDriver() {
        if (chromeDriver != null) {
            chromeDriver.quit();
            chromeDriver = null;
        }
    }

}