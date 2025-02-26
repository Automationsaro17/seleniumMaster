@RockCenterProductionRequest @ProducerDashboard @Dashboard_Validation
Feature: Validate dashboard scenarios related Rock center production

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role

  @RockCenterProductionRequest_Dashboard_Validation_e2e @SEVERITY=CRITICAL @StudioE2E
  Scenario Outline: Verify user filling Rock center production request form and validating in dashboard
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
    ###################################################################################################
    And verify submitted "<Form Name>" is present in my request page with "NEW" status
    And verify "background color" of "NEW" status is "Pink" in my request page
    When user searches request in my request page
    And user click edit link of the request in "My Request page"
    ############################ user adding notes as requester ############################
    When user verifies logs are displaying in Log section
    When user click "Notes" tab in request form page
    And user enters add notes details in Notes section
      | Notes Info       |
      | testr  requester |
    And user clicks on "save" button
    And verify submitted "<Form Name>" is present in my request page with "MODIFIED" status
    And verify "background color" of "MODIFIED" status is "Orange" in my request page
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "MODIFIED" status
    And verify "background color" of "MODIFIED" status is "Orange" in fullfiller dashboard
    Then verify all fields in the Rock Center form are matching with columns in production dashboard
      | Requesters   | Prod Date                                               | Show/Project           | Production Purpose | Set Location              | Control Room                           | Positions                                        | Submitted   |
      | <Requesters> | <Start Date>,<Prep Start Time>,<Start Time>, <End Time> | <Show or Project Name> | <Request For>      | <Location>,<Set Location> | <Control Room Location>,<Control Room> | <Set Crew>-<Control Room Crew>-<Additional Crew> | CurrentDate |
    When user clicks on "NBCU Logo" button
    And user logs out from application
    ############################ user logging in as fulfiller and modifying the form request ############################
    Given user opens producer dashboard application
    And user logins with "fulfiller" role
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "MODIFIED" status
    And verify "background color" of "MODIFIED" status is "Orange" in fullfiller dashboard
    And user click edit link of the request in "fulfiller page"
    When user verifies logs are displaying in Log section
    When user enters show information in Rock Center Production form
      | Air Platform | Show or Project Name | Start Date | Prep Start Time | Start Time | End Time |
      | Internal     |                      |            |                 |            |          |
    ############################ user adding notes as fulfiller ############################
    When user click "Notes" tab in request form page
    And user enters add notes details in Notes section
      | Notes Info       |
      | testr  fulfiller |
    When user clicks on "save" button
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "MODIFIED" status
    And verify "background color" of "MODIFIED" status is "Orange" in fullfiller dashboard
    Then verify all fields in the Rock Center form are matching with columns in production dashboard
      | Requesters   | Prod Date                                               | Show/Project           | Production Purpose | Set Location              | Control Room                           | Positions                                        | Submitted   |
      | <Requesters> | <Start Date>,<Prep Start Time>,<Start Time>, <End Time> | <Show or Project Name> | <Request For>      | <Location>,<Set Location> | <Control Room Location>,<Control Room> | <Set Crew>-<Control Room Crew>-<Additional Crew> | CurrentDate |
    ############################ Acknowledged the form request ############################
    And user click edit link of the request in "fulfiller page"
    When user verifies logs are displaying in Log section
    When user click "Status" tab in request form page
    When user changes status to "Acknowledged"
    When user clicks on "save" button
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "WORKING" status
    And verify "background color" of "WORKING" status is "Blue" in fullfiller dashboard
    Then verify all fields in the Rock Center form are matching with columns in production dashboard
      | Requesters   | Prod Date                                               | Show/Project           | Production Purpose | Set Location              | Control Room                           | Positions                                        | Submitted   |
      | <Requesters> | <Start Date>,<Prep Start Time>,<Start Time>, <End Time> | <Show or Project Name> | <Request For>      | <Location>,<Set Location> | <Control Room Location>,<Control Room> | <Set Crew>-<Control Room Crew>-<Additional Crew> | CurrentDate |
    ############################ Technical the form request ############################
    And user click edit link of the request in "fulfiller page"
    When user verifies logs are displaying in Log section
    When user click "Status" tab in request form page
    When user changes status to "Technical"
    When user clicks on "save" button
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "WORKING" status
    And verify "background color" of "WORKING" status is "Blue" in fullfiller dashboard
    Then verify all fields in the Rock Center form are matching with columns in production dashboard
      | Requesters   | Prod Date                                               | Show/Project           | Production Purpose | Set Location              | Control Room                           | Positions                                        | Submitted   |
      | <Requesters> | <Start Date>,<Prep Start Time>,<Start Time>, <End Time> | <Show or Project Name> | <Request For>      | <Location>,<Set Location> | <Control Room Location>,<Control Room> | <Set Crew>-<Control Room Crew>-<Additional Crew> | CurrentDate |
    ############################ DC Fulfillment the form request ############################
    And user click edit link of the request in "fulfiller page"
    When user verifies logs are displaying in Log section
    When user click "Status" tab in request form page
    When user changes status to "DC FULFILLMENT"
    When user clicks on "save" button
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "WORKING" status
    And verify "background color" of "WORKING" status is "Blue" in fullfiller dashboard
    Then verify all fields in the Rock Center form are matching with columns in production dashboard
      | Requesters   | Prod Date                                               | Show/Project           | Production Purpose | Set Location              | Control Room                           | Positions                                        | Submitted   |
      | <Requesters> | <Start Date>,<Prep Start Time>,<Start Time>, <End Time> | <Show or Project Name> | <Request For>      | <Location>,<Set Location> | <Control Room Location>,<Control Room> | <Set Crew>-<Control Room Crew>-<Additional Crew> | CurrentDate |
    ############################ LA Fulfillment the form request ############################
    And user click edit link of the request in "fulfiller page"
    When user verifies logs are displaying in Log section
    When user click "Status" tab in request form page
    When user changes status to "LA FULFILLMENT"
    When user clicks on "save" button
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "WORKING" status
    And verify "background color" of "WORKING" status is "Blue" in fullfiller dashboard
    Then verify all fields in the Rock Center form are matching with columns in production dashboard
      | Requesters   | Prod Date                                               | Show/Project           | Production Purpose | Set Location              | Control Room                           | Positions                                        | Submitted   |
      | <Requesters> | <Start Date>,<Prep Start Time>,<Start Time>, <End Time> | <Show or Project Name> | <Request For>      | <Location>,<Set Location> | <Control Room Location>,<Control Room> | <Set Crew>-<Control Room Crew>-<Additional Crew> | CurrentDate |
    ############################ Staging the form request ############################
    And user click edit link of the request in "fulfiller page"
    When user verifies logs are displaying in Log section
    When user click "Status" tab in request form page
    When user changes status to "Staging"
    When user clicks on "save" button
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "WORKING" status
    And verify "background color" of "WORKING" status is "Blue" in fullfiller dashboard
    Then verify all fields in the Rock Center form are matching with columns in production dashboard
      | Requesters   | Prod Date                                               | Show/Project           | Production Purpose | Set Location              | Control Room                           | Positions                                        | Submitted   |
      | <Requesters> | <Start Date>,<Prep Start Time>,<Start Time>, <End Time> | <Show or Project Name> | <Request For>      | <Location>,<Set Location> | <Control Room Location>,<Control Room> | <Set Crew>-<Control Room Crew>-<Additional Crew> | CurrentDate |
    ############################ HAIR, MAKEUP & WARDROBE the form request ############################
    And user click edit link of the request in "fulfiller page"
    When user verifies logs are displaying in Log section
    When user click "Status" tab in request form page
    When user changes status to "HAIR, MAKEUP & WARDROBE"
    When user clicks on "save" button
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "WORKING" status
    And verify "background color" of "WORKING" status is "Blue" in fullfiller dashboard
    Then verify all fields in the Rock Center form are matching with columns in production dashboard
      | Requesters   | Prod Date                                               | Show/Project           | Production Purpose | Set Location              | Control Room                           | Positions                                        | Submitted   |
      | <Requesters> | <Start Date>,<Prep Start Time>,<Start Time>, <End Time> | <Show or Project Name> | <Request For>      | <Location>,<Set Location> | <Control Room Location>,<Control Room> | <Set Crew>-<Control Room Crew>-<Additional Crew> | CurrentDate |
    ############################ TM/TPM the form request ############################
    And user click edit link of the request in "fulfiller page"
    When user verifies logs are displaying in Log section
    When user click "Status" tab in request form page
    When user changes status to "TM/TPM"
    When user clicks on "save" button
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "WORKING" status
    And verify "background color" of "WORKING" status is "Blue" in fullfiller dashboard
    Then verify all fields in the Rock Center form are matching with columns in production dashboard
      | Requesters   | Prod Date                                               | Show/Project           | Production Purpose | Set Location              | Control Room                           | Positions                                        | Submitted   |
      | <Requesters> | <Start Date>,<Prep Start Time>,<Start Time>, <End Time> | <Show or Project Name> | <Request For>      | <Location>,<Set Location> | <Control Room Location>,<Control Room> | <Set Crew>-<Control Room Crew>-<Additional Crew> | CurrentDate |
    ############################ DPS PLAYBACK the form request ############################
    And user click edit link of the request in "fulfiller page"
    When user verifies logs are displaying in Log section
    When user click "Status" tab in request form page
    When user changes status to "DPS PLAYBACK"
    When user clicks on "save" button
    And user opens fulfiller dashboard for "<Form Name>" form
    Then user clicks "Fulfilled" requests dropdown in Production Dashboard
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "FULFILLED" status
    And verify "background color" of "FULFILLED" status is "Green" in fullfiller dashboard
    Then verify all fields in the Rock Center form are matching with columns in production dashboard
      | Requesters   | Prod Date                                               | Show/Project           | Production Purpose | Set Location              | Control Room                           | Positions                                        | Submitted   |
      | <Requesters> | <Start Date>,<Prep Start Time>,<Start Time>, <End Time> | <Show or Project Name> | <Request For>      | <Location>,<Set Location> | <Control Room Location>,<Control Room> | <Set Crew>-<Control Room Crew>-<Additional Crew> | CurrentDate |
    And user logs out from application
    ############################ user logging in as producer and modifying the request  ############################
    Given user opens producer dashboard application
    And user logins with "producer" role
    When user searches request in my request page
    And user click edit link of the request in "My Request page"
    When user verifies logs are displaying in Log section
    When user enters show information in Rock Center Production form
      | Air Platform     | Show or Project Name | Start Date | Prep Start Time | Start Time | End Time |
      | Video Conference |                      |            |                 |            |          |
    When user clicks on "save" button
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "MODIFIED" status
    And verify "background color" of "MODIFIED" status is "Orange" in fullfiller dashboard
    Then verify all fields in the Rock Center form are matching with columns in production dashboard
      | Requesters   | Prod Date                                               | Show/Project           | Production Purpose | Set Location              | Control Room                           | Positions                                        | Submitted   |
      | <Requesters> | <Start Date>,<Prep Start Time>,<Start Time>, <End Time> | <Show or Project Name> | <Request For>      | <Location>,<Set Location> | <Control Room Location>,<Control Room> | <Set Crew>-<Control Room Crew>-<Additional Crew> | CurrentDate |
    When user clicks on "MY REQUEST DASHBOARD PAGE" button
    ############################ user submitting cancel request ############################
    When user searches request in my request page
    Then user click on request ID link of the request
    When user verifies logs are displaying in Log section
    When user clicks on "cancel request" button
    And verify "cancel request" alert message
      | Cancel Request Alert Message                                                                                     |
      | Are you sure you want to cancel this request? All cancellations are pending until confirmed by fulfillment teams |
    And click "Yes" on "cancel request" alert message
    Then verify request is "Cancellation Requested" successfully
    When user clicks on "NBCU Logo" button
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "CONFIRM CANCELLATION" status
    And verify "background color" of "CONFIRM CANCELLATION" status is "Grey" in fullfiller dashboard
    Then verify all fields in the Rock Center form are matching with columns in production dashboard
      | Requesters   | Prod Date                                               | Show/Project           | Production Purpose | Set Location              | Control Room                           | Positions                                        | Submitted   |
      | <Requesters> | <Start Date>,<Prep Start Time>,<Start Time>, <End Time> | <Show or Project Name> | <Request For>      | <Location>,<Set Location> | <Control Room Location>,<Control Room> | <Set Crew>-<Control Room Crew>-<Additional Crew> | CurrentDate |
    And user logs out from application
    ############################ user logging in as fulfiller and cancelled the form request ############################
    Given user opens producer dashboard application
    And user logins with "fulfiller" role
    And user opens fulfiller dashboard for "<Form Name>" form
    Then verify "<Form Name>" is present in fulfiller dashboard with "CONFIRM CANCELLATION" status
    And verify "background color" of "CONFIRM CANCELLATION" status is "Grey" in fullfiller dashboard
    Then verify all fields in the Rock Center form are matching with columns in production dashboard
      | Requesters   | Prod Date                                               | Show/Project           | Production Purpose | Set Location              | Control Room                           | Positions                                        | Submitted   |
      | <Requesters> | <Start Date>,<Prep Start Time>,<Start Time>, <End Time> | <Show or Project Name> | <Request For>      | <Location>,<Set Location> | <Control Room Location>,<Control Room> | <Set Crew>-<Control Room Crew>-<Additional Crew> | CurrentDate |
    Then user click on request ID link of the request
    When user verifies logs are displaying in Log section
    When user clicks on "confirm cancel request" button
    And verify "confirm cancellation" alert message
      | Confirm Cancellation Alert Message           |
      | Are you sure you want to cancel this request |
    And click "Yes" on "confirm cancellation" alert message
    Then verify request is "Cancelled" successfully
    And user opens fulfiller dashboard for "<Form Name>" form
    Then user clicks "Fulfilled" requests dropdown in Production Dashboard
    And user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "CANCELLED" status
    And verify "background color" of "CANCELLED" status is "Black" in fullfiller dashboard
    Then verify all fields in the Rock Center form are matching with columns in production dashboard
      | Requesters   | Prod Date                                               | Show/Project           | Production Purpose | Set Location              | Control Room                           | Positions                                        | Submitted   |
      | <Requesters> | <Start Date>,<Prep Start Time>,<Start Time>, <End Time> | <Show or Project Name> | <Request For>      | <Location>,<Set Location> | <Control Room Location>,<Control Room> | <Set Crew>-<Control Room Crew>-<Additional Crew> | CurrentDate |
    Then user click on request ID link of the request
    When user verifies logs are displaying in Log section

    Examples: 
      | Form Name   | Division | Requesters         | Request For | Air Platform     | Show or Project Name | Start Date    | Prep Start Time | Start Time    | End Time      | Location    | Set Location                         | Set Crew                                 | Control Room Location | Control Room                         | Control Room Crew                                      | Additional Crew                |
      | Rock Center | NBC News | Solai-Jeevanandham | Extend Crew | Video Conference | 7S Tour Studio       | CurrentDate+1 | CurrentTime+3   | CurrentTime+3 | CurrentTime+3 | LA,Field,DC | Stage West,Testing field 1,1A Studio | JIB,SM/A2,Prod A2,Crane Cam,Hair Stylist | DC,Field,Rock Center  | Ground Control,Testing field 2,CR 31 | A1 Production Mix,Video Playback,GFX PB Op FS,CR AD,T2 | Prompter Op,Studio Maintenance |

  @RockCenterProductionRequest_Dashboard_Validation_e2e_short @SEVERITY=CRITICAL @StudioE2E
  Scenario Outline: Verify user filling Rock center production request form and validating in dashboard
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
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "NEW" status
    And verify "background color" of "NEW" status is "Pink" in fullfiller dashboard
    Then verify all fields in the Rock Center form are matching with columns in production dashboard
      | Requesters   | Prod Date                                               | Show/Project           | Production Purpose | Set Location              | Control Room                           | Positions                                        | Submitted   |
      | <Requesters> | <Start Date>,<Prep Start Time>,<Start Time>, <End Time> | <Show or Project Name> | <Request For>      | <Location>,<Set Location> | <Control Room Location>,<Control Room> | <Set Crew>-<Control Room Crew>-<Additional Crew> | CurrentDate |
    When user clicks on "NBCU Logo" button
    And user logs out from application
    Given user opens producer dashboard application
    And user logins with "fulfiller" role
    ############################ user logging in as fulfiller and modifying the form request ############################
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    ############################ Acknowledged the form request ############################
    And user click edit link of the request in "fulfiller page"
    When user verifies logs are displaying in Log section
    When user click "Status" tab in request form page
    When user changes status to "Acknowledged"
    When user changes status to "Technical"
    When user changes status to "DC FULFILLMENT"
    When user changes status to "LA FULFILLMENT"
    When user changes status to "Staging"
    When user changes status to "HAIR, MAKEUP & WARDROBE"
    When user changes status to "TM/TPM"
    When user changes status to "DPS PLAYBACK"
    When user clicks on "save request" button
    And user opens fulfiller dashboard for "<Form Name>" form
    Then user clicks "Fulfilled" requests dropdown in Production Dashboard
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "FULFILLED" status
    And verify "background color" of "FULFILLED" status is "Green" in fullfiller dashboard
    Then verify all fields in the Rock Center form are matching with columns in production dashboard
      | Requesters   | Prod Date                                               | Show/Project           | Production Purpose | Set Location              | Control Room                           | Positions                                        | Submitted   |
      | <Requesters> | <Start Date>,<Prep Start Time>,<Start Time>, <End Time> | <Show or Project Name> | <Request For>      | <Location>,<Set Location> | <Control Room Location>,<Control Room> | <Set Crew>-<Control Room Crew>-<Additional Crew> | CurrentDate |
    And user click edit link of the request in "fulfiller page"

    Examples: 
      | Form Name   | Division | Requesters         | Request For | Air Platform     | Show or Project Name | Start Date    | Prep Start Time | Start Time    | End Time      | Location    | Set Location                         | Set Crew                                 | Control Room Location | Control Room                         | Control Room Crew                                      | Additional Crew                |
      | Rock Center | NBC News | Solai-Jeevanandham | Extend Crew | Video Conference | 7S Tour Studio       | CurrentDate+1 | CurrentTime+3   | CurrentTime+3 | CurrentTime+3 | LA,Field,DC | Stage West,Testing field 1,1A Studio | JIB,SM/A2,Prod A2,Crane Cam,Hair Stylist | DC,Field,Rock Center  | Ground Control,Testing field 2,CR 31 | A1 Production Mix,Video Playback,GFX PB Op FS,CR AD,T2 | Prompter Op,Studio Maintenance |
