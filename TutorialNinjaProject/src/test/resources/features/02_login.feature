Feature: MYTHILY_SENTHIL_LOGIN

Background:
Given the user launches the application

@ValidLogin
Scenario Outline: Verify login with valid credentials

Given the user is on login page
When the user enters the valid email as "<email>"
And the user enters the valid password as "<password>"
And click login
Then the link should appear as "<linkText>"

Examples:
| email            | password | linkText                        |
| dummy@gmail.com  | 1234     | Edit your account information |