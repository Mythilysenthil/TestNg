Feature: Login functionality

  Scenario: Verify valid login

    Given User launches application
    When User enters valid username and password
    And User clicks login button
    Then User should login successfully