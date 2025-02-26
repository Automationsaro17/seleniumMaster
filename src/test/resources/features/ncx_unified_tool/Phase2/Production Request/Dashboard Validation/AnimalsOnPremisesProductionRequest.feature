@AnimalsOnPremisesProductionRequest @ProducerDashboard @Dashboard_Validation
Feature: Validate various scenarios related Animals On Premises

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role

  @AnimalsOnPremisesProductionRequest_Dashboard_Validation
  Scenario Outline: Verify user filling Animals On Premises production request form and validating in dashboard
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in Animals on Premises Production form
      | Division   | Additional Requesters | Talent              |
      | <Division> | <Requesters>          | test/tesr/test/test |
    When user enters show information in Animals on Premises Production form
      | Air Platform   | Show or Project Name   | Arrival Date   | Arrival Time   | Departure Date   | Departure Time   |
      | <Air Platform> | <Show or Project Name> | <Arrival Date> | <Arrival Time> | <Departure Date> | <Departure Time> |
    When user enters set location information in Animals on Premises Production Form
      | Location   | Set Location   |
      | <Location> | <Set Location> |
    When user enters Handlers information for Animals on Premises Production form
      | Handlers Name   | Handlers Email   | Handlers Phone   |
      | <Handlers Name> | <Handlers Email> | <Handlers Phone> |
    When user enters Animals information for Animals on Premises Production form
      | Animal Type   | Animal Weight   | Animal HowMany   | Animal Handler   |
      | <Animal Type> | <Animal Weight> | <Animal HowMany> | <Animal Handler> |
    When user enters details information in Animals on Premises Production form
      | Details and Notes   |
      | test/tesr/test/test |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    And user opens fulfiller dashboard for "<Form Name>" form
    Then user clicks "All" requests dropdown in Production Dashboard
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "COMPLETED" status
    And verify "background color" of "COMPLETED" status is "Green" in fullfiller dashboard
    Then verify all fields in the Animal On Premises form are matching with columns in production dashboard
      | Requesters   | Show/Project           | Set Location              | Submitted   |
      | <Requesters> | <Show or Project Name> | <Location>,<Set Location> | CurrentDate |

    Examples: 
      | Form Name           | Division | Requesters         | Air Platform     | Show or Project Name | Arrival Date  | Arrival Time  | Departure Date | Departure Time | Location             | Set Location                       | Handlers Name   | Handlers Email                  | Handlers Phone | Animal Type    | Animal Weight | Animal HowMany | Animal Handler  |
      | Animals on Premises | NBC News | Solai-Jeevanandham | Video Conference | 7S Tour Studio       | CurrentDate+1 | CurrentTime+3 | CurrentDate+3  | CurrentTime+3  | Rock Center,Rock Center,Rock Center | 3A VR,3B West,6B Studio | Testing-Testing | Sainath.Peddina.test@nbcuni.com |     3254354364 | testing animal | 100-200 lbs   |              5 | Testing-Testing |
