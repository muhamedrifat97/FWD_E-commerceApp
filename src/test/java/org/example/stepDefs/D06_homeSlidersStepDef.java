package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03_homePage;
import org.testng.Assert;

public class D06_homeSlidersStepDef {

    P03_homePage home = new P03_homePage();

    @Given("user click on the Nokia Lumia slider")
    public void clickNokiaLumia()
    {
        home.slideToLumia();
        home.clickSlider();
    }

    @Then("user is directed to the lumia url")
    public void checkUrlLumia()
    {
        Assert.assertTrue(home.searchURL().contains("https://demo.nopcommerce.com/nokia-lumia-1020"));
    }

    @Given("user click on Iphone slider")
    public void clickIphone()
    {
        home.slideToIphone();
        home.clickSlider();
    }

    @Then("user is directed to the iPhone url")
    public void checkUrlIphone()
    {
        Assert.assertTrue(home.searchURL().contains("https://demo.nopcommerce.com/iphone-6"));
    }


}
