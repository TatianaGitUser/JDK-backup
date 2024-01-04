@Registration
Feature: Digital Bank Sign Up Page

  Background:
    Given the user with "jack@test.co" is not in DB
    And User navigates to Digital Bank account
@Test
  Scenario: Positive case: As a user, I want to successfully create Digital Bank account

    When user creates account with following fields
      | title | firstName | lastName | gender | dob        | ssn         | email        | password  | address    | locality | region | postalCode | country | homePhone | termsCheckMark |
      | Mr.   | Jack      | Test     | M      | 12/12/1990 | 112-23-3698 | jack@test.co | Tester123 | 12 Main St | City     | CA     | 99921      | US      | 123456987 | true           |
    Then the user should be displayed with the message "Success Registration Successful. Please Login"
    And the following user info should be saved in the db
      | title | firstName | lastName | gender | dob        | ssn         | email        | password  | address    | locality | region | postalCode | country | homePhone | termsCheckMark |
      | Mr.   | Jack      | Test     | M      | 12/12/1990 | 112-23-3698 | jack@test.co | Tester123 | 12 Main St | City     | CA     | 99921      | US      | 123456987 | true           |

  @NegativeRegistrationScenarios
  Scenario Outline: Negative test Cases. As a DigitalBank Admin I want to make sure the users cannot register without providing all valid data
    When user creates account with following fields
      | title   | firstName   | lastName   | gender   | dob   | ssn   | email   | password   | address   | locality   | region    | postalCode   | country   | homePhone   | termsCheckMark   |
      | <title> | <firstName> | <lastName> | <gender> | <dob> | <ssn> | <email> | <password> | <address> | <locality> | <region>> | <postalCode> | <country> | <homePhone> | <termsCheckMark> |
    Then the user should see the "<fieldWithError>" required field error message "<errorMessage>"
    Examples:
      | title | firstName | lastName | gender | dob        | ssn         | email           | password     | address | locality | region | postalCode | country | homePhone | termsCheckMark | fieldWithError | errorMessage                        |
      |       |           |          |        |            |             |                 |              |         |          |        |            |         |           |                | title          | Please select an item in the list.  |
      | Mr.   |           |          |        |            |             |                 |              |         |          |        |            |         |           |                | firstName      | Please fill out this field.         |
      | Mr.   | James     |          |        |            |             |                 |              |         |          |        |            |         |           |                | lastName       | Please fill out this field.         |
      | Mr.   | James     | Jameson  |        |            |             |                 |              |         |          |        |            |         |           |                | gender         | Please select one of these options. |
      | Mr.   | James     | Jameson  | M      |            |             |                 |              |         |          |        |            |         |           |                | dob            | Please fill out this field.         |
      | Mr.   | James     | Jameson  | M      | 12/12/1992 |             |                 |              |         |          |        |            |         |           |                | ssn            | Please fill out this field.         |
      | Mr.   | James     | Jameson  | M      | 12/12/1992 | 989-98-9988 |                 |              |         |          |        |            |         |           |                | email          | Please fill out this field.         |
      | Mr.   | James     | Jameson  | M      | 12/12/1992 | 989-98-9988 | lames@gmail.com |              |         |          |        |            |         |           |                | password       | Please fill out this field.         |
      | Mr.   | James     | Jameson  | M      | 12/12/1992 | 988-98-9987 | lames@gmail.com | JamesPidor1! |         |          |        |            |         |           |                | address        | Please fill out this field.         |