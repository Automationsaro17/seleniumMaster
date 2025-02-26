@CNBCProductionRequest @ProducerDashboard @Dashboard_Validation @END_TO_END
Feature: Validate various scenarios related CNBC production

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role

  @CNBCProductionRequest_Dashboard_Validation_e2e @SEVERITY=CRITICAL @StudioE2E
  Scenario Outline: Verify user filling CNBC production request form and validating in dashboard
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
    ###################################################################################################
    And verify submitted "<Form Name>" is present in my request page with "NEW" status
    And verify "background color" of "NEW" status is "Pink" in my request page
    When user searches request in my request page
    And user click edit link of the request in "My Request page"
    ############################ user adding notes as requester ############################
    When user verifies logs are displaying in Log section
    When user click "Notes" tab in request form page
    And user enters add notes details in Notes section
      | Notes Info       |
      | testr  requester |
    And user clicks on "save request" button
    And verify submitted "<Form Name>" is present in my request page with "MODIFIED" status
    And verify "background color" of "MODIFIED" status is "Orange" in my request page
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "MODIFIED" status
    And verify "background color" of "MODIFIED" status is "Orange" in fullfiller dashboard
    Then verify all fields in the CNBC form are matching with columns in production dashboard
      | Requesters   | Production Purpose | Prod Date                                         | Show/Project           | Set Location | Control Room          | Positions                      | Submitted   |
      | <Requesters> | <Request For>      | <Start Date>,<Call Time>,<Start Time>, <End Time> | <Show or Project Name> | <Location>   | <Control Room Needed> | <Set Crew>-<Control Room Crew> | CurrentDate |
    When user clicks on "NBCU Logo" button
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
    ############################ user adding notes as fulfiller ############################
    When user click "Notes" tab in request form page
    And user enters add notes details in Notes section
      | Notes Info       |
      | testr  fulfiller |
    When user clicks on "save" button
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "MODIFIED" status
    And verify "background color" of "MODIFIED" status is "Orange" in fullfiller dashboard
    Then verify all fields in the CNBC form are matching with columns in production dashboard
      | Requesters   | Production Purpose | Prod Date                                         | Show/Project           | Set Location | Control Room          | Positions                      | Submitted   |
      | <Requesters> | <Request For>      | <Start Date>,<Call Time>,<Start Time>, <End Time> | <Show or Project Name> | <Location>   | <Control Room Needed> | <Set Crew>-<Control Room Crew> | CurrentDate |
    ############################ Acknowledged the form request ############################
    And user click edit link of the request in "fulfiller page"
    When user verifies logs are displaying in Log section
    When user click "Status" tab in request form page
    When user changes status to "Acknowledged"
    When user clicks on "save request" button
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "WORKING" status
    And verify "background color" of "WORKING" status is "Blue" in fullfiller dashboard
    Then verify all fields in the CNBC form are matching with columns in production dashboard
      | Requesters   | Production Purpose | Prod Date                                         | Show/Project           | Set Location | Control Room          | Positions                      | Submitted   |
      | <Requesters> | <Request For>      | <Start Date>,<Call Time>,<Start Time>, <End Time> | <Show or Project Name> | <Location>   | <Control Room Needed> | <Set Crew>-<Control Room Crew> | CurrentDate |
    ############################ PCR the form request ############################
    And user click edit link of the request in "fulfiller page"
    When user verifies logs are displaying in Log section
    When user click "Status" tab in request form page
    When user changes status to "PCR"
    When user clicks on "save request" button
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "WORKING" status
    And verify "background color" of "WORKING" status is "Blue" in fullfiller dashboard
    Then verify all fields in the CNBC form are matching with columns in production dashboard
      | Requesters   | Production Purpose | Prod Date                                         | Show/Project           | Set Location | Control Room          | Positions                      | Submitted   |
      | <Requesters> | <Request For>      | <Start Date>,<Call Time>,<Start Time>, <End Time> | <Show or Project Name> | <Location>   | <Control Room Needed> | <Set Crew>-<Control Room Crew> | CurrentDate |
    ############################ Studio the form request ############################
    And user click edit link of the request in "fulfiller page"
    When user verifies logs are displaying in Log section
    When user click "Status" tab in request form page
    When user changes status to "Studio"
    When user clicks on "save request" button
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "WORKING" status
    And verify "background color" of "WORKING" status is "Blue" in fullfiller dashboard
    Then verify all fields in the CNBC form are matching with columns in production dashboard
      | Requesters   | Production Purpose | Prod Date                                         | Show/Project           | Set Location | Control Room          | Positions                      | Submitted   |
      | <Requesters> | <Request For>      | <Start Date>,<Call Time>,<Start Time>, <End Time> | <Show or Project Name> | <Location>   | <Control Room Needed> | <Set Crew>-<Control Room Crew> | CurrentDate |
    ############################ Director the form request ############################
    And user click edit link of the request in "fulfiller page"
    When user verifies logs are displaying in Log section
    When user click "Status" tab in request form page
    When user changes status to "Director"
    When user clicks on "save request" button
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "WORKING" status
    And verify "background color" of "WORKING" status is "Blue" in fullfiller dashboard
    Then verify all fields in the CNBC form are matching with columns in production dashboard
      | Requesters   | Production Purpose | Prod Date                                         | Show/Project           | Set Location | Control Room          | Positions                      | Submitted   |
      | <Requesters> | <Request For>      | <Start Date>,<Call Time>,<Start Time>, <End Time> | <Show or Project Name> | <Location>   | <Control Room Needed> | <Set Crew>-<Control Room Crew> | CurrentDate |
    ############################ TPS the form request ############################
    And user click edit link of the request in "fulfiller page"
    When user verifies logs are displaying in Log section
    When user click "Status" tab in request form page
    When user changes status to "TPS"
    When user clicks on "save request" button
    And user opens fulfiller dashboard for "<Form Name>" form
    Then user clicks "Fulfilled" requests dropdown in Production Dashboard
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "FULFILLED" status
    And verify "background color" of "FULFILLED" status is "Green" in fullfiller dashboard
    Then verify all fields in the CNBC form are matching with columns in production dashboard
      | Requesters   | Production Purpose | Prod Date                                         | Show/Project           | Set Location | Control Room          | Positions                      | Submitted   |
      | <Requesters> | <Request For>      | <Start Date>,<Call Time>,<Start Time>, <End Time> | <Show or Project Name> | <Location>   | <Control Room Needed> | <Set Crew>-<Control Room Crew> | CurrentDate |
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
    When user clicks on "save request" button
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "MODIFIED" status
    And verify "background color" of "MODIFIED" status is "Orange" in fullfiller dashboard
    Then verify all fields in the CNBC form are matching with columns in production dashboard
      | Requesters   | Production Purpose | Prod Date                                         | Show/Project           | Set Location | Control Room          | Positions                      | Submitted   |
      | <Requesters> | <Request For>      | <Start Date>,<Call Time>,<Start Time>, <End Time> | <Show or Project Name> | <Location>   | <Control Room Needed> | <Set Crew>-<Control Room Crew> | CurrentDate |
    ############################ user submitting cancel request ############################
    When user clicks on "MY REQUEST DASHBOARD PAGE" button
    When user searches request in my request page
    Then user click on request ID link of the request
    When user verifies logs are displaying in Log section
    When user clicks on "cancel request" button
    And verify "cancel request" alert message
      | Cancel Request Alert Message                                                                                     |
      | Are you sure you want to cancel this request? All cancellations are pending until confirmed by fulfillment teams |
    And click "yes" on "cancel request" alert message
    Then verify request is "Cancellation Requested" successfully
    When user clicks on "NBCU Logo" button
    And verify submitted "<Form Name>" is present in my request page with "CONFIRM CANCELLATION" status
    And verify "background color" of "CONFIRM CANCELLATION" status is "Grey" in my request page
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "CONFIRM CANCELLATION" status
    And verify "background color" of "CONFIRM CANCELLATION" status is "Grey" in fullfiller dashboard
    Then verify all fields in the CNBC form are matching with columns in production dashboard
      | Requesters   | Production Purpose | Prod Date                                         | Show/Project           | Set Location | Control Room          | Positions                      | Submitted   |
      | <Requesters> | <Request For>      | <Start Date>,<Call Time>,<Start Time>, <End Time> | <Show or Project Name> | <Location>   | <Control Room Needed> | <Set Crew>-<Control Room Crew> | CurrentDate |
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
    And click "yes" on "confirm cancellation" alert message
    Then verify request is "Cancelled" successfully
    And user opens fulfiller dashboard for "<Form Name>" form
    Then user clicks "Fulfilled" requests dropdown in Production Dashboard
    And user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "CANCELLED" status
    And verify "background color" of "CANCELLED" status is "Black" in fullfiller dashboard
    Then verify all fields in the CNBC form are matching with columns in production dashboard
      | Requesters   | Production Purpose | Prod Date                                         | Show/Project           | Set Location | Control Room          | Positions                      | Submitted   |
      | <Requesters> | <Request For>      | <Start Date>,<Call Time>,<Start Time>, <End Time> | <Show or Project Name> | <Location>   | <Control Room Needed> | <Set Crew>-<Control Room Crew> | CurrentDate |
    Then user click on request ID link of the request
    When user verifies logs are displaying in Log section

    Examples: 
      | Form Name | Division | Requesters         | Request For    | Air Platform | Sub Division | Show or Project Name | Start Date    | Call Time     | Start Time    | End Time      | Location | Set Crew                                 | Control Room Needed | Control Room Crew  |
      | CNBC      | Acorn    | Solai-Jeevanandham | Internal Event | OTT          |              | Power Lunch          | CurrentDate+1 | CurrentTime+3 | CurrentTime+3 | CurrentTime+3 | EC,DC,EC | Flashcam,Lighting Director,Playout,Other | Yes                 | TPS,Director,Other |

  @CNBCProductionRequest_Dashboard_Validation_e2e_short @SEVERITY=CRITICAL @StudioE2E
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
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "NEW" status
    And verify "background color" of "NEW" status is "Pink" in fullfiller dashboard
    Then verify all fields in the CNBC form are matching with columns in production dashboard
      | Requesters   | Production Purpose | Prod Date                                         | Show/Project           | Set Location | Control Room          | Positions                      | Submitted   |
      | <Requesters> | <Request For>      | <Start Date>,<Call Time>,<Start Time>, <End Time> | <Show or Project Name> | <Location>   | <Control Room Needed> | <Set Crew>-<Control Room Crew> | CurrentDate |
    When user clicks on "NBCU Logo" button
    And user logs out from application
    Given user opens producer dashboard application
    And user logins with "fulfiller" role
    ############################ user logging in as fulfiller and modifying the form request ############################
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    ############################ Acknowledged the form request ############################
    And user click edit link of the request in "fulfiller page"
    When user verifies logs are displaying in Log section
    When user click "Status" tab in request form page
    When user changes status to "Acknowledged"
    When user changes status to "PCR"
    When user changes status to "Studio"
    When user changes status to "Director"
    When user changes status to "TPS"
    When user clicks on "save request" button
    And user opens fulfiller dashboard for "<Form Name>" form
    Then user clicks "Fulfilled" requests dropdown in Production Dashboard
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "FULFILLED" status
    And verify "background color" of "FULFILLED" status is "Green" in fullfiller dashboard
    Then verify all fields in the CNBC form are matching with columns in production dashboard
      | Requesters   | Production Purpose | Prod Date                                         | Show/Project           | Set Location | Control Room          | Positions                      | Submitted   |
      | <Requesters> | <Request For>      | <Start Date>,<Call Time>,<Start Time>, <End Time> | <Show or Project Name> | <Location>   | <Control Room Needed> | <Set Crew>-<Control Room Crew> | CurrentDate |
    ############################ Studio the form request ############################
    And user click edit link of the request in "fulfiller page"

    Examples: 
      | Form Name | Division | Requesters         | Request For    | Air Platform | Sub Division | Show or Project Name | Start Date    | Call Time     | Start Time    | End Time      | Location | Set Crew                                 | Control Room Needed | Control Room Crew  |
      | CNBC      | Acorn    | Solai-Jeevanandham | Internal Event | OTT          |              | Power Lunch          | CurrentDate+1 | CurrentTime+3 | CurrentTime+3 | CurrentTime+3 | EC,DC,EC | Flashcam,Lighting Director,Playout,Other | Yes                 | TPS,Director,Other |