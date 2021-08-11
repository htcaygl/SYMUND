@SYMU-296
Feature: Log out function

    #1-User can log out and ends up in login page
	#2-User can not go to home page again by clicking step back button after successfully logged out.

 Scenario: User should be able to log out
	Given the user logged in
	When the user click user info and click Log out
	Then the user should be able to log out

@wip
Scenario: User can not go to home page again after successfully logged out
	Given the user logged in
	And the user click user info and click Log out
	When the user click step back button
	Then the user should not see home page


 @login
 Scenario: login
	Given the user is on the login page
	When the user enters valid credentials
	Then the user should be able to login