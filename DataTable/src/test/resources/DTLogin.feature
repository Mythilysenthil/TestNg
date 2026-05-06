Feature: Login in the DemoBalze

@InvalidCredentials
Scenario: Login with invalid credentials

  Given User is on Home page
  When User enters valid credentials
     | admin | admin |
  And when user click the loginlink   
  Then User should be able to login successfully and new page open