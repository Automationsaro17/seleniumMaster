@FirearmsOnPremisesProductionRequest @ProducerDashboard @Dashboard_Validation
Feature: Validate various scenarios related Firearms On Premises production request

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role

  @FirearmsOnPremisesProductionRequest_Dashboard_Validation
  Scenario Outline: Verify user filling Firearms On Premises production request form and validating in dashboard
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in Firearms on Premises Production form
      | Division   | Additional Requesters | Talent              |
      | <Division> | <Requesters>          | test/tesr/test/test |
    When user enters show information in Firearms on Premises Production form
      | Air Platform   | Show or Project Name   | Arrival Date   | Arrival Time   | Departure Date   | Departure Time   |
      | <Air Platform> | <Show or Project Name> | <Arrival Date> | <Arrival Time> | <Departure Date> | <Departure Time> |
    When user enters set location information in Firearms on Premises Production Form
      | Location   | Set Location   |
      | <Location> | <Set Location> |
    When user enters Firearms information for Firearms on Premises Production form
      | Type Of Firearm   | How Many Firearm   | Firearm Type   |
      | <Type Of Firearm> | <How Many Firearm> | <Firearm Type> |
    When user enters details information in Firearms on Premises Production form
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
    Then verify all fields in the Firearms On Premises form are matching with columns in production dashboard
      | Requesters   | Show/Project           | Set Location              | Submitted   |
      | <Requesters> | <Show or Project Name> | <Location>,<Set Location> | CurrentDate |

    Examples: 
      | Form Name            | Division | Requesters         | Air Platform     | Show or Project Name | Arrival Date  | Arrival Time  | Departure Date | Departure Time | Location                            | Set Location            | Type Of Firearm     | How Many Firearm | Firearm Type |
      | Firearms on Premises | NBC News | Solai-Jeevanandham | Video Conference | 7S Tour Studio       | CurrentDate+1 | CurrentTime+3 | CurrentDate+3  | CurrentTime+3  | Rock Center,Rock Center,Rock Center | 3A VR,3B West,6B Studio | test/tesr/test/test |               10 | Yes          |
      
      