@ExtendOrBridgeCrewFacilitiesProductionRequest @ProducerDashboard
Feature: Validate various scenarios related Extend Or Bridge Crew & Facilities production

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role

  @ExtendOrBridgeCrewFacilitiesProductionRequest_Basic_Flow
  Scenario Outline: Verify user filling Extend Or Bridge Crew & Facilities Production Request form
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in Extend or Bridge Crew Production form
      | Division | Additional Requesters | Talent              |
      | MSNBC    | Solai                 | test/tesr/test/test |
    When user enters details information in Extend or Bridge Crew Production form
      | Details and Notes   |
      | test/tesr/test/test |
    When user enters show information in Extend or Bridge Crew Production form
      | Request For | Air Platform | Show or Project Name | Start Date    | Start Time    | End Time      |
      | Extend      | OTT          | 7S Tour Studio       | CurrentDate+3 |  CurrentTime+3 | CurrentTime+3 |
    When user enters set location and crew information in Extend or Bridge Crew Production form
      | Location    | Set Location |
      | Rock Center | 3A VR        |
    When user enters control room and crew information in Extend or Bridge Crew Production form
      | Control Room And Crew Option | Control Room Location | Control Room |
      | Yes                          | Rock Center           | CR 32        |
    When user enters TPMorTM information in Extend or Bridge Crew Production form
      | TPM or TM |
      | Magesh    |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    And user logs out from application

    ########################################################
    Examples: 
      | Form Name                          |
      | Extend or Bridge Crew & Facilities |

  @ExtendOrBridgeCrewFacilitiesProductionRequest_different_divisions
  Scenario Outline: Verify user filling Extend Or Bridge Crew & Facilities Production Request form with different divisions
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in Extend or Bridge Crew Production form
      | Division   | Additional Requesters | Talent              |
      | <Division> | Solai                 | test/tesr/test/test |
    When user enters details information in Extend or Bridge Crew Production form
      | Details and Notes   |
      | test/tesr/test/test |
    When user enters show information in Extend or Bridge Crew Production form
      | Request For | Air Platform | Show or Project Name | Start Date    | Start Time    | End Time      |
      | Extend      | OTT          | 7S Tour Studio       | CurrentDate+3 |  CurrentTime+3 | CurrentTime+3 |
    When user enters set location and crew information in Extend or Bridge Crew Production form
      | Location    | Set Location |
      | Rock Center | 3A VR        |
    When user enters control room and crew information in Extend or Bridge Crew Production form
      | Control Room And Crew Option | Control Room Location | Control Room |
      | Yes                          | Rock Center           | CR 32        |
    When user enters TPMorTM information in Extend or Bridge Crew Production form
      | TPM or TM |
      | Magesh    |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    And user logs out from application

    ########################################################
    Examples: 
      | Form Name                          | Division         |
      | Extend or Bridge Crew & Facilities | NBC News         |
      | Extend or Bridge Crew & Facilities | MSNBC            |
      | Extend or Bridge Crew & Facilities | CNBC             |
      | Extend or Bridge Crew & Facilities | Acorn            |
      | Extend or Bridge Crew & Facilities | Corporate        |
      | Extend or Bridge Crew & Facilities | Engineering      |
      | Extend or Bridge Crew & Facilities | Entertainment    |
      | Extend or Bridge Crew & Facilities | ERG Events       |
      | Extend or Bridge Crew & Facilities | Facilities       |
      | Extend or Bridge Crew & Facilities | NBC News Studios |
      | Extend or Bridge Crew & Facilities | NBC Sports       |
      | Extend or Bridge Crew & Facilities | News Digital     |
      | Extend or Bridge Crew & Facilities | Olympics         |
      | Extend or Bridge Crew & Facilities | Operations       |
      | Extend or Bridge Crew & Facilities | Peacock          |
      | Extend or Bridge Crew & Facilities | Telemundo        |
      | Extend or Bridge Crew & Facilities | Universal Kids   |

  @ExtendOrBridgeCrewFacilitiesProductionRequest_different_divisions_location_controlroom_TPM
  Scenario Outline: Verify user filling Extend Or Bridge Crew & Facilities Production Request form with different divisions,location , TPM
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in Extend or Bridge Crew Production form
      | Division   | Additional Requesters | Talent              |
      | <Division> | Solai                 | test/tesr/test/test |
    When user enters details information in Extend or Bridge Crew Production form
      | Details and Notes   |
      | test/tesr/test/test |
    When user enters show information in Extend or Bridge Crew Production form
      | Request For    | Air Platform   | Show or Project Name | Start Date    |  Start Time    | End Time      |
      | <Request Type> | <Air Platform> | 7S Tour Studio       | CurrentDate+3 |  CurrentTime+3 | CurrentTime+3 |
    When user enters set location and crew information in Extend or Bridge Crew Production form
      | Location   | Set Location   |
      | <Location> | <Set Location> |
    When user enters control room and crew information in Extend or Bridge Crew Production form
      | Control Room And Crew Option | Control Room Location   | Control Room   |
      | Yes                          | <Control Room Location> | <Control Room> |
    When user enters TPMorTM information in Extend or Bridge Crew Production form
      | TPM or TM   |
      | <TPM or TM> |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    And user logs out from application

    ########################################################
    Examples: 
      | Form Name                          | Division         | Air Platform     | Location    | Set Location      | Control Room Location | Control Room   | Request Type | TPM or TM         |
      | Extend or Bridge Crew & Facilities | NBC News         | Broadcast        | Rock Center | 3B Studio         | Rock Center           | CR 1A          | Extend       | Yes               |
      | Extend or Bridge Crew & Facilities | NBC News Studios | OTT              | Field       | testing for hello | Field                 | Ground Control | Bridge       | No                |
      | Extend or Bridge Crew & Facilities | Universal Kids   | Video Conference | Rock Center | 4E Flash          | No Control Room       |                | Extend       | Same as Requester |
      | Extend or Bridge Crew & Facilities | Olympics         | Broadcast        | Rock Center | 3A Studio         | No Control Room       |                | Bridge       | Same as Requester |
      | Extend or Bridge Crew & Facilities | CNBC             | OTT              | Rock Center | 8H Studio         | Rock Center           | CR 1A          | Extend       | Same as Requester |
      
    @ExtendOrBridgeCrewFacilitiesProductionRequest_e2e @SEVERITY=CRITICAL @StudioE2E @NOTES
    Scenario Outline: Validate NOTES section in both Requester and Fulfillment for Extend Or Bridge Crew & Facilities Production Request form
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in Extend or Bridge Crew Production form
      | Division | Additional Requesters | Talent              |
      | MSNBC    | Solai                 | test/tesr/test/test |
    When user enters details information in Extend or Bridge Crew Production form
      | Details and Notes   |
      | test/tesr/test/test |
    When user enters show information in Extend or Bridge Crew Production form
      | Request For | Air Platform | Show or Project Name | Start Date    | Prep Start Time | Start Time    | End Time      |
      | Extend      | OTT          | 7S Tour Studio       | CurrentDate+3 | CurrentTime+3   | CurrentTime+3 | CurrentTime+3 |
    When user enters set location and crew information in Extend or Bridge Crew Production form
      | Location    | Set Location |
      | Rock Center | 3A VR        |
    When user enters control room and crew information in Extend or Bridge Crew Production form
      | Control Room And Crew Option | Control Room Location | Control Room |
      | Yes                          | Rock Center           | CR 32        |
    When user enters TPMorTM information in Extend or Bridge Crew Production form
      | TPM or TM |
      | Magesh    |
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
    When user enters show information in Extend or Bridge Crew Production form
      | Request For | Air Platform | Show or Project Name | Start Date | Prep Start Time | Start Time | End Time |
      |             | Internal     |                      |            |                 |            |          |
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
      | Form Name                          |
      | Extend or Bridge Crew & Facilities |
      
        @ExtendOrBridgeCrewFacilitiesProductionRequest_e2e @SEVERITY=CRITICAL @StudioE2E @EmailDLsExtendOrBridge
  Scenario Outline: Verify user filling Extend Or Bridge Crew & Facilities Production Request form
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in Extend or Bridge Crew Production form
      | Division | Additional Requesters | Talent              |
      | MSNBC    | Solai-Magesh          | test/tesr/test/test |
    When user enters details information in Extend or Bridge Crew Production form
      | Details and Notes   |
      | test/tesr/test/test |
    When user enters show information in Extend or Bridge Crew Production form
      | Request For | Air Platform      | Show or Project Name | Start Date    | Start Time    | End Time      |
      | Extend      | Video Conference  | 7S Tour Studio       | CurrentDate+3 | CurrentTime+3 | CurrentTime+3 |
    When user enters set location and crew information in Extend or Bridge Crew Production form
      | Location    | Set Location        |
      | LA          | Newsroom Set        |
    When user enters control room and crew information in Extend or Bridge Crew Production form
      | Control Room And Crew Option | Control Room Location | Control Room |
      | Yes                          | Rock Center           | CR 32        |
    When user enters TPMorTM information in Extend or Bridge Crew Production form
      | TPM or TM |
      | Magesh    |
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
    When user enters show information in Extend or Bridge Crew Production form
      | Request For | Air Platform | Show or Project Name | Start Date | Start Time | End Time |
      |             | Internal     |                      |            |            |          |
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
    ############################ TM/TPM the form request ############################
    #And user click edit link of the request in "fulfiller page"
    #When user verifies logs are displaying in Log section
    #When user click "Status" tab in request form page
    When user changes status to "LA FULFILLMENT"
     When user changes status to "TM/TPM"
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
    ########################### user logging in as producer and modifying the request  ############################
    Given user opens producer dashboard application
    And user logins with "producer" role
    When user searches request in my request page
    And user click edit link of the request in "My Request page"
    When user verifies logs are displaying in Log section
    When user enters show information in Extend or Bridge Crew Production form
      | Request For | Air Platform     | Show or Project Name | Start Date | Start Time | End Time |
      |             | Video Conference |                      |            |            |          |
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
      | Cancel Request Alert Message                                                                                     |
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
    And user click edit link of the request in "fulfiller page"
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

    Examples: 
      | Form Name                          |
      | Extend or Bridge Crew & Facilities |
      
