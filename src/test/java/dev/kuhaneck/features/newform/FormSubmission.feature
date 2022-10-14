Feature: Form Submission
  Scenario: The employee can submit a new request
  Given the employee is on the employee homepage
  When the employee fills out a date
  When the employee fills out the location input
  When the employee selects a course type
  When the employee selects a course time
  When the employee fills out the description input
  When the employee fills out the cost input
  When the employee fills out the work relation input
  When the employee clicks submit
  Then the employee should see the form added to the forms table