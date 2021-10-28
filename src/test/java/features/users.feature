@Regression
Feature: User Add/Delete Functionality

  @Regression
  Scenario Outline: Add User Functionality
    Given I opened the url
    When I clicked on Add User Button
    And I filled "<FirstName>", "<LastName>", "<username>", "<password>", "<customer>", "<Role>", "<Email>", "<CellPhone>" values in form
    And I click on save button
    Then Verify new user is added with username "<username>"
    Examples:
      | FirstName | LastName | username | password | customer    | Role  | Email       | CellPhone  |
      | shd       | xyz      | shdxyz   | abc@123  | Company AAA | Admin | 123@abc.com | 9999999999 |

  @Regression
  Scenario Outline: Delete User Functionality
    Given I opened the url
    When I clicked delete button for user with username as "<username>"
    And I clicked on Ok button
    Then Verify that user "<username>" is not available in table
    Examples:
      | username |
      | novak    |