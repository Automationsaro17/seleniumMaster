@NcxUnifiedToolPhase2 @FirearmsOnPremises @ProducerDashboard @UserStoryWise @NRT_11905
Feature: NCX Unified Tool Phase 2: Firearms on Premises Reskin

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role
    And "producer" becomes default requester for every request created by it
    
    
  @NcxUnifiedToolPhase2 @PSEQA @PSEQA_7927
  Scenario Outline: TC_003_StudioForm_NRT-11905 verify the total number of sub sections and headers of it in the request form. 
  	And  user clicks on forms link
  	And  user selects "<Form Name>" form
  	Then user verifies the form sections on Firearms on Premises production form
    Examples:
    				|Form Name                 |
    				|Firearms on Premises      |
    				
  @NcxUnifiedToolPhase2 @PSEQA @PSEQA_7926
  Scenario Outline: TC_002_StudioForm_NRT-11905_ Verify that the "Firearms on Premises" text is displayed above the form. 
  	And  user clicks on forms link
  	And  user selects "<Form Name>" form
  	Then user verifies the form title "Firearms on Premises" on "<Form Name>" production form
    Examples:
    				|Form Name                 |
    				|Firearms on Premises      |
    				
  @NcxUnifiedToolPhase2 @PSEQA @PSEQA_7930
  Scenario Outline: TC_006_StudioForm_NRT_11905_Status verification on the request page. 
  	And  user clicks on forms link
  	And  user selects "<Form Name>" form
  	Then user verifies that the status is '<Status>' for "<Form Name>" Production form
    Examples:
    				|Form Name                 | Status |
    				|Firearms on Premises      | NEW    |
    				
  @NcxUnifiedToolPhase2 @PSEQA @PSEQA_7931
  Scenario Outline: TC_007_StudioForm_NRT_11905_Requester details verification on request page 
  	And  user clicks on forms link
  	And  user selects "<Form Name>" form
    Then user verifies that it is added as requester in Requesters section of "<Form Name>" production form
    And  user verifies the fields present in "<Section Name>" section of Firearms on Premises Production form
    And  user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
    When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
    Examples:
    				|Form Name                 | Section Name  | Option1 | Option2 |
    				|Firearms on Premises      | REQUESTER(S)  | Submit  | ok      |
    				
  @NcxUnifiedToolPhase2 @PSEQA @PSEQA_7932 @PSEQA_7928 @PSEQA_7929
  Scenario Outline: TC_008_StudioForm_NRT_11905_ General details block field verification. 
  	And  user clicks on forms link
  	And  user selects "<Form Name>" form
  	Then user verifies the fields present in "<Section Name>" section of Firearms on Premises Production form
  	And  user checks placeholder of "Division" field in "<Section Name>" section on Firearm on Premises Production request
  	And  user verifies whether "<Section Name>" section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
    And  user checks error for "Division" required field in "<Section Name>" section on Firearm on Premises Production request
  	When user selects Division in "<Section Name>" section on Firearms on Premises production request
  					|Division    |
  					|MSNBC       |
  	Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	And  user checks error not displayed for "Division" required field in "<Section Name>" section on Firearm on Premises Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user checks error not displayed for "Division" required field in "<Section Name>" section on Firearm on Premises Production request
    And  user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	And  user verifies the fields present in "<Section Name>" section of Firearms on Premises Production form
    Examples:
    				|Form Name                 | Section Name    | Option1 | Option2 |
    				|Firearms on Premises      | GENERAL DETAILS | Submit  | ok      |
    				
  @NcxUnifiedToolPhase2 @PSEQA @PSEQA_7937 @PSEQA_7928 @PSEQA_7929
  Scenario Outline: TC_013_StudioForm_NRT_11905_Details block field verification. 
  	And  user clicks on forms link
  	And  user selects "<Form Name>" form
  	Then user verifies the fields present in "<Section Name>" section of Firearms on Premises Production form
  	Then user verifies whether "<Section Name>" section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
  	When user selects Details and Notes in "<Section Name>" section on Firearms on Premises production request
  					|Details and Notes                                                           |
  					|This is a sample text filled by automation in Details and Notes field       |
  	Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	Then user verifies the fields present in "<Section Name>" section of Firearms on Premises Production form
  	When user clears Details and Notes in "<Section Name>" section on Firearms on Premises production request
  	Then user verifies whether "<Section Name>" section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
    Examples:
    				|Form Name                 |Section Name | Option1 | Option2 |
    				|Firearms on Premises      |DETAILS      | Submit  | ok      |
    				
  @NcxUnifiedToolPhase2 @PSEQA @PSEQA_7934 @PSEQA_7928 @PSEQA_7929
  Scenario Outline: TC_010_StudioForm_NRT_11905_To verify details on show info block. 
  	And  user clicks on forms link
  	And  user selects "<Form Name>" form
  	Then user verifies the fields present in "<Section Name>" section of Firearms on Premises Production form
  	Then user checks placeholder of "Air Platform" field in "<Section Name>" section on Firearm on Premises Production request
  	Then user checks placeholder of "Show Unit or Project Name" field in "<Section Name>" section on Firearm on Premises Production request
  	Then user verifies whether "<Section Name>" section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
    Then user checks error for "Air Platform" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error for "Show Unit or Project Name" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error for "Arrival Date" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error for "Arrival Time" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error for "Departure Time" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error for "Departure Date" required field in "<Section Name>" section on Firearm on Premises Production request
  	When user selects Air Platform in "<Section Name>" section on Firearms on Premises production request
  					|Air Platform|
  					|Internal    |
  	Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user selects Show Unit or Project Name in "<Section Name>" section on Firearms on Premises production request
  					|Show Unit or Project Name|
  					|ALL SHOWS                |
  	Then user checks error not displayed for "Air Platform" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error not displayed for "Show Unit or Project Name" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error for "Arrival Date" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error for "Arrival Time" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error for "Departure Time" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error for "Departure Date" required field in "<Section Name>" section on Firearm on Premises Production request
  	Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user checks error not displayed for "Air Platform" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error not displayed for "Show Unit or Project Name" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error for "Arrival Date" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error for "Arrival Time" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error for "Departure Time" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error for "Departure Date" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user selects Arrival Date in "<Section Name>" section on Firearms on Premises production request
  					|Arrival Date  |
  					|currentDate+3 |
  	Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user selects Arrival Time in "<Section Name>" section on Firearms on Premises production request
  					|Arrival Time    |
  					|1:15 PM         |
  	Then user checks error not displayed for "Air Platform" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error not displayed for "Show Unit or Project Name" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error not displayed for "Arrival Date" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error not displayed for "Arrival Time" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error for "Departure Time" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error for "Departure Date" required field in "<Section Name>" section on Firearm on Premises Production request
  	Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user selects Departure Date in "<Section Name>" section on Firearms on Premises production request
  					|Departure Date    |
  					|currentDate+5     |
  	Then user checks error not displayed for "Air Platform" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error not displayed for "Show Unit or Project Name" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error not displayed for "Arrival Date" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error not displayed for "Arrival Time" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error for "Departure Time" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error not displayed for "Departure Date" required field in "<Section Name>" section on Firearm on Premises Production request
  	Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user selects Departure Time in "<Section Name>" section on Firearms on Premises production request
  					|Departure Time    |
  					|11:59 AM          |
  	Then user checks error not displayed for "Air Platform" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error not displayed for "Show Unit or Project Name" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error not displayed for "Arrival Date" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error not displayed for "Arrival Time" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error not displayed for "Departure Time" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error not displayed for "Departure Date" required field in "<Section Name>" section on Firearm on Premises Production request
  	Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user checks error not displayed for "Air Platform" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error not displayed for "Show Unit or Project Name" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error not displayed for "Arrival Date" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error not displayed for "Arrival Time" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error not displayed for "Departure Time" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error not displayed for "Departure Date" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	Then user verifies the fields present in "<Section Name>" section of Firearms on Premises Production form
  	When user selects Division in "GENERAL DETAILS" section on Firearms on Premises production request
  					|Division    |
  					|CNBC        |
  	Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	Then user verifies the fields present in "<Section Name>" section of Firearms on Premises Production form
  	When user selects Work Order # in "<Section Name>" section on Firearms on Premises production request
  					|Work Order #                                                       |
  					|This is a text given via automation in Work Order # field          |
  	Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	When user selects Show Unit or Project Name in "<Section Name>" section on Firearms on Premises production request
  					|Show Unit or Project Name|
  					|Other                    |
  	Then user checks error not displayed for "Air Platform" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error not displayed for "Show Unit or Project Name" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error not displayed for "Arrival Date" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error not displayed for "Arrival Time" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error not displayed for "Departure Time" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error not displayed for "Departure Date" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error for "Other" required field in "<Section Name>" section on Firearm on Premises Production request
  	Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user checks error not displayed for "Air Platform" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error not displayed for "Show Unit or Project Name" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error not displayed for "Arrival Date" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error not displayed for "Arrival Time" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error not displayed for "Departure Time" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error not displayed for "Departure Date" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error for "Other" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user selects Other in "<Section Name>" section on Firearms on Premises production request
  					|Other                                              |
  					|This is value given via automation for Other field |
  	Then user checks error not displayed for "Air Platform" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error not displayed for "Show Unit or Project Name" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error not displayed for "Arrival Date" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error not displayed for "Arrival Time" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error not displayed for "Departure Time" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error not displayed for "Departure Date" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error not displayed for "Other" required field in "<Section Name>" section on Firearm on Premises Production request
  	Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user checks error not displayed for "Air Platform" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error not displayed for "Show Unit or Project Name" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error not displayed for "Arrival Date" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error not displayed for "Arrival Time" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error not displayed for "Departure Time" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error not displayed for "Departure Date" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user checks error not displayed for "Other" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	Then user verifies the fields present in "<Section Name>" section of Firearms on Premises Production form
    Examples:
    				|Form Name                 |Section Name | Option1  | Option2  |
    				|Firearms on Premises      |SHOW INFO    | Submit   | ok       |
    				
  @NcxUnifiedToolPhase2 @PSEQA @PSEQA_7933 @PSEQA_7928 @PSEQA_7929
  Scenario Outline: TC_009_StudioForm_NRT_11905_Talent block field verification. 
  	And  user clicks on forms link
  	And  user selects "<Form Name>" form
  	Then user verifies the fields present in "<Section Name>" section of Firearms on Premises Production form
  	And  user checks placeholder of Talent field in "<Section Name>" section on Firearm on Premises Production request
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
    				|Name       |
    				|Velshi, Ali|
    Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
    When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	And  user verifies the fields present in "<Section Name>" section of Firearms on Premises Production form
    Examples:
    				|Form Name                 |Section Name | Option1  | Option2 |
    				|Firearms on Premises      |TALENT       | Submit   | ok      |
    				
  @NcxUnifiedToolPhase2 @PSEQA @PSEQA_7935 @PSEQA_7928 @PSEQA_7929
  Scenario Outline: TC_011_StudioForm_NRT_11905_Set location block verification with different locations. 
  	And  user clicks on forms link
  	And  user selects "<Form Name>" form
  	Then user verifies the fields present in "<Section Name>" section of Firearms on Premises Production form
  	And  user verifies whether "<Section Name>" section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
  	And  user checks placeholder of "Location" field in "<Section Name>" section on Firearm on Premises Production request
  	And  user checks placeholder of "Set Location" field in "<Section Name>" section on Firearm on Premises Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user checks error for "Location" required field in "<Section Name>" section on Firearm on Premises Production request
    And  user checks error for "Set Location" required field in "<Section Name>" section on Firearm on Premises Production request
    And  user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user selects Location in "<Section Name>" section on Firearms on Premises production request
  					|Position     |Location         |
  					|1            |Rock Center      |
  	Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
    Then user checks error not displayed for "Location" required field in "<Section Name>" section on Firearm on Premises Production request
    And  user checks error for "Set Location" required field in "<Section Name>" section on Firearm on Premises Production request
    And  user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user selects Set Location in "<Section Name>" section on Firearms on Premises production request
  					|Position     |Set Location   |
  					|1            |3A Studio      |
  	Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
    Then user checks error not displayed for "Location" required field in "<Section Name>" section on Firearm on Premises Production request
    And  user checks error not displayed for "Set Location" required field in "<Section Name>" section on Firearm on Premises Production request
    And  user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	When user clicks on + Location button in "<Section Name>" section of Firearm on Premises Production form
    Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user selects Location in "<Section Name>" section on Firearms on Premises production request
  					|Position     |Location         |
  					|2            |Field            |
    And user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user selects Address in "<Section Name>" section on Firearms on Premises production request
  					|Position     |Address                                     |
  					|2            |Example address in the address field 2      |
  	Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	When user clicks on + Location button in "<Section Name>" section of Firearm on Premises Production form
  	Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user selects Location in "<Section Name>" section on Firearms on Premises production request
  					|Position     |Location         |
  					|3            |Field            |
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
  	Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
    Then user checks error not displayed for "Location" required field in "<Section Name>" section on Firearm on Premises Production request
    And  user checks error for "Address" required field in "<Section Name>" section on Firearm on Premises Production request
    And  user checks error not displayed for "Set Location" required field in "<Section Name>" section on Firearm on Premises Production request
    And user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user selects Address in "<Section Name>" section on Firearms on Premises production request
  					|Position     |Address                                     |
  					|3            |Example address in the address field 3      |
  	Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
    Then user checks error not displayed for "Location" required field in "<Section Name>" section on Firearm on Premises Production request
    And  user checks error not displayed for "Address" required field in "<Section Name>" section on Firearm on Premises Production request
    And  user checks error not displayed for "Set Location" required field in "<Section Name>" section on Firearm on Premises Production request
    Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	And  user verifies the fields present in "<Section Name>" section of Firearms on Premises Production form
    Examples:
    				|Form Name                 |Section Name | Option1 | Option2 |
    				|Firearms on Premises      |SET LOCATION | Submit  | ok      |
    				
  @NcxUnifiedToolPhase2 @PSEQA @PSEQA_7936 @PSEQA_7928 @PSEQA_7929
  Scenario Outline: TC_012_StudioForm_NRT_11905_ To verify fields of Firearms information block. 
  	And  user clicks on forms link
  	And  user selects "<Form Name>" form
  	Then user verifies the fields present in "<Section Name>" section of Firearms on Premises Production form
  	And  user verifies whether "<Section Name>" section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
    And  user checks error for "Type of Firearm(s)" required field in "<Section Name>" section on Firearm on Premises Production request
    And  user checks error for "How Many" required field in "<Section Name>" section on Firearm on Premises Production request
    And  user checks error for "Type" required field in "<Section Name>" section on Firearm on Premises Production request
  	When user selects Type of Firearm(s) in "<Section Name>" section on Firearms on Premises production request
  					|Position     |Type of Firearm(s)  |
  					|1            |Licensed Guns       |
  	Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
    And  user checks error not displayed for "Type of Firearm(s)" required field in "<Section Name>" section on Firearm on Premises Production request
    And  user checks error for "How Many" required field in "<Section Name>" section on Firearm on Premises Production request
    And  user checks error for "Type" required field in "<Section Name>" section on Firearm on Premises Production request
  	When user selects How Many in "<Section Name>" section on Firearms on Premises production request
  					|Position     |How Many | 
  					|1            |12       |
  	Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
    And  user checks error not displayed for "Type of Firearm(s)" required field in "<Section Name>" section on Firearm on Premises Production request
    And  user checks error not displayed for "How Many" required field in "<Section Name>" section on Firearm on Premises Production request
    And  user checks error for "Type" required field in "<Section Name>" section on Firearm on Premises Production request
  	When user selects Type in "<Section Name>" section on Firearms on Premises production request
  					|Position     |Type              | 
  					|1            |Functioning       |
  	Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
    And  user checks error not displayed for "Type of Firearm(s)" required field in "<Section Name>" section on Firearm on Premises Production request
    And  user checks error not displayed for "How Many" required field in "<Section Name>" section on Firearm on Premises Production request
    And  user checks error not displayed for "Type" required field in "<Section Name>" section on Firearm on Premises Production request
  	When user clicks on + Firearm button in "<Section Name>" section of Firearm on Premises Production form
  	Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
    And  user checks error for "Type of Firearm(s)" required field in "<Section Name>" section on Firearm on Premises Production request
    And  user checks error for "How Many" required field in "<Section Name>" section on Firearm on Premises Production request
    And  user checks error for "Type" required field in "<Section Name>" section on Firearm on Premises Production request
  	When user selects Type of Firearm(s) in "<Section Name>" section on Firearms on Premises production request
  					|Position     |Type of Firearm(s)  |
  					|2            |Licensed Grenades   |
  	Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
    And  user checks error not displayed for "Type of Firearm(s)" required field in "<Section Name>" section on Firearm on Premises Production request
    And  user checks error for "How Many" required field in "<Section Name>" section on Firearm on Premises Production request
    And  user checks error for "Type" required field in "<Section Name>" section on Firearm on Premises Production request
  	When user selects How Many in "<Section Name>" section on Firearms on Premises production request
  					|Position     |How Many | 
  					|2            |101      |
  	Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
    And  user checks error not displayed for "Type of Firearm(s)" required field in "<Section Name>" section on Firearm on Premises Production request
    And  user checks error not displayed for "How Many" required field in "<Section Name>" section on Firearm on Premises Production request
    And  user checks error for "Type" required field in "<Section Name>" section on Firearm on Premises Production request
  	When user selects Type in "<Section Name>" section on Firearms on Premises production request
  					|Position     |Type              | 
  					|2            |Replica           |
  	Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
    And  user checks error not displayed for "Type of Firearm(s)" required field in "<Section Name>" section on Firearm on Premises Production request
    And  user checks error not displayed for "How Many" required field in "<Section Name>" section on Firearm on Premises Production request
    And  user checks error not displayed for "Type" required field in "<Section Name>" section on Firearm on Premises Production request
  	When user clicks on + Firearm button in "<Section Name>" section of Firearm on Premises Production form
  	Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
    And  user checks error for "Type of Firearm(s)" required field in "<Section Name>" section on Firearm on Premises Production request
    And  user checks error for "How Many" required field in "<Section Name>" section on Firearm on Premises Production request
    And  user checks error for "Type" required field in "<Section Name>" section on Firearm on Premises Production request
  	When user selects Type of Firearm(s) in "<Section Name>" section on Firearms on Premises production request
  					|Position     |Type of Firearm(s)  |
  					|3            |Fighter helicopters |
  	Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
    And  user checks error not displayed for "Type of Firearm(s)" required field in "<Section Name>" section on Firearm on Premises Production request
    And  user checks error for "How Many" required field in "<Section Name>" section on Firearm on Premises Production request
    And  user checks error for "Type" required field in "<Section Name>" section on Firearm on Premises Production request
  	When user selects How Many in "<Section Name>" section on Firearms on Premises production request
  					|Position     |How Many | 
  					|3            |1        |
  	Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
    And  user checks error not displayed for "Type of Firearm(s)" required field in "<Section Name>" section on Firearm on Premises Production request
    And  user checks error not displayed for "How Many" required field in "<Section Name>" section on Firearm on Premises Production request
    And  user checks error for "Type" required field in "<Section Name>" section on Firearm on Premises Production request
  	When user selects Type in "<Section Name>" section on Firearms on Premises production request
  					|Position     |Type              | 
  					|3            |Functioning       |
  	Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
    And  user checks error not displayed for "Type of Firearm(s)" required field in "<Section Name>" section on Firearm on Premises Production request
    And  user checks error not displayed for "How Many" required field in "<Section Name>" section on Firearm on Premises Production request
    And  user checks error not displayed for "Type" required field in "<Section Name>" section on Firearm on Premises Production request
  	And  user verifies the fields present in "<Section Name>" section of Firearms on Premises Production form
    Examples:
    				|Form Name                 | Section Name           | Option1  | Option2 |
    				|Firearms on Premises      | FIREARM(S) INFORMATION | Submit   | ok      |
    				
   	@NcxUnifiedToolPhase2 @PSEQA @PSEQA_7938
  	Scenario Outline: TC_014_StudioForm_NRT_11905_To verify the request can be submitted successfuly.
  	And  user clicks on forms link
  	And  user selects "<Form Name>" form
  	When user selects Division in "GENERAL DETAILS" section on Firearms on Premises production request
  					|Division    |
  					|CNBC       |
  	And user adds requester to the form
  					|Requester         |
  					|Worker 11, STORM  |
  	And  user selects Details and Notes in "DETAILS" section on Firearms on Premises production request
  					|Details and Notes                                                           |
  					|This is a sample text filled by automation in Details and Notes field       |
  	And  user selects Air Platform in "SHOW INFO" section on Firearms on Premises production request
  					|Air Platform|
  					|Internal    |
  	And  user selects Show Unit or Project Name in "SHOW INFO" section on Firearms on Premises production request
  					|Show Unit or Project Name|
  					|OTHER                    |
  	And  user selects Arrival Date in "SHOW INFO" section on Firearms on Premises production request
  					|Arrival Date  |
  					|currentDate+3 |
  	And  user selects Arrival Time in "SHOW INFO" section on Firearms on Premises production request
  					|Arrival Time    |
  					|1:15 PM         |
  	And  user selects Departure Date in "SHOW INFO" section on Firearms on Premises production request
  					|Departure Date    |
  					|currentDate+5     |
  	And  user selects Departure Time in "SHOW INFO" section on Firearms on Premises production request
  					|Departure Time    |
  					|11:59 AM          |
  	And  user selects Work Order # in "SHOW INFO" section on Firearms on Premises production request
  					|Work Order #                                                       |
  					|This is a text given via automation in Work Order # field          |
  	And  user selects Show Unit or Project Name in "SHOW INFO" section on Firearms on Premises production request
  					|Show Unit or Project Name|
  					|Other                    |
  	And  user selects Other in "SHOW INFO" section on Firearms on Premises production request
  					|Other                                              |
  					|This is value given via automation for Other field |
  	And  user add specific user in Talent section
    				|Name           | 
    				|Memoli, Mike   |
    And  user add specific user in Talent section
    				|Name       |
    				|Velshi, Ali|
  	And  user selects Location in "SET LOCATION" section on Firearms on Premises production request
  					|Position     |Location         |
  					|1            |Rock Center      |
  	And  user selects Set Location in "SET LOCATION" section on Firearms on Premises production request
  					|Position     |Set Location   |
  					|1            |3A Studio      |
		And  user clicks on + Location button in "SET LOCATION" section of Firearm on Premises Production form
  	And  user selects Location in "SET LOCATION" section on Firearms on Premises production request
  					|Position     |Location         |
  					|2            |Field            |
  	And  user selects Address in "SET LOCATION" section on Firearms on Premises production request
  					|Position     |Address                                     |
  					|2            |Example address in the address field 2      |
		And  user clicks on + Location button in "SET LOCATION" section of Firearm on Premises Production form
  	And  user selects Location in "SET LOCATION" section on Firearms on Premises production request
  					|Position     |Location         |
  					|3            |Field            |
  	And  user selects Address in "SET LOCATION" section on Firearms on Premises production request
  					|Position     |Address                                     |
  					|3            |Example address in the address field 3      |
  	And  user selects Type of Firearm(s) in "FIREARM(S) INFORMATION" section on Firearms on Premises production request
  					|Position     |Type of Firearm(s)  |
  					|1            |Licensed Guns       |
  	And  user selects How Many in "FIREARM(S) INFORMATION" section on Firearms on Premises production request
  					|Position     |How Many | 
  					|1            |7        |
  	And  user selects Type in "FIREARM(S) INFORMATION" section on Firearms on Premises production request
  					|Position     |Type              | 
  					|1            |Functioning       |
  	And  user clicks on + Firearm button in "FIREARM(S) INFORMATION" section of Firearm on Premises Production form
  	And  user selects Type of Firearm(s) in "FIREARM(S) INFORMATION" section on Firearms on Premises production request
  					|Position     |Type of Firearm(s)  |
  					|2            |Licensed Grenades   |
  	And  user selects How Many in "FIREARM(S) INFORMATION" section on Firearms on Premises production request
  					|Position     |How Many | 
  					|2            |10      |
  	And  user selects Type in "FIREARM(S) INFORMATION" section on Firearms on Premises production request
  					|Position     |Type              | 
  					|2            |Replica           |
  	And  user clicks on + Firearm button in "FIREARM(S) INFORMATION" section of Firearm on Premises Production form
  	And  user selects Type of Firearm(s) in "FIREARM(S) INFORMATION" section on Firearms on Premises production request
  					|Position     |Type of Firearm(s)  |
  					|3            |Fighter helicopters |
  	And  user selects How Many in "FIREARM(S) INFORMATION" section on Firearms on Premises production request
  					|Position     |How Many | 
  					|3            |1        |
  	And  user selects Type in "FIREARM(S) INFORMATION" section on Firearms on Premises production request
  					|Position     |Type              | 
  					|3            |Functioning       |
  	And  user clicks on "Submit" button
  	Then user sees modal for successful "<Form Name>" request creation
  	And  user clicks on "ok" button
  	When user opens the created request
  	Then user verifies the value displayed for Division field in GENERAL DETAILS section in readonly mode on Firearms on Premises production request
  	And user verifies that status of Firearms on Premises production request is "COMPLETED"
  	And user verifies the Talents in TALENT section in readonly mode on Firearms on Premises production request
  	And user verifies the Requesters in the REQUESTER(S) section of request
  	And user verifies the value displayed for Details and Notes field in DETAILS section in readonly mode on Firearms on Premises production request
  	And user verifies the values displayed in FIREARM(S) INFORMATION section in readonly mode on Firearms on Premises production request
  	And user verifies the values displayed in SET LOCATION section in readonly mode on Firearms on Premises production request
  	And user verifies the value displayed for "Air Platform" field in SHOW INFO section in readonly mode on Firearms on Premises production request
  	And user verifies the value displayed for "Show Unit or Project Name" field in SHOW INFO section in readonly mode on Firearms on Premises production request
  	And user verifies the value displayed for "Arrival Date" field in SHOW INFO section in readonly mode on Firearms on Premises production request
  	And user verifies the value displayed for "Arrival Time" field in SHOW INFO section in readonly mode on Firearms on Premises production request
  	And user verifies the value displayed for "Departure Date" field in SHOW INFO section in readonly mode on Firearms on Premises production request
  	And user verifies the value displayed for "Departure Time" field in SHOW INFO section in readonly mode on Firearms on Premises production request
  	And user verifies the value displayed for "Work Order #" field in SHOW INFO section in readonly mode on Firearms on Premises production request
    Examples:
    				|Form Name                 |
    				|Firearms on Premises      |