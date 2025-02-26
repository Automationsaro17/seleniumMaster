@RockCenterProductionRequest @ProducerDashboard @Dashboard_Validation
Feature: Validate dashboard scenarios related Rock center production

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role

  @RockCenterProductionRequest_MyRequest_Dashboard_AllRequest_Dashboard_Validation
  Scenario Outline: Verify user filling Rock center production request form and validating in my request and all request dashboard
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in Rock Center Production form
      | Division   | Additional Requesters | Talent              |
      | <Division> | <Requesters>          | test/tesr/test/test |
    When user enters Request For info in Rock Center Production form
      | Request For   | Details and Notes   |
      | <Request For> | test/tesr/test/test |
    When user enters show information in Rock Center Production form
      | Air Platform   | Show or Project Name   | Start Date   | Prep Start Time   | Start Time   | End Time   |
      | <Air Platform> | <Show or Project Name> | <Start Date> | <Prep Start Time> | <Start Time> | <End Time> |
    When user enters set location information in Rock Center Production form
      | Location   | Set Location   |
      | <Location> | <Set Location> |
    When user enters set crew information in Rock Center Production form
      | Set Crew   |
      | <Set Crew> |
    When user enters control room information in Rock Center Production form
      | Control Room Location   | Control Room   |
      | <Control Room Location> | <Control Room> |
    When user enters control room crew information in Rock Center Production form
      | Capture Manager | Control Room Crew   |
      | Yes             | <Control Room Crew> |
    When user enters additional crew information in Rock Center Production form
      | Additional Crew   |
      | <Additional Crew> |
    When user enters system information in Rock Center Production form
      | Ultimatte | Voice Activated Prompter | Notes               |
      |         2 |                        1 | test/tesr/test/test |
    When user enters staging information in Rock Center Production form
      | Staging | Carpentry | Lighting | Props | Describe Staging Needs |
      | Yes     | yes       | yes      | yes   | test/tesr/test/test    |
    When user enters TPMorTM information in Rock Center Production form
      | TPM or TM         |
      | Same as Requester |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    And verify submitted "<Form Name>" is present in my request page with "NEW" status
    And verify "background color" of "NEW" status is "Pink" in my request page
    When user searches request in my request page
    Then verify all fields in the Rock Center Production form are matching with columns in My Request dashboard
      | Slug | Submitted   | Prod Date    | Show Title             |
      |      | CurrentDate | <Start Date> | <Show or Project Name> |
    When user clicks on "All Requests" button
    Then verify all fields in the Rock Center Production form are matching with columns in All Request dashboard
      | Requesters   | Slug | Submitted   | Prod Date    | Show Title             |
      | <Requesters> |      | CurrentDate | <Start Date> | <Show or Project Name> |

    ########################################################
    Examples: 
      | Form Name   | Division | Requesters         | Request For | Air Platform     | Show or Project Name | Start Date    | Prep Start Time | Start Time    | End Time      | Location             | Set Location                       | Set Crew                    | Control Room Location | Control Room                         | Control Room Crew                                      | Additional Crew                |
      | Rock Center | NBC News | Solai-Jeevanandham | Extend Crew | Video Conference | 7S Tour Studio       | CurrentDate+1 | CurrentTime+3   | CurrentTime+3 | CurrentTime+3 | Rock Center,Field,DC | 3A VR,Testing field 1,Newsroom Cam | JIB,SM/A2,Prod A2,Crane Cam | DC,Field,Rock Center  | Ground Control,Testing field 2,CR 31 | A1 Production Mix,Video Playback,GFX PB Op FS,CR AD,T2 | Prompter Op,Studio Maintenance |
