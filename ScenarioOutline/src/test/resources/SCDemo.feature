Feature: Login in the DemoBalze

@InvalidCredentials
Scenario Outline: Login with invalid credentials

   Given User is on Home page
   When User enters username as "<username>"  and password as "<password>"
   And when user click the login link
   Then User should be able to see an "<errormsg>"
   
Examples:
   |username |password  |errormsg                              |
   |admin    |mythily   |Wrong password.                       |
   |admin-   |admin     |User does not exist.                  |
   |         |          |Please fill out Username and Password.|