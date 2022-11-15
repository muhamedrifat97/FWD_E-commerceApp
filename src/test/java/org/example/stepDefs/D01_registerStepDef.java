package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_register;
import org.testng.asserts.SoftAssert;

public class D01_registerStepDef {

    P01_register register = new P01_register();

    @Given("user go to register page")
    public void goRegisterPage()
    {
        register.registerlink().click();
    }

    @When("^user choose gender as \"(.*)\"$")
    public void setGender(String gender)
    {
        register.setGender(gender);
    }

    @And("^user enters first name as \"(.*)\" and last name as \"(.*)\"$")
    public void setName(String firstName, String lastName)
    {
        register.setFirstName(firstName);
        register.setLastName(lastName);
    }

    @And("^user enters date of birth as \"(.*)\" \"(.*)\" \"(.*)\"$")
    public void setDateOfBirth(String Day, String Month, String Year)
    {
        register.setBirthDay(Day);
        register.setBirthMonth(Month);
        register.setBirthYear(Year);
    }

    @And("^user enters email as \"(.*)\"$")
    public void setEmailAddress(String email)
    {
        register.setEmailAddress(email);
    }

    @And("^user enters company name as \"(.*)\"$")
    public void setCompanyName(String companyName)
    {
        register.setCompanyName(companyName);
    }

    @And("^user enters password as \"(.*)\"$")
    public void setPasswordDef(String password)
    {
        register.setPassword(password);
    }

    @And("^user enters confirmation password as \"(.*)\"$")
    public void setPassword(String password)
    {
        register.setConfPassword(password);
    }

    @And("user click register")
    public void userClickRegister()
    {
        register.clickRegister();
    }

    @Then("user could register successfully")
    public void userRegisterSuccessfully()
    {
        SoftAssert soft = new SoftAssert();

        // Check for successful registration message text and color

        soft.assertTrue(register.checkSuccessMsg("Your registration completed"));

        soft.assertTrue(register.checkSuccessMsgClr());

        soft.assertAll();
    }
}
