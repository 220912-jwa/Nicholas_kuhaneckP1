Feature: Login

  Scenario: Login with correct username and incorrect password
    Given the employee is on the homepage
    When the employee clicks on employee login
    Then the employee should be on the employee login page
    When the employee types "spaceman" into the username input
    When the employee types "zombie" into the password input
    When the employee clicks on the login button
    Then employee should not be logged in

  Scenario: Login with incorrect username and correct password
    Given the employee is on the homepage
    When the employee clicks on employee login
    Then the employee should be on the employee login page
    When the employee types "deputy" into the username input
    When the employee types "password" into the password input
    When the employee clicks on the login button
    Then employee should not be logged in