@RockCenterProductionRequest @ProducerDashboard
Feature: Validate various scenarios related Rock center production

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role

  @RockCenterProductionRequest_Basic_Flow
  Scenario Outline: Verify user filling Rock center production request form
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in Rock Center Production form
      | Division | Additional Requesters | Talent              |
      | MSNBC    | Solai-Jeevanandham    | test/tesr/test/test |
    When user enters Request For info in Rock Center Production form
      | Request For          | Details and Notes   |
      | Additional Live Show | test/tesr/test/test |
    When user enters show information in Rock Center Production form
      | Air Platform | Show or Project Name | Start Date    | Prep Start Time | Start Time    | End Time      |
      | OTT          | 7S Tour Studio       | CurrentDate+3 | CurrentTime+3   | CurrentTime+3 | CurrentTime+3 |
    When user enters set location information in Rock Center Production form
      | Location    | Set Location |
      | Rock Center | 3A VR        |
    When user enters set crew information in Rock Center Production form
      | Set Crew |
      | JIB      |
    When user enters control room information in Rock Center Production form
      | Control Room Location | Control Room |
      | Rock Center           | CR 32        |
    When user enters control room crew information in Rock Center Production form
      | Capture Manager | Control Room Crew |
      | Yes             | A1                |
    When user enters additional crew information in Rock Center Production form
      | Additional Crew |
      | VIDEO OP        |
    When user enters system information in Rock Center Production form
      | Ultimatte | Voice Activated Prompter | Notes               |
      |         2 |                        1 | test/tesr/test/test |
    When user enters staging information in Rock Center Production form
      | Staging | Carpentry | Lighting | Props | Describe Staging Needs |
      | Yes     | yes       | yes      | yes   | test/tesr/test/test    |
    When user enters TPMorTM information in Rock Center Production form
      | TPM or TM |
      | Magesh    |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    And user logs out from application

    ########################################################
    Examples: 
      | Form Name   |
      | Rock Center |

  @RockCenterProductionRequest_different_divisions
  Scenario Outline: Verify user filling Rock center production request form with different divisions
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in Rock Center Production form
      | Division   | Additional Requesters | Talent              |
      | <Division> | Solai-Jeevanandham    | test/tesr/test/test |
    When user enters Request For info in Rock Center Production form
      | Request For          | Details and Notes   |
      | Additional Live Show | test/tesr/test/test |
    When user enters show information in Rock Center Production form
      | Air Platform | Show or Project Name | Start Date    | Prep Start Time | Start Time    | End Time      |
      | OTT          | 7S Tour Studio       | CurrentDate+3 | CurrentTime+3   | CurrentTime+3 | CurrentTime+3 |
    When user enters set location information in Rock Center Production form
      | Location    | Set Location |
      | Rock Center | 3A VR        |
    When user enters set crew information in Rock Center Production form
      | Set Crew |
      | JIB      |
    When user enters control room information in Rock Center Production form
      | Control Room Location | Control Room |
      | Rock Center           | CR 32        |
    When user enters control room crew information in Rock Center Production form
      | Capture Manager | Control Room Crew |
      | Yes             | A1                |
    When user enters additional crew information in Rock Center Production form
      | Additional Crew |
      | VIDEO OP        |
    When user enters system information in Rock Center Production form
      | Ultimatte | Voice Activated Prompter | Notes               |
      |         2 |                        1 | test/tesr/test/test |
    When user enters staging information in Rock Center Production form
      | Staging | Carpentry | Lighting | Props | Describe Staging Needs |
      | Yes     | yes       | yes      | yes   | test/tesr/test/test    |
    When user enters TPMorTM information in Rock Center Production form
      | TPM or TM |
      | Magesh    |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    And user logs out from application

    ########################################################
    Examples: 
      | Form Name   | Division         |
      | Rock Center | NBC News         |
      | Rock Center | MSNBC            |
      | Rock Center | CNBC             |
      | Rock Center | Acorn            |
      | Rock Center | Corporate        |
      | Rock Center | Engineering      |
      | Rock Center | Entertainment    |
      | Rock Center | ERG Events       |
      | Rock Center | Facilities       |
      | Rock Center | NBC News Studios |
      | Rock Center | NBC Sports       |
      | Rock Center | News Digital     |
      | Rock Center | Olympics         |
      | Rock Center | Operations       |
      | Rock Center | Peacock          |
      | Rock Center | Telemundo        |
      | Rock Center | Universal Kids   |

  @RockCenterProductionRequest_combination_divisions_airplatform
  Scenario Outline: Verify user filling Rock center production request form with different divisions
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in Rock Center Production form
      | Division   | Additional Requesters | Talent              |
      | <Division> | Solai-Jeevanandham    | test/tesr/test/test |
    When user enters Request For info in Rock Center Production form
      | Request For          | Details and Notes   |
      | Additional Live Show | test/tesr/test/test |
    When user enters show information in Rock Center Production form
      | Air Platform   | Show or Project Name | Start Date    | Prep Start Time | Start Time    | End Time      |
      | <Air Platform> | 7S Tour Studio       | CurrentDate+3 | CurrentTime+3   | CurrentTime+3 | CurrentTime+3 |
    When user enters set location information in Rock Center Production form
      | Location   | Set Location   |
      | <Location> | <Set Location> |
    When user enters set crew information in Rock Center Production form
      | Set Crew |
      | JIB      |
    When user enters control room information in Rock Center Production form
      | Control Room Location | Control Room |
      | Rock Center           | CR 32        |
    When user enters control room crew information in Rock Center Production form
      | Capture Manager | Control Room Crew |
      | Yes             | A1                |
    When user enters additional crew information in Rock Center Production form
      | Additional Crew |
      | VIDEO OP        |
    When user enters system information in Rock Center Production form
      | Ultimatte | Voice Activated Prompter | Notes               |
      |         2 |                        1 | test/tesr/test/test |
    When user enters staging information in Rock Center Production form
      | Staging | Carpentry | Lighting | Props | Describe Staging Needs |
      | Yes     | yes       | yes      | yes   | test/tesr/test/test    |
    When user enters TPMorTM information in Rock Center Production form
      | TPM or TM |
      | Magesh    |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    And user logs out from application

    ########################################################
    Examples: 
      | Form Name   | Division         | Air Platform     | Location    | Set Location   |
      | Rock Center | NBC News         | Broadcast        | Rock Center | 1A Studio      |
      | Rock Center | MSNBC            | Cable            | Rock Center | 1A UP          |
      | Rock Center | NBC News Studios | OTT              | Rock Center | 6B Studio      |
      | Rock Center | NBC Sports       | Internal         | Rock Center | 3E Flashcam    |
      | Rock Center | News Digital     | Video Conference | Rock Center | 3B Studio      |
      | Rock Center | Olympics         | Multiple         | Rock Center | 3A Studio      |
      | Rock Center | Operations       | Broadcast        | Rock Center | 4E Town Square |
      | Rock Center | NBC News Studios | Cable            | Field       | Test           |
      | Rock Center | Telemundo        | OTT              | Rock Center | 4E Town Square |
      | Rock Center | Universal Kids   | Video Conference | Rock Center | 3B Studio      |
      | Rock Center | CNBC             | OTT              | Rock Center | 3A VR          |
      | Rock Center | Acorn            | Internal         | Rock Center | 3A West        |
      | Rock Center | Corporate        | Video Conference | Rock Center | 6A Studio      |
      | Rock Center | Engineering      | Multiple         | Rock Center | AQ             |
      | Rock Center | Entertainment    | N/A              | Rock Center | Plaza          |
      | Rock Center | ERG Events       | Broadcast        | Rock Center | 8G Studio      |
      | Rock Center | Facilities       | Cable            | Rock Center | 8H Studio      |

  @RockCenterProductionRequest_combination_divisions_airplatform_location_ControlRoom_RequestFor_TPM
  Scenario Outline: Verify user filling Rock center production request form with different divisions airplatform location ControlRoom Request For
    TPM

    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in Rock Center Production form
      | Division   | Additional Requesters | Talent              |
      | <Division> | Solai-Jeevanandham    | test/tesr/test/test |
    When user enters Request For info in Rock Center Production form
      | Request For   | Details and Notes   |
      | <Request For> | test/tesr/test/test |
    When user enters show information in Rock Center Production form
      | Air Platform   | Show or Project Name | Start Date    | Prep Start Time | Start Time    | End Time      |
      | <Air Platform> | 7S Tour Studio       | CurrentDate+3 | CurrentTime+3   | CurrentTime+3 | CurrentTime+3 |
    When user enters set location information in Rock Center Production form
      | Location   | Set Location   |
      | <Location> | <Set Location> |
    When user enters set crew information in Rock Center Production form
      | Set Crew |
      | JIB      |
    When user enters control room information in Rock Center Production form
      | Control Room Location   | Control Room   |
      | <Control Room Location> | <Control Room> |
    When user enters control room crew information in Rock Center Production form
      | Capture Manager | Control Room Crew |
      | Yes             | A1                |
    When user enters additional crew information in Rock Center Production form
      | Additional Crew |
      | VIDEO OP        |
    When user enters system information in Rock Center Production form
      | Ultimatte | Voice Activated Prompter | Notes               |
      |         2 |                        1 | test/tesr/test/test |
    When user enters staging information in Rock Center Production form
      | Staging | Carpentry | Lighting | Props | Describe Staging Needs |
      | Yes     | yes       | yes      | yes   | test/tesr/test/test    |
    When user enters TPMorTM information in Rock Center Production form
      | TPM or TM   |
      | <TPM or TM> |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    And user logs out from application

    ########################################################
    Examples: 
      | Form Name   | Division         | Air Platform | Location    | Set Location      | Control Room Location | Control Room   | Request For    | TPM or TM |
      | Rock Center | NBC News         | Broadcast    | Rock Center | 1A Studio         | Rock Center           | CR 1A          | Internal Event | Yes       |
      | Rock Center | NBC News Studios | OTT          | Field       | testing for hello | DC                    | Ground Control | Bridge Crew    | No        |

  @RockCenterProductionRequest_Telemundo
  Scenario Outline: Verify user filling Rock center production request form with Telemundo
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in Rock Center Production form
      | Division   | Additional Requesters | Talent              |
      | <Division> | Solai-Jeevanandham    | test/tesr/test/test |
    When user enters Request For info in Rock Center Production form
      | Request For   | Details and Notes   |
      | <Request For> | test/tesr/test/test |
    When user enters show information in Rock Center Production form
      | Air Platform   | Show or Project Name | Start Date    | Prep Start Time | Start Time    | End Time      |
      | <Air Platform> | 7S Tour Studio       | CurrentDate+3 | CurrentTime+3   | CurrentTime+3 | CurrentTime+3 |
    When user enters set location information in Rock Center Production form
      | Location   | Set Location   |
      | <Location> | <Set Location> |
    When user enters set crew information in Rock Center Production form
      | Set Crew |
      | JIB      |
    When user enters control room information in Rock Center Production form
      | Control Room Location   | Control Room   |
      | <Control Room Location> | <Control Room> |
    When user enters control room crew information in Rock Center Production form
      | Capture Manager | Control Room Crew |
      | Yes             | A1                |
    When user enters additional crew information in Rock Center Production form
      | Additional Crew |
      | VIDEO OP        |
    When user enters system information in Rock Center Production form
      | Ultimatte | Voice Activated Prompter | Notes               |
      |         2 |                        1 | test/tesr/test/test |
    When user enters staging information in Rock Center Production form
      | Staging | Carpentry | Lighting | Props | Describe Staging Needs |
      | Yes     | yes       | yes      | yes   | test/tesr/test/test    |
    When user enters TPMorTM information in Rock Center Production form
      | TPM or TM   |
      | <TPM or TM> |
    And user clicks on "Submit" button

    ########################################################
    Examples: 
      | Form Name   | Division       | Air Platform     | Location         | Set Location | Control Room Location | Control Room   | Request For | TPM or TM         |
      | Rock Center | Telemundo | Video Conference | Telemundo Center | Studio       | DC                    | Ground Control | Extend Crew | Same as Requester |
      
    @RockCenterProductionRequest_e2e @SEVERITY=CRITICAL @NOTES
    Scenario Outline: Verify both the requester and fulfiller can add NOTES and its validation for Rock center production request form
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in Rock Center Production form
      | Division | Additional Requesters | Talent              |
      | MSNBC    | solai-Jeevanandham    | test/tesr/test/test |
    When user enters Request For info in Rock Center Production form
      | Request For          | Details and Notes   |
      | Additional Live Show | test/tesr/test/test |
    When user enters show information in Rock Center Production form
      | Air Platform | Show or Project Name | Start Date    | Prep Start Time | Start Time    | End Time      |
      | OTT          | 7S Tour Studio       | CurrentDate+3 | CurrentTime+3   | CurrentTime+3 | CurrentTime+3 |
    When user enters set location information in Rock Center Production form
      | Location    | Set Location |
      | Rock Center | 3A VR        |
    When user enters set crew information in Rock Center Production form
      | Set Crew |
      | JIB      |
    When user enters control room information in Rock Center Production form
      | Control Room Location | Control Room |
      | Rock Center           | CR 32        |
    When user enters control room crew information in Rock Center Production form
      | Capture Manager | Control Room Crew |
      | Yes             | A1                |
    When user enters additional crew information in Rock Center Production form
      | Additional Crew |
      | VIDEO OP        |
    When user enters system information in Rock Center Production form
      | Ultimatte | Voice Activated Prompter | Notes               |
      |         2 |                        1 | test/tesr/test/test |
    When user enters staging information in Rock Center Production form
      | Staging | Carpentry | Lighting | Props | Describe Staging Needs |
      | Yes     | yes       | yes      | yes   | test/tesr/test/test    |
    When user enters TPMorTM information in Rock Center Production form
      | TPM or TM |
      | Magesh    |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    ##################################################################################################
    And verify submitted "<Form Name>" is present in my request page with "NEW" status
    And verify "background color" of "NEW" status is "Pink" in my request page
    When user searches request in my request page
    And user click edit link of the request in "My Request page"
    ############################ user adding notes as requester ############################
    When user verifies logs are displaying in Log section
    When user click "Notes" tab in request form page
    And user enters add notes details in Notes section
      | Notes Info       |
      | testr requester |
    And validate Notes added by "Requester"
    And verifies "Requester" able to edits the Notes with new text "Updated Test Requester"
    And user clicks on "save" button
    And user clicks on "Ok" button
    And verify submitted "<Form Name>" is present in my request page with "MODIFIED" status
    And verify "background color" of "MODIFIED" status is "Orange" in my request page
    When user clicks on "NBCU Logo" button
    And user logs out from application
    ########################### user logging in as fulfiller and modifying the form request ############################
    Given user opens producer dashboard application
    And user logins with "fulfiller" role
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    And user click edit link of the request in "fulfiller page"
    ############################ user adding notes as fulfiller ############################
    When user click "Notes" tab in request form page
    And validate Notes updated by "Requester" from fulfiller end
    And user enters add notes details in Notes section
      | Notes Info       |
      | testr fulfiller |
    And validate Notes added by "Fulfillment"
    And verifies "Fulfillment" able to edits the Notes with new text "Updated Test Fulfiller"
    And user clicks on "save" button
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "MODIFIED" status
    
    Examples: 
      | Form Name   |
      | Rock Center |
      
  

      
       @RockCenterProductionRequest_e2e @SEVERITY=CRITICAL @StudioE2E @EMailDLsRockCenter 
    Scenario Outline: Email TO & CC DL Validations with E2E workflow for Rock center production request form
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in Rock Center Production form
      | Division | Additional Requesters | Talent              |
      | MSNBC    | Solai-Magesh    | test/tesr/test/test |
    When user enters Request For info in Rock Center Production form
      | Request For          | Details and Notes   |
      | Additional Live Show | test/tesr/test/test |
    When user enters show information in Rock Center Production form
      | Air Platform     | Show or Project Name | Start Date    | Prep Start Time | Start Time    | End Time      |
      | Video Conference | 7S Tour Studio       | CurrentDate+3 | CurrentTime+3   | CurrentTime+3 | CurrentTime+3 |
    When user enters set location information in Rock Center Production form
      | Location    | Set Location |
      | LA          | Newsroom Set |
    When user enters set crew information in Rock Center Production form
      | Set Crew |
      | Hair Stylist      |
    When user enters control room information in Rock Center Production form
      | Control Room Location | Control Room |
      | DC                    | Ground Control        |
    When user enters control room crew information in Rock Center Production form
      | Capture Manager | Control Room Crew |
      | Yes             | A1                |
    When user enters additional crew information in Rock Center Production form
      | Additional Crew |
      | Studio Maintenance        |
    When user enters system information in Rock Center Production form
      | Ultimatte | Voice Activated Prompter | Notes               |
      |         2 |                        1 | test/tesr/test/test |
    When user enters staging information in Rock Center Production form
      | Staging | Carpentry | Lighting | Props | Describe Staging Needs |
      | Yes     | yes       | yes      | yes   | test/tesr/test/test    |
    When user enters TPMorTM information in Rock Center Production form
      | TPM or TM |
      | Magesh    |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
   	Then validate recieved email notification for status "New"
    Then validate "ToList" in the recieved email
    Then validate "CcList" in the recieved email
    ##################################################################################################
    And verify submitted "<Form Name>" is present in my request page with "NEW" status
    And verify "background color" of "NEW" status is "Pink" in my request page
    When user searches request in my request page
    And user click edit link of the request in "My Request page"
    ########################### user adding notes as requester ############################
    When user verifies logs are displaying in Log section
    When user click "Notes" tab in request form page
    And user enters add notes details in Notes section
      | Notes Info       |
      | testr  requester |
    And user clicks on "save" button
    And verify submitted "<Form Name>" is present in my request page with "MODIFIED" status
    And verify "background color" of "MODIFIED" status is "Orange" in my request page
    When user clicks on "NBCU Logo" button
    Then validate recieved email notification for status "MODIFIED"
    Then validate "ToList" in the recieved email
    Then validate "CcList" in the recieved email
    And user logs out from application
     ########################### user logging in as fulfiller and modifying the form request ############################
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
    When user clicks on "save" button
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "MODIFIED" status
    And verify "background color" of "MODIFIED" status is "Orange" in fullfiller dashboard
     ########################### Acknowledged the form request ############################
    And user click edit link of the request in "fulfiller page"
    When user verifies logs are displaying in Log section
    When user click "Status" tab in request form page
    When user changes status to "Acknowledged"
    When user clicks on "save" button
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "WORKING" status
    And verify "background color" of "WORKING" status is "Blue" in fullfiller dashboard
     Then validate recieved email notification for status "WORKING"
    Then validate "ToList" in the recieved email for "WORKING" status
    Then validate "CcList" in the recieved email for "WORKING" status
     ########################### Technical the form request ############################
    And user click edit link of the request in "fulfiller page"
    When user verifies logs are displaying in Log section
    When user click "Status" tab in request form page
    When user changes status to "Technical"
     ########################### DC Fulfillment the form request ############################
    When user changes status to "DC Fulfillment"
    
     ########################### LA Fulfillment the form request ############################
    When user changes status to "LA Fulfillment"
    
      ########################### Hair, Makeup & Wardrobe the form request ############################
    When user changes status to "Hair, Makeup & Wardrobe"
    
    ########################### Staging the form request ############################
    When user changes status to "Staging"
    ########################### TM/TPM the form request ############################
    When user changes status to "TM/TPM"
    When user clicks on "save" button
    And user opens fulfiller dashboard for "<Form Name>" form
    Then user clicks "Fulfilled" requests dropdown in Production Dashboard
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "FULFILLED" status
    And verify "background color" of "FULFILLED" status is "Green" in fullfiller dashboard
     Then validate recieved email notification for status "FULFILLED"
    Then validate "ToList" in the recieved email for "FULFILLED" status
    Then validate "CcList" in the recieved email for "FULFILLED" status
    And user logs out from application
    ########################### user logging in as producer and modifying the request  ############################
    Given user opens producer dashboard application
    And user logins with "producer" role
    When user searches request in my request page
    And user click edit link of the request in "My Request page"
    When user verifies logs are displaying in Log section
    When user enters show information in Rock Center Production form
      | Air Platform     | Show or Project Name | Start Date | Prep Start Time | Start Time | End Time |
      | Video Conference |                      |            |                 |            |          |
    When user clicks on "save" button
    And verify submitted "<Form Name>" is present in my request page with "MODIFIED" status
    And verify "background color" of "MODIFIED" status is "Orange" in my request page
     Then validate recieved email notification for status "MODIFIED"
    Then validate "ToList" in the recieved email
    Then validate "CcList" in the recieved email
    When user clicks on "NBCU Logo" button
    ########################### user submitting cancel request ############################
    When user searches request in my request page
    Then user click on request ID link of the request
    When user verifies logs are displaying in Log section
    When user clicks on "cancel request" button
    And verify "cancel request" alert message
      | Cancel Request Alert Message                                                                                               |
      | Are you sure you want to cancel this request? All cancellations are pending until confirmed by fulfillment teams |
    And click "Yes" on "cancel request" alert message
    Then verify request is "Cancellation Requested" successfully
    When user clicks on "NBCU Logo" button
    And verify submitted "<Form Name>" is present in my request page with "CONFIRM CANCELLATION" status
    And verify "background color" of "CONFIRM CANCELLATION" status is "Grey" in my request page
    Then validate recieved email notification for status "CONFIRM CANCELLATION"
    Then validate "ToList" in the recieved email
    Then validate "CcList" in the recieved email
    And user logs out from application
    ########################### user logging in as fulfiller and cancelled the form request ############################
    Given user opens producer dashboard application
    And user logins with "fulfiller" role
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "CONFIRM CANCELLATION" status
    And verify "background color" of "CONFIRM CANCELLATION" status is "Grey" in fullfiller dashboard
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
    Then user click on request ID link of the request
    When user verifies logs are displaying in Log section
    Then validate recieved email notification for status "CANCELLED"
    Then validate "ToList" in the recieved email
    Then validate "CcList" in the recieved email
     And user logs out from application
    
     Examples: 
      | Form Name   |
      | Rock Center |
      