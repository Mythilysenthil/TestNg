package actions;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import hooks.Hooks;
import pages.CartPage;

public class CartActions {

    CartPage cp = new CartPage();

    private static final Logger log =
            LogManager.getLogger(CartActions.class);

    public void searchProduct(String productName) {

        Hooks.getDriver()
                .findElement(cp.searchBox)
                .clear();

        Hooks.getDriver()
                .findElement(cp.searchBox)
                .sendKeys(productName);

        Hooks.getDriver()
                .findElement(cp.searchButton)
                .click();

        log.info("Product searched: "
                + productName);
    }

    public void addToCart() {

        Hooks.getDriver()
                .findElement(cp.addToCartButton)
                .click();

        log.info("Added product to cart");
    }

    public void openCart() {

        WebDriverWait wait = new WebDriverWait(
                Hooks.getDriver(), Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(cp.cartButton))
                .click();

        wait.until(ExpectedConditions.elementToBeClickable(cp.viewCart))
                .click();

        log.info("Opened cart");
    }
}