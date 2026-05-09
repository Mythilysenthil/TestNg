Feature: MYTHILY_SENTHIL_REGISTER

Background:
Given the user launches the application

@ValidRegistration
Scenario: Verify registration with valid credentials

Given the user is on register page
When the user enters the valid cedentials
| Mythily | Senthil | mythilysenthil2026@gmail.com | 9876543210 | 1234 | 1234 |
And click continue
Then the greet message should appear as "Your Account Has Been Created!"
And user should be logged in successfully