@NcxUnifiedToolPhase2 @ProducerDashboard @UserStoryWise
Feature: NCX Unified Tool Phase 2: Rock center Production Request Reskin

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role

  @PSEQA @NcxUnifiedToolPhase2 @PSEQA-6025
  Scenario Outline: TC_025_StudioForm_NRT-11902 Verify that the Rock Center text is displayed at the top of the form 
    And user clicks on forms link
    And user selects "<Form Name>" form
    Then user verifies whether "<Form Name>" is displayed the top of the request
 		Examples: 
      | Form Name   |
      | Rock Center |
      
  @PSEQA @NcxUnifiedToolPhase2 @PSEQA-6099
  Scenario Outline: TC_026_StudioForm_NRT-11902 verify the total number of sub sections and headers of it in the request form
  And user clicks on forms link
  And user selects "<Form Name>" form
  Then user verifies the form sections on Rock Center production form
  Examples: 
      | Form Name   |
      | Rock Center |
  
  @PSEQA @NcxUnifiedToolPhase2 @PSEQA-6025
  Scenario Outline: TC_001_StudioForm_NRT_11902_Default Status verification on the request page.
 	And user clicks on forms link
 	And user selects "<Form Name>" form
	Then user verifies the status on the request is "New"
	Examples: 
      | Form Name   |
      | Rock Center |
      
  @NcxUnifiedToolPhase2 @PSEQA @PSEQA-6080
  	Scenario Outline: TC_023_StudioForm_NRT-11902 General details block field verification.
  	And user clicks on forms link
  	And user selects "<Form Name>" form
    Then user verifies the fields present in "<Section>" section of Rock Center Production form
    Then  user verifies whether "<Section>" section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
    When user selects division from the dropdown under general details section
    |Division|
    |Corporate|
    Then user verifies whether "<section>" section is marked checked when all required fields are filled on "<Form Name>" Production request
    Examples: 
      | Form Name   |Section				|
      | Rock Center |GENERAL DETAILS|
      
   @NcxUnifiedToolPhase2 @PSEQA @PSEQA-6027
  	Scenario Outline: TC_002_StudioForm_NRT_11902_Requesters section verification on request page
  	And user clicks on forms link
  	And user selects "<Form Name>" form
  	Then user verifies whether "<section>" section is marked checked when all required fields are filled on "<Form Name>" Production request
    Then user verifies the fields present in "<Section>" section of Rock Center Production form
   	When user add additional requester in requester section
   	|Additional Requesters|
   	|Bambani-Jeevanandham|
   	Then user verifies additional requester name displayed
   	|Additional Requesters|
   	|Bambani, Mohit-R, Jeevanandham|
   Examples: 
      | Form Name   |Section|
      | Rock Center |REQUESTER(S)|
      
   @NcxUnifiedToolPhase2 @PSEQA @PSEQA-6028
  	Scenario Outline: TC_024_StudioForm_NRT_11902_Talent section verification on request page
   	And user clicks on forms link
  	And user selects "<Form Name>" form
  	Then  user verifies whether "<Section>" section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
    Then user verifies the fields present in "<Section>" section of Rock Center Production form
    When user add specific user in Talent section
    				|First Name | Last Name | 
    				|Bosa       | Deirdre   |
    Then user verifies added talent is displayed in the section
    				|First Name | Last Name | 
    				|Bosa       | Deirdre   |
    Then user verifies whether "<section>" section is marked checked when all required fields are filled on "<Form Name>" Production request
   Examples: 
      | Form Name   |Section|
      | Rock Center |TALENT|	
   
   
   @NcxUnifiedToolPhase2 @PSEQA @PSEQA-6029
  	Scenario Outline: TC_003_StudioForm_NRT_11902_production purpose block details verification
   	And user clicks on forms link
  	And user selects "<Form Name>" form
  	Then  user verifies whether "<Section>" section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
    Then user verifies the fields present in "<Section>" section of Rock Center Production form
    Then user enters Request For info in Rock Center Production form
    | Request For          | Details and Notes   |
    | Pretape Full Show | Automation Details for rock center show |
    Then user verifies whether "<section>" section is marked checked when all required fields are filled on "<Form Name>" Production request
   Examples: 
      | Form Name   |Section|
      | Rock Center |PRODUCTION PURPOSE|
   
   @NcxUnifiedToolPhase2 @PSEQA @PSEQA-6029
  	Scenario Outline: TC_004_StudioForm_NRT_11902_To verify details on show info block.
   	And user clicks on forms link
  	And user selects "<Form Name>" form
  	Then  user verifies whether "<Section>" section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
    Then user verifies the fields present in "<Section>" section of Rock Center Production form
    When user selects division from the dropdown under general details section
    |Division|
    |CNBC|
    Then user verifies the fields present in "<Section>" section of Rock Center Production form
   	When user selects show unit or project name details
   	|Show or Project Name|
   	|Other|
   	Then user verifies the fields present in "<Section>" section of Rock Center Production form
    When user enters show information in Rock Center Production form
    | Air Platform | Show or Project Name | Start Date    | Prep Start Time | Start Time    | End Time      |
    | OTT          | NOW Tonight       		| CurrentDate+3 | CurrentTime+3   | CurrentTime+3 | CurrentTime+3 |
  	Then user verifies whether "<section>" section is marked checked when all required fields are filled on "<Form Name>" Production request
   Examples: 
      | Form Name   |Section	|
      | Rock Center |SHOW INFO|
   
   @NcxUnifiedToolPhase2 @PSEQA @PSEQA-6030
  	Scenario Outline: TC_005_StudioForm_NRT_11902_Set location block verification with different locations.
   	And user clicks on forms link
  	And user selects "<Form Name>" form
  	Then  user verifies whether "<Section>" section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
    When user enters set location information for different location in Rock Center Production form
     | Location    | Set Location 	|Division	|
     | Field 				 |  						|MSNBC		|
    Then user verifies the fields present in "<Section>" section of Rock Center Production form
    Then user verifies whether "<section>" section is marked checked when all required fields are filled on "<Form Name>" Production request
   Examples: 
      | Form Name   |Section|
      | Rock Center |SET LOCATION|
      
     @NcxUnifiedToolPhase2 @PSEQA @PSEQA-6031
  	Scenario Outline: TC_006_StudioForm_NRT_11902_To verify addition of crew under Set crew.
   	And user clicks on forms link
  	And user selects "<Form Name>" form
  	Then  user verifies whether "<Section>" section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
    Then user verifies the fields present in "<Section>" section of Rock Center Production form
    When user enters set crew information in Rock Center Production form
      | Set Crew 				|
      | JIB  	|
    Then user verifies the added set crew is displayed in the section
    	| Set Crew 				|
      | JIB 	|
    Then user verifies whether "<section>" section is marked checked when all required fields are filled on "<Form Name>" Production request
   Examples: 
      | Form Name   |Section|
      | Rock Center |SET CREW|
      
   @NcxUnifiedToolPhase2 @PSEQA @PSEQA-6033
  	Scenario Outline: TC_008_StudioForm_NRT_11902_Control room block verification.
   	And user clicks on forms link
  	And user selects "<Form Name>" form
  	Then  user verifies whether "<Section>" section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
    When user enters control room details in Rock Center Production form
    | Control Room Location    | Control Room		|
    | Field 									 |  							|
    Then user verifies the fields present in "<Section>" section of Rock Center Production form
    When user enters control room details in Rock Center Production form
    | Control Room Location    | Control Room		|
    | No Control Room 				|  								|
    Then user verifies the fields present in "<Section>" section of Rock Center Production form
    Then user verifies whether "<section>" section is marked checked when all required fields are filled on "<Form Name>" Production request
   	When user enters control room details in Rock Center Production form
    | Control Room Location    | Control Room		|
    | Rock Center 						 |  Any Available Control Room					|
    Then user verifies whether "<section>" section is marked checked when all required fields are filled on "<Form Name>" Production request
   Examples: 
      | Form Name   |Section|
      | Rock Center |CONTROL ROOM|
   
   @NcxUnifiedToolPhase2 @PSEQA @PSEQA-6034
  	Scenario Outline: TC_027_StudioForm_NRT_11902_Control room crew block verification.
   	And user clicks on forms link
  	And user selects "<Form Name>" form
  	Then  user verifies whether "<Section>" section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
    When user enters control room crew information in Rock Center Production form
    | Capture Manager | Control Room Crew |
    | Yes             | A1                |
    Then user verifies the added control crew is displayed in the section
    | Capture Manager | Control Room Crew |
    | Yes             | A1                |
    Then user verifies whether "<section>" section is marked checked when all required fields are filled on "<Form Name>" Production request  
   Examples: 
      | Form Name   |Section|
      | Rock Center |CONTROL ROOM CREW|
      
    @NcxUnifiedToolPhase2 @PSEQA @PSEQA-7909
  	Scenario Outline: TC_020_StudioForm_NRT_11902_Additional crew block verification.
   	And user clicks on forms link
  	And user selects "<Form Name>" form
  	Then  user verifies whether "<Section>" section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
    Then user verifies the fields present in "<Section>" section of Rock Center Production form
    When user enters adds additional crew in Rock Center Production form
      | Additional Crew |
      | VIDEO OP     |
    Then user verifies the added additional crew is displayed in the section
    | Additional Crew |
    | VIDEO OP        |
    Then user verifies whether "<section>" section is marked checked when all required fields are filled on "<Form Name>" Production request
   Examples: 
      | Form Name   |Section|
      | Rock Center |ADDITIONAL CREW|
   
   @NcxUnifiedToolPhase2 @PSEQA @PSEQA-7908
  	Scenario Outline: TC_028_StudioForm_NRT_11902_Systems room block verification.
   	And user clicks on forms link
  	And user selects "<Form Name>" form
  	Then  user verifies whether "<Section>" section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
    Then user verifies the fields present in "<Section>" section of Rock Center Production form
    When user enters system information in Rock Center Production form
      | Ultimatte | Voice Activated Prompter |
      |         2 |                        1 |
    Then user verifies whether "<section>" section is marked checked when all required fields are filled on "<Form Name>" Production request
   Examples: 
      | Form Name   |Section|
      | Rock Center |SYSTEMS|
   
    @NcxUnifiedToolPhase2 @PSEQA @PSEQA-6035
  	Scenario Outline:TC_010_StudioForm_NRT_11902_To verify functionality of fields under Staging when 'is staging needed' is set to Yes.
   	And user clicks on forms link
  	And user selects "<Form Name>" form
    Then user verifies the fields present in "<Section>" section of Rock Center Production form
    Then  user verifies whether "<Section>" section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
    Then user checks the default state of is staging needed buttons
    When user enters staging information in Rock Center Production form
      | Staging | Carpentry | Lighting | Props | Describe Staging Needs |
      | No     | Yes       | No      | Yes   | test Sample    |
    Then user verifies whether "<section>" section is marked checked when all required fields are filled on "<Form Name>" Production request
   Examples: 
      | Form Name   |Section|
      | Rock Center |STAGING|
   
   @NcxUnifiedToolPhase2 @PSEQA @PSEQA-6036 
  	Scenario Outline: TC_011_StudioForm_NRT_11902_To verify functionality of TPM/TM information block when 'Is a TPM or TM needed' is set to Yes.
   	And user clicks on forms link
  	And user selects "<Form Name>" form
    Then user verifies the fields present in "<Section>" section of Rock Center Production form
     Then user verifies whether "<section>" section is marked checked when all required fields are filled on "<Form Name>" Production request
     When user enters TPMorTM information in Rock Center Production form
      | TPM or TM |
      | Same as requester    |
    Then user verifies whether "<section>" section is marked checked when all required fields are filled on "<Form Name>" Production request
   Examples: 
      | Form Name   |Section|
      | Rock Center |TPM / TM INFORMATION|
      
    @NcxUnifiedToolPhase2 @PSEQA @PSEQA-6032
  	Scenario Outline: TC_009_StudioForm_NRT_11902_Flashcam crew block verification.
   	And user clicks on forms link
  	And user selects "<Form Name>" form
  	Then user verifies presence of flashcam crew section 
  	|Location					| Set Location 			| Division	|
  	|Telemundo Center	|	Newsroom Flashcam	|	NBC News	|
		Then user verifies whether "<section>" section is marked checked when all required fields are filled on "<Form Name>" Production request
   Examples: 
      | Form Name   |Section|
      | Rock Center |TPM / TM INFORMATION|
   
   
   
   
   @PSEQA @NcxUnifiedToolPhase2 @PSEQA-6039
   Scenario Outline: TC005_StudioForm_NRT-11902 Verify that sections are marked as "X" when mandatory field are missed
    And user clicks on forms link
    And user selects "<Form Name>" form
    When user clicks on "submit" button
    When user clicks on "OK" button
    Then verify the mandatory sections highlights as incomplete in Rock Center Production form
      | Error sections                                                         |
      | GENERAL DETAILS,PRODUCTION PURPOSE,SHOW INFO,SET LOCATION,CONTROL ROOM,STAGING |
    Then Verify error message is displayed for all mandatory fields in general details section for Rock Center Production form
      | Division Error |
      | Select a value |
    Then Verify error message is displayed for all mandatory fields in Production Purpose section for Rock Center Production form
      | Request For Error |
      | Select a value    |
    Then Verify error message is displayed for all mandatory fields in show info section for Rock Center Production form
      | Air Platform Error | Show Unit Error                            | Budget Code Error | Start Date Error | Start Time Error | End Time Error |
      | Select a value     | Please select/enter a show or project name | Enter a value     | Select a date     | Enter a value    | Enter a value  |
    Then Verify error message is displayed for all mandatory fields in set Location info section In Rock Center Production Form
      | Location Error | Set Location Error |
      | Select a value | Select a value     |
    Then Verify error message is displayed for all mandatory fields in Control Room section In Rock Center Production Form
      | Control Room Location Error | control Room Error |
      | Select a value              | Select a value     |
    When user clicks on "NBCU Logo" button
    And user logs out from application
	 	Examples: 
      | Form Name   |
      | Rock Center |

				
   @PSEQA @NcxUnifiedToolPhase2 @PSEQA-6040
   Scenario Outline: TC_015_StudioForm_NRT_11902_Verify successful submission of rock center production request.
   And user clicks on forms link
   And user selects "<Form Name>" form
   When user selects division from the dropdown under general details section
   |Division|
   |Corporate|
   When user add additional requester in requester section
   	|Additional Requesters|
   	|Bambani-Jeevanandham|
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
   Examples: 
      | Form Name   |
      | Rock Center |