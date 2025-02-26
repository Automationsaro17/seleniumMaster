@NcxUnifiedToolPhase2 @ExtendOrBridgeCrewAndFacilities @ProducerDashboard @UserStoryWise @NRT_11907
Feature: NCX Unified Tool Phase 2: Extend or Bridge Crew & Facilities

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role
    And "producer" becomes default requester for every request created by it
    
    
  @NcxUnifiedToolPhase2 @PSEQA @PSEQA_7958 @PSEQA_7967
  Scenario Outline: TC_021_StudioForm_NRT-11907 verify the total number of sub sections and headers of it in the request form. 
  	And  user clicks on forms link
  	And  user selects "<Form Name>" form
  	Then user verifies the form sections on Extend or Bridge Crew & Facilities production form
  	When user selects Request For on Extend or Bridge Crew & Facilities production request
  					|Request For |
  					|Bridge      |
  	Then user verifies the form sections on Extend or Bridge Crew & Facilities production form
  	When user selects Request For on Extend or Bridge Crew & Facilities production request
  					|Request For |
  					|Extend      |
  	Then user verifies the form sections on Extend or Bridge Crew & Facilities production form
    Examples:
    				|Form Name                               | Section Name  |
    				|Extend or Bridge Crew & Facilities      | SHOW INFO     |
    				
  @NcxUnifiedToolPhase2 @PSEQA @PSEQA_7957
  Scenario Outline: TC_022_StudioForm_NRT-11907_ Verify that the "Extend or bridge" text is displayed above the form. 
  	And  user clicks on forms link
  	And  user selects "<Form Name>" form
  	Then user verifies the form title "Extend or Bridge Crew & Facilities" on "<Form Name>" production form
    Examples:
    				|Form Name                               |
    				|Extend or Bridge Crew & Facilities      |
    				
  @NcxUnifiedToolPhase2 @PSEQA @PSEQA_7961
  Scenario Outline: TC_018_StudioForm_NRT_11907_Default Status verification on the request page. 
  	And  user clicks on forms link
  	And  user selects "<Form Name>" form
  	Then user verifies that the status is '<Status>' for "<Form Name>" Production form
    Examples:
    				|Form Name                           | Status |
    				|Extend or Bridge Crew & Facilities  | NEW    |
    				
  @NcxUnifiedToolPhase2 @PSEQA @PSEQA_7962
  Scenario Outline: TC_002_StudioForm_NRT_11907_Requester details verification on request page 
  	And  user clicks on forms link
  	And  user selects "<Form Name>" form
    Then user verifies that it is added as requester in Requesters section of "<Form Name>" production form
    And  user verifies the fields present in "<Section Name>" section of Extend or Bridge Crew & Facilities Production form
    And  user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
    When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
    Examples:
    				|Form Name                          | Section Name  | Option1 | Option2 |
    				|Extend or Bridge Crew & Facilities | REQUESTER(S)  | Submit  | ok      |
    				
  @NcxUnifiedToolPhase2 @PSEQA @PSEQA_7963 @PSEQA_7959 @PSEQA_7960
  Scenario Outline: TC_003_StudioForm_NRT_11907_ General details block field verification. 
  	And  user clicks on forms link
  	And  user selects "<Form Name>" form
  	Then user verifies the fields present in "<Section Name>" section of Extend or Bridge Crew & Facilities Production form
  	And  user checks placeholder of "Division" field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
  	And  user verifies whether "<Section Name>" section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
    And  user checks error for "Division" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
  	When user selects Division on Extend or Bridge Crew & Facilities production request
  					|Division    |
  					|MSNBC       |
  	Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	And  user checks error not displayed for "Division" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user checks error not displayed for "Division" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    And  user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	And  user verifies the fields present in "<Section Name>" section of Extend or Bridge Crew & Facilities Production form
    Examples:
    				|Form Name                          | Section Name    | Option1 | Option2 |
    				|Extend or Bridge Crew & Facilities | GENERAL DETAILS | Submit  | ok      |
    				
  @NcxUnifiedToolPhase2 @PSEQA @PSEQA_7965 @PSEQA_7959 @PSEQA_7960
  Scenario Outline: TC_013_StudioForm_NRT_11905_Details block field verification. 
  	And  user clicks on forms link
  	And  user selects "<Form Name>" form
  	Then user verifies the fields present in "<Section Name>" section of Extend or Bridge Crew & Facilities Production form
  	Then user verifies whether "<Section Name>" section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
  	When user selects Details and Notes on Extend or Bridge Crew & Facilities production request
  					|Details and Notes                                                           |
  					|This is a sample text filled by automation in Details and Notes field       |
  	Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	Then user verifies the fields present in "<Section Name>" section of Extend or Bridge Crew & Facilities Production form
  	When user clears Details and Notes on Extend or Bridge Crew & Facilities production request
  	Then user verifies whether "<Section Name>" section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
    Examples:
    				|Form Name                          |Section Name | Option1 | Option2 |
    				|Extend or Bridge Crew & Facilities |DETAILS      | Submit  | ok      |
    				
  @NcxUnifiedToolPhase2 @PSEQA @PSEQA_7966 @PSEQA_7959 @PSEQA_7960
  Scenario Outline: TC_006_StudioForm_NRT_11907_To verify details on show info block. 
  	And  user clicks on forms link
  	And  user selects "<Form Name>" form
  	Then user verifies the fields present in "<Section Name>" section of Extend or Bridge Crew & Facilities Production form
  	Then user checks placeholder of "Air Platform" field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
  	Then user checks placeholder of Show Unit or Project Name field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
  	Then user verifies whether "<Section Name>" section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
    Then user checks error for "Air Platform" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error for "Show Unit or Project Name" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error for "Start Date" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error for "Start Time" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error for "End Time" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error for "Request For" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error for "Budget Code" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
  	When user selects Air Platform on Extend or Bridge Crew & Facilities production request
  					|Air Platform|
  					|Internal    |
  	Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user selects Show Unit or Project Name on Extend or Bridge Crew & Facilities production request
  					|Show Unit or Project Name       |
  					|11TH HOUR WITH STEPHANIE RUHLE  |
  	Then user checks error not displayed for "Air Platform" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error not displayed for "Show Unit or Project Name" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error for "Start Date" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error for "Start Time" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error for "End Time" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error for "Request For" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error not displayed for "Budget Code" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
  	Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user checks error not displayed for "Air Platform" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error not displayed for "Show Unit or Project Name" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error for "Start Date" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error for "Start Time" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error for "End Time" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error for "Request For" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error not displayed for "Budget Code" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user selects Start Date on Extend or Bridge Crew & Facilities production request
  					|Days from today  |
  					|3 |
  	Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user selects Start Time on Extend or Bridge Crew & Facilities production request
  					|Start Time |
  					|1:15 PM    |
  	Then user checks error not displayed for "Air Platform" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error not displayed for "Show Unit or Project Name" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error not displayed for "Start Date" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error not displayed for "Start Time" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error for "End Time" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error for "Request For" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error not displayed for "Budget Code" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
  	Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user selects Request For on Extend or Bridge Crew & Facilities production request
  					|Request For |
  					|Bridge      |
  	Then user checks error not displayed for "Air Platform" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error not displayed for "Show Unit or Project Name" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error not displayed for "Start Date" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error not displayed for "Start Time" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error for "End Time" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error not displayed for "Request For" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error not displayed for "Budget Code" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
  	Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user selects End Time on Extend or Bridge Crew & Facilities production request
  					|End Time  |
  					|11:59 AM  |
  	Then user checks error not displayed for "Air Platform" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error not displayed for "Show Unit or Project Name" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error not displayed for "Start Date" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error not displayed for "Start Time" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error not displayed for "End Time" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error not displayed for "Request For" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error not displayed for "Budget Code" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
  	Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user checks error not displayed for "Air Platform" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error not displayed for "Show Unit or Project Name" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error not displayed for "Start Date" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error not displayed for "Start Time" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error not displayed for "End Time" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error not displayed for "Request For" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error not displayed for "Budget Code" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	Then user verifies the fields present in "<Section Name>" section of Extend or Bridge Crew & Facilities Production form
  	When user selects Division in "GENERAL DETAILS" section on Extend or Bridge Crew & Facilities production request
  					|Division    |
  					|CNBC        |
  	Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	Then user verifies the fields present in "<Section Name>" section of Extend or Bridge Crew & Facilities Production form
  	When user selects Work Order # on Extend or Bridge Crew & Facilities production request
  					|Work Order #                                                       |
  					|This is a text given via automation in Work Order # field          |
  	Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	When user selects Show Unit or Project Name on Extend or Bridge Crew & Facilities production request
  					|Show Unit or Project Name|
  					|Other                    |
  	Then user checks error not displayed for "Air Platform" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error not displayed for "Show Unit or Project Name" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error not displayed for "Start Date" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error not displayed for "Start Time" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error not displayed for "End Time" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error not displayed for "Request For" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error for "Budget Code" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error for "Other" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
  	Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user checks error not displayed for "Air Platform" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error not displayed for "Show Unit or Project Name" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error not displayed for "Start Date" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error not displayed for "Start Time" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error not displayed for "End Time" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error not displayed for "Request For" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error for "Budget Code" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error for "Other" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user selects Other on Extend or Bridge Crew & Facilities production request
  					|Other                                              |
  					|This is value given via automation for Other field |
  	When user selects Budget Code on Extend or Bridge Crew & Facilities production request
  					|Budget Code          |
  					|autOmaTIonBUDgetcODe |
  	Then user checks error not displayed for "Air Platform" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error not displayed for "Show Unit or Project Name" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error not displayed for "Start Date" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error not displayed for "Start Time" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error not displayed for "End Time" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error not displayed for "Request For" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error not displayed for "Budget Code" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error not displayed for "Other" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
  	Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user checks error not displayed for "Air Platform" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error not displayed for "Show Unit or Project Name" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error not displayed for "Start Date" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error not displayed for "Start Time" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error not displayed for "End Time" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error not displayed for "Request For" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error not displayed for "Budget Code" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user checks error not displayed for "Other" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	Then user verifies the fields present in "<Section Name>" section of Extend or Bridge Crew & Facilities Production form
    Examples:
    				|Form Name                          |Section Name | Option1  | Option2  |
    				|Extend or Bridge Crew & Facilities |SHOW INFO    | Submit   | ok       |
    				
  @NcxUnifiedToolPhase2 @PSEQA @PSEQA_7964 @PSEQA_7959 @PSEQA_7960
  Scenario Outline: TC_004_StudioForm_NRT_11907_Talent block field verification. 
  	And  user clicks on forms link
  	And  user selects "<Form Name>" form
  	Then user verifies the fields present in "<Section Name>" section of Extend or Bridge Crew & Facilities Production form
  	And  user checks placeholder of Talent field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
  	And  user verifies whether "<Section Name>" section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
  	Then  user verifies whether "<Section Name>" section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
  	When user add specific user in Talent section
    				|Name        | 
    				|Memoli, Mike|
    Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
    When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
    When user add specific user in Talent section
    				|Name        | 
    				|Velshi, Ali |
    Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
    When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	And  user verifies the fields present in "<Section Name>" section of Extend or Bridge Crew & Facilities Production form
    Examples:
    				|Form Name                          |Section Name | Option1  | Option2 |
    				|Extend or Bridge Crew & Facilities |TALENT       | Submit   | ok      |
    				
  @NcxUnifiedToolPhase2 @PSEQA @PSEQA_7968 @PSEQA_7959 @PSEQA_7960
  Scenario Outline: TC_017_StudioForm_NRT_11907_ Set location & crew block verification with different location. 
  	And  user clicks on forms link
  	And  user selects "<Form Name>" form
  	When user selects Request For on Extend or Bridge Crew & Facilities production request
  					|Request For |
  					|Bridge      |
  	Then user verifies the fields present in "<Section Name>" section of Extend or Bridge Crew & Facilities Production form
  	And  user verifies whether "<Section Name>" section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
  	And  user checks placeholder of "Location" field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
  	And  user checks placeholder of "Set Location" field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user checks error for "Location" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    And  user checks error for "Set Location" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    And  user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user selects Location on Extend or Bridge Crew & Facilities production request
  					|Location         |
  					|Rock Center      |
  	Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
    Then user checks error not displayed for "Location" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    And  user checks error for "Set Location" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    And  user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user selects Set Location on Extend or Bridge Crew & Facilities production request
  					|Set Location   |
  					|3A Studio      |
  	Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
    Then user checks error not displayed for "Location" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    And  user checks error not displayed for "Set Location" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    And  user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	When user selects Location on Extend or Bridge Crew & Facilities production request
  					|Location         |
  					|Field            |
    And user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user selects Address in Set Location & Crew on Extend or Bridge Crew & Facilities production request
  					|Address                                     |
  					|Example address in the address field 2      |
  	Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
  	Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
    Then user checks error not displayed for "Location" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    And  user checks error not displayed for "Address" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
  	And  user verifies the fields present in "<Section Name>" section of Extend or Bridge Crew & Facilities Production form
  	When user selects Location on Extend or Bridge Crew & Facilities production request
  					|Location         |
  					|None             |
  	Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
  	Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
    Then user checks error not displayed for "Location" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
  	And  user verifies the fields present in "<Section Name>" section of Extend or Bridge Crew & Facilities Production form
    Examples:
    				|Form Name                          |Section Name               | Option1 | Option2 |
    				|Extend or Bridge Crew & Facilities |BRIDGE SET LOCATION & CREW | Submit  | ok      |

	@NcxUnifiedToolPhase2 @PSEQA @PSEQA_7968 @PSEQA_7959 @PSEQA_7960
  Scenario Outline: TC_017_StudioForm_NRT_11907_ Set location & crew block verification with different location. 
  	And  user clicks on forms link
  	And  user selects "<Form Name>" form
  	When user selects Request For on Extend or Bridge Crew & Facilities production request
  					|Request For |
  					|Extend      |
  	Then user verifies the fields present in "<Section Name>" section of Extend or Bridge Crew & Facilities Production form
  	And  user verifies whether "<Section Name>" section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
  	And  user checks placeholder of "Location" field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
  	And  user checks placeholder of "Set Location" field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user checks error for "Location" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    And  user checks error for "Set Location" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    And  user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user selects Location on Extend or Bridge Crew & Facilities production request
  					|Location         |
  					|Rock Center      |
  	Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
    Then user checks error not displayed for "Location" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    And  user checks error for "Set Location" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    And  user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user selects Set Location on Extend or Bridge Crew & Facilities production request
  					|Set Location   |
  					|3A Studio      |
  	Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
    Then user checks error not displayed for "Location" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    And  user checks error not displayed for "Set Location" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    And  user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	When user selects Location on Extend or Bridge Crew & Facilities production request
  					|Location         |
  					|Field            |
    And user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user selects Address in Set Location & Crew on Extend or Bridge Crew & Facilities production request
  					|Address                                     |
  					|Example address in the address field 2      |
  	Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
  	Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
    Then user checks error not displayed for "Location" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    And  user checks error not displayed for "Address" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
  	And  user verifies the fields present in "<Section Name>" section of Extend or Bridge Crew & Facilities Production form
  	When user selects Location on Extend or Bridge Crew & Facilities production request
  					|Location         |
  					|None             |
  	Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
  	Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
    Then user checks error not displayed for "Location" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
  	And  user verifies the fields present in "<Section Name>" section of Extend or Bridge Crew & Facilities Production form
    Examples:
    				|Form Name                          |Section Name               | Option1 | Option2 |
    				|Extend or Bridge Crew & Facilities |EXTEND SET LOCATION & CREW | Submit  | ok      |
    				
  @NcxUnifiedToolPhase2 @PSEQA @PSEQA_7969 @PSEQA_7959 @PSEQA_7960
  Scenario Outline: TC_008_StudioForm_NRT_11907_ To verify fields under control room & crew block. 
  	And  user clicks on forms link
  	And  user selects "<Form Name>" form
  	Then user verifies the fields present in "CONTROL ROOM & CREW" section of Extend or Bridge Crew & Facilities Production form
  	When user selects Request For on Extend or Bridge Crew & Facilities production request
  					|Request For |
  					|Extend      |
  	Then user verifies the fields present in "<Section Name>" section of Extend or Bridge Crew & Facilities Production form
  	And  user verifies whether "<Section Name>" section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
    And  user checks error for "Control Room & Crew" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    And  user checks error for "Control Room Location" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    And  user checks error for "Control Room" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
  	When user selects Control Room & Crew on Extend or Bridge Crew & Facilities production request
  					|Control Room & Crew|
  					|No                 |
  	Then user checks `Control Room Location` field is disabled on Extend or Bridge Crew & Facilities production request
  	Then user checks `Control Room` field is disabled on Extend or Bridge Crew & Facilities production request
  	And  user checks error not displayed for "Control Room & Crew" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    And  user checks error not displayed for "Control Room Location" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    And  user checks error not displayed for "Control Room" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user verifies the fields present in "<Section Name>" section of Extend or Bridge Crew & Facilities Production form
  	Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
       Examples:
    				|Form Name                         | Section Name               | Option1  | Option2 |
    				|Extend or Bridge Crew & Facilities| EXTEND CONTROL ROOM & CREW | Submit   | ok      |
    				
  @NcxUnifiedToolPhase2 @PSEQA @PSEQA_7969 @PSEQA_7959 @PSEQA_7960
  Scenario Outline: TC_008_StudioForm_NRT_11907_ To verify fields under control room & crew block. 
  	And  user clicks on forms link
  	And  user selects "<Form Name>" form
  	Then user verifies the fields present in "CONTROL ROOM & CREW" section of Extend or Bridge Crew & Facilities Production form
  	When user selects Request For on Extend or Bridge Crew & Facilities production request
  					|Request For |
  					|Bridge      |
  	Then user verifies the fields present in "<Section Name>" section of Extend or Bridge Crew & Facilities Production form
  	And  user verifies whether "<Section Name>" section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
    And  user checks error for "Control Room & Crew" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    And  user checks error for "Control Room Location" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    And  user checks error for "Control Room" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
  	When user selects Control Room & Crew on Extend or Bridge Crew & Facilities production request
  					|Control Room & Crew|
  					|No                 |
  	Then user checks `Control Room Location` field is disabled on Extend or Bridge Crew & Facilities production request
  	Then user checks `Control Room` field is disabled on Extend or Bridge Crew & Facilities production request
  	And  user checks error not displayed for "Control Room & Crew" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    And  user checks error not displayed for "Control Room Location" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    And  user checks error not displayed for "Control Room" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user verifies the fields present in "<Section Name>" section of Extend or Bridge Crew & Facilities Production form
  	Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
       Examples:
    				|Form Name                         | Section Name               | Option1  | Option2 |
    				|Extend or Bridge Crew & Facilities| BRIDGE CONTROL ROOM & CREW | Submit   | ok      |
    				
  @NcxUnifiedToolPhase2 @PSEQA @PSEQA_7970 @PSEQA_7959 @PSEQA_7960
  Scenario Outline: TC_009_StudioForm_NRT_11907_To verify functionality of TPM/TM information block when 'Is a TPM or TM needed' is set to Yes. 
  	And  user clicks on forms link
  	And  user selects "<Form Name>" form
  	Then user verifies the fields present in "<Section Name>" section of Extend or Bridge Crew & Facilities Production form
  	Then user checks `Same as requester?` checkbox is disabled on Extend or Bridge Crew & Facilities production request
  	Then user checks `TPM/TM Name` field is readonly on Extend or Bridge Crew & Facilities production request
  	Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
  	Then user checks `Same as requester?` checkbox is disabled on Extend or Bridge Crew & Facilities production request
  	Then user checks `TPM/TM Name` field is readonly on Extend or Bridge Crew & Facilities production request
    Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	When user selects `Is a TPM or TM Needed?` on Extend or Bridge Crew & Facilities production request
  					|Choice|
  					|Yes   |
  	Then user checks `Same as requester?` checkbox is enabled on Extend or Bridge Crew & Facilities production request
  	Then user checks `TPM/TM Name` field is enabled on Extend or Bridge Crew & Facilities production request
  	When user selects `Same as requester?` on Extend or Bridge Crew & Facilities production request
  	Then user checks `TPM/TM Name` field is readonly on Extend or Bridge Crew & Facilities production request
    Then user verifies the fields present in "<Section Name>" section of Extend or Bridge Crew & Facilities Production form
  	Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
       Examples:
    				|Form Name                         | Section Name         | Option1  | Option2 |
    				|Extend or Bridge Crew & Facilities| TPM / TM INFORMATION | Submit   | ok      |

	@NcxUnifiedToolPhase2 @PSEQA @PSEQA_7969 @PSEQA_7959 @PSEQA_7960
  Scenario Outline: TC_008_StudioForm_NRT_11907_ To verify fields under control room & crew block. permutation-1
  	And  user clicks on forms link
  	And  user selects "<Form Name>" form
  	Then user verifies the fields present in "CONTROL ROOM & CREW" section of Extend or Bridge Crew & Facilities Production form
  	When user selects Request For on Extend or Bridge Crew & Facilities production request
  					|Request For |
  					|Extend      |
  	Then user verifies the fields present in "<Section Name>" section of Extend or Bridge Crew & Facilities Production form
  	And  user verifies whether "<Section Name>" section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
    And  user checks error for "Control Room & Crew" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    And  user checks error for "Control Room Location" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    And  user checks error for "Control Room" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
  	When user selects Control Room & Crew on Extend or Bridge Crew & Facilities production request
  					|Control Room & Crew|
  					|Yes                |
  	And  user checks error not displayed for "Control Room & Crew" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    And  user checks error for "Control Room Location" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    And  user checks error for "Control Room" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user verifies the fields present in "<Section Name>" section of Extend or Bridge Crew & Facilities Production form
  	Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
    And  user checks error not displayed for "Control Room & Crew" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    And  user checks error for "Control Room Location" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    And  user checks error for "Control Room" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
  	When user selects Control Room Location on Extend or Bridge Crew & Facilities production request
  					|Control Room Location | 
  					|Rock Center           |
  	Then user verifies the fields present in "<Section Name>" section of Extend or Bridge Crew & Facilities Production form
  	Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
    And  user checks error not displayed for "Control Room & Crew" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    And  user checks error not displayed for "Control Room Location" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    And  user checks error for "Control Room" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
  	When user selects Control Room on Extend or Bridge Crew & Facilities production request
  					|Control Room  | 
  					|CR 1A         |
  	Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
    And  user checks error not displayed for "Control Room & Crew" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    And  user checks error not displayed for "Control Room Location" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    And  user checks error not displayed for "Control Room" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
  	When user selects Control Room Location on Extend or Bridge Crew & Facilities production request
  					|Control Room Location|
  					|Field                |
  	Then user verifies the fields present in "<Section Name>" section of Extend or Bridge Crew & Facilities Production form
  	Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
    Then user verifies the fields present in "<Section Name>" section of Extend or Bridge Crew & Facilities Production form
    And  user checks error not displayed for "Control Room & Crew" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    And  user checks error not displayed for "Control Room Location" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    And  user checks error for "Address" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
  	When user selects Address in Control Room & Crew on Extend or Bridge Crew & Facilities production request
  					|Address                                                  | 
  					|This is a text given by automation to Address input      |
  	Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
    And  user checks error not displayed for "Control Room & Crew" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    And  user checks error not displayed for "Control Room Location" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    And  user checks error not displayed for "Address" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
  	When user selects Control Room Location on Extend or Bridge Crew & Facilities production request
  					|Control Room Location| 
  					|No Control Room      |
  	Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	Then user verifies the fields present in "<Section Name>" section of Extend or Bridge Crew & Facilities Production form
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
    Then user verifies the fields present in "<Section Name>" section of Extend or Bridge Crew & Facilities Production form
    And  user checks error not displayed for "Control Room & Crew" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    And  user checks error not displayed for "Control Room Location" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Examples:
    				|Form Name                         | Section Name               | Option1  | Option2 |
    				|Extend or Bridge Crew & Facilities| EXTEND CONTROL ROOM & CREW | Submit   | ok      |
    				
  @NcxUnifiedToolPhase2 @PSEQA @PSEQA_7969_02 @PSEQA_7959 @PSEQA_7960
  Scenario Outline: TC_008_StudioForm_NRT_11907_ To verify fields under control room & crew block. permutation-2
  	And  user clicks on forms link
  	And  user selects "<Form Name>" form
  	Then user verifies the fields present in "CONTROL ROOM & CREW" section of Extend or Bridge Crew & Facilities Production form
  	When user selects Request For on Extend or Bridge Crew & Facilities production request
  					|Request For |
  					|Bridge      |
  	Then user verifies the fields present in "<Section Name>" section of Extend or Bridge Crew & Facilities Production form
  	And  user verifies whether "<Section Name>" section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submi button clicked on "<Form Name>" Production request
    And  user checks error for "Control Room & Crew" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    And  user checks error for "Control Room Location" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    And  user checks error for "Control Room" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
  	When user selects Control Room & Crew on Extend or Bridge Crew & Facilities production request
  					|Control Room & Crew|
  					|Yes                |
  	And  user checks error not displayed for "Control Room & Crew" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    And  user checks error for "Control Room Location" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    And  user checks error for "Control Room" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Then user verifies the fields present in "<Section Name>" section of Extend or Bridge Crew & Facilities Production form
  	Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
    And  user checks error not displayed for "Control Room & Crew" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    And  user checks error for "Control Room Location" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    And  user checks error for "Control Room" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
  	When user selects Control Room Location on Extend or Bridge Crew & Facilities production request
  					|Control Room Location | 
  					|Rock Center           |
  	Then user verifies the fields present in "<Section Name>" section of Extend or Bridge Crew & Facilities Production form
  	Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
    And  user checks error not displayed for "Control Room & Crew" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    And  user checks error not displayed for "Control Room Location" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    And  user checks error for "Control Room" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
  	When user selects Control Room on Extend or Bridge Crew & Facilities production request
  					|Control Room  | 
  					|CR 1A         |
  	Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
    And  user checks error not displayed for "Control Room & Crew" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    And  user checks error not displayed for "Control Room Location" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    And  user checks error not displayed for "Control Room" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
  	When user selects Control Room Location on Extend or Bridge Crew & Facilities production request
  					|Control Room Location|
  					|Field                |
  	Then user verifies the fields present in "<Section Name>" section of Extend or Bridge Crew & Facilities Production form
  	Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
    Then user verifies the fields present in "<Section Name>" section of Extend or Bridge Crew & Facilities Production form
    And  user checks error not displayed for "Control Room & Crew" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    And  user checks error not displayed for "Control Room Location" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    And  user checks error for "Address" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
  	When user selects Address in Control Room & Crew on Extend or Bridge Crew & Facilities production request
  					|Address                                                  | 
  					|This is a text given by automation to Address input      |
  	Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
    And  user checks error not displayed for "Control Room & Crew" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    And  user checks error not displayed for "Control Room Location" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    And  user checks error not displayed for "Address" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
  	When user selects Control Room Location on Extend or Bridge Crew & Facilities production request
  					|Control Room Location| 
  					|No Control Room      |
  	Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	Then user verifies the fields present in "<Section Name>" section of Extend or Bridge Crew & Facilities Production form
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
    Then user verifies the fields present in "<Section Name>" section of Extend or Bridge Crew & Facilities Production form
    And  user checks error not displayed for "Control Room & Crew" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    And  user checks error not displayed for "Control Room Location" required field in "<Section Name>" section on Extend or Bridge Crew & Facilities Production request
    Examples:
    				|Form Name                         | Section Name               | Option1  | Option2 |
    				|Extend or Bridge Crew & Facilities| BRIDGE CONTROL ROOM & CREW | Submit   | ok      |
    				
  @NcxUnifiedToolPhase2 @PSEQA @PSEQA_7973
  Scenario Outline: TC_013_StudioForm_NRT_11907_To verify the request can be submitted successfuly.
  	And  user clicks on forms link
  	And  user selects "<Form Name>" form
  	When user selects Division in "GENERAL DETAILS" section on Extend or Bridge Crew & Facilities production request
  					|Division    |
  					|CNBC       |
  	When user selects Details and Notes on Extend or Bridge Crew & Facilities production request
  					|Details and Notes                                                           |
  					|This is a sample text filled by automation in Details and Notes field       |
  	When user selects Request For on Extend or Bridge Crew & Facilities production request
  					|Request For |
  					|Extend      |
  	When user selects Air Platform on Extend or Bridge Crew & Facilities production request
  					|Air Platform|
  					|Internal    |
  	When user selects Show Unit or Project Name on Extend or Bridge Crew & Facilities production request
  					|Show Unit or Project Name|
  					|ALL SHOWS                |
  	When user selects Start Date on Extend or Bridge Crew & Facilities production request
  					|Days from today  |
  					|3 |
  	When user selects Start Time on Extend or Bridge Crew & Facilities production request
  					|Start Time |
  					|1:15 PM    |
  	When user selects End Time on Extend or Bridge Crew & Facilities production request
  					|End Time  |
  					|11:59 AM  |
  	When user selects Work Order # on Extend or Bridge Crew & Facilities production request
  					|Work Order #                                                       |
  					|This is a text given via automation in Work Order # field          |
  	When user selects Budget Code on Extend or Bridge Crew & Facilities production request
  					|Budget Code          |
  					|autOmaTIonBUDgetcODe |
  	When user add specific user in Talent section
    				|Name        | 
    				|Memoli, Mike|
    When user add specific user in Talent section
    				|Name        | 
    				|Velshi, Ali |
  	When user selects Location on Extend or Bridge Crew & Facilities production request
  					|Location         |
  					|Rock Center      |
  	When user selects Set Location on Extend or Bridge Crew & Facilities production request
  					|Set Location   |
  					|3A Studio      |
  	When user selects Control Room & Crew on Extend or Bridge Crew & Facilities production request
  					|Control Room & Crew|
  					|Yes                |
  	When user selects Control Room Location on Extend or Bridge Crew & Facilities production request
  					|Control Room Location | 
  					|Rock Center           |
  	When user selects Control Room on Extend or Bridge Crew & Facilities production request
  					|Control Room  | 
  					|CR 1A         |
  	When user clicks on "Submit" button
  	Then user sees modal for successful "<Form Name>" request creation
  	Examples:
    				|Form Name                         |
    				|Extend or Bridge Crew & Facilities|