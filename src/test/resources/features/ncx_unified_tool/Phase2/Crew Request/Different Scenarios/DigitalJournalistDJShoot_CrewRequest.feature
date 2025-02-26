@DigitalJournalistDJShootCrewRequest @ProducerDashboard
Feature: Validate various scenarios related Digital Journalist DJ Shoot Crew Request

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role

  @DigitalJournalistDJShootCrewRequest_Basic_Flow
  Scenario Outline: Verify user filling Digital Journalist DJ Shoot Crew Request form
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    Then user enters General info in Digital Journalist DJ Shoot Crew form
      | Slug | NCX Story Name | Additional Requesters | Is Producer Same as Requestor | Sr Producer  | Is Onsite Producer | Talent              |
      | Wind |                | Solai                 | Magesh                        | Jeevanandham | Yes                | test/tesr/test/test |
    When user enters field contact Information in Digital Journalist DJ Shoot Crew form
      | Field Contact | Phone      |
      | Jeevanandham  | 9898989877 |
    When user enters show title Information in Digital Journalist DJ Shoot Crew form
      | ShowTitle |
      | CNBC      |
    When user enters shoot details Information in Digital Journalist DJ Shoot Crew form
      | Production Type | Shoot Status | Shoot Type | Shoot Description   |
      | Repair          | Tent         |     Tape       | test/tesr/test/test |
    When user enters shoot specs Information in Digital Journalist DJ Shoot Crew form
      | Audio Needs   | Special Conditions | Transmission Type | Acquisition Specs | Is this a Drone Shoot | Special Gear | Primary Camera Type |
      | Complex Audio | Weather concern    | LIVEU             | Defer to Crew     | No                    | No           | Specialty           |
    When user enters shoot location Information in Digital Journalist DJ Shoot Crew form
      | Shoot Location | Risk Assessment Category | Risk Assessment Type | Risk Arrangements | Risk Approver |
      | Miami Bureau   |                          |                      |                   |               |
    When user enters Date & Time Information in Digital Journalist DJ Shoot Crew form
      | Shoot Start Date | Shoot End Date | Time Zone | Meet Time     | Start Time    | End Time      |
      | CurrentDate+6    | CurrentDate+9  | PT        | CurrentTime+1 | CurrentTime+2 | CurrentTime+3 |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    And user logs out from application

    ########################################################
    Examples: 
      | Form Name                     |
      | Digital Journalist / DJ Shoot |

  @DigitalJournalistDJShootCrewRequest_combination_ProductionType_ShootSpecs_location_timeZone
  Scenario Outline: Verify user filling Digital Journalist DJ Shoot Crew Request form with different Production Type , Shoot Specs, Location, Timezone
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    Then user enters General info in Digital Journalist DJ Shoot Crew form
      | Slug | NCX Story Name | Additional Requesters | Is Producer Same as Requestor | Sr Producer  | Is Onsite Producer | Talent              |
      | Wind |                | Solai                 | Magesh                        | Jeevanandham | Yes                | test/tesr/test/test |
    When user enters field contact Information in Digital Journalist DJ Shoot Crew form
      | Field Contact | Phone      |
      | Jeevanandham  | 9898989877 |
    When user enters show title Information in Digital Journalist DJ Shoot Crew form
      | ShowTitle |
      | CNBC      |
    When user enters shoot details Information in Digital Journalist DJ Shoot Crew form
      | Production Type   | Shoot Status | Shoot Type | Shoot Description   |
      | <Production Type> | Tent         |    Tape        | test/tesr/test/test |
    When user enters shoot specs Information in Digital Journalist DJ Shoot Crew form
      | Audio Needs   | Special Conditions   | Transmission Type   | Acquisition Specs   | Is this a Drone Shoot | Special Gear | Primary Camera Type   |
      | <Audio Needs> | <Special Conditions> | <Transmission Type> | <Acquisition Specs> | No                    | No           | <Primary Camera Type> |
    When user enters shoot location Information in Digital Journalist DJ Shoot Crew form
      | Shoot Location | Risk Assessment Category | Risk Assessment Type | Risk Arrangements | Risk Approver |
      | <Location>     |                          |                      |                   |               |
    When user enters Date & Time Information in Digital Journalist DJ Shoot Crew form
      | Shoot Start Date | Shoot End Date | Time Zone   | Meet Time     | Start Time    | End Time      |
      | CurrentDate+6    | CurrentDate+9  | <Time Zone> | CurrentTime+1 | CurrentTime+2 | CurrentTime+3 |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    And user logs out from application

    ########################################################
    Examples: 
      | Form Name                     | Production Type           | Audio Needs       | Special Conditions          | Transmission Type | Primary Camera Type         | Acquisition Specs       | Location       | Time Zone |
      | Digital Journalist / DJ Shoot | Field Shoot               | Complex Audio     | High profile guest          | LIVEU             | Eng (e.g. Panasonic 5000)   | Defer to Crew           | Chicago Bureau | ET        |
      | Digital Journalist / DJ Shoot | Repair                    | 3-4 Audio Sources | Time constraints            | OTHER             | Specialty                   | Broadcast/Tape          | Miami Bureau   | CT        |
      | Digital Journalist / DJ Shoot | Training                  | 1-2 Audio Sources | Weather concern             | FIBER/FIXED       | Specialty (e.g. GoPro HERO) | Broadcast/Live Standard | Houston Bureau | PT        |
      | Digital Journalist / DJ Shoot | Production Support        | 1-2 Audio Sources | Additional/complex lighting | LATAKOO           | Eng (e.g. Panasonic 5000)   | Broadcast/Live Standard | other          | GMT       |
      | Digital Journalist / DJ Shoot | Remote Production Support | 1-2 Audio Sources | Additional/complex lighting | LATAKOO           | Specialty (e.g. GoPro HERO) | Broadcast/Live Standard | other          | GMT       |
      | Digital Journalist / DJ Shoot | Maintenance               | Complex Audio     | High profile guest          | LIVEU             | Specialty                   | Defer to Crew           | Chicago Bureau | ET        |
      | Digital Journalist / DJ Shoot | Videographer Request      | 3-4 Audio Sources | Time constraints            | OTHER             | Eng (e.g. Panasonic 5000)   | Broadcast/Tape          | Miami Bureau   | CT        |
