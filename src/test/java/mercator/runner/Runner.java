package mercator.runner;

import mercator.driver.Driver;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@test",
        glue = {"mercator.steps"},
        features = {"src/test/resources/features"},
        plugin = {"pretty"})

public class Runner {

    @AfterClass
    public static void quitDriver() {
        Driver.stopDriver();
    }
}

