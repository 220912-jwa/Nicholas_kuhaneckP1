Feature: Login

  Scenario: Login with correct credentials
    Given the manager is on the homepage
    When the manager clicks on manager login
    Then the manager should be on the manager login page
    When the manager types "deputy" into the username input
    When the manager types "zombie" into the password input
    When the manager clicks on the login button
    Then manager should be on the manager homepage