Feature: Validate Scenarios by API

  Background: 
    #Given user gets ncxjwttoken
    Given user set up base uri

  @ExtendOrBridgeCrewFacilities_API @mar17
  Scenario Outline: To Create Studio Production Requests "<scenario_name>"
    When user set up headers
      | Content-Type | application/Json |
      | messageid    | sdsddsd12        |
      | userId       | en               |
    And user read data "<scenario_name>" and create payload for "Create_ExtendOrBridge_Prod_Req"
    Then user invokes "Create_ExtendOrBridge_Prod_Req" service to create new request
      """

      """
    Then validate the status code "<status_code>"
    Then fetch request id "studioRequestID"
    Then validate the "Create_ExtendOrBridge_Prod_Req" response values

    Examples: 
      | scenario_name                                                                                                    | status_code |
      #=========================To Verify Rock Center Request creation with all fields ============================================
      | Creating request with all fields                                                                                                          |         201 |
      #=========================To Verify Rock Center Request creation with only mandatory fields =================================
      #| Creating request with only mandatory fields                                                                                               |         201 |
      #========================To Verify Rock Center Requests creations combinations of All RequestFor and Divisions ==============
      #| Creating request with [Division - NBC News, location - ROCK Centre, RequestFor - Rehearsal]                                               |         201 |
      #| Creating request with [Division - MSNBC, location - ROCK Centre, RequestFor - Rehearsal]                                                  |         201 |
  Scenario Outline: To verify negative scenarios
    When user set up headers
      | Content-Type | application/Json |
      | messageid    | sdsddsd12        |
      | userId       | en               |
    #service in config and sheet name should be same
    And user read data "<scenario_name>" and create payload for "Create_Studio_Prod_Req"
    Then user invokes "Create_Studio_Prod_Req" service to create new request
      """

      """
    Then validate the status code "<status_code>"

    Examples: 
      | scenario_name                                                                  | status_code |
      | Creating request with mandatory fields null and non  mandatory fields not null |         400 |
