Feature: Login in the DemoBalze

  Background:
    Given User on the Home Page
    And User clicks on Login link

  @ValidCredentials
  Scenario Outline: Login with valid credentials
    When User enters valid username as "<email>" and password as "<password>"
    And when user click the login link
    Then User should be able to see the dashboard

    Examples:
      | email             | password |
      | mythily@gmail.com | mythily  |

  @InvalidCredentials
  Scenario Outline: Login with invalid credentials
    When User enters invalid username as "<email>" and password as "<password>"
    And when user click the login link
    Then User should be able to see the "<errormsg>"

    Examples:
      | email             | password   | errormsg                                              |
      | mythily@gmail.com | mythily123 | Warning: No match for E-Mail Address and/or Password. |
