package mercator.pages;

import mercator.driver.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends BasePage {

    @FindBy(css = "#shopping_cart_container")
    WebElement cart;

    public void addCostlyItemToCart() {
        boolean addToCart = false;
        String maxPrice = getMaxPrice();
        List<WebElement> items = driver.findElements(By.className("pricebar"));
        for (WebElement item : items) {
            if (item.getText().contains(maxPrice)) {
                item.findElement(By.tagName("button")).click();
                addToCart = true;
            }
        }
        if (!addToCart) {
            Assert.fail("Failed to click on Add to cart button");
        }
    }

    public String getMaxPrice() {
        List<Double> prices = new ArrayList<>();
        List<WebElement> item_prices = driver.findElements(By.className("inventory_item_price"));
        for (WebElement item : item_prices) {
            String price = item.getText().replace("$", "");
            prices.add(Double.parseDouble(price));
        }
        return String.valueOf(prices.stream().max(Double::compare).get());
    }

    public void clickOnCart() {
        assertElement(cart);
        clickElement(cart);
    }
}
