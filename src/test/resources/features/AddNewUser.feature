Feature: Create New User

  Scenario Outline: Open Site and Add New User
    Given the user is on the way to automation site
    When the user clicks on the add new user button
    And the user captures the first name "<firstName>" for the new user
    And the user captures the last name "<lastName>" for the new user
    And the user captures the user name "<userName>" for the new user
    And the user captures the password "<password>" for the new user
    And the user selects the customer company "<customer>" option for the new user
    And the user selects the role "<role>" for the new user
    And the user captures the email "<email>" for the new user
    And the user captures the cellphone number "<cell>" for the new user
    Then the user clicks on the save button
    And the new user is added into the User List Table

    Examples:
      | firstName | lastName | userName | password | customer    | role     | email              | cell   |
      | FName1    | LName1   | User     | Pass1    | Company AAA | Admin    | admin@mail.com     | 082555 |
      | FName2    | LName2   | User     | Pass2    | Company BBB | Customer | customer@smail.com | 083444 |