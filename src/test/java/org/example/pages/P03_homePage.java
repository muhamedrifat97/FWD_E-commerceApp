package org.example.pages;

import io.cucumber.java.en_old.Ac;
import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class P03_homePage {

    public P03_homePage() {

        PageFactory.initElements(Hooks.driver, this);
    }

    /***************** Page Factory Elements *****************/
    /*
    *   Defined Page Factories
     */
    @FindBy(id = "customerCurrency")
    private WebElement currencyList;

    @FindBy(className = "actual-price")
    private List<WebElement> pricesPF;

    @FindBy(className = "product-item")
    private List<WebElement> productItemPF;

    @FindBy(id = "small-searchterms")
    private WebElement searchPF;

    @FindBy(className = "nivo-imageLink")
    private WebElement sliderPF;
    /*********************************************************/


    /******************  D03 Currencies StepDefinition Methods ********************/
    public WebElement getCurrencyList() {
        return currencyList;
    }

    public List<WebElement> getPrices() {
        return pricesPF;
    }
    /******************************************************************************/


    /********************  D04 Search StepDefinition Methods **********************/
    public List<WebElement> getProductItems() {
        return productItemPF;
    }

    public WebElement getpPoductSku()
    {
        return Hooks.driver.findElement(By.xpath("//span[starts-with(@id,'sku-')]"));
    }

    public void searchProduct(String product) {
        searchPF.clear();
        searchPF.sendKeys(product);
        searchPF.sendKeys(Keys.ENTER);
    }

    /******************************************************************************/


    /*********************  D05 Hover StepDefinition Methods  *********************/

    public List<WebElement> getCategories()
    {
        return Hooks.driver.findElements(By.cssSelector("ul[class=\"top-menu notmobile\"]>li>a[href]"));
    }

    public void hover(List<WebElement> categories, int rand)
    {
        // Hover on the element
        Actions hover = new Actions(Hooks.driver);
        hover.moveToElement(categories.get(rand - 1)).perform();
    }

    public String getSubCategory(int categoryIndex, int subCategoryIndex)
    {
        return Hooks.driver.findElement(By.cssSelector("body>div.master-wrapper-page>div.header-menu>ul.top-menu.notmobile>li:nth-child("+categoryIndex+")>ul>li:nth-child("+subCategoryIndex+")>a")).getAttribute("href");

    }

    public String getPageTitleName()
    {
        return Hooks.driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[1]/h1")).getText();
    }
    public void goToSubCategory(int categoryIndex, int subCategoryIndex)
    {
        WebElement next_page = Hooks.driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.header-menu > ul.top-menu.notmobile > li:nth-child(1) > ul > li:nth-child(1) > a"));
        next_page.click();
    }

    public String getTitleText()
    {
        return Hooks.driver.findElement(By.cssSelector("div[class=\"age-title\"]")).getText();
    }

    public List<WebElement> getSubCategories(int headCategory)
    {
        return Hooks.driver.findElements(By.cssSelector("ul.top-menu.notmobile>li:nth-of-type("+headCategory+")>ul.sublist.first-level>li>a[href]"));

    }

    public void goToUrl(String url)
    {
        Hooks.driver.navigate().to(url);
    }
    /******************************************************************************/


    /*******************  D06 HomeSlider StepDefinition Methods *******************/

    public void slideToLumia()
    {
        Hooks.driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div > div > div > div > div.slider-wrapper.theme-custom > div.nivo-controlNav > a:nth-child(1)")).click();
    }

    public void slideToIphone()
    {
        Hooks.driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div > div > div > div > div.slider-wrapper.theme-custom > div.nivo-controlNav > a.nivo-control.active")).click();
    }

    public void clickSlider()
    {
        sliderPF.click();
    }
    /******************************************************************************/



    /*******************  D07 Follow Us StepDefinition Methods *******************/

    public void goToWebsite(String url)
    {
        Hooks.driver.findElement(By.cssSelector("a[href=\""+url+"\"]")).click();
    }

    public void switchToNewTab()
    {
        ArrayList <String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());

        // Switch to the 2nd tab
        Hooks.driver.switchTo().window(tabs.get(1));
    }
    /*****************************************************************************/



    /*******************  D08 Wishlist StepDefinition Methods *******************/

    public WebElement addWishList()
    {
        return Hooks.driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div > div > div > div > div.product-grid.home-page-product-grid > div.item-grid > div:nth-child(3) > div > div.details > div.add-info > div.buttons > button.button-2.add-to-wishlist-button"));
    }

    public WebElement successMsgWishlist()
    {
        return Hooks.driver.findElement(By.cssSelector("#bar-notification > div > p"));
    }


    public String successMshWishlistBgnd()
    {
        return Hooks.driver.findElement(By.cssSelector("#bar-notification > div")).getCssValue("background-color");
    }

    public WebElement wishListLink()
    {
        return Hooks.driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.header > div.header-upper > div.header-links-wrapper > div.header-links > ul > li:nth-child(3) > a"));
    }

    public int wishListQuantity()
    {
        return Integer.valueOf(Hooks.driver.findElement(By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div > div > div > div.page-body > div.wishlist-content > form > div.table-wrapper > table > tbody > tr > td.quantity > input")).getAttribute("value"));
    }
    public void removeSuccessMsg()
    {
        Hooks.driver.findElement(By.cssSelector("#bar-notification > div > span")).click();
    }

    /****************************************************************************/


    public String searchURL() {
        return Hooks.driver.getCurrentUrl();
    }
}
