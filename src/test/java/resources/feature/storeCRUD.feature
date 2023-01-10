Feature: Store Application

  As a user I want to test the Store api

  Scenario Outline: Store CRUD Test
    Given Best buy API playground in running
    When  I create a new store by providing the information name "<name>" type "<type>" address "<address>" address2 "<address2>" city "<city>" state "<state>" zip "<zip>" lat "<lat>" lng "<lng>" hours "<hours>" service1 "<service1>" service2 "<service2>"
    Then  I verify the store with name "<name>" is created
    And   I update the store with information name "<name>" type "<type>" address "<address>" address2 "<address2>" city "<city>" state "<state>" zip "<zip>" lat "<lat>" lng "<lng>" hours "<hours>" service1 "<service1>" service2 "<service2>"
    And   I verify that the store with the name "<name>" has been updated successfully
    And   I delete the store created with name "<name>"
    Then  I verify that the store is deleted successfully from the database

    Examples:
      | name        | type | address     | address2  | city         | state        | zip   | lat     | lng       | hours               | service1   | service2 |
      | Mat Lam Tam | T5   | Morningstar | Suite 84  | Philadelphia | Pennsylvania | 19151 | 39.9772 | -75.2545  | Mon-Fri 8am to  8pm | Service ID | S2       |
      | Zathin      | T1   | Anhalt      | Room 1432 | Long Beach   | California   | 90805 | 33.8635 | -118.1801 | Mon-Fri 8am to  8pm | Service ID | S3       |

