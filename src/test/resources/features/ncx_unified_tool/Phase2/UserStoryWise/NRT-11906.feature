@NcxUnifiedToolPhase2 @ProducerDashboard @UserStoryWise
Feature: NCX Unified Tool Phase 2: Single live Camera shot Production Request Reskin

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role

  @PSEQA @NcxUnifiedToolPhase2 @PSEQA-7954
  Scenario Outline: TC_015_StudioForm_NRT-11906_ Verify that the "Single camera live shot" text is displayed above the form. 
    And user clicks on forms link
    And user selects "<Form Name>" form
    Then user verifies whether "<Form Name>" is displayed the top of the request
 		Examples: 
      | Form Name   						|
      | Single Camera Live Shot |
      
  @PSEQA @NcxUnifiedToolPhase2 @PSEQA-7953
  Scenario Outline: TC_014_StudioForm_NRT-11906 verify the total number of sub sections and headers of it in the request form.
  And user clicks on forms link
  And user selects "<Form Name>" form
  Then user verifies the form sections on Single Camera Live Shot production form
  Examples: 
      | Form Name   						|
      | Single Camera Live Shot |
  
  @PSEQA @NcxUnifiedToolPhase2 @PSEQA-7940
  Scenario Outline: TC_001_StudioForm_NRT_11906_Status verification on the request page.
 	And user clicks on forms link
 	And user selects "<Form Name>" form
	Then user verifies the status on the request is "New"
	
	Examples: 
      | Form Name   						|
      | Single Camera Live Shot |
      
  @NcxUnifiedToolPhase2 @PSEQA @PSEQA-7942 @PSEQA-7947
  	Scenario Outline: TC_003_StudioForm_NRT_11906_ General details block field verification.
  	And user clicks on forms link
  	And user selects "<Form Name>" form
    Then user verifies the fields present in "<Section>" section of Single Live Camera Shot form
    Then  user verifies whether "<Section>" section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
    When user selects division from the dropdown under general details section
    |Division|
    |Corporate|
    Then user verifies whether "<Section>" section is marked checked when all required fields are filled on "<Form Name>" Production request
    Examples: 
      | Form Name   |Section				|
      | Single Camera Live Shot |GENERAL DETAILS|
      
   @NcxUnifiedToolPhase2 @PSEQA @PSEQA-7941
  	Scenario Outline: TC_002_StudioForm_NRT_11906_Requester details verification on request page
  	And user clicks on forms link
  	And user selects "<Form Name>" form
  	Then user verifies whether "<section>" section is marked checked when all required fields are filled on "<Form Name>" Production request
    Then user verifies the fields present in "<Section>" section of Single Live Camera Shot form
   	When user add additional requester in requester section
   	|Additional Requesters|
   	|Bambani-Jeevanandham|
   	Then user verifies additional requester name displayed
   	|Additional Requesters|
   	|Bambani, Mohit-R, Jeevanandham|
   Examples: 
      | Form Name   |Section|
      | Single Camera Live Shot |REQUESTER(S)|
      
   @NcxUnifiedToolPhase2 @PSEQA @PSEQA-7943
  	Scenario Outline: TC_004_StudioForm_NRT_11906_Talent block field verification.
   	And user clicks on forms link
  	And user selects "<Form Name>" form
  	Then  user verifies whether "<Section>" section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
    Then user verifies the fields present in "<Section>" section of Single Live Camera Shot form
    When user add specific user in Talent section
    				|First Name | Last Name | 
    				|Bosa       | Deirdre   |
    Then user verifies added talent is displayed in the section
    				|First Name | Last Name | 
    				|Bosa       | Deirdre   |
    Then user verifies whether "<section>" section is marked checked when all required fields are filled on "<Form Name>" Production request
   Examples: 
      | Form Name   |Section|
      | Single Camera Live Shot |TALENT|	
   
   @NcxUnifiedToolPhase2 @PSEQA @PSEQA-1111
   Scenario Outline: TC_016_StudioForm_NRT_11906_Details block field verification.
   	And user clicks on forms link
  	And user selects "<Form Name>" form
  	Then  user verifies whether "<Section>" section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
  	Then user verifies the fields present in "<Section>" section of Single Live Camera Shot form
  	When user provides notes under Details and Notes section
  	|Notes|
  	|Test Automation Notes|
  	Then user verifies whether "<section>" section is marked checked when all required fields are filled on "<Form Name>" Production request
    Examples: 
      | Form Name   						|Section	|
      | Single Camera Live Shot |DETAILS	|
      
    @NcxUnifiedToolPhase2 @PSEQA @PSEQA-7944
  	Scenario Outline: TC_005_StudioForm_NRT_11906_To verify details on show info block.
    And user clicks on forms link
  	And user selects "<Form Name>" form
  	Then  user verifies whether "<Section>" section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
    Then user verifies the fields present in "<Section>" section of Single Live Camera Shot form
    When user selects division from the dropdown under general details section
    |Division|
    |CNBC|
    Then user verifies the fields present in "<Section>" section of Single Live Camera Shot form
   	When user selects show unit or project name details
   	|Show or Project Name|
   	|Other|
   	Then user verifies the fields present in "<Section>" section of Single Live Camera Shot form
    When user enters show information in Rock Center Production form
    | Air Platform | Show or Project Name | Start Date    | Prep Start Time | Start Time    | End Time      |
    | OTT          | NOW Tonight       		| CurrentDate+3 | CurrentTime+3   | CurrentTime+3 | CurrentTime+3 |
  	Then user verifies whether "<section>" section is marked checked when all required fields are filled on "<Form Name>" Production request
   Examples: 
      | Form Name   						|Section	|
      | Single Camera Live Shot |SHOW INFO|
      
    @NcxUnifiedToolPhase2 @PSEQA @PSEQA-7945
  	Scenario Outline: TC_006_StudioForm_NRT_11906_ Set information block verification.
  	And user clicks on forms link
  	And user selects "<Form Name>" form
  	Then  user verifies whether "<Section>" section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
    Then user verifies the fields present in "<Section>" section of Single Live Camera Shot form
    When user selects set background option from the dropdown
   	|Set Background|
   	|Other|
   	Then user verifies the fields present in "<Section>" section of Single Live Camera Shot form
   	When user enters set information in Single Camera Live Shot Production form
      | Set Background | Set Staging Needed |
      | Greenscreen    | Yes                |
    Then user verifies whether "<section>" section is marked checked when all required fields are filled on "<Form Name>" Production request
   	Examples: 
      | Form Name   						|Section	|
      | Single Camera Live Shot |SET INFORMATION|
      
     
    @NcxUnifiedToolPhase2 @PSEQA @PSEQA-7946
  	Scenario Outline: TC_007_StudioForm_NRT_11906_ Set crew block verification.
  	And user clicks on forms link
  	And user selects "<Form Name>" form
  	Then  user verifies whether "<Section>" section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
    Then user verifies the fields present in "<Section>" section of Single Live Camera Shot form
    When user enters set crew in Single Camera Live Shot Production form
      | Capture Manager | Set Crew     |
      | Yes             | HAIR STYLIST |
      Then user verifies the added set crew is displayed in the section
    	| Set Crew 				|
      | HAIR STYLIST 		|
    Then user verifies whether "<section>" section is marked checked when all required fields are filled on "<Form Name>" Production request
    Examples: 
      | Form Name   						|Section	|
      | Single Camera Live Shot |SET CREW |
      
     @NcxUnifiedToolPhase2 @PSEQA @PSEQA-7949
    Scenario Outline: TC_010_StudioForm_NRT_11906_To verify successful submission of a request
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
     Examples: 
      | Form Name   						|
      | Single Camera Live Shot |
      
    @NcxUnifiedToolPhase2 @PSEQA @PSEQA-7948
 	 Scenario Outline: TC_009_StudioForm_NRT_11906_To verify that sections are marked as "X" when mandatory field are missed.
    And user clicks on forms link
    And user selects "<Form Name>" form
    When user clicks on "submit" button
    When user clicks on "OK" button
    Then verify the mandatory sections highlights as incomplete in Single Camera Live Shot Production form
      | Error sections                            |
      | GENERAL DETAILS,SHOW INFO,SET INFORMATION |
    Then Verify error message is displayed for all mandatory fields in general details section for Single Camera Live Shot Production form
      | Division Error |
      | Select a value |
    Then Verify error message is displayed for all mandatory fields in show info section for Single Camera Live Shot Production form
      | Air Platform Error | Show Unit Error                            | Budget Code Error | Start Date Error | Start Time Error | End Time Error |
      | Select a value     | Please select/enter a show or project name | Enter a value     | Select a date    | Enter a value    | Enter a value  |
    Then Verify error message is displayed for all mandatory fields in Set Information section In Single Camera Live Shot Production Form
      | Set Background Error | Set Staging Needed Error |
      | Select a value       | Select a value           |
    When user clicks on "NBCU Logo" button
    And user logs out from application

    Examples: 
      | Form Name               |
      | Single Camera Live Shot |
    