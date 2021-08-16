@SYMU-321
Feature: 

  Background:
    Given the user is on login page

	#As a user, I should be able to login
  @SYMU-305
  Scenario: Verify that user should be able to login with valid credentials
    When the user enters valid credentials
    And the user click Login button
    Then the user should be able to login
    And username should be seen under Profile icon

	#User can not login with any invalid credentials
  @SYMU-307
  Scenario Outline: Verify that user can not login with invalid credentials <username> and <password>
    When the user enters "<username>" and "<password>"
    And the user click Login button
    Then "Wrong username or password." error message should be seen
    And the user should not be able to login

    Examples:
      | username    |  | password    |
      | wrong       |  | wrong       |
      | Employee101 |  | password    |
      | username    |  | Employee123 |
      | Employee101 |  | employee123 |
      | employee101 |  | Employee123 |
      | EMPLOYEE101 |  | Employee123 |

	#User can not login with invalid credentials
  @SYMU-306
  Scenario: Verify that user should be able to login by pressing "Enter" key
    When the user enters valid credentials
    And the user presses Enter key
    Then the user should be able to login
    And username should be seen under Profile icon

	#User can not login with any invalid credentials
  @SYMU-310
  Scenario Outline: Verify that user should see Error when <type> is left blank
    When the user left "<type>" as blank
    And the user click Login button
    Then Please fill in this field message for "<type>" should be seen
    And the user should not be able to login

    Examples:
      | type     |
      | username |
      | password |
		    	

	#User can see the password in a form of dots by default
  @SYMU-311
  Scenario: Verify that user can see the password in a form of dots
    When the user enters valid credentials
    Then the user can see password in a form of dots by default


	#User can see password explicitly if needed
  @SYMU-312
  Scenario: Verify that user should be able to see password explicitly
    When the user enters valid credentials
    And the user click "Eye Icon"
    Then the user should be able to see password explicitly


	#User can see an option link like "forgot password" on the login page to be able to reset the password
  @SYMU-318
  Scenario: Verify that user can see "forgot password" on the login page
    Then the link "Forgot password?" should be displayed on the login page


	#User can see "Reset password" button to be able to reset the password
  @SYMU-319
  Scenario: Verify that user should be able to see "Reset password" button
    When the user click "Forgot password?"
    Then Reset password button should be seen


	#User can see valid placeholders on Username and Password fields.
  @SYMU-320
  Scenario Outline: Verify that user can see valid placeholder on <type> field
    Then the user should be able to see "<text>" for "<type>" field

    Examples:
      | type     |  | text              |
      | Username |  | Username or email |
      | Password |  | Password          |