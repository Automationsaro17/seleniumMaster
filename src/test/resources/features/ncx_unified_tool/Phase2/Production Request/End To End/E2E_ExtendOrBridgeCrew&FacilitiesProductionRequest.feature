@ExtendOrBridgeCrewFacilitiesProductionRequest @ProducerDashboard @END_TO_END
Feature: Validate various scenarios related Extend Or Bridge Crew & Facilities production

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role

  @ExtendOrBridgeCrewFacilitiesProductionRequest_e2e @SEVERITY=CRITICAL @StudioE2E 
  Scenario Outline: E2E Workflow Validation for Extend Or Bridge Crew & Facilities Production Request form
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in Extend or Bridge Crew Production form
      | Division   | Additional Requesters | Talent              |
      | <Division> | <Requesters>          | test/tesr/test/test |
    When user enters details information in Extend or Bridge Crew Production form
      | Details and Notes   |
      | test/tesr/test/test |
    When user enters show information in Extend or Bridge Crew Production form
      | Request For   | Air Platform   | Show or Project Name   | Start Date   | Start Time   | End Time   |
      | <Request For> | <Air Platform> | <Show or Project Name> | <Start Date> | <Start Time> | <End Time> |
    When user enters set location and crew information in Extend or Bridge Crew Production form
      | Location   | Set Location   |
      | <Location> | <Set Location> |
    When user enters control room and crew information in Extend or Bridge Crew Production form
      | Control Room And Crew Option | Control Room Location   | Control Room   |
      | Yes                          | <Control Room Location> | <Control Room> |
    When user enters TPMorTM information in Extend or Bridge Crew Production form
      | TPM or TM |
      | Yes       |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    #############################My Request Dashboard####################################################
    And verify submitted "<Form Name>" is present in my request page with "NEW" status
    And verify "background color" of "NEW" status is "Pink" in my request page
    When user searches request in my request page
    Then verify all fields in the Extend or Bridge Crew Production form are matching with columns in My Request dashboard
      | Slug | Submitted   | Prod Date    | Show Title             |
      |      | CurrentDate | <Start Date> | <Show or Project Name> |
    #############################All Request Dashboard####################################################
    When user clicks on "All Requests" button
    Then verify all fields in the Extend or Bridge Crew Production form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date    | Show Title             |
      | <Requesters> |      | CurrentDate | <Start Date> | <Show or Project Name> |
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "NEW" status
    And verify "background color" of "NEW" status is "Pink" in fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the Extend or Bridge form are matching with columns in production dashboard
      | Requesters   | Prod Date                             | Show/Project           | Production Purpose | Set Location              | Control Room                           | Submitted   |
      | <Requesters> | <Start Date>,<Start Time>, <End Time> | <Show or Project Name> | <Request For>      | <Location>,<Set Location> | <Control Room Location>,<Control Room> | CurrentDate |
    ##############################Email Validation###########################################
    Then validate recieved email notification for status "NEW"
    Then validate "ToList" in the recieved email
    Then validate "CcList" in the recieved email
    ############################ user adding notes as requester and validating notes ############################
    When user clicks on "MY REQUEST DASHBOARD PAGE" button
    When user searches request in my request page
    And user click edit link of the request in "My Request page"
    When user verifies logs are displaying in Log section
    When user click "Notes" tab in request form page
    And user enters add notes details in Notes section
      | Notes Info      |
      | testr requester |
    And validate Notes added by "Requester"
    And verifies "Requester" able to edits the Notes with new text "Updated Test Requester"
    And user clicks on "save" button
    And user clicks on "Ok" button
    #############################My Request Dashboard####################################################
    When user clicks on "MY REQUEST DASHBOARD PAGE" button
    When user clicks on "MY REQUESTS" button
    And verify submitted "<Form Name>" is present in my request page with "MODIFIED" status
    And verify "background color" of "MODIFIED" status is "Orange" in my request page
    When user searches request in my request page
    Then verify all fields in the Extend or Bridge Crew Production form are matching with columns in My Request dashboard
      | Slug | Submitted   | Prod Date    | Show Title             |
      |      | CurrentDate | <Start Date> | <Show or Project Name> |
    #############################All Request Dashboard####################################################
    When user clicks on "All Requests" button
    Then verify all fields in the Extend or Bridge Crew Production form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date    | Show Title             |
      | <Requesters> |      | CurrentDate | <Start Date> | <Show or Project Name> |
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "MODIFIED" status
    And verify "background color" of "MODIFIED" status is "Orange" in fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the Extend or Bridge form are matching with columns in production dashboard
      | Requesters   | Prod Date                             | Show/Project           | Production Purpose | Set Location              | Control Room                           | Submitted   |
      | <Requesters> | <Start Date>,<Start Time>, <End Time> | <Show or Project Name> | <Request For>      | <Location>,<Set Location> | <Control Room Location>,<Control Room> | CurrentDate |
    ##############################Email Validation###########################################
    Then validate recieved email notification for status "MODIFIED"
    Then validate "ToList" in the recieved email
    Then validate "CcList" in the recieved email
    And user logs out from application
    ############################ user logging in as fulfiller and modifying the form request ############################
    Given user opens producer dashboard application
    And user logins with "fulfiller" role
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "MODIFIED" status
    And verify "background color" of "MODIFIED" status is "Orange" in fullfiller dashboard
    And user click edit link of the request in "fulfiller page"
    When user verifies logs are displaying in Log section
    When user enters show information in Extend or Bridge Crew Production form
      | Request For | Air Platform | Show or Project Name | Start Date | Start Time | End Time |
      |             | Internal     |                      |            |            |          |
    ########################### user adding notes as fulfiller and validating############################
    When user click "Notes" tab in request form page
    And validate Notes updated by "Requester" from fulfiller end
    And user enters add notes details in Notes section
      | Notes Info      |
      | testr fulfiller |
    And validate Notes added by "Fulfillment"
    And verifies "Fulfillment" able to edits the Notes with new text "Updated Test Fulfiller"
    And user clicks on "save" button
    And user clicks on "ok" button
    #############################All Request Dashboard####################################################
    When user clicks on "MY REQUEST DASHBOARD PAGE" button
    When user clicks on "All Requests" button
    Then verify all fields in the Extend or Bridge Crew Production form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date    | Show Title             |
      | <Requesters> |      | CurrentDate | <Start Date> | <Show or Project Name> |
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "MODIFIED" status
    And verify "background color" of "MODIFIED" status is "Orange" in fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the Extend or Bridge form are matching with columns in production dashboard
      | Requesters   | Prod Date                             | Show/Project           | Production Purpose | Set Location              | Control Room                           | Submitted   |
      | <Requesters> | <Start Date>,<Start Time>, <End Time> | <Show or Project Name> | <Request For>      | <Location>,<Set Location> | <Control Room Location>,<Control Room> | CurrentDate |
    ############################ Acknowledged the form request ############################
    And user click edit link of the request in "fulfiller page"
    When user verifies logs are displaying in Log section
    When user click "Status" tab in request form page
    When user changes status to "Acknowledged"
    When user clicks on "save" button
    And user clicks on "ok" button
    #############################All Request Dashboard####################################################
    When user clicks on "MY REQUEST DASHBOARD PAGE" button
    When user clicks on "All Requests" button
    Then verify all fields in the Extend or Bridge Crew Production form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date    | Show Title             |
      | <Requesters> |      | CurrentDate | <Start Date> | <Show or Project Name> |
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "WORKING" status
    And verify "background color" of "WORKING" status is "Blue" in fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the Extend or Bridge form are matching with columns in production dashboard
      | Requesters   | Prod Date                             | Show/Project           | Production Purpose | Set Location              | Control Room                           | Submitted   |
      | <Requesters> | <Start Date>,<Start Time>, <End Time> | <Show or Project Name> | <Request For>      | <Location>,<Set Location> | <Control Room Location>,<Control Room> | CurrentDate |
    ##############################Email Validation###########################################
    Then validate recieved email notification for status "WORKING"
    Then validate "ToList" in the recieved email for "WORKING" status
    Then validate "CcList" in the recieved email for "WORKING" status
    ########################### Technical the form request ############################
    And user click edit link of the request in "fulfiller page"
    When user verifies logs are displaying in Log section
    When user click "Status" tab in request form page
    When user changes status to "Technical"
    When user clicks on "save" button
     When user clicks on "ok" button
     When user clicks on "MY REQUEST DASHBOARD PAGE" button
    #############################All Request Dashboard####################################################
    When user clicks on "All Requests" button
    Then verify all fields in the Extend or Bridge Crew Production form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date    | Show Title             |
      | <Requesters> |      | CurrentDate | <Start Date> | <Show or Project Name> |
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "WORKING" status
    And verify "background color" of "WORKING" status is "Blue" in fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the Extend or Bridge form are matching with columns in production dashboard
      | Requesters   | Prod Date                             | Show/Project           | Production Purpose | Set Location              | Control Room                           | Submitted   |
      | <Requesters> | <Start Date>,<Start Time>, <End Time> | <Show or Project Name> | <Request For>      | <Location>,<Set Location> | <Control Room Location>,<Control Room> | CurrentDate |
    ########################### LA FULFILLMENT the form request ############################
    And user click edit link of the request in "fulfiller page"
    When user verifies logs are displaying in Log section
    When user click "Status" tab in request form page
    When user changes status to "LA FULFILLMENT"
    When user clicks on "save" button
     When user clicks on "ok" button
     When user clicks on "MY REQUEST DASHBOARD PAGE" button
    #############################All Request Dashboard####################################################
    When user clicks on "All Requests" button
    Then verify all fields in the Extend or Bridge Crew Production form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date    | Show Title             |
      | <Requesters> |      | CurrentDate | <Start Date> | <Show or Project Name> |
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "WORKING" status
    And verify "background color" of "WORKING" status is "Blue" in fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the Extend or Bridge form are matching with columns in production dashboard
      | Requesters   | Prod Date                             | Show/Project           | Production Purpose | Set Location              | Control Room                           | Submitted   |
      | <Requesters> | <Start Date>,<Start Time>, <End Time> | <Show or Project Name> | <Request For>      | <Location>,<Set Location> | <Control Room Location>,<Control Room> | CurrentDate |
    ############################ TM/TPM the form request ############################
    And user click edit link of the request in "fulfiller page"
    When user verifies logs are displaying in Log section
    When user click "Status" tab in request form page
    When user changes status to "TM/TPM"
    When user clicks on "save" button
     When user clicks on "ok" button
     When user clicks on "MY REQUEST DASHBOARD PAGE" button
    #############################All Request Dashboard####################################################
    When user clicks on "All Requests" button
    Then verify all fields in the Extend or Bridge Crew Production form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date    | Show Title             |
      | <Requesters> |      | CurrentDate | <Start Date> | <Show or Project Name> |
    And user opens fulfiller dashboard for "<Form Name>" form
    Then user clicks "Fulfilled" requests dropdown in Production Dashboard
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "FULFILLED" status
    And verify "background color" of "FULFILLED" status is "Green" in fullfiller dashboard
    Then verify all fields in the Extend or Bridge form are matching with columns in production dashboard
      | Requesters   | Prod Date                             | Show/Project           | Production Purpose | Set Location              | Control Room                           | Submitted   |
      | <Requesters> | <Start Date>,<Start Time>, <End Time> | <Show or Project Name> | <Request For>      | <Location>,<Set Location> | <Control Room Location>,<Control Room> | CurrentDate |
   ##############################Email Validation###########################################
    Then validate recieved email notification for status "FULFILLED"
    Then validate "ToList" in the recieved email for "FULFILLED" status
    Then validate "CcList" in the recieved email for "FULFILLED" status
    And user logs out from application
    ############################ user logging in as producer and modifying the request  ############################
    Given user opens producer dashboard application
    And user logins with "producer" role
    When user searches request in my request page
    And user click edit link of the request in "My Request page"
    When user verifies logs are displaying in Log section
    When user enters show information in Extend or Bridge Crew Production form
      | Request For | Air Platform     | Show or Project Name | Start Date | Start Time | End Time |
      |             | Video Conference |                      |            |            |          |
    When user clicks on "save" button
     When user clicks on "ok" button
     When user clicks on "MY REQUEST DASHBOARD PAGE" button
     When user clicks on "MY REQUESTS" button
    #############################My Request Dashboard####################################################
    And verify submitted "<Form Name>" is present in my request page with "MODIFIED" status
    And verify "background color" of "MODIFIED" status is "Orange" in my request page
    When user searches request in my request page
    Then verify all fields in the Extend or Bridge Crew Production form are matching with columns in My Request dashboard
      | Slug | Submitted   | Prod Date    | Show Title             |
      |      | CurrentDate | <Start Date> | <Show or Project Name> |
    #############################All Request Dashboard####################################################
    When user clicks on "All Requests" button
    Then verify all fields in the Extend or Bridge Crew Production form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date    | Show Title             |
      | <Requesters> |      | CurrentDate | <Start Date> | <Show or Project Name> |
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "MODIFIED" status
    And verify "background color" of "MODIFIED" status is "Orange" in fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the Extend or Bridge form are matching with columns in production dashboard
      | Requesters   | Prod Date                             | Show/Project           | Production Purpose | Set Location              | Control Room                           | Submitted   |
      | <Requesters> | <Start Date>,<Start Time>, <End Time> | <Show or Project Name> | <Request For>      | <Location>,<Set Location> | <Control Room Location>,<Control Room> | CurrentDate |
    ##############################Email Validation###########################################
    Then validate recieved email notification for status "MODIFIED"
    Then validate "ToList" in the recieved email
    Then validate "CcList" in the recieved email
    When user clicks on "MY REQUEST DASHBOARD PAGE" button
    ############################ user submitting cancel request ############################
     When user clicks on "MY REQUESTS" button
    When user searches request in my request page
    Then user click on request ID link of the request
    When user verifies logs are displaying in Log section
    When user clicks on "cancel request" button
    And verify "cancel request" alert message
      | Cancel Request Alert Message                                                                                     |
      | Are you sure you want to cancel this request? All cancellations are pending until confirmed by fulfillment teams |
    And click "Yes" on "cancel request" alert message
    Then verify request is "Cancellation Requested" successfully
    When user clicks on "NBCU Logo" button
    #############################My Request Dashboard####################################################
     When user clicks on "MY REQUESTS" button
    And verify submitted "<Form Name>" is present in my request page with "CONFIRM CANCELLATION" status
    And verify "background color" of "CONFIRM CANCELLATION" status is "Grey" in my request page
    When user searches request in my request page
    Then verify all fields in the Extend or Bridge Crew Production form are matching with columns in My Request dashboard
      | Slug | Submitted   | Prod Date    | Show Title             |
      |      | CurrentDate | <Start Date> | <Show or Project Name> |
    #############################All Request Dashboard####################################################
    When user clicks on "All Requests" button
    Then verify all fields in the Extend or Bridge Crew Production form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date    | Show Title             |
      | <Requesters> |      | CurrentDate | <Start Date> | <Show or Project Name> |
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "CONFIRM CANCELLATION" status
    And verify "background color" of "CONFIRM CANCELLATION" status is "Grey" in fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the Extend or Bridge form are matching with columns in production dashboard
      | Requesters   | Prod Date                             | Show/Project           | Production Purpose | Set Location              | Control Room                           | Submitted   |
      | <Requesters> | <Start Date>,<Start Time>, <End Time> | <Show or Project Name> | <Request For>      | <Location>,<Set Location> | <Control Room Location>,<Control Room> | CurrentDate |
    ##############################Email Validation###########################################
    Then validate recieved email notification for status "CONFIRM CANCELLATION"
    Then validate "ToList" in the recieved email
    Then validate "CcList" in the recieved email
    And user logs out from application
    ############################ user logging in as fulfiller and cancelled the form request ############################
    Given user opens producer dashboard application
    And user logins with "fulfiller" role
    And user opens fulfiller dashboard for "<Form Name>" form
     When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "CONFIRM CANCELLATION" status
    And verify "background color" of "CONFIRM CANCELLATION" status is "Grey" in fullfiller dashboard
    Then verify all fields in the Extend or Bridge form are matching with columns in production dashboard
      | Requesters   | Prod Date                             | Show/Project           | Production Purpose | Set Location              | Control Room                           | Submitted   |
      | <Requesters> | <Start Date>,<Start Time>, <End Time> | <Show or Project Name> | <Request For>      | <Location>,<Set Location> | <Control Room Location>,<Control Room> | CurrentDate |
    Then user click on request ID link of the request
    When user verifies logs are displaying in Log section
    When user clicks on "confirm cancel request" button
    And verify "confirm cancellation" alert message
      | Confirm Cancellation Alert Message           |
      | Are you sure you want to cancel this request |
    And click "Yes" on "confirm cancellation" alert message
    Then verify request is "Cancelled" successfully
    #############################All Request Dashboard####################################################
    When user clicks on "MY REQUEST DASHBOARD PAGE" button
    When user clicks on "All Requests" button
    Then verify all fields in the Extend or Bridge Crew Production form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date    | Show Title             |
      | <Requesters> |      | CurrentDate | <Start Date> | <Show or Project Name> |
    And user opens fulfiller dashboard for "<Form Name>" form
      Then user clicks "Fulfilled" requests dropdown in Production Dashboard
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "CANCELLED" status
    And verify "background color" of "CANCELLED" status is "Black" in fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the Extend or Bridge form are matching with columns in production dashboard
      | Requesters   | Prod Date                             | Show/Project           | Production Purpose | Set Location              | Control Room                           | Submitted   |
      | <Requesters> | <Start Date>,<Start Time>, <End Time> | <Show or Project Name> | <Request For>      | <Location>,<Set Location> | <Control Room Location>,<Control Room> | CurrentDate |
    ##############################Email Validation###########################################
    Then validate recieved email notification for status "CANCELLED"
    Then validate "ToList" in the recieved email
    Then validate "CcList" in the recieved email
    And user logs out from application
    ############################ user logging in as Requester ############################
    Given user opens producer dashboard application
    And user logins with "producer" role
    #############################My Request Dashboard####################################################
      When user clicks on "MY REQUEST DASHBOARD PAGE" button
    When user clicks on "MY REQUESTS" button
    #When user searches request in my request page
    And verify submitted "<Form Name>" is present in my request page with "CANCELLED" status
    And verify "background color" of "CANCELLED" status is "Black" in my request page
    When user searches request in my request page
    Then verify all fields in the Extend or Bridge Crew Production form are matching with columns in My Request dashboard
      | Slug | Submitted   | Prod Date    | Show Title             |
      |      | CurrentDate | <Start Date> | <Show or Project Name> |
    #############################All Request Dashboard####################################################
    When user clicks on "All Requests" button
    Then verify all fields in the Extend or Bridge Crew Production form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date    | Show Title             |
      | <Requesters> |      | CurrentDate | <Start Date> | <Show or Project Name> |
    And user opens fulfiller dashboard for "<Form Name>" form
     Then user clicks "Fulfilled" requests dropdown in Production Dashboard
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "CANCELLED" status
    And verify "background color" of "CANCELLED" status is "Black" in fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the Extend or Bridge form are matching with columns in production dashboard
      | Requesters   | Prod Date                             | Show/Project           | Production Purpose | Set Location              | Control Room                           | Submitted   |
      | <Requesters> | <Start Date>,<Start Time>, <End Time> | <Show or Project Name> | <Request For>      | <Location>,<Set Location> | <Control Room Location>,<Control Room> | CurrentDate |
    And user logs out from application

    Examples: 
      | Form Name                          | Division | Requesters         | Request For | Air Platform     | Show or Project Name | Start Date    | Start Time    | End Time      | Location | Set Location  | Control Room Location | Control Room |
      | Extend or Bridge Crew & Facilities | NBC News | Solai-Magesh       | Extend      | Video Conference | 7S Tour Studio       | CurrentDate+1 | CurrentTime+3 | CurrentTime+3 | LA       | Flashcam Room | Rock Center           | CR 31        |
