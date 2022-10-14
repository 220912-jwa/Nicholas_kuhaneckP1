Feature: Login

  Scenario: Login with correct credentials
    Given the employee is on the homepage
    When the employee clicks on employee login
    Then the employee should be on the employee login page
    When the employee types "spaceman" into the username input
    When the employee types "password" into the password input
    When the employee clicks on the login button
    Then employee should be on the employee homepage