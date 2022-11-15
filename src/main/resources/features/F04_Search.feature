@smoke
  Feature: Searching for multiple values

    Scenario Outline: user could search using product name
      Given user searches for "<productName>"
      Then search shows relevant results
      And user is navigated to the correct url
      Examples:
      |productName|
      |   book    |
      |  laptop   |
      |   nike    |


    Scenario Outline: user could search for product using sku
      Given user searches for "<serialNumber>"
      Then click on the product in the search result
      And verify the sku is contained in the product page
      Examples:
        |serialNumber|
        | SCI_FAITH  |
        | APPLE_CAM  |
        | SF_PRO_11  |