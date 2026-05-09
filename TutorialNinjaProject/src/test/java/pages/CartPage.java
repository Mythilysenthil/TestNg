package pages;

import org.openqa.selenium.By;

public class CartPage {

    public By searchBox =
            By.name("search");

    public By searchButton =
            By.xpath("//button[@class='btn btn-default btn-lg']");

    public By addToCartButton =
            By.xpath("(//span[text()='Add to Cart'])[1]");

    public By cartButton =
            By.id("cart-total");

    public By viewCart =
            By.linkText("View Cart");
}