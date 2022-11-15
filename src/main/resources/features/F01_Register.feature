@smoke
  Feature: Register new account

    Scenario: Register with Valid Input
      Given user go to register page
      When user choose gender as "female"
      And user enters first name as "Jessicca" and last name as "John"
      And user enters date of birth as "23" "February" "1999"
      And user enters email as "Jessiccajohn@gmail.com"
      And user enters company name as "Our Company"
      And user enters password as "p@s$w0rd"
      And user enters confirmation password as "p@s$w0rd"
      And user click register
      Then user could register successfully