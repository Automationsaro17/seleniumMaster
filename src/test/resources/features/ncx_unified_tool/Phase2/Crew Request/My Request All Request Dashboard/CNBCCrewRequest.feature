@CNBCCrewRequest @ProducerDashboard @Dashboard_Validation
Feature: Validate various scenarios related CNBC Crew

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role

  @CNBCCrewRequest_MyRequest_Dashboard_AllRequest_Dashboard_Validation
  Scenario Outline: Verify user filling CNBC Crew Request form and validating in my request and all request dashboard
    And user clicks on forms link
    And user selects "<Form Name>" form
    Then user enters General info in CNBC Crew form
      | Slug   | NCX Story Name | Additional Requesters | Is Producer Same as Requestor | Sr Producer   | Is Onsite Producer | Talent   |
      | <Slug> |                | <Requesters>          | <Producer>                    | <Sr Producer> | Yes                | <Talent> |
    When user enters field contact Information in CNBC Crew form
      | Field Contact | Phone      |
      | Jeevanandham  | 9898989877 |
    When user enters show title Information in CNBC Crew form
      | ShowTitle    |
      | <Show Title> |
    When user enters shoot details Information in CNBC Crew form
      | Production Type | Shoot Status   | Shoot Description   |
      | LIVE - Anchor   | <Shoot Status> | test/tesr/test/test |
    When user enters shoot specs Information in CNBC Crew form
      | Audio Needs   | Special Conditions | Transmission Type | Is this a Drone Shoot | Special Gear |
      | Complex Audio | Weather concern    | LIVEU             | No                    | No           |
    When user enters shoot location Information in CNBC Crew form
      | Shoot Location   | Risk Assessment Category | Risk Assessment Type | Risk Arrangements | Risk Approver |
      | <Shoot Location> |                          |                      |                   |               |
    When user enters Date & Time Information in CNBC Crew form
      | Shoot Start Date   | Shoot End Date   | Time Zone | Meet Time   | Start Time    | End Time      |
      | <Shoot Start Date> | <Shoot End Date> | PT        | <Meet Time> | CurrentTime+2 | CurrentTime+3 |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    And verify submitted "<Form Name>" is present in my request page with "NEW" status
    And verify "background color" of "NEW" status is "Pink" in my request page
    When user searches request in my request page
    Then verify all fields in the CNBC Crew form are matching with columns in My Request dashboard
      | Slug   | Submitted   | Prod Date   | Show Title   |
      | <Slug> | CurrentDate | <Prod Date> | <Show Title> |
    When user clicks on "All Requests" button
    Then verify all fields in the CNBC Crew form are matching with columns in All Request dashboard
      | Requesters   | Slug   | Submitted   | Prod Date   | Show Title   |
      | <Requesters> | <Slug> | CurrentDate | <Prod Date> | <Show Title> |

    Examples: #Resource Standard
      | Form Name | Dashboard Name | Slug | Requesters         | Producer | Sr Producer  | Talent                                          | Show Title | Shoot Status | Shoot Location | Shoot Start Date | Shoot End Date | Meet Time     |
      | CNBC Crew | Resource       | Wind | Solai-Jeevanandham | Magesh   | Jeevanandham | test1/test1/test1/test1-test2/test2/test2/test2 | CNBC,News  | Tent         | Houston Bureau | CurrentDate+3    | CurrentDate+9  | CurrentTime+1 |
