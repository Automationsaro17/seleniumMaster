@CREW_REQUEST @NBC_BREAKING_NEWS
Feature: Validate various scenarios related breaking news crew request

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role

  @NBCBreakingNewsCrewRequest_Basic_Flow
  Scenario Outline: Verify user filling NBC Breaking News Crew Request form
    And user clicks on forms link
    And user selects "<Form Name>" form
    Then user enters General info in NBC Breaking News Crew form
      | Slug | NCX Story Name | Additional Requesters | Is Producer Same as Requestor | Sr Producer  | Is Onsite Producer | Talent              |
      | Wind |                | Solai                 | Magesh                        | Jeevanandham | Yes                | test/tesr/test/test |
    When user enters field contact Information in NBC Breaking News Crew form
      | Field Contact | Phone      |
      | Jeevanandham  | 9898989877 |
    When user enters show title Information in NBC Breaking News Crew form
      | ShowTitle |
      | CNBC      |
    When user enters shoot details Information in NBC Breaking News Crew form
      | Shoot Description   |
      | test/tesr/test/test |
    When user enters shoot specs Information in NBC Breaking News Crew form
      | Transmission Type | Is this a Drone Shoot |
      | LIVEU             | No                    |
    When user enters shoot location Information in NBC Breaking News Crew form
      | Shoot Location | Risk Assessment Category | Risk Assessment Type | Risk Arrangements | Risk Approver |
      | Miami Bureau   |                          |                      |                   |               |
    When user enters Date & Time Information in NBC Breaking News Crew form
      | Time Zone | Meet Time     | Start Time    | End Time      |
      | PT        | CurrentTime+1 | CurrentTime+2 | CurrentTime+3 |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    And user logs out from application

    Examples: 
      | Form Name         |
      | NBC Breaking News |

  @NBCBreakingNewsCrewRequest_combination_TransmissionType_location_timeZone
  Scenario Outline: Verify user filling NBC Breaking News Crew Request form with different Location, Timezone
    And user clicks on forms link
    And user selects "<Form Name>" form
    Then user enters General info in NBC Breaking News Crew form
      | Slug | NCX Story Name | Additional Requesters | Is Producer Same as Requestor | Sr Producer  | Is Onsite Producer | Talent              |
      | Wind |                | Solai                 | Magesh                        | Jeevanandham | Yes                | test/tesr/test/test |
    When user enters field contact Information in NBC Breaking News Crew form
      | Field Contact | Phone      |
      | Jeevanandham  | 9898989877 |
    When user enters show title Information in NBC Breaking News Crew form
      | ShowTitle |
      | CNBC      |
    When user enters shoot details Information in NBC Breaking News Crew form
      | Shoot Description   |
      | test/tesr/test/test |
    When user enters shoot specs Information in NBC Breaking News Crew form
      | Transmission Type   | Is this a Drone Shoot |
      | <Transmission Type> | No                    |
    When user enters shoot location Information in NBC Breaking News Crew form
      | Shoot Location | Risk Assessment Category | Risk Assessment Type | Risk Arrangements | Risk Approver |
      | <Location>     |                          |                      |                   |               |
    When user enters Date & Time Information in NBC Breaking News Crew form
      | Time Zone   | Meet Time     | Start Time    | End Time      |
      | <Time Zone> | CurrentTime+1 | CurrentTime+2 | CurrentTime+3 |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    And user logs out from application

    Examples: 
      | Form Name         | Transmission Type | Location       | Time Zone |
      | NBC Breaking News | LIVEU             | Chicago Bureau | ET        |
      | NBC Breaking News | OTHER             | Miami Bureau   | CT        |
      | NBC Breaking News | FIBER/FIXED       | Houston Bureau | PT        |
      | NBC Breaking News | LATAKOO           | other          | GMT       |
      | NBC Breaking News | LATAKOO           | other          | GMT       |
      | NBC Breaking News | LIVEU             | Chicago Bureau | ET        |
      | NBC Breaking News | OTHER             | Miami Bureau   | CT        |
