@NcxUnifiedToolPhase2 @ProducerDashboard @UserStoryWise
Feature: NCX Unified Tool Phase 2: Requester view Production Request edit state Reskin

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role

     @PSEQA @NcxUnifiedToolPhase2 @PSEQA-6195
   Scenario Outline: TC_001_StudioForm_NRT_11911_Verify adding a note in the notes section for all the request except animals and firearms.
   And user clicks on forms link
   And user selects "<Form Name>" form
   When user selects division from the dropdown under general details section
   |Division|
   |Corporate|
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
    | Capture Manager | Control Room Crew 				|
    | Yes             | CR Audio Assist - Tx      |
   When user enters adds additional crew in Rock Center Production form
      | Additional Crew 			|
      | Lighting Director     |
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
   Then user verifies absence of status tab
   When user adds note to the Add Notes section on fulfiller tab
   |Add Notes|
   |Sample Note for automation|
   And user clicks on "SAVE" button
   And user clicks on "ok" button
   When user searches request in my request page
   Then user verifies status of the request
   When user searches request in my request page
   And user click edit link of the request in "Rock Center Production"
   Then user verifies "revisedNote" has "revision highlight" present in "GOLD" color
   Then user edit added note
   |Edit Note|
   |Edited note for automation|
   Then user verifies the note is updated
   	|Edit Note|
   	|Edited note for automation|
   And user clicks on "SAVE" button
   And user clicks on "ok" button
   When user searches request in my request page
   And user click edit link of the request in "Rock Center Production"
   When user delete added note
   Then user verifies note is deleted
     Examples: 
      | Form Name   |
      | Rock Center |
      
   @NcxUnifiedToolPhase2 @PSEQA @PSEQA-6042
    Scenario Outline: TC_001_StudioForm_NRT_11911_Verify adding a note in the notes section for all the request except animals and firearms.
    And user clicks on forms link
    And user selects "<Form Name>" form
    When user selects division from the dropdown under general details section
   	|Division|
   	|Corporate|
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
   	Then user verifies the request is in edit state
   Then user verifies all the buttons are present on the request
   Then user verifies absence of status tab
   When user adds note to the Add Notes section on fulfiller tab
   |Add Notes|
   |Sample Note for automation|
   And user clicks on "SAVE" button
   And user clicks on "ok" button
   When user searches request in my request page
   And user click edit link of the request in "Rock Center Production"
   Then user verifies the request is in edit state
   Then user verifies all the buttons are present on the request
   Then user verifies "revisedNote" has "revision highlight" present in "GOLD" color
   Then user edit added note
   |Edit Note|
   |Edited note for automation|
   Then user verifies the note is updated
   	|Edit Note|
   	|Edited note for automation|
   And user clicks on "SAVE" button
   And user clicks on "ok" button
   When user searches request in my request page
   And user click edit link of the request in "Rock Center Production"
   When user delete added note
   Then user verifies note is deleted
     Examples: 
      | Form Name   						|
      | Single Camera Live Shot |
      
   @NcxUnifiedToolPhase2 @PSEQA @PSEQA-6043
  Scenario Outline: TC_001_StudioForm_NRT_11911_Verify adding a note in the notes section for all the request except animals and firearms.
  	And user clicks on forms link
  	And user selects "<Form Name>" form
  	When user selects division from the dropdown under general details section
   	|Division|
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
   	Then user verifies the request is in edit state
   	Then user verifies all the buttons are present on the request
   	Then user verifies absence of status tab
   	When user adds note to the Add Notes section on fulfiller tab
   	|Add Notes|
   	|Sample Note for automation|
   	And user clicks on "SAVE" button
   	And user clicks on "ok" button
   	When user searches request in my request page
   And user click edit link of the request in "Rock Center Production"
   Then user verifies the request is in edit state
   Then user verifies all the buttons are present on the request
   Then user verifies "revisedNote" has "revision highlight" present in "GOLD" color
   Then user edit added note
   |Edit Note|
   |Edited note for automation|
   Then user verifies the note is updated
   	|Edit Note|
   	|Edited note for automation|
   And user clicks on "SAVE" button
   And user clicks on "ok" button
   When user searches request in my request page
   And user click edit link of the request in "Rock Center Production"
   When user delete added note
   Then user verifies note is deleted
     Examples: 
      | Form Name  |
      | CNBC       |
      
  @NcxUnifiedToolPhase2 @PSEQA @PSEQA_6044
  Scenario Outline: TC_001_StudioForm_NRT_11911_Verify adding a note in the notes section for all the request except animals and firearms.
  	And  user clicks on forms link
  	And  user selects "<Form Name>" form
  When user selects division from the dropdown under general details section
   	|Division|
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
   	Then user verifies the request is in edit state
   	Then user verifies all the buttons are present on the request
   	Then user verifies absence of status tab
   	When user adds note to the Add Notes section on fulfiller tab
   	|Add Notes|
   	|Sample Note for automation|
   	And user clicks on "SAVE" button
   	And user clicks on "ok" button
   	When user searches request in my request page
   	And user click edit link of the request in "Rock Center Production"
   	Then user verifies the request is in edit state
   	Then user verifies all the buttons are present on the request
   	Then user verifies "revisedNote" has "revision highlight" present in "GOLD" color
   	When user edit added note
   	|Edit Note|
   	|Edited note for automation|
   	Then user verifies the note is updated
   	|Edit Note|
   	|Edited note for automation|
   	And user clicks on "SAVE" button
   	And user clicks on "ok" button
   	When user searches request in my request page
   	And user click edit link of the request in "Rock Center Production"
   	When user delete added note
   	Then user verifies note is deleted
  	Examples:
    				|Form Name                         |
    				|Extend or Bridge Crew & Facilities|
    				
    				
   @PSEQA @NcxUnifiedToolPhase2 @PSEQA-6051
   Scenario Outline: TC_004_StudioForm_NRT_11911_Verify presence of log tab for all the request except animals and firearms.
   And user clicks on forms link
   And user selects "<Form Name>" form
   When user selects division from the dropdown under general details section
   |Division|
   |Corporate|
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
    | Yes             | A1                |
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
   Then user verifies status "NEW" under log tab
   When user adds note to the Add Notes section on fulfiller tab
   	|Add Notes|
   	|Sample Note for automation|
   	And user clicks on "SAVE" button
   	And user clicks on "ok" button
   	When user searches request in my request page
   And user click edit link of the request in "Rock Center Production"
   Then user verifies the request is in edit state
   Then user verifies status "MODIFIED" under log tab
   Then user verifies details displayed under log tab
   Examples: 
      | Form Name   |
      | Rock Center |    			
   
   @NcxUnifiedToolPhase2 @PSEQA @PSEQA-6042
    Scenario Outline: TC_004_StudioForm_NRT_11911_Verify presence of log tab for all the request except animals and firearms.
    And user clicks on forms link
    And user selects "<Form Name>" form
    When user selects division from the dropdown under general details section
   	|Division|
   	|Corporate|
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
   	Then user verifies the request is in edit state
   Then user verifies all the buttons are present on the request
   Then user verifies status "NEW" under log tab
   When user adds note to the Add Notes section on fulfiller tab
   |Add Notes|
   |Sample Note for automation|
   And user clicks on "SAVE" button
   And user clicks on "ok" button
   When user searches request in my request page
   And user click edit link of the request in "Rock Center Production"
   Then user verifies the request is in edit state
   Then user verifies status "MODIFIED" under log tab
   Then user verifies details displayed under log tab
     Examples: 
      | Form Name   						|
      | Single Camera Live Shot |
      
   @NcxUnifiedToolPhase2 @PSEQA @PSEQA-6056
  Scenario Outline: TC_004_StudioForm_NRT_11911_Verify presence of log tab for all the request except animals and firearms.
  	And user clicks on forms link
  	And user selects "<Form Name>" form
  	When user selects division from the dropdown under general details section
   	|Division|
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
   	Then user verifies the request is in edit state
   	Then user verifies all the buttons are present on the request
   	Then user verifies status "NEW" under log tab
   	When user adds note to the Add Notes section on fulfiller tab
   	|Add Notes|
   	|Sample Note for automation|
   	And user clicks on "SAVE" button
   	And user clicks on "ok" button
   	When user searches request in my request page
   	And user click edit link of the request in "Rock Center Production"
   	Then user verifies the request is in edit state
   	Then user verifies status "MODIFIED" under log tab
   	Then user verifies details displayed under log tab
     Examples: 
      | Form Name  |
      | CNBC       |
      
  @NcxUnifiedToolPhase2 @PSEQA @PSEQA_6044
  Scenario Outline: TC_004_StudioForm_NRT_11911_Verify presence of log tab for all the request except animals and firearms.
  	And  user clicks on forms link
  	And  user selects "<Form Name>" form
  When user selects division from the dropdown under general details section
   	|Division|
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
   	Then user verifies the request is in edit state
   	Then user verifies all the buttons are present on the request
   	Then user verifies status "NEW" under log tab
   	When user adds note to the Add Notes section on fulfiller tab
   	|Add Notes|
   	|Sample Note for automation|
   	And user clicks on "SAVE" button
   	And user clicks on "ok" button
   	When user searches request in my request page
   	And user click edit link of the request in "Rock Center Production"
   	Then user verifies the request is in edit state
   	Then user verifies status "MODIFIED" under log tab
   	Then user verifies details displayed under log tab
  	Examples:
    				|Form Name                         |
    				|Extend or Bridge Crew & Facilities|	
    				
    				
   @NcxUnifiedToolPhase2 @PSEQA @PSEQA-6200
   Scenario Outline: TC_006_StudioForm_NRT_11911_Verify editability in case of animals and firearms on premise type of request.			
   	And user clicks on forms link
    And user selects "<Form Name>" form
    When user selects division from the dropdown under general details section
   	|Division|
   	|Corporate|
   #	When user add additional requester in requester section
   #	|Additional Requesters|
   #	|Bambani-Jeevanandham|
   	When user add specific user in Talent section
    |First Name | Last Name | 
    |Bosa       | Deirdre   |
    When user enters show information in Animals on Premises Production form
      | Air Platform | Show or Project Name | Arrival Date  | Arrival Time  | Departure Date | Departure Time |
      | OTT          | 7S Tour Studio       | CurrentDate+3 | CurrentTime+3 | CurrentDate+8  | CurrentTime+3  |
    When user enters set location information in Animals on Premises Production Form
      | Location    | Set Location |
      | Rock Center | 3A VR        |
    When user enters Handlers information for Animals on Premises Production form
      | Handlers Name   | Handlers Email                  | Handlers Phone |
      | Testing-Testing | test@nbcuni.com |     							3254354364 |
    When user enters Animals information for Animals on Premises Production form
      | Animal Type    | Animal Weight | Animal HowMany | Animal Handler  |
      | testing animal | 100-200 lbs   |              5 | Testing-Testing |
    When user enters details information in Animals on Premises Production form
      | Details and Notes   |
      | test |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button				
    When user searches request in my request page	
    And user click edit link of the request in "Rock Center Production"
    Then user verifies absence of edit button
     Examples: 
      | Form Name           |
      | Animals on Premises |
      
