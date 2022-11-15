@smoke
  Feature: F02_Login | users could use login functionality to use their accounts

    Background:
      Given user navigates to login page

    Scenario: user could login with valid email and password
      Given user login with valid "Jessiccajohn@gmail.com" and "p@s$w0rd"
      When user press on login button
      Then user login to the system successfully
      And is navigated to the correct url


    Scenario: user could login with invalid email and password
      Given user login with valid "invalid@gmail.com" and "invalid"
      When user press on login button
      Then user could not login to the system