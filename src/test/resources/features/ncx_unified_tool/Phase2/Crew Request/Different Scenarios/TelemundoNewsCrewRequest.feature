@TelemundoNewsCrewRequest @ProducerDashboard
Feature: Validate various scenarios related Telemundo News Crew Request

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role

  @TelemundoNewsCrewRequest_Basic_Flow
  Scenario Outline: Verify user filling Telemundo News Crew Request form
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    Then user enters General info in Telemundo Crew form
      | Slug | NCX Story Name | Additional Requesters | Is Producer Same as Requestor | Sr Producer  | Is Onsite Producer | Talent              |
      | Wind |                | Solai                 | Magesh                        | Jeevanandham | Yes                | test/tesr/test/test |
    When user enters field contact Information in Telemundo Crew form
      | Field Contact | Phone      |
      | Jeevanandham  | 9898989877 |
    When user enters show title Information in Telemundo Crew form
      | ShowTitle |
      | CNBC      |
    When user enters shoot details Information in Telemundo Crew form
      | Production Type | Shoot Status | Shoot Description   |
      | LIVE - Anchor   | Tent         | test/tesr/test/test |
    When user enters shoot specs Information in Telemundo Crew form
      | Audio Needs   | Special Conditions | Transmission Type | Is this a Drone Shoot | iPad Prompter Required | Special Gear |
      | Complex Audio | Weather concern    | LIVEU             | No                    | No                     | No           |
    When user enters shoot location Information in Telemundo Crew form
      | Shoot Location | Risk Assessment Category | Risk Assessment Type | Risk Arrangements | Risk Approver |
      | Miami Bureau   |                          |                      |                   |               |
    When user enters Date & Time Information in Telemundo Crew form
      | Shoot Start Date | Shoot End Date | Time Zone | Meet Time     | Start Time    | End Time      |
      | CurrentDate+6    | CurrentDate+9  | PT        | CurrentTime+1 | CurrentTime+2 | CurrentTime+3 |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    And user logs out from application

    ########################################################
    Examples: 
      | Form Name      |
      | Telemundo News |

  @TelemundoNewsCrewRequest_combination_ProductionType_AudioType_TransmissionType_location_timeZone
  Scenario Outline: Verify user filling Telemundo News Crew Request form with different Production Type,Audio Needs,Special Conditions,Transmission Type,Location,Time Zone
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    Then user enters General info in Telemundo Crew form
      | Slug | NCX Story Name | Additional Requesters | Is Producer Same as Requestor | Sr Producer  | Is Onsite Producer | Talent              |
      | Wind |                | Solai                 | Magesh                        | Jeevanandham | Yes                | test/tesr/test/test |
    When user enters field contact Information in Telemundo Crew form
      | Field Contact | Phone      |
      | Jeevanandham  | 9898989877 |
    When user enters show title Information in Telemundo Crew form
      | ShowTitle |
      | CNBC      |
    When user enters shoot details Information in Telemundo Crew form
      | Production Type   | Shoot Status | Shoot Description   |
      | <Production Type> | Tent         | test/tesr/test/test |
    When user enters shoot specs Information in Telemundo Crew form
      | Audio Needs   | Special Conditions   | Transmission Type   | Is this a Drone Shoot | iPad Prompter Required | Special Gear |
      | <Audio Needs> | <Special Conditions> | <Transmission Type> | No                    | No                     | No           |
    When user enters shoot location Information in Telemundo Crew form
      | Shoot Location | Risk Assessment Category | Risk Assessment Type | Risk Arrangements | Risk Approver |
      | <Location>     |                          |                      |                   |               |
    When user enters Date & Time Information in Telemundo Crew form
      | Shoot Start Date | Shoot End Date | Time Zone   | Meet Time     | Start Time    | End Time      |
      | CurrentDate+6    | CurrentDate+9  | <Time Zone> | CurrentTime+1 | CurrentTime+2 | CurrentTime+3 |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    And user logs out from application

    ########################################################
    Examples: 
      | Form Name      | Production Type        | Audio Needs       | Special Conditions          | Transmission Type | Location       | Time Zone |
      | Telemundo News | LIVE - Anchor          | Complex Audio     | High profile guest          | LIVEU             | Chicago Bureau | ET        |
      | Telemundo News | TAPE - BRoll           | 1-2 Audio Sources | Time constraints            | OTHER             | Miami Bureau   | CT        |
      | Telemundo News | TAPE - MOS             | 1-2 Audio Sources | Weather concern             | FIBER/FIXED       | Houston Bureau | PT        |
      | Telemundo News | LIVE - Correspondent   | 1-2 Audio Sources | Additional/complex lighting | LATAKOO           | other          | GMT       |
      | Telemundo News | BREAKING NEWS          | 1-2 Audio Sources | Additional/complex lighting | LATAKOO           | other          | GMT       |
      | Telemundo News | LIVE - GUEST           | 3-4 Audio Sources | High profile guest          | LIVEU             | Chicago Bureau | ET        |
      | Telemundo News | TAPE - Phone Interview | Complex Audio     | Time constraints            | OTHER             | Miami Bureau   | CT        |
