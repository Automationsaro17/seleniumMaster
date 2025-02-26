@FirearmsOnPremisesProductionRequest @ProducerDashboard
Feature: Firearms On Premises production request Validation

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role

  @FirearmsOnPremisesProductionRequest_Basic_Flow
  Scenario Outline: Verify user filling Firearms On Premises production request form
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in Firearms on Premises Production form
      | Division | Additional Requesters | Talent              |
      | MSNBC    | Solai                 | test/tesr/test/test |
    When user enters show information in Firearms on Premises Production form
      | Air Platform | Show or Project Name | Arrival Date  | Arrival Time  | Departure Date | Departure Time |
      | OTT          | 7S Tour Studio       | CurrentDate+3 | CurrentTime+3 | CurrentDate+8  | CurrentTime+3  |
    When user enters set location information in Firearms on Premises Production Form
      | Location    | Set Location |
      | Rock Center | 3A VR        |
    When user enters Firearms information for Firearms on Premises Production form
      | Type Of Firearm     | How Many Firearm | Firearm Type |
      | test/tesr/test/test |               10 | Yes          |
    When user enters details information in Firearms on Premises Production form
      | Details and Notes   |
      | test/tesr/test/test |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    And user logs out from application

    ########################################################
    Examples: 
      | Form Name            |
      | Firearms on Premises |

  @FirearmsOnPremisesProductionRequest_different_divisions
  Scenario Outline: Verify user filling Firearms On Premises production request form with different divisions
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in Firearms on Premises Production form
      | Division   | Additional Requesters | Talent              |
      | <Division> | Solai                 | test/tesr/test/test |
    When user enters show information in Firearms on Premises Production form
      | Air Platform | Show or Project Name | Arrival Date  | Arrival Time  | Departure Date | Departure Time |
      | OTT          | 7S Tour Studio       | CurrentDate+3 | CurrentTime+3 | CurrentDate+8  | CurrentTime+3  |
    When user enters set location information in Firearms on Premises Production Form
      | Location    | Set Location |
      | Rock Center | 3A VR        |
    When user enters Firearms information for Firearms on Premises Production form
      | Type Of Firearm     | How Many Firearm | Firearm Type |
      | test/tesr/test/test |               10 | Yes          |
    When user enters details information in Firearms on Premises Production form
      | Details and Notes   |
      | test/tesr/test/test |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    And user logs out from application

    ########################################################
    Examples: 
      | Form Name            | Division         |
      | Firearms on Premises | NBC News         |
      | Firearms on Premises | MSNBC            |
      | Firearms on Premises | CNBC             |
      | Firearms on Premises | Acorn            |
      | Firearms on Premises | Corporate        |
      | Firearms on Premises | Engineering      |
      | Firearms on Premises | Entertainment    |
      | Firearms on Premises | ERG Events       |
      | Firearms on Premises | Facilities       |
      | Firearms on Premises | NBC News Studios |
      | Firearms on Premises | NBC Sports       |
      | Firearms on Premises | News Digital     |
      | Firearms on Premises | Olympics         |
      | Firearms on Premises | Operations       |
      | Firearms on Premises | Peacock          |
      | Firearms on Premises | Telemundo        |
      | Firearms on Premises | Universal Kids   |

  @FirearmsOnPremisesProductionRequest_combination_divisions_airplatform_location
  Scenario Outline: Verify user filling Firearms On Premises production request form with different divisions, airplatforms and location
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in Firearms on Premises Production form
      | Division   | Additional Requesters | Talent              |
      | <Division> | Solai                 | test/tesr/test/test |
    When user enters show information in Firearms on Premises Production form
      | Air Platform   | Show or Project Name | Arrival Date  | Arrival Time  | Departure Date | Departure Time |
      | <Air Platform> | 7S Tour Studio       | CurrentDate+3 | CurrentTime+3 | CurrentDate+8  | CurrentTime+3  |
    When user enters set location information in Firearms on Premises Production Form
      | Location   | Set Location   |
      | <Location> | <Set Location> |
    When user enters Firearms information for Firearms on Premises Production form
      | Type Of Firearm     | How Many Firearm | Firearm Type |
      | test/tesr/test/test |               10 | Yes          |
    When user enters details information in Firearms on Premises Production form
      | Details and Notes   |
      | test/tesr/test/test |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    And user logs out from application

    ########################################################
    Examples: 
      | Form Name            | Division         | Air Platform     | Location    | Set Location   |
      | Firearms on Premises | NBC News         | Broadcast        | Rock Center | 1A Studio      |
      | Firearms on Premises | MSNBC            | Cable            | Rock Center | 1A UP          |
      | Firearms on Premises | NBC News Studios | OTT              | Rock Center | 6B Studio      |
      | Firearms on Premises | NBC Sports       | Internal         | Rock Center | 3E Flashcam    |
      | Firearms on Premises | News Digital     | Video Conference | Rock Center | 3B Studio      |
      | Firearms on Premises | Olympics         | Multiple         | Rock Center | 3A Studio      |
      | Firearms on Premises | Universal Kids   | Broadcast        | Rock Center | 4E Town Square |
      
       @FirearmsOnPremisesProductionRequest_Basic_Flow @EMailDLsFirearmsOnPremises 
  Scenario Outline: Email TO & CC DL Validations with E2E workflow for Firearms On Premises production request form
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in Firearms on Premises Production form
      | Division | Additional Requesters | Talent              |
      | MSNBC    | Solai                 | test/tesr/test/test |
    When user enters show information in Firearms on Premises Production form
      | Air Platform | Show or Project Name | Arrival Date  | Arrival Time  | Departure Date | Departure Time |
      | OTT          | 7S Tour Studio       | CurrentDate+3 | CurrentTime+3 | CurrentDate+8  | CurrentTime+3  |
    When user enters set location information in Firearms on Premises Production Form
      | Location    | Set Location |
      | Rock Center | 3A VR        |
    When user enters Firearms information for Firearms on Premises Production form
      | Type Of Firearm     | How Many Firearm | Firearm Type |
      | test/tesr/test/test |               10 | Yes          |
    When user enters details information in Firearms on Premises Production form
      | Details and Notes   |
      | test/tesr/test/test |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    Then validate recieved email notification for status "COMPLETED"
    Then validate "ToList" in the recieved email for "COMPLETED" status
    Then validate "CcList" in the recieved email for "COMPLETED" status
    

    ########################################################
    Examples: 
      | Form Name            |
      | Firearms on Premises |
      
