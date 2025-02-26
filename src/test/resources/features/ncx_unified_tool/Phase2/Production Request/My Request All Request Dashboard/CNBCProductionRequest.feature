@CNBCProductionRequest @ProducerDashboard @Dashboard_Validation
Feature: Validate various scenarios related CNBC production

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role

  @CNBCProductionRequest_MyRequest_Dashboard_AllRequest_Dashboard_Validation
  Scenario Outline: Verify user filling CNBC production request form and validating in my request and all request dashboard
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in CNBC Production form
      | Division   | Additional Requesters | Talent              |
      | <Division> | <Requesters>          | test/tesr/test/test |
    When user enters Request For info in CNBC Production form
      | Request For   | Details and Notes   |
      | <Request For> | test/tesr/test/test |
    When user enters show information in CNBC Production form
      | Air Platform   | Sub Division   | Show or Project Name   | Start Date   | Call Time   | Start Time   | End Time   |
      | <Air Platform> | <Sub Division> | <Show or Project Name> | <Start Date> | <Call Time> | <Start Time> | <End Time> |
    When user enters set location information in CNBC Production form
      | Location   |
      | <Location> |
    When user enters set crew information in CNBC Production form
      | Set Crew   |
      | <Set Crew> |
    When user enters staging information in CNBC Production form
      | Staging Needs       |
      | Test-test-test-test |
    When user enters control room information in CNBC Production form
      | Control Room Needed   | Ingest | Iso | Control Room Crew   |
      | <Control Room Needed> | No     | Yes | <Control Room Crew> |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    And verify submitted "<Form Name>" is present in my request page with "NEW" status
    And verify "background color" of "NEW" status is "Pink" in my request page
    When user searches request in my request page
    Then verify all fields in the CNBC Production form are matching with columns in My Request dashboard
      | Slug | Submitted   | Prod Date    | Show Title             |
      |      | CurrentDate | <Start Date> | <Show or Project Name> |
    When user clicks on "All Requests" button
    Then verify all fields in the CNBC Production form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date    | Show Title             |
      | <Requesters> |      | CurrentDate | <Start Date> | <Show or Project Name> |

    ########################################################
    Examples: 
      | Form Name | Division | Requesters         | Request For    | Air Platform | Sub Division | Show or Project Name | Start Date    | Call Time     | Start Time    | End Time      | Location | Set Crew                                 | Control Room Needed | Control Room Crew  |
      | CNBC      | Acorn    | Solai-Jeevanandham | Internal Event | OTT          |              | Power Lunch          | CurrentDate+1 | CurrentTime+3 | CurrentTime+3 | CurrentTime+3 | EC,DC,EC | Flashcam,Lighting Director,Playout,Other | Yes                 | TPS,Director,Other |
