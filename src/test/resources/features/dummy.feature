Feature: login
  @login
  Scenario: login
    Given the user is on login page
    When the user enters valid credentials
    Then the user should be able to login