@NcxUnifiedToolPhase2 @CNBCProductionRequest @ProducerDashboard @UserStoryWise @NRT_11903
Feature: NCX Unified Tool Phase 2: CNBC Production Request Reskin

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role
    And "producer" becomes default requester for every request created by it
    
    
  @NcxUnifiedToolPhase2 @PSEQA @PSEQA_6044
  Scenario Outline: TC002_StudioForm_NRT-11903_NRT-11903 Verify that the "CNBC Production" text is displayed above the form 
  	And  user clicks on forms link
  	And  user selects "<Form Name>" form
  	Then user verifies the form title "CNBC Production" on "<Form Name>" production form
    Examples:
    				|Form Name |
    				|CNBC      |
    
  @NcxUnifiedToolPhase2 @PSEQA @PSEQA_6063
  Scenario Outline: TC021_StudioForm_NRT-11903 Verify that Control room Crew section is not displayed 
  when `Is a control Room Needed ?` is selected as `No`
  	And user clicks on forms link
  	And user selects "<Form Name>" form
    When user selects `Is a Control Room Needed?` in CNBC production form
    				|Choice|
    				|No    |
    Then user verifies that Control Room Crew section and fields under the section are not displayed in CNBC production form
    Examples:
    				|Form Name |
    				|CNBC      |
    
  @NcxUnifiedToolPhase2 @PSEQA @PSEQA_6064
  Scenario Outline: TC021_StudioForm_NRT-11903 TC022_StudioForm_NRT-11903 Verify that Contol room Crew section 
  is displayed when ` Is a control Room Needed ? ` is selected as `Yes`
  	And user clicks on forms link
  	And user selects "<Form Name>" form
    When user selects `Is a Control Room Needed?` in CNBC production form
    				|Choice|
    				|Yes   |
    Then user verifies that Control Room Crew section and fields under the section are displayed in CNBC production form
    Examples:
    				|Form Name |
    				|CNBC      |
    				
  @NcxUnifiedToolPhase2 @PSEQA @PSEQA_6065
  Scenario Outline: TC023_StudioForm_NRT-11903 Verify that the user name and Job title is autofilled 
  	And user clicks on forms link
  	And user selects "<Form Name>" form
    Then user verifies that it is added as requester in Requesters section of "<Form Name>" production form
    Examples:
    				|Form Name |
    				|CNBC      |
  @NcxUnifiedToolPhase2 @PSEQA @PSEQA_6066
  Scenario Outline: TC024_StudioForm_NRT-11903 Verify that the Budget code field is disabled until 
  Budget code is indicated as available 
  	And user clicks on forms link
  	And user selects "<Form Name>" form
  	When user selects Air Platform in SHOW INFO section on CNBC Production request
  	| Air Platform |
    | OTT          |
    And user selects "Tech Check" as Show Unit or Project Name on CNBC Production
    And user selects `Is Budget Code Available?` on CNBC Production
            |Is Budget Code Available? |
            |Will Provide              |
    Then user verifies `Budget Code` input is disabled
    When user selects `Is Budget Code Available?` on CNBC Production
    				|Is Budget Code Available? |
            |Available                 |
    Then user verifies `Budget Code` input is enabled
    Examples:
    				|Form Name |
    				|CNBC      |
    
  @NcxUnifiedToolPhase2 @PSEQA @PSEQA_6045
  Scenario Outline: TC003_StudioForm_NRT-11903 verify the total number of sub sections in the CNBC Production request form 
  	And user clicks on forms link
  	And user selects "<Form Name>" form
    Then user verifies the form sections on CNBC production form
    When user selects `Is a Control Room Needed?` in CNBC production form
            | Is a Control Room Needed? |
            | Yes                       |
    Then user verifies the form sections on CNBC production form
    When user selects `Is a Control Room Needed?` in CNBC production form
    				| Is a Control Room Needed? |
            | No                        |
    Then user verifies the form sections on CNBC production form
    Examples:
    				|Form Name |
    				|CNBC      |
    
  @NcxUnifiedToolPhase2 @PSEQA @PSEQA_6049
  Scenario Outline: TC007_StudioForm_NRT-11903 Verify that the default status for a new request under the Status section 
  	And user clicks on forms link
  	And user selects "<Form Name>" form
    Then user verifies that the status is '<Status>' for "<Form Name>" Production form
    Examples:
    				|Form Name |  Status          |
    				|CNBC      |  NEW             |
  
  @NcxUnifiedToolPhase2 @PSEQA @PSEQA_6050 @PSEQA_6047 @PSEQA_6048
  Scenario Outline: TC008_StudioForm_NRT-11903 Verify the fields in General Details Section 
  	And  user clicks on forms link
  	And  user selects "<Form Name>" form
    Then user verifies the fields present in '<Section Name>' section of CNBC Production form
    And  user verifies whether '<Section Name>' section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
    And  user checks placeholder of `Division` field on CNBC Production request
    When user clicks on Submit button
    And  user clicks on "<Option2>" button
    Then user checks mandatory field error below `Division` on CNBC Production request
    And  user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button already clicked once on "<Form Name>" Production request
    When user populates GENERAL DETAILS section on CNBC Production request
            |   Division   |
            |   MSNBC      |
    Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
    When user clicks Submit button on request
    And  user clicks on "<Option2>" button
    Then user checks mandatory field error below `Division` on CNBC Production request
    And user checks placeholder of `Division` field on CNBC Production request
    And  user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
    Examples:
    				|Form Name |  Section Name          | Option2   |
    				|CNBC      |  GENERAL DETAILS       | ok        |
    
  @NcxUnifiedToolPhase2 @PSEQA @PSEQA_6052 @PSEQA_6047 @PSEQA_6048
  Scenario Outline: TC010_StudioForm_NRT-11903 Verify the fields in the Requesters section 
  	And user clicks on forms link
  	And user selects "<Form Name>" form
    Then user verifies the fields present in '<Section Name>' section of CNBC Production form
    And  user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
    When user clicks Submit button on request
    And  user clicks on "<Option2>" button
    Then  user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
    Examples:
    				|Form Name |  Section Name          |  Option1  | Option2  |
    				|CNBC      |  REQUESTER(S)          |  Submit   | ok       |
    
    
  @NcxUnifiedToolPhase2 @PSEQA @PSEQA_6053 @PSEQA_6047 @PSEQA_6048
  Scenario Outline: TC011_StudioForm_NRT-11903 Verify the fields in the Talent section 
  	And user clicks on forms link
  	And user selects "<Form Name>" form
    Then user verifies the fields present in '<Section Name>' section of CNBC Production form
    And  user verifies whether '<Section Name>' section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
    When user clicks Submit button on request
    And  user clicks on "<Option2>" button
    Then user verifies whether '<Section Name>' section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
    When user add specific user in Talent section
    				|Name        | 
    				|Memoli, Mike & Velshi, Ali|
    Then  user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
    When user clicks Submit button on request
    And  user clicks on "<Option2>" button
    Then  user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
    Examples:
    				|Form Name |  Section Name          | Option1  | Option2  |
    				|CNBC      |  TALENT                | Submit   | ok       |
    
  @NcxUnifiedToolPhase2 @PSEQA @PSEQA_6054 @PSEQA_6047 @PSEQA_6048
  Scenario Outline: TC012_StudioForm_NRT-11903 Verify the fields in the Production Purpose section 
  	And  user clicks on forms link
  	And  user selects "<Form Name>" form
    Then user verifies the fields present in '<Section Name>' section of CNBC Production form
    And  user verifies whether '<Section Name>' section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
    And  user checks placeholder of `Request For` field on CNBC Production request
    When user clicks Submit button on request
    And  user clicks on "<Option2>" button
    Then user checks mandatory field error below `Request For` on CNBC Production request
    And  user verifies whether "<Section Name>" section is marked crossed when all required fields are not filled and submit button already clicked once on "<Form Name>" Production request
    When user populates PRODUCTION PURPOSE section on CNBC Production request
            |   Request For   |  Details & Notes                                          |
            |   Live Stream   |  This is a test automation note in Details & Notes field  |
    Then user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
    When user clicks Submit button on request
    And  user clicks on "<Option2>" button
    Then user checks mandatory field error below `Request For` on CNBC Production request
    And  user verifies whether "<Section Name>" section is marked checked when all required fields are filled on "<Form Name>" Production request
    Examples:
    				|Form Name |  Section Name          |  Option1   | Option2  |
    				|CNBC      |  PRODUCTION PURPOSE    |  Submit    | ok       |
    
  @NcxUnifiedToolPhase2 @PSEQA @PSEQA_6055
  Scenario Outline: TC013_StudioForm_NRT-11903 Verify the fields in the Show info  section 
  	And user clicks on forms link
  	And user selects "<Form Name>" form
    Then user verifies the fields present in '<Section Name>' section of CNBC Production form
    When user selects 'CNBC' as Division on CNBC Production
    Then user verifies the fields present in '<Section Name>' section of CNBC Production form
    When user selects Show Unit or Project Name in SHOW INFO section on CNBC Production request
    	|Show Unit or Project Name|
    	|OTHER                    |
    Then user verifies the fields present in '<Section Name>' section of CNBC Production form
    When user selects 'MSNBC' as Division on CNBC Production
    Then user verifies the fields present in '<Section Name>' section of CNBC Production form
    When user selects Show Unit or Project Name in SHOW INFO section on CNBC Production request
    	|Show Unit or Project Name|
    	|Power Lunch              |
    Then user verifies the fields present in '<Section Name>' section of CNBC Production form
    Examples:
    				|Form Name |  Section Name    |
    				|CNBC      |  SHOW INFO       |
    
  @NcxUnifiedToolPhase2 @PSEQA @PSEQA_6056 @PSEQA_6047 @PSEQA_6048
  Scenario Outline: TC014_StudioForm_NRT-11903 Verify the fields in the Set Location section 
  	And  user clicks on forms link
  	And  user selects "<Form Name>" form
    Then user verifies the fields present in '<Section Name>' section of CNBC Production form
    And  user verifies whether '<Section Name>' section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
    And  user checks placeholder of `Location` field on CNBC Production request
    When user clicks Submit button on request
    And  user clicks on "<Option2>" button
    Then user verifies whether '<Section Name>' section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
    And  user checks mandatory field error for `Location` on CNBC Production request
    When user selects Location on CNBC Production request
            |Location  | Location Number |
            |SF        | 0               |
    And  user verifies whether '<Section Name>' section is marked checked when all required fields are filled on "<Form Name>" Production request
    When user clicks Submit button on request
    And  user clicks on "<Option2>" button
    Then  user checks placeholder of `Location` field on CNBC Production request
    And  user verifies whether '<Section Name>' section is marked checked when all required fields are filled on "<Form Name>" Production request
    Examples:
    				|Form Name |  Section Name    | Option1  | Option2 |
    				|CNBC      |  SET LOCATION    | Submit   | ok      |
    
  @NcxUnifiedToolPhase2 @PSEQA @PSEQA_6057 @PSEQA_6047 @PSEQA_6048
  Scenario Outline: TC015_StudioForm_NRT-11903 Verify the fields in the Set crew section 
  	And  user clicks on forms link
  	And  user selects "<Form Name>" form
    Then user verifies the fields present in '<Section Name>' section of CNBC Production form
    And  user verifies whether '<Section Name>' section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
    And  user checks placeholder of "Set Crew" field in '<Section Name>' section on CNBC Production request
    When user clicks Submit button on request
    And  user clicks on "<Option2>" button
    Then user verifies whether '<Section Name>' section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
    When user selects Set Crew on CNBC Production request
    				|Set Crew  |
    				|Flashcam  |
    Then user verifies whether '<Section Name>' section is marked checked when all required fields are filled on "<Form Name>" Production request
    When user selects Set Crew on CNBC Production request
    				|Set Crew      |
    				|Hair Stylist  |
    When user clicks Submit button on request
    And  user clicks on "<Option2>" button
    Then user verifies whether '<Section Name>' section is marked checked when all required fields are filled on "<Form Name>" Production request
    Examples:
    				|Form Name |  Section Name    | Option1 | Option2 |
    				|CNBC      |  SET CREW        | Submit  | ok      |
    
  @NcxUnifiedToolPhase2 @PSEQA @PSEQA_6058 @PSEQA_6047 @PSEQA_6048
  Scenario Outline: TC016_StudioForm_NRT-11903 Verify the fields in the Staging section 
  	And  user clicks on forms link
  	And  user selects "<Form Name>" form
    Then user verifies the fields present in "<Section Name>" section of CNBC Production form
    And  user verifies whether '<Section Name>' section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
    When user clicks Submit button on request
    And  user clicks on "<Option2>" button
    Then user verifies whether '<Section Name>' section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
    When user selects Staging Needs on CNBC Production request
            |Staging Needs																																							|
            |This is a sample text added by the producerdashboard automation for the Staging Needs field|
    Then user verifies whether '<Section Name>' section is marked checked when all required fields are filled on "<Form Name>" Production request
    When user clicks Submit button on request
    And  user clicks on "<Option2>" button
    Then user verifies whether '<Section Name>' section is marked checked when all required fields are filled on "<Form Name>" Production request
    Examples:
    				|Form Name |  Section Name    |Option1  | Option2|
    				|CNBC      |  STAGING         |Submit   | ok     |
    
  @NcxUnifiedToolPhase2 @PSEQA @PSEQA_6059 @PSEQA_6047 @PSEQA_6048
  Scenario Outline: TC017_StudioForm_NRT-11903 Verify the fields in the Control Room section 
  	And  user clicks on forms link
  	And  user selects "<Form Name>" form
    Then user verifies the fields present in "<Section Name>" section of CNBC Production form
    And  user verifies whether '<Section Name>' section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
    When user clicks Submit button on request
    And  user clicks on "<Option2>" button
    Then user verifies whether '<Section Name>' section is marked crossed when all required fields are not filled and submit button clicked on "<Form Name>" Production request
    When user selects `Is a Control Room Needed?` in CNBC production form
            |Choice|
            |Yes                      |
    Then user verifies the fields present in "<Section Name>" section of CNBC Production form
    And user verifies whether '<Section/ Name>' section is marked checked when all required fields are filled on "<Form Name>" Production request
    When user clicks Submit button on request
    And  user clicks on "<Option2>" button
    Then user verifies whether '<Section Name>' section is marked checked when all required fields are filled on "<Form Name>" Production request
    When user selects `Is a Control Room Needed?` in CNBC production form
            |Choice|
            |No                       |
    Then user verifies the fields present in "<Section Name>" section of CNBC Production form
    And user verifies whether '<Section Name>' section is marked checked when all required fields are filled on "<Form Name>" Production request
    When user clicks Submit button on request
    And  user clicks on "<Option2>" button
    Then user verifies whether '<Section Name>' section is marked checked when all required fields are filled on "<Form Name>" Production request
    Examples:
    				|Form Name |  Section Name    | Option1   | Option2  | 
     				|CNBC      |  CONTROL ROOM    | Submit    | ok       |
    
  @NcxUnifiedToolPhase2 @PSEQA @PSEQA_6060 @PSEQA_6047 @PSEQA_6048
  Scenario Outline: TC018_StudioForm_NRT-11903 Verify the fields in the Control Room Crew section 
  	And  user clicks on forms link
  	And  user selects "<Form Name>" form
  	When user selects `Is a Control Room Needed?` in CNBC production form
            |Choice|
            |Yes   |
    Then user verifies whether '<Section Name>' section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
    And  user verifies the fields present in "<Section Name>" section of CNBC Production form
    When user clicks Submit button on request
    And  user clicks on "<Option2>" button
    Then user verifies whether '<Section Name>' section is marked neither checked nor crossed when required fields not filled and submit button not clicked on "<Form Name>" Production request
    When user selects `Ingest: Do you need content to be recorded?` on CNBC Production request
            |Choice |
            |Yes    |
    Then user verifies whether '<Section Name>' section is marked checked when all required fields are filled on "<Form Name>" Production request
    When user clicks Submit button on request
    And  user clicks on "<Option2>" button
    Then user verifies whether '<Section Name>' section is marked checked when all required fields are filled on "<Form Name>" Production request
    When user selects `Ingest: Do you need content to be recorded?` on CNBC Production request
            |Choice |
            |No     |
    Then user verifies whether '<Section Name>' section is marked checked when all required fields are filled on "<Form Name>" Production request
    When user clicks Submit button on request
    And  user clicks on "<Option2>" button
    Then user verifies whether '<Section Name>' section is marked checked when all required fields are filled on "<Form Name>" Production request
    When user selects `ISO: Do you need ISO recordings?` on CNBC Production request
            |Choice            |
            |Yes               |
    Then user verifies whether '<Section Name>' section is marked checked when all required fields are filled on "<Form Name>" Production request
    When user clicks Submit button on request
    And  user clicks on "<Option2>" button
    Then user verifies whether '<Section Name>' section is marked checked when all required fields are filled on "<Form Name>" Production request
    When user selects `ISO: Do you need ISO recordings?` on CNBC Production request
            |Choice     |
            |No         |
    Then user verifies whether '<Section Name>' section is marked checked when all required fields are filled on "<Form Name>" Production request
    When user clicks Submit button on request
    And  user clicks on "<Option2>" button
    Then user verifies whether '<Section Name>' section is marked checked when all required fields are filled on "<Form Name>" Production request
    When user selects Control Room Crew in '<Section Name>' section on CNBC Production request
            |Control Room Crew  |
            |Director           |
    Then user verifies whether '<Section Name>' section is marked checked when all required fields are filled on "<Form Name>" Production request
    When user clicks Submit button on request
    And  user clicks on "<Option2>" button
    Then user verifies whether '<Section Name>' section is marked checked when all required fields are filled on "<Form Name>" Production request
    When user selects Control Room Crew in '<Section Name>' section on CNBC Production request
            |Control Room Crew  |
            |Viz Graphics       |
    Then user verifies whether '<Section Name>' section is marked checked when all required fields are filled on "<Form Name>" Production request
    When user clicks Submit button on request
    And  user clicks on "<Option2>" button
    Then user verifies whether '<Section Name>' section is marked checked when all required fields are filled on "<Form Name>" Production request
    Examples:
    				|Form Name |  Section Name         | Option1 |Option2 |
    				|CNBC      |  CONTROL ROOM CREW    | Submit  |ok      | 
    
  @NcxUnifiedToolPhase2 @PSEQA @PSEQA_6068
  Scenario Outline: TC026_StudioForm_NRT-11903 Verify that the Set crew section is Displayed if set location is selected
  	And user clicks on forms link
  	And user selects "<Form Name>" form
  	And user selects "CNBC" as Division on CNBC Production
  	And user adds requester to the form
  					|Requester             |
  					|Sawant, Swati Shivram |
  	And user add specific user in Talent section
    				|Name                        | 
    				|Memoli, Mike & Velshi, Ali  |
    And user selects Request For in PRODUCTION PURPOSE section on CNBC Production request
    	| Request For   |
      | Internal Event|
    And user gives Details & Notes in Production Purpose section on CNBC Production request
      | Details & Notes  |
      | Details and notes given by automation\nDetails and notes given by automation\nDetails and notes given by automation |
    And user selects Air Platform in SHOW INFO section on CNBC Production request
     	| Air Platform |
     	| OTT          |
    And user selects Sub Division in SHOW INFO section on CNBC Production request
     	| Sub Division |
     	| CNBC Events  |
    And user selects Show Unit or Project Name in SHOW INFO section on CNBC Production request
     	| Show Unit or Project Name |
     	| Tech Check  |
    And user selects Start Date in SHOW INFO section on CNBC Production request
     	| Days from today |
     	| 2  |
    And user selects Start Time in SHOW INFO section on CNBC Production request
     	| Time       |
     	| 12:00 PM   |
    And user selects End Time in SHOW INFO section on CNBC Production request
     	| Time       |
     	| 3:00 PM    |
    And user selects Location on CNBC Production request
  		| Location Number  | Location  |
  		| 0                | NYSE      |
  	And user clicks `+ Location` on CNBC Production request
  	And user selects Location on CNBC Production request
  		| Location Number  | Location  |
  		| 1                | DC      |
    And user selects Set Crew on CNBC Production request
  		| Set Crew |
  		| Flashcam, Hair Stylist, Lighting Director |
    Examples:
    				|Form Name |
    				|CNBC      |
    
    @NcxUnifiedToolPhase2 @PSEQA @PSEQA_6210
  Scenario Outline: TC020_StudioForm_NRT-11903 Verify that CNBC produciton request can be submitted successfully
  	And user clicks on forms link
  	And user selects "<Form Name>" form
  	And user selects "MSNBC" as Division on CNBC Production
  	And user adds requester to the form
  					|Requester             |
  					|Sawant, Swati Shivram |
  	And user add specific user in Talent section
    				|Name                        | 
    				|Memoli, Mike & Velshi, Ali  |
    And user selects Request For in PRODUCTION PURPOSE section on CNBC Production request
    	| Request For |
      | Live Show |
    And user gives Details & Notes in Production Purpose section on CNBC Production request
    	| Details & Notes                                       |
    	| this is comments\nthis is comments\nthis is comments  |
    And user selects Air Platform in SHOW INFO section on CNBC Production request
     	| Air Platform |
     	| OTT          |
    And user selects Show Unit or Project Name in SHOW INFO section on CNBC Production request
     	| Show Unit or Project Name |
     	| Tech Check  |
    And user selects Start Date in SHOW INFO section on CNBC Production request
     	| Days from today |
     	| 2  |
    And user selects Start Time in SHOW INFO section on CNBC Production request
     	| Time       |
     	| 12:00 PM   |
    And user selects End Time in SHOW INFO section on CNBC Production request
     	| Time       |
     	| 3:00 PM    |
    And user selects Location on CNBC Production request
  		| Location Number  | Location  |
  		| 0                | EC      |
    And user selects Set Crew on CNBC Production request
  		| Set Crew |
  		| Flashcam, Hair Stylist, Lighting Director |
    And user selects Staging Needs on CNBC Production request
      | Staging Needs       |
      | Test-test-test-test |
    And user selects `Is a Control Room Needed?` in CNBC production form
  		| Choice |
  		| Yes    |
  	And user selects Control Room Crew in "CONTROL ROOM CREW" section on CNBC Production request
  		| Control Room Crew  |
  		| Associate Director, Director, Viz Graphics |
    And user selects `ISO: Do you need ISO recordings?` on CNBC Production request
    	| Choice |
    	| No     |
    And user selects `Ingest: Do you need content to be recorded?` on CNBC Production request
    	| Choice |
    	| Yes    |
    And  user clicks Submit button on request
  	Then user sees modal for successful "CNBC Production" request creation
  	And  user clicks on "ok" button
  	When user opens the created request
    Examples:
    				|Form Name |
    				|CNBC      |
    				
  @NcxUnifiedToolPhase2 @PSEQA @PSEQA_62100
  Scenario Outline: TC020_StudioForm_NRT-11903 Verify that CNBC produciton request can be submitted successfully
  	And user clicks on forms link
  	And user selects "<Form Name>" form
  	And user selects "MSNBC" as Division on CNBC Production
  #	And user adds requester to the form
  #					|Requester             |
  #					|Sawant, Swati Shivram |
  #	And user add specific user in Talent section
    #				|Name                        | 
    #				|Memoli, Mike & Velshi, Ali  |
    And user selects Request For in PRODUCTION PURPOSE section on CNBC Production request
    	| Request For |
      | Live Show |
    And user gives Details & Notes in Production Purpose section on CNBC Production request
    	| Details & Notes                                       |
    	| this is comments\nthis is comments\nthis is comments  |
    And user selects Air Platform in SHOW INFO section on CNBC Production request
     	| Air Platform |
     	| OTT          |
    And user selects Show Unit or Project Name in SHOW INFO section on CNBC Production request
     	| Show Unit or Project Name |
     	| Tech Check  |
    And user selects Start Date in SHOW INFO section on CNBC Production request
     	| Days from today |
     	| 2  |
    And user selects Start Time in SHOW INFO section on CNBC Production request
     	| Time       |
     	| 12:00 PM   |
    And user selects End Time in SHOW INFO section on CNBC Production request
     	| Time       |
     	| 3:00 PM    |
    And user selects Call Time in SHOW INFO section on CNBC Production request
    | Time       |
     	| 11:00 AM    |
    And user selects Location on CNBC Production request
  		| Location Number  | Location  |
  		| 0                | EC      	|
    And user selects Set Crew on CNBC Production request
  		| Set Crew |
  		| Flashcam, Lighting Director |
    And user selects Staging Needs on CNBC Production request
      | Staging Needs       |
      | Test-test-test-test |
    And user selects `Is a Control Room Needed?` in CNBC production form
  		| Choice |
  		| Yes    |
  	And user selects Control Room Crew in "CONTROL ROOM CREW" section on CNBC Production request
  		| Control Room Crew  |
  		| Technical Director, TPS, SSG Graphics |
    And user selects `ISO: Do you need ISO recordings?` on CNBC Production request
    	| Choice |
    	| No     |
    And user selects `Ingest: Do you need content to be recorded?` on CNBC Production request
    	| Choice |
    	| Yes    |
    And  user clicks Submit button on request
  	Then user sees modal for successful "CNBC Production" request creation
  	And  user clicks on "ok" button
  	When user opens the created request
  	Then user checks correct Ingest option is selected on CNBC Production readonly request
  	And user checks correct ISO option is selected on CNBC Production readonly request
  	And user checks correct Set Crew selections are displayed on CNBC Production readonly request
  	And user checks correct Set Crew selections are not expandable before fulfilment on CNBC Production readonly request
  	And user checks correct Control Room Crew selections are not expandable before fulfilment on CNBC Production readonly request
  	And user checks correct Control Room Crew selections are displayed on CNBC Production readonly request
  	Then user checks correct Location selections are displayed on CNBC Production readonly request
  	Then user checks correct Control Room Needed option is selected on CNBC Production readonly request
  	Then user clicks Log button on request
  	Then user verifies all Logs on request
  	Then user closes Log Drawer on request
  	When user clicks Edit button on request
  	When user removes "Lighting Director" from Set Crew on CNBC Production request
    When user removes "TPS" from Control Room Crew on CNBC Production request
  	And user edits Location on CNBC Production request
  		| Location Number  | Location  |
  		| 0                | DC      	 |
  	And user clicks `+ Location` on CNBC Production request
  	And user edits Location on CNBC Production request
  		| Location Number  | Location  |
  		| 1                | NAS       |
  	And user edits `ISO: Do you need ISO recordings?` on CNBC Production request
    	| Choice |
    	| Yes    |
    And user edits `Ingest: Do you need content to be recorded?` on CNBC Production request
    	| Choice |
    	| No     |
    When user edits Staging Needs on CNBC Production request
    	|Staging Needs|
    	|Editing staging needs|
    When user edits Request For on CNBC Production request
		| Request For |
		| Live Stream |
		When user edits Details & Notes on CNBC Production request
		|Details & Notes|
		|created by automation|
		When user edits Air Platform on CNBC Production request
		|Air Platform|
		|Multiple|
		When user edits Show Unit or Project Name on CNBC Production request
		|Show Unit or Project Name|
		|The Exchange|
		When user clears `Start Date` on CNBC Production request
		When user clears `End Time` on CNBC Production request
		When user clears `Start Time` on CNBC Production request
