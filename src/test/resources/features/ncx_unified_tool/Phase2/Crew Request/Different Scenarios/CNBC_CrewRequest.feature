@CNBCCrewRequest @ProducerDashboard
Feature: Validate various scenarios related CNBC Crew Request

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role

  @CNBCCrewRequest_Basic_Flow
  Scenario Outline: Verify user filling CNBC Crew Request form
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    Then user enters General info in CNBC Crew form
      | Slug | NCX Story Name | Additional Requesters | Is Producer Same as Requestor | Sr Producer  | Is Onsite Producer | Talent              |
      | Wind |                | Solai                 | Magesh                        | Jeevanandham | Yes                | test/tesr/test/test |
    When user enters field contact Information in CNBC Crew form
      | Field Contact | Phone      |
      | Jeevanandham  | 9898989877 |
    When user enters show title Information in CNBC Crew form
      | ShowTitle |
      | CNBC      |
    When user enters shoot details Information in CNBC Crew form
      | Production Type | Shoot Status | Shoot Description   |
      | LIVE - Anchor   | Tent         | test/tesr/test/test |
    When user enters shoot specs Information in CNBC Crew form
      | Audio Needs   | Special Conditions | Transmission Type | Is this a Drone Shoot | Special Gear |
      | Complex Audio | Weather concern    | LIVEU             | No                    | No           |
    When user enters shoot location Information in CNBC Crew form
      | Shoot Location | Risk Assessment Category | Risk Assessment Type | Risk Arrangements | Risk Approver |
      | Miami Bureau   |                          |                      |                   |               |
    When user enters Date & Time Information in CNBC Crew form
      | Shoot Start Date | Shoot End Date | Time Zone | Meet Time     | Start Time    | End Time      |
      | CurrentDate+6    | CurrentDate+9  | PT        | CurrentTime+3 | CurrentTime+4 | CurrentTime+5 |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    And user logs out from application

    ########################################################
    Examples: 
      | Form Name |
      | CNBC Crew |

  @CNBCCrewRequest_combination_ProductionType
  Scenario Outline: Verify user filling CNBC Crew Request form with different Production Type
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    Then user enters General info in CNBC Crew form
      | Slug | NCX Story Name | Additional Requesters | Is Producer Same as Requestor | Sr Producer  | Is Onsite Producer | Talent              |
      | Wind |                | Solai                 | Magesh                        | Jeevanandham | Yes                | test/tesr/test/test |
    When user enters field contact Information in CNBC Crew form
      | Field Contact | Phone      |
      | Jeevanandham  | 9898989877 |
    When user enters show title Information in CNBC Crew form
      | ShowTitle |
      | CNBC      |
    When user enters shoot details Information in CNBC Crew form
      | Production Type   | Shoot Status | Shoot Description   |
      | <Production Type> | Tent         | test/tesr/test/test |
    When user enters shoot specs Information in CNBC Crew form
      | Audio Needs   | Special Conditions | Transmission Type | Is this a Drone Shoot | Special Gear |
      | Complex Audio | Weather concern    | LIVEU             | No                    | No           |
    When user enters shoot location Information in CNBC Crew form
      | Shoot Location | Risk Assessment Category | Risk Assessment Type | Risk Arrangements | Risk Approver |
      | Miami Bureau   |                          |                      |                   |               |
    When user enters Date & Time Information in CNBC Crew form
      | Shoot Start Date | Shoot End Date | Time Zone | Meet Time     | Start Time    | End Time      |
      | CurrentDate+6    | CurrentDate+9  | PT        | CurrentTime+3 | CurrentTime+4 | CurrentTime+5 |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    And user logs out from application

    ########################################################
    Examples: 
      | Form Name | Production Type      |
      | CNBC Crew | LIVE - Anchor        |
      | CNBC Crew | TAPE - BRoll         |
      | CNBC Crew | TAPE - MOS           |
      | CNBC Crew | LIVE - Correspondent |
      | CNBC Crew | BREAKING NEWS        |

  @CNBCCrewRequest_combination_ProductionType_ShootSpecs_location_timeZone
  Scenario Outline: Verify user filling CNBC Crew Request form with different Production Type , Shoot Specs
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    Then user enters General info in CNBC Crew form
      | Slug | NCX Story Name | Additional Requesters | Is Producer Same as Requestor | Sr Producer  | Is Onsite Producer | Talent              |
      | Wind |                | Solai                 | Magesh                        | Jeevanandham | Yes                | test/tesr/test/test |
    When user enters field contact Information in CNBC Crew form
      | Field Contact | Phone      |
      | Jeevanandham  | 9898989877 |
    When user enters show title Information in CNBC Crew form
      | ShowTitle |
      | CNBC      |
    When user enters shoot details Information in CNBC Crew form
      | Production Type   | Shoot Status | Shoot Description   |
      | <Production Type> | Tent         | test/tesr/test/test |
    When user enters shoot specs Information in CNBC Crew form
      | Audio Needs   | Special Conditions   | Transmission Type   | Is this a Drone Shoot | Special Gear |
      | <Audio Needs> | <Special Conditions> | <Transmission Type> | No                    | No           |
    When user enters shoot location Information in CNBC Crew form
      | Shoot Location | Risk Assessment Category | Risk Assessment Type | Risk Arrangements | Risk Approver |
      | <Location>     |                          |                      |                   |               |
    When user enters Date & Time Information in CNBC Crew form
      | Shoot Start Date | Shoot End Date | Time Zone   | Meet Time     | Start Time    | End Time      |
      | CurrentDate+6    | CurrentDate+9  | <Time Zone> | CurrentTime+3 | CurrentTime+4 | CurrentTime+5 |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    And user logs out from application

    ########################################################
    Examples: 
      | Form Name | Production Type | Audio Needs       | Special Conditions | Transmission Type | Acquisition Specs       | Location       | Time Zone |
      | CNBC Crew | LIVE - Anchor   | Complex Audio     | High profile guest | LIVEU             | Defer to Crew           | Chicago Bureau | ET        |
      | CNBC Crew | TAPE - BRoll    | 1-2 Audio Sources | Weather concern    | FIBER/FIXED       | Broadcast/Live Standard | Other          | PT        |
