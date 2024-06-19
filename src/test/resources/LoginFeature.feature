Feature: Login feature

@test
Scenario: Verify Login Scenario with correct Username and Password
	Given User is on login page
	When User enters username as "standard_user"
	When User enters password as "secret_sauce"
	When User clicks on Login button
	Then User verify login successful as "PRODUCTS" 

@test1
Scenario: Verify Login Scenario with correct Username and incorrect Password
	Given User is on login page
	When User enters username as "standard_user"
	When User enters password as "abcdef@1"
	When User clicks on Login button
	Then User verify error screen 