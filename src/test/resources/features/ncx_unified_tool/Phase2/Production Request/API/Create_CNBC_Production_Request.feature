Feature: Validate various scenarios related NBC Crew Request

  Background: 
    Given user set up base uri

  @mar10
  Scenario Outline: To Create CNBC Production Request with mandatory fields
    When user set up headers
      | Content-Type | application/Json |
      | messageid    | sdsddsd12        |
      | userId       | en               |
    And user read data "<rowdata>" and create payload for "Create_CNBC_Production_Request"
    Then user invokes "Create_CNBC_Production_Request" service to create new request
      """

      """
    Then validate the status code "201"
    Then fetch request id "studioRequestID"

    Examples: 
      | rowdata |
      |       1 |
      |       2 |
      |       3 |
      |       4 |
      |       5 |
      |       6 |
      |       7 |
      |       8 |
      |       9 |
      |       10 |
      |       11 |
      |       12 |
      |       13 |
      |       14 |
      |       15 |
      |       16 |
      |       17 |
      
