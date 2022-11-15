package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class D03_currenciesStepDef {
    P03_homePage home = new P03_homePage();

    @When("user select euro option")
    public void selectEuro()
    {
        Select select = new Select(home.getCurrencyList());
        select.selectByVisibleText("Euro");
    }


    @Then("euro symbol is displayed on all products")
    public void euroSymbolIsDisplayedOnAllProducts() {
        for (int element = 0; element < 4; element++)
        {
            String price = home.getPrices().get(element).getText();

            Assert.assertTrue(price.contains("€"));
        }
    }
}
