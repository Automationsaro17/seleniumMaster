@ER_Standard @ProducerDashboard @Dashboard_Validation
Feature: Validate various scenarios related ECM request

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role

  @ER_Standard_Dashboard_Validation
  Scenario Outline: Verify user creating Edit request Standard flow of "<Form Name>" form and validating in dashboard
    ############################ user submitting the form request ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in Edit request form
      | Slug   | NCX Story Name | Division   | Additional Requesters | Is Producer Same as Requestor | Sr Producer   | Talent   |
      | <Slug> | Testing        | <Division> | <Requesters>          | <Producer>                    | <Sr Producer> | <Talent> |
    When user selects "Standard" edit type in Edit request form
    ##################Standard Edit Request######################################
    When user enters show info Information in Standard Edit request form
      | Show Unit   | Budget Code   | Air Date   | Air Time   |
      | <Show Unit> | <Budget Code> | <Air Date> | <Air Time> |
    When user enters Show Length in Standard Edit Request form
      | Length Of Show Minutes | Length Of Show Seconds |
      |                      5 |                     55 |
    When user enters Session details info in Standard Edit Request form
      | Location   | Edit Start Date   | ediusOrAvid | Requested Edit Session Start Time | Edit Time Needed Days | Edit Time Needed Hours | Edit Time Needed Minutes |
      | <Location> | <Edit Start Date> | EDIUS       | CurrentTime+5                     |                    10 |                     28 |                       44 |
    When user selects type of edit info in Standard Edit Request form
      | Type of Edit        | Type of Edit Quantity | How Many Versions |
      | Package,Promo,Fixes |                 3,2,5 |                 5 |
    When user selects  Additional Requirements info in Standard Edit Request form
      | Additional Requirements | is Crash Edit |
      | Music,Effects           | <Crash>       |
    When user selects Final Delivery in Standard Edit Request form
      | Final Delivery       |
      | Digital,Social,hello |
    When user selects Source Material info in Standard Edit Request form
      | Source Material |
      | WG01,WG06       |
    When user enters comments info in Standard Edit Request form
      | Comments                               |
      | Testing info Testing info Testing info |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "NEW" status
    Then verify all fields in the Edit Standard form are matching with columns in edit request dashboard
      | Status | Color | Slug   | Show Unit   | Division   | Location    | Edit Start Date   | Air Date   | Air Time   | Requesters   | Producer   | Sr Producer   | Crash   | Submitted   |
      | New    | Pink  | <Slug> | <Show Unit> | <Division> | <Location > | <Edit Start Date> | <Air Date> | <Air Time> | <Requesters> | <Producer> | <Sr Producer> | <Crash> | CurrentDate |

    Examples: 
      | Form Name     | Slug | Division    | Requesters         | Producer | Sr Producer  | Talent                                          | Show Unit  | Budget Code     | Air Date      | Air Time      | Location | Edit Start Date | Crash |
      | Standard Edit | Wind | Engineering | Solai-Jeevanandham | Magesh   | Jeevanandham | test1/test1/test1/test1-test2/test2/test2/test2 | CNBC,MSNBC | T-EDT22NNN.J047 | CurrentDate+3 | CurrentTime+3 | London   | CurrentDate+15  | No    |
      #| Standard Edit | Wind | Engineering | Solai-Jeevanandham | Magesh   | Jeevanandham | test1/test1/test1/test1-test2/test2/test2/test2 | CNBC,MSNBC | T-EDT22NNN.J047 | TBD      | FLEXIBLE | London   | CurrentDate+15  | Yes   |
