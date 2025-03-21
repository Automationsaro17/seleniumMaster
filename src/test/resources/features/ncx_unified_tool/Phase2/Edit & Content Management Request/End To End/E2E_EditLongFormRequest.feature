@ER_LongForm @ProducerDashboard @END_TO_END
Feature: Validate various scenarios related ECM request

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role

  @ER_LongForm_e2e @SEVERITY=CRITICAL
  Scenario Outline: Verify user creating Edit request Long Form flow of "<Form Name>" and Fulfillment
    ############################ user submitting the form request ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in Edit request form
      | Slug   | NCX Story Name | Division   | Additional Requesters | Is Producer Same as Requestor | Sr Producer   | Talent   |
      | <Slug> | Testing        | <Division> | <Requesters>          | <Producer>                    | <Sr Producer> | <Talent> |
    When user selects "Long Form" edit type in Edit request form
    ##################LongForm Edit Request######################################
    When user enters show info Information in Long Edit request form
      | Show Unit   | Budget Code   | Air Date   | Air Time   | Date of First Screening |
      | <Show Unit> | <Budget Code> | <Air Date> | <Air Time> | CurrentDate+5           |
    When user enters Show Length in Long Edit Request form
      | Length Of Show No of Acts | Length Of Show Hours | Length Of Show Minutes | Length Of Show Seconds |
      |                         8 |                    4 |                      5 |                     55 |
    When user enters Session details info in Long Edit Request form
      | Location   | Edit Start Date   | ediusOrAvid | No Of Editors | Edit Time Needed Weeks | Edit Time Needed Days | Edit Time Needed Hours |
      | <Location> | <Edit Start Date> | EDIUS       |             5 |                     10 |                    28 |                     12 |
    When user selects Final Delivery in Long Edit Request form
      | Final Delivery       |
      | Digital,Social,hello |
    When user enters asst producer info in Long Edit Request form
      | Asst Producer same as Requester |
      | Yes                             |
    When user enters Additional Recipients info in Long Edit Request form
      | Additional Recipients           |
      | sainath@gyk.com,sainath@msk.com |
    When user enters comments info in Long Edit Request form
      | Comments                               |
      | Testing info Testing info Testing info |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    #############################My Request Dashboard####################################################
    And verify submitted "<Form Name>" is present in my request page with "NEW" status
    And verify "background color" of "NEW" status is "Pink" in my request page
    When user searches request in my request page
    Then verify all fields in the Long Edit form are matching with columns in My Request dashboard
      | Slug | Submitted   | Prod Date  | Show Title  |
      |      | CurrentDate | <Air Date> | <Show Unit> |
    #############################All Request Dashboard####################################################
    When user clicks on "All Requests" button
    Then verify all fields in the Long Edit form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date  | Show Title  |
      | <Requesters> |      | CurrentDate | <Air Date> | <Show Unit> |
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "NEW" status
    And verify "background color" of "NEW" status is "Pink" in ECM fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the Edit Long form are matching with columns in edit request dashboard
      | Status | Color | Slug   | Show Unit   | Division   | Location    | Edit Start Date   | Air Date   | Air Time   | Requesters   | Producer   | Sr Producer   | Submitted   |
      | New    | Pink  | <Slug> | <Show Unit> | <Division> | <Location > | <Edit Start Date> | <Air Date> | <Air Time> | <Requesters> | <Producer> | <Sr Producer> | CurrentDate |
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
    And verify submitted "<Form Name>" is present in my request page with "REVISED" status
    And verify "background color" of "REVISED" status is "Orange" in my request page
    When user searches request in my request page
    Then verify all fields in the Long Edit form are matching with columns in My Request dashboard
      | Slug | Submitted   | Prod Date  | Show Title  |
      |      | CurrentDate | <Air Date> | <Show Unit> |
    #############################All Request Dashboard####################################################
    When user clicks on "All Requests" button
    Then verify all fields in the Long Edit form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date  | Show Title  |
      | <Requesters> |      | CurrentDate | <Air Date> | <Show Unit> |
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "REVISED" status
    And verify "background color" of "REVISED" status is "Orange" in ECM fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the Edit Long form are matching with columns in edit request dashboard
      | Status  | Color  | Slug   | Show Unit   | Division   | Location    | Edit Start Date   | Air Date   | Air Time   | Requesters   | Producer   | Sr Producer   | Submitted   |
      | REVISED | Orange | <Slug> | <Show Unit> | <Division> | <Location > | <Edit Start Date> | <Air Date> | <Air Time> | <Requesters> | <Producer> | <Sr Producer> | CurrentDate |
    ##############################Email Validation###########################################
    Then validate recieved email notification for status "REVISED"
    Then validate "ToList" in the recieved email
    Then validate "CcList" in the recieved email
    And user logs out from application
    ########################### user logging in as fulfiller and modifying the form request ############################
    Given user opens producer dashboard application
    And user logins with "fulfiller" role
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "REVISED" status
    And verify "background color" of "REVISED" status is "Orange" in ECM fullfiller dashboard
    And user click edit link of the request in "fulfiller page"
    When user verifies logs are displaying in Log section
    When user click "Fulfillment" tab in request form page
    When user enters fulfillment comments in Long Edit Request form
      | Fulfillment Comments                                                    |
      | Fulfillment testr Fulfillment testr Fulfillment testr Fulfillment testr |
    And user enters Editor Controls info in Long Edit Request form
      | EditorName       | EditorPhoneNumber | Room   | AssignedFromDate | AssignedToDate | AssignedFromTime | AssignedToTime | Different Room |
      | Solai, Saravanan |        9090909090 | LONDON | CurrentDate+3    | CurrentDate+6  | CurrentTime+2    | CurrentTime+5  | LONDON         |
    ########################### user adding notes as fulfiller ############################
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
    Then verify all fields in the Long Edit form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date  | Show Title  |
      | <Requesters> |      | CurrentDate | <Air Date> | <Show Unit> |
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "REVISED" status
    And verify "background color" of "REVISED" status is "Orange" in ECM fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the Edit Long form are matching with columns in edit request dashboard
      | Status  | Color  | Slug   | Show Unit   | Division   | Location    | Edit Start Date   | Air Date   | Air Time   | Requesters   | Producer   | Sr Producer   | Submitted   |
      | REVISED | Orange | <Slug> | <Show Unit> | <Division> | <Location > | <Edit Start Date> | <Air Date> | <Air Time> | <Requesters> | <Producer> | <Sr Producer> | CurrentDate |
    ########################### Fulfill the form request ############################
    And user click edit link of the request in "fulfiller page"
    When user verifies logs are displaying in Log section
    When user click "Fulfillment" tab in request form page
    When user selects "Fulfilled" in Fulfillment Request Status
    When user clicks on "save" button
     And user clicks on "Ok" button
    #############################All Request Dashboard####################################################
    When user clicks on "MY REQUEST DASHBOARD PAGE" button
    When user clicks on "All Requests" button
    Then verify all fields in the Long Edit form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date  | Show Title  |
      | <Requesters> |      | CurrentDate | <Air Date> | <Show Unit> |
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "FULFILLED" status
    And verify "background color" of "FULFILLED" status is "Green" in ECM fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the Edit Long form are matching with columns in edit request dashboard
      | Status    | Color | Slug   | Show Unit   | Division   | Location    | Edit Start Date   | Air Date   | Air Time   | Requesters   | Producer   | Sr Producer   | Submitted   |
      | FULFILLED | Green | <Slug> | <Show Unit> | <Division> | <Location > | <Edit Start Date> | <Air Date> | <Air Time> | <Requesters> | <Producer> | <Sr Producer> | CurrentDate |
    ##############################Email Validation###########################################
    Then validate recieved email notification for status "FULFILLED"
    Then validate "ToList" in the recieved email for "FULFILLED" status
    Then validate "CcList" in the recieved email for "FULFILLED" status
    And user logs out from application
    ########################### user logging in as producer and modifying the request  ############################
    Given user opens producer dashboard application
    And user logins with "producer" role
    When user searches request in my request page
    And user click edit link of the request in "My Request page"
    When user verifies logs are displaying in Log section
    When user enters comments info in Long Edit Request form
      | Comments                                                       |
      | Updated Testing info Updated Testing info Updated Testing info |
    When user clicks on "save" button
    And user clicks on "ok" button
    #############################My Request Dashboard####################################################
    When user clicks on "MY REQUEST DASHBOARD PAGE" button
    When user clicks on "MY REQUESTS" button
    And verify submitted "<Form Name>" is present in my request page with "REVISED" status
    And verify "background color" of "REVISED" status is "Orange" in my request page
    When user searches request in my request page
    Then verify all fields in the Long Edit form are matching with columns in My Request dashboard
      | Slug | Submitted   | Prod Date  | Show Title  |
      |      | CurrentDate | <Air Date> | <Show Unit> |
    #############################All Request Dashboard####################################################
    When user clicks on "All Requests" button
    Then verify all fields in the Long Edit form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date  | Show Title  |
      | <Requesters> |      | CurrentDate | <Air Date> | <Show Unit> |
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "REVISED" status
    And verify "background color" of "REVISED" status is "Orange" in ECM fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the Edit Long form are matching with columns in edit request dashboard
      | Status  | Color  | Slug   | Show Unit   | Division   | Location    | Edit Start Date   | Air Date   | Air Time   | Requesters   | Producer   | Sr Producer   | Submitted   |
      | REVISED | Orange | <Slug> | <Show Unit> | <Division> | <Location > | <Edit Start Date> | <Air Date> | <Air Time> | <Requesters> | <Producer> | <Sr Producer> | CurrentDate |
    ##############################Email Validation###########################################
    Then validate recieved email notification for status "REVISED"
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
    When user clicks on "MY REQUEST DASHBOARD PAGE" button
    When user clicks on "MY REQUESTS" button
    And verify submitted "<Form Name>" is present in my request page with "CONFIRM CANCELLATION" status
    And verify "background color" of "CONFIRM CANCELLATION" status is "Grey" in my request page
    When user searches request in my request page
    Then verify all fields in the Long Edit form are matching with columns in My Request dashboard
      | Slug | Submitted   | Prod Date  | Show Title  |
      |      | CurrentDate | <Air Date> | <Show Unit> |
    #############################All Request Dashboard####################################################
    When user clicks on "All Requests" button
    Then verify all fields in the Long Edit form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date  | Show Title  |
      | <Requesters> |      | CurrentDate | <Air Date> | <Show Unit> |
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "CONFIRM CANCELLATION" status
    And verify "background color" of "CONFIRM CANCELLATION" status is "Grey" in ECM fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the Edit Long form are matching with columns in edit request dashboard
      | Status               | Color | Slug   | Show Unit   | Division   | Location    | Edit Start Date   | Air Date   | Air Time   | Requesters   | Producer   | Sr Producer   | Submitted   |
      | CONFIRM CANCELLATION | Grey  | <Slug> | <Show Unit> | <Division> | <Location > | <Edit Start Date> | <Air Date> | <Air Time> | <Requesters> | <Producer> | <Sr Producer> | CurrentDate |
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
    And verify "background color" of "CONFIRM CANCELLATION" status is "Grey" in ECM fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the Edit Long form are matching with columns in edit request dashboard
      | Status               | Color | Slug   | Show Unit   | Division   | Location    | Edit Start Date   | Air Date   | Air Time   | Requesters   | Producer   | Sr Producer   | Submitted   |
      | CONFIRM CANCELLATION | Grey  | <Slug> | <Show Unit> | <Division> | <Location > | <Edit Start Date> | <Air Date> | <Air Time> | <Requesters> | <Producer> | <Sr Producer> | CurrentDate |
    Then user click on request ID link of the request
    When user clicks on "confirm cancellation" button
    And verify "confirm cancellation" alert message
      | Confirm Cancellation Alert Message           |
      | Are you sure you want to cancel this request |
    And click "yes" on "confirm cancellation" alert message
    Then verify request is "Cancelled" successfully
    #############################All Request Dashboard####################################################
    When user clicks on "MY REQUEST DASHBOARD PAGE" button
    When user clicks on "All Requests" button
    Then verify all fields in the Long Edit form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date  | Show Title  |
      | <Requesters> |      | CurrentDate | <Air Date> | <Show Unit> |
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "CANCELLED" status
    And verify "background color" of "CANCELLED" status is "Black" in ECM fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the Edit Long form are matching with columns in edit request dashboard
      | Status    | Color | Slug   | Show Unit   | Division   | Location    | Edit Start Date   | Air Date   | Air Time   | Requesters   | Producer   | Sr Producer   | Submitted   |
      | CANCELLED | Black | <Slug> | <Show Unit> | <Division> | <Location > | <Edit Start Date> | <Air Date> | <Air Time> | <Requesters> | <Producer> | <Sr Producer> | CurrentDate |
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
    And verify submitted "<Form Name>" is present in my request page with "CANCELLED" status
    And verify "background color" of "CANCELLED" status is "Black" in my request page
    When user searches request in my request page
    Then verify all fields in the Long Edit form are matching with columns in My Request dashboard
      | Slug | Submitted   | Prod Date  | Show Title  |
      |      | CurrentDate | <Air Date> | <Show Unit> |
    #############################All Request Dashboard####################################################
    When user clicks on "All Requests" button
    Then verify all fields in the Long Edit form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date  | Show Title  |
      | <Requesters> |      | CurrentDate | <Air Date> | <Show Unit> |
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "CANCELLED" status
    And verify "background color" of "CANCELLED" status is "Black" in ECM fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the Edit Long form are matching with columns in edit request dashboard
      | Status    | Color | Slug   | Show Unit   | Division   | Location    | Edit Start Date   | Air Date   | Air Time   | Requesters   | Producer   | Sr Producer   | Submitted   |
      | CANCELLED | Black | <Slug> | <Show Unit> | <Division> | <Location > | <Edit Start Date> | <Air Date> | <Air Time> | <Requesters> | <Producer> | <Sr Producer> | CurrentDate |
    And user logs out from application

    Examples: 
      | Form Name | Slug | Division    | Requesters    | Producer | Sr Producer  | Talent                                          | Show Unit  | Budget Code     | Air Date | Air Time | Location | Edit Start Date |
      | Long Edit | Wind | Engineering | Solai-Sainath | Magesh   | Jeevanandham | test1/test1/test1/test1-test2/test2/test2/test2 | CNBC,MSNBC | T-EDT22NNN.J047 | TBD      | FLEXIBLE | London   | CurrentDate+15  |
