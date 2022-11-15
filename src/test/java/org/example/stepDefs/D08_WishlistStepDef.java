package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03_homePage;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class D08_WishlistStepDef {
    P03_homePage home = new P03_homePage();

    @Given("user press add to wishlist button")
    public void pressAddToWishlist()
    {
        home.addWishList().click();


    }

    @Then("success message is previewed")
    public void successMsgPreviewed()
    {
        SoftAssert soft = new SoftAssert();

        soft.assertTrue(home.successMsgWishlist().isDisplayed());

        soft.assertTrue(home.successMshWishlistBgnd().contains("rgba(75, 176, 122, 1)"));
        soft.assertAll();
    }

    @Then("user navigate to wishlist page")
    public void userNavigateToWishlistPage() throws InterruptedException {
        Thread.sleep(1000);
        home.removeSuccessMsg();
        Thread.sleep(1000);
        home.wishListLink().click();
    }

    @And("user have elements with quantity more than zero in the list")
    public void userHaveElementsWithQuantityMoreThanZeroInTheList() {
        Assert.assertTrue(home.wishListQuantity() > 0);
    }

}
