Feature: Update existing user
  Scenario: Updating existing random user with new randon user
    Given the user updates his existing info
    When he clicks submit button
    Then he should see the confirmation message