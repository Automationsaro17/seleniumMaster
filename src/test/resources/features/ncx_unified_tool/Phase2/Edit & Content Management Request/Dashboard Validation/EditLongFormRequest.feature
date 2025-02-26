@ER_LongForm @ProducerDashboard @Dashboard_Validation
Feature: Validate various scenarios related ECM request

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role

  @ER_LongForm_Dashboard_Validation
  Scenario Outline: Verify user creating Edit request Long Form flow of "<Form Name>" and validating in dashboard
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
    ########################################################
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "NEW" status
    Then verify all fields in the Edit Long form are matching with columns in edit request dashboard
      | Status | Color | Slug   | Show Unit   | Division   | Location    | Edit Start Date   | Air Date   | Air Time   | Requesters   | Producer   | Sr Producer   | Submitted   |
      | New    | Pink  | <Slug> | <Show Unit> | <Division> | <Location > | <Edit Start Date> | <Air Date> | <Air Time> | <Requesters> | <Producer> | <Sr Producer> | CurrentDate |

    Examples: 
      | Form Name | Slug | Division    | Requesters         | Producer | Sr Producer  | Talent                                          | Show Unit  | Budget Code     | Air Date | Air Time | Location | Edit Start Date |
      # | Long Edit | Wind | Engineering | Solai-Jeevanandham | Magesh   | Jeevanandham | test1/test1/test1/test1-test2/test2/test2/test2 | CNBC,MSNBC | T-EDT22NNN.J047 | CurrentDate+3 | CurrentTime+3 | London   | CurrentDate+15  |
      | Long Edit | Wind | Engineering | Solai-Jeevanandham | Magesh   | Jeevanandham | test1/test1/test1/test1-test2/test2/test2/test2 | CNBC,MSNBC | T-EDT22NNN.J047 | TBD      | FLEXIBLE | London   | CurrentDate+15  |
