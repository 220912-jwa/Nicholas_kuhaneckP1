Feature: Manager submission

  Scenario: A manager can submit a request
    Given the manager is on the homepage
    When the manager clicks on manager login
    Then the manager should be on the manager login page
    When the manager types "deputy" into the username input
    When the manager types "zombie" into the password input
    When the manager clicks on the login button
    Then manager should be on the manager homepage
    When the manager clicks on Submit a new request
    Then the manager should be on the page titled "Manager Form Submission"
    When the manager enters a Submission date
    When the manager enters a course location
    When the manager selects a course type
    When the manager selects a course time
    When the manager enters a course description
    When the manager enters a course cost
    When the manager enters a work relation
    When the manager clicks the submit button
    Then the manager should see an alert that the request was submitted