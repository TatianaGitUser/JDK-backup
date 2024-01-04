@WithdrawFromSavings
Feature: Creating new Savings account and withdraw

  Scenario Outline: Create a savings individual account
    Given the user is logged in as new user
    When the user creates a new savings account with new credentials
      | accountType   | ownership   | accountName   | initialDeposit   |
      | <accountType> | <ownership> | <accountName> | <initialDeposit> |
    And the user withdraws $"<withdrawalAmount>"
    Then the user should see the balance confirmation "<confirmationMessage>" message
    And the user should see the following transactions data
      | date   | description   | amount   | balance   | errorMessage   |
      | <date> | <description> | <amount> | <balance> | <errorMessage> |
    Examples:
      | accountType | ownership  | accountName  | initialDeposit | confirmationMessage | withdrawalAmount | date   | description   | amount   | balance   | errorMessage                                                                                              |
#      | Savings     | Individual | TanyaAccount | 225.00         | Balance: $165.00    | 60.00            | <date> | <description> | <amount> | <balance> |                                                                                                           |
#      | Savings     | Individual | TanyaAccount | 25.00          | Balance: $-35.00    | 10.00            | <date> | <description> | <amount> | <balance> | The withdraw amount ($60.00) is greater than the available balance ($25.00) and overdraft limit ($25.00). |
      | Savings     | Individual |       TanyaAccount       | 25.00          | Balance: $-35.00    | 10.00            | <date> | <description> | <amount> | <balance> | Please select an item in the list.                                                                        |