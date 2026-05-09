Feature: Login to HRM Application

	@ValidCredentials
	Scenario: Login with valid credentials
	
	Given the user is on HRM Page "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
	When the user enters username and password
	Then user should be able to login successfully and should see "Dashboard"