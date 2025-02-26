@NcxUnifiedToolPhase2 @AnimalsOnPremises @ProducerDashboard @UserStoryWise @NRT_11904
Feature: NCX Unified Tool Phase 2: Animals on Premises Reskin

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role
    
  @NcxUnifiedToolPhase2 @PSEQA @PSEQA_7911
  Scenario Outline: TC_003_StudioForm_NRT-11904 verify the total number of sub sections and headers of it in the request form. 
  	And  user clicks on forms link
  	And  user selects "<Form Name>" form
  	Then user verifies the form sections on Animals on Premises production form
    Examples:
    				|Form Name                 |
    				|Animals on Premises       |
    				
  @NcxUnifiedToolPhase2 @PSEQA @PSEQA_7910
  Scenario Outline: TC_002_StudioForm_NRT-11904_ Verify that the "Animals on Premises" text is displayed above the form. 
  	And  user clicks on forms link
  	And  user selects "<Form Name>" form
  	Then user verifies the form title "Animals on Premises" on "<Form Name>" production form
    Examples:
    				|Form Name                 |
    				|Animals on Premises       |
    				
  @NcxUnifiedToolPhase2 @PSEQA @PSEQA_7914
  Scenario Outline: TC_006_StudioForm_NRT_11904_Default Status verification on the request page. 
  	And  user clicks on forms link
  	And  user selects "<Form Name>" form
  	Then user verifies that the status is '<Status>' for "<Form Name>" Production form
    Examples:
    				|Form Name            | Status |
    				|Animals on Premises  | NEW    |
    				
  @NcxUnifiedToolPhase2 @PSEQA @PSEQA_7915 @PSEQA_7912 @PSEQA_7913
  Scenario Outline: TC_007_StudioForm_NRT_11904_Requester details verification on request page. 
  	And  user clicks on forms link
  	And  user selects "<Form Name>" form
    Then user verifies that it is added as requester in Requesters section of "<Form Name>" production form
    And  user verifies the fields present in "<Section Name>" section of Animals on Premises Production form
    And  user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
    When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
    Examples:
    				|Form Name           | Section Name  | Option1 | Option2 |
    				|Animals on Premises | REQUESTER(S)  | Submit  | ok      |
    				
  @NcxUnifiedToolPhase2 @PSEQA @PSEQA_7916 @PSEQA_7912 @PSEQA_7913
  Scenario Outline: TC_008_StudioForm_NRT_11904_ General details block field verification. 
  	And  user clicks on forms link
  	And  user selects "<Form Name>" form
  	Then user verifies the fields present in "<Section Name>" section of Animals on Premises Production form
  	And  user checks placeholder of "Division" field in "<Section Name>" section on Animals on Premises Production request
  	And  user verifies whether "<Section Name>" section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
    And  user checks error for "Division" required field in "<Section Name>" section on Animals on Premises Production request
  	When user selects Division in "<Section Name>" section on Animals on Premises production request
  					|Division    |
  					|MSNBC       |
  	Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	And  user checks error not displayed for "Division" required field in "<Section Name>" section on Animals on Premises Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user checks error not displayed for "Division" required field in "<Section Name>" section on Animals on Premises Production request
    And  user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	And  user verifies the fields present in "<Section Name>" section of Animals on Premises Production form
    Examples:
    				|Form Name                 | Section Name    | Option1 | Option2 |
    				|Animals on Premises       | GENERAL DETAILS | Submit  | ok      |
    				
  @NcxUnifiedToolPhase2 @PSEQA @PSEQA_7921 @PSEQA_7912 @PSEQA_7913
  Scenario Outline: TC_013_StudioForm_NRT_11904_Details block field verification. 
  	And  user clicks on forms link
  	And  user selects "<Form Name>" form
  	Then user verifies the fields present in "<Section Name>" section of Animals on Premises Production form
  	Then user verifies whether "<Section Name>" section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
  	When user selects Details and Notes in "<Section Name>" section on Animals on Premises production request
  					|Details and Notes                                                           |
  					|This is a sample text filled by automation in Details and Notes field       |
  	Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	Then user verifies the fields present in "<Section Name>" section of Animals on Premises Production form
  	When user clears Details and Notes in "<Section Name>" section on Animals on Premises production request
  	Then user verifies whether "<Section Name>" section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
    Examples:
    				|Form Name                 |Section Name | Option1 | Option2 |
    				|Animals on Premises       |DETAILS      | Submit  | ok      |
    				
  @NcxUnifiedToolPhase2 @PSEQA @PSEQA_7918 @PSEQA_7912 @PSEQA_7913
  Scenario Outline: TC_010_StudioForm_NRT_11904_To verify details on show info block. 
  	And  user clicks on forms link
  	And  user selects "<Form Name>" form
  	Then user verifies the fields present in "<Section Name>" section of Animals on Premises Production form
  	Then user checks placeholder of "Air Platform" field in "<Section Name>" section on Animals on Premises Production request
  	Then user checks placeholder of "Show Unit or Project Name" field in "<Section Name>" section on Animals on Premises Production request
  	Then user verifies whether "<Section Name>" section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
    Then user checks error for "Air Platform" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error for "Show Unit or Project Name" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error for "Arrival Date" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error for "Arrival Time" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error for "Departure Time" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error for "Departure Date" required field in "<Section Name>" section on Animals on Premises Production request
  	When user selects Air Platform in "<Section Name>" section on Animals on Premises production request
  					|Air Platform|
  					|Internal    |
  	Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user selects Show Unit or Project Name in "<Section Name>" section on Animals on Premises production request
  					|Show Unit or Project Name|
  					|ALL SHOWS                |
  	Then user checks error not displayed for "Air Platform" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error not displayed for "Show Unit or Project Name" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error for "Arrival Date" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error for "Arrival Time" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error for "Departure Time" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error for "Departure Date" required field in "<Section Name>" section on Animals on Premises Production request
  	Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user checks error not displayed for "Air Platform" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error not displayed for "Show Unit or Project Name" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error for "Arrival Date" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error for "Arrival Time" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error for "Departure Time" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error for "Departure Date" required field in "<Section Name>" section on Animals on Premises Production request
    Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user selects Arrival Date in "<Section Name>" section on Animals on Premises production request
  					|Arrival Date  |
  					|currentDate+3 |
  	Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user selects Arrival Time in "<Section Name>" section on Animals on Premises production request
  					|Arrival Time    |
  					|1:15 PM         |
  	Then user checks error not displayed for "Air Platform" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error not displayed for "Show Unit or Project Name" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error not displayed for "Arrival Date" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error not displayed for "Arrival Time" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error for "Departure Time" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error for "Departure Date" required field in "<Section Name>" section on Animals on Premises Production request
  	Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user selects Departure Date in "<Section Name>" section on Animals on Premises production request
  					|Departure Date    |
  					|currentDate+5     |
  	Then user checks error not displayed for "Air Platform" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error not displayed for "Show Unit or Project Name" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error not displayed for "Arrival Date" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error not displayed for "Arrival Time" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error for "Departure Time" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error not displayed for "Departure Date" required field in "<Section Name>" section on Animals on Premises Production request
  	Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user selects Departure Time in "<Section Name>" section on Animals on Premises production request
  					|Departure Time    |
  					|11:59 AM          |
  	Then user checks error not displayed for "Air Platform" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error not displayed for "Show Unit or Project Name" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error not displayed for "Arrival Date" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error not displayed for "Arrival Time" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error not displayed for "Departure Time" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error not displayed for "Departure Date" required field in "<Section Name>" section on Animals on Premises Production request
  	Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user checks error not displayed for "Air Platform" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error not displayed for "Show Unit or Project Name" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error not displayed for "Arrival Date" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error not displayed for "Arrival Time" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error not displayed for "Departure Time" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error not displayed for "Departure Date" required field in "<Section Name>" section on Animals on Premises Production request
    Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	Then user verifies the fields present in "<Section Name>" section of Animals on Premises Production form
  	When user selects Division in "GENERAL DETAILS" section on Animals on Premises production request
  					|Division    |
  					|CNBC        |
  	Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	Then user verifies the fields present in "<Section Name>" section of Animals on Premises Production form
  	When user selects Work Order # in "<Section Name>" section on Animals on Premises production request
  					|Work Order #                                                       |
  					|This is a text given via automation in Work Order # field          |
  	Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	When user selects Show Unit or Project Name in "<Section Name>" section on Animals on Premises production request
  					|Show Unit or Project Name|
  					|Other                    |
  	Then user checks error not displayed for "Air Platform" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error not displayed for "Show Unit or Project Name" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error not displayed for "Arrival Date" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error not displayed for "Arrival Time" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error not displayed for "Departure Time" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error not displayed for "Departure Date" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error for "Other" required field in "<Section Name>" section on Animals on Premises Production request
  	Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user checks error not displayed for "Air Platform" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error not displayed for "Show Unit or Project Name" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error not displayed for "Arrival Date" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error not displayed for "Arrival Time" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error not displayed for "Departure Time" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error not displayed for "Departure Date" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error for "Other" required field in "<Section Name>" section on Animals on Premises Production request
    Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user selects Other in "<Section Name>" section on Animals on Premises production request
  					|Other                                              |
  					|This is value given via automation for Other field |
  	Then user checks error not displayed for "Air Platform" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error not displayed for "Show Unit or Project Name" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error not displayed for "Arrival Date" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error not displayed for "Arrival Time" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error not displayed for "Departure Time" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error not displayed for "Departure Date" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error not displayed for "Other" required field in "<Section Name>" section on Animals on Premises Production request
  	Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user checks error not displayed for "Air Platform" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error not displayed for "Show Unit or Project Name" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error not displayed for "Arrival Date" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error not displayed for "Arrival Time" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error not displayed for "Departure Time" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error not displayed for "Departure Date" required field in "<Section Name>" section on Animals on Premises Production request
    Then user checks error not displayed for "Other" required field in "<Section Name>" section on Animals on Premises Production request
    Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	Then user verifies the fields present in "<Section Name>" section of Animals on Premises Production form
    Examples:
    				|Form Name                 |Section Name | Option1  | Option2  |
    				|Animals on Premises       |SHOW INFO    | Submit   | ok       |
    				
  @NcxUnifiedToolPhase2 @PSEQA @PSEQA_7917 @PSEQA_7912 @PSEQA_7913
  Scenario Outline: TC_009_StudioForm_NRT_11904_Talent block field verification. 
  	And  user clicks on forms link
  	And  user selects "<Form Name>" form
  	Then user verifies the fields present in "<Section Name>" section of Animals on Premises Production form
  	And  user checks placeholder of Talent field in "TALENT" section on Animals on Premises Production request
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
  	And  user verifies the fields present in "<Section Name>" section of Animals on Premises Production form
    Examples:
    				|Form Name                 |Section Name | Option1  | Option2 |
    				|Animals on Premises       |TALENT       | Submit   | ok      |
    				
  @NcxUnifiedToolPhase2 @PSEQA @PSEQA_7919 @PSEQA_7912 @PSEQA_7913
  Scenario Outline: TC_011_StudioForm_NRT_11904_ Set location block verification. 
  	And  user clicks on forms link
  	And  user selects "<Form Name>" form
  	Then user verifies the fields present in "<Section Name>" section of Animals on Premises Production form
  	And  user verifies whether "<Section Name>" section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
  	And  user checks placeholder of "Location" field in "<Section Name>" section on Animals on Premises Production request
  	And  user checks placeholder of "Set Location" field in "<Section Name>" section on Animals on Premises Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user checks error for "Location" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error for "Set Location" required field in "<Section Name>" section on Animals on Premises Production request
    And  user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user selects Location in "<Section Name>" section on Animals on Premises production request
  					|Position     |Location         |
  					|1            |Rock Center      |
  	Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
    Then user checks error not displayed for "Location" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error for "Set Location" required field in "<Section Name>" section on Animals on Premises Production request
    And  user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user selects Set Location in "<Section Name>" section on Animals on Premises production request
  					|Position     |Set Location   |
  					|1            |3A Studio      |
  	Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
    Then user checks error not displayed for "Location" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error not displayed for "Set Location" required field in "<Section Name>" section on Animals on Premises Production request
    And  user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	When user clicks on `+ Location` button in "<Section Name>" section of Animals on Premises Production form
    Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user selects Location in "<Section Name>" section on Animals on Premises production request
  					|Position     |Location         |
  					|2            |Rock Center      |
    And user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user selects Set Location in "<Section Name>" section on Animals on Premises production request
  					|Position     |Set Location   |
  					|2            |3B Studio      |
  	Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	When user clicks on `+ Location` button in "<Section Name>" section of Animals on Premises Production form
  	Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user selects Location in "<Section Name>" section on Animals on Premises production request
  					|Position     |Location         |
  					|3            |Rock Center      |
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
  	Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
    Then user checks error not displayed for "Location" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error for "Set Location" required field in "<Section Name>" section on Animals on Premises Production request
    And user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user selects Set Location in "<Section Name>" section on Animals on Premises production request
  					|Position     |Set Location  |
  					|3            |6A Studio     |
  	Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
    Then user checks error not displayed for "Location" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error not displayed for "Set Location" required field in "<Section Name>" section on Animals on Premises Production request
    Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	And  user verifies the fields present in "<Section Name>" section of Animals on Premises Production form
    Examples:
    				|Form Name           |Section Name | Option1 | Option2 |
    				|Animals on Premises |SET LOCATION | Submit  | ok      |
    				
  @NcxUnifiedToolPhase2 @PSEQA @PSEQA_7920 @PSEQA_7912 @PSEQA_7913
  Scenario Outline: TC_012_StudioForm_NRT_11904_ To verify fields of Handlers information block. 
  	And  user clicks on forms link
  	And  user selects "<Form Name>" form
  	Then user verifies the fields present in "<Section Name>" section of Animals on Premises Production form
  	And  user verifies whether "<Section Name>" section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
    And  user checks error for "Name" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error for "Email Address" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error for "Phone" required field in "<Section Name>" section on Animals on Premises Production request
  	When user selects Name in "<Section Name>" section on Animals on Premises production request
  					|Position     |Name     |
  					|1            |Handler1 |
  	Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
    And  user checks error not displayed for "Name" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error for "Email Address" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error for "Phone" required field in "<Section Name>" section on Animals on Premises Production request
  	When user selects Email Address in "<Section Name>" section on Animals on Premises production request
  					|Position     |Email Address | 
  					|1            |a@b.com       |
  	Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
    And  user checks error not displayed for "Name" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error not displayed for "Email Address" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error for "Phone" required field in "<Section Name>" section on Animals on Premises Production request
  	When user selects Phone in "<Section Name>" section on Animals on Premises production request
  					|Position     |Phone          | 
  					|1            |000-000-0000 |
  	Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
    And  user checks error not displayed for "Name" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error not displayed for "Email Address" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error not displayed for "Phone" required field in "<Section Name>" section on Animals on Premises Production request
  	When user clicks on `+ Handler` button in "<Section Name>" section of Animals on Premises Production form
  	Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
    And  user checks error for "Name" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error for "Email Address" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error for "Phone" required field in "<Section Name>" section on Animals on Premises Production request
  	When user selects Name in "<Section Name>" section on Animals on Premises production request
  					|Position     |Name                 |
  					|2            |Handler1's handler2  |
  	Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
    And  user checks error not displayed for "Name" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error for "Email Address" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error for "Phone" required field in "<Section Name>" section on Animals on Premises Production request
  	When user selects Email Address in "<Section Name>" section on Animals on Premises production request
  					|Position     |Email Address | 
  					|2            |c@d.com       |
  	Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
    And  user checks error not displayed for "Name" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error not displayed for "Email Address" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error for "Phone" required field in "<Section Name>" section on Animals on Premises Production request
  	When user selects Phone in "<Section Name>" section on Animals on Premises production request
  					|Position     |Phone          | 
  					|2            |000-000-0000  |
  	Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
    And  user checks error not displayed for "Name" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error not displayed for "Email Address" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error not displayed for "Phone" required field in "<Section Name>" section on Animals on Premises Production request
  	When user clicks on `+ Handler` button in "<Section Name>" section of Animals on Premises Production form
  	Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
    And  user checks error for "Name" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error for "Email Address" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error for "Phone" required field in "<Section Name>" section on Animals on Premises Production request
  	When user selects Name in "<Section Name>" section on Animals on Premises production request
  					|Position     |Name                             |
  					|3            |Handler1's handler2's handler3   |
  	Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
    And  user checks error not displayed for "Name" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error for "Email Address" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error for "Phone" required field in "<Section Name>" section on Animals on Premises Production request
  	When user selects Email Address in "<Section Name>" section on Animals on Premises production request
  					|Position     |Email Address | 
  					|3            |e@f.com       |
  	Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
    And  user checks error not displayed for "Name" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error not displayed for "Email Address" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error for "Phone" required field in "<Section Name>" section on Animals on Premises Production request
  	When user selects Phone in "<Section Name>" section on Animals on Premises production request
  					|Position     |Phone         | 
  					|3            |000-000-0000  |
  	Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
    And  user checks error not displayed for "Name" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error not displayed for "Email Address" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error not displayed for "Phone" required field in "<Section Name>" section on Animals on Premises Production request
  	And  user verifies the fields present in "<Section Name>" section of Animals on Premises Production form
    Examples:
    				|Form Name                 | Section Name           | Option1  | Option2 |
    				|Animals on Premises       | HANDLER(S) INFORMATION | Submit   | ok      |
    				
  @NcxUnifiedToolPhase2 @PSEQA @PSEQA_7922 @PSEQA_7912 @PSEQA_7913
  Scenario Outline: TC_014_StudioForm_NRT_11904_Animals information block field verification. 
  	And  user clicks on forms link
  	And  user selects "<Form Name>" form
  	When user selects Name in "HANDLER(S) INFORMATION" section on Animals on Premises production request
  					|Position     |Name     |
  					|1            |Handler1 |
		When user selects Email Address in "HANDLER(S) INFORMATION" section on Animals on Premises production request
  					|Position     |Email Address | 
  					|1            |a@b.com       |
		When user selects Phone in "HANDLER(S) INFORMATION" section on Animals on Premises production request
  					|Position     |Phone          | 
  					|1            |(000)-000-0000 |
  	When user clicks on `+ Handler` button in "HANDLER(S) INFORMATION" section of Animals on Premises Production form
		When user selects Name in "HANDLER(S) INFORMATION" section on Animals on Premises production request
  					|Position     |Name                 |
  					|2            |Handler1's handler2  |
		When user selects Email Address in "HANDLER(S) INFORMATION" section on Animals on Premises production request
  					|Position     |Email Address | 
  					|2            |c@d.com       |
		When user selects Phone in "HANDLER(S) INFORMATION" section on Animals on Premises production request
  					|Position     |Phone          | 
  					|2            |(000)000-0000  |
  	Then user verifies the fields present in "<Section Name>" section of Animals on Premises Production form
  	And  user verifies whether "<Section Name>" section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
    And  user checks error for "Type of Animal(s)" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error for "How Many" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error for "Weight" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error for "Handler" required field in "<Section Name>" section on Animals on Premises Production request
  	When user selects Type of Animal(s) in "<Section Name>" section on Animals on Premises production request
  					|Position     |Type of Animal(s)   |
  					|1            |Very large elephants |
  	Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
    And  user checks error not displayed for "Type of Animal(s)" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error for "How Many" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error for "Weight" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error for "Handler" required field in "<Section Name>" section on Animals on Premises Production request
  	When user selects How Many in "<Section Name>" section on Animals on Premises production request
  					|Position     |How Many | 
  					|1            |12       |
  	Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
    And  user checks error not displayed for "Type of Animal(s)" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error not displayed for "How Many" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error for "Weight" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error for "Handler" required field in "<Section Name>" section on Animals on Premises Production request
  	When user selects Weight in "<Section Name>" section on Animals on Premises production request
  					|Position     |Weight       | 
  					|1            |200-300 lbs  |
  	When user selects Handler in "<Section Name>" section on Animals on Premises production request
  					|Position     |Handler              | 
  					|1            |Handler1's handler2  |
  	Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
    And  user checks error not displayed for "Type of Animal(s)" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error not displayed for "How Many" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error not displayed for "Weight" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error not displayed for "Handler" required field in "<Section Name>" section on Animals on Premises Production request
  	When user clicks on `+ Animal` button in "<Section Name>" section of Animals on Premises Production form
  	Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
    And  user checks error for "Type of Animal(s)" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error for "How Many" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error for "Weight" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error for "Handler" required field in "<Section Name>" section on Animals on Premises Production request
  	When user selects Type of Animal(s) in "<Section Name>" section on Animals on Premises production request
  					|Position     |Type of Animal(s)                    |
  					|2            |African Giraffes that have large necks|
  	Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
    And  user checks error not displayed for "Type of Animal(s)" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error for "How Many" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error for "Weight" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error for "Handler" required field in "<Section Name>" section on Animals on Premises Production request
  	When user selects How Many in "<Section Name>" section on Animals on Premises production request
  					|Position     |How Many | 
  					|2            |10       |
  	Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
    And  user checks error not displayed for "Type of Animal(s)" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error not displayed for "How Many" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error for "Weight" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error for "Handler" required field in "<Section Name>" section on Animals on Premises Production request
  	When user selects Weight in "<Section Name>" section on Animals on Premises production request
  					|Position     |Weight        | 
  					|2            |over 300 lbs  |
  	When user selects Handler in "<Section Name>" section on Animals on Premises production request
  					|Position     |Handler              | 
  					|2            |Handler1's handler2  |
  	Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
    And  user checks error not displayed for "Type of Animal(s)" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error not displayed for "How Many" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error not displayed for "Weight" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error not displayed for "Handler" required field in "<Section Name>" section on Animals on Premises Production request
  	When user clicks on `+ Animal` button in "<Section Name>" section of Animals on Premises Production form
  	Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
    And  user checks error for "Type of Animal(s)" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error for "How Many" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error for "Weight" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error for "Handler" required field in "<Section Name>" section on Animals on Premises Production request
  	When user selects Type of Animal(s) in "<Section Name>" section on Animals on Premises production request
  					|Position     |Type of Animal(s)                                     |
  					|3            |Chimpanzees that are assumed to be smarter than humans|
  	Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
    And  user checks error not displayed for "Type of Animal(s)" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error for "How Many" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error for "Weight" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error for "Handler" required field in "<Section Name>" section on Animals on Premises Production request
  	When user selects How Many in "<Section Name>" section on Animals on Premises production request
  					|Position     |How Many | 
  					|3            |5        |
  	Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
    And  user checks error not displayed for "Type of Animal(s)" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error not displayed for "How Many" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error for "Weight" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error for "Handler" required field in "<Section Name>" section on Animals on Premises Production request
  	When user selects Weight in "<Section Name>" section on Animals on Premises production request
  					|Position     |Weight    | 
  					|3            |1-10 lbs  |
  	When user selects Handler in "<Section Name>" section on Animals on Premises production request
  					|Position     |Handler   | 
  					|3            |Handler1  |
  	Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
  	When user clicks on "<Option1>" button
    And  user clicks on "<Option2>" button
    Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
    And  user checks error not displayed for "Type of Animal(s)" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error not displayed for "How Many" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error not displayed for "Weight" required field in "<Section Name>" section on Animals on Premises Production request
    And  user checks error not displayed for "Handler" required field in "<Section Name>" section on Animals on Premises Production request
  	And  user verifies the fields present in "<Section Name>" section of Animals on Premises Production form
    Examples:
    				|Form Name                 | Option1  | Option2 | Section Name          |
    				|Animals on Premises       | Submit   | ok      | ANIMAL(S) INFORMATION |
    				
   	@NcxUnifiedToolPhase2 @PSEQA @PSEQA_7923
  	Scenario Outline: TC_015_StudioForm_NRT_11904_To verify the request can be submitted successfuly.
  	And  user clicks on forms link
  	And  user selects "<Form Name>" form
  	When user selects Division in "GENERAL DETAILS" section on Animals on Premises production request
  					|Division    |
  					|CNBC       |
  	And  user selects Details and Notes in "DETAILS" section on Animals on Premises production request
  					|Details and Notes                                                           |
  					|This is a sample text filled by automation in Details and Notes field       |
  	And  user selects Air Platform in "SHOW INFO" section on Animals on Premises production request
  					|Air Platform|
  					|Internal    |
  	And  user selects Show Unit or Project Name in "SHOW INFO" section on Animals on Premises production request
  					|Show Unit or Project Name|
  					|OTHER                    |
  	And  user selects Arrival Date in "SHOW INFO" section on Animals on Premises production request
  					|Arrival Date  |
  					|currentDate+3 |
  	And  user selects Arrival Time in "SHOW INFO" section on Animals on Premises production request
  					|Arrival Time    |
  					|1:15 PM         |
  	And  user selects Departure Date in "SHOW INFO" section on Animals on Premises production request
  					|Departure Date    |
  					|currentDate+5     |
  	And  user selects Departure Time in "SHOW INFO" section on Animals on Premises production request
  					|Departure Time    |
  					|11:59 AM          |
  	And  user selects Work Order # in "SHOW INFO" section on Animals on Premises production request
  					|Work Order #                                                       |
  					|This is a text given via automation in Work Order # field          |
  	And  user selects Show Unit or Project Name in "SHOW INFO" section on Animals on Premises production request
  					|Show Unit or Project Name|
  					|Other                    |
  	And  user selects Other in "SHOW INFO" section on Animals on Premises production request
  					|Other                                              |
  					|This is value given via automation for Other field |
  	When user add specific user in Talent section
    				|Name        | 
    				|Memoli, Mike|
    When user add specific user in Talent section
    				|Name        | 
    				|Velshi, Ali |
  	And  user selects Location in "SET LOCATION" section on Animals on Premises production request
  					|Position     |Location         |
  					|1            |Rock Center      |
  	And  user selects Set Location in "SET LOCATION" section on Animals on Premises production request
  					|Position     |Set Location   |
  					|1            |3A Studio      |
		And  user clicks on `+ Location` button in "SET LOCATION" section of Animals on Premises Production form
  	And  user selects Location in "SET LOCATION" section on Animals on Premises production request
  					|Position     |Location         |
  					|2            |Rock Center      |
  	And  user selects Set Location in "SET LOCATION" section on Animals on Premises production request
  					|Position     |Set Location   |
  					|2            |3B Studio      |
		And  user clicks on `+ Location` button in "SET LOCATION" section of Animals on Premises Production form
  	And  user selects Location in "SET LOCATION" section on Animals on Premises production request
  					|Position     |Location         |
  					|3            |Rock Center      |
  	And  user selects Set Location in "SET LOCATION" section on Animals on Premises production request
  					|Position     |Set Location |
  					|3            |6A Studio    |
  	When user selects Name in "HANDLER(S) INFORMATION" section on Animals on Premises production request
  					|Position     |Name     |
  					|1            |Handler1 |
		When user selects Email Address in "HANDLER(S) INFORMATION" section on Animals on Premises production request
  					|Position     |Email Address | 
  					|1            |a@b.com       |
		When user selects Phone in "HANDLER(S) INFORMATION" section on Animals on Premises production request
  					|Position     |Phone          | 
  					|1            |(000)-000-0000 |
  	When user clicks on `+ Handler` button in "HANDLER(S) INFORMATION" section of Animals on Premises Production form
		When user selects Name in "HANDLER(S) INFORMATION" section on Animals on Premises production request
  					|Position     |Name                 |
  					|2            |Handler1's handler2  |
		When user selects Email Address in "HANDLER(S) INFORMATION" section on Animals on Premises production request
  					|Position     |Email Address | 
  					|2            |c@d.com       |
		When user selects Phone in "HANDLER(S) INFORMATION" section on Animals on Premises production request
  					|Position     |Phone          | 
  					|2            |(000)000-0000  |
  	When user selects Type of Animal(s) in "ANIMAL(S) INFORMATION" section on Animals on Premises production request
  					|Position     |Type of Animal(s)   |
  					|1            |Very large elephants |
		When user selects How Many in "ANIMAL(S) INFORMATION" section on Animals on Premises production request
  					|Position     |How Many | 
  					|1            |12       |
		When user selects Weight in "ANIMAL(S) INFORMATION" section on Animals on Premises production request
  					|Position     |Weight       | 
  					|1            |200-300 lbs  |
		When user selects Handler in "ANIMAL(S) INFORMATION" section on Animals on Premises production request
  					|Position     |Handler              | 
  					|1            |Handler1's handler2  |
		When user clicks on `+ Animal` button in "ANIMAL(S) INFORMATION" section of Animals on Premises Production form
		When user selects Type of Animal(s) in "ANIMAL(S) INFORMATION" section on Animals on Premises production request
  					|Position     |Type of Animal(s)                    |
  					|2            |African Giraffes that have large necks|
		When user selects How Many in "ANIMAL(S) INFORMATION" section on Animals on Premises production request
  					|Position     |How Many | 
  					|2            |10       |
		When user selects Weight in "ANIMAL(S) INFORMATION" section on Animals on Premises production request
  					|Position     |Weight        | 
  					|2            |over 300 lbs  |
		When user selects Handler in "ANIMAL(S) INFORMATION" section on Animals on Premises production request
  					|Position     |Handler              | 
  					|2            |Handler1's handler2  |
		When user clicks on `+ Animal` button in "ANIMAL(S) INFORMATION" section of Animals on Premises Production form
		When user selects Type of Animal(s) in "ANIMAL(S) INFORMATION" section on Animals on Premises production request
  					|Position     |Type of Animal(s)                                     |
  					|3            |Chimpanzees that are assumed to be smarter than humans|
		When user selects How Many in "ANIMAL(S) INFORMATION" section on Animals on Premises production request
  					|Position     |How Many | 
  					|3            |5        |
		When user selects Weight in "ANIMAL(S) INFORMATION" section on Animals on Premises production request
  					|Position     |Weight    | 
  					|3            |1-10 lbs  |
		When user selects Handler in "ANIMAL(S) INFORMATION" section on Animals on Premises production request
  					|Position     |Handler   | 
  					|3            |Handler1  |
  	And  user clicks on "Submit" button
  	Then user sees modal for successful "<Form Name>" request creation
    Examples:
    				|Form Name                 |
    				|Animals on Premises       |