#		When user clears `Call Time` on CNBC Production request
		When user edits End Time on CNBC Production request
		|Time|
		|7:00 PM|
		When user edits Start Time on CNBC Production request
		|Time|
		|6:00 PM|
		When user edits Division and selects "CNBC" on CNBC Production
		When user edits Sub Division on CNBC Production request
		|Sub Division|
		|CNBC Events|
#		When user edits Call Time on CNBC Production request
#		|Time|
#		|5:00 PM|
		When user edits Start Date on CNBC Production request
		|Days from today|
		|1|
    #And user clears `Set Crew` on CNBC Production request
    #And user clears `Control Room Crew` on CNBC Production request
    #And user edits Control Room Crew section on CNBC Production request
  #		| Control Room Crew  |
  #		| Associate Director, Viz Graphics |
  	When user clicks Save button on request
  	Then  user clicks on "ok" button
  	When user opens the created request
  #	Then user checks correct Location selections are displayed on CNBC Production readonly request
  #	And user checks correct Control Room Crew selections are displayed on CNBC Production readonly request
  #	And user checks correct Set Crew selections are displayed on CNBC Production readonly request
  #	Then user checks correct Ingest option is selected on CNBC Production readonly request
  #	And user checks correct ISO option is selected on CNBC Production readonly request.
  	Then user clicks Log button on request
  	Then user verifies all Logs on request
  	Then user closes Log Drawer on request
    Examples:
    				|Form Name |
    				|CNBC      |
    				
    @NcxUnifiedToolPhase2 @PSEQA @PSEQA_62101
  Scenario Outline: TC020_StudioForm_NRT-11903 Verify that CNBC produciton request can be submitted successfully
  	And user clicks on forms link
  	And user selects "<Form Name>" form
  	Then user checks whether the sections are marked either checked or crossed or neither
  	And user selects "MSNBC" as Division on CNBC Production
  	Then user checks whether the sections are marked either checked or crossed or neither
  #	And user adds requester to the form
  #					|Requester             |
  #					|Sawant, Swati Shivram |
  #	And user add specific user in Talent section
    #				|Name                        | 
    #				|Memoli, Mike & Velshi, Ali  |
    And user gives Details & Notes in Production Purpose section on CNBC Production request
    	| Details & Notes                                       |
    	| this is comments\nthis is comments\nthis is comments  |
    And user selects Request For in PRODUCTION PURPOSE section on CNBC Production request
    	| Request For |
      | Live Show  |
    Then user checks whether the sections are marked either checked or crossed or neither
    And user selects Air Platform in SHOW INFO section on CNBC Production request
     	| Air Platform |
     	| OTT          |
    Then user checks whether the sections are marked either checked or crossed or neither
    And user selects Show Unit or Project Name in SHOW INFO section on CNBC Production request
     	| Show Unit or Project Name |
     	| Tech Check  |
    Then user checks whether the sections are marked either checked or crossed or neither
    And user selects Start Date in SHOW INFO section on CNBC Production request
     	| Days from today |
     	| 2  |
    Then user checks whether the sections are marked either checked or crossed or neither
    And user selects Start Time in SHOW INFO section on CNBC Production request
     	| Time       |
     	| 12:00 PM   |
    Then user checks whether the sections are marked either checked or crossed or neither
    And user selects End Time in SHOW INFO section on CNBC Production request
     	| Time       |
     	| 3:00 PM    |
    And user selects Call Time in SHOW INFO section on CNBC Production request
    | Time       |
     	| 11:00 AM    |
    Then user checks whether the sections are marked either checked or crossed or neither
    And user selects Location on CNBC Production request
  		| Location Number  | Location  |
  		| 0                | EC      	|
  	Then user checks whether the sections are marked either checked or crossed or neither
    And user selects Set Crew on CNBC Production request
  		| Set Crew |
  		| Flashcam, Lighting Director |
  	Then user checks whether the sections are marked either checked or crossed or neither
    And user selects Staging Needs on CNBC Production request
      | Staging Needs       |
      | Test-test-test-test |
    Then user checks whether the sections are marked either checked or crossed or neither
    And user selects `Is a Control Room Needed?` in CNBC production form
  		| Choice |
  		| Yes    |
  	Then user checks whether the sections are marked either checked or crossed or neither
  	And user selects Control Room Crew in "CONTROL ROOM CREW" section on CNBC Production request
  		| Control Room Crew  |
  		| Technical Director, TPS, SSG Graphics |
  	Then user checks whether the sections are marked either checked or crossed or neither
    And user selects `ISO: Do you need ISO recordings?` on CNBC Production request
    	| Choice |
    	| No     |
    And user selects `Ingest: Do you need content to be recorded?` on CNBC Production request
    	| Choice |
    	| Yes    |
    And  user clicks Submit button on CNBC Production request
  	Then user sees modal for successful "CNBC Production" request creation
  	And  user clicks on "ok" button
  	When user opens the created request
  	Then user checks correct Ingest option is selected on CNBC Production readonly request
  	And user checks correct ISO option is selected on CNBC Production readonly request
  	And user checks correct Set Crew selections are displayed on CNBC Production readonly request
  	And user checks correct Set Crew selections are not expandable before fulfilment on CNBC Production readonly request
  	And user checks correct Control Room Crew selections are not expandable before fulfilment on CNBC Production readonly request
  	And user checks correct Control Room Crew selections are displayed on CNBC Production readonly request
  	Then user checks correct Location selections are displayed on CNBC Production readonly request
  	Then user checks correct Control Room Needed option is selected on CNBC Production readonly request
  	Then user clicks Log button on request
  	Then user verifies all Logs on request
  	Then user closes Log Drawer on request
  	When user clicks Edit button on request
  	When user removes "Lighting Director" from Set Crew on CNBC Production request
    When user removes "TPS" from Control Room Crew on CNBC Production request
  	And user edits Location on CNBC Production request
  		| Location Number  | Location  |
  		| 0                | DC      	 |
  	And user clicks `+ Location` on CNBC Production request
  	And user edits Location on CNBC Production request
  		| Location Number  | Location  |
  		| 1                | NAS       |
  	And user edits `ISO: Do you need ISO recordings?` on CNBC Production request
    	| Choice |
    	| Yes    |
    And user edits `Ingest: Do you need content to be recorded?` on CNBC Production request
    	| Choice |
    	| No     |
    When user edits Staging Needs on CNBC Production request
    	|Staging Needs|
    	|Editing staging needs|
    When user edits Request For on CNBC Production request
		| Request For |
		| Live Stream |
		When user edits Details & Notes on CNBC Production request
		|Details & Notes|
		|created by automation|
		When user edits Air Platform on CNBC Production request
		|Air Platform|
		|Multiple|
		When user edits Show Unit or Project Name on CNBC Production request
		|Show Unit or Project Name|
		|The Exchange|
		When user clears `Start Date` on CNBC Production request
		When user clears `End Time` on CNBC Production request
		When user clears `Start Time` on CNBC Production request
