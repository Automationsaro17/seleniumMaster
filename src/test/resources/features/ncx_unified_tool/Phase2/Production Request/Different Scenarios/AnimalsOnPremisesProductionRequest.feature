@AnimalsOnPremisesProductionRequest @ProducerDashboard
Feature: Validate various scenarios related Animals On Premises

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role

  @AnimalsOnPremisesProductionRequest_Basic_Flow
  Scenario Outline: Verify user filling Animals On Premises production request form
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in Animals on Premises Production form
      | Division | Additional Requesters | Talent              |
      | MSNBC    | Solai                 | test/tesr/test/test |
    When user enters show information in Animals on Premises Production form
      | Air Platform | Show or Project Name | Arrival Date  | Arrival Time  | Departure Date | Departure Time |
      | OTT          | 7S Tour Studio       | CurrentDate+3 | CurrentTime+3 | CurrentDate+8  | CurrentTime+3  |
    When user enters set location information in Animals on Premises Production Form
      | Location    | Set Location |
      | Rock Center | 3A VR        |
    When user enters Handlers information for Animals on Premises Production form
      | Handlers Name   | Handlers Email                  | Handlers Phone |
      | Testing-Testing | Sainath.Peddina.test@nbcuni.com |     3254354364 |
    When user enters Animals information for Animals on Premises Production form
      | Animal Type    | Animal Weight | Animal HowMany | Animal Handler  |
      | testing animal | 100-200 lbs   |              5 | Testing-Testing |
    When user enters details information in Animals on Premises Production form
      | Details and Notes   |
      | test/tesr/test/test |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    And user logs out from application

    ########################################################
    Examples: 
      | Form Name           |
      | Animals on Premises |

  @AnimalsOnPremisesProductionRequest_different_divisions
  Scenario Outline: Verify user filling Animals On Premises production request form with different divisions
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in Animals on Premises Production form
      | Division   | Additional Requesters | Talent              |
      | <Division> | Solai                 | test/tesr/test/test |
    When user enters show information in Animals on Premises Production form
      | Air Platform | Show or Project Name | Arrival Date  | Arrival Time  | Departure Date | Departure Time |
      | OTT          | 7S Tour Studio       | CurrentDate+3 | CurrentTime+3 | CurrentDate+8  | CurrentTime+3  |
    When user enters set location information in Animals on Premises Production Form
      | Location    | Set Location |
      | Rock Center | 3A VR        |
    When user enters Handlers information for Animals on Premises Production form
      | Handlers Name   | Handlers Email                  | Handlers Phone |
      | Testing-Testing | Sainath.Peddina.test@nbcuni.com |     3254354364 |
    When user enters Animals information for Animals on Premises Production form
      | Animal Type    | Animal Weight | Animal HowMany | Animal Handler  |
      | testing animal | 100-200 lbs   |              5 | Testing-Testing |
    When user enters details information in Animals on Premises Production form
      | Details and Notes   |
      | test/tesr/test/test |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    And user logs out from application

    ########################################################
    Examples: 
      | Form Name           | Division         |
      | Animals on Premises | NBC News         |
      | Animals on Premises | MSNBC            |
      | Animals on Premises | CNBC             |
      | Animals on Premises | Acorn            |
      | Animals on Premises | Corporate        |
      | Animals on Premises | Engineering      |
      | Animals on Premises | Entertainment    |
      | Animals on Premises | ERG Events       |
      | Animals on Premises | Facilities       |
      | Animals on Premises | NBC News Studios |
      | Animals on Premises | NBC Sports       |
      | Animals on Premises | News Digital     |
      | Animals on Premises | Olympics         |
      | Animals on Premises | Operations       |
      | Animals on Premises | Peacock          |
      | Animals on Premises | Telemundo        |
      | Animals on Premises | Universal Kids   |

  @AnimalsOnPremisesProductionRequest_combination_divisions_airplatform_location
  Scenario Outline: Verify user filling Animals On Premises production request form with different divisions, airplatforms and location
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in Animals on Premises Production form
      | Division   | Additional Requesters | Talent              |
      | <Division> | Solai                 | test/tesr/test/test |
    When user enters show information in Animals on Premises Production form
      | Air Platform   | Show or Project Name | Arrival Date  | Arrival Time  | Departure Date | Departure Time |
      | <Air Platform> | 7S Tour Studio       | CurrentDate+3 | CurrentTime+3 | CurrentDate+8  | CurrentTime+3  |
    When user enters set location information in Animals on Premises Production Form
      | Location   | Set Location   |
      | <Location> | <Set Location> |
    When user enters Handlers information for Animals on Premises Production form
      | Handlers Name   | Handlers Email                  | Handlers Phone |
      | Testing-Testing | Sainath.Peddina.test@nbcuni.com |     3254354364 |
    When user enters Animals information for Animals on Premises Production form
      | Animal Type    | Animal Weight | Animal HowMany | Animal Handler  |
      | testing animal | 100-200 lbs   |              5 | Testing-Testing |
    When user enters details information in Animals on Premises Production form
      | Details and Notes   |
      | test/tesr/test/test |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    And user logs out from application

    ########################################################
    Examples: 
      | Form Name           | Division         | Air Platform     | Location    | Set Location   |
      | Animals on Premises | NBC News         | Broadcast        | Rock Center | 1A Studio      |
      | Animals on Premises | MSNBC            | Cable            | Rock Center | 1A UP          |
      | Animals on Premises | NBC News Studios | OTT              | Rock Center | 6B Studio      |
      | Animals on Premises | NBC Sports       | Internal         | Rock Center | 3E Flashcam    |
      | Animals on Premises | News Digital     | Video Conference | Rock Center | 3B Studio      |
      | Animals on Premises | Olympics         | Multiple         | Rock Center | 3A Studio      |
      | Animals on Premises | Universal Kids   | Broadcast        | Rock Center | 4E Town Square |
      
      @AnimalsOnPremisesProductionRequest_e2e @SEVERITY=CRITICAL @StudioE2E @EMailDLsAnimalsOnPremises 
  Scenario Outline: Email TO & CC DL Validations with E2E workflow for Animals On Premises production request form
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in Animals on Premises Production form
      | Division | Additional Requesters | Talent              |
      | MSNBC    | Solai-Magesh          | test/tesr/test/test |
    When user enters show information in Animals on Premises Production form
      | Air Platform | Show or Project Name | Arrival Date  | Arrival Time  | Departure Date | Departure Time |
      | Video Conference          | 7S Tour Studio       | CurrentDate+3 | CurrentTime+3 | CurrentDate+8  | CurrentTime+3  |
    When user enters set location information in Animals on Premises Production Form
      | Location    | Set Location |
      | Rock Center | 3A VR        |
    When user enters Handlers information for Animals on Premises Production form
      | Handlers Name   | Handlers Email                  | Handlers Phone |
      | Testing-Testing | Sainath.Peddina.test@nbcuni.com |     3254354364 |
    When user enters Animals information for Animals on Premises Production form
      | Animal Type    | Animal Weight | Animal HowMany | Animal Handler  |
      | testing animal | 100-200 lbs   |              5 | Testing-Testing |
    When user enters details information in Animals on Premises Production form
      | Details and Notes   |
      | test/tesr/test/test |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    	Then validate recieved email notification for status "COMPLETED"
    Then validate "ToList" in the recieved email for "COMPLETED" status
    Then validate "CcList" in the recieved email for "COMPLETED" status

    Examples: 
      | Form Name           |
      | Animals on Premises |
