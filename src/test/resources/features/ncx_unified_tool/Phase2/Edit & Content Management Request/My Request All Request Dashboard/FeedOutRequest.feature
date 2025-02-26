@FeedOutRequest @ProducerDashboard @Dashboard_Validation
Feature: Validate various scenarios related ECM request

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role

  @FeedOut_MyRequest_Dashboard_AllRequest_Dashboard_Validation
  Scenario Outline: Verify user creating Feed Out request flow of "<Form Name>" form and validating in my request and all request dashboard
    ############################ user submitting the form request ###########################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in Feed Out Request form
      | Slug   | NCX Story Name | Division   | Additional Requesters | Additional Recipients           | Is Producer Same as Requestor | Sr Producer   | Talent   |
      | <Slug> |                | <Division> | <Requesters>          | sainath@gyk.com,sainath@msk.com | <Producer>                    | <Sr Producer> | <Talent> |
    When user enters show info Information in Feed Out Request form
      | Show Unit   | Budget Code   | Air Date   | Air Time      |
      | <Show Unit> | <Budget Code> | <Air Date> | CurrentTime+3 |
    When user enters Date Needed By and Time Needed By info in Feed Out Request form
      | Date Needed By   | Time Needed By   |
      | <Date Needed By> | <Time Needed By> |
    When user enters source info in Feed Out Request form
      | Source   | Source Slug   | Quantity   | Comments   |
      | <Source> | <Source Slug> | <Quantity> | <Comments> |
    When user selects Final Destination in Feed Out Request form
      | Final Destination   |
      | <Final Destination> |
    When user enters content description info in Feed Out Request form
      | Content Description   |
      | <Content Description> |
    When user enters comments info in Feed Out Request form
      | Comments                               |
      | Testing info Testing info Testing info |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    And verify submitted "<Form Name>" is present in my request page with "NEW" status
    And verify "background color" of "NEW" status is "Pink" in my request page
    When user searches request in my request page
    Then verify all fields in the Feed Out form are matching with columns in My Request dashboard
      | Slug   | Submitted   | Prod Date  | Show Title  |
      | <Slug> | CurrentDate | <Air Date> | <Show Unit> |
    When user clicks on "All Requests" button
    Then verify all fields in the Feed Out form are matching with columns in All Request dashboard
      | Requesters   | Slug   | Submitted   | Prod Date  | Show Title  |
      | <Requesters> | <Slug> | CurrentDate | <Air Date> | <Show Unit> |

    Examples: 
      | Form Name | Slug | Division    | Requesters         | Producer | Sr Producer  | Talent                                          | Show Unit  | Budget Code     | Air Date      | Date Needed By | Time Needed By | Final Destination                      | Source                    | Source Slug                         | Quantity | Comments                                                  | Content Description                                    |
      | Feed Out  | Wind | Engineering | Solai-Jeevanandham | Magesh   | Jeevanandham | test1/test1/test1/test1-test2/test2/test2/test2 | CNBC,MSNBC | T-EDT22NNN.J047 | CurrentDate+4 | CurrentDate+10 | CurrentTime+10 | WG01,WG06, 30 Rock, Other destinations | Tapes,CNBC- Stratus,Tapes | Test Slug 1,Test Slug 2,Test Slug 3 |   10,5,8 | Test Test Tapes, Test Test CNBC- Stratus, Test Test Tapes | Testing info Content Testing info Content Testing info |
