@SingleCameraLiveShotFromPlazaProductionRequest @ProducerDashboard
Feature: Single Camera Live Shot From Plaza production request Validation

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role

  @SingleCameraLiveShotFromPlazaProductionRequest_Basic_Flow
  Scenario Outline: Verify user filling Single Camera Live Shot From Plaza production request form
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in Single Camera Live Shot Production form
      | Division | Additional Requesters | Talent              |
      | Acorn    | Solai-Jeevanandham    | test/tesr/test/test |
    When user enters details information in Animals on Premises Production form
      | Details and Notes   |
      | test/tesr/test/test |
    When user enters show information in Single Camera Live Shot Production form
      | Air Platform | Show or Project Name | Start Date    | Prep Start Time | Start Time    | End Time      |
      | OTT          | 7S Tour Studio       | CurrentDate+3 | CurrentTime+5   | CurrentTime+3 | CurrentTime+3 |
    When user enters set information in Single Camera Live Shot Production form
      | Set Background | Set Staging Needed |
      | Greenscreen    | Yes                |
    When user enters set crew in Single Camera Live Shot Production form
      | Capture Manager | Set Crew     |
      | Yes             | HAIR STYLIST |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    And user logs out from application

    ########################################################
    Examples: 
      | Form Name               |
      | Single Camera Live Shot |

  @SingleCameraLiveShotFromPlazaProductionRequest_combination_divisions_airplatform
  Scenario Outline: Verify user filling Single Camera Live Shot From Plaza production request form with different divisions
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in Single Camera Live Shot Production form
      | Division | Additional Requesters | Talent              |
      | Acorn    | Solai-Jeevanandham    | test/tesr/test/test |
    When user enters details information in Animals on Premises Production form
      | Details and Notes   |
      | test/tesr/test/test |
    When user enters show information in Single Camera Live Shot Production form
      | Air Platform | Show or Project Name | Start Date    | Prep Start Time | Start Time    | End Time      |
      | OTT          | 7S Tour Studio       | CurrentDate+3 | CurrentTime+5   | CurrentTime+3 | CurrentTime+3 |
    When user enters set information in Single Camera Live Shot Production form
      | Set Background | Set Staging Needed |
      | Greenscreen    | Yes                |
    When user enters set crew in Single Camera Live Shot Production form
      | Capture Manager | Set Crew     |
      | Yes             | HAIR STYLIST |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    And user logs out from application

    ########################################################
    Examples: 
      | Form Name               | Division         | Air Platform     | Location    | Set Location   |
      | Single Camera Live Shot | NBC News         | Broadcast        | Rock Center | 1A Studio      |
      | Single Camera Live Shot | MSNBC            | Cable            | Rock Center | 1A UP          |
      | Single Camera Live Shot | NBC News Studios | OTT              | Rock Center | 6B Studio      |
      | Single Camera Live Shot | NBC Sports       | Internal         | Rock Center | 3E Flashcam    |
      | Single Camera Live Shot | News Digital     | Video Conference | Rock Center | 3B Studio      |
      | Single Camera Live Shot | Olympics         | Multiple         | Rock Center | 3A Studio      |
      | Single Camera Live Shot | Operations       | Broadcast        | Rock Center | 4E Town Square |
      | Single Camera Live Shot | NBC News Studios | Cable            | Field       | Test           |
      | Single Camera Live Shot | Telemundo        | OTT              | Rock Center | 4E Town Square |
      | Single Camera Live Shot | Universal Kids   | Video Conference | Rock Center | 3B Studio      |
      | Single Camera Live Shot | CNBC             | OTT              | Rock Center | 3A VR          |
      | Single Camera Live Shot | Acorn            | Internal         | Rock Center | 3A West        |
      | Single Camera Live Shot | Corporate        | Video Conference | Rock Center | 6A Studio      |
      | Single Camera Live Shot | Engineering      | Multiple         | Rock Center | AQ             |
      | Single Camera Live Shot | Entertainment    | N/A              | Rock Center | Plaza          |
      | Single Camera Live Shot | ERG Events       | Broadcast        | Rock Center | 8G Studio      |
      | Single Camera Live Shot | Facilities       | Cable            | Rock Center | 8H Studio      |

  @SingleCameraLiveShotFromPlazaProductionRequest_combination_divisions_airplatform_location_ControlRoom_RequestFor_TPM
  Scenario Outline: Verify user filling Single Camera Live Shot From Plaza production request form with different divisions airplatform location ControlRoom Request For
    TPM

    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in Single Camera Live Shot Production form
      | Division | Additional Requesters | Talent              |
      | Acorn    | Solai-Jeevanandham    | test/tesr/test/test |
    When user enters details information in Animals on Premises Production form
      | Details and Notes   |
      | test/tesr/test/test |
    When user enters show information in Single Camera Live Shot Production form
      | Air Platform | Show or Project Name | Start Date    | Prep Start Time | Start Time    | End Time      |
      | OTT          | 7S Tour Studio       | CurrentDate+3 | CurrentTime+5   | CurrentTime+3 | CurrentTime+3 |
    When user enters set information in Single Camera Live Shot Production form
      | Set Background | Set Staging Needed |
      | Greenscreen    | Yes                |
    When user enters set crew in Single Camera Live Shot Production form
      | Capture Manager | Set Crew     |
      | Yes             | HAIR STYLIST |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    And user logs out from application

    ########################################################
    Examples: 
      | Form Name               | Division       | Air Platform | Location    | Set Location      | Control Room Location | Control Room   | Request For    | TPM or TM |
      | Single Camera Live Shot | NBC News       | Broadcast    | Rock Center | 1A Studio         | Rock Center           | CR 1A          | Internal Event | Yes       |
      | Single Camera Live Shot | Universal Kids | OTT          | Field       | testing for hello | DC                    | Ground Control | Bridge Crew    | No        |
      
    @SingleCameraLiveShotFromPlazaProductionRequest_e2e @SEVERITY=CRITICAL @StudioE2E @NOTES
    Scenario Outline: Validate NOTES section in both Requester and Fulfillment for Single Camera Live Shot From Plaza production request form
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in Single Camera Live Shot Production form
      | Division | Additional Requesters | Talent              |
      | Acorn    | solai-Jeevanandham    | test/tesr/test/test |
    When user enters details information in Animals on Premises Production form
      | Details and Notes   |
      | test/tesr/test/test |
    When user enters show information in Single Camera Live Shot Production form
      | Air Platform | Show or Project Name | Start Date    | Prep Start Time | Start Time    | End Time      |
      | OTT          | 7S Tour Studio       | CurrentDate+3 | CurrentTime+5   | CurrentTime+3 | CurrentTime+3 |
    When user enters set information in Single Camera Live Shot Production form
      | Set Background | Set Staging Needed |
      | Greenscreen    | Yes                |
    When user enters set crew in Single Camera Live Shot Production form
      | Capture Manager | Set Crew     |
      | Yes             | HAIR STYLIST |
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
      | testr requester |
    And validate Notes added by "Requester"
    And verifies "Requester" able to edits the Notes with new text "Updated Test Requester"
    And user clicks on "save" button
    And user clicks on "Ok" button
    And verify submitted "<Form Name>" is present in my request page with "MODIFIED" status
    And verify "background color" of "MODIFIED" status is "Orange" in my request page
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
    When user enters show information in Single Camera Live Shot Production form
      | Air Platform | Show or Project Name | Start Date | Prep Start Time | Start Time | End Time |
      | Internal     |                      |            |                 |            |          |
    ############################ user adding notes as fulfiller ############################
    When user click "Notes" tab in request form page
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
      | Form Name               |
      | Single Camera Live Shot |

      @SingleCameraLiveShotFromPlazaProductionRequest_e2e @SEVERITY=CRITICAL @StudioE2E @EmailDLsSCLS
  Scenario Outline: Verify user filling Single Camera Live Shot From Plaza production request form
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in Single Camera Live Shot Production form
      | Division | Additional Requesters | Talent              |
      | MSNBC    | Solai-Magesh          | test/tesr/test/test |
    When user enters details information in Animals on Premises Production form
      | Details and Notes   |
      | test/tesr/test/test |
    When user enters show information in Single Camera Live Shot Production form
      | Air Platform              | Show or Project Name | Start Date    | Prep Start Time | Start Time    | End Time      |
      | Video Conference          | 7S Tour Studio       | CurrentDate+3 | CurrentTime+5   | CurrentTime+3 | CurrentTime+3 |
    When user enters set information in Single Camera Live Shot Production form
      | Set Background | Set Staging Needed |
      | Greenscreen    | Yes                |
    When user enters set crew in Single Camera Live Shot Production form
      | Capture Manager | Set Crew     |
      | Yes             | HAIR STYLIST |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    Then validate recieved email notification for status "New"
    Then validate "ToList" in the recieved email
    Then validate "CcList" in the recieved email
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
    When user clicks on "NBCU Logo" button
    Then validate recieved email notification for status "MODIFIED"
    Then validate "ToList" in the recieved email
    Then validate "CcList" in the recieved email
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
    When user enters show information in Single Camera Live Shot Production form
      | Air Platform | Show or Project Name | Start Date | Prep Start Time | Start Time | End Time |
      | Internal     |                      |            |                 |            |          |
    ############################ user adding notes as fulfiller ############################
    When user click "Notes" tab in request form page
    And user enters add notes details in Notes section
      | Notes Info       |
      | testr  fulfiller |
    When user clicks on "save request" button
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "MODIFIED" status
    And verify "background color" of "MODIFIED" status is "Orange" in fullfiller dashboard
    ############################ Acknowledged the form request ############################
    And user click edit link of the request in "fulfiller page"
    When user verifies logs are displaying in Log section
    When user click "Status" tab in request form page
    When user changes status to "Acknowledged"
    When user clicks on "save request" button
    And user opens fulfiller dashboard for "<Form Name>" form
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "WORKING" status
    And verify "background color" of "WORKING" status is "Blue" in fullfiller dashboard
     Then validate recieved email notification for status "WORKING"
    Then validate "ToList" in the recieved email for "WORKING" status
    Then validate "CcList" in the recieved email for "WORKING" status
    ############################ Technical the form request ############################
    And user click edit link of the request in "fulfiller page"
    When user verifies logs are displaying in Log section
    When user click "Status" tab in request form page
    When user changes status to "Technical"
    #When user clicks on "save request" button
    #And user opens fulfiller dashboard for "<Form Name>" form
    #When user searches request in fulfiller dashboard
    #Then verify "<Form Name>" is present in fulfiller dashboard with "WORKING" status
    #And verify "background color" of "WORKING" status is "Blue" in fullfiller dashboard
    ############################ Staging the form request ############################
    #And user click edit link of the request in "fulfiller page"
    #When user verifies logs are displaying in Log section
    When user click "Status" tab in request form page
    When user changes status to "Staging"
    #When user clicks on "save request" button
    #And user opens fulfiller dashboard for "<Form Name>" form
    #When user searches request in fulfiller dashboard
    #Then verify "<Form Name>" is present in fulfiller dashboard with "WORKING" status
    #And verify "background color" of "WORKING" status is "Blue" in fullfiller dashboard
     #Then validate recieved email notification for status "WORKING"
    #Then validate "ToList" in the recieved email for "WORKING" status
    #Then validate "CcList" in the recieved email for "WORKING" status
    ############################ Hair, Makeup & Wardrobe the form request ############################
    #And user click edit link of the request in "fulfiller page"
    #When user verifies logs are displaying in Log section
    When user click "Status" tab in request form page
    When user changes status to "Hair, Makeup & Wardrobe"
    When user clicks on "save request" button
    And user opens fulfiller dashboard for "<Form Name>" form
    Then user clicks "Fulfilled" requests dropdown in Production Dashboard
    When user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "FULFILLED" status
    And verify "background color" of "FULFILLED" status is "Green" in fullfiller dashboard
     Then validate recieved email notification for status "FULFILLED"
    Then validate "ToList" in the recieved email for "FULFILLED" status
    Then validate "CcList" in the recieved email for "FULFILLED" status
    And user logs out from application
    ############################ user logging in as producer and modifying the request  ############################
    Given user opens producer dashboard application
    And user logins with "producer" role
    When user searches request in my request page
    And user click edit link of the request in "My Request page"
    When user verifies logs are displaying in Log section
    When user enters show information in Single Camera Live Shot Production form
      | Air Platform     | Show or Project Name | Start Date | Prep Start Time | Start Time | End Time |
      | Video Conference |                      |            |                 |            |          |
    When user clicks on "save request" button
    And verify submitted "<Form Name>" is present in my request page with "MODIFIED" status
    And verify "background color" of "MODIFIED" status is "Orange" in my request page
    Then validate recieved email notification for status "MODIFIED"
    Then validate "ToList" in the recieved email
    Then validate "CcList" in the recieved email
    When user clicks on "NBCU Logo" button
    ############################ user submitting cancel request ############################
    When user searches request in my request page
    Then user click on request ID link of the request
    When user verifies logs are displaying in Log section
    When user clicks on "cancel request" button
    And verify "cancel request" alert message
      | Cancel Request Alert Message                                                                                               |
      | Are you sure you want to cancel this request? All cancellations are pending until confirmed by fulfillment teams |
    And click "yes" on "cancel request" alert message
    Then verify request is "Cancellation Requested" successfully
    When user clicks on "NBCU Logo" button
    And verify submitted "<Form Name>" is present in my request page with "CONFIRM CANCELLATION" status
    And verify "background color" of "CONFIRM CANCELLATION" status is "Grey" in my request page
    Then validate recieved email notification for status "CONFIRM CANCELLATION"
    Then validate "ToList" in the recieved email
    Then validate "CcList" in the recieved email
    And user logs out from application
    ############################ user logging in as fulfiller and cancelled the form request ############################
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
    And click "yes" on "confirm cancellation" alert message
    Then verify request is "Cancelled" successfully
    When user clicks on "NBCU Logo" button
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

    ########################################################
    Examples: 
      | Form Name               |
      | Single Camera Live Shot |