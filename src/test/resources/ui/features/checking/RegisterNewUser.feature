Feature: Register new user
  Scenario: Successfully register new user
    Given The user is on the main page of dbank and clicked "Sign Up Here" button
    When the user provides new credentials
#    |title | firstName | lastName | gender | dob | ssn | email | password | confirmation |

    And clicked "Next" button
    And privided new credentials on the next page
    And clicked "Submit" button
    Then the user should see confirmation message
