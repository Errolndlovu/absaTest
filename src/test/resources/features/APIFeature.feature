Feature: API Tests

  Scenario Outline: Performing API calls

    Given a user requests for a list of all breeds
    When the user verifies the retriever "<retriever>" is within the list
    Then the user requests to produce a list of sub breeds for retriever
    And the user requests for a random image or link for the sub-breed golden "<golden>"
    Examples:
      | retriever | golden |
      | retriever | golden |