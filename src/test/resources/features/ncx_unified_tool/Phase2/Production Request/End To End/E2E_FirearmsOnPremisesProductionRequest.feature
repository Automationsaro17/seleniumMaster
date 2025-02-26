@FirearmsOnPremisesProductionRequest @ProducerDashboard @END_TO_END
Feature: Validate various scenarios related Firearms On Premises production request

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role

  @FirearmsOnPremisesProductionRequest_e2e @SEVERITY=CRITICAL @StudioE2E
  Scenario Outline: Verify user filling Firearms On Premises production request form
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
    #############################My Request Dashboard####################################################
    And verify submitted "<Form Name>" is present in my request page with "COMPLETED" status
    And verify "background color" of "COMPLETED" status is "Green" in my request page
    When user searches request in my request page
    Then verify all fields in the Firearms on Premises Production form are matching with columns in My Request dashboard
      | Slug | Submitted   | Prod Date    | Show Title             |
      |      | CurrentDate | <Start Date> | <Show or Project Name> |
    #############################All Request Dashboard####################################################
    When user clicks on "All Requests" button
    Then verify all fields in the Firearms on Premises Production form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date    | Show Title             |
      | <Requesters> |      | CurrentDate | <Start Date> | <Show or Project Name> |
    And user opens fulfiller dashboard for "<Form Name>" form
    Then user clicks "Fulfilled" requests dropdown in Production Dashboard
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "COMPLETED" status
    And verify "background color" of "COMPLETED" status is "Green" in fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the Firearms On Premises form are matching with columns in production dashboard
      | Requesters   | Show/Project           | Set Location              | Submitted   |
      | <Requesters> | <Show or Project Name> | <Location>,<Set Location> | CurrentDate |
    ##############################Email Validation###########################################
    Then validate recieved email notification for status "COMPLETED"
    Then validate "ToList" in the recieved email for "COMPLETED" status
    Then validate "CcList" in the recieved email for "COMPLETED" status
    And user logs out from application
    ############################ user logging in as fulfiller and modifying the form request ############################
    Given user opens producer dashboard application
    And user logins with "fulfiller" role
    #############################All Request Dashboard####################################################
    When user clicks on "All Requests" button
    Then verify all fields in the Firearms on Premises Production form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date    | Show Title             |
      | <Requesters> |      | CurrentDate | <Start Date> | <Show or Project Name> |
    And user opens fulfiller dashboard for "<Form Name>" form
    Then user clicks "Fulfilled" requests dropdown in Production Dashboard
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "COMPLETED" status
    And verify "background color" of "COMPLETED" status is "Green" in fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the Firearms On Premises form are matching with columns in production dashboard
      | Requesters   | Show/Project           | Set Location              | Submitted   |
      | <Requesters> | <Show or Project Name> | <Location>,<Set Location> | CurrentDate |
    Then user click on request ID link of the request
    When user clicks on "cancel request" button
    And verify "cancel request" alert message
      | Confirm Cancellation Alert Message           |
      | Are you sure you want to cancel this request |
    And click "Yes" on "cancel request" alert message
   Then verify request is "Cancelled" successfully
    #############################All Request Dashboard####################################################
    When user clicks on "MY REQUEST DASHBOARD PAGE" button
    When user clicks on "All Requests" button
    Then verify all fields in the Firearms on Premises Production form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date    | Show Title             |
      | <Requesters> |      | CurrentDate | <Start Date> | <Show or Project Name> |
    And user opens fulfiller dashboard for "<Form Name>" form
    Then user clicks "Fulfilled" requests dropdown in Production Dashboard
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "CANCELLED" status
    And verify "background color" of "CANCELLED" status is "Black" in fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the Firearms On Premises form are matching with columns in production dashboard
      | Requesters   | Show/Project           | Set Location              | Submitted   |
      | <Requesters> | <Show or Project Name> | <Location>,<Set Location> | CurrentDate |
    And user logs out from application
    ############################ user logging in as Requester ############################
    Given user opens producer dashboard application
    And user logins with "producer" role
    #############################My Request Dashboard####################################################
    #When user searches request in my request page
    And verify submitted "<Form Name>" is present in my request page with "CANCELLED" status
    And verify "background color" of "CANCELLED" status is "Black" in my request page
    When user searches request in my request page
    Then verify all fields in the Firearms on Premises Production form are matching with columns in My Request dashboard
      | Slug | Submitted   | Prod Date    | Show Title             |
      |      | CurrentDate | <Start Date> | <Show or Project Name> |
    #############################All Request Dashboard####################################################
    When user clicks on "All Requests" button
    Then verify all fields in the Firearms on Premises Production form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date    | Show Title             |
      | <Requesters> |      | CurrentDate | <Start Date> | <Show or Project Name> |
    And user opens fulfiller dashboard for "<Form Name>" form
    Then user clicks "Fulfilled" requests dropdown in Production Dashboard
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "CANCELLED" status
    And verify "background color" of "CANCELLED" status is "Black" in fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the Firearms On Premises form are matching with columns in production dashboard
      | Requesters   | Show/Project           | Set Location              | Submitted   |
      | <Requesters> | <Show or Project Name> | <Location>,<Set Location> | CurrentDate |
    And user logs out from application

    Examples: 
      | Form Name            | Division | Requesters    | Air Platform     | Show or Project Name | Arrival Date  | Arrival Time  | Departure Date | Departure Time | Location                            | Set Location            | Type Of Firearm     | How Many Firearm | Firearm Type |
      | Firearms on Premises | NBC News | Solai-Sainath | Video Conference | 7S Tour Studio       | CurrentDate+1 | CurrentTime+3 | CurrentDate+3  | CurrentTime+3  | Rock Center,Rock Center,Rock Center | 3A VR,3B West,6B Studio | test/tesr/test/test |               10 | Yes          |