#		When user clears `Call Time` on CNBC Production request
		When user edits End Time on CNBC Production request
		|Time|
		|7:00 PM|
		When user edits Start Time on CNBC Production request
		|Time|
		|6:00 PM|
		When user edits Division and selects "CNBC" on CNBC Production
		When user edits Sub Division on CNBC Production request
		|Sub Division|
		|CNBC Events|
#		When user edits Call Time on CNBC Production request
#		|Time|
#		|5:00 PM|
		When user edits Start Date on CNBC Production request
		|Days from today|
		|1|
    #And user clears `Set Crew` on CNBC Production request
    #And user clears `Control Room Crew` on CNBC Production request
    #And user edits Control Room Crew section on CNBC Production request
  #		| Control Room Crew  |
  #		| Associate Director, Viz Graphics |
  	When user clicks Save button on request
  	Then  user clicks on "ok" button
  	When user opens the created request
  #	Then user checks correct Location selections are displayed on CNBC Production readonly request
  #	And user checks correct Control Room Crew selections are displayed on CNBC Production readonly request
  #	And user checks correct Set Crew selections are displayed on CNBC Production readonly request
  #	Then user checks correct Ingest option is selected on CNBC Production readonly request
  #	And user checks correct ISO option is selected on CNBC Production readonly request.
  	Then user clicks Log button on request
  	Then user verifies all Logs on request
  	Then user closes Log Drawer on request
    Examples:
    				|Form Name |
    				|CNBC      |