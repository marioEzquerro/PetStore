Feature: Validate dogStore functionality

  Scenario: add new order for a pet
    When the user sends the post request
    Then a new order is created

  Scenario Outline: get order by id
    When the user sends the get request by "<id>"
    Then the request contains the order
    Examples:
      | id |
      | 2  |

  Scenario Outline: delete order by id
    When the user sends the delete request "<id>"
    Then the order gets deleted
    Examples:
      | id |
      | 2  |

  Scenario: get all the inventories
    When the user sends the get request
    Then the request is successful



