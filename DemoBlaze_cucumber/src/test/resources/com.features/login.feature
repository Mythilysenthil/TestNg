Feature: Login functionality of DemoBlaze

  Background:
    Given User navigates to "https://www.demoblaze.com"
    And User clicks on Login link

  @ValidLogin
  Scenario: Login with valid credentials
    When User enters username "admin"
    And User enters password "admin"
    And User clicks on Login button
    Then User should see the welcome message with username

  @InvalidLogin
  Scenario: Login with invalid credentials
    When User enters username "Mythily"
    And User enters password "mythily"
    And User clicks on Login button
    Then User should see an error alert message

  @EmptyLogin
  Scenario: Login with empty credentials
    When User clicks on Login button
    Then User should see an alert for empty credentials