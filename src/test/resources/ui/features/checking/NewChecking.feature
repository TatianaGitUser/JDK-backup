Feature: Creating new Checking account

  Scenario: Create a standard individual checking account
    Given the user is logged in as "Tanya@gmail.com" "TanyaTanya1234567!"
    When the user creates a new checking account
      | checkingAccountType | accountOwnership | accountName           | initialDeposit |
      | Standard Checking   | Individual       | Tanya Second Checking | 100000.00      |
    Then the user should see the green confirmation "Confirmation Successfully created new Standard Checking account named Tanya Second Checking" message
    And the user should see newly added account card
      | accountName           | accountType       | ownership  | accountNumber | interestRate | balance   |
      | Tanya Second Checking | Standard Checking | Individual | 486133320     | 0.0%         | 100000.00 |
    And the user should see the following transactions
      | date             | category | description               | amount    | balance   |
      | 2023-12-09 22:56 | Income   | 845324408 (DPT) - Deposit | 100000.00 | 100000.00 |