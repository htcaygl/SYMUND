@SYMU-303
Feature: 

#User can log out and ends up in login page
@SYMU-296
Scenario: User should be able to log out-HA
	Given the user logged in
	When the user click user info and click Log out
	Then the user should be able to log out


#User can not go to home page again by clicking step back button after successfully logged out.
@SYMU-298
Scenario: User cannot go back home page after logged out-HA
	Given the user logged in
	And the user click user info and click Log out
	When the user click step back button
	Then the user should not see home page


