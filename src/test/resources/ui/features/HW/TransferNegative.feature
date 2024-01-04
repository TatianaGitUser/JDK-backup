Feature: Transfer between accounts negative case
  Scenario: User is trying to transfer funds leaving required fields empty
    Given The user has registered on dbank website and opened two new accounts
    When the user is trying to transfer funds from one account to another leaving a required field empty
    Then the user should see the error message
