package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03_homePage;
import org.testng.Assert;

import java.util.ArrayList;

public class D07_followUsStepDef {
    P03_homePage home = new P03_homePage();

    @Given("user click on fb link")
    public void fbClick() throws InterruptedException {
        home.goToWebsite("http://www.facebook.com/nopCommerce");

        Thread.sleep(2000);

        home.switchToNewTab();
    }

    @Then("user is directed to fb website")
    public void checkDirectedToFb()
    {
        Assert.assertTrue(home.searchURL().contains("https://www.facebook.com/nopCommerce"));
    }

    @Given("user click on twitter link")
    public void userClickOnTwitterLink() throws InterruptedException {
        home.goToWebsite("https://twitter.com/nopCommerce");

        Thread.sleep(2000);

        home.switchToNewTab();
    }

    @Then("user is directed to twitter website")
    public void userIsDirectedToTwitterWebsite() {
         Assert.assertTrue(home.searchURL().contains("https://twitter.com/nopCommerce"));
    }

    @Given("user click on rss link")
    public void userClickOnRssLink() throws InterruptedException {
        home.goToWebsite("/news/rss/1");

        Thread.sleep(2000);

        home.switchToNewTab();
    }

    @Then("user is directed to rss website")
    public void userIsDirectedToRssWebsite() {
        Assert.assertTrue(home.searchURL().contains("https://demo.nopcommerce.com/new-online-store-is-open"));
    }


    @Given("user click on youtube link")
    public void userClickOnYoutubeLink() throws InterruptedException {
        home.goToWebsite("http://www.youtube.com/user/nopCommerce");

        Thread.sleep(2000);

        home.switchToNewTab();
    }

    @Then("user is directed to youtube website")
    public void userIsDirectedToYoutubeWebsite() {
        Assert.assertTrue(home.searchURL().contains("https://www.youtube.com/user/nopCommerce"));
    }
}
