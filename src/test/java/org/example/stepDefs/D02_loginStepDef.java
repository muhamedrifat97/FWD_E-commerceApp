package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.testng.asserts.SoftAssert;

public class D02_loginStepDef {
    P02_login login = new P02_login();

    @Given("user navigates to login page")
    public void goLoginPage()
    {
        login.loginLink().click();
    }


    @Given("^user login with valid \"(.*)\" and \"(.*)\"$")
    public void enterLoginData(String email, String password)
    {
        login.setEmail(email);
        login.setPassword(password);
    }

    @When("user press on login button")
    public void pressLogin()
    {
        login.Submit();
    }

    @Then("user could not login to the system")
    public void checkErrMsg()
    {
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(login.checkErrorMsg("Login was unsuccessful. Please correct the errors and try again."));
        soft.assertTrue(login.checkErrMsgClr());
        soft.assertAll();
    }

    @Then("user login to the system successfully")
    public void loginSuccess()
    {
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(login.checkSuccess());
        soft.assertAll();
    }

    @And("is navigated to the correct url")
    public void checkUrl() {
        SoftAssert soft = new SoftAssert();

        soft.assertTrue(login.currentURL.contains("https://demo.nopcommerce.com/"));

        soft.assertAll();
    }
}
