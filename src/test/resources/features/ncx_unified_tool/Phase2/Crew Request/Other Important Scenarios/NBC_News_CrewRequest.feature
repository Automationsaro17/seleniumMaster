@NBCNewsCrewRequest @ProducerDashboard
Feature: Validate various Important scenarios related NBC News Crew

  Background:
    Given user opens producer dashboard application
    And user logins with "producer" role

  @SEVERITY=CRITICAL @SR
  Scenario Outline: Verify Resource Override Scenario in NBC News Crew Request form
    And user clicks on forms link
    And user selects "<Form Name>" form
    Then user enters General info in NBC News Crew form
      | Slug | NCX Story Name | Additional Requesters | Is Producer Same as Requestor | Sr Producer  | Is Onsite Producer | Talent              |
      | Wind |                | Solai                 | Magesh                        | Jeevanandham | Yes                | test/tesr/test/test |
    When user enters field contact Information in NBC News Crew form
      | Field Contact | Phone      |
      | Jeevanandham  | 9898989877 |
    When user enters show title Information in NBC News Crew form
      | ShowTitle |
      | CNBC      |
    When user enters shoot details Information in NBC News Crew form
      | Production Type | Shoot Status | Shoot Description   |
      | LIVE - Anchor   | Tent         | test/tesr/test/test |
    When user enters shoot specs Information in NBC News Crew form
      | Audio Needs   | Special Conditions | Transmission Type | Acquisition Specs | Is this a Drone Shoot | Special Gear |
      | Complex Audio | Weather concern    | LIVEU             | Defer to Crew     | No                    | No           |
    When user enters shoot location Information in NBC News Crew form
      | Shoot Location | Risk Assessment Category | Risk Assessment Type | Risk Arrangements | Risk Approver |
      | Miami Bureau   |                          |                      |                   |               |
    When user enters Date & Time Information in NBC News Crew form
      | Shoot Start Date | Shoot End Date | Time Zone | Meet Time     | Start Time    | End Time      |
      | CurrentDate+6    | CurrentDate+9  | PT        | CurrentTime+3 | CurrentTime+4 | CurrentTime+5 |
    Then user increases Suggested Resources
      | Camera Ops | Audio Ops | Utility Ops |
      | 1          | 1         | 1           |
    And verify Estimated Cost getting changed or not
    Then verify the Notification when increases Resources Allocation
      | Notification1                                                                                                                                                           | Notification2                                                                                    |
      | Requested Resources are greater than suggested resources, please provide resource information below - Sr. Producer/Approver will need to approve in order to firm book. | Disclaimer: Estimate to be used for planning purpose only, actuals billed at conclusion of shoot |
    Then user clicks on "View Estimated Cost Breakdown" button
    And verify whether the overlay Calculator details showing correctly
    And user clicks on "Submit" button
    Then verify the Missing Fields Alert msg when user click submit button
      | Missing Field Alert Msg                                               |
      | Missing Fields: Please complete any mandatory fields and click Submit |
    And user clicks on "Missing Field Alert Popup Ok" button
    Then verify the "Override Info" section is getting visible
    And user enters Resource Reason and Description in the NBC News Crew Form
      | Resource Reason | Description         |
      | Safety          | Testing Purpose !!! |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button

    Examples:
      | Form Name |
      | NBC News  |
