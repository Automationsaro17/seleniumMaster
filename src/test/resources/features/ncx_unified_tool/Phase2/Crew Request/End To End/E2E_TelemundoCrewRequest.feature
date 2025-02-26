@TelemundoCrewRequest @ProducerDashboard @END_TO_END
Feature: Validate various scenarios related Telemundo Crew

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role

  @TelemundoCrewRequest_e2e @SEVERITY=CRITICAL @CrewE2E
  Scenario Outline: Verify user filling Telemundo Crew Request form
    And user clicks on forms link
    And user selects "<Form Name>" form
    Then user enters General info in Telemundo Crew form
      | Slug   | NCX Story Name | Additional Requesters | Is Producer Same as Requestor | Sr Producer   | Is Onsite Producer | Talent   |
      | <Slug> |                | <Requesters>          | <Producer>                    | <Sr Producer> | Yes                | <Talent> |
    When user enters field contact Information in Telemundo Crew form
      | Field Contact | Phone      |
      | Jeevanandham  | 9898989877 |
    When user enters show title Information in Telemundo Crew form
      | ShowTitle    |
      | <Show Title> |
    When user enters shoot details Information in Telemundo Crew form
      | Production Type | Shoot Status   | Shoot Description   |
      | LIVE - Anchor   | <Shoot Status> | test/tesr/test/test |
    When user enters shoot specs Information in Telemundo Crew form
      | Audio Needs   | Special Conditions | Transmission Type | Is this a Drone Shoot | iPad Prompter Required | Special Gear |
      | Complex Audio | Weather concern    | LIVEU             | No                    | No                     | No           |
    When user enters shoot location Information in Telemundo Crew form
      | Shoot Location   | Risk Assessment Category | Risk Assessment Type | Risk Arrangements | Risk Approver |
      | <Shoot Location> |                          |                      |                   |               |
    When user enters Date & Time Information in Telemundo Crew form
      | Shoot Start Date   | Shoot End Date   | Time Zone | Meet Time     | Start Time    | End Time      |
      | <Shoot Start Date> | <Shoot End Date> | PT        | CurrentTime+1 | CurrentTime+2 | CurrentTime+3 |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    #############################My Request Dashboard####################################################
    And verify submitted "<Form Name>" is present in my request page with "NEW" status
    And verify "background color" of "NEW" status is "Pink" in my request page
    When user searches request in my request page
    Then verify all fields in the Telemundo News Crew form are matching with columns in My Request dashboard
      | Slug   | Submitted   | Prod Date   | Show Title   |
      | <Slug> | CurrentDate | <Prod Date> | <Show Title> |
    #############################All Request Dashboard####################################################
    When user clicks on "All Requests" button
    Then verify all fields in the Telemundo News Crew form are matching with columns in All Request dashboard
      | Requesters   | Slug   | Submitted   | Prod Date   | Show Title   |
      | <Requesters> | <Slug> | CurrentDate | <Prod Date> | <Show Title> |
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "NEW" status
    ##############################Dashboard Validation###########################################
    Then verify all fields in the Telemundo News Crew form are matching with "<Dashboard Name>" view columns in crew dashboard
      | Status | Color | Shoot Start Date   | Meet Time   | Shoot Status   | Slug   | Shoot Location    | Talent   | Show Title   | Requesters   | Producer   | Sr Producer   | Submitted   |
      | New    | Pink  | <Shoot Start Date> | <Meet Time> | <Shoot Status> | <Slug> | <Shoot Location > | <Talent> | <Show Title> | <Requesters> | <Producer> | <Sr Producer> | CurrentDate |
    Then verify resource count and crew details in the Telemundo News Crew form are matching with "<Dashboard Name>" view columns in crew dashboard
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
    #############################My Request Dashboard####################################################
    When user clicks on "MY REQUEST DASHBOARD PAGE" button
    When user clicks on "MY REQUESTS" button
    And verify submitted "<Form Name>" is present in my request page with "REVISED" status
    And verify "background color" of "REVISED" status is "Orange" in my request page
    When user searches request in my request page
    Then verify all fields in the Telemundo News Crew form are matching with columns in My Request dashboard
      | Slug   | Submitted   | Prod Date   | Show Title   |
      | <Slug> | CurrentDate | <Prod Date> | <Show Title> |
    #############################All Request Dashboard####################################################
    When user clicks on "All Requests" button
    Then verify all fields in the Telemundo News Crew form are matching with columns in All Request dashboard
      | Requesters   | Slug   | Submitted   | Prod Date   | Show Title   |
      | <Requesters> | <Slug> | CurrentDate | <Prod Date> | <Show Title> |
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "REVISED" status
    ##############################Dashboard Validation###########################################
    Then verify all fields in the Telemundo News Crew form are matching with "<Dashboard Name>" view columns in crew dashboard
      | Status  | Color  | Shoot Start Date   | Meet Time   | Shoot Status   | Slug   | Shoot Location    | Talent   | Show Title   | Requesters   | Producer   | Sr Producer   | Submitted   |
      | REVISED | Orange | <Shoot Start Date> | <Meet Time> | <Shoot Status> | <Slug> | <Shoot Location > | <Talent> | <Show Title> | <Requesters> | <Producer> | <Sr Producer> | CurrentDate |
    Then verify resource count and crew details in the Telemundo News Crew form are matching with "<Dashboard Name>" view columns in crew dashboard
    ##############################Email Validation###########################################
    Then validate recieved email notification for status "REVISED"
    Then validate "ToList" in the recieved email
    Then validate "CcList" in the recieved email
    And user logs out from application
    ############################ user logging in as fulfiller and modifying the form request ############################
    Given user opens producer dashboard application
    And user logins with "fulfiller" role
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "REVISED" status
    And verify "background color" of "REVISED" status is "Orange" in fullfiller dashboard
    And user click edit link of the request in "fulfiller page"
    When user verifies logs are displaying in Log section
    When user enters shoot location Information in Telemundo Crew form
      | Shoot Location | Risk Assessment Category | Risk Assessment Type | Risk Arrangements | Risk Approver |
      | Chicago Bureau |                          |                      |                   |               |
    ########################### user adding notes as fulfiller and validating############################
    When user click "Notes" tab in request form page
    And validate Notes updated by "Requester" from fulfiller end
    And user enters add notes details in Notes section
      | Notes Info      |
      | testr fulfiller |
    And validate Notes added by "Fulfillment"
    And verifies "Fulfillment" able to edits the Notes with new text "Updated Test Fulfiller"
    And user clicks on "publish" button
    #############################All Request Dashboard####################################################
    When user clicks on "MY REQUEST DASHBOARD PAGE" button
    When user clicks on "All Requests" button
    Then verify all fields in the Telemundo News Crew form are matching with columns in All Request dashboard
      | Requesters   | Slug   | Submitted   | Prod Date   | Show Title   |
      | <Requesters> | <Slug> | CurrentDate | <Prod Date> | <Show Title> |
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "REVISED" status
    ##############################Dashboard Validation###########################################
    Then verify all fields in the Telemundo News Crew form are matching with "<Dashboard Name>" view columns in crew dashboard
      | Status  | Color  | Shoot Start Date   | Meet Time   | Shoot Status   | Slug   | Shoot Location    | Talent   | Show Title   | Requesters   | Producer   | Sr Producer   | Submitted   |
      | REVISED | Orange | <Shoot Start Date> | <Meet Time> | <Shoot Status> | <Slug> | <Shoot Location > | <Talent> | <Show Title> | <Requesters> | <Producer> | <Sr Producer> | CurrentDate |
    Then verify resource count and crew details in the Telemundo News Crew form are matching with "<Dashboard Name>" view columns in crew dashboard
    ############################ Efforting the form request ############################
    And user click edit link of the request in "fulfiller page"
    When user verifies logs are displaying in Log section
    Then user click "fulfillment" tab in request form page
    And user changes status to "EFFORTING"
    And user clicks on "publish" button
    #############################All Request Dashboard####################################################
    When user clicks on "MY REQUEST DASHBOARD PAGE" button
    When user clicks on "All Requests" button
    Then verify all fields in the Telemundo News Crew form are matching with columns in All Request dashboard
      | Requesters   | Slug   | Submitted   | Prod Date   | Show Title   |
      | <Requesters> | <Slug> | CurrentDate | <Prod Date> | <Show Title> |
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "EFFORTING" status
    ##############################Dashboard Validation###########################################
    Then verify all fields in the Telemundo News Crew form are matching with "<Dashboard Name>" view columns in crew dashboard
      | Status    | Color | Shoot Start Date   | Meet Time   | Shoot Status   | Slug   | Shoot Location    | Talent   | Show Title   | Requesters   | Producer   | Sr Producer   | Submitted   |
      | EFFORTING | Blue  | <Shoot Start Date> | <Meet Time> | <Shoot Status> | <Slug> | <Shoot Location > | <Talent> | <Show Title> | <Requesters> | <Producer> | <Sr Producer> | CurrentDate |
    Then verify resource count and crew details in the Telemundo News Crew form are matching with "<Dashboard Name>" view columns in crew dashboard
    ##############################Email Validation###########################################
    Then validate recieved email notification for status "EFFORTING"
    Then validate "ToList" in the recieved email for "EFFORTING" status
    Then validate "CcList" in the recieved email for "EFFORTING" status
    ############################ ROFR the form request ############################
    And user click edit link of the request in "fulfiller page"
    When user verifies logs are displaying in Log section
    Then user click "fulfillment" tab in request form page
    When user changes status to "ROFR"
    And user clicks on "publish" button
    #############################All Request Dashboard####################################################
    When user clicks on "MY REQUEST DASHBOARD PAGE" button
    When user clicks on "All Requests" button
    Then verify all fields in the Telemundo News Crew form are matching with columns in All Request dashboard
      | Requesters   | Slug   | Submitted   | Prod Date   | Show Title   |
      | <Requesters> | <Slug> | CurrentDate | <Prod Date> | <Show Title> |
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "ROFR" status
    ##############################Dashboard Validation###########################################
    Then verify all fields in the Telemundo News Crew form are matching with "<Dashboard Name>" view columns in crew dashboard
      | Status | Color | Shoot Start Date   | Meet Time   | Shoot Status   | Slug   | Shoot Location    | Talent   | Show Title   | Requesters   | Producer   | Sr Producer   | Submitted   |
      | ROFR   | Blue  | <Shoot Start Date> | <Meet Time> | <Shoot Status> | <Slug> | <Shoot Location > | <Talent> | <Show Title> | <Requesters> | <Producer> | <Sr Producer> | CurrentDate |
    Then verify resource count and crew details in the Telemundo News Crew form are matching with "<Dashboard Name>" view columns in crew dashboard
    ##############################Email Validation###########################################
    Then validate recieved email notification for status "ROFR"
    Then validate "ToList" in the recieved email for "ROFR" status
    Then validate "CcList" in the recieved email for "ROFR" status
    ############################ Booked the form request ############################
    And user click edit link of the request in "fulfiller page"
    When user verifies logs are displaying in Log section
    Then user click "fulfillment" tab in request form page
    When user changes status to "BOOKED"
    And user clicks on "publish" button
    #############################All Request Dashboard####################################################
    When user clicks on "MY REQUEST DASHBOARD PAGE" button
    When user clicks on "All Requests" button
    Then verify all fields in the Telemundo News Crew form are matching with columns in All Request dashboard
      | Requesters   | Slug   | Submitted   | Prod Date   | Show Title   |
      | <Requesters> | <Slug> | CurrentDate | <Prod Date> | <Show Title> |
    And user opens fulfiller dashboard for "<Form Name>" form
    Then user clicks "Fulfilled" requests dropdown in Crew Dashboard
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "BOOKED" status
    ##############################Dashboard Validation###########################################
    Then verify all fields in the Telemundo News Crew form are matching with "<Dashboard Name>" view columns in crew dashboard
      | Status | Color | Shoot Start Date   | Meet Time   | Shoot Status   | Slug   | Shoot Location    | Talent   | Show Title   | Requesters   | Producer   | Sr Producer   | Submitted   |
      | BOOKED | Green | <Shoot Start Date> | <Meet Time> | <Shoot Status> | <Slug> | <Shoot Location > | <Talent> | <Show Title> | <Requesters> | <Producer> | <Sr Producer> | CurrentDate |
    Then verify resource count and crew details in the Telemundo News Crew form are matching with "<Dashboard Name>" view columns in crew dashboard
    ##############################Email Validation###########################################
    Then validate recieved email notification for status "BOOKED"
    Then validate "ToList" in the recieved email for "BOOKED" status
    Then validate "CcList" in the recieved email for "BOOKED" status
    And user logs out from application
    ############################ user logging in as producer and modifying the request  ############################
    Given user opens producer dashboard application
    And user logins with "producer" role
    When user searches request in my request page
    And user click edit link of the request in "My Request page"
    When user verifies logs are displaying in Log section
    When user enters shoot location Information in Telemundo Crew form
      | Shoot Location | Risk Assessment Category | Risk Assessment Type | Risk Arrangements | Risk Approver |
      | White House    |                          |                      |                   |               |
    When user clicks on "save" button
    #############################My Request Dashboard####################################################
    When user clicks on "MY REQUEST DASHBOARD PAGE" button
    When user clicks on "MY REQUESTS" button
    And verify submitted "<Form Name>" is present in my request page with "REVISED" status
    And verify "background color" of "REVISED" status is "Orange" in my request page
    When user searches request in my request page
    Then verify all fields in the Telemundo News Crew form are matching with columns in My Request dashboard
      | Slug   | Submitted   | Prod Date   | Show Title   |
      | <Slug> | CurrentDate | <Prod Date> | <Show Title> |
    #############################All Request Dashboard####################################################
    When user clicks on "All Requests" button
    Then verify all fields in the Telemundo News Crew form are matching with columns in All Request dashboard
      | Requesters   | Slug   | Submitted   | Prod Date   | Show Title   |
      | <Requesters> | <Slug> | CurrentDate | <Prod Date> | <Show Title> |
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "REVISED" status
    ##############################Dashboard Validation###########################################
    Then verify all fields in the Telemundo News Crew form are matching with "<Dashboard Name>" view columns in crew dashboard
      | Status  | Color  | Shoot Start Date   | Meet Time   | Shoot Status   | Slug   | Shoot Location    | Talent   | Show Title   | Requesters   | Producer   | Sr Producer   | Submitted   |
      | REVISED | Orange | <Shoot Start Date> | <Meet Time> | <Shoot Status> | <Slug> | <Shoot Location > | <Talent> | <Show Title> | <Requesters> | <Producer> | <Sr Producer> | CurrentDate |
    Then verify resource count and crew details in the Telemundo News Crew form are matching with "<Dashboard Name>" view columns in crew dashboard
    ##############################Email Validation###########################################
    Then validate recieved email notification for status "REVISED"
    Then validate "ToList" in the recieved email
    Then validate "CcList" in the recieved email
    When user clicks on "MY REQUEST DASHBOARD PAGE" button
    ############################ user submitting cancel request ############################
    When user clicks on "MY REQUESTS" button
    When user searches request in my request page
    And user click edit link of the request in "My Request page"
    When user verifies logs are displaying in Log section
    When user clicks on "cancel request" button
    And verify "cancel request" alert message
      | Cancel Request Alert Message                                                                                     |
      | Are you sure you want to cancel this request? All cancellations are pending until confirmed by fulfillment teams |
    And click "Yes" on "cancel request" alert message
    Then verify request is "Cancellation Requested" successfully
    #############################My Request Dashboard####################################################
    When user clicks on "MY REQUEST DASHBOARD PAGE" button
    When user clicks on "MY REQUESTS" button
    And verify submitted "<Form Name>" is present in my request page with "CONFIRM CANCELLATION" status
    And verify "background color" of "CONFIRM CANCELLATION" status is "Grey" in my request page
    When user searches request in my request page
    Then verify all fields in the Telemundo News Crew form are matching with columns in My Request dashboard
      | Slug   | Submitted   | Prod Date   | Show Title   |
      | <Slug> | CurrentDate | <Prod Date> | <Show Title> |
    #############################All Request Dashboard####################################################
    When user clicks on "All Requests" button
    Then verify all fields in the Telemundo News Crew form are matching with columns in All Request dashboard
      | Requesters   | Slug   | Submitted   | Prod Date   | Show Title   |
      | <Requesters> | <Slug> | CurrentDate | <Prod Date> | <Show Title> |
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "CONFIRM CANCELLATION" status
    ##############################Dashboard Validation###########################################
    Then verify all fields in the Telemundo News Crew form are matching with "<Dashboard Name>" view columns in crew dashboard
      | Status               | Color | Shoot Start Date   | Meet Time   | Shoot Status   | Slug   | Shoot Location    | Talent   | Show Title   | Requesters   | Producer   | Sr Producer   | Submitted   |
      | CONFIRM CANCELLATION | Grey  | <Shoot Start Date> | <Meet Time> | <Shoot Status> | <Slug> | <Shoot Location > | <Talent> | <Show Title> | <Requesters> | <Producer> | <Sr Producer> | CurrentDate |
    Then verify resource count and crew details in the Telemundo News Crew form are matching with "<Dashboard Name>" view columns in crew dashboard
    ##############################Email Validation###########################################
    Then validate recieved email notification for status "CONFIRM CANCELLATION"
    Then validate "ToList" in the recieved email for "CONFIRM CANCELLATION" status
    Then validate "CcList" in the recieved email for "CONFIRM CANCELLATION" status
    And user logs out from application
    ############################ user logging in as fulfiller and cancelled the form request ############################
    Given user opens producer dashboard application
    And user logins with "fulfiller" role
    And user opens fulfiller dashboard for "<Form Name>" form
    Then user clicks "All" requests dropdown in Crew Dashboard
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "CONFIRM CANCELLATION" status
    ##############################Dashboard Validation###########################################
    Then verify all fields in the Telemundo News Crew form are matching with "<Dashboard Name>" view columns in crew dashboard
      | Status               | Color | Shoot Start Date   | Meet Time   | Shoot Status   | Slug   | Shoot Location    | Talent   | Show Title   | Requesters   | Producer   | Sr Producer   | Submitted   |
      | CONFIRM CANCELLATION | Grey  | <Shoot Start Date> | <Meet Time> | <Shoot Status> | <Slug> | <Shoot Location > | <Talent> | <Show Title> | <Requesters> | <Producer> | <Sr Producer> | CurrentDate |
    ############################ user submitting cancel request ############################
    And user click edit link of the request in "fulfiller page"
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
    Then verify all fields in the Telemundo News Crew form are matching with columns in All Request dashboard
      | Requesters   | Slug   | Submitted   | Prod Date   | Show Title   |
      | <Requesters> | <Slug> | CurrentDate | <Prod Date> | <Show Title> |
    And user opens fulfiller dashboard for "<Form Name>" form
    Then user clicks "Cancelled" requests dropdown in Crew Dashboard
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "CANCELLED" status
    ##############################Dashboard Validation###########################################
    Then verify all fields in the Telemundo News Crew form are matching with "<Dashboard Name>" view columns in crew dashboard
      | Status    | Color | Shoot Start Date   | Meet Time   | Shoot Status   | Slug   | Shoot Location    | Talent   | Show Title   | Requesters   | Producer   | Sr Producer   | Submitted   |
      | CANCELLED | Black | <Shoot Start Date> | <Meet Time> | <Shoot Status> | <Slug> | <Shoot Location > | <Talent> | <Show Title> | <Requesters> | <Producer> | <Sr Producer> | CurrentDate |
    Then verify resource count and crew details in the Telemundo News Crew form are matching with "<Dashboard Name>" view columns in crew dashboard
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
    When user searches request in my request page
    And verify submitted "<Form Name>" is present in my request page with "CANCELLED" status
    And verify "background color" of "CANCELLED" status is "Black" in my request page
    When user searches request in my request page
    Then verify all fields in the Telemundo News Crew form are matching with columns in My Request dashboard
      | Slug   | Submitted   | Prod Date   | Show Title   |
      | <Slug> | CurrentDate | <Prod Date> | <Show Title> |
    #############################All Request Dashboard####################################################
    When user clicks on "All Requests" button
    Then verify all fields in the Telemundo News Crew form are matching with columns in All Request dashboard
      | Requesters   | Slug   | Submitted   | Prod Date   | Show Title   |
      | <Requesters> | <Slug> | CurrentDate | <Prod Date> | <Show Title> |
    And user opens fulfiller dashboard for "<Form Name>" form
    Then user clicks "Cancelled" requests dropdown in Crew Dashboard
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "CANCELLED" status
    ##############################Dashboard Validation###########################################
    Then verify all fields in the Telemundo News Crew form are matching with "<Dashboard Name>" view columns in crew dashboard
      | Status    | Color | Shoot Start Date   | Meet Time   | Shoot Status   | Slug   | Shoot Location    | Talent   | Show Title   | Requesters   | Producer   | Sr Producer   | Submitted   |
      | CANCELLED | Black | <Shoot Start Date> | <Meet Time> | <Shoot Status> | <Slug> | <Shoot Location > | <Talent> | <Show Title> | <Requesters> | <Producer> | <Sr Producer> | CurrentDate |
    Then verify resource count and crew details in the Telemundo News Crew form are matching with "<Dashboard Name>" view columns in crew dashboard

    Examples: #Resource Standard
      | Form Name      | Dashboard Name | Slug | Requesters    | Producer | Sr Producer  | Talent                                          | Show Title | Shoot Status | Shoot Location | Shoot Start Date | Shoot End Date | Meet Time     |
      | Telemundo News | Resource       | Wind | Solai-Sainath | Magesh   | Jeevanandham | test1/test1/test1/test1-test2/test2/test2/test2 | CNBC,News  | Tent         | Houston Bureau | CurrentDate+3    | CurrentDate+9  | CurrentTime+1 |
