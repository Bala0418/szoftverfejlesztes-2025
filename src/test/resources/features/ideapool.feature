Feature: WeAreCommunity page tests

  Scenario: Check card content on Communities page (Passing)
    Given the main page is opened
    When the Communities button is clicked on
    Then the page should be loaded

    Then then card should be present
    And the title of the 3. card should be "We are Community"

  Scenario: Check card content on Communities page (Failing)
    Given the main page is opened
    When the Communities button is clicked on
    Then the page should be loaded

    Then then card should be present
    And the title of the 1. card should be "We are Community"

