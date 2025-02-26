@NewsGearRequest @ProducerDashboard @Dashboard_Validation
Feature: Validate various scenarios related Gear request

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role

  @NewsGearRequest_MyRequest_Dashboard_AllRequest_Dashboard_Validation
  Scenario Outline: Verify end to end flow of "<Form Name>" form and validating in my request and all request dashboard
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
    And verify submitted "<Form Name>" is present in my request page with "NEW" status
    And verify "background color" of "NEW" status is "Pink" in my request page
    When user searches request in my request page
    Then verify all fields in the News Gear form are matching with columns in My Request dashboard
      | Slug   | Submitted   | Prod Date  | Show Title  |
      | <Slug> | CurrentDate | <Pick Up Date> | <Show Unit> |
    When user clicks on "All Requests" button
    Then verify all fields in the News Gear form are matching with columns in All Request dashboard
      | Requesters   | Slug   | Submitted   | Prod Date      | Show Title  |
      | <Requesters> | <Slug> | CurrentDate | <Pick Up Date> | <Show Unit> |

    ########################################################
    Examples: 
      | Form Name | Division | Requesters         | Show Unit                            | Budget Code     | Location | Pick Up Date  | Pick Up Time  | Return Date   | Return Time   |
      | News Gear | Acorn    | Solai-Jeevanandham | Capital Exchange Livestream,News Now | T-SHEP2021.J047 | LA       | CurrentDate+1 | CurrentTime+3 | CurrentDate+3 | CurrentTime+3 |
