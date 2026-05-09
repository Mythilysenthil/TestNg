package stepdefinitions;

import java.util.List;

import actions.CartActions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartStepDefinition {

    CartActions ca =
            new CartActions();

    @When("user adds products to cart")
    public void user_adds_products_to_cart(DataTable dataTable) {

        List<List<String>> data =
                dataTable.asLists();

        for (int i = 0; i < data.size(); i++) {

            String productName =
                    data.get(i).get(0);

            ca.searchProduct(productName);

            ca.addToCart();
        }
    }

    @Then("user opens the cart")
    public void user_opens_the_cart() {

        ca.openCart();
    }
}