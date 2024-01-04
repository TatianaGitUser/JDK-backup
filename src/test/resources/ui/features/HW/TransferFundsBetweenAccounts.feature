Feature: Transfer funds
  Scenario: The user successfully transfers funds from Account1 to Account2
    Given The user has registered at dbank and created two accounts
    When the user transfers money from one account to another
    Then the user should see updated balance in the destination account