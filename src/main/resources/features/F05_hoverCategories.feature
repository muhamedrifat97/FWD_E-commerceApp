@smoke
  Feature: hover categories

    Scenario: hover on random category
      Given user will hover on random category of the three main categories
      And select random one of the three sub categories
      Then verify the subcategory title