@NcxUnifiedToolPhase2 @PSEQA @PSEQA-6200
  Scenario Outline: TC_006_StudioForm_NRT_11911_Verify editability in case of animals and firearms on premise type of request.
    And user clicks on forms link
    And user selects "<Form Name>" form
   When user selects division from the dropdown under general details section
   	|Division|
   	|Corporate|
   #	When user add additional requester in requester section
   #	|Additional Requesters|
   #	|Bambani-Jeevanandham|
   	When user add specific user in Talent section
    |First Name | Last Name | 
    |Bosa       | Deirdre   |
    When user enters show information in Firearms on Premises Production form
      | Air Platform | Show or Project Name | Arrival Date  | Arrival Time  | Departure Date | Departure Time |
      | OTT          | 7S Tour Studio       | CurrentDate+3 | CurrentTime+3 | CurrentDate+8  | CurrentTime+3  |
    When user enters set location information in Firearms on Premises Production Form
      | Location    | Set Location |
      | Rock Center | 3A VR        |
    When user enters Firearms information for Firearms on Premises Production form
      | Type Of Firearm     | How Many Firearm | Firearm Type |
      | test								 |               10 | Yes          |
    When user enters details information in Firearms on Premises Production form
      | Details and Notes   |
      | Automation test|
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button      
    When user searches request in my request page	
    And user click edit link of the request in "Rock Center Production"
    Then user verifies absence of edit button
     		Examples: 
      | Form Name           |
      | Firearms on Premises |
      