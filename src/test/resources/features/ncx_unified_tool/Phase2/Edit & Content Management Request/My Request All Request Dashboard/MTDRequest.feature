@MTD @ProducerDashboard @Dashboard_Validation
Feature: Validate various scenarios related ECM request

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role

  @MTD_MyRequest_Dashboard_AllRequest_Dashboard_Validation
  Scenario Outline: Verify user creating MTD requests flow of "<Form Name>" form and validating in my request and all request dashboard
    ############################ user submitting the form request ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in MTD Request form
      | Slug   | NCX Story Name | Division   | Additional Requesters | Is Producer Same as Requestor | Sr Producer   | Talent   |
      | <Slug> |                | <Division> | <Requesters>          | <Producer>                    | <Sr Producer> | <Talent> |
    When user enters show info Information in MTD Request form
      | Show Unit   | Budget Code   | Air Date   | Air Time      |
      | <Show Unit> | <Budget Code> | <Air Date> | CurrentTime+3 |
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
    And verify submitted "<Form Name>" is present in my request page with "NEW" status
    And verify "background color" of "NEW" status is "Pink" in my request page
    When user searches request in my request page
    Then verify all fields in the MTD form are matching with columns in My Request dashboard
      | Slug   | Submitted   | Prod Date  | Show Title  |
      | <Slug> | CurrentDate | <Air Date> | <Show Unit> |
    When user clicks on "All Requests" button
    Then verify all fields in the MTD form are matching with columns in All Request dashboard
      | Requesters   | Slug   | Submitted   | Prod Date  | Show Title  |
      | <Requesters> | <Slug> | CurrentDate | <Air Date> | <Show Unit> |

    Examples: #CNBC- Stratus
      | Form Name                                      | Slug | Division    | Requesters         | Producer | Sr Producer  | Talent                                          | Show Unit  | Budget Code     | Air Date      | Date Needed By | Time Needed By | Source          | Source Details                              | Time Codes                                                                           | Camera                    | Destination               | Quantity | Details                                            |
      | Media Transcoding / Transferring / Duplication | Wind | Engineering | Solai-Jeevanandham | Magesh   | Jeevanandham | test1/test1/test1/test1-test2/test2/test2/test2 | CNBC,MSNBC | T-EDT22NNN.J047 | CurrentDate+5 | CurrentDate+10 | CurrentTime+10 | Hard Drive,WG01 | Test Source Details 1,Test Source Details 2 | Matching Time Code For All Clips, Merging Together Clips Without Retaining Time Code | Canon 5D Mark II,Canon R6 | Hard Drive,Stratus,Bluray |  5,10,15 | testing Hard Drive,testing Stratus, testing Bluray |
