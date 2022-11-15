package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class P01_register {

    public P01_register() {
        PageFactory.initElements(Hooks.driver, this);
    }


    /************************************************************/
    /*
    * Page Factory elements
    */
    @FindBy(id = "gender-male")
    public WebElement genderMaleRadioButtonPF;

    @FindBy(id = "gender-female")
    public WebElement genderFemaleRadioButtonPF;

    @FindBy(id = "FirstName")
    public WebElement firstNamePF;

    @FindBy(id = "LastName")
    public WebElement lastNamePF;

    @FindBy(name = "DateOfBirthDay")
    public WebElement DateOfBirth_DayPF;

    @FindBy(name = "DateOfBirthMonth")
    public WebElement DateOfBirth_MonthPF;

    @FindBy(name = "DateOfBirthYear")
    public WebElement DateOfBirth_YearPF;

    @FindBy(id = "Email")
    public WebElement emailPF;

    @FindBy(id = "Company")
    public WebElement CompanyPF;

    @FindBy(id = "Password")
    public WebElement passwrdPF;

    @FindBy(id = "ConfirmPassword")
    public WebElement passwrdCnfPF;

    @FindBy(id = "register-button")
    public WebElement registerButtonPF;

    @FindBy(className = "ico-register")
    public WebElement regIcoPF;

    @FindBy(className = "result")
    public WebElement sccuessMsgPF;
    /************************************************************/


    public WebElement registerlink()
    {
        return regIcoPF;
    }

    public void setFirstName(String firstName) {
        // Clear the first name field
        firstNamePF.clear();
        // Input the passed first name string to the field
        firstNamePF.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        // Clear the first name field
        lastNamePF.clear();
        // Input the passed first name string to the field
        lastNamePF.sendKeys(lastName);
    }

    public void setGender(String gender)
    {
        if (gender.equals("male"))
        {
            genderMaleRadioButtonPF.click();
        } else if (gender.equals("female"))
        {
            genderFemaleRadioButtonPF.click();
        }

    }

    public void setBirthDay(String Day)
    {
        Select select = new Select(DateOfBirth_DayPF);
        select.selectByValue(Day);
    }

    public void setBirthMonth(String Month)
    {
        Select select = new Select(DateOfBirth_MonthPF);
        select.selectByVisibleText(Month);
    }

    public void setBirthYear(String Year)
    {
        Select select = new Select(DateOfBirth_YearPF);
        select.selectByValue(Year);

    }

    public void setEmailAddress(String email)
    {
        emailPF.clear();
        emailPF.sendKeys(email);
    }

    public void setCompanyName(String companyName)
    {
        CompanyPF.clear();
        CompanyPF.sendKeys(companyName);
    }

    public void setPassword(String password)
    {
        passwrdPF.sendKeys(password);
    }

    public void setConfPassword(String ConfPassword)
    {
        passwrdCnfPF.sendKeys(ConfPassword);
    }

    public void clickRegister()
    {
        registerButtonPF.click();
    }

    public boolean checkSuccessMsg(String expected)
    {
        String actualRes = sccuessMsgPF.getText();

        return actualRes.contains(expected);
    }

    public boolean checkSuccessMsgClr()
    {
        String actualRes = sccuessMsgPF.getCssValue("color");
        return actualRes.equals("rgba(76, 177, 124, 1)");
    }

}