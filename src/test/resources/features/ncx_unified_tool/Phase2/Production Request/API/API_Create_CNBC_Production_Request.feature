Feature: CNBC Production Request API Validations 

  Background: 
    Given user set up base uri

  @CNBC_CREATION_SERVICE @apr23
  Scenario Outline: To Create CNBC Production Requests "<scenario_name>"
    When user set up headers
      | Content-Type | application/Json |
      | messageid    | sdsddsd12        |
      | userId       | en               |
    And user read data "<scenario_name>" and create payload for "Create_CNBC_Prod_Req"
    Then user invokes "Create_CNBC_Prod_Req" service to create new request
      """

      """
    Then validate the status code "<status_code>"
    Then fetch request id "studioRequestID"
    Then validate the "Create_CNBC_Prod_Req" response values

    Examples: 
      | scenario_name                    | status_code |
      #=========================To Verify CNBC Production Request creation with all fields ============================================
      | Creating request with all fields |         201 |

  @CNBC_NEGATIVE_SCENARIO
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
      |      10 |
      |      11 |
      |      12 |
      |      13 |
      |      14 |
      |      15 |
      |      16 |
      |      17 |
