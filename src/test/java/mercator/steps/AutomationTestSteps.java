package mercator.steps;

import mercator.driver.BasePage;
import mercator.pages.LoginPage;
import mercator.pages.ProductsPage;
import mercator.pages.CartPage;
import io.cucumber.java8.En;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AutomationTestSteps implements En {

    private Logger log = LoggerFactory.getLogger(AutomationTestSteps.class);

    LoginPage loginPage = new LoginPage();
    ProductsPage productsPage = new ProductsPage();
    CartPage cartPage = new CartPage();

    String maxPrice = "";
    public AutomationTestSteps() {

        Given("I open the sauce demo site", () -> {
            loginPage.openUrl(BasePage.getProperty("baseUrl"));
        });

        And("I login to sauce demo site", () -> {
            loginPage.login();
        });

        Then("I assert the page title to be {string}", (String title) -> {
            Assert.assertEquals("Page name not matched", title, productsPage.getPageTitle());
        });

        Then("I add costly dress to cart", () -> {
            maxPrice = productsPage.getMaxPrice();
            System.out.println("Max Item Price: "+maxPrice);
            productsPage.addCostlyItemToCart();
        });

        And("I click on cart icon on the products page", () -> {
            productsPage.clickOnCart();
        });

        Then("I validate the price in the cart page", () -> {
            Assert.assertEquals("Fail: Wrong item added to cart", maxPrice, cartPage.getTheItemPrice());
        });
    }

}
