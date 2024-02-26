@Deposit
  @Smoke
Feature: Positive case deposit
  Scenario: Customer deposits money to his checking account
    Given the user navigates to deposit page in digital bank
    When the user selects his "account" and puts "30.00" and clicks Submit button
    Then the user should be displayed with new Balance card and transactions info table
