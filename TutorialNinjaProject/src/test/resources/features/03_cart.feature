Feature: MYTHILY_SENTHIL_CART

Background:
Given the user launches the application

@Cart
Scenario: Verify add products to cart

When user adds products to cart
| MacBook |
| iPhone |
| Samsung SyncMaster 941BW |

Then user opens the cart