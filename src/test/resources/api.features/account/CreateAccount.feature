Feature: Create Account Test Scenarios

  Scenario: Create a valid account
    Given the user with "stevejobs@apple.com" is not in DB

    Given the following user is in the DB
      | title | firstName | lastName | gender | dob        | ssn         | emailAddress        | password | address         | locality | region | postalCode | country | homePhone   | mobilePhone |
      | Mr.   | Steve     | Jobs     | M      | 02/17/1949 | 569-45-1236 | stevejobs@apple.com | Test123$ | 1 Infinite Loop | CA       | CA     | 99009      | USA     | 987-899-997 |             |
    When the user opens an account with the following credentials
      | accountName                         | accountTypeCode | openingDeposit | ownerTypeCode |
      | Test Account Standard SCK # +100500 | SCK             | 700.30         | IND           |
    Then the following account info should be returned in the response
      | accountName                         | accountTypeCode | openingDeposit | ownerTypeCode |accountStandingName |
      | Test Account Standard SCK # +100500 | SCK             | 700.30         | IND           | Open               |
    And the following account details are saved in the db

  Scenario: Create an account with wrong account name


  Scenario: Create an account with wrong Account Type Code

  Scenario: Create an account with wrong opening deposit

  Scenario: Create an account with wrong owner type code