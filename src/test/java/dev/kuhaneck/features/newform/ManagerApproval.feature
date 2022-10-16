Feature: Manager approval

  Scenario: The manager can approve a request
    Given the manager is on the homepage
    When the manager clicks on manager login
    Then the manager should be on the manager login page
    Then the manager should be on the manager login page
    When the manager types "deputy" into the username input
    When the manager types "zombie" into the password input
    When the manager clicks on the login button
    Then manager should be on the manager homepage
    When the manager clicks on the edit button
    Then the manager should be on the page titled "Approval Page"
    When the manager clicks Approve Reimbursement
    Then the manager should see an alert that the request was approved

    Scenario: The manager can deny a request
      Given the manager is on the homepage
      When the manager clicks on manager login
      Then the manager should be on the manager login page
      Then the manager should be on the manager login page
      When the manager types "deputy" into the username input
      When the manager types "zombie" into the password input
      When the manager clicks on the login button
      Then manager should be on the manager homepage
      When the manager clicks on the edit button
      Then the manager should be on the page titled "Approval Page"
      When the manager clicks deny
      Then the manager should see an alert that the request was denied
