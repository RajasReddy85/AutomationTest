package mercator.pages;

import mercator.driver.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(className = "inventory_item_price")
    private WebElement item_Price;

    public String getTheItemPrice() {
        assertElement(item_Price);
        return item_Price.getText().replace("$", "");
    }
}
