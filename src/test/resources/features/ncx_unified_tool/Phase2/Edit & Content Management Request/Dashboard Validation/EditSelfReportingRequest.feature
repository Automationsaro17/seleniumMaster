@EditSelfReportingForm @ProducerDashboard @Dashboard_Validation
Feature: Validate various scenarios related Edit Self Reporting request

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role

  @EditSelfReporting_Dashboard_Validation
  Scenario Outline: Verify user creating Edit Self Reporting request flow of "<Form Name>" and validating in dashboard
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
    ########################################################
    And user clicks on "Submit" button
    Then user get the Edit Self Reporting Request ID with Request Type from Success message
    And user clicks on "ok" button
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "NEW" status
    Then verify all fields in the Edit Self Reporting form are matching with columns in edit self reporting dashboard
      | Status | Color | Show Unit                 | Air Date   | Who Is Editing   | Submitted   |
      | New    | Pink  | <Show Unit>,<Budget Code> | <Air Date> | <Who Is Editing> | CurrentDate |

    Examples: 
      | Form Name           | Show Unit | Budget Code     | Air Date | Who Is Editing | Type of Edit              | Type of Edit Quantity |
      | Edit Self Reporting |           | T-EDT22NNN.J047 | TBD      | Producer       | Package,Promo,Fixes,Other |               2,4,6,8 |
