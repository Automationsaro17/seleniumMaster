@EditSelfReportingForm @ProducerDashboard @END_TO_END
Feature: Validate various scenarios related Edit Self Reporting request

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role

  @EditSelfReporting_e2e @SEVERITY=CRITICAL
  Scenario Outline: Verify user creating Edit Self Reporting request flow of "<Form Name>" and Fulfillment
    ############################ user submitting the form request ############################
    And user selects "<Form Name>" form
    And user enters General info in Edit Self Reporting request form
      | Show Unit   | Budget Code   |
      | <Show Unit> | <Budget Code> |
    And user enters Show info in Edit Self Reporting request form
      | Air Date   | Edit Date     |
      | <Air Date> | CurrentDate+7 |
    And user enters Edit Type info in Edit Self Reporting request form
      | Who Is Editing   | Type of Edit   | Type of Edit Quantity   |
      | <Who Is Editing> | <Type of Edit> | <Type of Edit Quantity> |
    And user enters Location info in Edit Self Reporting request form
      | Location | Room            |
      | London   | LONDON EDIT - 1 |
    And user enters comments info in Edit Self Reporting request form
      | Comments                               |
      | Testing info Testing info Testing info |
    And user clicks on "Submit" button
    Then user get the Edit Self Reporting Request ID with Request Type from Success message
    And user clicks on "ok" button
    #############################My Request Dashboard####################################################
    And verify submitted "<Form Name>" is present in my request page with "NEW" status
    And verify "background color" of "NEW" status is "Pink" in my request page
    When user searches request in my request page
    Then verify all fields in the Edit Self Reporting form are matching with columns in My Request dashboard
      | Slug | Submitted   | Prod Date  | Show Title  |
      |      | CurrentDate | <Air Date> | <Show Unit> |
    #############################All Request Dashboard####################################################
    When user clicks on "All Requests" button
    Then verify all fields in the Edit Self Reporting form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date  | Show Title  |
      | <Requesters> |      | CurrentDate | <Air Date> | <Show Unit> |
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "NEW" status
    And verify "background color" of "NEW" status is "Pink" in ECM fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the Edit Self Reporting form are matching with columns in edit self reporting dashboard
      | Status | Color | Show Unit                 | Air Date   | Who Is Editing   | Submitted   |
      | New    | Pink  | <Show Unit>,<Budget Code> | <Air Date> | <Who Is Editing> | CurrentDate |
    ############################ user adding notes as requester and validating notes ############################
    When user clicks on "MY REQUEST DASHBOARD PAGE" button
    When user searches request in my request page
    And user click edit link of the request in "My Request page"
    And user enters comments info in Edit Self Reporting request form
      | Comments                                                       |
      | Updated Testing info Updated Testing info Updated Testing info |
    And user clicks on "save" button
    And user clicks on "ok" button
    #############################My Request Dashboard####################################################
    When user clicks on "MY REQUEST DASHBOARD PAGE" button
    When user clicks on "MY REQUESTS" button
    #############################My Request Dashboard####################################################
    And verify submitted "<Form Name>" is present in my request page with "NEW" status
    And verify "background color" of "NEW" status is "Pink" in my request page
    When user searches request in my request page
    Then verify all fields in the Edit Self Reporting form are matching with columns in My Request dashboard
      | Slug | Submitted   | Prod Date  | Show Title  |
      |      | CurrentDate | <Air Date> | <Show Unit> |
    #############################All Request Dashboard####################################################
    When user clicks on "All Requests" button
    Then verify all fields in the Edit Self Reporting form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date  | Show Title  |
      | <Requesters> |      | CurrentDate | <Air Date> | <Show Unit> |
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "NEW" status
    And verify "background color" of "NEW" status is "Pink" in ECM fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the Edit Self Reporting form are matching with columns in edit self reporting dashboard
      | Status | Color | Show Unit                 | Air Date   | Who Is Editing   | Submitted   |
      | New    | Pink  | <Show Unit>,<Budget Code> | <Air Date> | <Who Is Editing> | CurrentDate |
    And user logs out from application
    ########################### user logging in as fulfiller and modifying the form request ############################
    Given user opens producer dashboard application
    And user logins with "fulfiller" role
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "NEW" status
    And verify "background color" of "NEW" status is "Pink" in ECM fullfiller dashboard
    ############################ Entered Into Strom the form request ############################
    And user click edit link of the request in "fulfiller page"
    When user changes status to "Entered Into Storm"
    When user clicks on "save" button
    When user clicks on "ok" button
    #############################All Request Dashboard####################################################
    When user clicks on "MY REQUEST DASHBOARD PAGE" button
    When user clicks on "All Requests" button
    Then verify all fields in the Edit Self Reporting form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date  | Show Title  |
      | <Requesters> |      | CurrentDate | <Air Date> | <Show Unit> |
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "COMPLETED" status
    And verify "background color" of "COMPLETED" status is "Green" in ECM fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the Edit Self Reporting form are matching with columns in edit self reporting dashboard
      | Status    | Color | Show Unit                 | Air Date   | Who Is Editing   | Submitted   |
      | COMPLETED | Green | <Show Unit>,<Budget Code> | <Air Date> | <Who Is Editing> | CurrentDate |
    And user logs out from application
    ############################ user logging in as producer and cancelled the request  ############################
    Given user opens producer dashboard application
    And user logins with "producer" role
    #############################My Request Dashboard####################################################
    When user clicks on "MY REQUEST DASHBOARD PAGE" button
    When user clicks on "MY REQUESTS" button
    And verify submitted "<Form Name>" is present in my request page with "COMPLETED" status
    And verify "background color" of "COMPLETED" status is "Green" in my request page
    When user searches request in my request page
    Then verify all fields in the Edit Self Reporting form are matching with columns in My Request dashboard
      | Slug | Submitted   | Prod Date  | Show Title  |
      |      | CurrentDate | <Air Date> | <Show Unit> |
    #############################All Request Dashboard####################################################
    When user clicks on "All Requests" button
    Then verify all fields in the Edit Self Reporting form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date  | Show Title  |
      | <Requesters> |      | CurrentDate | <Air Date> | <Show Unit> |
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "COMPLETED" status
    And verify "background color" of "COMPLETED" status is "Green" in ECM fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the Edit Self Reporting form are matching with columns in edit self reporting dashboard
      | Status    | Color | Show Unit                 | Air Date   | Who Is Editing   | Submitted   |
      | COMPLETED | Green | <Show Unit>,<Budget Code> | <Air Date> | <Who Is Editing> | CurrentDate |
    ############################ cancelled the request  #########################################################
    When user clicks on "MY REQUEST DASHBOARD PAGE" button
    When user clicks on "MY REQUESTS" button
    When user searches request in my request page
    Then user click on request ID link of the request
    When user clicks on "cancel request" button
    And verify "cancel request" alert message
      | Cancel Request Alert Message                 |
      | Are you sure you want to cancel this request |
    And click "yes" on "cancel request" alert message
    Then verify request is "Cancellation Confirmed" successfully
    When user clicks on "NBCU Logo" button
    #############################My Request Dashboard####################################################
    When user clicks on "MY REQUEST DASHBOARD PAGE" button
    When user clicks on "MY REQUESTS" button
    And verify submitted "<Form Name>" is present in my request page with "CANCELLED" status
    And verify "background color" of "CANCELLED" status is "Black" in my request page
    When user searches request in my request page
    Then verify all fields in the Edit Self Reporting form are matching with columns in My Request dashboard
      | Slug | Submitted   | Prod Date  | Show Title  |
      |      | CurrentDate | <Air Date> | <Show Unit> |
    #############################All Request Dashboard####################################################
    When user clicks on "All Requests" button
    Then verify all fields in the Edit Self Reporting form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date  | Show Title  |
      | <Requesters> |      | CurrentDate | <Air Date> | <Show Unit> |
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "CANCELLED" status
    And verify "background color" of "CANCELLED" status is "Black" in ECM fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the Edit Self Reporting form are matching with columns in edit self reporting dashboard
      | Status    | Color | Show Unit                 | Air Date   | Who Is Editing   | Submitted   |
      | CANCELLED | Black | <Show Unit>,<Budget Code> | <Air Date> | <Who Is Editing> | CurrentDate |
    And user logs out from application
    ############################ user logging in as fulfiller and verify cancelled form request ############################
    Given user opens producer dashboard application
    And user logins with "fulfiller" role
    #############################All Request Dashboard####################################################
    When user clicks on "MY REQUEST DASHBOARD PAGE" button
    When user clicks on "All Requests" button
    Then verify all fields in the Edit Self Reporting form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date  | Show Title  |
      | <Requesters> |      | CurrentDate | <Air Date> | <Show Unit> |
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "CANCELLED" status
    And verify "background color" of "CANCELLED" status is "Black" in ECM fullfiller dashboard
    ##############################Dashboard Validation###########################################
    Then verify all fields in the Edit Self Reporting form are matching with columns in edit self reporting dashboard
      | Status    | Color | Show Unit                 | Air Date   | Who Is Editing   | Submitted   |
      | CANCELLED | Black | <Show Unit>,<Budget Code> | <Air Date> | <Who Is Editing> | CurrentDate |
    And user logs out from application

    Examples: 
      | Form Name           | Requesters | Show Unit | Budget Code     | Air Date | Who Is Editing | Type of Edit              | Type of Edit Quantity |
      | Edit Self Reporting |            |           | T-EDT22NNN.J047 | TBD      | Producer       | Package,Promo,Fixes,Other |               2,4,6,8 |
