@SYMU-303
Feature: 
	Background:
		Given the user logged in
	    When the user click user info
	    And the user click Log out

#User can log out and ends up in login page
@SYMU-296
Scenario: User should be able to log out-HA
	Then the user should be able to log out


#User can not go to home page again by clicking step back button after successfully logged out.
@SYMU-298
Scenario: User cannot go back home page after logged out-HA
	When the user click step back button
	Then the user should not see home page


