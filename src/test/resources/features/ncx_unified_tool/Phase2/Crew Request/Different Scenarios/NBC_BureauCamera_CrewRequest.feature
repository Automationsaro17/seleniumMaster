@CREW_REQUEST @NBC_BUREAU_CAMERA
Feature: Validate various scenarios related bureau camera crew request

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role

  @NBCBureauCameraCrewRequest_Basic_Flow
  Scenario Outline: Verify user filling NBC Bureau Camera Crew Request form
    And user clicks on forms link
    And user selects "<Form Name>" form
    Then user enters General info in NBC Bureau Camera Crew form
      | Slug | NCX Story Name | Additional Requesters | Is Producer Same as Requestor | Sr Producer  | Is Onsite Producer | Talent              |
      | Wind |                | Solai                 | Magesh                        | Jeevanandham | Yes                | test/tesr/test/test |
    When user enters show title Information in NBC Bureau Camera Crew form
      | ShowTitle |
      | CNBC      |
    When user enters shoot details Information in NBC Bureau Camera Crew form
      | Shoot Description   |
      | test/tesr/test/test |
    When user enters shoot location Information in NBC Bureau Camera Crew form
      | Shoot Location | Risk Assessment Category | Risk Assessment Type | Risk Arrangements | Risk Approver |
      | Miami Bureau   |                          |                      |                   |               |
    When user enters Date & Time Information in NBC Bureau Camera Crew form
      | Shoot Start Date | Shoot End Date | Time Zone | Meet Time     | Start Time    | End Time      |
      | CurrentDate+6    | CurrentDate+9  | PT        | CurrentTime+1 | CurrentTime+2 | CurrentTime+3 |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    And user logs out from application

    Examples: 
      | Form Name         |
      | NBC Bureau Camera |

  @NBCBureauCameraCrewRequest_combination_location_timeZone
  Scenario Outline: Verify user filling NBC Bureau Camera Crew Request form with different Location, Timezone
    And user clicks on forms link
    And user selects "<Form Name>" form
    Then user enters General info in NBC Bureau Camera Crew form
      | Slug | NCX Story Name | Additional Requesters | Is Producer Same as Requestor | Sr Producer  | Is Onsite Producer | Talent              |
      | Wind |                | Solai                 | Magesh                        | Jeevanandham | Yes                | test/tesr/test/test |
    When user enters show title Information in NBC Bureau Camera Crew form
      | ShowTitle |
      | CNBC      |
    When user enters shoot details Information in NBC Bureau Camera Crew form
      | Shoot Description   |
      | test/tesr/test/test |
    When user enters shoot location Information in NBC Bureau Camera Crew form
      | Shoot Location | Risk Assessment Category | Risk Assessment Type | Risk Arrangements | Risk Approver |
      | <Location>     |                          |                      |                   |               |
    When user enters Date & Time Information in NBC Bureau Camera Crew form
      | Shoot Start Date | Shoot End Date | Time Zone   | Meet Time     | Start Time    | End Time      |
      | CurrentDate+6    | CurrentDate+9  | <Time Zone> | CurrentTime+1 | CurrentTime+2 | CurrentTime+3 |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    And user logs out from application

    Examples: 
      | Form Name         | Location       | Time Zone |
      | NBC Bureau Camera | Chicago Bureau | ET        |
      | NBC Bureau Camera | Miami Bureau   | CT        |
      | NBC Bureau Camera | Houston Bureau | PT        |
      | NBC Bureau Camera | other          | GMT       |
      | NBC Bureau Camera | other          | GMT       |
      | NBC Bureau Camera | Chicago Bureau | ET        |
      | NBC Bureau Camera | Miami Bureau   | CT        |
