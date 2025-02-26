Feature: Validate Scenarios by API

  Background: 
    #Given user gets ncxjwttoken
    Given user set up base uri

  @Create_AnimalsOnPremises_Prod_Req @mar17
  Scenario Outline: To Create Studio Production Requests "<scenario_name>"
    When user set up headers
      | Content-Type | application/Json |
      | messageid    | sdsddsd12        |
      | userId       | en               |
    And user read data "<scenario_name>" and create payload for "Create_AnimalsOnPremises_Prod_Req"
    Then user invokes "Create_AnimalsOnPremises_Prod_Req" service to create new request
      """

      """
    Then validate the status code "<status_code>"
    Then fetch request id "studioRequestID"
    Then validate the "Create_AnimalsOnPremises_Prod_Req" response values

    Examples: 
      | scenario_name                                                                                                    | status_code |
      #=========================To Verify AnimalsOnPremises Prod Req creation with all fields ============================================
      | Creating request with all fields                                                                                                          |         201 |
      #=========================To Verify AnimalsOnPremises ProdRequest creation with only mandatory fields =================================
      #| Creating request with only mandatory fields                                                                                               |         201 |
      #========================To Verify AnimalsOnPremises Prod Req creations combinations of All RequestFor and Divisions ==============
      #| Creating request with [Division - NBC News, location - ROCK Centre, RequestFor - Rehearsal]                                               |         201 |
      