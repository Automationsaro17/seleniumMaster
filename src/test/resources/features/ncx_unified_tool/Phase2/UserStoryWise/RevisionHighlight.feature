@NcxUnifiedToolPhase2 @ProducerDashboard @UserStoryWise
Feature: NCX Unified Tool Phase 2: Requester view Production Request edit state Reskin

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role
    
   @PSEQA @NcxUnifiedToolPhase2
   Scenario Outline: TC_009_StudioForm_NRT_11911_Verify presence of revision highlight for fields under rock center request
   And user clicks on forms link
   And user selects "<Form Name>" form
   When user selects division from the dropdown under general details section
   |Slug   |NCX Story Name 	|Division    |
   |Test   |   					|Corporate|
   #When user add additional requester in requester section
   #	|Additional Requesters|
   #	|Bambani-Jeevanandham|
   When user add specific user in Talent section
    |First Name | Last Name | 
    |Bosa       | Deirdre   |
   Then user enters Request For info in Rock Center Production form
    | Request For          | Details and Notes   |
    | Pretape Full Show | Automation Details for rock center show |
   When user enters show information in Rock Center Production form
      | Air Platform | Show or Project Name | Start Date    | Prep Start Time | Start Time    | End Time      |
      | OTT          | 7S Tour Studio       | CurrentDate+3 | CurrentTime+3   | CurrentTime+3 | CurrentTime+3 |
   When user enters set location information in Rock Center Production form
      | Location    | Set Location |
      | Rock Center | 3A VR        |
   When user enters set crew information in Rock Center Production form
      | Set Crew 				|
      | JIB  	|
   When user enters control room details in Rock Center Production form
    	| Control Room Location    | Control Room		|
    	| Rock Center 						 |  Any Available Control Room					|
   When user enters control room crew information in Rock Center Production form
    | Capture Manager | Control Room Crew |
    | Yes             | CR Audio Assist - Tx                |
   When user enters adds additional crew in Rock Center Production form
      | Additional Crew |
      | VIDEO OP     |
   When user enters system information in Rock Center Production form
      | Ultimatte | Voice Activated Prompter |
      |         2 |                        1 |
   When user enters staging information in Rock Center Production form
      | Staging | Carpentry | Lighting | Props | Describe Staging Needs |
      | Yes     | yes       | yes      | yes   | test Sample    				|
   When user enters TPMorTM information in Rock Center Production form
      | TPM or TM |
      | Same as requester    |
   And user clicks on "Submit" button
   Then user get the Request ID with Request Type from Success message
   And user clicks on "ok" button
   When user searches request in my request page
   And user click edit link of the request in "Rock Center Production"
   Then user verifies the request is in edit state
   Then user verifies all the buttons are present on the request
   Then user enters Request For info in Rock Center Production form
    | Request For          | Details and Notes   |
    | Internal Event 			| Updated automation Details for rock center show |
   And user clicks on "SAVE" button
   And user clicks on "ok" button
   When user searches request in my request page
   And user click edit link of the request in "Rock Center Production"
   Then user verifies "revisedPurpose" has "revision highlight" present in "GOLD" color
   | Request For          | Details and Notes   |
   | Internal Event 			| Updated automation Details for rock center show |
   And user clicks on "SAVE" button
   And user clicks on "ok" button
   When user searches request in my request page
   And user click edit link of the request in "Rock Center Production"
   When user enters show information in Rock Center Production form
      | Air Platform | Show or Project Name | Start Date    | Prep Start Time | Start Time    | End Time      |
      | Broadcast          | ACCESS HOLLYWOOD       | CurrentDate+6 | CurrentTime+4   | CurrentTime+5 | CurrentTime+7 |
   And user clicks on "SAVE" button
   And user clicks on "ok" button
   When user searches request in my request page
   And user click edit link of the request in "Rock Center Production"
   Then user verifies "revisedShowInfo" has "revision highlight" present in "GOLD" color
   | Air Platform | Show or Project Name | Start Date    | Prep Start Time | Start Time    | End Time      |
   | Broadcast          | ACCESS HOLLYWOOD       | CurrentDate+6 | CurrentTime+4   | CurrentTime+5 | CurrentTime+7 |
   And user clicks on "SAVE" button
   And user clicks on "ok" button
   When user searches request in my request page
   And user click edit link of the request in "Rock Center Production"
   When user enters set location information in Rock Center Production form
      | Location    | Set Location |
      | DC 					| 1A Studio        |
   And user clicks on "SAVE" button
   And user clicks on "ok" button
   When user searches request in my request page
   And user click edit link of the request in "Rock Center Production"
   Then user verifies "revisedSetLocation" has "revision highlight" present in "GOLD" color
   | Location    | Set Location |
   | DC 					| 1A Studio        |
   And user clicks on "SAVE" button
   And user clicks on "ok" button
   When user searches request in my request page
   And user click edit link of the request in "Rock Center Production"
   When user enters set crew information in Rock Center Production form
      | Set Crew 				|
      | Stage Manager  	|
   #And user clicks on "SAVE" button
   #And user clicks on "ok" button
   #When user searches request in my request page
   #And user click edit link of the request in "Rock Center Production"
   #Then user verifies "revisedSetCrew" has "revision highlight" present in "GOLD" color
   #| Set Crew 				|
   #| Stage Manager  	|
   And user clicks on "SAVE" button
   And user clicks on "ok" button
   When user searches request in my request page
   And user click edit link of the request in "Rock Center Production"
   When user enters control room details in Rock Center Production form
    	| Control Room Location    | Control Room		        |
    	| DC 						 					 | Ground Control					|
   And user clicks on "SAVE" button
   And user clicks on "ok" button
   When user searches request in my request page
   And user click edit link of the request in "Rock Center Production"
   Then user verifies "revisedControlRoom" has "revision highlight" present in "GOLD" color
   | Control Room Location    | Control Room		        |
   | DC 						 					 | Ground Control					|
   And user clicks on "SAVE" button
   And user clicks on "ok" button
   When user searches request in my request page
   And user click edit link of the request in "Rock Center Production"
   When user enters control room crew information in Rock Center Production form
    | Capture Manager | Control Room Crew           |
    | No             |  GFX PB Op L3                |
   And user clicks on "SAVE" button
   And user clicks on "ok" button
   When user searches request in my request page
   And user click edit link of the request in "Rock Center Production"
   Then user verifies "revisedControlRoomCrew" has "revision highlight" present in "GOLD" color
   | Capture Manager | Control Room Crew           |
   | No             |  GFX PB Op L3                |
   #And user clicks on "SAVE" button
   #And user clicks on "ok" button
   #When user searches request in my request page
   #And user click edit link of the request in "Rock Center Production"
   #When user enters adds additional crew in Rock Center Production form
      #| Additional Crew |
      #| Robo Cam     |
   #And user clicks on "SAVE" button
   #And user clicks on "ok" button
   #When user searches request in my request page
   #And user click edit link of the request in "Rock Center Production"
   #Then user verifies "revisedAdditionalCrew" has "revision highlight" present in "GOLD" color
   #| Additional Crew |
   #| Robo Cam     |
   And user clicks on "SAVE" button
   And user clicks on "ok" button
   When user searches request in my request page
   And user click edit link of the request in "Rock Center Production"
   When user enters system information in Rock Center Production form
      | Ultimatte | Voice Activated Prompter | Notes          |
      | 1					|  3 												| Automation note|
   And user clicks on "SAVE" button
   And user clicks on "ok" button
   When user searches request in my request page
   And user click edit link of the request in "Rock Center Production"
   Then user verifies "revisedSystem" has "revision highlight" present in "GOLD" color
   | Ultimatte | Voice Activated Prompter | Notes          |
   | 1					|  3 												| Automation note|
   And user clicks on "SAVE" button
   And user clicks on "ok" button
   When user searches request in my request page
   And user click edit link of the request in "Rock Center Production"
   When user enters staging information in Rock Center Production form
      | Staging | Carpentry | Lighting | Props | Describe Staging Needs |
      | Yes     | no       | no      | no   | updated test Sample    				|
   And user clicks on "SAVE" button
   And user clicks on "ok" button
   When user searches request in my request page
   And user click edit link of the request in "Rock Center Production"
   Then user verifies "revisedStagingRockCenter" has "revision highlight" present in "GOLD" color
   | Staging | Carpentry | Lighting | Props | Describe Staging Needs |
   | Yes     | no       | no      | no   | updated test Sample    				|
   And user clicks on "SAVE" button
   And user clicks on "ok" button
   When user searches request in my request page
   And user click edit link of the request in "Rock Center Production"
   When user enters TPMorTM information in Rock Center Production form
      | TPM or TM |
      | No    |
   And user clicks on "SAVE" button
   And user clicks on "ok" button
   When user searches request in my request page
   And user click edit link of the request in "Rock Center Production"
   Then user verifies "revisedTpmTmName" has "revision highlight" present in "GOLD" color
    | TPM or TM |
    | No    			|
   Examples: 
      | Form Name   |
      | Rock Center | 
      
      
  @NcxUnifiedToolPhase2 @PSEQA
    Scenario Outline: TC_010_StudioForm_NRT_11911_Verify presence of revision highlight for fields under single camera logn shot request
    And user clicks on forms link
    And user selects "<Form Name>" form
    When user selects division from the dropdown under general details section
   	|Division    |
   	|Corporate		|
   #	When user add additional requester in requester section
   #	|Additional Requesters|
   #	|Bambani-Jeevanandham|
   	When user add specific user in Talent section
    |First Name | Last Name | 
    |Bosa       | Deirdre   |
    When user enters details information in Single Camera Live Shot Production form
      | Details and Notes   |
      | Test Automation Note |
    When user enters show information in Single Camera Live Shot Production form
      | Air Platform | Show or Project Name | Start Date    | Prep Start Time | Start Time    | End Time      |
      | OTT          | 7S Tour Studio       | CurrentDate+3 | CurrentTime+5   | CurrentTime+3 | CurrentTime+3 |
    When user enters set information in Single Camera Live Shot Production form
      | Set Background | Set Staging Needed |
      | NYC Skyline    | Yes                |
    When user enters set crew in Single Camera Live Shot Production form
      | Capture Manager | Set Crew     |
      | Yes             | PROMPTER OP 	|
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    When user searches request in my request page
   	And user click edit link of the request in "Rock Center Production"
   	When user enters details information in Single Camera Live Shot Production form
      | Details and Notes   |
      | Updated Test Automation Note |
   And user clicks on "SAVE" button
   And user clicks on "ok" button
   When user searches request in my request page
   And user click edit link of the request in "Rock Center Production"
   #Then user verifies "revisedDetails" has "revision highlight" present in "GOLD" color
   #| Details and Notes   |
   #| Updated Test Automation Note |
   #And user clicks on "SAVE" button
   #And user clicks on "ok" button
   #When user searches request in my request page
   #And user click edit link of the request in "Rock Center Production"
   When user enters show information in Single Camera Live Shot Production form
      | Air Platform | Show or Project Name 			| Start Date    | Prep Start Time | Start Time    | End Time      |
      | Cable        | Alex Wagner Tonight       	| CurrentDate+7 | CurrentTime+3   | CurrentTime+5 | CurrentTime+6 |	
   And user clicks on "SAVE" button
   And user clicks on "ok" button
   When user searches request in my request page
   And user click edit link of the request in "Rock Center Production"
   Then user verifies "revisedShowInfo" has "revision highlight" present in "GOLD" color
   | Air Platform | Show or Project Name 			| Start Date    | Prep Start Time | Start Time    | End Time      |
   | Cable        | Alex Wagner Tonight       	| CurrentDate+7 | CurrentTime+3   | CurrentTime+5 | CurrentTime+6 |	
   And user clicks on "SAVE" button
   And user clicks on "ok" button
   When user searches request in my request page
   And user click edit link of the request in "Rock Center Production"
   When user enters set information in Single Camera Live Shot Production form
      | Set Background | Set Staging Needed |
      | Greenscreen    | No                |
   And user clicks on "SAVE" button
   And user clicks on "ok" button
   When user searches request in my request page
   And user click edit link of the request in "Rock Center Production"
   Then user verifies "revisedSetInfo" has "revision highlight" present in "GOLD" color
    | Set Background | Set Staging Needed |
    | Greenscreen    | No                |
   And user clicks on "SAVE" button
   And user clicks on "ok" button
   When user searches request in my request page
   And user click edit link of the request in "Rock Center Production" 
   When user enters set crew in Single Camera Live Shot Production form
      | Capture Manager | Set Crew     |
      | No             | Makeup Artist 	|
   And user clicks on "SAVE" button
   And user clicks on "ok" button
   When user searches request in my request page
   And user click edit link of the request in "Rock Center Production"
   Then user verifies "revisedSetCrew" has "revision highlight" present in "GOLD" color
   | Capture Manager | Set Crew     |
   | No             | Makeup Artist 	|
     Examples: 
      | Form Name   						|
      | Single Camera Live Shot |
    
   @NcxUnifiedToolPhase2 @PSEQA
  Scenario Outline: TC_011_StudioForm_NRT_11911_Verify presence of revision highlight for fields under extend or bridge request
  	And  user clicks on forms link
  	And  user selects "<Form Name>" form
  When user selects division from the dropdown under general details section
   	|Division	|
   	|Corporate|
   #	When user add additional requester in requester section
   #	|Additional Requesters|
   #	|Bambani-Jeevanandham|
   	When user add specific user in Talent section
    |First Name | Last Name | 
    |Bosa       | Deirdre   |
   	When user enters details information in Extend or Bridge Crew Production form
      | Details and Notes   |
      | Automation details |
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
      | Same as requester    |
  	And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    When user searches request in my request page
   	And user click edit link of the request in "Rock Center Production"
   	When user enters details information in Extend or Bridge Crew Production form
      | Details and Notes   |
      | Updated Automation details |
   #	And user clicks on "SAVE" button
   #	And user clicks on "ok" button
   #	When user searches request in my request page
   #	And user click edit link of the request in "Rock Center Production"
   #	Then user verifies "revisedDetails" has "revision highlight" present in "GOLD" color
   #	| Details and Notes   |
      #| Updated Automation details |
		And user clicks on "SAVE" button
   	And user clicks on "ok" button
   	When user searches request in my request page
   	And user click edit link of the request in "Rock Center Production"
   	When user enters show information in Extend or Bridge Crew Production form
      | Request For | Air Platform | Show or Project Name | Start Date    | Prep Start Time | Start Time    | End Time      |
      | Bridge      | Multiple     | CNBC EUROPE      		| CurrentDate+5 | CurrentTime+4   | CurrentTime+2 | CurrentTime+1 |
    And user clicks on "SAVE" button
   	And user clicks on "ok" button
   	When user searches request in my request page
   	And user click edit link of the request in "Rock Center Production"
   	Then user verifies "revisedShowInfo" has "revision highlight" present in "GOLD" color
   	| Request For | Air Platform | Show or Project Name | Start Date    | Prep Start Time | Start Time    | End Time      |
    | Bridge      | Multiple     | CNBC EUROPE      		| CurrentDate+5 | CurrentTime+4   | CurrentTime+2 | CurrentTime+1 |
		And user clicks on "SAVE" button
   	And user clicks on "ok" button
   	When user searches request in my request page
   	And user click edit link of the request in "Rock Center Production"
   	When user enters set location and crew information in Extend or Bridge Crew Production form
      | Location    | Set Location 				|
      | LA 					| Flashcam Room       |
    And user clicks on "SAVE" button
   	And user clicks on "ok" button
   	When user searches request in my request page
   	And user click edit link of the request in "Rock Center Production"
   	Then user verifies "revisedSetLocation" has "revision highlight" present in "GOLD" color
   	| Location    | Set Location 				|
    | LA 					| Flashcam Room       |
		And user clicks on "SAVE" button
   	And user clicks on "ok" button
   	When user searches request in my request page
   	And user click edit link of the request in "Rock Center Production"
   	When user enters control room and crew information in Extend or Bridge Crew Production form
      | Control Room And Crew Option | Control Room Location | Control Room |
      | No                          | Rock Center           | 	CR 34       |
    #And user clicks on "SAVE" button
   #	And user clicks on "ok" button
   #	When user searches request in my request page
   #	And user click edit link of the request in "Rock Center Production"
   #	Then user verifies "revisedControlRoom" has "revision highlight" present in "GOLD" color
   #	 |Control Room And Crew Option | Control Room Location | Control Room |
     #| No                          | Rock Center           | 	CR 34       |
		And user clicks on "SAVE" button
   	And user clicks on "ok" button
   	When user searches request in my request page
   	And user click edit link of the request in "Rock Center Production"
   	 When user enters TPMorTM information in Extend or Bridge Crew Production form
      | TPM or TM |
      | No    		|
    And user clicks on "SAVE" button
   	And user clicks on "ok" button
   	When user searches request in my request page
   	And user click edit link of the request in "Rock Center Production"
   	Then user verifies "revisedTpmTmName" has "revision highlight" present in "GOLD" color
   	| TPM or TM |
      | No    		|
  	Examples:
    				|Form Name                         |
    				|Extend or Bridge Crew & Facilities|
    				
  @NcxUnifiedToolPhase2 @PSEQA
  Scenario Outline: TC_012_StudioForm_NRT_11911_Verify presence of revision highlight for fields under CNBC request
  	And user clicks on forms link
  	And user selects "<Form Name>" form
  	When user selects division from the dropdown under general details section
   	|Division	|
   	|Corporate|
   #	When user add additional requester in requester section
   #	|Additional Requesters|
   #	|Bambani-Jeevanandham|
   	When user add specific user in Talent section
    |First Name | Last Name | 
    |Bosa       | Deirdre   |
    When user enters Request For info in CNBC Production form
      | Request For | Details and Notes |
      | Live Show   | Automation details |
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
      | Automation staging needs |
    When user enters control room information in CNBC Production form
      | Control Room Needed | Ingest | Iso | Control Room Crew |
      | Yes                 | No     | Yes | Director          |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    When user searches request in my request page
   	And user click edit link of the request in "Rock Center Production"
   	When user enters Request For info in CNBC Production form
      | Request For | Details and Notes |
      | Rehearsal   | Updated automation details |
   	And user clicks on "SAVE" button
   	And user clicks on "ok" button
   	When user searches request in my request page
   And user click edit link of the request in "Rock Center Production"
   Then user verifies "revisedPurpose" has "revision highlight" present in "GOLD" color
   | Request For | Details and Notes |
   | Rehearsal   | Updated automation details |
   And user clicks on "SAVE" button
   And user clicks on "ok" button
   When user searches request in my request page
   And user click edit link of the request in "Rock Center Production"
   When user enters show information in CNBC Production form
      | Air Platform | Sub Division | Show or Project Name | Start Date    | Call Time     | Start Time    | End Time      |
      | Stream       |              | Squawk Box          | CurrentDate+6 | CurrentTime+4 | CurrentTime+1 | CurrentTime+4 |
   And user clicks on "SAVE" button
   And user clicks on "ok" button
   When user searches request in my request page
   And user click edit link of the request in "Rock Center Production"
   Then user verifies "revisedShowInfo" has "revision highlight" present in "GOLD" color
   | Air Platform | Sub Division | Show or Project Name | Start Date    | Call Time     | Start Time    | End Time      |
   | Stream       |              | Squawk Box          | CurrentDate+6 | CurrentTime+4 | CurrentTime+1 | CurrentTime+4 |
   And user clicks on "SAVE" button
   And user clicks on "ok" button
   When user searches request in my request page
   And user click edit link of the request in "Rock Center Production"
   When user enters set location information in CNBC Production form
      | Location |
      | DC       |
   And user clicks on "SAVE" button
   And user clicks on "ok" button
   When user searches request in my request page
   And user click edit link of the request in "Rock Center Production"
   Then user verifies "revisedSetLocation" has "revision highlight" present in "GOLD" color
   | Location |
   | DC       |
   And user clicks on "SAVE" button
   And user clicks on "ok" button
   When user searches request in my request page
   And user click edit link of the request in "Rock Center Production"
   When user enters set crew information in CNBC Production form
      | Set Crew |
      | Prompter |
   And user clicks on "SAVE" button
   And user clicks on "ok" button
   When user searches request in my request page
   And user click edit link of the request in "Rock Center Production"
   Then user verifies "revisedSetCrew" has "revision highlight" present in "GOLD" color
   | Set Crew |
   | Prompter |
   And user clicks on "SAVE" button
   And user clicks on "ok" button
   When user searches request in my request page
   And user click edit link of the request in "Rock Center Production"
   When user enters staging information in CNBC Production form
      | Staging Needs       |
      | Updated Automation staging needs |
   #And user clicks on "SAVE" button
   #And user clicks on "ok" button
   #When user searches request in my request page
   #And user click edit link of the request in "Rock Center Production"
   #Then user verifies "revisedStagingCNBC" has "revision highlight" present in "GOLD" color
   #| Staging Needs       |
   #| Updated Automation staging needs |
   And user clicks on "SAVE" button
   And user clicks on "ok" button
   When user searches request in my request page
   And user click edit link of the request in "Rock Center Production"
   When user enters control room information in CNBC Production form
      | Control Room Needed | Ingest | Iso | Control Room Crew |
      | Yes                 | Yes     | No | TPS          			|
   And user clicks on "SAVE" button
   And user clicks on "ok" button
   When user searches request in my request page
   And user click edit link of the request in "Rock Center Production"
   Then user verifies "revisedControlRoomCrewCNBC" has "revision highlight" present in "GOLD" color 
   | Control Room Needed | Ingest | Iso | Control Room Crew |
   | Yes                 | Yes     | No | TPS          			|
     Examples: 
      | Form Name  |
      | CNBC       |