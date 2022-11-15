@smoke
  Feature: Wish-list
    Background:
      Given user press add to wishlist button
    Scenario: Adding HTC One M8 Android to wishlist
      Given success message is previewed

    Scenario: Checking the quantity of elements in the wishlist
      Then user navigate to wishlist page
      And user have elements with quantity more than zero in the list