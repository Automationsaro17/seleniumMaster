@CNBCProductionRequest @ProducerDashboard
Feature: Validate various scenarios related CNBC production

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role

  @CNBCProductionRequest_Basic_Flow
  Scenario Outline: Verify user filling CNBC production request form
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in CNBC Production form
      | Division | Additional Requesters | Talent              |
      | MSNBC    | Solai                 | test/tesr/test/test |
    When user enters Request For info in CNBC Production form
      | Request For | Details and Notes   |
      | Live Show   | test/tesr/test/test |
    When user enters show information in CNBC Production form
      | Air Platform | Sub Division | Show or Project Name | Start Date    | Call Time     | Start Time    | End Time      |
      | OTT          |              | Power Lunch          | CurrentDate+3 | CurrentTime+3 | CurrentTime+3 | CurrentTime+3 |
    When user enters set location information in CNBC Production form
      | Location |
      | EC       |
    When user enters set crew information in CNBC Production form
      | Set Crew |
      | Flashcam |
    When user enters staging information in CNBC Production form
      | Staging Needs       |
      | Test-test-test-test |
    When user enters control room information in CNBC Production form
      | Control Room Needed | Ingest | Iso | Control Room Crew |
      | Yes                 | No     | Yes | Director          |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    And user logs out from application

    ########################################################
    Examples: 
      | Form Name |
      | CNBC      |

  @CNBCProductionRequest_different_divisions
  Scenario Outline: Verify user filling CNBC production request form with different divisions
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in CNBC Production form
      | Division   | Additional Requesters | Talent              |
      | <Division> | Solai                 | test/tesr/test/test |
    When user enters Request For info in CNBC Production form
      | Request For | Details and Notes   |
      | Live Show   | test/tesr/test/test |
    When user enters show information in CNBC Production form
      | Air Platform | Sub Division | Show or Project Name | Start Date    | Call Time     | Start Time    | End Time      |
      | OTT          |              | Power Lunch          | CurrentDate+3 | CurrentTime+3 | CurrentTime+3 | CurrentTime+3 |
    When user enters set location information in CNBC Production form
      | Location |
      | EC       |
    When user enters set crew information in CNBC Production form
      | Set Crew |
      | Flashcam |
    When user enters staging information in CNBC Production form
      | Staging Needs       |
      | Test-test-test-test |
    When user enters control room information in CNBC Production form
      | Control Room Needed | Ingest | Iso | Control Room Crew |
      | Yes                 | No     | Yes | Director          |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    And user logs out from application

    ########################################################
    Examples: 
      | Form Name | Division         |
      | CNBC      | NBC News         |
      | CNBC      | MSNBC            |
      | CNBC      | CNBC             |
      | CNBC      | Acorn            |
      | CNBC      | Corporate        |
      | CNBC      | Engineering      |
      | CNBC      | Entertainment    |
      | CNBC      | ERG Events       |
      | CNBC      | Facilities       |
      | CNBC      | NBC News Studios |
      | CNBC      | NBC Sports       |
      | CNBC      | News Digital     |
      | CNBC      | Olympics         |
      | CNBC      | Operations       |
      | CNBC      | Peacock          |
      | CNBC      | Telemundo        |
      | CNBC      | Universal Kids   |

  @CNBCProductionRequest_combination_divisions_airplatform_subdivisions
  Scenario Outline: Verify user filling CNBC production request form with different sub divisions and airplatforms
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in CNBC Production form
      | Division   | Additional Requesters | Talent              |
      | <Division> | Solai                 | test/tesr/test/test |
    When user enters Request For info in CNBC Production form
      | Request For | Details and Notes   |
      | Live Show   | test/tesr/test/test |
    When user enters show information in CNBC Production form
      | Air Platform   | Sub Division   | Show or Project Name | Start Date    | Call Time     | Start Time    | End Time      |
      | <Air Platform> | <Sub Division> | Power Lunch          | CurrentDate+3 | CurrentTime+3 | CurrentTime+3 | CurrentTime+3 |
    When user enters set location information in CNBC Production form
      | Location |
      | EC       |
    When user enters set crew information in CNBC Production form
      | Set Crew |
      | Flashcam |
    When user enters staging information in CNBC Production form
      | Staging Needs       |
      | Test-test-test-test |
    When user enters control room information in CNBC Production form
      | Control Room Needed | Ingest | Iso | Control Room Crew |
      | Yes                 | No     | Yes | Director          |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    And user logs out from application

    ########################################################
    Examples: 
      | Form Name | Division       | Air Platform | Sub Division      |
      | CNBC      | Peacock        | Cable        |                   |
      | CNBC      | Telemundo      | OTT          |                   |
      | CNBC      | Universal Kids | Stream       |                   |
      | CNBC      | CNBC           | Broadcast    | CNBC General      |
      | CNBC      | CNBC           | Cable        | CNBC Business Day |
      | CNBC      | CNBC           | OTT          | CNBC Programming  |
      | CNBC      | CNBC           | Internal     | CNBC Long Form    |
      | CNBC      | CNBC           | Stream       | CNBC Events       |
      | CNBC      | CNBC           | Multiple     | CNBC Digital      |
      | CNBC      | CNBC           | Broadcast    | CNBC Promos       |

  @CNBCProductionRequest_combination_divisions_airplatform_subdivisions_productionpurpose_location
  Scenario Outline: Verify user filling CNBC production request form with different production purpose and location
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in CNBC Production form
      | Division   | Additional Requesters | Talent              |
      | <Division> | Solai                 | test/tesr/test/test |
    When user enters Request For info in CNBC Production form
      | Request For   | Details and Notes   |
      | <Request For> | test/tesr/test/test |
    When user enters show information in CNBC Production form
      | Air Platform   | Sub Division   | Show or Project Name | Start Date    | Call Time     | Start Time    | End Time      |
      | <Air Platform> | <Sub Division> | Power Lunch          | CurrentDate+3 | CurrentTime+3 | CurrentTime+3 | CurrentTime+3 |
    When user enters set location information in CNBC Production form
      | Location   |
      | <Location> |
    When user enters set crew information in CNBC Production form
      | Set Crew |
      | Flashcam |
    When user enters staging information in CNBC Production form
      | Staging Needs       |
      | Test-test-test-test |
    When user enters control room information in CNBC Production form
      | Control Room Needed | Ingest | Iso | Control Room Crew |
      | Yes                 | No     | Yes | Director          |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    And user logs out from application

    ########################################################
    Examples: 
      | Form Name | Division       | Air Platform | Sub Division | Request For     | Location | Set Location |
      | CNBC      | Peacock        | Cable        |              | Live Show       | DC       | DC Newsroom  |
      | CNBC      | Telemundo      | OTT          |              | Rehearsal       | DC       | DC Studio    |
      | CNBC      | Universal Kids | Stream       |              | Camera Blocking | EC       | EC Studio A  |
      | CNBC      | CNBC           | Broadcast    | CNBC General | Internal Event  | EC       | EC Lobby     |
      | CNBC      | CNBC           | Multiple     | CNBC Digital | Set Lighting    | Bureau   | Chicago      |
      
    @CNBCProductionRequest_e2e @SEVERITY=CRITICAL @StudioE2E @NOTES
    Scenario Outline: Validate NOTES section in both Requester and Fulfillment for CNBC production request form
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in CNBC Production form
      | Division | Additional Requesters | Talent              |
      | MSNBC    | Solai                 | test/tesr/test/test |
    When user enters Request For info in CNBC Production form
      | Request For | Details and Notes   |
      | Live Show   | test/tesr/test/test |
    When user enters show information in CNBC Production form
      | Air Platform | Sub Division | Show or Project Name | Start Date    | Call Time     | Start Time    | End Time      |
      | OTT          |              | Power Lunch          | CurrentDate+3 | CurrentTime+3 | CurrentTime+3 | CurrentTime+3 |
    When user enters set location information in CNBC Production form
      | Location |
      | EC       |
    When user enters set crew information in CNBC Production form
      | Set Crew |
      | Flashcam |
    When user enters staging information in CNBC Production form
      | Staging Needs       |
      | Test-test-test-test |
    When user enters control room information in CNBC Production form
      | Control Room Needed | Ingest | Iso | Control Room Crew |
      | Yes                 | No     | Yes | Director          |
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
    When user enters show information in CNBC Production form
      | Air Platform | Sub Division | Show or Project Name | Production Purpose | Start Date | Call Time | Start Time | End Time |
      | Internal     |              |                      |                    |            |           |            |          |
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
      | Form Name |
      | CNBC      |

     
      
       @CNBCProductionRequest_e2e @SEVERITY=CRITICAL @StudioE2E @EMailDLsCNBC 
  Scenario Outline: Email TO & CC DL Validations with E2E workflow for CNBC production request form
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in CNBC Production form
      | Division | Additional Requesters | Talent              |
      | MSNBC    | Solai-Magesh          | test/tesr/test/test |
    When user enters Request For info in CNBC Production form
      | Request For | Details and Notes   |
      | Live Show   | test/tesr/test/test |
    When user enters show information in CNBC Production form
      | Air Platform | Sub Division | Show or Project Name | Start Date    | Call Time     | Start Time    | End Time      |
      | OTT          |              | Power Lunch          | CurrentDate+3 | CurrentTime+3 | CurrentTime+3 | CurrentTime+3 |
    When user enters set location information in CNBC Production form
      | Location |
      | EC       |
    When user enters set crew information in CNBC Production form
      | Set Crew |
      | Flashcam |
    When user enters staging information in CNBC Production form
      | Staging Needs       |
      | Test-test-test-test |
    When user enters control room information in CNBC Production form
      | Control Room Needed | Ingest | Iso | Control Room Crew |
      | Yes                 | Yes    | Yes | Director          |
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
    And user clicks on "save request" button
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
    When user enters show information in CNBC Production form
      | Air Platform | Sub Division | Show or Project Name | Production Purpose | Start Date | Call Time | Start Time | End Time |
      | Internal     |              |                      |                    |            |           |            |          |
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
    ############################ PCR the form request ############################
    And user click edit link of the request in "fulfiller page"
    When user verifies logs are displaying in Log section
    When user click "Status" tab in request form page
    When user changes status to "PCR"
    #When user clicks on "save request" button
    #And user opens fulfiller dashboard for "<Form Name>" form
    #When user searches request in fulfiller dashboard
    #Then verify "<Form Name>" is present in fulfiller dashboard with "WORKING" status
    #And verify "background color" of "WORKING" status is "Blue" in fullfiller dashboard
    ############################ Studio the form request ############################
    #And user click edit link of the request in "fulfiller page"
    #When user verifies logs are displaying in Log section
    #When user click "Status" tab in request form page
    When user changes status to "Studio"
    #When user clicks on "save request" button
    #And user opens fulfiller dashboard for "<Form Name>" form
    #When user searches request in fulfiller dashboard
    #Then verify "<Form Name>" is present in fulfiller dashboard with "WORKING" status
    #And verify "background color" of "WORKING" status is "Blue" in fullfiller dashboard
    ############################ Director the form request ############################
    #And user click edit link of the request in "fulfiller page"
    #When user verifies logs are displaying in Log section
    #When user click "Status" tab in request form page
    When user changes status to "Director"
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
    When user enters show information in CNBC Production form
      | Air Platform | Sub Division | Show or Project Name | Production Purpose | Start Date | Call Time | Start Time | End Time |
      | Cable        |              |                      |                    |            |           |            |          |
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
    Then validate "ToList" in the recieved email for "CONFIRM CANCELLATION" status
    Then validate "CcList" in the recieved email for "CONFIRM CANCELLATION" status
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
    And user opens fulfiller dashboard for "<Form Name>" form
    Then user clicks "Fulfilled" requests dropdown in Production Dashboard
    And user searches request in fulfiller dashboard
    Then verify "<Form Name>" is present in fulfiller dashboard with "CANCELLED" status
    And verify "background color" of "CANCELLED" status is "Black" in fullfiller dashboard
    Then user click on request ID link of the request
     Then validate recieved email notification for status "CANCELLED"
    Then validate "ToList" in the recieved email for "CANCELLED" status
    Then validate "CcList" in the recieved email for "CANCELLED" status

    Examples: 
      | Form Name |
      | CNBC      |