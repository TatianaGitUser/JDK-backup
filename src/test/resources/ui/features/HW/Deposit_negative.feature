Feature: Negative case Deposit
  Scenario: User deposits funds unsuccessfully
    Given The user navigates to deposit page
    When the user leaves the account field unselected
    Then the user should not be able to submit transaction