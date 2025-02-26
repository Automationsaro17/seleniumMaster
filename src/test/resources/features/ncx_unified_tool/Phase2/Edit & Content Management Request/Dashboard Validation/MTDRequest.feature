@MTD @ProducerDashboard @Dashboard_Validation
Feature: Validate various scenarios related ECM request

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role

  @MTD_Dashboard_Validation
  Scenario Outline: Verify user creating MTD requests flow of "<Form Name>" form and validating in dashboard
    ############################ user submitting the form request ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in MTD Request form
      | Slug   | NCX Story Name | Division   | Additional Requesters | Is Producer Same as Requestor | Sr Producer   | Talent   |
      | <Slug> |                | <Division> | <Requesters>          | <Producer>                    | <Sr Producer> | <Talent> |
    When user enters show info Information in MTD Request form
      | Show Unit   | Budget Code   | Air Date      | Air Time      |
      | <Show Unit> | <Budget Code> | CurrentDate+3 | CurrentTime+3 |
    When user enters Date Needed By and Time Needed By info in MTD Request form
      | Date Needed By   | Time Needed By   |
      | <Date Needed By> | <Time Needed By> |
    When user enters source info in MTD Request form
      | Source   | Source Details   | Time Codes   | Camera   |
      | <Source> | <Source Details> | <Time Codes> | <Camera> |
    When user selects Final Destination in MTD Request form
      | Destination   | Quantity   | Details   |
      | <Destination> | <Quantity> | <Details> |
    When user enters Instructions info in MTD Request form
      | Instructions                                                    |
      | Instructions Merging Together Clips Without Retaining Time Code |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "NEW" status
    Then verify all fields in the MTD form are matching with columns in content management dashboard
      | Status | Color | Slug   | Show Unit   | Division   | Date Needed By   | Time Needed By   | Destination   | Requesters   | Producer   | Sr Producer   | Source   | Camera   | Submitted   |
      | New    | Pink  | <Slug> | <Show Unit> | <Division> | <Date Needed By> | <Time Needed By> | <Destination> | <Requesters> | <Producer> | <Sr Producer> | <Source> | <Camera> | CurrentDate |

    Examples: #CNBC- Stratus
      | Form Name                                      | Slug | Division    | Requesters         | Producer | Sr Producer  | Talent                                          | Show Unit  | Budget Code     | Date Needed By | Time Needed By | Source          | Source Details                              | Time Codes                                                                           | Camera                    | Destination               | Quantity | Details                                            |
      | Media Transcoding / Transferring / Duplication | Wind | Engineering | Solai-Jeevanandham | Magesh   | Jeevanandham | test1/test1/test1/test1-test2/test2/test2/test2 | CNBC,MSNBC | T-EDT22NNN.J047 | CurrentDate+10 | CurrentTime+10 | Hard Drive,WG01 | Test Source Details 1,Test Source Details 2 | Matching Time Code For All Clips, Merging Together Clips Without Retaining Time Code | Canon 5D Mark II,Canon R6 | Hard Drive,Stratus,Bluray |  5,10,15 | testing Hard Drive,testing Stratus, testing Bluray |
