@FileIngestRequest @ProducerDashboard @END_TO_END
Feature: Validate various scenarios related ECM request

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role

  @FileIngest_e2e @SEVERITY=CRITICAL
  Scenario Outline: Verify user creating File Ingest request flow of "<Form Name>" form and Fulfillment
    ############################ user submitting the form request ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in File Ingest Request form
      | Slug   | NCX Story Name | Division   | Additional Requesters | Additional Recipients           | Is Producer Same as Requestor | Sr Producer   | Talent   |
      | <Slug> |                | <Division> | <Requesters>          | sainath@gyk.com,sainath@msk.com | <Producer>                    | <Sr Producer> | <Talent> |
    When user enters show info Information in File Ingest Request form
      | Show Unit   | Budget Code   | Air Date      | Air Time      |
      | <Show Unit> | <Budget Code> | CurrentDate+3 | CurrentTime+3 |
    When user enters Date Needed By and Time Needed By info in File Ingest Request form
      | Date Needed By   | Time Needed By   |
      | <Date Needed By> | <Time Needed By> |
    When user enters source info in File Ingest Request form
      | Source   | Quantity   | Comments   | Camera   |
      | <Source> | <Quantity> | <Comments> | <Camera> |
    When user selects Final Destination in File Ingest Request form
      | Final Destination   |
      | <Final Destination> |
    When user enters content description info in File Ingest Request form
      | Content Description   |
      | <Content Description> |
    When user enters comments info in File Ingest Request form
      | Comments                               |
      | Testing info Testing info Testing info |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    #############################My Request Dashboard####################################################
    And verify submitted "<Form Name>" is present in my request page with "NEW" status
    And verify "background color" of "NEW" status is "Pink" in my request page
    When user searches request in my request page
    Then verify all fields in the File Ingest form are matching with columns in My Request dashboard
      | Slug | Submitted   | Prod Date  | Show Title  |
      |      | CurrentDate | <Air Date> | <Show Unit> |
    #############################All Request Dashboard####################################################
    When user clicks on "All Requests" button
    Then verify all fields in the File Ingest form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date  | Show Title  |
      | <Requesters> |      | CurrentDate | <Air Date> | <Show Unit> |
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "NEW" status
    And verify "background color" of "NEW" status is "Pink" in ECM fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the File Ingest form are matching with columns in content management dashboard
      | Status | Color | Slug   | Show Unit   | Division   | Date Needed By   | Time Needed By   | Final Destination   | Requesters   | Producer   | Sr Producer   | Source   | Camera   | Content Description   | Submitted   |
      | New    | Pink  | <Slug> | <Show Unit> | <Division> | <Date Needed By> | <Time Needed By> | <Final Destination> | <Requesters> | <Producer> | <Sr Producer> | <Source> | <Camera> | <Content Description> | CurrentDate |
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
    Then verify all fields in the File Ingest form are matching with columns in My Request dashboard
      | Slug | Submitted   | Prod Date  | Show Title  |
      |      | CurrentDate | <Air Date> | <Show Unit> |
    #############################All Request Dashboard####################################################
    When user clicks on "All Requests" button
    Then verify all fields in the File Ingest form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date  | Show Title  |
      | <Requesters> |      | CurrentDate | <Air Date> | <Show Unit> |
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "REVISED" status
    And verify "background color" of "REVISED" status is "Orange" in ECM fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the File Ingest form are matching with columns in content management dashboard
      | Status  | Color  | Slug   | Show Unit   | Division   | Date Needed By   | Time Needed By   | Final Destination   | Requesters   | Producer   | Sr Producer   | Source   | Camera   | Content Description   | Submitted   |
      | REVISED | Orange | <Slug> | <Show Unit> | <Division> | <Date Needed By> | <Time Needed By> | <Final Destination> | <Requesters> | <Producer> | <Sr Producer> | <Source> | <Camera> | <Content Description> | CurrentDate |
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
    And user enters fulfillment info in File Ingest Fulfillment section
      | Method Of Ingest | Destinations | File Format | Gig Size | Clip Count | Folder Format | Bin Name        | Media ID | Assistant Editor Assigned | Cnbc Stratus Ingest | Transcoding Needed | Transcode Complete | Cnbc Avid Ingest | Device Timer Hours | Device Timer Minutes | Device Timer Seconds | Fulfiller Comments                                                      |
      | RMI, AMA, Import | Nimbus       | .avi        |        5 |          4 | DCIM          | Testet Bin Name |   324235 | Jeevanandham              | Yes                 | Yes                | Yes                | Yes              |                  8 |                   30 |                   57 | Fulfillment testr Fulfillment testr Fulfillment testr Fulfillment testr |
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
    Then verify all fields in the File Ingest form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date  | Show Title  |
      | <Requesters> |      | CurrentDate | <Air Date> | <Show Unit> |
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "REVISED" status
    And verify "background color" of "REVISED" status is "Orange" in ECM fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the File Ingest form are matching with columns in content management dashboard
      | Status  | Color  | Slug   | Show Unit   | Division   | Date Needed By   | Time Needed By   | Final Destination   | Requesters   | Producer   | Sr Producer   | Source   | Camera   | Content Description   | Submitted   |
      | REVISED | Orange | <Slug> | <Show Unit> | <Division> | <Date Needed By> | <Time Needed By> | <Final Destination> | <Requesters> | <Producer> | <Sr Producer> | <Source> | <Camera> | <Content Description> | CurrentDate |
    ############################ change status to Inprogress in the form request ############################
    And user click edit link of the request in "fulfiller page"
    When user verifies logs are displaying in Log section
    When user click "Fulfillment" tab in request form page
    When user selects "In Progress" in Fulfillment Request Status
    When user clicks on "save" button
    And user clicks on "Ok" button
    #############################All Request Dashboard####################################################
    When user clicks on "MY REQUEST DASHBOARD PAGE" button
    When user clicks on "All Requests" button
    Then verify all fields in the File Ingest form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date  | Show Title  |
      | <Requesters> |      | CurrentDate | <Air Date> | <Show Unit> |
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "IN PROGRESS" status
    And verify "background color" of "IN PROGRESS" status is "Blue" in ECM fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the File Ingest form are matching with columns in content management dashboard
      | Status      | Color | Slug   | Show Unit   | Division   | Date Needed By   | Time Needed By   | Final Destination   | Requesters   | Producer   | Sr Producer   | Source   | Camera   | Content Description   | Submitted   |
      | IN PROGRESS | Blue  | <Slug> | <Show Unit> | <Division> | <Date Needed By> | <Time Needed By> | <Final Destination> | <Requesters> | <Producer> | <Sr Producer> | <Source> | <Camera> | <Content Description> | CurrentDate |
    ##############################Email Validation###########################################
    Then validate recieved email notification for status "IN PROGRESS"
    Then validate "ToList" in the recieved email for "IN PROGRESS" status
    Then validate "CcList" in the recieved email for "IN PROGRESS" status
    ########################### Fulfill the form request ############################
    And user click edit link of the request in "fulfiller page"
    When user verifies logs are displaying in Log section
    When user click "Fulfillment" tab in request form page
    When user selects "Completed" in Fulfillment Request Status
    When user clicks on "save" button
    And user clicks on "Ok" button
    #############################All Request Dashboard####################################################
    When user clicks on "MY REQUEST DASHBOARD PAGE" button
    When user clicks on "All Requests" button
    Then verify all fields in the File Ingest form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date  | Show Title  |
      | <Requesters> |      | CurrentDate | <Air Date> | <Show Unit> |
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "COMPLETED" status
    And verify "background color" of "COMPLETED" status is "Green" in ECM fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the File Ingest form are matching with columns in content management dashboard
      | Status    | Color | Slug   | Show Unit   | Division   | Date Needed By   | Time Needed By   | Final Destination   | Requesters   | Producer   | Sr Producer   | Source   | Camera   | Content Description   | Submitted   |
      | COMPLETED | Green | <Slug> | <Show Unit> | <Division> | <Date Needed By> | <Time Needed By> | <Final Destination> | <Requesters> | <Producer> | <Sr Producer> | <Source> | <Camera> | <Content Description> | CurrentDate |
    ##############################Email Validation###########################################
    Then validate recieved email notification for status "COMPLETED"
    Then validate "ToList" in the recieved email for "COMPLETED" status
    Then validate "CcList" in the recieved email for "COMPLETED" status
    And user logs out from application
    ########################### user logging in as producer and modifying the request  ############################
    Given user opens producer dashboard application
    And user logins with "producer" role
    When user searches request in my request page
    And user click edit link of the request in "My Request page"
    When user verifies logs are displaying in Log section
    When user enters comments info in File Ingest Request form
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
    Then verify all fields in the File Ingest form are matching with columns in My Request dashboard
      | Slug | Submitted   | Prod Date  | Show Title  |
      |      | CurrentDate | <Air Date> | <Show Unit> |
    #############################All Request Dashboard####################################################
    When user clicks on "All Requests" button
    Then verify all fields in the File Ingest form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date  | Show Title  |
      | <Requesters> |      | CurrentDate | <Air Date> | <Show Unit> |
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "REVISED" status
    And verify "background color" of "REVISED" status is "Orange" in ECM fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the File Ingest form are matching with columns in content management dashboard
      | Status  | Color  | Slug   | Show Unit   | Division   | Date Needed By   | Time Needed By   | Final Destination   | Requesters   | Producer   | Sr Producer   | Source   | Camera   | Content Description   | Submitted   |
      | REVISED | Orange | <Slug> | <Show Unit> | <Division> | <Date Needed By> | <Time Needed By> | <Final Destination> | <Requesters> | <Producer> | <Sr Producer> | <Source> | <Camera> | <Content Description> | CurrentDate |
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
    Then verify all fields in the File Ingest form are matching with columns in My Request dashboard
      | Slug | Submitted   | Prod Date  | Show Title  |
      |      | CurrentDate | <Air Date> | <Show Unit> |
    #############################All Request Dashboard####################################################
    When user clicks on "All Requests" button
    Then verify all fields in the File Ingest form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date  | Show Title  |
      | <Requesters> |      | CurrentDate | <Air Date> | <Show Unit> |
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "CONFIRM CANCELLATION" status
    And verify "background color" of "CONFIRM CANCELLATION" status is "Grey" in ECM fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the File Ingest form are matching with columns in content management dashboard
      | Status               | Color | Slug   | Show Unit   | Division   | Date Needed By   | Time Needed By   | Final Destination   | Requesters   | Producer   | Sr Producer   | Source   | Camera   | Content Description   | Submitted   |
      | CONFIRM CANCELLATION | Grey  | <Slug> | <Show Unit> | <Division> | <Date Needed By> | <Time Needed By> | <Final Destination> | <Requesters> | <Producer> | <Sr Producer> | <Source> | <Camera> | <Content Description> | CurrentDate |
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
    Then verify all fields in the File Ingest form are matching with columns in content management dashboard
      | Status               | Color | Slug   | Show Unit   | Division   | Date Needed By   | Time Needed By   | Final Destination   | Requesters   | Producer   | Sr Producer   | Source   | Camera   | Content Description   | Submitted   |
      | CONFIRM CANCELLATION | Grey  | <Slug> | <Show Unit> | <Division> | <Date Needed By> | <Time Needed By> | <Final Destination> | <Requesters> | <Producer> | <Sr Producer> | <Source> | <Camera> | <Content Description> | CurrentDate |
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
    Then verify all fields in the File Ingest form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date  | Show Title  |
      | <Requesters> |      | CurrentDate | <Air Date> | <Show Unit> |
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "CANCELLED" status
    And verify "background color" of "CANCELLED" status is "Black" in ECM fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the File Ingest form are matching with columns in content management dashboard
      | Status    | Color | Slug   | Show Unit   | Division   | Date Needed By   | Time Needed By   | Final Destination   | Requesters   | Producer   | Sr Producer   | Source   | Camera   | Content Description   | Submitted   |
      | CANCELLED | Black | <Slug> | <Show Unit> | <Division> | <Date Needed By> | <Time Needed By> | <Final Destination> | <Requesters> | <Producer> | <Sr Producer> | <Source> | <Camera> | <Content Description> | CurrentDate |
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
    Then verify all fields in the File Ingest form are matching with columns in My Request dashboard
      | Slug | Submitted   | Prod Date  | Show Title  |
      |      | CurrentDate | <Air Date> | <Show Unit> |
    #############################All Request Dashboard####################################################
    When user clicks on "All Requests" button
    Then verify all fields in the File Ingest form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date  | Show Title  |
      | <Requesters> |      | CurrentDate | <Air Date> | <Show Unit> |
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "CANCELLED" status
    And verify "background color" of "CANCELLED" status is "Black" in ECM fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the File Ingest form are matching with columns in content management dashboard
      | Status    | Color | Slug   | Show Unit   | Division   | Date Needed By   | Time Needed By   | Final Destination   | Requesters   | Producer   | Sr Producer   | Source   | Camera   | Content Description   | Submitted   |
      | CANCELLED | Black | <Slug> | <Show Unit> | <Division> | <Date Needed By> | <Time Needed By> | <Final Destination> | <Requesters> | <Producer> | <Sr Producer> | <Source> | <Camera> | <Content Description> | CurrentDate |
    And user logs out from application

    Examples: #CNBC- Stratus
      | Form Name   | Slug | Division    | Requesters         | Producer | Sr Producer  | Talent                                          | Show Unit  | Budget Code     | Date Needed By | Time Needed By | Final Destination                                           | Source      | Quantity | Comments                                    | Camera               | Content Description                                    |
      | File Ingest | Wind | Engineering | Solai-Sainath | Magesh   | Jeevanandham | test1/test1/test1/test1-test2/test2/test2/test2 | CNBC,MSNBC | T-EDT22NNN.J047 | CurrentDate+10 | CurrentTime+10 | WG01,WG06,Nimbus,DC Network News,CNBC - AVID,CNBC - Stratus | Cfast,P2,SD |   10,5,8 | Test Test Cfast, Test Test P2, Test Test SD | Canon R6, Canon C300 | Testing info Content Testing info Content Testing info |
