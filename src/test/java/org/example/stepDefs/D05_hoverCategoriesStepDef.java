package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03_homePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Random;

public class D05_hoverCategoriesStepDef {

    P03_homePage home = new P03_homePage();
/*
    @Given("user will hover on random category of the three main categories")
    public void getList() {
        List<WebElement> categories = home.getCategories();

        int categoryIndex = new Random().nextInt(3);
        home.hover(categories, categoryIndex);

        String mainCategory = categories.get(categoryIndex).getText();


        List<WebElement> subCategories = home.getSubCategories(categoryIndex);

        int subCategoryIndex = new Random().nextInt(1, 4);
        String subCategoryText = subCategories.get(subCategoryIndex).getText();


        subCategories.get(subCategoryIndex).click();

        SoftAssert soft = new SoftAssert();
        soft.assertTrue(home.getTitleText().contains(subCategoryText));
        soft.assertAll();

    }
 */
    private int categoryIndex, subCategoryIndex;
    private String subCategory;

    @Given("user will hover on random category of the three main categories")
    public void getList() {
        categoryIndex = new Random().nextInt(1, 4);
        subCategoryIndex = new Random().nextInt(1, 4);

        List<WebElement> categories = home.getCategories();

        home.hover(categories, categoryIndex);






        /*
        home.goToSubCategory(categoryIndex, subCategoryIndex);

        System.out.println(subCategory);

*/
    }

    @And("select random one of the three sub categories")
    public void selectRandomOneOfTheThreeSubCategories() {
        String subCategoryHref = home.getSubCategory(categoryIndex, subCategoryIndex);
        // Extract the text
        subCategory = subCategoryHref.substring(29).trim().toLowerCase();

        home.goToUrl(subCategoryHref);
    }

    @Then("verify the subcategory title")
    public void verifyTheSubcategoryTitle() {
        String pageTitleName = home.getPageTitleName().trim().toLowerCase();

        Assert.assertTrue(pageTitleName.contains(subCategory));
    }
}
