package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P02_login {
    public P02_login() {
        PageFactory.initElements(Hooks.driver, this);
    }

    /************************************************************/
    /*
    *   Page Factory Elements
     */

    @FindBy(className = "ico-login")
    public WebElement regLoginPF;

    @FindBy(id = "Email")
    public WebElement emailPF;

    @FindBy(id = "Password")
    public WebElement passwordPF;

    @FindBy(className = "login-button")
    public WebElement loginButtonPF;

    @FindBy(className = "validation-summary-errors")
    public WebElement invalidLoginErrorPF;

    @FindBy(className = "ico-account")
    public WebElement myAccountPF;

    /************************************************************/

    public String currentURL = Hooks.driver.getCurrentUrl();
    public WebElement loginLink()
    {
        return regLoginPF;
    }

    public void setEmail(String email){
        emailPF.clear();
        emailPF.sendKeys(email);
    }

    public void setPassword(String password){
        passwordPF.clear();
        passwordPF.sendKeys(password);
    }

    public void Submit()
    {
        loginButtonPF.click();
    }

    public boolean checkErrorMsg(String expected)
    {
        String actualRes = invalidLoginErrorPF.getText();
        return actualRes.contains(expected);
    }

    public boolean checkSuccess()
    {
        return myAccountPF.isDisplayed();
    }

    public boolean checkErrMsgClr()
    {
        String actualRes = invalidLoginErrorPF.getCssValue("color");
        return actualRes.equals("rgba(228, 67, 75, 1)");
    }

}
