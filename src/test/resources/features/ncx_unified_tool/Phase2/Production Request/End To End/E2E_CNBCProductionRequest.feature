@CNBCProductionRequest @ProducerDashboard @END_TO_END
Feature: Validate various scenarios related CNBC production

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role

  @CNBCProductionRequest_e2e @SEVERITY=CRITICAL @StudioE2E 
  Scenario Outline: Verify user filling CNBC production request form
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in CNBC Production form
      | Division   | Additional Requesters | Talent              |
      | <Division> | <Requesters>          | test/tesr/test/test |
    When user enters Request For info in CNBC Production form
      | Request For   | Details and Notes   |
      | <Request For> | test/tesr/test/test |
    When user enters show information in CNBC Production form
      | Air Platform   | Sub Division   | Show or Project Name   | Start Date   | Call Time   | Start Time   | End Time   |
      | <Air Platform> | <Sub Division> | <Show or Project Name> | <Start Date> | <Call Time> | <Start Time> | <End Time> |
    When user enters set location information in CNBC Production form
      | Location   |
      | <Location> |
    When user enters set crew information in CNBC Production form
      | Set Crew   |
      | <Set Crew> |
    When user enters staging information in CNBC Production form
      | Staging Needs       |
      | Test-test-test-test |
    When user enters control room information in CNBC Production form
      | Control Room Needed   | Ingest | Iso | Control Room Crew   |
      | <Control Room Needed> | Yes    | Yes | <Control Room Crew> |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    #############################My Request Dashboard####################################################
    And verify submitted "<Form Name>" is present in my request page with "NEW" status
    And verify "background color" of "NEW" status is "Pink" in my request page
    When user searches request in my request page
    Then verify all fields in the CNBC Production form are matching with columns in My Request dashboard
      | Slug | Submitted   | Prod Date    | Show Title             |
      |      | CurrentDate | <Start Date> | <Show or Project Name> |
    #############################All Request Dashboard####################################################
    When user clicks on "All Requests" button
    Then verify all fields in the CNBC Production form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date    | Show Title             |
      | <Requesters> |      | CurrentDate | <Start Date> | <Show or Project Name> |
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "NEW" status
    And verify "background color" of "NEW" status is "Pink" in fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the CNBC form are matching with columns in production dashboard
      | Requesters   | Production Purpose | Prod Date                                         | Show/Project           | Set Location | Control Room          | Positions                      | Submitted   |
      | <Requesters> | <Request For>      | <Start Date>,<Call Time>,<Start Time>, <End Time> | <Show or Project Name> | <Location>   | <Control Room Needed> | <Set Crew>-<Control Room Crew> | CurrentDate |
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
    Then verify all fields in the CNBC Production form are matching with columns in My Request dashboard
      | Slug | Submitted   | Prod Date    | Show Title             |
      |      | CurrentDate | <Start Date> | <Show or Project Name> |
    #############################All Request Dashboard####################################################
    When user clicks on "All Requests" button
    Then verify all fields in the CNBC Production form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date    | Show Title             |
      | <Requesters> |      | CurrentDate | <Start Date> | <Show or Project Name> |
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "MODIFIED" status
    And verify "background color" of "MODIFIED" status is "Orange" in fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the CNBC form are matching with columns in production dashboard
      | Requesters   | Production Purpose | Prod Date                                         | Show/Project           | Set Location | Control Room          | Positions                      | Submitted   |
      | <Requesters> | <Request For>      | <Start Date>,<Call Time>,<Start Time>, <End Time> | <Show or Project Name> | <Location>   | <Control Room Needed> | <Set Crew>-<Control Room Crew> | CurrentDate |
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
    When user enters show information in CNBC Production form
      | Air Platform | Sub Division | Show or Project Name | Production Purpose | Start Date | Call Time | Start Time | End Time |
      | Internal     |              |                      |                    |            |           |            |          |
    ########################### user adding notes as fulfiller and validating############################
    When user click "Notes" tab in request form page
    And validate Notes updated by "Requester" from fulfiller end
    And user enters add notes details in Notes section
      | Notes Info      |
      | testr fulfiller |
    And validate Notes added by "Fulfillment"
    And verifies "Fulfillment" able to edits the Notes with new text "Updated Test Fulfiller"
    And user clicks on "save" button
    And user clicks on "Ok" button
    #############################All Request Dashboard####################################################
     When user clicks on "MY REQUEST DASHBOARD PAGE" button
    When user clicks on "All Requests" button
    Then verify all fields in the CNBC Production form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date    | Show Title             |
      | <Requesters> |      | CurrentDate | <Start Date> | <Show or Project Name> |
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "MODIFIED" status
    And verify "background color" of "MODIFIED" status is "Orange" in fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the CNBC form are matching with columns in production dashboard
      | Requesters   | Production Purpose | Prod Date                                         | Show/Project           | Set Location | Control Room          | Positions                      | Submitted   |
      | <Requesters> | <Request For>      | <Start Date>,<Call Time>,<Start Time>, <End Time> | <Show or Project Name> | <Location>   | <Control Room Needed> | <Set Crew>-<Control Room Crew> | CurrentDate |
    ############################ Acknowledged the form request ############################
    And user click edit link of the request in "fulfiller page"
    When user verifies logs are displaying in Log section
    When user click "Status" tab in request form page
    When user changes status to "Acknowledged"
    When user clicks on "save" button
    And user clicks on "Ok" button
    #############################All Request Dashboard####################################################
      When user clicks on "MY REQUEST DASHBOARD PAGE" button
    When user clicks on "All Requests" button
    Then verify all fields in the CNBC Production form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date    | Show Title             |
      | <Requesters> |      | CurrentDate | <Start Date> | <Show or Project Name> |
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "WORKING" status
    And verify "background color" of "WORKING" status is "Blue" in fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the CNBC form are matching with columns in production dashboard
      | Requesters   | Production Purpose | Prod Date                                         | Show/Project           | Set Location | Control Room          | Positions                      | Submitted   |
      | <Requesters> | <Request For>      | <Start Date>,<Call Time>,<Start Time>, <End Time> | <Show or Project Name> | <Location>   | <Control Room Needed> | <Set Crew>-<Control Room Crew> | CurrentDate |
    ##############################Email Validation###########################################
    Then validate recieved email notification for status "WORKING"
    Then validate "ToList" in the recieved email for "WORKING" status
    Then validate "CcList" in the recieved email for "WORKING" status
    ############################ PCR the form request ############################
    And user click edit link of the request in "fulfiller page"
    When user verifies logs are displaying in Log section
    When user click "Status" tab in request form page
    When user changes status to "PCR"
    When user clicks on "save" button
    And user clicks on "Ok" button
    When user clicks on "MY REQUEST DASHBOARD PAGE" button
    #############################All Request Dashboard####################################################
    When user clicks on "All Requests" button
    Then verify all fields in the CNBC Production form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date    | Show Title             |
      | <Requesters> |      | CurrentDate | <Start Date> | <Show or Project Name> |
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "WORKING" status
    And verify "background color" of "WORKING" status is "Blue" in fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the CNBC form are matching with columns in production dashboard
      | Requesters   | Production Purpose | Prod Date                                         | Show/Project           | Set Location | Control Room          | Positions                      | Submitted   |
      | <Requesters> | <Request For>      | <Start Date>,<Call Time>,<Start Time>, <End Time> | <Show or Project Name> | <Location>   | <Control Room Needed> | <Set Crew>-<Control Room Crew> | CurrentDate |
    ########################### Studio the form request ############################
    And user click edit link of the request in "fulfiller page"
    When user verifies logs are displaying in Log section
    When user click "Status" tab in request form page
    When user changes status to "Studio"
    When user clicks on "save" button
    And user clicks on "Ok" button
    When user clicks on "MY REQUEST DASHBOARD PAGE" button
    #############################All Request Dashboard####################################################
    When user clicks on "All Requests" button
    Then verify all fields in the CNBC Production form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date    | Show Title             |
      | <Requesters> |      | CurrentDate | <Start Date> | <Show or Project Name> |
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "WORKING" status
    And verify "background color" of "WORKING" status is "Blue" in fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the CNBC form are matching with columns in production dashboard
      | Requesters   | Production Purpose | Prod Date                                         | Show/Project           | Set Location | Control Room          | Positions                      | Submitted   |
      | <Requesters> | <Request For>      | <Start Date>,<Call Time>,<Start Time>, <End Time> | <Show or Project Name> | <Location>   | <Control Room Needed> | <Set Crew>-<Control Room Crew> | CurrentDate |
    ########################### Director the form request ############################
    And user click edit link of the request in "fulfiller page"
    When user verifies logs are displaying in Log section
    When user click "Status" tab in request form page
    When user changes status to "Director"
    When user clicks on "save" button
    And user clicks on "Ok" button
    When user clicks on "MY REQUEST DASHBOARD PAGE" button
    #############################All Request Dashboard####################################################
    When user clicks on "All Requests" button
    Then verify all fields in the CNBC Production form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date    | Show Title             |
      | <Requesters> |      | CurrentDate | <Start Date> | <Show or Project Name> |
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "WORKING" status
    And verify "background color" of "WORKING" status is "Blue" in fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the CNBC form are matching with columns in production dashboard
      | Requesters   | Production Purpose | Prod Date                                         | Show/Project           | Set Location | Control Room          | Positions                      | Submitted   |
      | <Requesters> | <Request For>      | <Start Date>,<Call Time>,<Start Time>, <End Time> | <Show or Project Name> | <Location>   | <Control Room Needed> | <Set Crew>-<Control Room Crew> | CurrentDate |
    ############################ TPS the form request ############################
    And user click edit link of the request in "fulfiller page"
    When user verifies logs are displaying in Log section
    When user click "Status" tab in request form page
    When user changes status to "TPS"
    When user clicks on "save" button
    And user clicks on "Ok" button
    When user clicks on "MY REQUEST DASHBOARD PAGE" button
    #############################All Request Dashboard####################################################
    When user clicks on "All Requests" button
    Then verify all fields in the CNBC Production form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date    | Show Title             |
      | <Requesters> |      | CurrentDate | <Start Date> | <Show or Project Name> |
    And user opens fulfiller dashboard for "<Form Name>" form
    Then user clicks "Fulfilled" requests dropdown in Production Dashboard
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "FULFILLED" status
    And verify "background color" of "FULFILLED" status is "Green" in fullfiller dashboard
    Then verify all fields in the CNBC form are matching with columns in production dashboard
      | Requesters   | Production Purpose | Prod Date                                         | Show/Project           | Set Location | Control Room          | Positions                      | Submitted   |
      | <Requesters> | <Request For>      | <Start Date>,<Call Time>,<Start Time>, <End Time> | <Show or Project Name> | <Location>   | <Control Room Needed> | <Set Crew>-<Control Room Crew> | CurrentDate |
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
    When user enters show information in CNBC Production form
      | Air Platform | Sub Division | Show or Project Name | Production Purpose | Start Date | Call Time | Start Time | End Time |
      | Cable        |              |                      |                    |            |           |            |          |
    When user clicks on "save" button
    And user clicks on "Ok" button
    #############################My Request Dashboard####################################################
    When user clicks on "MY REQUEST DASHBOARD PAGE" button
    When user clicks on "MY REQUESTS" button
    And verify submitted "<Form Name>" is present in my request page with "MODIFIED" status
    And verify "background color" of "MODIFIED" status is "Orange" in my request page
    When user searches request in my request page
    Then verify all fields in the CNBC Production form are matching with columns in My Request dashboard
      | Slug | Submitted   | Prod Date    | Show Title             |
      |      | CurrentDate | <Start Date> | <Show or Project Name> |
    #############################All Request Dashboard####################################################
    When user clicks on "MY REQUEST DASHBOARD PAGE" button
    When user clicks on "All Requests" button
    Then verify all fields in the CNBC Production form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date    | Show Title             |
      | <Requesters> |      | CurrentDate | <Start Date> | <Show or Project Name> |
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "MODIFIED" status
    And verify "background color" of "MODIFIED" status is "Orange" in fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the CNBC form are matching with columns in production dashboard
      | Requesters   | Production Purpose | Prod Date                                         | Show/Project           | Set Location | Control Room          | Positions                      | Submitted   |
      | <Requesters> | <Request For>      | <Start Date>,<Call Time>,<Start Time>, <End Time> | <Show or Project Name> | <Location>   | <Control Room Needed> | <Set Crew>-<Control Room Crew> | CurrentDate |
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
    Then verify all fields in the CNBC Production form are matching with columns in My Request dashboard
      | Slug | Submitted   | Prod Date    | Show Title             |
      |      | CurrentDate | <Start Date> | <Show or Project Name> |
    #############################All Request Dashboard####################################################
    When user clicks on "All Requests" button
    Then verify all fields in the CNBC Production form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date    | Show Title             |
      | <Requesters> |      | CurrentDate | <Start Date> | <Show or Project Name> |
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "CONFIRM CANCELLATION" status
    And verify "background color" of "CONFIRM CANCELLATION" status is "Grey" in fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the CNBC form are matching with columns in production dashboard
      | Requesters   | Production Purpose | Prod Date                                         | Show/Project           | Set Location | Control Room          | Positions                      | Submitted   |
      | <Requesters> | <Request For>      | <Start Date>,<Call Time>,<Start Time>, <End Time> | <Show or Project Name> | <Location>   | <Control Room Needed> | <Set Crew>-<Control Room Crew> | CurrentDate |
    ##############################Email Validation###########################################
     Then validate recieved email notification for status "CONFIRM CANCELLATION"
    Then validate "ToList" in the recieved email for "CONFIRM CANCELLATION" status
    Then validate "CcList" in the recieved email for "CONFIRM CANCELLATION" status
    And user logs out from application
    ############################ user logging in as fulfiller and cancelled the form request ############################
    Given user opens producer dashboard application
    And user logins with "fulfiller" role
    And user opens fulfiller dashboard for "<Form Name>" form
      When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "CONFIRM CANCELLATION" status
    And verify "background color" of "CONFIRM CANCELLATION" status is "Grey" in fullfiller dashboard
    Then verify all fields in the CNBC form are matching with columns in production dashboard
      | Requesters   | Production Purpose | Prod Date                                         | Show/Project           | Set Location | Control Room          | Positions                      | Submitted   |
      | <Requesters> | <Request For>      | <Start Date>,<Call Time>,<Start Time>, <End Time> | <Show or Project Name> | <Location>   | <Control Room Needed> | <Set Crew>-<Control Room Crew> | CurrentDate |
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
    Then verify all fields in the CNBC Production form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date    | Show Title             |
      | <Requesters> |      | CurrentDate | <Start Date> | <Show or Project Name> |
    And user opens fulfiller dashboard for "<Form Name>" form
     Then user clicks "Fulfilled" requests dropdown in Production Dashboard
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "CANCELLED" status
    And verify "background color" of "CANCELLED" status is "Black" in fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the CNBC form are matching with columns in production dashboard
      | Requesters   | Production Purpose | Prod Date                                         | Show/Project           | Set Location | Control Room          | Positions                      | Submitted   |
      | <Requesters> | <Request For>      | <Start Date>,<Call Time>,<Start Time>, <End Time> | <Show or Project Name> | <Location>   | <Control Room Needed> | <Set Crew>-<Control Room Crew> | CurrentDate |
    ##############################Email Validation###########################################
    Then validate recieved email notification for status "CANCELLED"
    Then validate "ToList" in the recieved email for "CANCELLED" status
    Then validate "CcList" in the recieved email for "CANCELLED" status
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
    Then verify all fields in the CNBC Production form are matching with columns in My Request dashboard
      | Slug | Submitted   | Prod Date    | Show Title             |
      |      | CurrentDate | <Start Date> | <Show or Project Name> |
    #############################All Request Dashboard####################################################
    When user clicks on "All Requests" button
    Then verify all fields in the CNBC Production form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date    | Show Title             |
      | <Requesters> |      | CurrentDate | <Start Date> | <Show or Project Name> |
    And user opens fulfiller dashboard for "<Form Name>" form
     Then user clicks "Fulfilled" requests dropdown in Production Dashboard
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "CANCELLED" status
    And verify "background color" of "CANCELLED" status is "Black" in fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the CNBC form are matching with columns in production dashboard
      | Requesters   | Production Purpose | Prod Date                                         | Show/Project           | Set Location | Control Room          | Positions                      | Submitted   |
      | <Requesters> | <Request For>      | <Start Date>,<Call Time>,<Start Time>, <End Time> | <Show or Project Name> | <Location>   | <Control Room Needed> | <Set Crew>-<Control Room Crew> | CurrentDate |

    Examples: 
      | Form Name | Division | Requesters         | Request For    | Air Platform | Sub Division | Show or Project Name | Start Date    | Call Time     | Start Time    | End Time      | Location | Set Crew                                 | Control Room Needed | Control Room Crew  |
      | CNBC      | Acorn    | Solai-Magesh       | Internal Event | OTT          |              | Power Lunch          | CurrentDate+1 | CurrentTime+3 | CurrentTime+3 | CurrentTime+3 | EC,DC,EC | Flashcam,Lighting Director,Playout       | Yes                 | TPS,Director       |
