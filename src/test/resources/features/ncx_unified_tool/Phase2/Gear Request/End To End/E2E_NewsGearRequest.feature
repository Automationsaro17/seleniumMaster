@NewsGearRequest @ProducerDashboard @END_TO_END
Feature: Validate various scenarios related Gear request

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role

  @NewsGearRequest_e2e @SEVERITY=CRITICAL
  Scenario Outline: Verify end to end flow of "<Form Name>" form
    ############################ user submitting the form request ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in News Gear form
      | Slug | NCX Story Name | Division   | Additional Requesters | Is Producer Same as Requestor | Sr Producer  | Talent              |
      | Test |                | <Division> | <Requesters>          | yes                           | Jeevanandham | test/tesr/test/test |
    ############################ user selecting the form ############################
    When user enters Gear User Information in News Gear form
      | Gear User | Mobile Phone |
      |           |   9898989877 |
    When user enters show info Information in News Gear form
      | Show Unit   | Budget Code   | Segment Type |
      | <Show Unit> | <Budget Code> | Live         |
    When user enters Logistic details Information in News Gear form
      | Location   | Pick Up Date   | Pick Up Time   | Return Date   |
      | <Location> | <Pick Up Date> | <Pick Up Time> | <Return Date> |
    When user enters Add Gear details Information in News Gear form
      | Type of Gear   | How many | Comments                       |
      | Cameras,Tripod |      4,5 | Testing camera, Testing tripod |
    When user enters Usage deatils Information in News Gear form
      | Is this the gear being used as a hidden camera or microphone? | Is this gear being used outside the US? | Will any wireless audio equipment be used in any NBC studio location? | Is this gear being given to someone outside of NBC Universal to use? | description         |
      | yes                                                           | yes                                     | yes                                                                   | yes                                                                  | testing description |
    When user enters additional Information in News Gear form
      | additional info      |
      | Test additional info |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    #############################My Request Dashboard####################################################
    And verify submitted "<Form Name>" is present in my request page with "NEW" status
    And verify "background color" of "NEW" status is "Pink" in my request page
    When user searches request in my request page
    Then verify all fields in the News Gear form are matching with columns in My Request dashboard
      | Slug | Submitted   | Prod Date    | Show Title             |
      |      | CurrentDate | <Start Date> | <Show or Project Name> |
    #############################All Request Dashboard####################################################
    When user clicks on "All Requests" button
    Then verify all fields in the News Gear form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date    | Show Title             |
      | <Requesters> |      | CurrentDate | <Start Date> | <Show or Project Name> |
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "NEW" status
    And verify "background color" of "NEW" status is "Pink" in fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the News Gear form are matching with columns in gear dashboard
      | Status | Color | Submitted   | Requesters   | Location   | Pick Up Date   | Pick Up Time   | Return Date   | Show        |
      | New    | Pink  | CurrentDate | <Requesters> | <Location> | <Pick Up Date> | <Pick Up Time> | <Return Date> | <Show Unit> |
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
    Then verify all fields in the News Gear form are matching with columns in My Request dashboard
      | Slug | Submitted   | Prod Date    | Show Title             |
      |      | CurrentDate | <Start Date> | <Show or Project Name> |
    #############################All Request Dashboard####################################################
    When user clicks on "All Requests" button
    Then verify all fields in the News Gear form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date    | Show Title             |
      | <Requesters> |      | CurrentDate | <Start Date> | <Show or Project Name> |
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "MODIFIED" status
    And verify "background color" of "MODIFIED" status is "Orange" in fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the News Gear form are matching with columns in gear dashboard
      | Status   | Color  | Submitted   | Requesters   | Location   | Pick Up Date   | Pick Up Time   | Return Date   | Show        |
      | MODIFIED | Orange | CurrentDate | <Requesters> | <Location> | <Pick Up Date> | <Pick Up Time> | <Return Date> | <Show Unit> |
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
    When user enters show info Information in News Gear form
      | Show Unit | Budget Code | Segment Type |
      |           |             | Live         |
    When user enters Usage deatils Information in News Gear form
      | Is this the gear being used as a hidden camera or microphone? | Is this gear being used outside the US? | Will any wireless audio equipment be used in any NBC studio location? | Is this gear being given to someone outside of NBC Universal to use? | description         |
      | Yes                                                           | yes                                     |                                                                       |                                                                      | testing description |
    When user enters additional Information in News Gear form
      | additional info              |
      | updated Test additional info |
    When user click "Fulfillment" tab in request form page
    And user selects sub category type for requested gear in Equipment section
      | Type of Gear   | How many? | Sub Category                                       |
      | Cameras,Tripod |       4,5 | Canon 5Dm2, Canon 5Dm3, Sony FX3 , Sony FX6 - Null |
    ############################ user adding notes as fulfiller ############################
    #When user click "Notes" tab in request form page
    #And user enters add notes details in Notes section
    #| Notes Info       |
    #| testr  fulfiller |
    When user clicks on "save" button
    When user clicks on "ok" button
    #############################All Request Dashboard####################################################
    When user clicks on "MY REQUEST DASHBOARD PAGE" button
    When user clicks on "All Requests" button
    Then verify all fields in the News Gear form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date    | Show Title             |
      | <Requesters> |      | CurrentDate | <Start Date> | <Show or Project Name> |
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "MODIFIED" status
    And verify "background color" of "MODIFIED" status is "Orange" in fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the News Gear form are matching with columns in gear dashboard
      | Status   | Color  | Submitted   | Requesters   | Location   | Pick Up Date   | Pick Up Time   | Return Date   | Show        |
      | MODIFIED | Orange | CurrentDate | <Requesters> | <Location> | <Pick Up Date> | <Pick Up Time> | <Return Date> | <Show Unit> |
    ############################ Acknowledged the form request ############################
    And user click edit link of the request in "fulfiller page"
    When user verifies logs are displaying in Log section
    When user click "Fulfillment" tab in request form page
    When user changes status to "Acknowledged"
    When user clicks on "save" button
    And user clicks on "Ok" button
    #############################All Request Dashboard####################################################
    When user clicks on "MY REQUEST DASHBOARD PAGE" button
    When user clicks on "All Requests" button
    Then verify all fields in the News Gear form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date    | Show Title             |
      | <Requesters> |      | CurrentDate | <Start Date> | <Show or Project Name> |
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "ACKNOWLEDGED" status
    And verify "background color" of "ACKNOWLEDGED" status is "Blue" in fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the News Gear form are matching with columns in gear dashboard
      | Status       | Color | Submitted   | Requesters   | Location   | Pick Up Date   | Pick Up Time   | Return Date   | Show        |
      | ACKNOWLEDGED | Blue  | CurrentDate | <Requesters> | <Location> | <Pick Up Date> | <Pick Up Time> | <Return Date> | <Show Unit> |
    ##############################Email Validation###########################################
    Then validate recieved email notification for status "ACKNOWLEDGED"
    Then validate "ToList" in the recieved email for "ACKNOWLEDGED" status
    Then validate "CcList" in the recieved email for "ACKNOWLEDGED" status
    ############################ Ready For Pick Up the form request ############################
    And user click edit link of the request in "fulfiller page"
    When user verifies logs are displaying in Log section
    When user click "Fulfillment" tab in request form page
    When user changes status to "Ready For Pick Up"
    When user clicks on "save" button
    And user clicks on "Ok" button
    #############################All Request Dashboard####################################################
    When user clicks on "MY REQUEST DASHBOARD PAGE" button
    When user clicks on "All Requests" button
    Then verify all fields in the News Gear form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date    | Show Title             |
      | <Requesters> |      | CurrentDate | <Start Date> | <Show or Project Name> |
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "READY FOR PICK UP" status
    And verify "background color" of "READY FOR PICK UP" status is "Green" in fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the News Gear form are matching with columns in gear dashboard
      | Status            | Color | Submitted   | Requesters   | Location   | Pick Up Date   | Pick Up Time   | Return Date   | Show        |
      | READY FOR PICK UP | Green | CurrentDate | <Requesters> | <Location> | <Pick Up Date> | <Pick Up Time> | <Return Date> | <Show Unit> |
    ##############################Email Validation###########################################
    Then validate recieved email notification for status "READY FOR PICK UP"
    Then validate "ToList" in the recieved email for "READY FOR PICK UP" status
    Then validate "CcList" in the recieved email for "READY FOR PICK UP" status
    ############################ Complete the form request ############################
    And user click edit link of the request in "fulfiller page"
    When user verifies logs are displaying in Log section
    When user click "Fulfillment" tab in request form page
    When user changes status to "Complete"
    When user clicks on "save" button
    And user clicks on "Ok" button
    #############################All Request Dashboard####################################################
    When user clicks on "MY REQUEST DASHBOARD PAGE" button
    When user clicks on "All Requests" button
    Then verify all fields in the News Gear form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date    | Show Title             |
      | <Requesters> |      | CurrentDate | <Start Date> | <Show or Project Name> |
    And user opens fulfiller dashboard for "<Form Name>" form
    Then user clicks "Fulfilled" requests dropdown in Production Dashboard
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "COMPLETED" status
    And verify "background color" of "COMPLETED" status is "Green" in fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the News Gear form are matching with columns in gear dashboard
      | Status    | Color | Submitted   | Requesters   | Location   | Pick Up Date   | Pick Up Time   | Return Date   | Show        |
      | COMPLETED | Green | CurrentDate | <Requesters> | <Location> | <Pick Up Date> | <Pick Up Time> | <Return Date> | <Show Unit> |
    ##############################Email Validation###########################################
    Then validate recieved email notification for status "COMPLETED"
    Then validate "ToList" in the recieved email for "COMPLETED" status
    Then validate "CcList" in the recieved email for "COMPLETED" status
    ############################ Extended the form request ############################
    And user click edit link of the request in "fulfiller page"
    When user verifies logs are displaying in Log section
    When user enters Logistic details Information in News Gear form
      | Location | Pick Up Date | Pick Up Time | Return Date    |
      |          |              |              | CurrentDate+25 |
    When user clicks on "save" button
    When user clicks on "Ok" button
    #############################All Request Dashboard####################################################
    When user clicks on "MY REQUEST DASHBOARD PAGE" button
    When user clicks on "All Requests" button
    Then verify all fields in the News Gear form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date    | Show Title             |
      | <Requesters> |      | CurrentDate | <Start Date> | <Show or Project Name> |
    And user opens fulfiller dashboard for "<Form Name>" form
    Then user clicks "Extended" requests dropdown in Production Dashboard
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "EXTENDED" status
    And verify "background color" of "EXTENDED" status is "Orange" in fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the News Gear form are matching with columns in gear dashboard
      | Status   | Color  | Submitted   | Requesters   | Location   | Pick Up Date   | Pick Up Time   | Return Date   | Show        |
      | EXTENDED | Orange | CurrentDate | <Requesters> | <Location> | <Pick Up Date> | <Pick Up Time> | <Return Date> | <Show Unit> |
    ##############################Email Validation###########################################
    Then validate recieved email notification for status "EXTENDED"
    Then validate "ToList" in the recieved email for "EXTENDED" status
    Then validate "CcList" in the recieved email for "EXTENDED" status
    And user logs out from application
    ############################ user logging in as producer and modifying the request  ############################
    Given user opens producer dashboard application
    And user logins with "producer" role
    When user searches request in my request page
    And user click edit link of the request in "My Request page"
    When user verifies logs are displaying in Log section
    When user enters Logistic details Information in News Gear form
      | Location | Pick Up Date | Pick Up Time | Return Date    |
      |          |              |              | CurrentDate+29 |
    When user clicks on "save" button
    And user clicks on "Ok" button
    #############################My Request Dashboard####################################################
    When user clicks on "MY REQUEST DASHBOARD PAGE" button
    When user clicks on "MY REQUESTS" button
    And verify submitted "<Form Name>" is present in my request page with "MODIFIED" status
    And verify "background color" of "MODIFIED" status is "Orange" in my request page
    When user searches request in my request page
    Then verify all fields in the News Gear form are matching with columns in My Request dashboard
      | Slug | Submitted   | Prod Date    | Show Title             |
      |      | CurrentDate | <Start Date> | <Show or Project Name> |
    #############################All Request Dashboard####################################################
    When user clicks on "MY REQUEST DASHBOARD PAGE" button
    When user clicks on "All Requests" button
    Then verify all fields in the News Gear form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date    | Show Title             |
      | <Requesters> |      | CurrentDate | <Start Date> | <Show or Project Name> |
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "MODIFIED" status
    And verify "background color" of "MODIFIED" status is "Orange" in fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the News Gear form are matching with columns in gear dashboard
      | Status   | Color  | Submitted   | Requesters   | Location   | Pick Up Date   | Pick Up Time   | Return Date   | Show        |
      | MODIFIED | Orange | CurrentDate | <Requesters> | <Location> | <Pick Up Date> | <Pick Up Time> | <Return Date> | <Show Unit> |
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
    Then verify all fields in the News Gear form are matching with columns in My Request dashboard
      | Slug | Submitted   | Prod Date    | Show Title             |
      |      | CurrentDate | <Start Date> | <Show or Project Name> |
    #############################All Request Dashboard####################################################
    When user clicks on "All Requests" button
    Then verify all fields in the News Gear form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date    | Show Title             |
      | <Requesters> |      | CurrentDate | <Start Date> | <Show or Project Name> |
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "CONFIRM CANCELLATION" status
    And verify "background color" of "CONFIRM CANCELLATION" status is "Grey" in fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the News Gear form are matching with columns in gear dashboard
      | Status               | Color | Submitted   | Requesters   | Location   | Pick Up Date   | Pick Up Time   | Return Date   | Show        |
      | CONFIRM CANCELLATION | Grey  | CurrentDate | <Requesters> | <Location> | <Pick Up Date> | <Pick Up Time> | <Return Date> | <Show Unit> |
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
    ##############################Dashboard Validation###########################################
    Then verify all fields in the News Gear form are matching with columns in gear dashboard
      | Status               | Color | Submitted   | Requesters   | Location   | Pick Up Date   | Pick Up Time   | Return Date   | Show        |
      | CONFIRM CANCELLATION | Grey  | CurrentDate | <Requesters> | <Location> | <Pick Up Date> | <Pick Up Time> | <Return Date> | <Show Unit> |
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
    Then verify all fields in the News Gear form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date    | Show Title             |
      | <Requesters> |      | CurrentDate | <Start Date> | <Show or Project Name> |
    And user opens fulfiller dashboard for "<Form Name>" form
    Then user clicks "Fulfilled" requests dropdown in Production Dashboard
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "CANCELLED" status
    And verify "background color" of "CANCELLED" status is "Black" in fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the News Gear form are matching with columns in gear dashboard
      | Status    | Color | Submitted   | Requesters   | Location   | Pick Up Date   | Pick Up Time   | Return Date   | Show        |
      | CANCELLED | Black | CurrentDate | <Requesters> | <Location> | <Pick Up Date> | <Pick Up Time> | <Return Date> | <Show Unit> |
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
    Then verify all fields in the News Gear form are matching with columns in My Request dashboard
      | Slug | Submitted   | Prod Date    | Show Title             |
      |      | CurrentDate | <Start Date> | <Show or Project Name> |
    #############################All Request Dashboard####################################################
    When user clicks on "All Requests" button
    Then verify all fields in the News Gear form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date    | Show Title             |
      | <Requesters> |      | CurrentDate | <Start Date> | <Show or Project Name> |
    And user opens fulfiller dashboard for "<Form Name>" form
    Then user clicks "Fulfilled" requests dropdown in Production Dashboard
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "CANCELLED" status
    And verify "background color" of "CANCELLED" status is "Black" in fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the News Gear form are matching with columns in gear dashboard
      | Status    | Color | Submitted   | Requesters   | Location   | Pick Up Date   | Pick Up Time   | Return Date   | Show        |
      | CANCELLED | Black | CurrentDate | <Requesters> | <Location> | <Pick Up Date> | <Pick Up Time> | <Return Date> | <Show Unit> |

    Examples: 
      | Form Name | Division | Requesters    | Show Unit                            | Budget Code     | Location | Pick Up Date  | Pick Up Time  | Return Date   | Return Time   |
      | News Gear | Acorn    | Solai-Sainath | Capital Exchange Livestream,News Now | T-SHEP2021.J047 | LA       | CurrentDate+1 | CurrentTime+3 | CurrentDate+3 | CurrentTime+3 |
