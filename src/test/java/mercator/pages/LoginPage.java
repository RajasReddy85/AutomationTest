package mercator.pages;

import mercator.driver.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(css = "#user-name")
    WebElement username;

    @FindBy(css = "#password")
    WebElement passwd;

     @FindBy(css = "#login-button")
    WebElement Login;

    public void enterUsername() {
        assertElement(username);
        setText(username, BasePage.getProperty("username"));
    }

    public void enterPassword() {
        assertElement(passwd);
        setText(passwd, BasePage.getProperty("password"));
    }

    public void clickOnSignIn() {
        assertElement(Login);
        clickElement(Login);
    }

    public void login() {
        enterUsername();
        enterPassword();
        clickOnSignIn();
    }
}
