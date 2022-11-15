@smoke
Feature: Testing social media links
  Scenario: user opens facebook link
    Given user click on fb link
    Then user is directed to fb website

  Scenario: user opens twitter link
    Given user click on twitter link
    Then user is directed to twitter website

  Scenario: user opens rss link
    Given user click on rss link
    Then user is directed to rss website

  Scenario: user opens youtube link
    Given user click on youtube link
    Then user is directed to youtube website