package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03_homePage;
import org.testng.asserts.SoftAssert;

public class D04_searchStepDef {
    P03_homePage home = new P03_homePage();
    String globalProduct;

    @Given("user searches for {string}")
    public void searchFor(String product) {
        globalProduct = product;
        home.searchProduct(product);
    }

    @And("user is navigated to the correct url")
    public void userIsNavigatedToTheCorrectUrl() {
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(home.searchURL().contains("https://demo.nopcommerce.com/search?q="));

        soft.assertAll();
    }

    @Then("search shows relevant results")
    public void searchShowsRelevantResults() {
        // Count number of search results using findElements & size()
        SoftAssert soft = new SoftAssert();

        int numberOfProducts = home.getProductItems().size();

        for (int product_index = 0; product_index < numberOfProducts; product_index++)
        {
            String actualProduct = home.getProductItems().get(product_index).getText().toLowerCase();
            soft.assertTrue(actualProduct.contains(globalProduct));
        }

        // Create for loop and verify each result contains the search word
        // use toLowerCase() method

        soft.assertAll();
    }

    @Then("click on the product in the search result")
    public void clickOnTheProductInTheSearchResult() {
        home.getProductItems().get(0).click();
    }

    @And("verify the sku is contained in the product page")
    public void verifyTheSkuIsContainedInTheProductPage() {
        SoftAssert soft = new SoftAssert();

        soft.assertTrue(home.getpPoductSku().getText().contains(globalProduct));
        soft.assertAll();
    }
}
