@NcxUnifiedToolPhase2 @ProducerDashboard @Logs
Feature: Log validation scenarios for Production requests

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role
    And "producer" becomes default requester for every request created by it
    
    
    				
  @NcxUnifiedToolPhase2 @PSEQA @Logs_001 @Logs_CNBCProduction
  Scenario: Verify that log is generated in CNBC Production for individual field changes
  	And user clicks on forms link
  	And user selects "CNBC" form
  	And user selects "MSNBC" as Division on CNBC Production
  	When user populates PRODUCTION PURPOSE section on CNBC Production request
    	| Details & Notes |Request For|
    	| this is comments|Live Show  |
    When user selects fields in SHOW INFO section on CNBC Production request
     	|Air Platform|Show Unit or Project Name|Days from today|Start Time|End Time|Call Time|
     	|OTT         |Tech Check               |2              |12:00 PM  |3:00 PM |11:00 AM |
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
  	When user selects fields in Control Room Crew section on CNBC Production request
  		|Control Room Crew                    |ISO|Ingest|
  		|Technical Director, TPS, SSG Graphics|No |Yes   |
    And  user clicks Submit button on request
  	Then user sees modal for successful "CNBC Production" request creation
  	And  user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
  	When user removes Set Crew from Set Crew on CNBC Production request in edit mode
  		| Set Crew |
  		| Lighting Director |
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	# Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user removes Control Room Crew from Control Room Crew on CNBC Production request in edit mode
  		|Control Room Crew  |
  		|TPS                |
    When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	# Then user verifies all Logs on request
  	When user clicks Edit button on request
  	And user edits Location on CNBC Production request
  		| Location Number  | Location  |
  		| 0                | DC      	 |
  	And user clicks `+ Location` on CNBC Production request
  	And user edits Location on CNBC Production request
  		| Location Number  | Location  |
  		| 1                | NAS       |
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	# Then user verifies all Logs on request
  	When user clicks Edit button on request
  	And user edits `ISO: Do you need ISO recordings?` on CNBC Production request
    	| Choice |
    	| Yes    |
    When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	# Then user verifies all Logs on request
  	When user clicks Edit button on request
    And user edits `Ingest: Do you need content to be recorded?` on CNBC Production request
    	| Choice |
    	| No     |
    When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	# Then user verifies all Logs on request
  	When user clicks Edit button on request
    When user edits Staging Needs on CNBC Production request
    	|Staging Needs|
    	|Editing staging needs|
    When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	# Then user verifies all Logs on request
  	When user clicks Edit button on request
    When user edits Request For on CNBC Production request
			| Request For |
			| Live Stream |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	# Then user verifies all Logs on request
  	When user clicks Edit button on request
		When user edits Details & Notes on CNBC Production request
			|Details & Notes|
			|created by automation|
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	# Then user verifies all Logs on request
  	When user clicks Edit button on request
		When user edits Air Platform on CNBC Production request
			|Air Platform|
			|Multiple|
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	# Then user verifies all Logs on request
  	When user clicks Edit button on request
		When user edits Show Unit or Project Name on CNBC Production request
			|Show Unit or Project Name|
			|The Exchange|
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	# Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user clears `Call Time` on CNBC Production request in edit mode
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	# Then user verifies all Logs on request
		When user clicks Edit button on request
		When user clears `End Time` on CNBC Production request
		When user edits End Time on CNBC Production request
			|Time|
			|7:00 PM|
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	# Then user verifies all Logs on request
  	When user clicks Edit button on request
		When user clears `Start Time` on CNBC Production request
		When user edits Start Time on CNBC Production request
			|Time|
			|6:00 PM|
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	# Then user verifies all Logs on request
  	When user clicks Edit button on request
		When user edits Division and selects "CNBC" on CNBC Production
		When user edits Sub Division on CNBC Production request
		|Sub Division|
		|CNBC Events|
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	# Then user verifies all Logs on request
  	When user clicks Edit button on request
		When user edits Call Time on CNBC Production request
		|Time|
		|5:00 PM|
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	# Then user verifies all Logs on request
  	When user clicks Edit button on request
		When user clears `Start Date` on CNBC Production request
		When user edits Start Date on CNBC Production request
		|Days from today|
		|1|
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	# Then user verifies all Logs on request
  	When user clicks Edit button on request
    When user clears `Set Crew` on CNBC Production request in edit mode
    When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	# Then user verifies all Logs on request
  	When user clicks Edit button on request
    When user clears `Control Room Crew` on CNBC Production request in edit mode
    When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	# Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user edits fields in Control Room Crew section on CNBC Production request
  		|Control Room Crew          |
  		|Director, TPS, SSG Graphics|
    When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	
  	@NcxUnifiedToolPhase2 @PSEQA @Logs_002 @Logs_CNBCProduction
  Scenario: Logs verification for all the section wise multiple field changes on CNBC Production Request
  	And user clicks on forms link
  	And user selects "CNBC" form
  	And user selects "CNBC" as Division on CNBC Production
  	When user populates PRODUCTION PURPOSE section on CNBC Production request
    	| Details & Notes |Request For|
    	| this is comments|Live Show  |
    When user selects fields in SHOW INFO section on CNBC Production request
     	|Air Platform|Show Unit or Project Name|Days from today|Start Time|End Time|Call Time|Sub Division |
     	|OTT         |Tech Check               |2              |12:00 PM  |3:00 PM |11:00 AM |CNBC Events  |
    And user selects Location on CNBC Production request
  		| Location Number  | Location  |
  		| 0                | EC      	|
    And user selects Set Crew on CNBC Production request
  		| Set Crew |
  		| Cam - Steadicam & Utility,Flashcam,Vid Robo,Stage Manager,Scene/Wall Graphics,Technical Producer,Lighting Director,Cam - Op Jib,Cam- Op Ped,Playout,Prompter |
    And user selects Staging Needs on CNBC Production request
      | Staging Needs       |
      | Test-test-test-test |
    And user selects `Is a Control Room Needed?` in CNBC production form
  		| Choice |
  		| Yes    |
  	When user selects fields in Control Room Crew section on CNBC Production request
  		|Control Room Crew                                     |ISO|Ingest|
  		|Audio - Pro Tools,Director,Audio - A1,TPS,SSG Graphics|No |Yes   |
    And  user clicks Submit button on request
  	Then user sees modal for successful "CNBC Production" request creation
  	And  user clicks on "ok" button
  	When user opens the created request
# validations for logs Controm Room section field changes
		When user clicks Edit button on request
	  When user selects `Is a Control Room Needed?` in CNBC production form in edit mode   	
	    |Choice|
	    |No    |
	  When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	# Then user verifies all Logs on request
  	When user clicks Edit button on request
	  When user selects `Is a Control Room Needed?` in CNBC production form in edit mode   	
	    |Choice|
	    |Yes   |
	  When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	# Then user verifies all Logs on request
  	When user clicks Edit button on request
	  When user selects `Is a Control Room Needed?` in CNBC production form in edit mode   	
	    |Choice|
	    |No    |
	  When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	# Then user verifies all Logs on request
  	When user clicks Edit button on request
	  When user selects `Is a Control Room Needed?` in CNBC production form in edit mode   	
	    |Choice|
	    |Yes   |
	  When user edits fields in Control Room Crew section on CNBC Production request
  		|Control Room Crew                                     |ISO|Ingest|
  		|Audio - Pro Tools,Director,Audio - A1,TPS,SSG Graphics|Yes|No    |
  	When user selects `Is a Control Room Needed?` in CNBC production form in edit mode   	
	    |Choice|
	    |No    |
	  When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	# Then user verifies all Logs on request
  	When user clicks Edit button on request
	  When user selects `Is a Control Room Needed?` in CNBC production form in edit mode   	
	    |Choice|
	    |Yes   |
	  When user edits fields in Control Room Crew section on CNBC Production request
  		|Control Room Crew                                     |ISO|Ingest|
  		|Audio - Pro Tools,Director,Audio - A1,TPS,SSG Graphics|Yes|No    |
	  When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	# Then user verifies all Logs on request
  	When user clicks Edit button on request
	  When user selects `Is a Control Room Needed?` in CNBC production form in edit mode   	
	    |Choice|
	    |No   |
  	When user selects `Is a Control Room Needed?` in CNBC production form in edit mode   	
	    |Choice |
	    |Yes    |
	  When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	# Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user selects `Is a Control Room Needed?` in CNBC production form in edit mode
  		| Choice |
  		| Yes    |
  	When user edits fields in Control Room Crew section on CNBC Production request
  		|Control Room Crew                                     |
  		|Audio - Pro Tools,Director,Audio - A1,TPS,SSG Graphics|
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	# Then user verifies all Logs on request
  	When user clicks Edit button on request
	  When user selects `Is a Control Room Needed?` in CNBC production form in edit mode   	
	    |Choice|
	    |No    |
	  When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	# Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user selects `Is a Control Room Needed?` in CNBC production form in edit mode
  		| Choice |
  		| Yes    |
  	When user edits fields in Control Room Crew section on CNBC Production request
  		|Ingest|
  		|Yes   |
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	# Then user verifies all Logs on request
  	When user clicks Edit button on request
	  When user selects `Is a Control Room Needed?` in CNBC production form in edit mode   	
	    |Choice|
	    |No    |
	  When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	# Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user selects `Is a Control Room Needed?` in CNBC production form in edit mode
  		| Choice |
  		| Yes    |
  	When user edits fields in Control Room Crew section on CNBC Production request
  		|ISO|
  		|No |
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	# Then user verifies all Logs on request
  	When user clicks Edit button on request
	  When user selects `Is a Control Room Needed?` in CNBC production form in edit mode   	
	    |Choice|
	    |No    |
	  When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	# Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user selects `Is a Control Room Needed?` in CNBC production form in edit mode
  		| Choice |
  		| Yes    |
  	When user edits fields in Control Room Crew section on CNBC Production request
  		|Control Room Crew                                     |ISO|Ingest|
  		|Audio - Pro Tools,Director,Audio - A1,TPS,SSG Graphics|Yes|No   |
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	# Then user verifies all Logs on request
# validations for log for Set Location section 
    When user clicks Edit button on request
  	And user edits Location on CNBC Production request
  		| Location Number  | Location  |
  		| 0                | DC      	 |
  	And user clicks `+ Location` on CNBC Production request
  	And user edits Location on CNBC Production request
  		| Location Number  | Location  |
  		| 1                | NAS       |
  	And user clicks `+ Location` on CNBC Production request
  	And user edits Location on CNBC Production request
  		| Location Number  | Location  |
  		| 2                | SF        |
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	# Then user verifies all Logs on request
  	When user clicks Edit button on request
  	And user edits Location on CNBC Production request
  		| Location Number  | Location  |
  		| 0                | SF      	 |
  	And user edits Location on CNBC Production request
  		| Location Number  | Location  |
  		| 1                | DC       |
  	And user edits Location on CNBC Production request
  		| Location Number  | Location  |
  		| 2                | NAS       |
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	# Then user verifies all Logs on request  	
  	When user clicks Edit button on request
  	And user removes location from Set Location section on CNBC Production in edit mode
  		| Location Number  |
  		| 0                |
  	And user removes location from Set Location section on CNBC Production in edit mode
  		| Location Number  |
  		| 1                |
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	# Then user verifies all Logs on request
# validations of log for Set Crew section - complete deletion, complete addition, some removal, some addition	
  	When user clicks Edit button on request
  	When user clears `Set Crew` on CNBC Production request in edit mode
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	# Then user verifies all Logs on request
  	When user clicks Edit button on request
    When user adds Set Crew on CNBC Production request in edit mode
  		| Set Crew |
  		| Cam - Steadicam & Utility,Flashcam,Vid Robo,Stage Manager,Scene/Wall Graphics,Technical Producer,Lighting Director,Cam - Op Jib,Cam- Op Ped,Playout,Prompter |
    When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	# Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user clears `Set Crew` on CNBC Production request in edit mode
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	# Then user verifies all Logs on request
  	When user clicks Edit button on request
    When user adds Set Crew on CNBC Production request in edit mode
  		| Set Crew |
  		| Cam - Steadicam & Utility,Flashcam,Vid Robo,Stage Manager,Scene/Wall Graphics |
    When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	# Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user removes Set Crew from Set Crew on CNBC Production request in edit mode
  		| Set Crew |
  		| Cam - Steadicam & Utility,Flashcam,Vid Robo,Stage Manager,Scene/Wall Graphics |
  	When user adds Set Crew on CNBC Production request in edit mode
  		| Set Crew |
  		| Technical Producer,Lighting Director,Cam - Op Jib,Cam- Op Ped,Playout,Utility,Prompter |
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	# Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user removes Set Crew from Set Crew on CNBC Production request in edit mode
  		| Set Crew |
  		| Technical Producer,Lighting Director,Cam - Op Jib,Cam- Op Ped,Playout,Utility,Prompter |
  	When user adds Set Crew on CNBC Production request in edit mode
  		| Set Crew |
  		| Cam - Steadicam & Utility,Flashcam,Stage Manager,Scene/Wall Graphics,Vid Robo |
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request  	
  #	# Then user verifies all Logs on request
# log validations for show info section changes
  	When user clicks Edit button on request
  	When user clears `End Time` on CNBC Production request
  	When user clears `Start Time` on CNBC Production request
  	When user clears `Call Time` on CNBC Production request in edit mode
  	When user clears `Start Date` on CNBC Production request
  	When user edits fields in SHOW INFO section on CNBC Production request in edit mode
     	|Air Platform|Show Unit or Project Name|Days from today|Start Time|End Time|Call Time|Sub Division |
     	|Multiple    |The Exchange             |1              |6:00 PM   |7:00 PM |5:00 PM  |CNBC Digital |
    When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	# Then user verifies all Logs on request
 # log validations for Production purpose section changes
    When user clicks Edit button on request
  	When user populates PRODUCTION PURPOSE section on CNBC Production request in edit mode
    	| Details & Notes          |Request For|
    	| this is comments - edited|Live Stream|
    When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	# Then user verifies all Logs on request
 # log validations for Staging Needs section changes
    When user clicks Edit button on request 	
  	When user edits Staging Needs on CNBC Production request
    	|Staging Needs|
    	|Editing staging needs|
    When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	# Then user verifies all Logs on request
 # log validations for Control Room Crew section changes
    When user clicks Edit button on request
    When user clears `Control Room Crew` on CNBC Production request in edit mode
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	# Then user verifies all Logs on request
 		When user clicks Edit button on request
    When user edits fields in Control Room Crew section on CNBC Production request
  		|Control Room Crew                                               |ISO |Ingest|
  		|Audio - Pro Tools,Audio - A1,Technical Director,TPS,SSG Graphics|Yes |No    |
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	# Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user removes Control Room Crew from Control Room Crew on CNBC Production request in edit mode
  		|Control Room Crew     |
  		|Audio - A1,TPS        |
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	# Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user edits fields in Control Room Crew section on CNBC Production request
  		|Control Room Crew       |ISO|
  		|Audio - A1,Director,TPS |No |
  	When user removes Control Room Crew from Control Room Crew on CNBC Production request in edit mode
  		|Control Room Crew                                  |
  		|Audio - Pro Tools,Technical Director,SSG Graphics  |
    When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	# Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user edits fields in Control Room Crew section on CNBC Production request
  		|Control Room Crew                                 |ISO| Ingest|
  		|Audio - Pro Tools,Technical Director,SSG Graphics |Yes| Yes   |
  	When user removes Control Room Crew from Control Room Crew on CNBC Production request in edit mode
  		|Control Room Crew        |
  		|Audio - A1,Director,TPS  |
    When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	
  	
  	@NcxUnifiedToolPhase2 @PSEQA @Logs_003 @Logs_CNBCProduction
  Scenario: Logs verification for Control Room Needed section changes, Talent and Requesters section changes 
  	And user clicks on forms link
  	And user selects "CNBC" form
  	And user selects "CNBC" as Division on CNBC Production
  	When user add specific user in Talent section
  	  | Name     |
  	  | Velshi, Ali & Alba, Monica  |
  	When user populates PRODUCTION PURPOSE section on CNBC Production request
    	| Details & Notes |Request For|
    	| this is comments|Live Show  |
    When user selects fields in SHOW INFO section on CNBC Production request
     	|Air Platform|Show Unit or Project Name|Days from today|Start Time|End Time|Call Time|Sub Division |
     	|OTT         |Tech Check               |2              |12:00 PM  |3:00 PM |11:00 AM |CNBC Events  |
    And user selects Location on CNBC Production request
  		| Location Number  | Location  |
  		| 0                | EC      	|
    #And user selects Set Crew on CNBC Production request
  #		| Set Crew |
  #		| Cam - Steadicam & Utility,Flashcam,Vid Robo,Stage Manager,Scene/Wall Graphics,Technical Producer,Lighting Director,Cam - Op Jib,Cam- Op Ped,Playout,Prompter |
    And user selects Staging Needs on CNBC Production request
      | Staging Needs       |
      | Test-test-test-test |
    And user selects `Is a Control Room Needed?` in CNBC production form
  		| Choice |
  		| Yes    |
  	When user selects fields in Control Room Crew section on CNBC Production request
  		|Control Room Crew                                     |ISO|Ingest|
  		|Audio - Pro Tools,Director,Audio - A1,TPS,SSG Graphics|No |Yes   |
    And  user clicks Submit button on request
  	Then user sees modal for successful "CNBC Production" request creation
  	And  user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
  	When user edits fields in Control Room Crew section on CNBC Production request
  		|Control Room Crew |ISO|Ingest|
  		|Technical Director|Yes|No    |
  	When user removes Control Room Crew from Control Room Crew on CNBC Production request in edit mode
  	  |Control Room Crew          |
  		|Audio - Pro Tools,Director |
  	When user selects `Is a Control Room Needed?` in CNBC production form in edit mode   	
	    |Choice|
	    |No   |
	  When user selects `Is a Control Room Needed?` in CNBC production form in edit mode   	
	    |Choice|
	    |Yes   |
	  When user edits fields in Control Room Crew section on CNBC Production request
  		|Control Room Crew                        |ISO|Ingest|
  		|Audio - Pro Tools,Director,Audio - A1,TPS|Yes|No    |
  	When user selects `Is a Control Room Needed?` in CNBC production form in edit mode   	
	    |Choice|
	    |No   |
	  When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	# Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user selects `Is a Control Room Needed?` in CNBC production form in edit mode   	
	    |Choice |
	    |Yes    |
	  When user edits fields in Control Room Crew section on CNBC Production request
  		|Control Room Crew              |ISO|Ingest|
  		|Technical Director,SSG Graphics|No |Yes   |
  	When user selects `Is a Control Room Needed?` in CNBC production form in edit mode   	
	    |Choice|
	    |No    |
	  When user selects `Is a Control Room Needed?` in CNBC production form in edit mode   	
	    |Choice |
	    |Yes    |
	  When user edits fields in Control Room Crew section on CNBC Production request
  		|Control Room Crew                                           |ISO|Ingest|
  		|Audio - Pro Tools,Technical Director,Audio - A1,SSG Graphics|Yes|No    |
	  When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	# Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user edits fields in Control Room Crew section on CNBC Production request
  		|Control Room Crew |ISO|Ingest|
  		|Director,TPS      |No |Yes   |
  	When user removes Control Room Crew from Control Room Crew on CNBC Production request in edit mode
  	  |Control Room Crew                    |
  		|Audio - Pro Tools,Technical Director |
  	When user selects `Is a Control Room Needed?` in CNBC production form in edit mode   	
	    |Choice |
	    |No    |
  	When user selects `Is a Control Room Needed?` in CNBC production form in edit mode   	
	    |Choice |
	    |Yes    |
	  When user edits fields in Control Room Crew section on CNBC Production request
  		|Control Room Crew  |ISO|Ingest|
  		|Director,TPS       |No |Yes   |
	  When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	# Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user selects `Is a Control Room Needed?` in CNBC production form in edit mode   	
	    |Choice |
	    |No    |
  	When user selects `Is a Control Room Needed?` in CNBC production form in edit mode   	
	    |Choice |
	    |Yes    |
	  When user edits fields in Control Room Crew section on CNBC Production request
  		|Control Room Crew                                            |ISO|Ingest|
  		|Audio - Pro Tools,Technical Director,Audio - A1,SSG Graphics |Yes|No    |
	  When user selects `Is a Control Room Needed?` in CNBC production form in edit mode   	
	    |Choice |
	    |No    |
	  When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	Then user verifies all Logs on request
    # validations for logs of Talent section field changes
		When user clicks Edit button on request
	  When user adds requester to the form in edit mode   	
	    |Requester       |
	    |Worker 2, STORM |
	  When user adds requester to the form in edit mode   	
	    |Requester       |
	    |Worker 11, STORM |
	  When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	# Then user verifies all Logs on request
  	When user clicks Edit button on request
	  When user removes requester to the form in edit mode   	
	    |Requester       |
	    |Worker 2, STORM & Worker 11, STORM |
	  When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	# Then user verifies all Logs on request
  	When user clicks Edit button on request
	  When user removes specific user in Talent section in edit mode
	  	| Name     |
	  	| Velshi, Ali & Alba, Monica  |
	  When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	# Then user verifies all Logs on request
  	When user clicks Edit button on request
	  When user adds requester to the form in edit mode   	
	    |Requester       |
	    |Worker 2, STORM |
	  When user removes requester to the form in edit mode   	
	    |Requester       |
	    |Worker 11, STORM |
	  When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	# Then user verifies all Logs on request
  	When user clicks Edit button on request
	  When user adds requester to the form in edit mode   	
	    |Requester       |
	    |Worker 11, STORM |
	  When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	# Then user verifies all Logs on request
  	When user clicks Edit button on request
	  When user removes requester to the form in edit mode   	
	    |Requester        |
	    |Worker 11, STORM |
	  When user removes requester to the form in edit mode   	
	    |Requester       |
	    |Worker 2, STORM |
	  When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  
  
  @NcxUnifiedToolPhase2 @PSEQA @Logs_004 @Logs_CNBCProduction
  Scenario: Logs verification when Fulfiller increases, decreases quantities, update names of crew resources and delete whole crew sections on CREW tab of fulfillment in CNBC Production Request  
  	And user clicks on forms link
  	And user selects "CNBC" form
  	And user selects "CNBC" as Division on CNBC Production
  	When user populates PRODUCTION PURPOSE section on CNBC Production request
    	| Details & Notes |Request For|
    	| this is comments|Live Show  |
    When user selects fields in SHOW INFO section on CNBC Production request
     	|Air Platform|Show Unit or Project Name|Days from today|Start Time|End Time|Call Time|Sub Division |
     	|OTT         |Tech Check               |2              |12:00 PM  |3:00 PM |11:00 AM |CNBC Events  |
    And user selects Location on CNBC Production request
  		| Location Number  | Location  |
  		| 0                | EC      	|
    And user selects Set Crew on CNBC Production request
  		| Set Crew |
  		| Cam - Steadicam & Utility,Flashcam,Vid Robo,Stage Manager,Scene/Wall Graphics,Technical Producer,Lighting Director,Cam - Op Jib,Cam- Op Ped,Playout,Prompter |
    And user selects Staging Needs on CNBC Production request
      | Staging Needs       |
      | Test-test-test-test |
    And user selects `Is a Control Room Needed?` in CNBC production form
  		| Choice |
  		| Yes    |
  	When user selects fields in Control Room Crew section on CNBC Production request
  		|Control Room Crew                                     |ISO|Ingest|
  		|Audio - Pro Tools,Director,Audio - A1,TPS,SSG Graphics|No |Yes   |
    And  user clicks Submit button on request
  	Then user sees modal for successful "CNBC Production" request creation
  	And  user clicks on "ok" button
  	Then user logs out from application
  	Given user opens producer dashboard application
    And user logins with "fulfiller" role
    When user opens the created request
		When user clicks Edit button on request
		When user switches to `Crew` tab in Fulfillment
		Then user modifies the Control Room Crew Member quantities in fulfillment
		Then user provides the Control Room Crew Member names in fulfillment
		Then user deletes Control Room Crew Member names in fulfillment randomly
		Then user deletes Control Room Crew names in fulfillment
  		| Control Room Crew          |
  		| Audio - Pro Tools,Director |
		When user clicks Save button on request
		Then user clicks on "ok" button
		When user opens the created request
		# Then user verifies all Logs on request
    When user opens the created request
		When user clicks Edit button on request
		When user switches to `Crew` tab in Fulfillment
		Then user modifies the Set Crew Member quantities in fulfillment
		Then user provides the Set Crew Member names in fulfillment
		Then user deletes Set Crew Member names in fulfillment randomly
		Then user deletes Set Crew names in fulfillment
  		| Set Crew                                    |
  		| Cam - Steadicam & Utility,Flashcam,Vid Robo |
		When user clicks Save button on request
		Then user clicks on "ok" button
		When user opens the created request
		# Then user verifies all Logs on request
  	When user opens the created request
  	When user clicks Edit button on request
  	When user switches to `Crew` tab in Fulfillment
  	Then user modifies the Set Crew Member quantities in fulfillment
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	# Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user switches to `Crew` tab in Fulfillment
  	Then user provides the Set Crew Member names in fulfillment
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	# Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user switches to `Crew` tab in Fulfillment
  	Then user deletes Set Crew Member names in fulfillment randomly
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	# Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user switches to `Crew` tab in Fulfillment
  	Then user deletes Set Crew names in fulfillment
  		| Set Crew                                    |
  		| Cam - Steadicam & Utility,Flashcam,Vid Robo |
	  When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	
  	
  	@NcxUnifiedToolPhase2 @PSEQA @Logs_005 @Logs_CNBCProduction
  Scenario: Logs verification when Fulfiller selects and unselects different fulfillment status on CNBC Production request
  	And user clicks on forms link
  	And user selects "CNBC" form
  	And user selects "CNBC" as Division on CNBC Production
  	When user add specific user in Talent section
  	  | Name     |
  	  | Velshi, Ali & Alba, Monica  |
  	When user adds requester to the form
	    |Requester       |
	    |Worker 2, STORM |
	  When user adds requester to the form 	
	    |Requester       |
	    |Worker 11, STORM |
  	When user populates PRODUCTION PURPOSE section on CNBC Production request
    	| Details & Notes |Request For|
    	| this is comments|Live Show  |
    When user selects fields in SHOW INFO section on CNBC Production request
     	|Air Platform|Show Unit or Project Name|Days from today|Start Time|End Time|Call Time|Sub Division |
     	|OTT         |Tech Check               |2              |12:00 PM  |3:00 PM |11:00 AM |CNBC Events  |
    And user selects Location on CNBC Production request
  		| Location Number  | Location  |
  		| 0                | EC      	|
    And user selects Set Crew on CNBC Production request
  		| Set Crew |
  		| Cam - Steadicam & Utility,Flashcam,Vid Robo,Stage Manager,Scene/Wall Graphics,Technical Producer,Lighting Director,Cam - Op Jib,Cam- Op Ped,Playout,Prompter |
    And user selects Staging Needs on CNBC Production request
      | Staging Needs       |
      | Test-test-test-test |
    And user selects `Is a Control Room Needed?` in CNBC production form
  		| Choice |
  		| Yes    |
  	When user selects fields in Control Room Crew section on CNBC Production request
  		|Control Room Crew                                     |ISO|Ingest|
  		|Audio - Pro Tools,Director,Audio - A1,TPS,SSG Graphics|No |Yes   |
    And  user clicks Submit button on request
  	Then user sees modal for successful "CNBC Production" request creation
  	And  user clicks on "ok" button
  	Then user logs out from application
  	Given user opens producer dashboard application
    And user logins with "fulfiller" role
    When user opens the created request
		When user clicks Edit button on request
		Then user completes below status in fulfillment
			|Status                                   |
			|Acknowledged, TPS, Studio, Director, PCR |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	# Then user verifies all Logs on request
  	When user clicks Edit button on request
  	Then user clears below status in fulfillment
			|Status                                   |
			|TPS, Studio, Director, PCR |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	# Then user verifies all Logs on request
  	When user clicks Edit button on request
		Then user completes below status in fulfillment
			|Status                                   |
			|TPS, Studio, PCR |
  	Then user clears below status in fulfillment
			|Status                                   |
			|TPS, Studio, PCR |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	# Then user verifies all Logs on request
  	When user clicks Edit button on request
		Then user completes below status in fulfillment
			|Status                                   |
			|TPS, Studio, PCR |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
  	Then user clears below status in fulfillment
			|Status                                   |
			|TPS, Studio, PCR |
		Then user completes below status in fulfillment
			|Status                                   |
			|TPS, Studio, PCR |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	
  	@NcxUnifiedToolPhase2 @PSEQA @Logs_006 @Logs_CNBCProduction
  Scenario: Logs verification when Requester and Fulfiller adds, edits or deletes notes on CNBC Request
  	And user clicks on forms link
  	And user selects "CNBC" form
  	And user selects "CNBC" as Division on CNBC Production
  	When user populates PRODUCTION PURPOSE section on CNBC Production request
    	| Details & Notes |Request For|
    	| this is comments|Live Show  |
    When user selects fields in SHOW INFO section on CNBC Production request
     	|Air Platform|Show Unit or Project Name|Days from today|Start Time|End Time|Call Time|Sub Division |
     	|OTT         |Tech Check               |2              |12:00 PM  |3:00 PM |11:00 AM |CNBC Events  |
    And user selects Location on CNBC Production request
  		| Location Number  | Location  |
  		| 0                | EC      	|
    And user selects Set Crew on CNBC Production request
  		| Set Crew |
  		| Cam - Steadicam & Utility,Flashcam,Vid Robo,Stage Manager,Scene/Wall Graphics,Technical Producer,Lighting Director,Cam - Op Jib,Cam- Op Ped,Playout,Prompter |
    And user selects Staging Needs on CNBC Production request
      | Staging Needs       |
      | Test-test-test-test |
    And user selects `Is a Control Room Needed?` in CNBC production form
  		| Choice |
  		| Yes    |
  	When user selects fields in Control Room Crew section on CNBC Production request
  		|Control Room Crew                                     |ISO|Ingest|
  		|Audio - Pro Tools,Director,Audio - A1,TPS,SSG Graphics|No |Yes   |
    And  user clicks Submit button on request
  	Then user sees modal for successful "CNBC Production" request creation
  	And  user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
  	When user switches to `Notes` tab in right container on Request
  	Then user adds 11 notes on request
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  #	When user opens the created request
  	# Then user verifies all Logs on request
  	Then user logs out from application
  	Given user opens producer dashboard application
    And user logins with "fulfiller" role
    When user opens the created request
		When user clicks Edit button on request
		When user switches to `Notes` tab in right container on Request
  	Then user adds 11 notes on request
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  #	When user opens the created request
  	# Then user verifies all Logs on request
  	Then user logs out from application
  	Given user opens producer dashboard application
    And user logins with "producer" role
    When user opens the created request
		When user clicks Edit button on request
		When user switches to `Notes` tab in right container on Request
  	Then user edits notes on request randomly
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
		When user switches to `Notes` tab in right container on Request
  	Then user deletes notes on request randomly
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  #	When user opens the created request
  	# Then user verifies all Logs on request
  	Then user logs out from application
  	Given user opens producer dashboard application
    And user logins with "fulfiller" role
    When user opens the created request
		When user clicks Edit button on request
		When user switches to `Notes` tab in right container on Request
  	Then user edits notes on request randomly
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
		When user switches to `Notes` tab in right container on Request
  	Then user deletes notes on request randomly
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	
  	
  	@NcxUnifiedToolPhase2 @PSEQA @Logs_007 @Logs_CNBCProduction
  Scenario: Logs verification when Producer clicks Cancel Request and then Fulfiller clicks Confirm Cancel Request on newly created CNBC Request
  	And user clicks on forms link
  	And user selects "CNBC" form
  	And user selects "CNBC" as Division on CNBC Production
  	When user populates PRODUCTION PURPOSE section on CNBC Production request
    	| Details & Notes |Request For|
    	| this is comments|Live Show  |
    When user selects fields in SHOW INFO section on CNBC Production request
     	|Air Platform|Show Unit or Project Name|Days from today|Start Time|End Time|Call Time|Sub Division |
     	|OTT         |Tech Check               |2              |12:00 PM  |3:00 PM |11:00 AM |CNBC Events  |
    And user selects Location on CNBC Production request
  		| Location Number  | Location  |
  		| 0                | EC      	|
    And user selects Set Crew on CNBC Production request
  		| Set Crew |
  		| Cam - Steadicam & Utility,Flashcam,Vid Robo,Stage Manager,Scene/Wall Graphics,Technical Producer,Lighting Director,Cam - Op Jib,Cam- Op Ped,Playout,Prompter |
    And user selects Staging Needs on CNBC Production request
      | Staging Needs       |
      | Test-test-test-test |
    And user selects `Is a Control Room Needed?` in CNBC production form
  		| Choice |
  		| Yes    |
  	When user selects fields in Control Room Crew section on CNBC Production request
  		|Control Room Crew                                     |ISO|Ingest|
  		|Audio - Pro Tools,Director,Audio - A1,TPS,SSG Graphics|No |Yes   |
    And  user clicks Submit button on request
  	Then user sees modal for successful "CNBC Production" request creation
  	And  user clicks on "ok" button
  	When user opens the created request
		Then user clicks Cancel Request button on request
		When user opens the created request
		Then user verifies all Logs on request
		Then user logs out from application
  	Given user opens producer dashboard application
    And user logins with "fulfiller" role
    When user opens the created request
    Then user clicks Confirm Cancellation button on request
    When user opens the created request
		Then user verifies all Logs on request
		
		@NcxUnifiedToolPhase2 @PSEQA @Logs_008 @Logs_CNBCProduction
  Scenario: Logs verification when Fulfiller clicks Cancel Request on newly created CNBC Request
  	And user clicks on forms link
  	And user selects "CNBC" form
  	And user selects "CNBC" as Division on CNBC Production
  	When user populates PRODUCTION PURPOSE section on CNBC Production request
    	| Details & Notes |Request For|
    	| this is comments|Live Show  |
    When user selects fields in SHOW INFO section on CNBC Production request
     	|Air Platform|Show Unit or Project Name|Days from today|Start Time|End Time|Call Time|Sub Division |
     	|OTT         |Tech Check               |2              |12:00 PM  |3:00 PM |11:00 AM |CNBC Events  |
    And user selects Location on CNBC Production request
  		| Location Number  | Location  |
  		| 0                | EC      	|
    And user selects Set Crew on CNBC Production request
  		| Set Crew |
  		| Cam - Steadicam & Utility,Flashcam,Vid Robo,Stage Manager,Scene/Wall Graphics,Technical Producer,Lighting Director,Cam - Op Jib,Cam- Op Ped,Playout,Prompter |
    And user selects Staging Needs on CNBC Production request
      | Staging Needs       |
      | Test-test-test-test |
    And user selects `Is a Control Room Needed?` in CNBC production form
  		| Choice |
  		| Yes    |
  	When user selects fields in Control Room Crew section on CNBC Production request
  		|Control Room Crew                                     |ISO|Ingest|
  		|Audio - Pro Tools,Director,Audio - A1,TPS,SSG Graphics|No |Yes   |
    And  user clicks Submit button on request
  	Then user sees modal for successful "CNBC Production" request creation
  	And  user clicks on "ok" button
		Then user logs out from application
  	Given user opens producer dashboard application
    And user logins with "fulfiller" role
    When user opens the created request
    Then user clicks Cancel Request button on request
    When user opens the created request
		Then user verifies all Logs on request
		
		
		@NcxUnifiedToolPhase2 @PSEQA @Logs_009 @Logs_ExtendOrBridge
  Scenario: Logs verification for Set Location & Crew section on Extend or Bridge Crew Facilities with Request Type=Extend
  	And user clicks on forms link
  	And user selects "Extend or Bridge Crew & Facilities" form
  	And user selects Division on Extend or Bridge Crew & Facilities production request
  		|Division  |
  		|CNBC      |
  	When user selects Details and Notes on Extend or Bridge Crew & Facilities production request
    	| Details and Notes |
    	| this is comments  |
    When user selects fields in SHOW INFO section on Extend or Bridge Crew & Facilities production request
     	|Request For  |Air Platform|Show Unit or Project Name|Days from today|Start Time|End Time|
     	|Extend       |OTT         |ACCESS HOLLYWOOD         |2              |12:00 PM  |3:00 PM |
    When user selects fields in Set Location & Crew section on Extend or Bridge Crew & Facilities production request
  		| Location  |Set Location |
  		| DC      	|N-7          |
  	When user selects fields in Control Room & Crew section on Extend or Bridge Crew & Facilities production request
    	|Control Room & Crew|Control Room Location  | Control Room |
    	| Yes               |Rock Center            | CR 71        |
    And user selects `Is a TPM or TM Needed?` on Extend or Bridge Crew & Facilities production request
  		| Choice |
  		| No     |
    And  user clicks Submit button on request
  	Then user sees modal for successful "Extend or Bridge Crew & Facilities" request creation
  	And  user clicks on "ok" button
		When user opens the created request
		When user clicks Edit button on request
		When user selects fields in Set Location & Crew section on Extend or Bridge Crew & Facilities production request in edit mode
  		|Set Location |
  		|N-1          |
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
		When user selects fields in Set Location & Crew section on Extend or Bridge Crew & Facilities production request in edit mode
  		|Set Location | Location  |
  		|Flashcam Room| LA        |
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
		When user selects fields in Set Location & Crew section on Extend or Bridge Crew & Facilities production request in edit mode
  		| Location  |Address                          |
  		| Field     |address given by automation .... |
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
		When user selects fields in Set Location & Crew section on Extend or Bridge Crew & Facilities production request in edit mode
  		| Location  |Address                                   |
  		| Field     |address given by automation .... - edited |
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
		When user selects fields in Set Location & Crew section on Extend or Bridge Crew & Facilities production request in edit mode
  		| Location  |
  		| None      |
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
		When user selects fields in Set Location & Crew section on Extend or Bridge Crew & Facilities production request in edit mode
  		|Set Location | Location        |
  		|3B Studio    | Rock Center     |
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
		When user selects fields in Set Location & Crew section on Extend or Bridge Crew & Facilities production request in edit mode
  		| Location  |Address                                   |
  		| Field     |address given by automation .... - edited |
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	
  	@NcxUnifiedToolPhase2 @PSEQA @Logs_010 @Logs_ExtendOrBridge
  Scenario: Logs verification for Set Location & Crew section on Extend or Bridge Crew Facilities with Request Type=Bridge
  	And user clicks on forms link
  	And user selects "Extend or Bridge Crew & Facilities" form
  	And user selects Division on Extend or Bridge Crew & Facilities production request
  		|Division  |
  		|CNBC      |
  	When user selects Details and Notes on Extend or Bridge Crew & Facilities production request
    	| Details and Notes |
    	| this is comments  |
    When user selects fields in SHOW INFO section on Extend or Bridge Crew & Facilities production request
     	|Request For  |Air Platform|Show Unit or Project Name|Days from today|Start Time|End Time|
     	|Bridge       |OTT         |ACCESS HOLLYWOOD         |2              |12:00 PM  |3:00 PM |
    When user selects fields in Set Location & Crew section on Extend or Bridge Crew & Facilities production request
  		| Location  |Set Location |
  		| DC      	|N-7          |
  	When user selects fields in Control Room & Crew section on Extend or Bridge Crew & Facilities production request
    	|Control Room & Crew|Control Room Location  | Control Room |
    	| Yes               |Rock Center            | CR 71        |
    And user selects `Is a TPM or TM Needed?` on Extend or Bridge Crew & Facilities production request
  		| Choice |
  		| No     |
    And  user clicks Submit button on request
  	Then user sees modal for successful "Extend or Bridge Crew & Facilities" request creation
  	And  user clicks on "ok" button
		When user opens the created request
		When user clicks Edit button on request
		When user selects fields in Set Location & Crew section on Extend or Bridge Crew & Facilities production request in edit mode
  		|Set Location |
  		|N-1          |
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
		When user selects fields in Set Location & Crew section on Extend or Bridge Crew & Facilities production request in edit mode
  		|Set Location | Location  |
  		|Flashcam Room| LA        |
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
		When user selects fields in Set Location & Crew section on Extend or Bridge Crew & Facilities production request in edit mode
  		| Location  |Address                          |
  		| Field     |address given by automation .... |
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
		When user selects fields in Set Location & Crew section on Extend or Bridge Crew & Facilities production request in edit mode
  		| Location  |Address                                   |
  		| Field     |address given by automation .... - edited |
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
		When user selects fields in Set Location & Crew section on Extend or Bridge Crew & Facilities production request in edit mode
  		| Location  |
  		| None      |
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
		When user selects fields in Set Location & Crew section on Extend or Bridge Crew & Facilities production request in edit mode
  		|Set Location | Location        |
  		|3B Studio    | Rock Center     |
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
		When user selects fields in Set Location & Crew section on Extend or Bridge Crew & Facilities production request in edit mode
  		| Location  |Address                                   |
  		| Field     |address given by automation .... - edited |
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	
  	@NcxUnifiedToolPhase2 @PSEQA @Logs_011 @Logs_ExtendOrBridge
  Scenario: Logs verification for Show Info section on Extend or Bridge Crew Facilities with Request Type=Bridge
  	And user clicks on forms link
  	And user selects "Extend or Bridge Crew & Facilities" form
  	And user selects Division on Extend or Bridge Crew & Facilities production request
  		|Division  |
  		|CNBC      |
  	When user selects Details and Notes on Extend or Bridge Crew & Facilities production request
    	| Details and Notes |
    	| this is comments  |
    When user selects fields in SHOW INFO section on Extend or Bridge Crew & Facilities production request
     	|Request For  |Air Platform|Show Unit or Project Name|Days from today|Start Time|End Time|
     	|Bridge       |OTT         |ACCESS HOLLYWOOD         |2              |12:00 PM  |3:00 PM |
    When user selects fields in Set Location & Crew section on Extend or Bridge Crew & Facilities production request
  		| Location  |Set Location |
  		| DC      	|N-7          |
  	When user selects fields in Control Room & Crew section on Extend or Bridge Crew & Facilities production request
    	|Control Room & Crew|Control Room Location  | Control Room |
    	| Yes               |Rock Center            | CR 71        |
    And user selects `Is a TPM or TM Needed?` on Extend or Bridge Crew & Facilities production request
  		| Choice |
  		| Yes     |
    And  user clicks Submit button on request
  	Then user sees modal for successful "Extend or Bridge Crew & Facilities" request creation
  	And  user clicks on "ok" button
		When user opens the created request
		When user clicks Edit button on request
		When user clears End Time on Extend or Bridge Crew & Facilities production request
		When user clears Start Time on Extend or Bridge Crew & Facilities production request
		When user clears Start Date on Extend or Bridge Crew & Facilities production request
		When user selects fields in SHOW INFO section on Extend or Bridge Crew & Facilities production request in edit mode
     	|Request For  |Air Platform|Show Unit or Project Name|Days from today|Start Time|End Time|
     	|Extend       |OTT         |ACCESS HOLLYWOOD         |2              |12:00 PM  |3:00 PM |
		When user selects fields in Set Location & Crew section on Extend or Bridge Crew & Facilities production request in edit mode
  		|Set Location | Location  |
  		|Flashcam Room| LA        |
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
  	When user clears End Time on Extend or Bridge Crew & Facilities production request
		When user clears Start Time on Extend or Bridge Crew & Facilities production request
		When user clears Start Date on Extend or Bridge Crew & Facilities production request
		When user selects fields in SHOW INFO section on Extend or Bridge Crew & Facilities production request in edit mode
     	|Request For  |Air Platform|Show Unit or Project Name|Days from today|Start Time|End Time|
     	|Extend       |Multiple    |7S Tour Studio           |4              |2:00 PM   |5:00 PM |
		When user selects fields in Set Location & Crew section on Extend or Bridge Crew & Facilities production request in edit mode
  		| Location  |Address                                   |
  		| Field     |address given by automation .... - edited |
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
		When user selects fields in Set Location & Crew section on Extend or Bridge Crew & Facilities production request in edit mode
  		| Location  |
  		| None      |
  	When user clears End Time on Extend or Bridge Crew & Facilities production request
		When user clears Start Time on Extend or Bridge Crew & Facilities production request
		When user clears Start Date on Extend or Bridge Crew & Facilities production request
  	When user selects fields in SHOW INFO section on Extend or Bridge Crew & Facilities production request in edit mode
     	|Request For  |Air Platform|Show Unit or Project Name|Days from today|Start Time|End Time|
     	|Bridge       |Multiple    |Alex Wagner Tonight      |15             |5:00 PM   |9:00 PM |	
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
  	When user clears End Time on Extend or Bridge Crew & Facilities production request
		When user clears Start Time on Extend or Bridge Crew & Facilities production request
		When user clears Start Date on Extend or Bridge Crew & Facilities production request
		When user selects fields in SHOW INFO section on Extend or Bridge Crew & Facilities production request in edit mode
     	|Request For  |Air Platform|Show Unit or Project Name|Days from today|Start Time|End Time|Work Order   |  Other                        |Budget Code |
     	|Extend       |Multiple    |OTHER                    |15             |12:00 PM   |2:00 PM |W00098       |  This is data for other field |autOMATION  |
		When user selects fields in Set Location & Crew section on Extend or Bridge Crew & Facilities production request in edit mode
  		| Location  |Address                                   |
  		| Field     |address given by automation .... - edited |
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	
  	@NcxUnifiedToolPhase2 @PSEQA @Logs_012 @Logs_ExtendOrBridge
  Scenario: Logs verification for Control Room & Crew section on Extend or Bridge Crew Facilities with Request Type=Extend
  	And user clicks on forms link
  	And user selects "Extend or Bridge Crew & Facilities" form
  	And user selects Division on Extend or Bridge Crew & Facilities production request
  		|Division  |
  		|CNBC      |
  	When user selects Details and Notes on Extend or Bridge Crew & Facilities production request
    	| Details and Notes |
    	| this is comments  |
    When user selects fields in SHOW INFO section on Extend or Bridge Crew & Facilities production request
     	|Request For  |Air Platform|Show Unit or Project Name|Days from today|Start Time|End Time|
     	|Extend       |OTT         |ACCESS HOLLYWOOD         |2              |12:00 PM  |3:00 PM |
    When user selects fields in Set Location & Crew section on Extend or Bridge Crew & Facilities production request
  		| Location  |Set Location |
  		| DC      	|N-7          |
  	When user selects fields in Control Room & Crew section on Extend or Bridge Crew & Facilities production request
    	|Control Room & Crew|Control Room Location  | Control Room |
    	| Yes               |Rock Center            | CR 71        |
    And user selects `Is a TPM or TM Needed?` on Extend or Bridge Crew & Facilities production request
  		| Choice |
  		| Yes     |
    And  user clicks Submit button on request
  	Then user sees modal for successful "Extend or Bridge Crew & Facilities" request creation
  	And  user clicks on "ok" button
		When user opens the created request
		When user clicks Edit button on request
		When user clears End Time on Extend or Bridge Crew & Facilities production request
		When user clears Start Time on Extend or Bridge Crew & Facilities production request
		When user clears Start Date on Extend or Bridge Crew & Facilities production request
		When user selects fields in SHOW INFO section on Extend or Bridge Crew & Facilities production request in edit mode
     	|Request For  |Air Platform|Show Unit or Project Name|Days from today|Start Time|End Time|
     	|Bridge       |OTT         |ACCESS HOLLYWOOD         |2              |12:00 PM  |3:00 PM |
		When user selects fields in Set Location & Crew section on Extend or Bridge Crew & Facilities production request in edit mode
  		|Set Location | Location  |
  		|Flashcam Room| LA        |
  	When user selects fields in Control Room & Crew section on Extend or Bridge Crew & Facilities production request in edit mode
  		|Control Room & Crew|
    	| No                |
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
  	When user clears End Time on Extend or Bridge Crew & Facilities production request
		When user clears Start Time on Extend or Bridge Crew & Facilities production request
		When user clears Start Date on Extend or Bridge Crew & Facilities production request
		When user selects fields in SHOW INFO section on Extend or Bridge Crew & Facilities production request in edit mode
     	|Request For  |Air Platform|Show Unit or Project Name|Days from today|Start Time|End Time|
     	|Extend       |Multiple    |7S Tour Studio           |4              |2:00 PM   |5:00 PM |
		When user selects fields in Set Location & Crew section on Extend or Bridge Crew & Facilities production request in edit mode
  		| Location  |Address                                   |
  		| Field     |address given by automation .... - edited |
  	When user selects fields in Control Room & Crew section on Extend or Bridge Crew & Facilities production request in edit mode
  		|Control Room & Crew|Control Room Location  | Control Room |
    	| Yes               |Rock Center            | CR 33        |
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
		When user selects fields in Set Location & Crew section on Extend or Bridge Crew & Facilities production request in edit mode
  		| Location  |
  		| None      |
  	When user selects fields in Control Room & Crew section on Extend or Bridge Crew & Facilities production request in edit mode
  		|Control Room & Crew|Control Room Location  | Address                                     |
    	| Yes               |Field                  | address given by automation in control room |
  	When user clears End Time on Extend or Bridge Crew & Facilities production request
		When user clears Start Time on Extend or Bridge Crew & Facilities production request
		When user clears Start Date on Extend or Bridge Crew & Facilities production request
  	When user selects fields in SHOW INFO section on Extend or Bridge Crew & Facilities production request in edit mode
     	|Request For  |Air Platform|Show Unit or Project Name|Days from today|Start Time|End Time|
     	|Bridge       |Multiple    |Alex Wagner Tonight      |15             |5:00 PM   |9:00 PM |	
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
  	When user clears End Time on Extend or Bridge Crew & Facilities production request
		When user clears Start Time on Extend or Bridge Crew & Facilities production request
		When user clears Start Date on Extend or Bridge Crew & Facilities production request
		When user selects fields in SHOW INFO section on Extend or Bridge Crew & Facilities production request in edit mode
     	|Request For  |Air Platform|Show Unit or Project Name|Days from today|Start Time|End Time|Work Order   |  Other                        |Budget Code |
     	|Extend       |Multiple    |OTHER                    |15             |12:00 PM   |2:00 PM |W00098       |  This is data for other field |autOMATION  |
		When user selects fields in Set Location & Crew section on Extend or Bridge Crew & Facilities production request in edit mode
  		| Location  |Address                                   |
  		| Field     |address given by automation .... - edited |
  	When user selects fields in Control Room & Crew section on Extend or Bridge Crew & Facilities production request in edit mode
  		|Control Room Location  | 
    	|No Control Room        |
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
  	When user clears End Time on Extend or Bridge Crew & Facilities production request
		When user clears Start Time on Extend or Bridge Crew & Facilities production request
		When user clears Start Date on Extend or Bridge Crew & Facilities production request
		When user selects fields in SHOW INFO section on Extend or Bridge Crew & Facilities production request in edit mode
     	|Request For  |Air Platform|Show Unit or Project Name|Days from today|Start Time|End Time|Work Order   |Budget Code |
     	|Bridge       |OTT         |OTHER                    |15             |12:00 PM   |2:00 PM |W00099      |autOMATION_N  |
		When user selects fields in Set Location & Crew section on Extend or Bridge Crew & Facilities production request in edit mode
  		| Location  |Address                                   |
  		| Field     |address given by automation .... - edited |
  	When user selects fields in Control Room & Crew section on Extend or Bridge Crew & Facilities production request in edit mode
  		|Control Room & Crew |Control Room Location  |  Control Room  |
    	|Yes                 |Rock Center            |  CR 71         |
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	
  	@NcxUnifiedToolPhase2 @PSEQA @Logs_013 @Logs_ExtendOrBridge
  Scenario: Logs verification when Fulfiller selects and unselects different fulfillment status on Extend or Bridge Production request
  	And user clicks on forms link
  	And user selects "Extend or Bridge Crew & Facilities" form
  	And user selects Division on Extend or Bridge Crew & Facilities production request
  		|Division  |
  		|CNBC      |
  	When user selects Details and Notes on Extend or Bridge Crew & Facilities production request
    	| Details and Notes |
    	| this is comments  |
    When user selects fields in SHOW INFO section on Extend or Bridge Crew & Facilities production request
     	|Request For  |Air Platform|Show Unit or Project Name|Days from today|Start Time|End Time|
     	|Extend       |OTT         |ACCESS HOLLYWOOD         |2              |12:00 PM  |3:00 PM |
    When user selects fields in Set Location & Crew section on Extend or Bridge Crew & Facilities production request
  		| Location  |Set Location |
  		| DC      	|N-7          |
  	When user selects fields in Control Room & Crew section on Extend or Bridge Crew & Facilities production request
    	|Control Room & Crew|Control Room Location  | Control Room |
    	| Yes               |Rock Center            | CR 71        |
    And user selects `Is a TPM or TM Needed?` on Extend or Bridge Crew & Facilities production request
  		| Choice |
  		| Yes     |
    And  user clicks Submit button on request
  	Then user sees modal for successful "Extend or Bridge Crew & Facilities" request creation
  	And  user clicks on "ok" button
  	Then user logs out from application
  	Given user opens producer dashboard application
    And user logins with "fulfiller" role
    When user opens the created request
		When user clicks Edit button on request
		Then user completes below status in fulfillment on Extend or Bridge Crew & Facilities Request
			|Status                                           |
			|Acknowledged, Technical, TPM/TM, DC Fulfillment  |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	Then user clears below status in fulfillment on Extend or Bridge Crew & Facilities Request
			|Status                                   |
			|TPM/TM,Technical, DC Fulfillment |
		When user selects fields in Set Location & Crew section on Extend or Bridge Crew & Facilities production request in edit mode
  		| Location  |Set Location |
  		| LA      	|Stage West   |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	Then user verifies all Logs on request
  	When user clicks Edit button on request
		Then user completes below status in fulfillment on Extend or Bridge Crew & Facilities Request
			|Status                                   |
			|TPM/TM,Technical, LA Fulfillment |
  	Then user clears below status in fulfillment on Extend or Bridge Crew & Facilities Request
			|Status                                   |
			|TPM/TM,Technical |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	Then user verifies all Logs on request
  	When user clicks Edit button on request
		Then user completes below status in fulfillment on Extend or Bridge Crew & Facilities Request
			|Status                                   |
			|TPM/TM,Technical |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	Then user clears below status in fulfillment on Extend or Bridge Crew & Facilities Request
			|Status                                   |
			|TPM/TM,Technical, LA Fulfillment |
		Then user completes below status in fulfillment on Extend or Bridge Crew & Facilities Request
			|Status                                   |
			|TPM/TM,Technical, LA Fulfillment |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	
  	@NcxUnifiedToolPhase2 @PSEQA @Logs_014 @Logs_ExtendOrBridge
  Scenario: Logs verification when Requester and Fulfiller adds, edits or deletes notes on CNBC Request
  	And user clicks on forms link
  	And user selects "Extend or Bridge Crew & Facilities" form
  	And user selects Division on Extend or Bridge Crew & Facilities production request
  		|Division  |
  		|CNBC      |
  	When user selects Details and Notes on Extend or Bridge Crew & Facilities production request
    	| Details and Notes |
    	| this is comments  |
    When user selects fields in SHOW INFO section on Extend or Bridge Crew & Facilities production request
     	|Request For  |Air Platform|Show Unit or Project Name|Days from today|Start Time|End Time|
     	|Extend       |OTT         |ACCESS HOLLYWOOD         |2              |12:00 PM  |3:00 PM |
    When user selects fields in Set Location & Crew section on Extend or Bridge Crew & Facilities production request
  		| Location  |Set Location |
  		| DC      	|N-7          |
  	When user selects fields in Control Room & Crew section on Extend or Bridge Crew & Facilities production request
    	|Control Room & Crew|Control Room Location  | Control Room |
    	| Yes               |Rock Center            | CR 71        |
    And user selects `Is a TPM or TM Needed?` on Extend or Bridge Crew & Facilities production request
  		| Choice |
  		| Yes     |
    And  user clicks Submit button on request
  	Then user sees modal for successful "Extend or Bridge Crew & Facilities" request creation
  	And  user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
  	When user switches to `Notes` tab in right container on Request
  	Then user adds 11 notes on request
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  #	When user opens the created request
  	# Then user verifies all Logs on request
  	Then user logs out from application
  	Given user opens producer dashboard application
    And user logins with "fulfiller" role
    When user opens the created request
		When user clicks Edit button on request
		When user switches to `Notes` tab in right container on Request
  	Then user adds 11 notes on request
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  #	When user opens the created request
  	# Then user verifies all Logs on request
  	Then user logs out from application
  	Given user opens producer dashboard application
    And user logins with "producer" role
    When user opens the created request
		When user clicks Edit button on request
		When user switches to `Notes` tab in right container on Request
  	Then user edits notes on request randomly
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
		When user switches to `Notes` tab in right container on Request
  	Then user deletes notes on request randomly
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  #	When user opens the created request
  	# Then user verifies all Logs on request
  	Then user logs out from application
  	Given user opens producer dashboard application
    And user logins with "fulfiller" role
    When user opens the created request
		When user clicks Edit button on request
		When user switches to `Notes` tab in right container on Request
  	Then user edits notes on request randomly
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
		When user switches to `Notes` tab in right container on Request
  	Then user deletes notes on request randomly
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	
  	
  	@NcxUnifiedToolPhase2 @PSEQA @Logs_015 @Logs_ExtendOrBridge
  Scenario: Logs verification when Producer clicks Cancel Request and then Fulfiller clicks Confirm Cancel Request on newly created CNBC Request
  	And user clicks on forms link
  	And user selects "Extend or Bridge Crew & Facilities" form
  	And user selects Division on Extend or Bridge Crew & Facilities production request
  		|Division  |
  		|CNBC      |
  	When user selects Details and Notes on Extend or Bridge Crew & Facilities production request
    	| Details and Notes |
    	| this is comments  |
    When user selects fields in SHOW INFO section on Extend or Bridge Crew & Facilities production request
     	|Request For  |Air Platform|Show Unit or Project Name|Days from today|Start Time|End Time|
     	|Extend       |OTT         |ACCESS HOLLYWOOD         |2              |12:00 PM  |3:00 PM |
    When user selects fields in Set Location & Crew section on Extend or Bridge Crew & Facilities production request
  		| Location  |Set Location |
  		| DC      	|N-7          |
  	When user selects fields in Control Room & Crew section on Extend or Bridge Crew & Facilities production request
    	|Control Room & Crew|Control Room Location  | Control Room |
    	| Yes               |Rock Center            | CR 71        |
    And user selects `Is a TPM or TM Needed?` on Extend or Bridge Crew & Facilities production request
  		| Choice |
  		| Yes     |
    And  user clicks Submit button on request
  	Then user sees modal for successful "Extend or Bridge Crew & Facilities" request creation
  	And  user clicks on "ok" button
  	When user opens the created request
		Then user clicks Cancel Request button on request
		When user opens the created request
		Then user verifies all Logs on request
		Then user logs out from application
  	Given user opens producer dashboard application
    And user logins with "fulfiller" role
    When user opens the created request
    Then user clicks Confirm Cancellation button on request
    When user opens the created request
		Then user verifies all Logs on request
		
		@NcxUnifiedToolPhase2 @PSEQA @Logs_016 @Logs_ExtendOrBridge
  Scenario: Logs verification when Fulfiller clicks Cancel Request on newly created CNBC Request
  	And user clicks on forms link
  	And user selects "Extend or Bridge Crew & Facilities" form
  	And user selects Division on Extend or Bridge Crew & Facilities production request
  		|Division  |
  		|CNBC      |
  	When user selects Details and Notes on Extend or Bridge Crew & Facilities production request
    	| Details and Notes |
    	| this is comments  |
    When user selects fields in SHOW INFO section on Extend or Bridge Crew & Facilities production request
     	|Request For  |Air Platform|Show Unit or Project Name|Days from today|Start Time|End Time|
     	|Extend       |OTT         |ACCESS HOLLYWOOD         |2              |12:00 PM  |3:00 PM |
    When user selects fields in Set Location & Crew section on Extend or Bridge Crew & Facilities production request
  		| Location  |Set Location |
  		| DC      	|N-7          |
  	When user selects fields in Control Room & Crew section on Extend or Bridge Crew & Facilities production request
    	|Control Room & Crew|Control Room Location  | Control Room |
    	| Yes               |Rock Center            | CR 71        |
    And user selects `Is a TPM or TM Needed?` on Extend or Bridge Crew & Facilities production request
  		| Choice |
  		| Yes     |
    And  user clicks Submit button on request
  	Then user sees modal for successful "Extend or Bridge Crew & Facilities" request creation
  	And  user clicks on "ok" button
		Then user logs out from application
  	Given user opens producer dashboard application
    And user logins with "fulfiller" role
    When user opens the created request
    Then user clicks Cancel Request button on request
    When user opens the created request
		Then user verifies all Logs on request
		
		@NcxUnifiedToolPhase2 @PSEQA @Logs_017 @Logs_ExtendOrBridge
  Scenario: Logs verification for Details, TPM/TM, Talent and Requesters section changes on Extend or Bridge Production request 
  	And user clicks on forms link
  	And user selects "Extend or Bridge Crew & Facilities" form
  	And user selects Division on Extend or Bridge Crew & Facilities production request
  		|Division  |
  		|CNBC      |
  	When user selects Details and Notes on Extend or Bridge Crew & Facilities production request
    	| Details and Notes |
    	| this is comments  |
    When user selects fields in SHOW INFO section on Extend or Bridge Crew & Facilities production request
     	|Request For  |Air Platform|Show Unit or Project Name|Days from today|Start Time|End Time|
     	|Extend       |OTT         |ACCESS HOLLYWOOD         |2              |12:00 PM  |3:00 PM |
    When user selects fields in Set Location & Crew section on Extend or Bridge Crew & Facilities production request
  		| Location  |Set Location |
  		| DC      	|N-7          |
  	When user selects fields in Control Room & Crew section on Extend or Bridge Crew & Facilities production request
    	|Control Room & Crew|Control Room Location  | Control Room |
    	| Yes               |Rock Center            | CR 71        |
    And user selects `Is a TPM or TM Needed?` on Extend or Bridge Crew & Facilities production request
  		| Choice |
  		| Yes     |
    And  user clicks Submit button on request
  	Then user sees modal for successful "Extend or Bridge Crew & Facilities" request creation
  	And  user clicks on "ok" button
  	When user opens the created request
    # validations for logs of Talent section field changes
		When user clicks Edit button on request
	  When user adds requester to the form in edit mode   	
	    |Requester       |
	    |Worker 2, STORM |
	  When user adds requester to the form in edit mode   	
	    |Requester       |
	    |Worker 11, STORM |
	  When user selects Details and Notes on Extend or Bridge Crew & Facilities production request in edit mode
	  	| Details and Notes               |
	  	| editing editing editing         |
	  When user selects `Is a TPM or TM Needed?` on Extend or Bridge Crew & Facilities production request in edit mode
  		| Choice |
  		| No     |
	  When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user clears Details and Notes on Extend or Bridge Crew & Facilities production request in edit mode
  	When user adds specific user in Talent section in edit mode
  	  | Name     |
  	  | Velshi, Ali & Alba, Monica  |
	  When user removes requester to the form in edit mode   	
	    |Requester       |
	    |Worker 2, STORM & Worker 11, STORM |
	  When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	Then user verifies all Logs on request
  	When user clicks Edit button on request
	  When user removes specific user in Talent section in edit mode
	  	| Name     |
	  	| Velshi, Ali & Alba, Monica  |
	  When user selects `Is a TPM or TM Needed?` on Extend or Bridge Crew & Facilities production request in edit mode
  		| Choice |
  		| Yes    |
	  When user selects Details and Notes on Extend or Bridge Crew & Facilities production request in edit mode
	  	| Details and Notes               |
	  	| editing editing editing         |
	  When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	Then user verifies all Logs on request
  	When user clicks Edit button on request
	  When user adds requester to the form in edit mode
	  |Requester       |
	  |Worker 2, STORM |
	  When user adds specific user in Talent section in edit mode
  	  | Name     |
  	  | Velshi, Ali  |   	
	  When user selects TPM/TM Name on Extend or Bridge Crew & Facilities production request in edit mode
	  	| TPM/TM Name|
	  	| User999    |
	  When user removes requester to the form in edit mode   	
	    |Requester       |
	    |Worker 11, STORM |
	  When user clears Details and Notes on Extend or Bridge Crew & Facilities production request in edit mode
	  When user selects Details and Notes on Extend or Bridge Crew & Facilities production request in edit mode
	  	| Details and Notes               |
	  	| editing editing editing 2         |
	  When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	Then user verifies all Logs on request
  	When user clicks Edit button on request
	  When user adds requester to the form in edit mode   	
	    |Requester       |
	    |Worker 11, STORM |
	  When user selects `Is a TPM or TM Needed?` on Extend or Bridge Crew & Facilities production request in edit mode
  		| Choice |
  		| No     |
  	When user adds specific user in Talent section in edit mode
  	  | Name     |
  	  | Alba, Monica  |
  	When user removes specific user in Talent section in edit mode
  		|Name |
  		|Velshi, Ali|
	  When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	Then user verifies all Logs on request
  	When user clicks Edit button on request
	  When user removes requester to the form in edit mode   	
	    |Requester        |
	    |Worker 11, STORM |
	  When user removes requester to the form in edit mode   	
	    |Requester       |
	    |Worker 2, STORM |
	  When user selects `Is a TPM or TM Needed?` on Extend or Bridge Crew & Facilities production request in edit mode
  		| Choice |
  		| Yes    |
  	When user selects TPM/TM Name on Extend or Bridge Crew & Facilities production request in edit mode
	  	| TPM/TM Name|
	  	| User99989  |
	  When user removes specific user in Talent section in edit mode
  		|Name |
  		|Alba, Monica|
	  When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	
  	@NcxUnifiedToolPhase2 @PSEQA @Logs_018 @Logs_SingleCameraLiveShot
  Scenario: Logs verification for Details, Talent and Requesters section changes on Single Camera Live Shot 
  	And user clicks on forms link
  	And user selects "Single Camera Live Shot" form
  	And user selects Division on Single Camera Live Shot request
  		|Division  |
  		|CNBC      |
  	When user provides Details and Notes on Single Camera Live Shot request
    	| Details and Notes |
    	| this is comments  |
    When user selects fields in Show Info section on Single Camera Live Shot request
     	|Air Platform|Show Unit or Project Name|Days from today|Start Time|End Time|Prep Time | Work Order |
     	|OTT         |ACCESS HOLLYWOOD         |2              |1:00 PM  |3:00 PM  |12:00 PM  | W00098     |
    When user selects fields in Set Information section on Single Camera Live Shot request
  		| Set Background  |Staging |
  		| NYC Skyline     |Yes     |
  	When user selects fields in Set Crew section on Single Camera Live Shot request
    	|Capture Manager|Set Crew                    |
    	| Yes           |Makeup Artist, Prompter Op  |
    And  user clicks Submit button on request
  	Then user sees modal for successful "Single Camera Live Shot" request creation
  	And  user clicks on "ok" button
  	When user opens the created request
    # validations for logs of Talent section field changes
		When user clicks Edit button on request
	  When user adds requester to the form in edit mode   	
	    |Requester       |
	    |Worker 2, STORM |
	  When user adds requester to the form in edit mode   	
	    |Requester       |
	    |Worker 11, STORM |
	  When user provides Details and Notes on Single Camera Live Shot request in edit mode
	  	| Details and Notes               |
	  	| editing editing editing         |
	  When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
  	When user clears Details and Notes on Single Camera Live Shot request in edit mode
  	When user adds specific user in Talent section in edit mode
  	  | Name     |
  	  | Velshi, Ali & Alba, Monica  |
	  When user removes requester to the form in edit mode   	
	    |Requester       |
	    |Worker 2, STORM & Worker 11, STORM |
	  When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
	  When user removes specific user in Talent section in edit mode
	  	| Name     |
	  	| Velshi, Ali & Alba, Monica  |
	  When user provides Details and Notes on Single Camera Live Shot request in edit mode
	  	| Details and Notes               |
	  	| editing editing editing         |
	  When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
	  When user adds requester to the form in edit mode
	  |Requester       |
	  |Worker 2, STORM |
	  When user adds specific user in Talent section in edit mode
  	  | Name     |
  	  | Velshi, Ali  |   	
	  When user removes requester to the form in edit mode   	
	    |Requester       |
	    |Worker 11, STORM |
	  When user clears Details and Notes on Single Camera Live Shot request in edit mode
	  When user provides Details and Notes on Single Camera Live Shot request in edit mode
	  	| Details and Notes               |
	  	| editing editing editing 2         |
	  When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
	  When user adds requester to the form in edit mode   	
	    |Requester       |
	    |Worker 11, STORM |
  	When user adds specific user in Talent section in edit mode
  	  | Name     |
  	  | Alba, Monica  |
  	When user removes specific user in Talent section in edit mode
  		|Name |
  		|Velshi, Ali|
	  When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
	  When user removes requester to the form in edit mode   	
	    |Requester        |
	    |Worker 11, STORM |
	  When user removes requester to the form in edit mode   	
	    |Requester       |
	    |Worker 2, STORM |
	  When user removes specific user in Talent section in edit mode
  		|Name |
  		|Alba, Monica|
	  When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	
  	@NcxUnifiedToolPhase2 @PSEQA @Logs_019 @Logs_SingleCameraLiveShot
  Scenario: Logs verification when Fulfiller clicks Cancel Request on newly created Single Camera Live Shot Request
  	And user clicks on forms link
  	And user selects "Single Camera Live Shot" form
  	And user selects Division on Single Camera Live Shot request
  		|Division  |
  		|CNBC      |
  	When user provides Details and Notes on Single Camera Live Shot request
    	| Details and Notes |
    	| this is comments  |
    When user selects fields in Show Info section on Single Camera Live Shot request
     	|Air Platform|Show Unit or Project Name|Days from today|Start Time|End Time|Prep Time | Work Order |
     	|OTT         |ACCESS HOLLYWOOD         |2              |1:00 PM  |3:00 PM  |12:00 PM  | W00098     |
    When user selects fields in Set Information section on Single Camera Live Shot request
  		| Set Background  |Staging |
  		| NYC Skyline     |Yes     |
  	When user selects fields in Set Crew section on Single Camera Live Shot request
    	|Capture Manager|Set Crew                    |
    	| Yes           |Makeup Artist, Prompter Op  |
    And  user clicks Submit button on request
  	Then user sees modal for successful "Single Camera Live Shot" request creation
  	And  user clicks on "ok" button
		Then user logs out from application
  	Given user opens producer dashboard application
    And user logins with "fulfiller" role
    When user opens the created request
    Then user clicks Cancel Request button on request
    When user opens the created request
		Then user verifies all Logs on request
		
		@NcxUnifiedToolPhase2 @PSEQA @Logs_020 @Logs_SingleCameraLiveShot
  Scenario: Logs verification when Producer clicks Cancel Request and then Fulfiller clicks Confirm Cancel Request on newly created Single Camera Live Shot Request
  	And user clicks on forms link
  	And user selects "Single Camera Live Shot" form
  	And user selects Division on Single Camera Live Shot request
  		|Division  |
  		|CNBC      |
  	When user provides Details and Notes on Single Camera Live Shot request
    	| Details and Notes |
    	| this is comments  |
    When user selects fields in Show Info section on Single Camera Live Shot request
     	|Air Platform|Show Unit or Project Name|Days from today|Start Time|End Time|Prep Time | Work Order |
     	|OTT         |ACCESS HOLLYWOOD         |2              |1:00 PM  |3:00 PM  |12:00 PM  | W00098     |
    When user selects fields in Set Information section on Single Camera Live Shot request
  		| Set Background  |Staging |
  		| NYC Skyline     |Yes     |
  	When user selects fields in Set Crew section on Single Camera Live Shot request
    	|Capture Manager|Set Crew                    |
    	| Yes           |Makeup Artist, Prompter Op  |
    And  user clicks Submit button on request
  	Then user sees modal for successful "Single Camera Live Shot" request creation
  	And  user clicks on "ok" button
  	When user opens the created request
		Then user clicks Cancel Request button on request
		When user opens the created request
		Then user verifies all Logs on request
		Then user logs out from application
  	Given user opens producer dashboard application
    And user logins with "fulfiller" role
    When user opens the created request
    Then user clicks Confirm Cancellation button on request
    When user opens the created request
		Then user verifies all Logs on request
		
		@NcxUnifiedToolPhase2 @PSEQA @Logs_021 @Logs_SingleCameraLiveShot
  Scenario: Logs verification when Requester and Fulfiller adds, edits or deletes notes on Single Camera Live Shot Request
  	And user clicks on forms link
  	And user selects "Single Camera Live Shot" form
  	And user selects Division on Single Camera Live Shot request
  		|Division  |
  		|CNBC      |
  	When user provides Details and Notes on Single Camera Live Shot request
    	| Details and Notes |
    	| this is comments  |
    When user selects fields in Show Info section on Single Camera Live Shot request
     	|Air Platform|Show Unit or Project Name|Days from today|Start Time|End Time|Prep Time | Work Order |
     	|OTT         |ACCESS HOLLYWOOD         |2              |1:00 PM  |3:00 PM  |12:00 PM  | W00098     |
    When user selects fields in Set Information section on Single Camera Live Shot request
  		| Set Background  |Staging |
  		| NYC Skyline     |Yes     |
  	When user selects fields in Set Crew section on Single Camera Live Shot request
    	|Capture Manager|Set Crew                    |
    	| Yes           |Makeup Artist, Prompter Op  |
    And  user clicks Submit button on request
  	Then user sees modal for successful "Single Camera Live Shot" request creation
  	And  user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
  	When user switches to `Notes` tab in right container on Request
  	Then user adds 11 notes on request
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  #	When user opens the created request
  	# Then user verifies all Logs on request
  	Then user logs out from application
  	Given user opens producer dashboard application
    And user logins with "fulfiller" role
    When user opens the created request
		When user clicks Edit button on request
		When user switches to `Notes` tab in right container on Request
  	Then user adds 11 notes on request
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  #	When user opens the created request
  	# Then user verifies all Logs on request
  	Then user logs out from application
  	Given user opens producer dashboard application
    And user logins with "producer" role
    When user opens the created request
		When user clicks Edit button on request
		When user switches to `Notes` tab in right container on Request
  	Then user edits notes on request randomly
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
		When user switches to `Notes` tab in right container on Request
  	Then user deletes notes on request randomly
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  #	When user opens the created request
  	# Then user verifies all Logs on request
  	Then user logs out from application
  	Given user opens producer dashboard application
    And user logins with "fulfiller" role
    When user opens the created request
		When user clicks Edit button on request
		When user switches to `Notes` tab in right container on Request
  	Then user edits notes on request randomly
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
		When user switches to `Notes` tab in right container on Request
  	Then user deletes notes on request randomly
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	
  	@NcxUnifiedToolPhase2 @PSEQA @Logs_022 @Logs_SingleCameraLiveShot
  Scenario: Logs verification for Set Crew section on Single Camera Live Shot
		And user clicks on forms link
  	And user selects "Single Camera Live Shot" form
  	And user selects Division on Single Camera Live Shot request
  		|Division  |
  		|CNBC      |
  	When user provides Details and Notes on Single Camera Live Shot request
    	| Details and Notes |
    	| this is comments  |
    When user selects fields in Show Info section on Single Camera Live Shot request
     	|Air Platform|Show Unit or Project Name|Days from today|Start Time|End Time|Prep Time | Work Order |
     	|OTT         |ACCESS HOLLYWOOD         |2              |1:00 PM  |3:00 PM  |12:00 PM  | W00098     |
    When user selects fields in Set Information section on Single Camera Live Shot request
  		| Set Background  |Staging |
  		| NYC Skyline     |Yes     |
  	When user selects fields in Set Crew section on Single Camera Live Shot request
    	|Capture Manager|Set Crew                    |
    	| Yes           |Makeup Artist, Prompter Op  |
    And  user clicks Submit button on request
  	Then user sees modal for successful "Single Camera Live Shot" request creation
  	And  user clicks on "ok" button
		When user opens the created request
		When user clicks Edit button on request
		When user removes all Set Crew on Single Camera Live Shot request in edit mode
		When user selects fields in Set Crew section on Single Camera Live Shot request in edit mode
  		|Capture Manager |Set Crew                          |
  		|No              |Hair Stylist, Plaza Productions Op|
		When user changes quantities of Set Crew on Single Camera Live Shot request in edit mode
		|NamesWithQuantities                                                   |
		|Hair Stylist=3, Prompter Op=2, Makeup Artist=1, Plaza Productions Op=4|
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
  	When user selects fields in Set Crew section on Single Camera Live Shot request in edit mode
    	|Capture Manager|
    	| Yes           |
		When user removes specific crews on Single Camera Live Shot request in edit mode
		|Crews                                                          |
		| Hair Stylist, Prompter Op, Makeup Artist, Plaza Productions Op|
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
  	When user selects fields in Set Crew section on Single Camera Live Shot request in edit mode
    	|Capture Manager| Set Crew                                                          |
    	| Yes           | Hair Stylist, Prompter Op, Makeup Artist, Plaza Productions Op|
		When user changes quantities of Set Crew on Single Camera Live Shot request in edit mode
		|NamesWithQuantities                                                   |
		|Hair Stylist=4, Prompter Op=2, Makeup Artist=2, Plaza Productions Op=1|
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
  	When user selects fields in Set Crew section on Single Camera Live Shot request in edit mode
    	|Capture Manager|
    	| No           |
		When user removes all Set Crew on Single Camera Live Shot request in edit mode
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
  	When user selects fields in Set Crew section on Single Camera Live Shot request in edit mode
    	|Capture Manager| Set Crew                                                          |
    	| Yes           | Hair Stylist, Prompter Op, Makeup Artist, Plaza Productions Op|
		When user changes quantities of Set Crew on Single Camera Live Shot request in edit mode
		|NamesWithQuantities                                                   |
		|Hair Stylist=3, Prompter Op=2, Makeup Artist=4, Plaza Productions Op=4|
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	
  	@NcxUnifiedToolPhase2 @PSEQA @Logs_023 @Logs_SingleCameraLiveShot
  Scenario: Logs verification for Set Information section on Single Camera Live Shot request
  	And user clicks on forms link
  	And user selects "Single Camera Live Shot" form
  	And user selects Division on Single Camera Live Shot request
  		|Division  |
  		|CNBC      |
  	When user provides Details and Notes on Single Camera Live Shot request
    	| Details and Notes |
    	| this is comments  |
    When user selects fields in Show Info section on Single Camera Live Shot request
     	|Air Platform|Show Unit or Project Name|Days from today|Start Time|End Time|Prep Time | Work Order |
     	|OTT         |ACCESS HOLLYWOOD         |2              |1:00 PM  |3:00 PM  |12:00 PM  | W00098     |
    When user selects fields in Set Information section on Single Camera Live Shot request
  		| Set Background  |Staging |
  		| NYC Skyline     |Yes     |
  	When user selects fields in Set Crew section on Single Camera Live Shot request
    	|Capture Manager|Set Crew                    |
    	| Yes           |Makeup Artist, Prompter Op  |
    And  user clicks Submit button on request
  	Then user sees modal for successful "Single Camera Live Shot" request creation
  	And  user clicks on "ok" button
		When user opens the created request
		When user clicks Edit button on request
    When user selects fields in Set Information section on Single Camera Live Shot request in edit mode
  		| Set Background  |Staging |
  		| Greenscreen     |No     |
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
    When user selects fields in Set Information section on Single Camera Live Shot request in edit mode
  		| Set Background      |Staging |
  		| Providing Graphic  |No     |
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
    When user selects fields in Set Information section on Single Camera Live Shot request in edit mode
  		| Set Background       |Staging |
  		| Generic Newsroom     |Yes     |
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
    When user selects fields in Set Information section on Single Camera Live Shot request in edit mode
  		| Set Background       |Staging |
  		| Generic Newsroom     |Yes     |
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
    When user selects fields in Set Information section on Single Camera Live Shot request in edit mode
  		| Set Background       |Staging |
  		| Providing Graphic   |Yes     |
    When user selects fields in Set Information section on Single Camera Live Shot request in edit mode
  		| Set Background       |Staging |
  		| Greenscreen          |No     |
    	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	
  	@NcxUnifiedToolPhase2 @PSEQA @Logs_024 @Logs_SingleCameraLiveShot
  Scenario: Logs verification for Show Info section on Single Camera Live Shot request
  	And user clicks on forms link
  	And user selects "Single Camera Live Shot" form
  	And user selects Division on Single Camera Live Shot request
  		|Division  |
  		|CNBC      |
  	When user provides Details and Notes on Single Camera Live Shot request
    	| Details and Notes |
    	| this is comments  |
    When user selects fields in Show Info section on Single Camera Live Shot request
     	|Air Platform|Show Unit or Project Name|Days from today|Start Time|End Time|Prep Time | Work Order |
     	|OTT         |ACCESS HOLLYWOOD         |2              |1:00 PM  |3:00 PM  |12:00 PM  | W00098     |
    When user selects fields in Set Information section on Single Camera Live Shot request
  		| Set Background  |Staging |
  		| NYC Skyline     |Yes     |
  	When user selects fields in Set Crew section on Single Camera Live Shot request
    	|Capture Manager|Set Crew                    |
    	| Yes           |Makeup Artist, Prompter Op  |
    And  user clicks Submit button on request
  	Then user sees modal for successful "Single Camera Live Shot" request creation
  	And  user clicks on "ok" button
		When user opens the created request
		When user clicks Edit button on request
		When user clears End Time on Single Camera Live Shot request
		When user clears Start Time on Single Camera Live Shot request
		When user clears Start Date on Single Camera Live Shot request
		When user clears Prep Time on Single Camera Live Shot request in edit mode
		When user selects fields in Show Info section on Single Camera Live Shot request in edit mode
     	|Air Platform|Show Unit or Project Name|Days from today|Start Time|End Time|Prep Time | Work Order |
     	|OTT         |ACCESS HOLLYWOOD         |2              |2:00 PM  |4:00 PM  |1:00 PM  | W00099     |
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
  		When user clears End Time on Single Camera Live Shot request
		When user clears Start Time on Single Camera Live Shot request
		When user clears Start Date on Single Camera Live Shot request
		When user selects fields in Show Info section on Single Camera Live Shot request in edit mode
     	|Air Platform|Show Unit or Project Name|Days from today|Start Time|End Time|
     	|Multiple    |7S Tour Studio           |4              |3:00 PM   |6:00 PM |
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
  		When user clears End Time on Single Camera Live Shot request
		When user clears Start Time on Single Camera Live Shot request
		When user clears Start Date on Single Camera Live Shot request
		When user clears Prep Time on Single Camera Live Shot request in edit mode
  	When user selects fields in SHOW INFO section on Extend or Bridge Crew & Facilities production request in edit mode
     	|Air Platform|Show Unit or Project Name|Days from today|Start Time|End Time|
     	|Multiple    |Alex Wagner Tonight      |15             |5:00 PM   |9:00 PM |	
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
  		When user clears End Time on Single Camera Live Shot request
		When user clears Start Time on Single Camera Live Shot request
		When user clears Start Date on Single Camera Live Shot request
		When user selects fields in SHOW INFO section on Extend or Bridge Crew & Facilities production request in edit mode
     	|Air Platform|Show Unit or Project Name|Days from today|Start Time|End Time|Prep Time|Work Order   |  Other                        |Budget Code |
     	|Multiple    |OTHER                    |15             |12:00 PM  |2:00 PM |4:00 PM  |W00098       |  This is data for other field |autOMATION  |
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	
  	@NcxUnifiedToolPhase2 @PSEQA @Logs_025 @Logs_SingleCameraLiveShot
  Scenario: Logs verification when Fulfiller selects and unselects different fulfillment status on Single Camera Live Shot Production request
  	And user clicks on forms link
  	And user selects "Single Camera Live Shot" form
  	And user selects Division on Single Camera Live Shot request
  		|Division  |
  		|CNBC      |
  	When user provides Details and Notes on Single Camera Live Shot request
    	| Details and Notes |
    	| this is comments  |
    When user selects fields in Show Info section on Single Camera Live Shot request
     	|Air Platform|Show Unit or Project Name|Days from today|Start Time|End Time|Prep Time | Work Order |
     	|OTT         |ACCESS HOLLYWOOD         |2              |1:00 PM  |3:00 PM  |12:00 PM  | W00098     |
    When user selects fields in Set Information section on Single Camera Live Shot request
  		| Set Background  |Staging |
  		| NYC Skyline     |Yes     |
  	When user selects fields in Set Crew section on Single Camera Live Shot request
    	|Capture Manager|Set Crew                    |
    	| Yes           |Makeup Artist, Prompter Op  |
    And  user clicks Submit button on request
  	Then user sees modal for successful "Single Camera Live Shot" request creation
  	And  user clicks on "ok" button
  	Then user logs out from application
  	Given user opens producer dashboard application
    And user logins with "fulfiller" role
    When user opens the created request
		When user clicks Edit button on request
		Then user completes below status in fulfillment on Single Camera Live Shot Request
			|Status                                                     |
			|Acknowledged ; Technical ; Staging ; Hair, Makeup & Wardrobe  |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	Then user clears below status in fulfillment on Single Camera Live Shot Request
			|Status                                   |
			|Staging ; Technical ; Hair, Makeup & Wardrobe |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	Then user verifies all Logs on request
  	When user clicks Edit button on request
		Then user completes below status in fulfillment on Single Camera Live Shot Request
			|Status                                   |
			|Staging ; Technical ; Hair, Makeup & Wardrobe |
  	Then user clears below status in fulfillment on Single Camera Live Shot Request
			|Status                                   |
			|Staging ; Technical |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	Then user verifies all Logs on request
  	When user clicks Edit button on request
		Then user completes below status in fulfillment on Single Camera Live Shot Request
			|Status                                   |
			|Staging ; Technical |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	Then user clears below status in fulfillment on Single Camera Live Shot Request
			|Status                                   |
			|Staging ; Technical ; Hair, Makeup & Wardrobe |
		Then user completes below status in fulfillment on Single Camera Live Shot Request
			|Status                                   |
			|Staging ; Technical ; Hair, Makeup & Wardrobe |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	
  	@NcxUnifiedToolPhase2 @PSEQA @Logs_026 @Logs_SingleCameraLiveShot
  Scenario: Logs verification when Fulfiller selects and unselects different fulfillment status on Single Camera Live Shot Production request
  	And user clicks on forms link
  	And user selects "Single Camera Live Shot" form
  	And user selects Division on Single Camera Live Shot request
  		|Division  |
  		|CNBC      |
  	When user provides Details and Notes on Single Camera Live Shot request
    	| Details and Notes |
    	| this is comments  |
    When user selects fields in Show Info section on Single Camera Live Shot request
     	|Air Platform|Show Unit or Project Name|Days from today|Start Time|End Time|Prep Time | Work Order |
     	|OTT         |ACCESS HOLLYWOOD         |2              |1:00 PM  |3:00 PM  |12:00 PM  | W00098     |
    When user selects fields in Set Information section on Single Camera Live Shot request
  		| Set Background  |Staging |
  		| NYC Skyline     |Yes     |
  	When user selects fields in Set Crew section on Single Camera Live Shot request
    	|Capture Manager|Set Crew                    |
    	| Yes           |Hair Stylist, Prompter Op  |
    And  user clicks Submit button on request
  	Then user sees modal for successful "Single Camera Live Shot" request creation
  	And  user clicks on "ok" button
  	Then user logs out from application
  	Given user opens producer dashboard application
    And user logins with "fulfiller" role
    When user opens the created request
		When user clicks Edit button on request
		Then user completes below status in fulfillment on Single Camera Live Shot Request
			|Status                                                     |
			|Acknowledged ; Technical ; Staging ; Hair, Makeup & Wardrobe  |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	Then user clears below status in fulfillment on Single Camera Live Shot Request
			|Status                                   |
			|Staging ; Technical ; Hair, Makeup & Wardrobe |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	Then user verifies all Logs on request
  	When user clicks Edit button on request
		Then user completes below status in fulfillment on Single Camera Live Shot Request
			|Status                                   |
			|Staging ; Technical ; Hair, Makeup & Wardrobe |
  	Then user clears below status in fulfillment on Single Camera Live Shot Request
			|Status                                   |
			|Staging ; Technical |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	Then user verifies all Logs on request
  	When user clicks Edit button on request
		Then user completes below status in fulfillment on Single Camera Live Shot Request
			|Status                                   |
			|Staging ; Technical |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	Then user clears below status in fulfillment on Single Camera Live Shot Request
			|Status                                   |
			|Staging ; Technical ; Hair, Makeup & Wardrobe |
		Then user completes below status in fulfillment on Single Camera Live Shot Request
			|Status                                   |
			|Staging ; Technical ; Hair, Makeup & Wardrobe |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	
  	@NcxUnifiedToolPhase2 @PSEQA @Logs_027 @Logs_SingleCameraLiveShot
  Scenario: Logs verification when Fulfiller increases, decreases quantities, update names of crew resources and delete whole crew sections on CREW tab of fulfillment in Single Camera Live Shot Request  
  	And user clicks on forms link
  	And user selects "Single Camera Live Shot" form
  	And user selects Division on Single Camera Live Shot request
  		|Division  |
  		|CNBC      |
  	When user provides Details and Notes on Single Camera Live Shot request
    	| Details and Notes |
    	| this is comments  |
    When user selects fields in Show Info section on Single Camera Live Shot request
     	|Air Platform|Show Unit or Project Name|Days from today|Start Time|End Time|Prep Time | Work Order |
     	|OTT         |ACCESS HOLLYWOOD         |2              |1:00 PM  |3:00 PM  |12:00 PM  | W00098     |
    When user selects fields in Set Information section on Single Camera Live Shot request
  		| Set Background  |Staging |
  		| NYC Skyline     |Yes     |
  	When user selects fields in Set Crew section on Single Camera Live Shot request
    	|Capture Manager|Set Crew                                                        |
    	| Yes           |Makeup Artist, Prompter Op, Hair Stylist, Plaza Productions Op  |
    When user changes quantities of Set Crew on Single Camera Live Shot request
    	| NamesWithQuantities |
    	| Makeup Artist=3, Prompter Op=2, Hair Stylist=4, Plaza Productions Op=4  |
    And  user clicks Submit button on request
  	Then user sees modal for successful "Single Camera Live Shot" request creation
  	And  user clicks on "ok" button
  	Then user logs out from application
  	Given user opens producer dashboard application
    And user logins with "fulfiller" role
    When user opens the created request
		When user clicks Edit button on request
		When user switches to `Crew` tab in Fulfillment
		Then user modifies the Set Crew Member quantities in fulfillment on Single Camera Live Shot
		Then user provides the Set Crew Member names in fulfillment on Single Camera Live Shot
		Then user deletes Set Crew Member names in fulfillment randomly on Single Camera Live Shot
		Then user deletes Set Crew names in fulfillment on Single Camera Live Shot
  		| Set Crew          |
  		| Prompter Op       |
		When user clicks Save button on request
		Then user clicks on "ok" button
		When user opens the created request
		# Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user switches to `Crew` tab in Fulfillment
  	Then user modifies the Set Crew Member quantities in fulfillment on Single Camera Live Shot
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	# Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user switches to `Crew` tab in Fulfillment
  	Then user provides the Set Crew Member names in fulfillment on Single Camera Live Shot
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	# Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user switches to `Crew` tab in Fulfillment
  	Then user deletes Set Crew Member names in fulfillment randomly on Single Camera Live Shot
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	# Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user switches to `Crew` tab in Fulfillment
		Then user deletes Set Crew names in fulfillment on Single Camera Live Shot
  		| Set Crew          |
  		| Hair Stylist, Makeup Artist,Plaza Productions Op    |
	  When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	
  	@NcxUnifiedToolPhase2 @PSEQA @Logs_028 @Logs_Rockcenter @EmaiA
  Scenario: Logs verification for Production Purpose, Talent and Requesters section changes on Rockcenter request
  	And user clicks on forms link
  	And user selects "Rock Center" form
  	And user selects Division on Rockcenter request
  		|Division  |
  		|CNBC      |
  	When user selects fields in Production Purpose section on Rockcenter request
    	| Details & Notes   |Request For      |
    	| this is comments  |Special Coverage |
    	When user selects fields in Show Info section on Rockcenter request
     	|Air Platform|Show Unit or Project Name|Days from today|Start Time|End Time|Prep Time | Work Order |
     	|OTT         |ACCESS HOLLYWOOD         |2              |1:00 PM   |3:00 PM  |12:00 PM | W00098     |
    	When user clicks `+ Location` button on Rockcenter request
    	When user selects fields in Set Location section on Rockcenter request
  		| Location Number  |Location        |Set Location |
  		| 0                |Rock Center     |3A Studio    |
  		When user selects fields in Set Location section on Rockcenter request
  		| Location Number  |Location        |Set Location |
  		| 1                |Rock Center     |3B Studio    |
  	When user selects fields in Control Room Crew section on Rockcenter request
    	|Capture Manager|Control Room Crew                |
    	| Yes           |Technical Director, Playback AD  |
		When user selects fields in Set Crew section on Rockcenter request
			|Set Crew                   |
			|Prod A2, Stage Manager     |
    When user clicks `+ Control Room` button on Rockcenter request
		When user selects fields in Control Room section on Rockcenter request
  		| Location Number  |Control Room Location |Control Room |
  		| 0                |Rock Center           |CR 33        |
  	When user selects fields in Control Room section on Rockcenter request
  		| Location Number  |Control Room Location |Control Room |
  		| 1                |DC              |Wash Control |
		When user selects fields in Set Crew section on Rockcenter request
			|Additional Crew                   |
			|Lighting Director, Prompter Op    |
		When user selects fields in Systems section on Rockcenter request
			|Ultimatte    |Voice Activated Prompter|System Notes           |
			|3            |1                       |These are system notes |
		When user selects fields in Staging section on Rockcenter request
			|Is Staging Needed |Is Lighting Needed  |Is Carpentry Needed|Are Props Needed|Describe Staging Needs |
			|Yes               |No                  | Yes               |Yes             |These are staging Needs|
		When user selects fields in TPM/TM Information section on Rockcenter request
			|Is a TPM or TM Needed   |
			|Yes                     |
		And user clicks Submit button on request
  	Then user sees modal for successful "Rock Center" request creation
  	And  user clicks on "ok" button
		When user opens the created request
    # validations for logs of Talent section field changes
		When user clicks Edit button on request
	  When user adds requester to the form in edit mode   	
	    |Requester       |
	    |Worker 2, STORM |
	  When user adds requester to the form in edit mode   	
	    |Requester       |
	    |Worker 11, STORM |
  	When user selects fields in Production Purpose section on Rockcenter request in edit mode
    	| Details & Notes           |
    	| this is comments - edited |
	  When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
  	When user clears Details & Notes on Rockcenter request in edit mode
  	When user adds specific user in Talent section in edit mode
  	  | Name     |
  	  | Velshi, Ali & Alba, Monica  |
	  When user removes requester to the form in edit mode   	
	    |Requester       |
	    |Worker 2, STORM & Worker 11, STORM |
	  When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
	  When user removes specific user in Talent section in edit mode
	  	| Name     |
	  	| Velshi, Ali & Alba, Monica  |
  	When user selects fields in Production Purpose section on Rockcenter request in edit mode
			|Request For      |
    	|Internal Event   |
	  When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
	  When user adds requester to the form in edit mode
	  |Requester       |
	  |Worker 2, STORM |
	  When user adds specific user in Talent section in edit mode
  	  | Name     |
  	  | Velshi, Ali  |   	
	  When user removes requester to the form in edit mode   	
	    |Requester       |
	    |Worker 11, STORM |
	  When user clears Details & Notes on Rockcenter request in edit mode
  	When user selects fields in Production Purpose section on Rockcenter request
    	| Details & Notes                 |Request For                             |
    	| this is comments edited edited2 |Additional Crew for Existing Production |
	  When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
	  When user adds requester to the form in edit mode   	
	    |Requester       |
	    |Worker 11, STORM |
  	When user adds specific user in Talent section in edit mode
  	  | Name     |
  	  | Alba, Monica  |
  	When user removes specific user in Talent section in edit mode
  		|Name |
  		|Velshi, Ali|
	  When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
	  When user removes requester to the form in edit mode   	
	    |Requester        |
	    |Worker 11, STORM |
	  When user removes requester to the form in edit mode   	
	    |Requester       |
	    |Worker 2, STORM |
	  When user removes specific user in Talent section in edit mode
  		|Name |
  		|Alba, Monica|
	  When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	
  @NcxUnifiedToolPhase2 @PSEQA @Logs_029 @Logs_Rockcenter
	Scenario: Logs verification when Fulfiller clicks Cancel Request on newly created Rockcenter Request
  	And user clicks on forms link
  	And user selects "Rock Center" form
  	And user selects Division on Rockcenter request
  		|Division  |
  		|CNBC      |
  	When user selects fields in Production Purpose section on Rockcenter request
    	| Details & Notes   |Request For      |
    	| this is comments  |Special Coverage |
    	When user selects fields in Show Info section on Rockcenter request
     	|Air Platform|Show Unit or Project Name|Days from today|Start Time|End Time|Prep Time | Work Order |
     	|OTT         |ACCESS HOLLYWOOD         |2              |1:00 PM   |3:00 PM  |12:00 PM | W00098     |
    	When user clicks `+ Location` button on Rockcenter request
    	When user selects fields in Set Location section on Rockcenter request
  		| Location Number  |Location        |Set Location |
  		| 0                |Rock Center     |3A Studio    |
  		When user selects fields in Set Location section on Rockcenter request
  		| Location Number  |Location        |Set Location |
  		| 1                |Rock Center     |3B Studio    |
  	When user selects fields in Control Room Crew section on Rockcenter request
    	|Capture Manager|Control Room Crew                |
    	| Yes           |Technical Director, Playback AD  |
		When user selects fields in Set Crew section on Rockcenter request
			|Set Crew                   |
			|Prod A2, Stage Manager     |
    When user clicks `+ Control Room` button on Rockcenter request
		When user selects fields in Control Room section on Rockcenter request
  		| Location Number  |Control Room Location |Control Room |
  		| 0                |Rock Center           |CR 33        |
  	When user selects fields in Control Room section on Rockcenter request
  		| Location Number  |Control Room Location |Control Room |
  		| 1                |DC              |Wash Control |
		When user selects fields in Set Crew section on Rockcenter request
			|Additional Crew                   |
			|Lighting Director, Prompter Op    |
		When user selects fields in Systems section on Rockcenter request
			|Ultimatte    |Voice Activated Prompter|System Notes           |
			|3            |1                       |These are system notes |
		When user selects fields in Staging section on Rockcenter request
			|Is Staging Needed |Is Lighting Needed  |Is Carpentry Needed|Are Props Needed|Describe Staging Needs |
			|Yes               |No                  | Yes               |Yes             |These are staging Needs|
		When user selects fields in TPM/TM Information section on Rockcenter request
			|Is a TPM or TM Needed   |
			|Yes                     |
		And user clicks Submit button on request
  	Then user sees modal for successful "Rock Center" request creation
  	And  user clicks on "ok" button
		Then user logs out from application
  	Given user opens producer dashboard application
    And user logins with "fulfiller" role
    When user opens the created request
    Then user clicks Cancel Request button on request
    When user opens the created request
		Then user verifies all Logs on request
		
		@NcxUnifiedToolPhase2 @PSEQA @Logs_030 @Logs_Rockcenter
  Scenario: Logs verification when Producer clicks Cancel Request and then Fulfiller clicks Confirm Cancel Request on newly created Rockcenter Request
  	And user clicks on forms link
  	And user selects "Rock Center" form
  	And user selects Division on Rockcenter request
  		|Division  |
  		|CNBC      |
  	When user selects fields in Production Purpose section on Rockcenter request
    	| Details & Notes   |Request For      |
    	| this is comments  |Special Coverage |
    	When user selects fields in Show Info section on Rockcenter request
     	|Air Platform|Show Unit or Project Name|Days from today|Start Time|End Time|Prep Time | Work Order |
     	|OTT         |ACCESS HOLLYWOOD         |2              |1:00 PM   |3:00 PM  |12:00 PM | W00098     |
    	When user clicks `+ Location` button on Rockcenter request
    	When user selects fields in Set Location section on Rockcenter request
  		| Location Number  |Location        |Set Location |
  		| 0                |Rock Center     |3A Studio    |
  		When user selects fields in Set Location section on Rockcenter request
  		| Location Number  |Location        |Set Location |
  		| 1                |Rock Center     |3B Studio    |
  	When user selects fields in Control Room Crew section on Rockcenter request
    	|Capture Manager|Control Room Crew                |
    	| Yes           |Technical Director, Playback AD  |
		When user selects fields in Set Crew section on Rockcenter request
			|Set Crew                   |
			|Prod A2, Stage Manager     |
    When user clicks `+ Control Room` button on Rockcenter request
		When user selects fields in Control Room section on Rockcenter request
  		| Location Number  |Control Room Location |Control Room |
  		| 0                |Rock Center           |CR 33        |
  	When user selects fields in Control Room section on Rockcenter request
  		| Location Number  |Control Room Location |Control Room |
  		| 1                |DC              |Wash Control |
		When user selects fields in Set Crew section on Rockcenter request
			|Additional Crew                   |
			|Lighting Director, Prompter Op    |
		When user selects fields in Systems section on Rockcenter request
			|Ultimatte    |Voice Activated Prompter|System Notes           |
			|3            |1                       |These are system notes |
		When user selects fields in Staging section on Rockcenter request
			|Is Staging Needed |Is Lighting Needed  |Is Carpentry Needed|Are Props Needed|Describe Staging Needs |
			|Yes               |No                  | Yes               |Yes             |These are staging Needs|
		When user selects fields in TPM/TM Information section on Rockcenter request
			|Is a TPM or TM Needed   |
			|Yes                     |
		And user clicks Submit button on request
  	Then user sees modal for successful "Rock Center" request creation
  	And  user clicks on "ok" button
  	When user opens the created request
		Then user clicks Cancel Request button on request
		When user opens the created request
		Then user verifies all Logs on request
		Then user logs out from application
  	Given user opens producer dashboard application
    And user logins with "fulfiller" role
    When user opens the created request
    Then user clicks Confirm Cancellation button on request
    When user opens the created request
		Then user verifies all Logs on request
		
		@NcxUnifiedToolPhase2 @PSEQA @Logs_031 @Logs_Rockcenter
  Scenario: Logs verification when Requester and Fulfiller adds, edits or deletes notes on Rockcenter Request
  	And user clicks on forms link
  	And user selects "Rock Center" form
  	And user selects Division on Rockcenter request
  		|Division  |
  		|CNBC      |
  	When user selects fields in Production Purpose section on Rockcenter request
    	| Details & Notes   |Request For      |
    	| this is comments  |Special Coverage |
    	When user selects fields in Show Info section on Rockcenter request
     	|Air Platform|Show Unit or Project Name|Days from today|Start Time|End Time|Prep Time | Work Order |
     	|OTT         |ACCESS HOLLYWOOD         |2              |1:00 PM   |3:00 PM  |12:00 PM | W00098     |
    	When user clicks `+ Location` button on Rockcenter request
    	When user selects fields in Set Location section on Rockcenter request
  		| Location Number  |Location        |Set Location |
  		| 0                |Rock Center     |3A Studio    |
  		When user selects fields in Set Location section on Rockcenter request
  		| Location Number  |Location        |Set Location |
  		| 1                |Rock Center     |3B Studio    |
  	When user selects fields in Control Room Crew section on Rockcenter request
    	|Capture Manager|Control Room Crew                |
    	| Yes           |Technical Director, Playback AD  |
		When user selects fields in Set Crew section on Rockcenter request
			|Set Crew                   |
			|Prod A2, Stage Manager     |
    When user clicks `+ Control Room` button on Rockcenter request
		When user selects fields in Control Room section on Rockcenter request
  		| Location Number  |Control Room Location |Control Room |
  		| 0                |Rock Center           |CR 33        |
  	When user selects fields in Control Room section on Rockcenter request
  		| Location Number  |Control Room Location |Control Room |
  		| 1                |DC              |Wash Control |
		When user selects fields in Set Crew section on Rockcenter request
			|Additional Crew                   |
			|Lighting Director, Prompter Op    |
		When user selects fields in Systems section on Rockcenter request
			|Ultimatte    |Voice Activated Prompter|System Notes           |
			|3            |1                       |These are system notes |
		When user selects fields in Staging section on Rockcenter request
			|Is Staging Needed |Is Lighting Needed  |Is Carpentry Needed|Are Props Needed|Describe Staging Needs |
			|Yes               |No                  | Yes               |Yes             |These are staging Needs|
		When user selects fields in TPM/TM Information section on Rockcenter request
			|Is a TPM or TM Needed   |
			|Yes                     |
		And user clicks Submit button on request
  	Then user sees modal for successful "Rock Center" request creation
  	And  user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
  	When user switches to `Notes` tab in right container on Request
  	Then user adds 11 notes on request
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	Then user logs out from application
  	Given user opens producer dashboard application
    And user logins with "fulfiller" role
    When user opens the created request
		When user clicks Edit button on request
		When user switches to `Notes` tab in right container on Request
  	Then user adds 11 notes on request
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	Then user logs out from application
  	Given user opens producer dashboard application
    And user logins with "producer" role
    When user opens the created request
		When user clicks Edit button on request
		When user switches to `Notes` tab in right container on Request
  	Then user edits notes on request randomly
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
		When user switches to `Notes` tab in right container on Request
  	Then user deletes notes on request randomly
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	Then user logs out from application
  	Given user opens producer dashboard application
    And user logins with "fulfiller" role
    When user opens the created request
		When user clicks Edit button on request
		When user switches to `Notes` tab in right container on Request
  	Then user edits notes on request randomly
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
		When user switches to `Notes` tab in right container on Request
  	Then user deletes notes on request randomly
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
		
		
		@NcxUnifiedToolPhase2 @PSEQA @Logs_032 @Logs_Rockcenter
  Scenario: Logs verification for Set Crew section on Rockcenter request
  	And user clicks on forms link
  	And user selects "Rock Center" form
  	And user selects Division on Rockcenter request
  		|Division  |
  		|CNBC      |
  	When user selects fields in Production Purpose section on Rockcenter request
    	| Details & Notes   |Request For      |
    	| this is comments  |Special Coverage |
    	When user selects fields in Show Info section on Rockcenter request
     	|Air Platform|Show Unit or Project Name|Days from today|Start Time|End Time|Prep Time | Work Order |
     	|OTT         |ACCESS HOLLYWOOD         |2              |1:00 PM   |3:00 PM  |12:00 PM | W00098     |
    	When user clicks `+ Location` button on Rockcenter request
    	When user selects fields in Set Location section on Rockcenter request
  		| Location Number  |Location        |Set Location |
  		| 0                |Rock Center     |3A Studio    |
  		When user selects fields in Set Location section on Rockcenter request
  		| Location Number  |Location        |Set Location |
  		| 1                |Rock Center     |3B Studio    |
  	When user selects fields in Control Room Crew section on Rockcenter request
    	|Capture Manager|Control Room Crew                |
    	| Yes           |Technical Director, Playback AD  |
		When user selects fields in Set Crew section on Rockcenter request
			|Set Crew                   |
			|Prod A2, Stage Manager     |
    When user clicks `+ Control Room` button on Rockcenter request
		When user selects fields in Control Room section on Rockcenter request
  		| Location Number  |Control Room Location |Control Room |
  		| 0                |Rock Center           |CR 33        |
  	When user selects fields in Control Room section on Rockcenter request
  		| Location Number  |Control Room Location |Control Room |
  		| 1                |DC              |Wash Control |
		When user selects fields in Set Crew section on Rockcenter request
			|Additional Crew                   |
			|Lighting Director, Prompter Op    |
		When user selects fields in Systems section on Rockcenter request
			|Ultimatte    |Voice Activated Prompter|System Notes           |
			|3            |1                       |These are system notes |
		When user selects fields in Staging section on Rockcenter request
			|Is Staging Needed |Is Lighting Needed  |Is Carpentry Needed|Are Props Needed|Describe Staging Needs |
			|Yes               |No                  | Yes               |Yes             |These are staging Needs|
		When user selects fields in TPM/TM Information section on Rockcenter request
			|Is a TPM or TM Needed   |
			|Yes                     |
		And user clicks Submit button on request
  	Then user sees modal for successful "Rock Center" request creation
  	And  user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
  	When user selects fields in Set Crew section on Rockcenter request in edit mode
    		|Set Crew  |
    		|SM/A2, Steadicam + Util, Jib, Jib Utility, Merlin, Ped Cam, Handheld Cam, Camera Utility, Plaza Productions Op, Lighting Board Op, Hair Stylist, Makeup Artist, Wardrobe Dresser, Music A2, Audio Boom Op, Front of House Mix, Monitor Mix -Foldback, Sound Effects, Crane Cam, Crane Driver, Crane Utility |
		When user removes specific Set Crews on Rockcenter request in edit mode
				|Set Crew               |
				|Prod A2, Stage Manager |
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
		When user changes quantities of Set Crew on Rockcenter request in edit mode
				|NamesWithQuantities                                                   |
				|SM/A2=3, Steadicam + Util=4, Jib=2, Jib Utility=4, Merlin=3, Ped Cam=3, Handheld Cam=3, Camera Utility=2, Plaza Productions Op=3, Lighting Board Op=4, Hair Stylist=4, Makeup Artist=2, Wardrobe Dresser=4, Music A2=2, Audio Boom Op=3, Front of House Mix=4, Monitor Mix -Foldback=3, Sound Effects=3, Crane Cam=3, Crane Driver=2, Crane Utility=2|
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
		When user removes all Set Crew on Rockcenter request in edit mode
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user selects fields in Set Crew section on Rockcenter request in edit mode
			|Set Crew                                                          |
			|Steadicam + Util, Jib, Jib Utility, Merlin, Ped Cam, Handheld Cam, Camera Utility, Plaza Productions Op, Lighting Board Op, Hair Stylist, Makeup Artist, Wardrobe Dresser, Music A2, Audio Boom Op, Front of House Mix, Monitor Mix -Foldback, Sound Effects, Crane Cam, Crane Driver, Crane Utility, Prod A2, Stage Manager,SM/A2|
		When user changes quantities of Set Crew on Rockcenter request in edit mode
			|NamesWithQuantities                                                   |
			|SM/A2=3, Steadicam + Util=4, Jib=2, Jib Utility=4, Merlin=3, Ped Cam=3, Handheld Cam=3, Camera Utility=2, Plaza Productions Op=3, Lighting Board Op=4, Hair Stylist=4, Makeup Artist=2, Wardrobe Dresser=4, Music A2=2, Audio Boom Op=3, Front of House Mix=4, Monitor Mix -Foldback=3, Sound Effects=3, Crane Cam=3, Crane Driver=2, Crane Utility=2, Prod A2=4, Stage Manager=3|
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	
  	@NcxUnifiedToolPhase2 @PSEQA @Logs_033 @Logs_Rockcenter
  Scenario: Logs verification for Control Room Crew section on Rockcenter request
  	And user clicks on forms link
  	And user selects "Rock Center" form
  	And user selects Division on Rockcenter request
  		|Division  |
  		|CNBC      |
  	When user selects fields in Production Purpose section on Rockcenter request
    	| Details & Notes   |Request For      |
    	| this is comments  |Special Coverage |
    When user selects fields in Show Info section on Rockcenter request
     	|Air Platform|Show Unit or Project Name|Days from today|Start Time|End Time|Prep Time | Work Order |
     	|OTT         |ACCESS HOLLYWOOD         |2              |1:00 PM   |3:00 PM  |12:00 PM | W00098     |
    When user clicks `+ Location` button on Rockcenter request
    When user selects fields in Set Location section on Rockcenter request
  		| Location Number  |Location        |Set Location |
  		| 0                |Rock Center     |3A Studio    |
  	When user selects fields in Set Location section on Rockcenter request
  		| Location Number  |Location        |Set Location |
  		| 1                |Rock Center     |3B Studio    |
  	When user selects fields in Control Room Crew section on Rockcenter request
    	|Capture Manager|Control Room Crew                |
    	| Yes           |Technical Director, Playback AD  |
		When user selects fields in Set Crew section on Rockcenter request
			|Set Crew                   |
			|Prod A2, Stage Manager     |
    When user clicks `+ Control Room` button on Rockcenter request
		When user selects fields in Control Room section on Rockcenter request
  		| Location Number  |Control Room Location |Control Room |
  		| 0                |Rock Center           |CR 33        |
  	When user selects fields in Control Room section on Rockcenter request
  		| Location Number  |Control Room Location |Control Room |
  		| 1                |DC              |Wash Control |
		When user selects fields in Set Crew section on Rockcenter request
			|Additional Crew                   |
			|Lighting Director, Prompter Op    |
		When user selects fields in Systems section on Rockcenter request
			|Ultimatte    |Voice Activated Prompter|System Notes           |
			|3            |1                       |These are system notes |
		When user selects fields in Staging section on Rockcenter request
			|Is Staging Needed |Is Lighting Needed  |Is Carpentry Needed|Are Props Needed|Describe Staging Needs |
			|Yes               |No                  | Yes               |Yes             |These are staging Needs|
		When user selects fields in TPM/TM Information section on Rockcenter request
			|Is a TPM or TM Needed   |
			|Yes                     |
		And user clicks Submit button on request
  	Then user sees modal for successful "Rock Center" request creation
  	And  user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
  	When user selects fields in Control Room Crew section on Rockcenter request in edit mode
    		|Capture Manager|Control Room Crew  |
    		|No             |CR Audio Assist - Tx, GFX PB Op L3, Video Playback, A1 Production Mix, GFX PB Op FS/L3, GFX Build Op, CR AD, Fix AD, T2, GFX PB Op FS |
		When user removes specific Control Room Crews on Rockcenter request in edit mode
				|Control Room Crew               |
				|Technical Director, Playback AD |
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
		When user changes quantities of Control Room Crew on Rockcenter request in edit mode
				|NamesWithQuantities                                                   |
				|CR Audio Assist - Tx=2, GFX PB Op L3=4, Video Playback=4, A1 Production Mix=2, GFX PB Op FS/L3=2, GFX Build Op=3, CR AD=2, Fix AD=4, T2=4, GFX PB Op FS=3 |
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
		When user removes all Control Room Crew on Rockcenter request in edit mode
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user selects fields in Control Room Crew section on Rockcenter request in edit mode
    		|Capture Manager|Control Room Crew  |
    		|Yes            |Technical Director, CR Audio Assist - Tx, GFX PB Op L3, Video Playback, Playback AD, A1 Production Mix, GFX PB Op FS/L3, GFX Build Op, CR AD, Fix AD, T2, GFX PB Op FS |
		When user changes quantities of Control Room Crew on Rockcenter request in edit mode
				|NamesWithQuantities                                                   |
				|Technical Director=2, CR Audio Assist - Tx=4, GFX PB Op L3=2, Video Playback=2, Playback AD=3, A1 Production Mix=4, GFX PB Op FS/L3=2, GFX Build Op=3, CR AD=2, Fix AD=4, T2=4, GFX PB Op FS=2 |
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user selects fields in Control Room Crew section on Rockcenter request in edit mode
    		|Capture Manager|
    		|Yes            |
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	
  	  @NcxUnifiedToolPhase2 @PSEQA @Logs_034 @Logs_Rockcenter
  Scenario: Logs verification for Show Info section on Rockcenter request
  	And user clicks on forms link
  	And user selects "Rock Center" form
  	And user selects Division on Rockcenter request
  		|Division  |
  		|CNBC      |
  	When user selects fields in Production Purpose section on Rockcenter request
    	| Details & Notes   |Request For      |
    	| this is comments  |Special Coverage |
    	When user selects fields in Show Info section on Rockcenter request
     	|Air Platform|Show Unit or Project Name|Days from today|Start Time|End Time|Prep Time | Work Order |
     	|OTT         |ACCESS HOLLYWOOD         |2              |1:00 PM   |3:00 PM  |12:00 PM | W00098     |
    	When user clicks `+ Location` button on Rockcenter request
    	When user selects fields in Set Location section on Rockcenter request
  		| Location Number  |Location        |Set Location |
  		| 0                |Rock Center     |3A Studio    |
  		When user selects fields in Set Location section on Rockcenter request
  		| Location Number  |Location        |Set Location |
  		| 1                |Rock Center     |3B Studio    |
  	When user selects fields in Control Room Crew section on Rockcenter request
    	|Capture Manager|Control Room Crew                |
    	| Yes           |Technical Director, Playback AD  |
		When user selects fields in Set Crew section on Rockcenter request
			|Set Crew                   |
			|Prod A2, Stage Manager     |
    When user clicks `+ Control Room` button on Rockcenter request
		When user selects fields in Control Room section on Rockcenter request
  		| Location Number  |Control Room Location |Control Room |
  		| 0                |Rock Center           |CR 33        |
  	When user selects fields in Control Room section on Rockcenter request
  		| Location Number  |Control Room Location |Control Room |
  		| 1                |DC              |Wash Control |
		When user selects fields in Set Crew section on Rockcenter request
			|Additional Crew                   |
			|Lighting Director, Prompter Op    |
		When user selects fields in Systems section on Rockcenter request
			|Ultimatte    |Voice Activated Prompter|System Notes           |
			|3            |1                       |These are system notes |
		When user selects fields in Staging section on Rockcenter request
			|Is Staging Needed |Is Lighting Needed  |Is Carpentry Needed|Are Props Needed|Describe Staging Needs |
			|Yes               |No                  | Yes               |Yes             |These are staging Needs|
		When user selects fields in TPM/TM Information section on Rockcenter request
			|Is a TPM or TM Needed   |
			|Yes                     |
		And user clicks Submit button on request
  	Then user sees modal for successful "Rock Center" request creation
  	And  user clicks on "ok" button
		When user opens the created request
		When user clicks Edit button on request
		When user clears End Time on Rockcenter request
		When user clears Start Time on Rockcenter request
		When user clears Start Date on Rockcenter request
		When user clears Prep Time on Rockcenter request in edit mode
		When user selects fields in Show Info section on Rockcenter request in edit mode
     	|Air Platform|Show Unit or Project Name|Days from today|Start Time|End Time|Prep Time | Work Order |
     	|OTT         |ACCESS HOLLYWOOD         |2              |2:00 PM  |4:00 PM  |1:00 PM  | W00099     |
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
		When user clears End Time on Rockcenter request
		When user clears Start Time on Rockcenter request
		When user clears Start Date on Rockcenter request
		When user selects fields in Show Info section on Rockcenter request in edit mode
     	|Air Platform|Show Unit or Project Name|Days from today|Start Time|End Time|
     	|Multiple    |7S Tour Studio           |4              |3:00 PM   |6:00 PM |
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
		When user clears End Time on Rockcenter request
		When user clears Start Time on Rockcenter request
		When user clears Start Date on Rockcenter request
		When user clears Prep Time on Rockcenter request in edit mode
  	When user selects fields in Show Info section on Rockcenter request in edit mode
     	|Air Platform|Show Unit or Project Name|Days from today|Start Time|End Time|
     	|Multiple    |Alex Wagner Tonight      |15             |5:00 PM   |9:00 PM |	
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
		When user clears End Time on Rockcenter request
		When user clears Start Time on Rockcenter request
		When user clears Start Date on Rockcenter request
		When user selects fields in Show Info section on Rockcenter request in edit mode
     	|Air Platform|Show Unit or Project Name|Days from today|Start Time|End Time|Prep Time|Work Order   |  Other                        |Budget Code |
     	|Multiple    |OTHER                    |15             |12:00 PM  |2:00 PM |4:00 PM  |W00098       |  This is data for other field |autOMATION  |
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	
  	  @NcxUnifiedToolPhase2 @PSEQA @Logs_035 @Logs_Rockcenter
  Scenario: Logs verification for Additional Crew section on Rockcenter request
  	And user clicks on forms link
  	And user selects "Rock Center" form
  	And user selects Division on Rockcenter request
  		|Division  |
  		|CNBC      |
  	When user selects fields in Production Purpose section on Rockcenter request
    	| Details & Notes   |Request For      |
    	| this is comments  |Special Coverage |
    When user selects fields in Show Info section on Rockcenter request
     	|Air Platform|Show Unit or Project Name|Days from today|Start Time|End Time|Prep Time | Work Order |
     	|OTT         |ACCESS HOLLYWOOD         |2              |1:00 PM   |3:00 PM  |12:00 PM | W00098     |
    When user clicks `+ Location` button on Rockcenter request
    When user selects fields in Set Location section on Rockcenter request
  		| Location Number  |Location        |Set Location |
  		| 0                |Rock Center     |3A Studio    |
  	When user selects fields in Set Location section on Rockcenter request
  		| Location Number  |Location        |Set Location |
  		| 1                |Rock Center     |3B Studio    |
  	When user selects fields in Control Room Crew section on Rockcenter request
    	|Capture Manager|Control Room Crew                |
    	| Yes           |Technical Director, Playback AD  |
		When user selects fields in Set Crew section on Rockcenter request
			|Set Crew                   |
			|Prod A2, Stage Manager     |
    When user clicks `+ Control Room` button on Rockcenter request
		When user selects fields in Control Room section on Rockcenter request
  		| Location Number  |Control Room Location |Control Room |
  		| 0                |Rock Center           |CR 33        |
  	When user selects fields in Control Room section on Rockcenter request
  		| Location Number  |Control Room Location |Control Room |
  		| 1                |DC              |Wash Control |
		When user selects fields in Additional Crew section on Rockcenter request
			|Additional Crew                |
			|Lighting Director, Video Op    |
		When user selects fields in Systems section on Rockcenter request
			|Ultimatte    |Voice Activated Prompter|System Notes           |
			|3            |1                       |These are system notes |
		When user selects fields in Staging section on Rockcenter request
			|Is Staging Needed |Is Lighting Needed  |Is Carpentry Needed|Are Props Needed|Describe Staging Needs |
			|Yes               |No                  | Yes               |Yes             |These are staging Needs|
		When user selects fields in TPM/TM Information section on Rockcenter request
			|Is a TPM or TM Needed   |
			|Yes                     |
		And user clicks Submit button on request
  	Then user sees modal for successful "Rock Center" request creation
  	And  user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
  	When user selects fields in Additional Crew section on Rockcenter request in edit mode
    		|Additional Crew  |
    		|Prompter Op, Video Op / Robo Cam, Robo Cam, Studio Maintenance |
		When user removes specific Additional Crews on Rockcenter request in edit mode
			|Additional Crew             |
			|Lighting Director, Video Op |
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
		When user changes quantities of Additional Crew on Rockcenter request in edit mode
				|NamesWithQuantities                                                   |
				|Prompter Op=2, Robo Cam=3, Studio Maintenance=3 |
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
		When user removes all Additional Crew on Rockcenter request in edit mode
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user selects fields in Additional Crew section on Rockcenter request in edit mode
		|Additional Crew  |
		|Prompter Op, Video Op / Robo Cam, Lighting Director, Video Op, Robo Cam, Studio Maintenance |
		When user changes quantities of Additional Crew on Rockcenter request in edit mode
		|NamesWithQuantities                                                   |
		|Prompter Op=2, Video Op / Robo Cam=3, Lighting Director=3, Video Op=3, Robo Cam=3, Studio Maintenance=2 |
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	
  	
  	
  	@NcxUnifiedToolPhase2 @PSEQA @Logs_036 @Logs_FileIngest
  Scenario: log verification for CNBC-Stratus section in File Ingest request
  	And user clicks on forms link
  	And user selects "File Ingest" form
  	When user selects fields in General Details section on ECM request
  		|Division  |Slug    |
  		|CNBC      |Testing |
  	When user clicks `+ Additional Recipient` button on ECM request
  	When user selects fields in Additional Recipients(s) section on ECM request
    	| Email                     |Position      |
    	| mohit.bambani@nbcuni.com  |0             |
    When user selects fields in Producer Details section on ECM request
     	|Req same as producer  | Producer      | Senior Producer   |
			|No                    | Bambani, Mohit| Bambani, Mohit    |
    When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name  | Days from today   | Time   | Flexible    | To Be Determined   |
		|0      | CNBC - Affiliates          | 4                 | 1:00 PM| No          | No                 |
		When user clicks `+ Show Unit` button on ECM request
    When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name    |
		|1      | CNBC - Biz Day - Projects    |
		When user selects fields in Date & Time Needed section on ECM request
		|Days from today | Time   | Flexible | ASAP|
		| 5              | 4:00 PM| No       | No  | 
    When user selects fields in Sources section on File Ingest request
  	| Source Index  | Source  | Qty | Comments  | Select Camera Index | Camera Type  |
		| 0             | Cfast   | 5   | Cfast Comm| 0                   | Canon 5D Mark II |
		When user clicks `+ Camera Type` button on ECM request
		| Source Index  |
		| 0             |
    When user selects fields in Sources section on File Ingest request
  	| Source Index  | Select Camera Index | Camera Type  |
		| 0             | 1                   | Canon C300 Mark I |
  	When user selects Destinations on File Ingest request
  	| Destinations                                         |
  	| Nimbus, DC Network News, CNBC - AVID, CNBC - Stratus |
  	When user selects fields in Nimbus section on ECM request
    	|Details        |Transcode Needed?     |
    	|Nimbus 3000    |Yes                   |
		When user selects fields in DC Network News section on ECM request
		|Need Material Archived? |
		|No                      |
		When user selects fields in CNBC-Avid section on ECM request
		|AVID Workspace           | AVID Project Name | Bin Name    | Add bin name at location  | 
		|Marketing Ingest Elements| avj               | bin name 33 | 0                         |
		When user clicks `+ Bin Name` button on ECM request
		When user selects fields in CNBC-Avid section on ECM request
		| Bin Name    | Add bin name at location  | 
		| bin name 34 | 1                         |
		When user selects fields in CNBC-Stratus section on ECM request
		|Source Compression  | Source Frame Rate | Time Codes                                        | CNBC Stratus Slug    | Add slug at location  | 
		|H.264               | 29.97p            | Merging Together Clips Without Retaining Time Code| slug name 33         | 0                     | 
		When user clicks `+ Slug` button on ECM request
		When user selects fields in CNBC-Stratus section on ECM request
		| CNBC Stratus Slug    | Add slug at location  | 
		| slug name 34         | 1                         |
    When user selects fields in Content Description section on ECM request
		|Content Description|
		| CCD               |
		When user selects fields in Comments section on ECM request
		|Comments |
		|Commenting |
		And user clicks Submit button on request
  	Then user sees modal for successful "File Ingest" request creation
  	And  user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
  	When user unselects Destinations on File Ingest request in edit mode
  	|Destinations |
  	|CNBC - Stratus|
  	When user selects Destinations on File Ingest request in edit mode
  	|Destinations |
  	|CNBC - Stratus|
  	When user selects fields in CNBC-Stratus section on ECM request in edit mode
		|Source Compression  | Source Frame Rate | Time Codes                                        | CNBC Stratus Slug    | Add slug at location  | 
		|H.264               | 29.97p            | Merging Together Clips Without Retaining Time Code| slug name 33         | 0                     | 
		When user clicks `+ Slug` button on ECM request
		When user selects fields in CNBC-Stratus section on ECM request in edit mode
		| CNBC Stratus Slug    | Add slug at location  | 
		| slug name 34         | 1                     |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user selects fields in CNBC-Stratus section on ECM request in edit mode
		|Source Compression  | 
		|H.265               |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	Then user verifies all Logs on request
  	When user clicks Edit button on request
		When user selects fields in CNBC-Stratus section on ECM request in edit mode
		| Source Frame Rate | 
		| 59.94p            |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	Then user verifies all Logs on request
  	When user clicks Edit button on request
		When user selects fields in CNBC-Stratus section on ECM request in edit mode
		| Time Codes                      | 
		| Matching Time Code For All Clips|
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	Then user verifies all Logs on request
  	When user clicks Edit button on request
		When user clicks `+ Slug` button on ECM request
		When user selects fields in CNBC-Stratus section on ECM request in edit mode
		| CNBC Stratus Slug    | Add slug at location  | 
		| slug name 35         | 2                     |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	Then user verifies all Logs on request
  	When user clicks Edit button on request
		When user selects fields in CNBC-Stratus section on ECM request in edit mode
		| Remove slug having location| 
		| 1                            |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	Then user verifies all Logs on request
  	When user clicks Edit button on request
		When user selects fields in CNBC-Stratus section on ECM request in edit mode
		| Remove slug having location| 
		| 0                            |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user selects fields in CNBC-Stratus section on ECM request in edit mode
		|Source Compression  | Source Frame Rate | Time Codes                                        | 
		|H.264               | 29.97p            | Merging Together Clips Without Retaining Time Code|
		When user clicks `+ Slug` button on ECM request
		When user selects fields in CNBC-Stratus section on ECM request in edit mode
		| CNBC Stratus Slug    | Add slug at location  | 
		| slug name 35         | 1                     |
		When user clicks `+ Slug` button on ECM request
		When user selects fields in CNBC-Stratus section on ECM request in edit mode
		| CNBC Stratus Slug    | Add slug at location  | 
		| slug name 349        | 2                     |
		When user selects fields in CNBC-Stratus section on ECM request in edit mode
		| Remove slug having location| 
		| 0                          |
		When user selects fields in CNBC-Stratus section on ECM request in edit mode
		| Remove slug having location| 
		| 1                          |
		When user selects fields in CNBC-Stratus section on ECM request in edit mode
		|Source Compression  | Source Frame Rate | Time Codes                      | 
		|H.265               | 59.94p            | Matching Time Code For All Clips|
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
  	When user selects fields in CNBC-Stratus section on ECM request in edit mode
		|Source Compression  | Source Frame Rate | Time Codes                                        | 
		|H.264               | 29.97p            | Merging Together Clips Without Retaining Time Code|
		When user clicks `+ Slug` button on ECM request
		When user selects fields in CNBC-Stratus section on ECM request in edit mode
		| CNBC Stratus Slug    | Add slug at location  | 
		| slug name 350        | 1                     |
		When user selects fields in CNBC-Stratus section on ECM request in edit mode
		| Remove slug having location| 
		| 0                          |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user unselects Destinations on File Ingest request in edit mode
  	|Destinations  |
  	|CNBC - Stratus|
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user selects Destinations on File Ingest request in edit mode
  	|Destinations |
  	|CNBC - Stratus|
		When user selects fields in CNBC-Stratus section on ECM request in edit mode
		| CNBC Stratus Slug    | Add slug at location  | 
		| slug name 34         | 0                     |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	
  	@NcxUnifiedToolPhase2 @PSEQA @Logs_037 @Logs_FileIngest
  Scenario: log verification for CNBC-AVID section in File Ingest request
  	And user clicks on forms link
  	And user selects "File Ingest" form
  	When user selects fields in General Details section on ECM request
  		|Division  |Slug    |
  		|CNBC      |Testing |
  	When user clicks `+ Additional Recipient` button on ECM request
  	When user selects fields in Additional Recipients(s) section on ECM request
    	| Email                     |Position      |
    	| mohit.bambani@nbcuni.com  |0             |
    When user selects fields in Producer Details section on ECM request
     	|Req same as producer  | Producer      | Senior Producer   |
			|No                    | Bambani, Mohit| Bambani, Mohit    |
    When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name  | Days from today   | Time   | Flexible    | To Be Determined   |
		|0      | CNBC - Affiliates          | 4                 | 1:00 PM| No          | No                 |
		When user clicks `+ Show Unit` button on ECM request
    When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name    |
		|1      | CNBC - Biz Day - Projects    |
		When user selects fields in Date & Time Needed section on ECM request
		|Days from today | Time   | Flexible | ASAP|
		| 5              | 4:00 PM| No       | No  | 
    When user selects fields in Sources section on File Ingest request
  	| Source Index  | Source  | Qty | Comments  | Select Camera Index | Camera Type  |
		| 0             | Cfast   | 5   | Cfast Comm| 0                   | Canon 5D Mark II |
		When user clicks `+ Camera Type` button on ECM request
		| Source Index  |
		| 0             |
    When user selects fields in Sources section on File Ingest request
  	| Source Index  | Select Camera Index | Camera Type  |
		| 0             | 1                   | Canon C300 Mark I |
  	When user selects Destinations on File Ingest request
  	| Destinations                                         |
  	| Nimbus, DC Network News, CNBC - AVID, CNBC - Stratus |
  	When user selects fields in Nimbus section on ECM request
    	|Details        |Transcode Needed?     |
    	|Nimbus 3000    |Yes                   |
		When user selects fields in DC Network News section on ECM request
		|Need Material Archived? |
		|No                      |
		When user selects fields in CNBC-Avid section on ECM request
		|AVID Workspace           | AVID Project Name | Bin Name    | Add bin name at location  | 
		|Marketing Ingest Elements| avj               | bin name 33 | 0                         |
		When user clicks `+ Bin Name` button on ECM request
		When user selects fields in CNBC-Avid section on ECM request
		| Bin Name    | Add bin name at location  | 
		| bin name 34 | 1                         |
		When user selects fields in CNBC-Stratus section on ECM request
		|Source Compression  | Source Frame Rate | Time Codes                                        | CNBC Stratus Slug    | Add slug at location  | 
		|H.264               | 29.97p            | Merging Together Clips Without Retaining Time Code| slug name 33         | 0                     | 
		When user clicks `+ Slug` button on ECM request
		When user selects fields in CNBC-Stratus section on ECM request
		| CNBC Stratus Slug    | Add slug at location  | 
		| slug name 34         | 1                         |
    When user selects fields in Content Description section on ECM request
		|Content Description|
		| CCD               |
		When user selects fields in Comments section on ECM request
		|Comments |
		|Commenting |
		And user clicks Submit button on request
  	Then user sees modal for successful "File Ingest" request creation
  	And  user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
  	When user unselects Destinations on File Ingest request in edit mode
  	|Destinations |
  	|CNBC - AVID|
  	When user selects Destinations on File Ingest request in edit mode
  	|Destinations |
  	|CNBC - AVID|
  	When user selects fields in CNBC-Avid section on ECM request in edit mode
		|AVID Workspace           | AVID Project Name | Bin Name    | Add bin name at location  | 
		|Marketing Ingest Elements| avj               | bin name 33 | 0                         | 
		When user clicks `+ Bin Name` button on ECM request
		When user selects fields in CNBC-Avid section on ECM request in edit mode
		| Bin Name    | Add bin name at location  | 
		| bin name 34 | 1                         |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user selects fields in CNBC-Avid section on ECM request in edit mode
		|AVID Workspace| 
		|News Projects | 
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	Then user verifies all Logs on request
  	When user clicks Edit button on request
		When user selects fields in CNBC-Avid section on ECM request in edit mode
		| AVID Project Name | 
		| avj - edited               | 
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	Then user verifies all Logs on request
  	When user clicks Edit button on request
		When user clicks `+ Bin Name` button on ECM request
		When user selects fields in CNBC-Avid section on ECM request in edit mode
		| Bin Name    | Add bin name at location  | 
		| bin name 35 | 2                         |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user selects fields in CNBC-Avid section on ECM request in edit mode
		| Remove bin name having location| 
		| 1                              |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	Then user verifies all Logs on request
  	When user clicks Edit button on request
		When user selects fields in CNBC-Avid section on ECM request in edit mode
		| Remove bin name having location| 
		| 0                              |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user selects fields in CNBC-Avid section on ECM request in edit mode
		|AVID Workspace           | AVID Project Name | 
		|Marketing Ingest Elements| avj               |
		When user clicks `+ Bin Name` button on ECM request
		When user selects fields in CNBC-Avid section on ECM request in edit mode
		| Bin Name     | Add bin name at location  | 
		| bin name 35  | 1                         |
		When user clicks `+ Bin Name` button on ECM request
		When user selects fields in CNBC-Avid section on ECM request in edit mode
		| Bin Name       | Add bin name at location  | 
		| bin name 3500  | 2                         |
		When user selects fields in CNBC-Avid section on ECM request in edit mode
		| Remove bin name having location| 
		| 0                          |
		When user selects fields in CNBC-Avid section on ECM request in edit mode
		| Remove bin name having location| 
		| 1                          |
		When user selects fields in CNBC-Avid section on ECM request in edit mode
		|AVID Workspace | AVID Project Name | 
		|News Projects  | avj - edited      |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
  	When user selects fields in CNBC-Avid section on ECM request in edit mode
		|AVID Workspace           | AVID Project Name | 
		|Marketing Ingest Elements| avj               |
		When user clicks `+ Bin Name` button on ECM request
		When user selects fields in CNBC-Avid section on ECM request in edit mode
		| Bin Name     | Add bin name at location  | 
		| bin name 350 | 1                         |
		When user selects fields in CNBC-Avid section on ECM request in edit mode
		| Remove bin name having location| 
		| 0                              |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user unselects Destinations on File Ingest request in edit mode
  	|Destinations  |
  	|CNBC - AVID   |
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user selects Destinations on File Ingest request in edit mode
  	|Destinations |
  	|CNBC - AVID  |
		When user selects fields in CNBC-Avid section on ECM request in edit mode
		|AVID Workspace  | AVID Project Name | 
		|News Projects   | avj               |
		When user selects fields in CNBC-Avid section on ECM request in edit mode
		| Bin Name     | Add bin name at location  | 
		| bin name 350 | 0                         |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	
  	@NcxUnifiedToolPhase2 @PSEQA @Logs_038 @Logs_FileIngest
  Scenario: log verification for Nimbus, DC Network News section in File Ingest request
  	And user clicks on forms link
  	And user selects "File Ingest" form
  	When user selects fields in General Details section on ECM request
  		|Division  |Slug    |
  		|CNBC      |Testing |
  	When user clicks `+ Additional Recipient` button on ECM request
  	When user selects fields in Additional Recipients(s) section on ECM request
    	| Email                     |Position      |
    	| mohit.bambani@nbcuni.com  |0             |
    When user selects fields in Producer Details section on ECM request
     	|Req same as producer  | Producer      | Senior Producer   |
			|No                    | Bambani, Mohit| Bambani, Mohit    |
    When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name  | Days from today   | Time   | Flexible    | To Be Determined   |
		|0      | CNBC - Affiliates          | 4                 | 1:00 PM| No          | No                 |
		When user clicks `+ Show Unit` button on ECM request
    When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name    |
		|1      | CNBC - Biz Day - Projects    |
		When user selects fields in Date & Time Needed section on ECM request
		|Days from today | Time   | Flexible | ASAP|
		| 5              | 4:00 PM| No       | No  | 
    When user selects fields in Sources section on File Ingest request
  	| Source Index  | Source  | Qty | Comments  | Select Camera Index | Camera Type  |
		| 0             | Cfast   | 5   | Cfast Comm| 0                   | Canon 5D Mark II |
		When user clicks `+ Camera Type` button on ECM request
		| Source Index  |
		| 0             |
    When user selects fields in Sources section on File Ingest request
  	| Source Index  | Select Camera Index | Camera Type  |
		| 0             | 1                   | Canon C300 Mark I |
  	When user selects Destinations on File Ingest request
  	| Destinations                                         |
  	| Nimbus, DC Network News, CNBC - AVID, CNBC - Stratus |
  	When user selects fields in Nimbus section on ECM request
    	|Details        |Transcode Needed?     |
    	|Nimbus 3000    |Yes                   |
		When user selects fields in DC Network News section on ECM request
		|Need Material Archived? |
		|No                      |
		When user selects fields in CNBC-Avid section on ECM request
		|AVID Workspace           | AVID Project Name | Bin Name    | Add bin name at location  | 
		|Marketing Ingest Elements| avj               | bin name 33 | 0                         |
		When user clicks `+ Bin Name` button on ECM request
		When user selects fields in CNBC-Avid section on ECM request
		| Bin Name    | Add bin name at location  | 
		| bin name 34 | 1                         |
		When user selects fields in CNBC-Stratus section on ECM request
		|Source Compression  | Source Frame Rate | Time Codes                                        | CNBC Stratus Slug    | Add slug at location  | 
		|H.264               | 29.97p            | Merging Together Clips Without Retaining Time Code| slug name 33         | 0                     | 
		When user clicks `+ Slug` button on ECM request
		When user selects fields in CNBC-Stratus section on ECM request
		| CNBC Stratus Slug    | Add slug at location  | 
		| slug name 34         | 1                         |
    When user selects fields in Content Description section on ECM request
		|Content Description|
		| CCD               |
		When user selects fields in Comments section on ECM request
		|Comments |
		|Commenting |
		And user clicks Submit button on request
  	Then user sees modal for successful "File Ingest" request creation
 		And  user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
  	When user selects fields in Nimbus section on ECM request in edit mode
    	|Details        |Transcode Needed?     |
    	|Nimbus 4000    |No                   |
		When user selects fields in DC Network News section on ECM request in edit mode
		|Need Material Archived? |
		|Yes                      |
		When user selects fields in Nimbus section on ECM request in edit mode
    	|Details        |Transcode Needed?     |
    	|Nimbus 3000    |Yes                   |
		When user selects fields in DC Network News section on ECM request in edit mode
		|Need Material Archived? |
		|No                      |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
		When user selects fields in Nimbus section on ECM request in edit mode
    	|Details        |
    	|Nimbus 4000    |
		When user selects fields in DC Network News section on ECM request in edit mode
		|Need Material Archived? |
		|Yes                      |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	Then user verifies all Logs on request
  	When user clicks Edit button on request
		When user selects fields in Nimbus section on ECM request in edit mode
		|Transcode Needed?     |
		|No                   |
		When user selects fields in DC Network News section on ECM request in edit mode
		|Need Material Archived? |
		|No                      |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	Then user verifies all Logs on request
  	When user clicks Edit button on request
		When user selects fields in Nimbus section on ECM request in edit mode
		|Transcode Needed?     |
		|Yes                   |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	Then user verifies all Logs on request
  	When user clicks Edit button on request
		When user selects fields in DC Network News section on ECM request in edit mode
		|Need Material Archived? |
		|Yes                     |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  #	Then user verifies all Logs on request
  	When user clicks Edit button on request
		When user selects fields in Nimbus section on ECM request in edit mode
    	|Details        |Transcode Needed?     |
    	|Nimbus 5000    |No                   |
		When user selects fields in DC Network News section on ECM request in edit mode
		|Need Material Archived? |
		|No                      |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
  	When user unselects Destinations on File Ingest request in edit mode
  	|Destinations                   |
  	|Nimbus, DC Network News        |
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user selects Destinations on File Ingest request in edit mode
  	|Destinations |
  	|Nimbus, DC Network News  |
		When user selects fields in Nimbus section on ECM request in edit mode
    	|Details        |Transcode Needed?     |
    	|Nimbus 4000    |No                   |
		When user selects fields in DC Network News section on ECM request in edit mode
		|Need Material Archived? |
		|Yes                     |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	
  	@NcxUnifiedToolPhase2 @PSEQA @Logs_039 @Logs_FileIngest
  Scenario: log verification for Sources section in File Ingest request
  	And user clicks on forms link
  	And user selects "File Ingest" form
  	When user selects fields in General Details section on ECM request
  		|Division  |Slug    |
  		|CNBC      |Testing |
  	When user clicks `+ Additional Recipient` button on ECM request
  	When user selects fields in Additional Recipients(s) section on ECM request
    	| Email                     |Position      |
    	| mohit.bambani@nbcuni.com  |0             |
    When user selects fields in Producer Details section on ECM request
     	|Req same as producer  | Producer      | Senior Producer   |
			|No                    | Bambani, Mohit| Bambani, Mohit    |
    When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name  | Days from today   | Time   | Flexible    | To Be Determined   |
		|0      | CNBC - Affiliates          | 4                 | 1:00 PM| No          | No                 |
		When user clicks `+ Show Unit` button on ECM request
    When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name    |
		|1      | CNBC - Biz Day - Projects    |
		When user selects fields in Date & Time Needed section on ECM request
		|Days from today | Time   | Flexible | ASAP|
		| 5              | 4:00 PM| No       | No  | 
    When user selects fields in Sources section on File Ingest request
  	| Source Index  | Source  | Qty | Comments  | Select Camera Index | Camera Type  |
		| 0             | Cfast   | 5   | Cfast Comm| 0                   | Canon 5D Mark II |
		When user clicks `+ Camera Type` button on ECM request
		| Source Index  |
		| 0             |
    When user selects fields in Sources section on File Ingest request
  	| Source Index  | Select Camera Index | Camera Type  |
		| 0             | 1                   | Canon C300 Mark I |
  	When user selects Destinations on File Ingest request
  	| Destinations                                         |
  	| Nimbus, DC Network News, CNBC - AVID, CNBC - Stratus |
  	When user selects fields in Nimbus section on ECM request
    	|Details        |Transcode Needed?     |
    	|Nimbus 3000    |Yes                   |
		When user selects fields in DC Network News section on ECM request
		|Need Material Archived? |
		|No                      |
		When user selects fields in CNBC-Avid section on ECM request
		|AVID Workspace           | AVID Project Name | Bin Name    | Add bin name at location  | 
		|Marketing Ingest Elements| avj               | bin name 33 | 0                         |
		When user clicks `+ Bin Name` button on ECM request
		When user selects fields in CNBC-Avid section on ECM request
		| Bin Name    | Add bin name at location  | 
		| bin name 34 | 1                         |
		When user selects fields in CNBC-Stratus section on ECM request
		|Source Compression  | Source Frame Rate | Time Codes                                        | CNBC Stratus Slug    | Add slug at location  | 
		|H.264               | 29.97p            | Merging Together Clips Without Retaining Time Code| slug name 33         | 0                     | 
		When user clicks `+ Slug` button on ECM request
		When user selects fields in CNBC-Stratus section on ECM request
		| CNBC Stratus Slug    | Add slug at location  | 
		| slug name 34         | 1                         |
    When user selects fields in Content Description section on ECM request
		|Content Description|
		| CCD               |
		When user selects fields in Comments section on ECM request
		|Comments |
		|Commenting |
		And user clicks Submit button on request
  	Then user sees modal for successful "File Ingest" request creation
  	And  user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
		When user clicks `+ Source` button on ECM request
  	When user selects fields in Sources section on File Ingest request in edit mode
  	| Source Index  | Source  | Qty | Comments  | Select Camera Index | Camera Type      |
		| 1             | Cfast   | 5   | Cfast Comm| 0                   | Canon 5D Mark II |
		When user clicks `+ Camera Type` button on ECM request
		| Source Index  |
		| 1             |
    When user selects fields in Sources section on File Ingest request in edit mode
  	| Source Index  | Select Camera Index | Camera Type  |
		| 1             | 1                   | Canon C300 Mark I |
		When user removes Source section on ECM request in edit mode
		|Source Index |
		|0            |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user selects fields in Sources section on File Ingest request in edit mode
  	| Source Index  | Source  |
		| 0             | Cfast 2 |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user selects fields in Sources section on File Ingest request in edit mode
  	| Source Index  | Qty |
		| 0             | 3   |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user selects fields in Sources section on File Ingest request in edit mode
  	| Source Index  | Comments   |
		| 0             | Cfast2 Comm|
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user selects fields in Sources section on File Ingest request in edit mode
  	| Source Index  |Select Camera Index | Camera Type       |
		| 0             | 0                  | Canon 5D Mark III |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user selects fields in Sources section on File Ingest request in edit mode
  	| Source Index  |Select Camera Index | Camera Type      |
		| 0             | 1                  | Canon 5D Mark II |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
		When user clicks `+ Camera Type` button on ECM request
		| Source Index  |
		| 0             |
  	When user selects fields in Sources section on File Ingest request in edit mode
  	| Source Index  |Select Camera Index | Camera Type      |
		| 0             | 2                  | Canon 5D Mark II |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
		When user clicks `+ Camera Type` button on ECM request
		| Source Index  |
		| 0             |
  	When user selects fields in Sources section on File Ingest request in edit mode
  	| Source Index  |Select Camera Index | Camera Type      |
		| 0             | 3                  | Canon 5D Mark II |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user clicks `+ Source` button on ECM request
  	When user selects fields in Sources section on File Ingest request in edit mode
  	| Source Index  | Source  | Qty | Comments   | Select Camera Index | Camera Type      |
		| 1             | Cfast 2 | 4   | Cfast2 Comm| 0                   | Canon 5D Mark II |
		When user clicks `+ Camera Type` button on ECM request
		| Source Index  |
		| 1             |
    When user selects fields in Sources section on File Ingest request in edit mode
  	| Source Index  | Select Camera Index | Camera Type  |
		| 1             | 1                   | Canon C300 Mark I |
		When user selects fields in Sources section on File Ingest request in edit mode
  	| Source Index  | Select Camera Index | Camera Type  |
		| 1             | 2                   | Canon C300 Mark I |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user clicks `+ Source` button on ECM request
  	When user selects fields in Sources section on File Ingest request in edit mode
  	| Source Index  | Source  | Qty | Comments       | Select Camera Index | Camera Type      |
		| 2             | Cfast 2 | 4   | Cfast2 Comm-e  | 0                   | Canon 5D Mark II |
		When user clicks `+ Camera Type` button on ECM request
		| Source Index  |
		| 2             |
    When user selects fields in Sources section on File Ingest request in edit mode
  	| Source Index  | Select Camera Index | Camera Type  |
		| 2             | 1                   | Canon C300 Mark I |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user selects fields in Sources section on File Ingest request in edit mode
  	| Source Index  | Remove Camera Index  |
		| 1             | 1                    |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
		When user clicks `+ Camera Type` button on ECM request
		| Source Index  |
		| 2             |
    When user selects fields in Sources section on File Ingest request in edit mode
  	| Source Index  | Select Camera Index | Camera Type  |
		| 2             | 2                   | Canon C300 Mark I |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
		When user removes Source section on ECM request in edit mode
		|Source Index |
		|1            |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
		When user removes Source section on ECM request in edit mode
		|Source Index |
		|1            |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	
  	@NcxUnifiedToolPhase2 @PSEQA @Logs_040 @Logs_FileIngest
  Scenario: log verification for Show Information section in File Ingest request
  	And user clicks on forms link
  	And user selects "File Ingest" form
  	When user selects fields in General Details section on ECM request
  		|Division  |Slug    |
  		|CNBC      |Testing |
  	When user clicks `+ Additional Recipient` button on ECM request
  	When user selects fields in Additional Recipients(s) section on ECM request
    	| Email                     |Position      |
    	| mohit.bambani@nbcuni.com  |0             |
    When user selects fields in Producer Details section on ECM request
     	|Req same as producer  | Producer      | Senior Producer   |
			|No                    | Bambani, Mohit| Bambani, Mohit    |
    When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name  | Days from today   | Time   | Flexible    | To Be Determined   |
		|0      | CNBC - Affiliates          | 4                 | 1:00 PM| No          | No                 |
		When user clicks `+ Show Unit` button on ECM request
    When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name    |
		|1      | CNBC - Biz Day - Projects    |
		When user selects fields in Date & Time Needed section on ECM request
		|Days from today | Time   | Flexible | ASAP|
		| 5              | 4:00 PM| No       | No  | 
    When user selects fields in Sources section on File Ingest request
  	| Source Index  | Source  | Qty | Comments  | Select Camera Index | Camera Type  |
		| 0             | Cfast   | 5   | Cfast Comm| 0                   | Canon 5D Mark II |
		When user clicks `+ Camera Type` button on ECM request
		| Source Index  |
		| 0             |
    When user selects fields in Sources section on File Ingest request
  	| Source Index  | Select Camera Index | Camera Type  |
		| 0             | 1                   | Canon C300 Mark I |
  	When user selects Destinations on File Ingest request
  	| Destinations                                         |
  	| Nimbus, DC Network News, CNBC - AVID, CNBC - Stratus |
  	When user selects fields in Nimbus section on ECM request
    	|Details        |Transcode Needed?     |
    	|Nimbus 3000    |Yes                   |
		When user selects fields in DC Network News section on ECM request
		|Need Material Archived? |
		|No                      |
		When user selects fields in CNBC-Avid section on ECM request
		|AVID Workspace           | AVID Project Name | Bin Name    | Add bin name at location  | 
		|Marketing Ingest Elements| avj               | bin name 33 | 0                         |
		When user clicks `+ Bin Name` button on ECM request
		When user selects fields in CNBC-Avid section on ECM request
		| Bin Name    | Add bin name at location  | 
		| bin name 34 | 1                         |
		When user selects fields in CNBC-Stratus section on ECM request
		|Source Compression  | Source Frame Rate | Time Codes                                        | CNBC Stratus Slug    | Add slug at location  | 
		|H.264               | 29.97p            | Merging Together Clips Without Retaining Time Code| slug name 33         | 0                     | 
		When user clicks `+ Slug` button on ECM request
		When user selects fields in CNBC-Stratus section on ECM request
		| CNBC Stratus Slug    | Add slug at location  | 
		| slug name 34         | 1                         |
    When user selects fields in Content Description section on ECM request
		|Content Description|
		| CCD               |
		When user selects fields in Comments section on ECM request
		|Comments |
		|Commenting |
		And user clicks Submit button on request
  	Then user sees modal for successful "File Ingest" request creation
  	And  user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
		When user clicks `+ Show Unit` button on ECM request
    When user selects fields in Show Information section on ECM request in edit mode
		|Index  | Show Unit or Project Name  |
		|2      | CNBC - Affiliates          |
		When user clicks `+ Show Unit` button on ECM request
    When user selects fields in Show Information section on ECM request in edit mode
		|Index  | Show Unit or Project Name    |
		|3      | CNBC - Biz Day - Projects    |
    When user selects fields in Show Information section on ECM request in edit mode
		|Remove show unit index|
		|0                     |
    When user selects fields in Show Information section on ECM request in edit mode
		|Remove show unit index|
		|0                     |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request 
		When user clicks Edit button on request
		When user selects fields in Show Information section on ECM request in edit mode
		| Flexible    |
		| Yes         |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request 
		When user clicks Edit button on request
		When user selects fields in Show Information section on ECM request in edit mode
		| To Be Determined   |
		| Yes                |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request 
		When user clicks Edit button on request
		When user selects fields in Show Information section on ECM request in edit mode
		|To Be Determined  |
		|No                |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request 
  	When user clicks Edit button on request
		When user selects fields in Show Information section on ECM request in edit mode
		| Days from today   |
		| 5                 |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
		When user clicks Edit button on request
    When user selects fields in Show Information section on ECM request in edit mode
		| Flexible    |
		| No          |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request 
  	When user clicks Edit button on request
    When user selects fields in Show Information section on ECM request in edit mode
		| Time   |
		| 1:00 PM|
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request 
  	When user clicks Edit button on request
  	When user clears Air Date on ECM request in edit mode
		When user selects fields in Show Information section on ECM request in edit mode
		| Days from today   |
		| 10                 |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user clears Air Time on ECM request in edit mode
    When user selects fields in Show Information section on ECM request in edit mode
		| Time   |
		| 3:00 PM|
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request 
  	When user clicks Edit button on request
    When user selects fields in Show Information section on ECM request in edit mode
		| Flexible |To Be Determined|
		| Yes      |Yes             |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
    When user selects fields in Show Information section on ECM request in edit mode
		| Flexible |To Be Determined|Time    |Days from today|
		| No       |No              |1:00 PM |7              |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request 
  	When user clicks Edit button on request
  	When user clears Air Time on ECM request in edit mode
  	When user clears Air Date on ECM request in edit mode
    When user selects fields in Show Information section on ECM request in edit mode
		|Time    |Days from today|
		|2:00 PM |9              |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user selects fields in Show Information section on ECM request in edit mode
		|Remove show unit index|
		|0                     |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user clicks `+ Show Unit` button on ECM request
    When user selects fields in Show Information section on ECM request in edit mode
		|Index  | Show Unit or Project Name    |
		|1      | CNBC - Biz Day - Projects    |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user selects fields in Show Information section on ECM request in edit mode
		|Remove show unit index|
		|0                     |
		When user selects fields in Show Information section on ECM request in edit mode
		|Remove show unit index|
		|0                     |
		When user selects fields in Show Information section on ECM request in edit mode
		|Index  | Show Unit or Project Name  |
		|0      | CNBC - Archives            |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user selects fields in Show Information section on ECM request in edit mode
		|Remove show unit index|
		|0                     |
		When user clears Air Time on ECM request in edit mode
		When user selects fields in Show Information section on ECM request in edit mode
		|Index  | Show Unit or Project Name  |To Be Determined|Time   |
		|0      | CNBC - Affiliates          |Yes             |8:00 PM|
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user clears Air Time on ECM request in edit mode
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user selects fields in Show Information section on ECM request in edit mode
		|To Be Determined|Days from today |
		|No              |8               |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user clears Air Date on ECM request in edit mode
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	
  	@NcxUnifiedToolPhase2 @PSEQA @Logs_041 @Logs_FileIngest
  Scenario: log verification for Date & Time Needed section in File Ingest request
  	And user clicks on forms link
  	And user selects "File Ingest" form
  	When user selects fields in General Details section on ECM request
  		|Division  |Slug    |
  		|CNBC      |Testing |
  	When user clicks `+ Additional Recipient` button on ECM request
  	When user selects fields in Additional Recipients(s) section on ECM request
    	| Email                     |Position      |
    	| mohit.bambani@nbcuni.com  |0             |
    When user selects fields in Producer Details section on ECM request
     	|Req same as producer  | Producer      | Senior Producer   |
			|No                    | Bambani, Mohit| Bambani, Mohit    |
    When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name  | Days from today   | Time   | Flexible    | To Be Determined   |
		|0      | CNBC - Affiliates          | 4                 | 1:00 PM| No          | No                 |
		When user clicks `+ Show Unit` button on ECM request
    When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name    |
		|1      | CNBC - Biz Day - Projects    |
		When user selects fields in Date & Time Needed section on ECM request
		|Days from today | Time   | Flexible | ASAP|
		| 5              | 4:00 PM| No       | No  | 
    When user selects fields in Sources section on File Ingest request
  	| Source Index  | Source  | Qty | Comments  | Select Camera Index | Camera Type  |
		| 0             | Cfast   | 5   | Cfast Comm| 0                   | Canon 5D Mark II |
		When user clicks `+ Camera Type` button on ECM request
		| Source Index  |
		| 0             |
    When user selects fields in Sources section on File Ingest request
  	| Source Index  | Select Camera Index | Camera Type  |
		| 0             | 1                   | Canon C300 Mark I |
  	When user selects Destinations on File Ingest request
  	| Destinations                                         |
  	| Nimbus, DC Network News, CNBC - AVID, CNBC - Stratus |
  	When user selects fields in Nimbus section on ECM request
    	|Details        |Transcode Needed?     |
    	|Nimbus 3000    |Yes                   |
		When user selects fields in DC Network News section on ECM request
		|Need Material Archived? |
		|No                      |
		When user selects fields in CNBC-Avid section on ECM request
		|AVID Workspace           | AVID Project Name | Bin Name    | Add bin name at location  | 
		|Marketing Ingest Elements| avj               | bin name 33 | 0                         |
		When user clicks `+ Bin Name` button on ECM request
		When user selects fields in CNBC-Avid section on ECM request
		| Bin Name    | Add bin name at location  | 
		| bin name 34 | 1                         |
		When user selects fields in CNBC-Stratus section on ECM request
		|Source Compression  | Source Frame Rate | Time Codes                                        | CNBC Stratus Slug    | Add slug at location  | 
		|H.264               | 29.97p            | Merging Together Clips Without Retaining Time Code| slug name 33         | 0                     | 
		When user clicks `+ Slug` button on ECM request
		When user selects fields in CNBC-Stratus section on ECM request
		| CNBC Stratus Slug    | Add slug at location  | 
		| slug name 34         | 1                         |
    When user selects fields in Content Description section on ECM request
		|Content Description|
		| CCD               |
		When user selects fields in Comments section on ECM request
		|Comments |
		|Commenting |
		And user clicks Submit button on request
  	Then user sees modal for successful "File Ingest" request creation
  	And  user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
    When user selects fields in Date & Time Needed section on ECM request in edit mode
		| Flexible | ASAP|
		| Yes      | Yes | 
    When user selects fields in Date & Time Needed section on ECM request in edit mode
		| Flexible | ASAP|Days from today|Time    |
		| No       | No  | 5             |4:00 PM |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request 
		When user clicks Edit button on request
		When user selects fields in Date & Time Needed section on ECM request in edit mode
		| Flexible |
		| Yes      |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request 
		When user clicks Edit button on request
		When user selects fields in Date & Time Needed section on ECM request in edit mode
		| ASAP       |
		| Yes        |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request 
		When user clicks Edit button on request
		When user selects fields in Date & Time Needed section on ECM request in edit mode
		| ASAP|Days from today|
		| No  | 5             |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request 
  	When user clicks Edit button on request
  	When user clears Date Needed By on ECM request
		When user selects fields in Date & Time Needed section on ECM request in edit mode
		|Days from today|
		| 6             |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
		When user clicks Edit button on request
    When user selects fields in Date & Time Needed section on ECM request in edit mode
		| Flexible |Time    |
		| No       |4:00 PM |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request 
  	When user clicks Edit button on request
  	When user clears Time Needed By on ECM request
    When user selects fields in Date & Time Needed section on ECM request in edit mode
		|Time    |
		|5:00 PM |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request 
  	When user clicks Edit button on request
  	When user clears Date Needed By on ECM request
		When user selects fields in Date & Time Needed section on ECM request in edit mode
		| Days from today   |
		| 10                 |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user clears Time Needed By on ECM request
    When user selects fields in Date & Time Needed section on ECM request in edit mode
		| Time   |
		| 3:00 PM|
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request 
  	When user clicks Edit button on request
    When user selects fields in Date & Time Needed section on ECM request in edit mode
		| Flexible |ASAP        |
		| Yes      |Yes         |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
    When user selects fields in Date & Time Needed section on ECM request in edit mode
		| Flexible | ASAP|Days from today|Time    |
		| No       | No  | 5             |4:00 PM |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request 
  	When user clicks Edit button on request
  	When user clears Date Needed By on ECM request
  	When user clears Time Needed By on ECM request
    When user selects fields in Date & Time Needed section on ECM request in edit mode
		|Days from today|Time    |
		| 5             |4:00 PM |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user clears Date Needed By on ECM request
    When user selects fields in Date & Time Needed section on ECM request in edit mode
		|Days from today|Flexible    |
		| 6             |Yes         |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
    When user selects fields in Date & Time Needed section on ECM request in edit mode
		|ASAP|
		|Yes |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	
  	@NcxUnifiedToolPhase2 @PSEQA @Logs_042 @Logs_FileIngest
  Scenario: log verification for Comments, Content Description sections in File Ingest request
  	And user clicks on forms link
  	And user selects "File Ingest" form
  	When user selects fields in General Details section on ECM request
  		|Division  |Slug    |
  		|CNBC      |Testing |
  	When user clicks `+ Additional Recipient` button on ECM request
  	When user selects fields in Additional Recipients(s) section on ECM request
    	| Email                     |Position      |
    	| mohit.bambani@nbcuni.com  |0             |
    When user selects fields in Producer Details section on ECM request
     	|Req same as producer  | Producer      | Senior Producer   |
			|No                    | Bambani, Mohit| Bambani, Mohit    |
    When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name  | Days from today   | Time   | Flexible    | To Be Determined   |
		|0      | CNBC - Affiliates          | 4                 | 1:00 PM| No          | No                 |
		When user clicks `+ Show Unit` button on ECM request
    When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name    |
		|1      | CNBC - Biz Day - Projects    |
		When user selects fields in Date & Time Needed section on ECM request
		|Days from today | Time   | Flexible | ASAP|
		| 5              | 4:00 PM| No       | No  | 
    When user selects fields in Sources section on File Ingest request
  	| Source Index  | Source  | Qty | Comments  | Select Camera Index | Camera Type  |
		| 0             | Cfast   | 5   | Cfast Comm| 0                   | Canon 5D Mark II |
		When user clicks `+ Camera Type` button on ECM request
		| Source Index  |
		| 0             |
    When user selects fields in Sources section on File Ingest request
  	| Source Index  | Select Camera Index | Camera Type  |
		| 0             | 1                   | Canon C300 Mark I |
  	When user selects Destinations on File Ingest request
  	| Destinations                                         |
  	| Nimbus, DC Network News, CNBC - AVID, CNBC - Stratus |
  	When user selects fields in Nimbus section on ECM request
    	|Details        |Transcode Needed?     |
    	|Nimbus 3000    |Yes                   |
		When user selects fields in DC Network News section on ECM request
		|Need Material Archived? |
		|No                      |
		When user selects fields in CNBC-Avid section on ECM request
		|AVID Workspace           | AVID Project Name | Bin Name    | Add bin name at location  | 
		|Marketing Ingest Elements| avj               | bin name 33 | 0                         |
		When user clicks `+ Bin Name` button on ECM request
		When user selects fields in CNBC-Avid section on ECM request
		| Bin Name    | Add bin name at location  | 
		| bin name 34 | 1                         |
		When user selects fields in CNBC-Stratus section on ECM request
		|Source Compression  | Source Frame Rate | Time Codes                                        | CNBC Stratus Slug    | Add slug at location  | 
		|H.264               | 29.97p            | Merging Together Clips Without Retaining Time Code| slug name 33         | 0                     | 
		When user clicks `+ Slug` button on ECM request
		When user selects fields in CNBC-Stratus section on ECM request
		| CNBC Stratus Slug    | Add slug at location  | 
		| slug name 34         | 1                         |
    When user selects fields in Content Description section on ECM request
		|Content Description|
		| CCD               |
		When user selects fields in Comments section on ECM request
		|Comments |
		|Commenting |
		And user clicks Submit button on request
  	Then user sees modal for successful "File Ingest" request creation
  	And  user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
  	When user selects fields in Content Description section on ECM request in edit mode
		|Content Description|
		| CCD               |
		When user selects fields in Comments section on ECM request in edit mode
		|Comments |
		|Commenting |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user selects fields in Content Description section on ECM request in edit mode
		|Content Description|
		| CCD - edited      |
		When user selects fields in Comments section on ECM request in edit mode
		|Comments |
		|Commenting |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user selects fields in Content Description section on ECM request in edit mode
		|Content Description|
		| CCD - edited      |
		When user selects fields in Comments section on ECM request in edit mode
		|Comments            |
		|Commenting - edited |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user selects fields in Content Description section on ECM request in edit mode
		|Content Description|
		| CCD - edited 2      |
		When user selects fields in Comments section on ECM request in edit mode
		|Comments              |
		|Commenting - edited 2 |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	
  	@NcxUnifiedToolPhase2 @PSEQA @Logs_043 @Logs_FileIngest
  Scenario: log verification for General Details, Additional Recipients, Producer Details sections in File Ingest request
  	And user clicks on forms link
  	And user selects "File Ingest" form
  	When user selects fields in General Details section on ECM request
  		|Division  |Slug    |
  		|CNBC      |Testing |
  	When user clicks `+ Additional Recipient` button on ECM request
  	When user selects fields in Additional Recipients(s) section on ECM request
    	| Email                     |Position      |
    	| mohit.bambani@nbcuni.com  |0             |
    When user clicks `+ Additional Recipient` button on ECM request
    When user selects fields in Additional Recipients(s) section on ECM request
    	| Email                     |Position      |
    	| mohit.bambani@nbcuni.com  |1             |
    When user selects fields in Producer Details section on ECM request
     	|Req same as producer  | Producer      | Senior Producer   |
			|No                    | Bambani, Mohit| Bambani, Mohit    |
    When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name  | Days from today   | Time   | Flexible    | To Be Determined   |
		|0      | CNBC - Affiliates          | 4                 | 1:00 PM| No          | No                 |
		When user clicks `+ Show Unit` button on ECM request
    When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name    |
		|1      | CNBC - Biz Day - Projects    |
		When user selects fields in Date & Time Needed section on ECM request
		|Days from today | Time   | Flexible | ASAP|
		| 5              | 4:00 PM| No       | No  | 
    When user selects fields in Sources section on File Ingest request
  	| Source Index  | Source  | Qty | Comments  | Select Camera Index | Camera Type  |
		| 0             | Cfast   | 5   | Cfast Comm| 0                   | Canon 5D Mark II |
		When user clicks `+ Camera Type` button on ECM request
		| Source Index  |
		| 0             |
    When user selects fields in Sources section on File Ingest request
  	| Source Index  | Select Camera Index | Camera Type  |
		| 0             | 1                   | Canon C300 Mark I |
  	When user selects Destinations on File Ingest request
  	| Destinations                                         |
  	| Nimbus, DC Network News, CNBC - AVID, CNBC - Stratus |
  	When user selects fields in Nimbus section on ECM request
    	|Details        |Transcode Needed?     |
    	|Nimbus 3000    |Yes                   |
		When user selects fields in DC Network News section on ECM request
		|Need Material Archived? |
		|No                      |
		When user selects fields in CNBC-Avid section on ECM request
		|AVID Workspace           | AVID Project Name | Bin Name    | Add bin name at location  | 
		|Marketing Ingest Elements| avj               | bin name 33 | 0                         |
		When user clicks `+ Bin Name` button on ECM request
		When user selects fields in CNBC-Avid section on ECM request
		| Bin Name    | Add bin name at location  | 
		| bin name 34 | 1                         |
		When user selects fields in CNBC-Stratus section on ECM request
		|Source Compression  | Source Frame Rate | Time Codes                                        | CNBC Stratus Slug    | Add slug at location  | 
		|H.264               | 29.97p            | Merging Together Clips Without Retaining Time Code| slug name 33         | 0                     | 
		When user clicks `+ Slug` button on ECM request
		When user selects fields in CNBC-Stratus section on ECM request
		| CNBC Stratus Slug    | Add slug at location  | 
		| slug name 34         | 1                         |
    When user selects fields in Content Description section on ECM request
		|Content Description|
		| CCD               |
		When user selects fields in Comments section on ECM request
		|Comments |
		|Commenting |
		And user clicks Submit button on request
  	Then user sees modal for successful "File Ingest" request creation
  	And  user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
  	When user clicks `+ Additional Recipient` button on ECM request
  	When user selects fields in Additional Recipients(s) section on ECM request in edit mode
    	| Email                     |Position      |
    	| mohit.bambani@nbcuni.com  |2             |
    When user clicks `+ Additional Recipient` button on ECM request
  	When user selects fields in Additional Recipients(s) section on ECM request in edit mode
    	| Email                     |Position      |
    	| mohit.bambani@nbcuni.com  |3             |
    When user selects fields in Additional Recipients(s) section on ECM request in edit mode
    	|Remove email from position |
    	|0                          |
   	When user selects fields in Additional Recipients(s) section on ECM request in edit mode
    	|Remove email from position |
    	|0                          |
    When user selects fields in Producer Details section on ECM request in edit mode
     	|Req same as producer  | Senior Producer   |
			|Yes                   | R, Jeevanandham   |
		When user selects fields in Producer Details section on ECM request in edit mode
     	|Req same as producer  | Senior Producer   | Producer          |
			|No                    | Bambani, Mohit    | Bambani, Mohit    |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user clicks `+ Additional Recipient` button on ECM request
  	When user selects fields in Additional Recipients(s) section on ECM request in edit mode
    	| Email                     |Position      |
    	| mohit.bambani@nbcuni.com  |2             |
    When user selects fields in General Details section on ECM request in edit mode
  		|Division  |
  		|NBC News  |
  	When user selects fields in Producer Details section on ECM request in edit mode
     	|Req same as producer  |
			|Yes                   |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
    When user selects fields in Additional Recipients(s) section on ECM request in edit mode
    	|Remove email from position |
    	|1                          |
    When user selects fields in General Details section on ECM request in edit mode
  		|Slug|
  		|NBC |
  	When user selects fields in Producer Details section on ECM request in edit mode
     	| Senior Producer   |
			| R, Jeevanandham   |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user clicks `+ Additional Recipient` button on ECM request
  	When user selects fields in Additional Recipients(s) section on ECM request in edit mode
    	| Email                     |Position      |
    	| mohit.bambani@nbcuni.com  |2             |
    When user selects fields in General Details section on ECM request in edit mode
  		|Slug |
  		|Test |
  	When user selects fields in Producer Details section on ECM request in edit mode
     	|Req same as producer  | Producer          |
			|No                    | R, Jeevanandham   |
    When user clicks `+ Additional Recipient` button on ECM request
  	When user selects fields in Additional Recipients(s) section on ECM request in edit mode
    	| Email                     |Position      |
    	| mohit.bambani@nbcuni.com  |3             |
    When user selects fields in General Details section on ECM request in edit mode
  		|Slug    |Division|
  		|Testing |CNBC    |
  	When user selects fields in Producer Details section on ECM request in edit mode
     	| Producer          | Senior Producer  |
			| Bambani, Mohit    |Bambani, Mohit    |
    When user clicks `+ Additional Recipient` button on ECM request
  	When user selects fields in Additional Recipients(s) section on ECM request in edit mode
    	| Email                     |Position      |
    	| mohit.bambani@nbcuni.com  |4             |
    When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
    When user selects fields in Additional Recipients(s) section on ECM request in edit mode
    	|Remove email from position |
    	|1                          |
    When user selects fields in Additional Recipients(s) section on ECM request in edit mode
    	|Remove email from position |
    	|2                          |
    When user selects fields in Additional Recipients(s) section on ECM request in edit mode
    	|Remove email from position |
    	|2                          |
    When user selects fields in Additional Recipients(s) section on ECM request in edit mode
    	|Remove email from position |
    	|0                          |
    When user selects fields in Additional Recipients(s) section on ECM request in edit mode
    	|Remove email from position |
    	|0                          |
    When user selects fields in General Details section on ECM request in edit mode
  		|Slug|Division   |
  		|NBC |NBC News   |
  	When user selects fields in Producer Details section on ECM request in edit mode
     	| Req same as producer|
			| Yes                 |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	
  	@NcxUnifiedToolPhase2 @PSEQA @Logs_044 @Logs_FileIngest
  Scenario: Logs verification for  Talent and Requesters section changes on File Ingest request
  	And user clicks on forms link
  	And user selects "File Ingest" form
  	When user selects fields in General Details section on ECM request
  		|Division  |Slug    |
  		|CNBC      |Testing |
  	When user clicks `+ Additional Recipient` button on ECM request
  	When user selects fields in Additional Recipients(s) section on ECM request
    	| Email                     |Position      |
    	| mohit.bambani@nbcuni.com  |0             |
    When user selects fields in Producer Details section on ECM request
     	|Req same as producer  | Producer      | Senior Producer   |
			|No                    | Bambani, Mohit| Bambani, Mohit    |
    When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name  | Days from today   | Time   | Flexible    | To Be Determined   |
		|0      | CNBC - Affiliates          | 4                 | 1:00 PM| No          | No                 |
		When user clicks `+ Show Unit` button on ECM request
    When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name    |
		|1      | CNBC - Biz Day - Projects    |
		When user selects fields in Date & Time Needed section on ECM request
		|Days from today | Time   | Flexible | ASAP|
		| 5              | 4:00 PM| No       | No  | 
    When user selects fields in Sources section on File Ingest request
  	| Source Index  | Source  | Qty | Comments  | Select Camera Index | Camera Type  |
		| 0             | Cfast   | 5   | Cfast Comm| 0                   | Canon 5D Mark II |
		When user clicks `+ Camera Type` button on ECM request
		| Source Index  |
		| 0             |
    When user selects fields in Sources section on File Ingest request
  	| Source Index  | Select Camera Index | Camera Type  |
		| 0             | 1                   | Canon C300 Mark I |
  	When user selects Destinations on File Ingest request
  	| Destinations                                         |
  	| Nimbus, DC Network News, CNBC - AVID, CNBC - Stratus |
  	When user selects fields in Nimbus section on ECM request
    	|Details        |Transcode Needed?     |
    	|Nimbus 3000    |Yes                   |
		When user selects fields in DC Network News section on ECM request
		|Need Material Archived? |
		|No                      |
		When user selects fields in CNBC-Avid section on ECM request
		|AVID Workspace           | AVID Project Name | Bin Name    | Add bin name at location  | 
		|Marketing Ingest Elements| avj               | bin name 33 | 0                         |
		When user clicks `+ Bin Name` button on ECM request
		When user selects fields in CNBC-Avid section on ECM request
		| Bin Name    | Add bin name at location  | 
		| bin name 34 | 1                         |
		When user selects fields in CNBC-Stratus section on ECM request
		|Source Compression  | Source Frame Rate | Time Codes                                        | CNBC Stratus Slug    | Add slug at location  | 
		|H.264               | 29.97p            | Merging Together Clips Without Retaining Time Code| slug name 33         | 0                     | 
		When user clicks `+ Slug` button on ECM request
		When user selects fields in CNBC-Stratus section on ECM request
		| CNBC Stratus Slug    | Add slug at location  | 
		| slug name 34         | 1                         |
    When user selects fields in Content Description section on ECM request
		|Content Description|
		| CCD               |
		When user selects fields in Comments section on ECM request
		|Comments |
		|Commenting |
		And user clicks Submit button on request
  	Then user sees modal for successful "File Ingest" request creation
  	And  user clicks on "ok" button
		When user opens the created request
    # validations for logs of Talent section field changes
		When user clicks Edit button on request
	  When user adds requester to the form in edit mode   	
	    |Requester       |
	    |Worker 2, STORM |
	  When user adds requester to the form in edit mode   	
	    |Requester       |
	    |Worker 11, STORM |
	  When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user adds specific user in Talent section in edit mode
  	  | Name     |
  	  | Velshi, Ali & Alba, Monica  |
	  When user removes requester to the form in edit mode   	
	    |Requester       |
	    |Worker 2, STORM & Worker 11, STORM |
	  When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
	  When user removes specific user in Talent section in edit mode
	  	| Name     |
	  	| Velshi, Ali & Alba, Monica  |
	  When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
	  When user adds requester to the form in edit mode
	  |Requester       |
	  |Worker 2, STORM |
	  When user adds specific user in Talent section in edit mode
  	  | Name     |
  	  | Velshi, Ali  |   	
	  When user removes requester to the form in edit mode   	
	    |Requester       |
	    |Worker 11, STORM |
	  When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
	  When user adds requester to the form in edit mode   	
	    |Requester       |
	    |Worker 11, STORM |
  	When user adds specific user in Talent section in edit mode
  	  | Name     |
  	  | Alba, Monica  |
  	When user removes specific user in Talent section in edit mode
  		|Name |
  		|Velshi, Ali|
	  When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
	  When user removes requester to the form in edit mode   	
	    |Requester        |
	    |Worker 11, STORM |
	  When user removes requester to the form in edit mode   	
	    |Requester       |
	    |Worker 2, STORM |
	  When user removes specific user in Talent section in edit mode
  		|Name |
  		|Alba, Monica|
	  When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	
  	@NcxUnifiedToolPhase2 @PSEQA @Logs_045 @Logs_FileIngest
	Scenario: Logs verification when Fulfiller clicks Cancel Request on newly created File Ingest Request
  	And user clicks on forms link
  	And user selects "File Ingest" form
  	When user selects fields in General Details section on ECM request
  		|Division  |Slug    |
  		|CNBC      |Testing |
  	When user clicks `+ Additional Recipient` button on ECM request
  	When user selects fields in Additional Recipients(s) section on ECM request
    	| Email                     |Position      |
    	| mohit.bambani@nbcuni.com  |0             |
    When user selects fields in Producer Details section on ECM request
     	|Req same as producer  | Producer      | Senior Producer   |
			|No                    | Bambani, Mohit| Bambani, Mohit    |
    When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name  | Days from today   | Time   | Flexible    | To Be Determined   |
		|0      | CNBC - Affiliates          | 4                 | 1:00 PM| No          | No                 |
		When user clicks `+ Show Unit` button on ECM request
    When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name    |
		|1      | CNBC - Biz Day - Projects    |
		When user selects fields in Date & Time Needed section on ECM request
		|Days from today | Time   | Flexible | ASAP|
		| 5              | 4:00 PM| No       | No  | 
    When user selects fields in Sources section on File Ingest request
  	| Source Index  | Source  | Qty | Comments  | Select Camera Index | Camera Type  |
		| 0             | Cfast   | 5   | Cfast Comm| 0                   | Canon 5D Mark II |
		When user clicks `+ Camera Type` button on ECM request
		| Source Index  |
		| 0             |
    When user selects fields in Sources section on File Ingest request
  	| Source Index  | Select Camera Index | Camera Type  |
		| 0             | 1                   | Canon C300 Mark I |
  	When user selects Destinations on File Ingest request
  	| Destinations                                         |
  	| Nimbus, DC Network News, CNBC - AVID, CNBC - Stratus |
  	When user selects fields in Nimbus section on ECM request
    	|Details        |Transcode Needed?     |
    	|Nimbus 3000    |Yes                   |
		When user selects fields in DC Network News section on ECM request
		|Need Material Archived? |
		|No                      |
		When user selects fields in CNBC-Avid section on ECM request
		|AVID Workspace           | AVID Project Name | Bin Name    | Add bin name at location  | 
		|Marketing Ingest Elements| avj               | bin name 33 | 0                         |
		When user clicks `+ Bin Name` button on ECM request
		When user selects fields in CNBC-Avid section on ECM request
		| Bin Name    | Add bin name at location  | 
		| bin name 34 | 1                         |
		When user selects fields in CNBC-Stratus section on ECM request
		|Source Compression  | Source Frame Rate | Time Codes                                        | CNBC Stratus Slug    | Add slug at location  | 
		|H.264               | 29.97p            | Merging Together Clips Without Retaining Time Code| slug name 33         | 0                     | 
		When user clicks `+ Slug` button on ECM request
		When user selects fields in CNBC-Stratus section on ECM request
		| CNBC Stratus Slug    | Add slug at location  | 
		| slug name 34         | 1                         |
    When user selects fields in Content Description section on ECM request
		|Content Description|
		| CCD               |
		When user selects fields in Comments section on ECM request
		|Comments |
		|Commenting |
		And user clicks Submit button on request
  	Then user sees modal for successful "File Ingest" request creation
  	And  user clicks on "ok" button
		Then user logs out from application
  	Given user opens producer dashboard application
    And user logins with "fulfiller" role
    When user opens the created request
    Then user clicks Cancel Request button on request
    When user opens the created request
		Then user verifies all Logs on request
		
		@NcxUnifiedToolPhase2 @PSEQA @Logs_046 @Logs_FileIngest
  Scenario: Logs verification when Producer clicks Cancel Request and then Fulfiller clicks Confirm Cancel Request on newly created File Ingest Request
  	And user clicks on forms link
  	And user selects "File Ingest" form
  	When user selects fields in General Details section on ECM request
  		|Division  |Slug    |
  		|CNBC      |Testing |
  	When user clicks `+ Additional Recipient` button on ECM request
  	When user selects fields in Additional Recipients(s) section on ECM request
    	| Email                     |Position      |
    	| mohit.bambani@nbcuni.com  |0             |
    When user selects fields in Producer Details section on ECM request
     	|Req same as producer  | Producer      | Senior Producer   |
			|No                    | Bambani, Mohit| Bambani, Mohit    |
    When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name  | Days from today   | Time   | Flexible    | To Be Determined   |
		|0      | CNBC - Affiliates          | 4                 | 1:00 PM| No          | No                 |
		When user clicks `+ Show Unit` button on ECM request
    When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name    |
		|1      | CNBC - Biz Day - Projects    |
		When user selects fields in Date & Time Needed section on ECM request
		|Days from today | Time   | Flexible | ASAP|
		| 5              | 4:00 PM| No       | No  | 
    When user selects fields in Sources section on File Ingest request
  	| Source Index  | Source  | Qty | Comments  | Select Camera Index | Camera Type  |
		| 0             | Cfast   | 5   | Cfast Comm| 0                   | Canon 5D Mark II |
		When user clicks `+ Camera Type` button on ECM request
		| Source Index  |
		| 0             |
    When user selects fields in Sources section on File Ingest request
  	| Source Index  | Select Camera Index | Camera Type  |
		| 0             | 1                   | Canon C300 Mark I |
  	When user selects Destinations on File Ingest request
  	| Destinations                                         |
  	| Nimbus, DC Network News, CNBC - AVID, CNBC - Stratus |
  	When user selects fields in Nimbus section on ECM request
    	|Details        |Transcode Needed?     |
    	|Nimbus 3000    |Yes                   |
		When user selects fields in DC Network News section on ECM request
		|Need Material Archived? |
		|No                      |
		When user selects fields in CNBC-Avid section on ECM request
		|AVID Workspace           | AVID Project Name | Bin Name    | Add bin name at location  | 
		|Marketing Ingest Elements| avj               | bin name 33 | 0                         |
		When user clicks `+ Bin Name` button on ECM request
		When user selects fields in CNBC-Avid section on ECM request
		| Bin Name    | Add bin name at location  | 
		| bin name 34 | 1                         |
		When user selects fields in CNBC-Stratus section on ECM request
		|Source Compression  | Source Frame Rate | Time Codes                                        | CNBC Stratus Slug    | Add slug at location  | 
		|H.264               | 29.97p            | Merging Together Clips Without Retaining Time Code| slug name 33         | 0                     | 
		When user clicks `+ Slug` button on ECM request
		When user selects fields in CNBC-Stratus section on ECM request
		| CNBC Stratus Slug    | Add slug at location  | 
		| slug name 34         | 1                         |
    When user selects fields in Content Description section on ECM request
		|Content Description|
		| CCD               |
		When user selects fields in Comments section on ECM request
		|Comments |
		|Commenting |
		And user clicks Submit button on request
  	Then user sees modal for successful "File Ingest" request creation
  	And  user clicks on "ok" button
  	When user opens the created request
		Then user clicks Cancel Request button on request
		When user opens the created request
		Then user verifies all Logs on request
		Then user logs out from application
  	Given user opens producer dashboard application
    And user logins with "fulfiller" role
    When user opens the created request
    Then user clicks Confirm Cancellation button on request
    When user opens the created request
		Then user verifies all Logs on request
		
		@NcxUnifiedToolPhase2 @PSEQA @Logs_047 @Logs_FileIngest
  Scenario: Logs verification when Requester and Fulfiller adds, edits or deletes notes on File Ingest Request
  	And user clicks on forms link
  	And user selects "File Ingest" form
  	When user selects fields in General Details section on ECM request
  		|Division  |Slug    |
  		|CNBC      |Testing |
  	When user clicks `+ Additional Recipient` button on ECM request
  	When user selects fields in Additional Recipients(s) section on ECM request
    	| Email                     |Position      |
    	| mohit.bambani@nbcuni.com  |0             |
    When user selects fields in Producer Details section on ECM request
     	|Req same as producer  | Senior Producer   |
			|Yes                   | Bambani, Mohit    |
    When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name  | Days from today   | Time   | Flexible    | To Be Determined   |
		|0      | CNBC - Affiliates          | 4                 | 1:00 PM| No          | No                 |
		When user clicks `+ Show Unit` button on ECM request
    When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name    |
		|1      | CNBC - Biz Day - Projects    |
		When user selects fields in Date & Time Needed section on ECM request
		|Days from today | Time   | Flexible | ASAP|
		| 5              | 4:00 PM| No       | No  | 
    When user selects fields in Sources section on File Ingest request
  	| Source Index  | Source  | Qty | Comments  | Select Camera Index | Camera Type  |
		| 0             | Cfast   | 5   | Cfast Comm| 0                   | Canon 5D Mark II |
		When user clicks `+ Camera Type` button on ECM request
		| Source Index  |
		| 0             |
    When user selects fields in Sources section on File Ingest request
  	| Source Index  | Select Camera Index | Camera Type  |
		| 0             | 1                   | Canon C300 Mark I |
  	When user selects Destinations on File Ingest request
  	| Destinations                                         |
  	| Nimbus, DC Network News, CNBC - AVID, CNBC - Stratus |
  	When user selects fields in Nimbus section on ECM request
    	|Details        |Transcode Needed?     |
    	|Nimbus 3000    |Yes                   |
		When user selects fields in DC Network News section on ECM request
		|Need Material Archived? |
		|No                      |
		When user selects fields in CNBC-Avid section on ECM request
		|AVID Workspace           | AVID Project Name | Bin Name    | Add bin name at location  | 
		|Marketing Ingest Elements| avj               | bin name 33 | 0                         |
		When user clicks `+ Bin Name` button on ECM request
		When user selects fields in CNBC-Avid section on ECM request
		| Bin Name    | Add bin name at location  | 
		| bin name 34 | 1                         |
		When user selects fields in CNBC-Stratus section on ECM request
		|Source Compression  | Source Frame Rate | Time Codes                                        | CNBC Stratus Slug    | Add slug at location  | 
		|H.264               | 29.97p            | Merging Together Clips Without Retaining Time Code| slug name 33         | 0                     | 
		When user clicks `+ Slug` button on ECM request
		When user selects fields in CNBC-Stratus section on ECM request
		| CNBC Stratus Slug    | Add slug at location  | 
		| slug name 34         | 1                         |
    When user selects fields in Content Description section on ECM request
		|Content Description|
		| CCD               |
		When user selects fields in Comments section on ECM request
		|Comments |
		|Commenting |
		And user clicks Submit button on request
  	Then user sees modal for successful "File Ingest" request creation
  	And  user clicks on "ok" button
  	When user opens the created request
		When user clicks Edit button on request
		When user switches to `Notes` tab in right container on Request
  	Then user adds 11 notes on request
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	Then user logs out from application
  	Given user opens producer dashboard application
    And user logins with "fulfiller" role
    When user opens the created request
    When user clicks Edit button on request
    When user switches to `Fulfillment` tab on ECM request
    When user selects fields in File Ingest fulfillment
		|Method of Ingest | Destinations  | File formats | Gig size |Clip count  | Folder formats  |Bin Name  | Media Id   |Assistant Editor   |
		|AMA, Root 6      | WG06          |.gif, .heic   | 9        |8           | XDROOT, DCIM    |bn        | mi-01      |Bambani, Mohit     |
		When user selects fields in CNBC-Stratus Ingest in File Ingest fulfillment
		|Ingest Complete? | Hours   | Minutes | Seconds | Transcoding Needed  | Transcode Complete?|
		| Yes             | 10      | 09      | 08      | Yes                 | Yes                |
		When user clicks `+ Bin Name` button in ECM Fulfillment
		When user clicks `+ Bin Name` button in ECM Fulfillment
		When user selects fields in CNBC-Avid Ingest in File Ingest fulfillment
		|Ingest Complete?|Hours   |Minutes   | Seconds  | Workspace     | Project   | Position   | Bin Name     |
		|Yes             | 9      |19        | 20       | News Projects | proj-01   | 0          | cnbc-avid-01 |
		When user selects fields in CNBC-Avid Ingest in File Ingest fulfillment
		| Position   | Bin Name     |
		| 1          | cnbc-avid-02 |
		When user selects fields in Timer in File Ingest fulfillment
		|Hours     | Minutes     | Seconds  |
		| 1        | 1           | 10       |
		When user selects fields in Comments in File Ingest fulfillment
		|Comments     |
		| com         |
		When user selects fields in Status in File Ingest fulfillment
		|Status       |
		| IN PROGRESS |
  	When user switches to `Notes` tab in right container on Request
  	Then user adds 11 notes on request
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	Then user logs out from application
  	Given user opens producer dashboard application
    And user logins with "producer" role
    When user opens the created request
		When user clicks Edit button on request
		When user switches to `Notes` tab in right container on Request
  	Then user edits notes on request randomly
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
		When user switches to `Notes` tab in right container on Request
  	Then user deletes notes on request randomly
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	Then user logs out from application
  	Given user opens producer dashboard application
    And user logins with "fulfiller" role
    When user opens the created request
		When user clicks Edit button on request
		When user switches to `Notes` tab in right container on Request
  	Then user edits notes on request randomly
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
		When user switches to `Notes` tab in right container on Request
  	Then user deletes notes on request randomly
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	
  	@NcxUnifiedToolPhase2 @PSEQA @Logs_048 @Logs_FeedOut
  Scenario: Logs verification when Producer clicks Cancel Request and then Fulfiller clicks Confirm Cancel Request on newly created Feed Out Request
  	And user clicks on forms link
  	And user selects "Feed Out" form
  	When user selects fields in General Details section on ECM request
  		|Division  |Slug    |
  		|CNBC      |Testing |
  	When user clicks `+ Additional Recipient` button on ECM request
  	When user selects fields in Additional Recipients(s) section on ECM request
    	| Email                     |Position      |
    	| mohit.bambani@nbcuni.com  |0             |
    When user selects fields in Producer Details section on ECM request
     	|Req same as producer  | Producer      | Senior Producer   |
			|No                    | Bambani, Mohit| Bambani, Mohit    |
		When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name  | Days from today   | Time   | Flexible    | To Be Determined   |
		|0      | CNBC - Affiliates          | 4                 | 1:00 PM| No          | No                 |
		When user clicks `+ Show Unit` button on ECM request
    When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name    |
		|1      | CNBC - Biz Day - Projects    |
		When user selects fields in Date & Time Needed section on ECM request
		|Days from today | Time   | Flexible | ASAP|
		| 5              | 4:00 PM| No       | No  | 
    When user selects fields in Sources section on Feed out request
  	| Source Index  | Source          | Qty | Comments  |
		| 0             | CNBC- Stratus   | 5   | Cfast Comm|
		When user selects CNBC-Stratus Slug(s) in Sources section on Feed out request
		| Source Index  | Slug Index   | Slug    |
		| 0             | 0            | Slug 1  |
		When user clicks `+ Stratus Slug` button on Feed out request
		| Source Index  |
		| 0             |
		When user selects CNBC-Stratus Slug(s) in Sources section on Feed out request
		| Source Index  | Slug Index   | Slug    |
		| 0             | 1            | Slug 2  |
  	When user selects Destinations on Feed out request
  	| Destinations                    |
  	| WG01, WG02, WG06, WG08, 30 Rock |
  	When user selects fields in Content Description section on ECM request
		|Content Description|
		| CCD               |
		When user selects fields in Comments section on ECM request
		|Comments |
		|Commenting |
		And user clicks Submit button on request
  	Then user sees modal for successful "Feed Out" request creation
  	And  user clicks on "ok" button
  	When user opens the created request
		Then user clicks Cancel Request button on request
		When user opens the created request
		Then user verifies all Logs on request
		Then user logs out from application
  	Given user opens producer dashboard application
    And user logins with "fulfiller" role
    When user opens the created request
    Then user clicks Confirm Cancellation button on request
    When user opens the created request
		Then user verifies all Logs on request
		
		@NcxUnifiedToolPhase2 @PSEQA @Logs_049 @Logs_FeedOut
  Scenario: log verification for Show Information section in Feed Out request
		And user clicks on forms link
  	And user selects "Feed Out" form
  	When user selects fields in General Details section on ECM request
  		|Division  |Slug    |
  		|CNBC      |Testing |
  	When user clicks `+ Additional Recipient` button on ECM request
  	When user selects fields in Additional Recipients(s) section on ECM request
    	| Email                     |Position      |
    	| mohit.bambani@nbcuni.com  |0             |
    When user selects fields in Producer Details section on ECM request
     	|Req same as producer  | Producer      | Senior Producer   |
			|No                    | Bambani, Mohit| Bambani, Mohit    |
		When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name  | Days from today   | Time   | Flexible    | To Be Determined   |
		|0      | CNBC - Affiliates          | 4                 | 1:00 PM| No          | No                 |
		When user clicks `+ Show Unit` button on ECM request
    When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name    |
		|1      | CNBC - Biz Day - Projects    |
		When user selects fields in Date & Time Needed section on ECM request
		|Days from today | Time   | Flexible | ASAP|
		| 5              | 4:00 PM| No       | No  | 
    When user selects fields in Sources section on Feed out request
  	| Source Index  | Source          | Qty | Comments  |
		| 0             | CNBC- Stratus   | 5   | Cfast Comm|
		When user selects CNBC-Stratus Slug(s) in Sources section on Feed out request
		| Source Index  | Slug Index   | Slug    |
		| 0             | 0            | Slug 1  |
		When user clicks `+ Stratus Slug` button on Feed out request
		| Source Index  |
		| 0             |
		When user selects CNBC-Stratus Slug(s) in Sources section on Feed out request
		| Source Index  | Slug Index   | Slug    |
		| 0             | 1            | Slug 2  |
  	When user selects Destinations on Feed out request
  	| Destinations                    |
  	| WG01, WG02, WG06, WG08, 30 Rock |
  	When user selects fields in Content Description section on ECM request
		|Content Description|
		| CCD               |
		When user selects fields in Comments section on ECM request
		|Comments |
		|Commenting |
		And user clicks Submit button on request
  	Then user sees modal for successful "Feed Out" request creation
  	And  user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
		When user clicks `+ Show Unit` button on ECM request
    When user selects fields in Show Information section on ECM request in edit mode
		|Index  | Show Unit or Project Name  |
		|2      | CNBC - Affiliates          |
		When user clicks `+ Show Unit` button on ECM request
    When user selects fields in Show Information section on ECM request in edit mode
		|Index  | Show Unit or Project Name    |
		|3      | CNBC - Biz Day - Projects    |
    When user selects fields in Show Information section on ECM request in edit mode
		|Remove show unit index|
		|0                     |
    When user selects fields in Show Information section on ECM request in edit mode
		|Remove show unit index|
		|0                     |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request 
		When user clicks Edit button on request
		When user selects fields in Show Information section on ECM request in edit mode
		| Flexible    |
		| Yes         |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request 
		When user clicks Edit button on request
		When user selects fields in Show Information section on ECM request in edit mode
		| To Be Determined   |
		| Yes                |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request 
		When user clicks Edit button on request
		When user selects fields in Show Information section on ECM request in edit mode
		|To Be Determined  |
		|No                |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request 
  	When user clicks Edit button on request
		When user selects fields in Show Information section on ECM request in edit mode
		| Days from today   |
		| 5                 |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
		When user clicks Edit button on request
    When user selects fields in Show Information section on ECM request in edit mode
		| Flexible    |
		| No          |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request 
  	When user clicks Edit button on request
    When user selects fields in Show Information section on ECM request in edit mode
		| Time   |
		| 1:00 PM|
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request 
  	When user clicks Edit button on request
  	When user clears Air Date on ECM request in edit mode
		When user selects fields in Show Information section on ECM request in edit mode
		| Days from today   |
		| 10                 |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user clears Air Time on ECM request in edit mode
    When user selects fields in Show Information section on ECM request in edit mode
		| Time   |
		| 3:00 PM|
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request 
  	When user clicks Edit button on request
    When user selects fields in Show Information section on ECM request in edit mode
		| Flexible |To Be Determined|
		| Yes      |Yes             |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
    When user selects fields in Show Information section on ECM request in edit mode
		| Flexible |To Be Determined|Time    |Days from today|
		| No       |No              |1:00 PM |7              |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request 
  	When user clicks Edit button on request
  	When user clears Air Time on ECM request in edit mode
  	When user clears Air Date on ECM request in edit mode
    When user selects fields in Show Information section on ECM request in edit mode
		|Time    |Days from today|
		|2:00 PM |9              |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user selects fields in Show Information section on ECM request in edit mode
		|Remove show unit index|
		|0                     |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user clicks `+ Show Unit` button on ECM request
    When user selects fields in Show Information section on ECM request in edit mode
		|Index  | Show Unit or Project Name    |
		|1      | CNBC - Biz Day - Projects    |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user selects fields in Show Information section on ECM request in edit mode
		|Remove show unit index|
		|0                     |
		When user selects fields in Show Information section on ECM request in edit mode
		|Remove show unit index|
		|0                     |
		When user selects fields in Show Information section on ECM request in edit mode
		|Index  | Show Unit or Project Name  |
		|0      | CNBC - Archives            |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user selects fields in Show Information section on ECM request in edit mode
		|Remove show unit index|
		|0                     |
		When user clears Air Time on ECM request in edit mode
		When user selects fields in Show Information section on ECM request in edit mode
		|Index  | Show Unit or Project Name  |To Be Determined|Time   |
		|0      | CNBC - Affiliates          |Yes             |8:00 PM|
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user clears Air Time on ECM request in edit mode
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user selects fields in Show Information section on ECM request in edit mode
		|To Be Determined|Days from today |
		|No              |8               |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user clears Air Date on ECM request in edit mode
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	
  	@NcxUnifiedToolPhase2 @PSEQA @Logs_050 @Logs_FeedOut
  Scenario: log verification for Date & Time Needed section in Feed out request
  	And user clicks on forms link
  	And user selects "Feed Out" form
  	When user selects fields in General Details section on ECM request
  		|Division  |Slug    |
  		|CNBC      |Testing |
  	When user clicks `+ Additional Recipient` button on ECM request
  	When user selects fields in Additional Recipients(s) section on ECM request
    	| Email                     |Position      |
    	| mohit.bambani@nbcuni.com  |0             |
    When user selects fields in Producer Details section on ECM request
     	|Req same as producer  | Producer      | Senior Producer   |
			|No                    | Bambani, Mohit| Bambani, Mohit    |
		When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name  | Days from today   | Time   | Flexible    | To Be Determined   |
		|0      | CNBC - Affiliates          | 4                 | 1:00 PM| No          | No                 |
		When user clicks `+ Show Unit` button on ECM request
    When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name    |
		|1      | CNBC - Biz Day - Projects    |
		When user selects fields in Date & Time Needed section on ECM request
		|Days from today | Time   | Flexible | ASAP|
		| 5              | 4:00 PM| No       | No  | 
    When user selects fields in Sources section on Feed out request
  	| Source Index  | Source          | Qty | Comments  |
		| 0             | CNBC- Stratus   | 5   | Cfast Comm|
		When user selects CNBC-Stratus Slug(s) in Sources section on Feed out request
		| Source Index  | Slug Index   | Slug    |
		| 0             | 0            | Slug 1  |
		When user clicks `+ Stratus Slug` button on Feed out request
		| Source Index  |
		| 0             |
		When user selects CNBC-Stratus Slug(s) in Sources section on Feed out request
		| Source Index  | Slug Index   | Slug    |
		| 0             | 1            | Slug 2  |
  	When user selects Destinations on Feed out request
  	| Destinations                    |
  	| WG01, WG02, WG06, WG08, 30 Rock |
  	When user selects fields in Content Description section on ECM request
		|Content Description|
		| CCD               |
		When user selects fields in Comments section on ECM request
		|Comments |
		|Commenting |
		And user clicks Submit button on request
  	Then user sees modal for successful "Feed Out" request creation
  	And  user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
    When user selects fields in Date & Time Needed section on ECM request in edit mode
		| Flexible | ASAP|
		| Yes      | Yes | 
    When user selects fields in Date & Time Needed section on ECM request in edit mode
		| Flexible | ASAP|Days from today|Time    |
		| No       | No  | 5             |4:00 PM |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request 
		When user clicks Edit button on request
		When user selects fields in Date & Time Needed section on ECM request in edit mode
		| Flexible |
		| Yes      |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request 
		When user clicks Edit button on request
		When user selects fields in Date & Time Needed section on ECM request in edit mode
		| ASAP       |
		| Yes        |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request 
		When user clicks Edit button on request
		When user selects fields in Date & Time Needed section on ECM request in edit mode
		| ASAP|Days from today|
		| No  | 5             |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request 
  	When user clicks Edit button on request
  	When user clears Date Needed By on ECM request
		When user selects fields in Date & Time Needed section on ECM request in edit mode
		|Days from today|
		| 6             |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
		When user clicks Edit button on request
    When user selects fields in Date & Time Needed section on ECM request in edit mode
		| Flexible |Time    |
		| No       |4:00 PM |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request 
  	When user clicks Edit button on request
  	When user clears Time Needed By on ECM request
    When user selects fields in Date & Time Needed section on ECM request in edit mode
		|Time    |
		|5:00 PM |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request 
  	When user clicks Edit button on request
  	When user clears Date Needed By on ECM request
		When user selects fields in Date & Time Needed section on ECM request in edit mode
		| Days from today   |
		| 10                 |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user clears Time Needed By on ECM request
    When user selects fields in Date & Time Needed section on ECM request in edit mode
		| Time   |
		| 3:00 PM|
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request 
  	When user clicks Edit button on request
    When user selects fields in Date & Time Needed section on ECM request in edit mode
		| Flexible |ASAP        |
		| Yes      |Yes         |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
    When user selects fields in Date & Time Needed section on ECM request in edit mode
		| Flexible | ASAP|Days from today|Time    |
		| No       | No  | 5             |4:00 PM |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request 
  	When user clicks Edit button on request
  	When user clears Date Needed By on ECM request
  	When user clears Time Needed By on ECM request
    When user selects fields in Date & Time Needed section on ECM request in edit mode
		|Days from today|Time    |
		| 5             |4:00 PM |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user clears Date Needed By on ECM request
    When user selects fields in Date & Time Needed section on ECM request in edit mode
		|Days from today|Flexible    |
		| 6             |Yes         |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
    When user selects fields in Date & Time Needed section on ECM request in edit mode
		|ASAP|
		|Yes |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	
  	@NcxUnifiedToolPhase2 @PSEQA @Logs_051 @Logs_FeedOut
  Scenario: log verification for Comments, Content Description sections in Feed out request
  	And user clicks on forms link
  	And user selects "Feed Out" form
  	When user selects fields in General Details section on ECM request
  		|Division  |Slug    |
  		|CNBC      |Testing |
  	When user clicks `+ Additional Recipient` button on ECM request
  	When user selects fields in Additional Recipients(s) section on ECM request
    	| Email                     |Position      |
    	| mohit.bambani@nbcuni.com  |0             |
    When user selects fields in Producer Details section on ECM request
     	|Req same as producer  | Producer      | Senior Producer   |
			|No                    | Bambani, Mohit| Bambani, Mohit    |
		When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name  | Days from today   | Time   | Flexible    | To Be Determined   |
		|0      | CNBC - Affiliates          | 4                 | 1:00 PM| No          | No                 |
		When user clicks `+ Show Unit` button on ECM request
    When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name    |
		|1      | CNBC - Biz Day - Projects    |
		When user selects fields in Date & Time Needed section on ECM request
		|Days from today | Time   | Flexible | ASAP|
		| 5              | 4:00 PM| No       | No  | 
    When user selects fields in Sources section on Feed out request
  	| Source Index  | Source          | Qty | Comments  |
		| 0             | CNBC- Stratus   | 5   | Cfast Comm|
		When user selects CNBC-Stratus Slug(s) in Sources section on Feed out request
		| Source Index  | Slug Index   | Slug    |
		| 0             | 0            | Slug 1  |
		When user clicks `+ Stratus Slug` button on Feed out request
		| Source Index  |
		| 0             |
		When user selects CNBC-Stratus Slug(s) in Sources section on Feed out request
		| Source Index  | Slug Index   | Slug    |
		| 0             | 1            | Slug 2  |
  	When user selects Destinations on Feed out request
  	| Destinations                    |
  	| WG01, WG02, WG06, WG08, 30 Rock |
  	When user selects fields in Content Description section on ECM request
		|Content Description|
		| CCD               |
		When user selects fields in Comments section on ECM request
		|Comments |
		|Commenting |
		And user clicks Submit button on request
  	Then user sees modal for successful "Feed Out" request creation
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
  	When user selects fields in Content Description section on ECM request in edit mode
		|Content Description|
		| CCD               |
		When user selects fields in Comments section on ECM request in edit mode
		|Comments |
		|Commenting |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user selects fields in Content Description section on ECM request in edit mode
		|Content Description|
		| CCD - edited      |
		When user selects fields in Comments section on ECM request in edit mode
		|Comments |
		|Commenting |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user selects fields in Content Description section on ECM request in edit mode
		|Content Description|
		| CCD - edited      |
		When user selects fields in Comments section on ECM request in edit mode
		|Comments            |
		|Commenting - edited |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user selects fields in Content Description section on ECM request in edit mode
		|Content Description|
		| CCD - edited 2      |
		When user selects fields in Comments section on ECM request in edit mode
		|Comments              |
		|Commenting - edited 2 |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	
  	@NcxUnifiedToolPhase2 @PSEQA @Logs_052 @Logs_FeedOut
  Scenario: log verification for General Details, Additional Recipients, Producer Details sections in Feed out request
	And user clicks on forms link
  	And user selects "Feed Out" form
  	When user selects fields in General Details section on ECM request
  		|Division  |Slug    |
  		|CNBC      |Testing |
  	When user clicks `+ Additional Recipient` button on ECM request
  	When user selects fields in Additional Recipients(s) section on ECM request
    	| Email                     |Position      |
    	| mohit.bambani@nbcuni.com  |0             |
    When user selects fields in Producer Details section on ECM request
     	|Req same as producer  | Producer      | Senior Producer   |
			|No                    | Bambani, Mohit| Bambani, Mohit    |
		When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name  | Days from today   | Time   | Flexible    | To Be Determined   |
		|0      | CNBC - Affiliates          | 4                 | 1:00 PM| No          | No                 |
		When user clicks `+ Show Unit` button on ECM request
    When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name    |
		|1      | CNBC - Biz Day - Projects    |
		When user selects fields in Date & Time Needed section on ECM request
		|Days from today | Time   | Flexible | ASAP|
		| 5              | 4:00 PM| No       | No  | 
    When user selects fields in Sources section on Feed out request
  	| Source Index  | Source          | Qty | Comments  |
		| 0             | CNBC- Stratus   | 5   | Cfast Comm|
		When user selects CNBC-Stratus Slug(s) in Sources section on Feed out request
		| Source Index  | Slug Index   | Slug    |
		| 0             | 0            | Slug 1  |
		When user clicks `+ Stratus Slug` button on Feed out request
		| Source Index  |
		| 0             |
		When user selects CNBC-Stratus Slug(s) in Sources section on Feed out request
		| Source Index  | Slug Index   | Slug    |
		| 0             | 1            | Slug 2  |
  	When user selects Destinations on Feed out request
  	| Destinations                    |
  	| WG01, WG02, WG06, WG08, 30 Rock |
  	When user selects fields in Content Description section on ECM request
		|Content Description|
		| CCD               |
		When user selects fields in Comments section on ECM request
		|Comments |
		|Commenting |
		And user clicks Submit button on request
  	Then user sees modal for successful "Feed Out" request creation
  	And  user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
  	When user clicks `+ Additional Recipient` button on ECM request
  	When user selects fields in Additional Recipients(s) section on ECM request in edit mode
    	| Email                     |Position      |
    	| mohit.bambani@nbcuni.com  |1             |
    When user clicks `+ Additional Recipient` button on ECM request
  	When user selects fields in Additional Recipients(s) section on ECM request in edit mode
    	| Email                     |Position      |
    	| mohit.bambani@nbcuni.com  |2             |
    When user selects fields in Additional Recipients(s) section on ECM request in edit mode
    	|Remove email from position |
    	|0                          |
   	When user selects fields in Additional Recipients(s) section on ECM request in edit mode
    	|Remove email from position |
    	|0                          |
    When user selects fields in Producer Details section on ECM request in edit mode
     	|Req same as producer  | Senior Producer   |
			|Yes                   | R, Jeevanandham   |
		When user selects fields in Producer Details section on ECM request in edit mode
     	|Req same as producer  | Senior Producer   | Producer          |
			|No                    | Bambani, Mohit    | Bambani, Mohit    |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user clicks `+ Additional Recipient` button on ECM request
  	When user selects fields in Additional Recipients(s) section on ECM request in edit mode
    	| Email                     |Position      |
    	| mohit.bambani@nbcuni.com  |2             |
    When user selects fields in General Details section on ECM request in edit mode
  		|Division  |
  		|NBC News  |
  	When user selects fields in Producer Details section on ECM request in edit mode
     	|Req same as producer  |
			|Yes                   |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
    When user selects fields in Additional Recipients(s) section on ECM request in edit mode
    	|Remove email from position |
    	|1                          |
    When user selects fields in General Details section on ECM request in edit mode
  		|Slug|
  		|NBC |
  	When user selects fields in Producer Details section on ECM request in edit mode
     	| Senior Producer   |
			| R, Jeevanandham   |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user clicks `+ Additional Recipient` button on ECM request
  	When user selects fields in Additional Recipients(s) section on ECM request in edit mode
    	| Email                     |Position      |
    	| mohit.bambani@nbcuni.com  |1             |
    When user selects fields in General Details section on ECM request in edit mode
  		|Slug |
  		|Test |
  	When user selects fields in Producer Details section on ECM request in edit mode
     	|Req same as producer  | Producer          |
			|No                    | R, Jeevanandham   |
    When user clicks `+ Additional Recipient` button on ECM request
  	When user selects fields in Additional Recipients(s) section on ECM request in edit mode
    	| Email                     |Position      |
    	| mohit.bambani@nbcuni.com  |2             |
    When user selects fields in General Details section on ECM request in edit mode
  		|Slug    |Division|
  		|Testing |CNBC    |
  	When user selects fields in Producer Details section on ECM request in edit mode
     	| Producer          | Senior Producer  |
			| Bambani, Mohit    |Bambani, Mohit    |
    When user clicks `+ Additional Recipient` button on ECM request
  	When user selects fields in Additional Recipients(s) section on ECM request in edit mode
    	| Email                     |Position      |
    	| mohit.bambani@nbcuni.com  |3             |
    When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
    When user selects fields in Additional Recipients(s) section on ECM request in edit mode
    	|Remove email from position |
    	|1                          |
    When user selects fields in Additional Recipients(s) section on ECM request in edit mode
    	|Remove email from position |
    	|2                          |
    When user selects fields in Additional Recipients(s) section on ECM request in edit mode
    	|Remove email from position |
    	|0                          |
    When user selects fields in Additional Recipients(s) section on ECM request in edit mode
    	|Remove email from position |
    	|0                          |
    When user selects fields in General Details section on ECM request in edit mode
  		|Slug|Division   |
  		|NBC |NBC News   |
  	When user selects fields in Producer Details section on ECM request in edit mode
     	| Req same as producer|
			| Yes                 |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	
  	@NcxUnifiedToolPhase2 @PSEQA @Logs_053 @Logs_FeedOut
  Scenario: Logs verification for  Talent and Requesters section changes on Feed out request
  	And user clicks on forms link
  	And user selects "Feed Out" form
  	When user selects fields in General Details section on ECM request
  		|Division  |Slug    |
  		|CNBC      |Testing |
  	When user clicks `+ Additional Recipient` button on ECM request
  	When user selects fields in Additional Recipients(s) section on ECM request
    	| Email                     |Position      |
    	| mohit.bambani@nbcuni.com  |0             |
    When user selects fields in Producer Details section on ECM request
     	|Req same as producer  | Producer      | Senior Producer   |
			|No                    | Bambani, Mohit| Bambani, Mohit    |
		When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name  | Days from today   | Time   | Flexible    | To Be Determined   |
		|0      | CNBC - Affiliates          | 4                 | 1:00 PM| No          | No                 |
		When user clicks `+ Show Unit` button on ECM request
    When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name    |
		|1      | CNBC - Biz Day - Projects    |
		When user selects fields in Date & Time Needed section on ECM request
		|Days from today | Time   | Flexible | ASAP|
		| 5              | 4:00 PM| No       | No  | 
    When user selects fields in Sources section on Feed out request
  	| Source Index  | Source          | Qty | Comments  |
		| 0             | CNBC- Stratus   | 5   | Cfast Comm|
		When user selects CNBC-Stratus Slug(s) in Sources section on Feed out request
		| Source Index  | Slug Index   | Slug    |
		| 0             | 0            | Slug 1  |
		When user clicks `+ Stratus Slug` button on Feed out request
		| Source Index  |
		| 0             |
		When user selects CNBC-Stratus Slug(s) in Sources section on Feed out request
		| Source Index  | Slug Index   | Slug    |
		| 0             | 1            | Slug 2  |
  	When user selects Destinations on Feed out request
  	| Destinations                    |
  	| WG01, WG02, WG06, WG08, 30 Rock |
  	When user selects fields in Content Description section on ECM request
		|Content Description|
		| CCD               |
		When user selects fields in Comments section on ECM request
		|Comments |
		|Commenting |
		And user clicks Submit button on request
  	Then user sees modal for successful "Feed Out" request creation
  	And  user clicks on "ok" button
		When user opens the created request
    # validations for logs of Talent section field changes
		When user clicks Edit button on request
	  When user adds requester to the form in edit mode   	
	    |Requester       |
	    |Worker 2, STORM |
	  When user adds requester to the form in edit mode   	
	    |Requester       |
	    |Worker 11, STORM |
	  When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user adds specific user in Talent section in edit mode
  	  | Name     |
  	  | Velshi, Ali & Alba, Monica  |
	  When user removes requester to the form in edit mode   	
	    |Requester       |
	    |Worker 2, STORM & Worker 11, STORM |
	  When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
	  When user removes specific user in Talent section in edit mode
	  	| Name     |
	  	| Velshi, Ali & Alba, Monica  |
	  When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
	  When user adds requester to the form in edit mode
	  |Requester       |
	  |Worker 2, STORM |
	  When user adds specific user in Talent section in edit mode
  	  | Name     |
  	  | Velshi, Ali  |   	
	  When user removes requester to the form in edit mode   	
	    |Requester       |
	    |Worker 11, STORM |
	  When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
	  When user adds requester to the form in edit mode   	
	    |Requester       |
	    |Worker 11, STORM |
  	When user adds specific user in Talent section in edit mode
  	  | Name     |
  	  | Alba, Monica  |
  	When user removes specific user in Talent section in edit mode
  		|Name |
  		|Velshi, Ali|
	  When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
	  When user removes requester to the form in edit mode   	
	    |Requester        |
	    |Worker 11, STORM |
	  When user removes requester to the form in edit mode   	
	    |Requester       |
	    |Worker 2, STORM |
	  When user removes specific user in Talent section in edit mode
  		|Name |
  		|Alba, Monica|
	  When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	
  	@NcxUnifiedToolPhase2 @PSEQA @Logs_054 @Logs_FeedOut
	Scenario: Logs verification when Fulfiller clicks Cancel Request on newly created Feed Out Request
  	And user clicks on forms link
  	And user selects "Feed Out" form
  	When user selects fields in General Details section on ECM request
  		|Division  |Slug    |
  		|CNBC      |Testing |
  	When user clicks `+ Additional Recipient` button on ECM request
  	When user selects fields in Additional Recipients(s) section on ECM request
    	| Email                     |Position      |
    	| mohit.bambani@nbcuni.com  |0             |
    When user selects fields in Producer Details section on ECM request
     	|Req same as producer  | Producer      | Senior Producer   |
			|No                    | Bambani, Mohit| Bambani, Mohit    |
		When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name  | Days from today   | Time   | Flexible    | To Be Determined   |
		|0      | CNBC - Affiliates          | 4                 | 1:00 PM| No          | No                 |
		When user clicks `+ Show Unit` button on ECM request
    When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name    |
		|1      | CNBC - Biz Day - Projects    |
		When user selects fields in Date & Time Needed section on ECM request
		|Days from today | Time   | Flexible | ASAP|
		| 5              | 4:00 PM| No       | No  | 
    When user selects fields in Sources section on Feed out request
  	| Source Index  | Source          | Qty | Comments  |
		| 0             | CNBC- Stratus   | 5   | Cfast Comm|
		When user selects CNBC-Stratus Slug(s) in Sources section on Feed out request
		| Source Index  | Slug Index   | Slug    |
		| 0             | 0            | Slug 1  |
		When user clicks `+ Stratus Slug` button on Feed out request
		| Source Index  |
		| 0             |
		When user selects CNBC-Stratus Slug(s) in Sources section on Feed out request
		| Source Index  | Slug Index   | Slug    |
		| 0             | 1            | Slug 2  |
  	When user selects Destinations on Feed out request
  	| Destinations                    |
  	| WG01, WG02, WG06, WG08, 30 Rock |
  	When user selects fields in Content Description section on ECM request
		|Content Description|
		| CCD               |
		When user selects fields in Comments section on ECM request
		|Comments |
		|Commenting |
		And user clicks Submit button on request
  	Then user sees modal for successful "Feed Out" request creation
  	And  user clicks on "ok" button
		Then user logs out from application
  	Given user opens producer dashboard application
    And user logins with "fulfiller" role
    When user opens the created request
    Then user clicks Cancel Request button on request
    When user opens the created request
		Then user verifies all Logs on request
		
		@NcxUnifiedToolPhase2 @PSEQA @Logs_055 @Logs_FeedOut
	Scenario: Logs verification for Sources section Feed Out Request
  	And user clicks on forms link
  	And user selects "Feed Out" form
  	When user selects fields in General Details section on ECM request
  		|Division  |Slug    |
  		|CNBC      |Testing |
  	When user clicks `+ Additional Recipient` button on ECM request
  	When user selects fields in Additional Recipients(s) section on ECM request
    	| Email                     |Position      |
    	| mohit.bambani@nbcuni.com  |0             |
    When user selects fields in Producer Details section on ECM request
     	|Req same as producer  | Senior Producer   |
			|Yes                   | Bambani, Mohit    |
		When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name  | Days from today   | Time   | Flexible    | To Be Determined   |
		|0      | CNBC - Affiliates          | 4                 | 1:00 PM| No          | No                 |
		When user clicks `+ Show Unit` button on ECM request
    When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name    |
		|1      | CNBC - Biz Day - Projects    |
		When user selects fields in Date & Time Needed section on ECM request
		|Days from today | Time   | Flexible | ASAP|
		| 5              | 4:00 PM| No       | No  |
		When user selects fields in Sources section on Feed out request
  	| Source Index  | Source          | Qty | Comments  |
		| 0             | CNBC- Stratus   | 5   | Cfast Comm|
		When user selects CNBC-Stratus Slug(s) in Sources section on Feed out request
		| Source Index  | Slug Index   | Slug    |
		| 0             | 0            | Slug 1  |
		When user clicks `+ Stratus Slug` button on Feed out request
		| Source Index  |
		| 0             |
		When user selects CNBC-Stratus Slug(s) in Sources section on Feed out request
		| Source Index  | Slug Index   | Slug    |
		| 0             | 1            | Slug 2  | 
  	When user selects Destinations on Feed out request
  	| Destinations                    |
  	| WG01, WG02, WG06, WG08, 30 Rock |
  	When user selects fields in Content Description section on ECM request
		|Content Description|
		| CCD               |
		When user selects fields in Comments section on ECM request
		|Comments |
		|Commenting |
		And user clicks Submit button on request
  	Then user sees modal for successful "Feed Out" request creation
  	And  user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
		When user clicks `+ Source` button on ECM request
  	When user selects fields in Sources section on Feed out request in edit mode
  	| Source Index  | Source  | Qty | Comments  |
		| 1             | CNBC- Stratus   | 5   | Cfast Comm|
		When user selects CNBC-Stratus Slug(s) in Sources section on Feed out request in edit mode
		| Source Index  | Slug Index   | Slug    |
		| 1             | 0            | Slug 1  |
		When user clicks `+ Stratus Slug` button on Feed out request
		| Source Index  |
		| 1             |
		When user selects CNBC-Stratus Slug(s) in Sources section on Feed out request in edit mode
		| Source Index  | Slug Index   | Slug    |
		| 1             | 1            | Slug 2  |
		When user removes Source section on ECM request in edit mode
		|Source Index |
		|0            |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user selects fields in Sources section on Feed out request in edit mode
  	| Source Index  | Source  |
		| 0             | Tapes |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user selects fields in Sources section on Feed out request in edit mode
  	| Source Index  | Qty |
		| 0             | 3   |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user selects fields in Sources section on Feed out request in edit mode
  	| Source Index  | Comments   |
		| 0             | Cfast2 Comm|
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user selects fields in Sources section on Feed out request in edit mode
  	| Source Index  | Source  |
		| 0             | CNBC- Stratus |
		When user selects CNBC-Stratus Slug(s) in Sources section on Feed out request in edit mode
		| Source Index  | Slug Index   | Slug    |
		| 0             | 0            | Slug 1 - edited  |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user clicks `+ Stratus Slug` button on Feed out request
		| Source Index  |
		| 0             |
  	When user selects CNBC-Stratus Slug(s) in Sources section on Feed out request in edit mode
		| Source Index  | Slug Index   | Slug    |
		| 0             | 1            | Slug 2 - edited  |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user clicks `+ Stratus Slug` button on Feed out request
		| Source Index  |
		| 0             |
  	When user selects CNBC-Stratus Slug(s) in Sources section on Feed out request in edit mode
		| Source Index  | Slug Index   | Slug    |
		| 0             | 2            | Slug 3 - edited  |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
		When user clicks `+ Stratus Slug` button on Feed out request
		| Source Index  |
		| 0             |
  	When user selects CNBC-Stratus Slug(s) in Sources section on Feed out request in edit mode
		| Source Index  | Slug Index   | Slug  |
		| 0             | 3            | Slug 4|
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
		When user clicks `+ Stratus Slug` button on Feed out request
		| Source Index  |
		| 0             |
  	When user selects CNBC-Stratus Slug(s) in Sources section on Feed out request in edit mode
		| Source Index  | Slug Index   | Slug    |
		| 0             | 4            | Slug 5  |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user clicks `+ Source` button on ECM request
  	When user selects fields in Sources section on Feed out request in edit mode
  	| Source Index  | Source  | Qty | Comments   |
		| 1             | Tapes | 4   | Cfast2 Comm|
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user clicks `+ Source` button on ECM request
  	When user selects fields in Sources section on Feed out request in edit mode
  	| Source Index  | Source  | Qty | Comments       |
		| 2             | CNBC- Stratus | 4   | Cfast2 Comm-e  |
		When user selects CNBC-Stratus Slug(s) in Sources section on Feed out request in edit mode
		| Source Index  | Slug Index   | Slug    |
		| 2             | 0            | Slug 21  |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user selects CNBC-Stratus Slug(s) in Sources section on Feed out request in edit mode
  	| Source Index  | Remove slug having index  |
		| 0             | 1                         |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
		When user clicks `+ Stratus Slug` button on Feed out request
		| Source Index  |
		| 2             |
    When user selects CNBC-Stratus Slug(s) in Sources section on Feed out request in edit mode
  	| Source Index  | Slug Index  | Slug    |
		| 2             | 1           | Slug 22 |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user selects CNBC-Stratus Slug(s) in Sources section on Feed out request in edit mode
  	| Source Index  | Remove slug having index  |
		| 2             | 0                         |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
		When user removes Source section on ECM request in edit mode
		|Source Index |
		|1            |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
		When user removes Source section on ECM request in edit mode
		|Source Index |
		|1            |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	
  	@NcxUnifiedToolPhase2 @PSEQA @Logs_056 @Logs_MTD
  Scenario: log verification for Sources section in MTD request
  	And user clicks on forms link
  	And user selects "Media Transcoding / Transferring / Duplication" form
  	When user selects fields in General Details section on ECM request
  		|Division  |Slug    |
  		|CNBC      |Testing |
    When user selects fields in Producer Details section on ECM request
     	|Req same as producer  | Producer      | Senior Producer   |
			|No                    | Bambani, Mohit| Bambani, Mohit    |
    When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name  | Days from today   | Time   | Flexible    | To Be Determined   |
		|0      | CNBC - Affiliates          | 4                 | 1:00 PM| No          | No                 |
		When user clicks `+ Show Unit` button on ECM request
    When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name    |
		|1      | CNBC - Biz Day - Projects    |
		When user selects fields in Date & Time Needed section on ECM request
		|Days from today | Time   | Flexible | ASAP|
		| 5              | 4:00 PM| No       | No  | 
    When user selects fields in Sources section on MTD request
  	| Source Index  | Source  | Source Details  |Time Codes                      | Select Camera Index | Camera Type  |
		| 0             | WG06    | Cfast Comm      |Matching Time Code For All Clips| 0                   | Canon 5D Mark II |
		When user clicks `+ Camera Type` button on ECM request
		| Source Index  |
		| 0             |
    When user selects fields in Sources section on MTD request
  	| Source Index  | Select Camera Index | Camera Type  |
		| 0             | 1                   | Canon C300 Mark II |
  	When user selects fields in Destinations section on MTD request
  	| Destination Index  | Destination  | Destination Details  | Qty |
		| 0                  | Media Shuttle| Cfast Comm           | 3   |
		When user selects fields in Instructions section on MTD request
		|Instructions |
		|Commenting   |
		And user clicks Submit button on request
  	Then user sees modal for successful "Media Transcoding/Transferring/Duplication" request creation
  	And  user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
		When user clicks `+ Source` button on ECM request
		When user selects fields in Sources section on MTD request in edit mode
  	| Source Index  | Source  | Source Details  |Time Codes                      | Select Camera Index | Camera Type  |
		| 1             | WG06    | Cfast Comm      |Matching Time Code For All Clips| 0                   | Canon 5D Mark II |
		When user clicks `+ Camera Type` button on ECM request
		| Source Index  |
		| 1             |
    When user selects fields in Sources section on MTD request in edit mode
  	| Source Index  | Select Camera Index | Camera Type  |
		| 1             | 1                   | Canon C300 Mark II |
		When user removes Source section on ECM request in edit mode
		|Source Index |
		|0            |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user selects fields in Sources section on MTD request in edit mode
  	| Source Index  | Source     | 
		| 0             | Hard Drive | 
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user selects fields in Sources section on MTD request in edit mode
  	| Source Index  | Source Details  |
		| 0             | Cfast           |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user selects fields in Sources section on MTD request in edit mode
  	| Source Index  |Time Codes                      |
		| 0             |Matching Time Code For All Clips|
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user selects fields in Sources section on MTD request in edit mode
  	| Source Index  |Time Codes                                        |
		| 0             |Merging Together Clips Without Retaining Time Code|
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user selects fields in Sources section on MTD request in edit mode
  	| Source Index  |Select Camera Index | Camera Type       |
		| 0             | 0                  | Canon 5D Mark III |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user selects fields in Sources section on MTD request in edit mode
  	| Source Index  |Select Camera Index | Camera Type      |
		| 0             | 1                  | Canon 5D Mark II |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
		When user clicks `+ Camera Type` button on ECM request
		| Source Index  |
		| 0             |
  	When user selects fields in Sources section on MTD request in edit mode
  	| Source Index  |Select Camera Index | Camera Type      |
		| 0             | 2                  | Canon 5D Mark II |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
		When user clicks `+ Camera Type` button on ECM request
		| Source Index  |
		| 0             |
  	When user selects fields in Sources section on MTD request in edit mode
  	| Source Index  |Select Camera Index | Camera Type      |
		| 0             | 3                  | Canon 5D Mark II |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user clicks `+ Source` button on ECM request
  	When user selects fields in Sources section on MTD request in edit mode
  	| Source Index  | Source  | Source Details   |Time Codes                       | Select Camera Index | Camera Type      |
		| 1             | WG02    | Cfast2 Comm      |Matching Time Code For All Clips | 0                   | Canon 5D Mark II |
		When user clicks `+ Camera Type` button on ECM request
		| Source Index  |
		| 1             |
    When user selects fields in Sources section on MTD request in edit mode
  	| Source Index  | Select Camera Index | Camera Type  |
		| 1             | 1                   | Canon C300 Mark II |
		When user selects fields in Sources section on MTD request in edit mode
  	| Source Index  | Select Camera Index | Camera Type  |
		| 1             | 2                   | Canon C300 Mark II |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user clicks `+ Source` button on ECM request
  	When user selects fields in Sources section on MTD request in edit mode
  	| Source Index  | Source            | Source Details | Select Camera Index | Camera Type      |Time Codes                                        |
		| 2             | Solid State Drive | Cfast2 Comm-e  | 0                   | Canon 5D Mark II |Merging Together Clips Without Retaining Time Code|
		When user clicks `+ Camera Type` button on ECM request
		| Source Index  |
		| 2             |
    When user selects fields in Sources section on MTD request in edit mode
  	| Source Index  | Select Camera Index | Camera Type  |
		| 2             | 1                   | Canon C300 Mark II |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user selects fields in Sources section on MTD request in edit mode
  	| Source Index  | Remove Camera Index  |
		| 1             | 1                    |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
		When user clicks `+ Camera Type` button on ECM request
		| Source Index  |
		| 2             |
    When user selects fields in Sources section on MTD request in edit mode
  	| Source Index  | Select Camera Index | Camera Type  |
		| 2             | 2                   | Canon C300 Mark II |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
		When user removes Source section on ECM request in edit mode
		|Source Index |
		|1            |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
		When user removes Source section on ECM request in edit mode
		|Source Index |
		|0            |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	
  	@NcxUnifiedToolPhase2 @PSEQA @Logs_057 @Logs_MTD
  Scenario: Logs verification when Producer clicks Cancel Request and then Fulfiller clicks Confirm Cancel Request on newly created MTD Request
  	And user clicks on forms link
  	And user selects "Media Transcoding / Transferring / Duplication" form
  	When user selects fields in General Details section on ECM request
  		|Division  |Slug    |
  		|CNBC      |Testing |
    When user selects fields in Producer Details section on ECM request
     	|Req same as producer  | Producer      | Senior Producer   |
			|No                    | Bambani, Mohit| Bambani, Mohit    |
    When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name  | Days from today   | Time   | Flexible    | To Be Determined   |
		|0      | CNBC - Affiliates          | 4                 | 1:00 PM| No          | No                 |
		When user clicks `+ Show Unit` button on ECM request
    When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name    |
		|1      | CNBC - Biz Day - Projects    |
		When user selects fields in Date & Time Needed section on ECM request
		|Days from today | Time   | Flexible | ASAP|
		| 5              | 4:00 PM| No       | No  | 
    When user selects fields in Sources section on MTD request
  	| Source Index  | Source  | Source Details  |Time Codes                      | Select Camera Index | Camera Type  |
		| 0             | WG06    | Cfast Comm      |Matching Time Code For All Clips| 0                   | Canon 5D Mark II |
		When user clicks `+ Camera Type` button on ECM request
		| Source Index  |
		| 0             |
    When user selects fields in Sources section on MTD request
  	| Source Index  | Select Camera Index | Camera Type  |
		| 0             | 1                   | Canon C300 Mark II |
  	When user selects fields in Destinations section on MTD request
  	| Destination Index  | Destination  | Destination Details  | Qty |
		| 0                  | Media Shuttle| Cfast Comm           | 4   |
		When user selects fields in Instructions section on MTD request
		|Instructions |
		|Commenting   |
		And user clicks Submit button on request
  	Then user sees modal for successful "Media Transcoding/Transferring/Duplication" request creation
  	And  user clicks on "ok" button
  	When user opens the created request
		Then user clicks Cancel Request button on request
		When user opens the created request
		Then user verifies all Logs on request
		Then user logs out from application
  	Given user opens producer dashboard application
    And user logins with "fulfiller" role
    When user opens the created request
    Then user clicks Confirm Cancellation button on request
    When user opens the created request
		Then user verifies all Logs on request
		
		@NcxUnifiedToolPhase2 @PSEQA @Logs_058 @Logs_MTD
  Scenario: log verification for Show Information section in MTD request
		And user clicks on forms link
  	And user selects "Media Transcoding / Transferring / Duplication" form
  	When user selects fields in General Details section on ECM request
  		|Division  |Slug    |
  		|CNBC      |Testing |
    When user selects fields in Producer Details section on ECM request
     	|Req same as producer  | Producer      | Senior Producer   |
			|No                    | Bambani, Mohit| Bambani, Mohit    |
    When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name  | Days from today   | Time   | Flexible    | To Be Determined   |
		|0      | CNBC - Affiliates          | 4                 | 1:00 PM| No          | No                 |
		When user clicks `+ Show Unit` button on ECM request
    When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name    |
		|1      | CNBC - Biz Day - Projects    |
		When user selects fields in Date & Time Needed section on ECM request
		|Days from today | Time   | Flexible | ASAP|
		| 5              | 4:00 PM| No       | No  | 
    When user selects fields in Sources section on MTD request
  	| Source Index  | Source  | Source Details  |Time Codes                      | Select Camera Index | Camera Type  |
		| 0             | WG06    | Cfast Comm      |Matching Time Code For All Clips| 0                   | Canon 5D Mark II |
		When user clicks `+ Camera Type` button on ECM request
		| Source Index  |
		| 0             |
    When user selects fields in Sources section on MTD request
  	| Source Index  | Select Camera Index | Camera Type  |
		| 0             | 1                   | Canon C300 Mark II |
  	When user selects fields in Destinations section on MTD request
  	| Destination Index  | Destination  | Destination Details  | Qty |
		| 0                  | Media Shuttle| Cfast Comm           | 4   |
		When user selects fields in Instructions section on MTD request
		|Instructions |
		|Commenting   |
		And user clicks Submit button on request
  	Then user sees modal for successful "Media Transcoding/Transferring/Duplication" request creation
  	And  user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
		When user clicks `+ Show Unit` button on ECM request
    When user selects fields in Show Information section on ECM request in edit mode
		|Index  | Show Unit or Project Name  |
		|2      | CNBC - Affiliates          |
		When user clicks `+ Show Unit` button on ECM request
    When user selects fields in Show Information section on ECM request in edit mode
		|Index  | Show Unit or Project Name    |
		|3      | CNBC - Biz Day - Projects    |
    When user selects fields in Show Information section on ECM request in edit mode
		|Remove show unit index|
		|0                     |
    When user selects fields in Show Information section on ECM request in edit mode
		|Remove show unit index|
		|0                     |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request 
		When user clicks Edit button on request
		When user selects fields in Show Information section on ECM request in edit mode
		| Flexible    |
		| Yes         |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request 
		When user clicks Edit button on request
		When user selects fields in Show Information section on ECM request in edit mode
		| To Be Determined   |
		| Yes                |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request 
		When user clicks Edit button on request
		When user selects fields in Show Information section on ECM request in edit mode
		|To Be Determined  |
		|No                |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request 
  	When user clicks Edit button on request
		When user selects fields in Show Information section on ECM request in edit mode
		| Days from today   |
		| 5                 |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
		When user clicks Edit button on request
    When user selects fields in Show Information section on ECM request in edit mode
		| Flexible    |
		| No          |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request 
  	When user clicks Edit button on request
    When user selects fields in Show Information section on ECM request in edit mode
		| Time   |
		| 1:00 PM|
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request 
  	When user clicks Edit button on request
  	When user clears Air Date on ECM request in edit mode
		When user selects fields in Show Information section on ECM request in edit mode
		| Days from today   |
		| 10                 |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user clears Air Time on ECM request in edit mode
    When user selects fields in Show Information section on ECM request in edit mode
		| Time   |
		| 3:00 PM|
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request 
  	When user clicks Edit button on request
    When user selects fields in Show Information section on ECM request in edit mode
		| Flexible |To Be Determined|
		| Yes      |Yes             |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
    When user selects fields in Show Information section on ECM request in edit mode
		| Flexible |To Be Determined|Time    |Days from today|
		| No       |No              |1:00 PM |7              |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request 
  	When user clicks Edit button on request
  	When user clears Air Time on ECM request in edit mode
  	When user clears Air Date on ECM request in edit mode
    When user selects fields in Show Information section on ECM request in edit mode
		|Time    |Days from today|
		|2:00 PM |9              |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user selects fields in Show Information section on ECM request in edit mode
		|Remove show unit index|
		|0                     |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user clicks `+ Show Unit` button on ECM request
    When user selects fields in Show Information section on ECM request in edit mode
		|Index  | Show Unit or Project Name    |
		|1      | CNBC - Biz Day - Projects    |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user selects fields in Show Information section on ECM request in edit mode
		|Remove show unit index|
		|0                     |
		When user selects fields in Show Information section on ECM request in edit mode
		|Remove show unit index|
		|0                     |
		When user selects fields in Show Information section on ECM request in edit mode
		|Index  | Show Unit or Project Name  |
		|0      | CNBC - Archives            |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user selects fields in Show Information section on ECM request in edit mode
		|Remove show unit index|
		|0                     |
		When user clears Air Time on ECM request in edit mode
		When user selects fields in Show Information section on ECM request in edit mode
		|Index  | Show Unit or Project Name  |To Be Determined|Time   |
		|0      | CNBC - Affiliates          |Yes             |8:00 PM|
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user clears Air Time on ECM request in edit mode
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user selects fields in Show Information section on ECM request in edit mode
		|To Be Determined|Days from today |
		|No              |8               |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user clears Air Date on ECM request in edit mode
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	
  	@NcxUnifiedToolPhase2 @PSEQA @Logs_059 @Logs_MTD
  Scenario: log verification for Date & Time Needed section in Feed out request
  	And user clicks on forms link
  	And user selects "Media Transcoding / Transferring / Duplication" form
  	When user selects fields in General Details section on ECM request
  		|Division  |Slug    |
  		|CNBC      |Testing |
    When user selects fields in Producer Details section on ECM request
     	|Req same as producer  | Producer      | Senior Producer   |
			|No                    | Bambani, Mohit| Bambani, Mohit    |
    When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name  | Days from today   | Time   | Flexible    | To Be Determined   |
		|0      | CNBC - Affiliates          | 4                 | 1:00 PM| No          | No                 |
		When user clicks `+ Show Unit` button on ECM request
    When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name    |
		|1      | CNBC - Biz Day - Projects    |
		When user selects fields in Date & Time Needed section on ECM request
		|Days from today | Time   | Flexible | ASAP|
		| 5              | 4:00 PM| No       | No  | 
    When user selects fields in Sources section on MTD request
  	| Source Index  | Source  | Source Details  |Time Codes                      | Select Camera Index | Camera Type  |
		| 0             | WG06    | Cfast Comm      |Matching Time Code For All Clips| 0                   | Canon 5D Mark II |
		When user clicks `+ Camera Type` button on ECM request
		| Source Index  |
		| 0             |
    When user selects fields in Sources section on MTD request
  	| Source Index  | Select Camera Index | Camera Type  |
		| 0             | 1                   | Canon C300 Mark II |
  	When user selects fields in Destinations section on MTD request
  	| Destination Index  | Destination  | Destination Details  | Qty |
		| 0                  | Media Shuttle| Cfast Comm           | 4   |
		When user selects fields in Instructions section on MTD request
		|Instructions |
		|Commenting   |
		And user clicks Submit button on request
  	Then user sees modal for successful "Media Transcoding/Transferring/Duplication" request creation
  	And  user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
    When user selects fields in Date & Time Needed section on ECM request in edit mode
		| Flexible | ASAP|
		| Yes      | Yes | 
    When user selects fields in Date & Time Needed section on ECM request in edit mode
		| Flexible | ASAP|Days from today|Time    |
		| No       | No  | 5             |4:00 PM |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request 
		When user clicks Edit button on request
		When user selects fields in Date & Time Needed section on ECM request in edit mode
		| Flexible |
		| Yes      |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request 
		When user clicks Edit button on request
		When user selects fields in Date & Time Needed section on ECM request in edit mode
		| ASAP       |
		| Yes        |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request 
		When user clicks Edit button on request
		When user selects fields in Date & Time Needed section on ECM request in edit mode
		| ASAP|Days from today|
		| No  | 5             |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request 
  	When user clicks Edit button on request
  	When user clears Date Needed By on ECM request
		When user selects fields in Date & Time Needed section on ECM request in edit mode
		|Days from today|
		| 6             |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
		When user clicks Edit button on request
    When user selects fields in Date & Time Needed section on ECM request in edit mode
		| Flexible |Time    |
		| No       |4:00 PM |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request 
  	When user clicks Edit button on request
  	When user clears Time Needed By on ECM request
    When user selects fields in Date & Time Needed section on ECM request in edit mode
		|Time    |
		|5:00 PM |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request 
  	When user clicks Edit button on request
  	When user clears Date Needed By on ECM request
		When user selects fields in Date & Time Needed section on ECM request in edit mode
		| Days from today   |
		| 10                 |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user clears Time Needed By on ECM request
    When user selects fields in Date & Time Needed section on ECM request in edit mode
		| Time   |
		| 3:00 PM|
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request 
  	When user clicks Edit button on request
    When user selects fields in Date & Time Needed section on ECM request in edit mode
		| Flexible |ASAP        |
		| Yes      |Yes         |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
    When user selects fields in Date & Time Needed section on ECM request in edit mode
		| Flexible | ASAP|Days from today|Time    |
		| No       | No  | 5             |4:00 PM |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request 
  	When user clicks Edit button on request
  	When user clears Date Needed By on ECM request
  	When user clears Time Needed By on ECM request
    When user selects fields in Date & Time Needed section on ECM request in edit mode
		|Days from today|Time    |
		| 5             |4:00 PM |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user clears Date Needed By on ECM request
    When user selects fields in Date & Time Needed section on ECM request in edit mode
		|Days from today|Flexible    |
		| 6             |Yes         |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
    When user selects fields in Date & Time Needed section on ECM request in edit mode
		|ASAP|
		|Yes |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	
  	 @NcxUnifiedToolPhase2 @PSEQA @Logs_060 @Logs_MTD
  Scenario: log verification for General Details, Instructions, Producer Details sections in Feed out request
		And user clicks on forms link
  	And user selects "Media Transcoding / Transferring / Duplication" form
  	When user selects fields in General Details section on ECM request
  		|Division  |Slug    |
  		|CNBC      |Testing |
    When user selects fields in Producer Details section on ECM request
     	|Req same as producer  | Producer      | Senior Producer   |
			|No                    | Bambani, Mohit| Bambani, Mohit    |
    When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name  | Days from today   | Time   | Flexible    | To Be Determined   |
		|0      | CNBC - Affiliates          | 4                 | 1:00 PM| No          | No                 |
		When user clicks `+ Show Unit` button on ECM request
    When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name    |
		|1      | CNBC - Biz Day - Projects    |
		When user selects fields in Date & Time Needed section on ECM request
		|Days from today | Time   | Flexible | ASAP|
		| 5              | 4:00 PM| No       | No  | 
    When user selects fields in Sources section on MTD request
  	| Source Index  | Source  | Source Details  |Time Codes                      | Select Camera Index | Camera Type  |
		| 0             | WG06    | Cfast Comm      |Matching Time Code For All Clips| 0                   | Canon 5D Mark II |
		When user clicks `+ Camera Type` button on ECM request
		| Source Index  |
		| 0             |
    When user selects fields in Sources section on MTD request
  	| Source Index  | Select Camera Index | Camera Type  |
		| 0             | 1                   | Canon C300 Mark II |
  	When user selects fields in Destinations section on MTD request
  	| Destination Index  | Destination  | Destination Details  | Qty |
		| 0                  | Media Shuttle| Cfast Comm           | 3   |
		When user selects fields in Instructions section on MTD request
		|Instructions |
		|Commenting   |
		And user clicks Submit button on request
  	Then user sees modal for successful "Media Transcoding/Transferring/Duplication" request creation
  	And  user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
		When user selects fields in Instructions section on MTD request in edit mode
		|Instructions        |
		|Commenting |
    When user selects fields in Producer Details section on ECM request in edit mode
     	|Req same as producer  | Senior Producer   |
			|Yes                   | R, Jeevanandham   |
		When user selects fields in Producer Details section on ECM request in edit mode
     	|Req same as producer  | Senior Producer   | Producer          |
			|No                    | Bambani, Mohit    | Bambani, Mohit    |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
    When user selects fields in General Details section on ECM request in edit mode
  		|Division  |
  		|NBC News  |
  	When user selects fields in Producer Details section on ECM request in edit mode
     	|Req same as producer  |
			|Yes                   |
		When user selects fields in Instructions section on MTD request in edit mode
		|Instructions        |
		|Commenting |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
    When user selects fields in General Details section on ECM request in edit mode
  		|Slug|
  		|NBC |
  	When user selects fields in Producer Details section on ECM request in edit mode
     	| Senior Producer   |
			| R, Jeevanandham   |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
    When user selects fields in General Details section on ECM request in edit mode
  		|Slug |
  		|Test |
  	When user selects fields in Producer Details section on ECM request in edit mode
     	|Req same as producer  | Producer          |
			|No                    | R, Jeevanandham   |
    When user selects fields in General Details section on ECM request in edit mode
  		|Slug    |Division|
  		|Testing |CNBC    |
  	When user selects fields in Producer Details section on ECM request in edit mode
     	| Producer          | Senior Producer  |
			| Bambani, Mohit    |Bambani, Mohit    |
		When user selects fields in Instructions section on MTD request in edit mode
		|Instructions        |
		|Commenting - edited |
    When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
    When user selects fields in General Details section on ECM request in edit mode
  		|Slug|Division   |
  		|NBC |NBC News   |
  	When user selects fields in Producer Details section on ECM request in edit mode
     	| Req same as producer|
			| Yes                 |
		When user selects fields in Instructions section on MTD request in edit mode
		|Instructions        |
		|Commenting - edited 2 |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	
  	@NcxUnifiedToolPhase2 @PSEQA @Logs_061 @Logs_MTD
  Scenario: Logs verification for  Talent and Requesters section changes on MTD request
  	And user clicks on forms link
  	And user selects "Media Transcoding / Transferring / Duplication" form
  	When user selects fields in General Details section on ECM request
  		|Division  |Slug    |
  		|CNBC      |Testing |
    When user selects fields in Producer Details section on ECM request
     	|Req same as producer  | Producer      | Senior Producer   |
			|No                    | Bambani, Mohit| Bambani, Mohit    |
    When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name  | Days from today   | Time   | Flexible    | To Be Determined   |
		|0      | CNBC - Affiliates          | 4                 | 1:00 PM| No          | No                 |
		When user clicks `+ Show Unit` button on ECM request
    When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name    |
		|1      | CNBC - Biz Day - Projects    |
		When user selects fields in Date & Time Needed section on ECM request
		|Days from today | Time   | Flexible | ASAP|
		| 5              | 4:00 PM| No       | No  | 
    When user selects fields in Sources section on MTD request
  	| Source Index  | Source  | Source Details  |Time Codes                      | Select Camera Index | Camera Type  |
		| 0             | WG06    | Cfast Comm      |Matching Time Code For All Clips| 0                   | Canon 5D Mark II |
		When user clicks `+ Camera Type` button on ECM request
		| Source Index  |
		| 0             |
    When user selects fields in Sources section on MTD request
  	| Source Index  | Select Camera Index | Camera Type  |
		| 0             | 1                   | Canon C300 Mark II |
  	When user selects fields in Destinations section on MTD request
  	| Destination Index  | Destination  | Destination Details  | Qty |
		| 0                  | Media Shuttle| Cfast Comm           | 2   |
		When user selects fields in Instructions section on MTD request
		|Instructions |
		|Commenting   |
		And user clicks Submit button on request
  	Then user sees modal for successful "Media Transcoding/Transferring/Duplication" request creation
  	And  user clicks on "ok" button
		When user opens the created request
    # validations for logs of Talent section field changes
		When user clicks Edit button on request
	  When user adds requester to the form in edit mode   	
	    |Requester       |
	    |Worker 2, STORM |
	  When user adds requester to the form in edit mode   	
	    |Requester       |
	    |Worker 11, STORM |
	  When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user adds specific user in Talent section in edit mode
  	  | Name     |
  	  | Velshi, Ali & Alba, Monica  |
	  When user removes requester to the form in edit mode   	
	    |Requester       |
	    |Worker 2, STORM & Worker 11, STORM |
	  When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
	  When user removes specific user in Talent section in edit mode
	  	| Name     |
	  	| Velshi, Ali & Alba, Monica  |
	  When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
	  When user adds requester to the form in edit mode
	  |Requester       |
	  |Worker 2, STORM |
	  When user adds specific user in Talent section in edit mode
  	  | Name     |
  	  | Velshi, Ali  |   	
	  When user removes requester to the form in edit mode   	
	    |Requester       |
	    |Worker 11, STORM |
	  When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
	  When user adds requester to the form in edit mode   	
	    |Requester       |
	    |Worker 11, STORM |
  	When user adds specific user in Talent section in edit mode
  	  | Name     |
  	  | Alba, Monica  |
  	When user removes specific user in Talent section in edit mode
  		|Name |
  		|Velshi, Ali|
	  When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
	  When user removes requester to the form in edit mode   	
	    |Requester        |
	    |Worker 11, STORM |
	  When user removes requester to the form in edit mode   	
	    |Requester       |
	    |Worker 2, STORM |
	  When user removes specific user in Talent section in edit mode
  		|Name |
  		|Alba, Monica|
	  When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	
  	@NcxUnifiedToolPhase2 @PSEQA @Logs_062 @Logs_MTD
	Scenario: Logs verification when Fulfiller clicks Cancel Request on newly created MTD Request
  	And user clicks on forms link
  	And user selects "Media Transcoding / Transferring / Duplication" form
  	When user selects fields in General Details section on ECM request
  		|Division  |Slug    |
  		|CNBC      |Testing |
    When user selects fields in Producer Details section on ECM request
     	|Req same as producer  | Producer      | Senior Producer   |
			|No                    | Bambani, Mohit| Bambani, Mohit    |
    When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name  | Days from today   | Time   | Flexible    | To Be Determined   |
		|0      | CNBC - Affiliates          | 4                 | 1:00 PM| No          | No                 |
		When user clicks `+ Show Unit` button on ECM request
    When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name    |
		|1      | CNBC - Biz Day - Projects    |
		When user selects fields in Date & Time Needed section on ECM request
		|Days from today | Time   | Flexible | ASAP|
		| 5              | 4:00 PM| No       | No  | 
    When user selects fields in Sources section on MTD request
  	| Source Index  | Source  | Source Details  |Time Codes                      | Select Camera Index | Camera Type  |
		| 0             | WG06    | Cfast Comm      |Matching Time Code For All Clips| 0                   | Canon 5D Mark II |
		When user clicks `+ Camera Type` button on ECM request
		| Source Index  |
		| 0             |
    When user selects fields in Sources section on MTD request
  	| Source Index  | Select Camera Index | Camera Type  |
		| 0             | 1                   | Canon C300 Mark II |
  	When user selects fields in Destinations section on MTD request
  	| Destination Index  | Destination  | Destination Details  | Qty |
		| 0                  | Media Shuttle| Cfast Comm           | 6   |
		When user selects fields in Instructions section on MTD request
		|Instructions |
		|Commenting   |
		And user clicks Submit button on request
  	Then user sees modal for successful "Media Transcoding/Transferring/Duplication" request creation
  	And  user clicks on "ok" button
		Then user logs out from application
  	Given user opens producer dashboard application
    And user logins with "fulfiller" role
    When user opens the created request
    Then user clicks Cancel Request button on request
    When user opens the created request
		Then user verifies all Logs on request
		
		@NcxUnifiedToolPhase2 @PSEQA @Logs_063 @Logs_MTD
  Scenario: log verification for Destinations section in MTD request
  	And user clicks on forms link
  	And user selects "Media Transcoding / Transferring / Duplication" form
  	When user selects fields in General Details section on ECM request
  		|Division  |Slug    |
  		|CNBC      |Testing |
    When user selects fields in Producer Details section on ECM request
     	|Req same as producer  | Producer      | Senior Producer   |
			|No                    | Bambani, Mohit| Bambani, Mohit    |
    When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name  | Days from today   | Time   | Flexible    | To Be Determined   |
		|0      | CNBC - Affiliates          | 4                 | 1:00 PM| No          | No                 |
		When user clicks `+ Show Unit` button on ECM request
    When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name    |
		|1      | CNBC - Biz Day - Projects    |
		When user selects fields in Date & Time Needed section on ECM request
		|Days from today | Time   | Flexible | ASAP|
		| 5              | 4:00 PM| No       | No  | 
    When user selects fields in Sources section on MTD request
  	| Source Index  | Source  | Source Details  |Time Codes                      | Select Camera Index | Camera Type  |
		| 0             | WG06    | Cfast Comm      |Matching Time Code For All Clips| 0                   | Canon 5D Mark II |
		When user clicks `+ Camera Type` button on ECM request
		| Source Index  |
		| 0             |
    When user selects fields in Sources section on MTD request
  	| Source Index  | Select Camera Index | Camera Type  |
		| 0             | 1                   | Canon C300 Mark II |
  	When user selects fields in Destinations section on MTD request
  	| Destination Index  | Destination  | Destination Details  | Qty |
		| 0                  | Media Shuttle| Cfast Comm           | 4   |
		When user selects fields in Instructions section on MTD request
		|Instructions |
		|Commenting   |
		And user clicks Submit button on request
  	Then user sees modal for successful "Media Transcoding/Transferring/Duplication" request creation
  	And  user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
		When user clicks `+ Destination` button on MTD request
		When user selects fields in Destinations section on MTD request in edit mode
  	| Destination Index  | Destination  | Destination Details  | Qty |
		| 1                  | Media Shuttle| Cfast Comm           | 4   |
		When user removes Destination section on MTD request in edit mode
		|Destination Index |
		|0                 |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
		When user selects fields in Destinations section on MTD request in edit mode
  	| Destination Index  | Destination |
		| 0                  | Hard Drive  |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
		When user selects fields in Destinations section on MTD request in edit mode
  	| Destination Index  | Destination Details  |
		| 0                  | Cfast Comm - edited  |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
		When user selects fields in Destinations section on MTD request in edit mode
  	| Destination Index  | Qty |
		| 0                  | 4   |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
		When user selects fields in Destinations section on MTD request in edit mode
  	| Destination Index  | Destination Details  |
		| 0                  | Cfasting Comm        |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user clicks `+ Destination` button on MTD request
  	When user selects fields in Destinations section on MTD request in edit mode
  	| Destination Index  | Destination   | Destination Details  | Qty |
		| 1                  | Send This File| Cfast Send this file | 3   |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
  	When user clicks `+ Destination` button on MTD request
  	When user selects fields in Destinations section on MTD request in edit mode
  	| Destination Index  | Destination  | Destination Details  |
		| 2                  | Media Shuttle| Cfast Send this file |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
		When user removes Destination section on MTD request in edit mode
		|Destination Index |
		|1	           |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	When user clicks Edit button on request
		When user removes Destination section on MTD request in edit mode
		|Destination Index |
		|0            |
		When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	
  	@NcxUnifiedToolPhase2 @PSEQA @Logs_064 @Logs_FeedOut
  Scenario: Logs verification when Requester and Fulfiller adds, edits or deletes notes on Feed out Request
  	And user clicks on forms link
  	And user selects "Feed Out" form
  	When user selects fields in General Details section on ECM request
  		|Division  |Slug    |
  		|CNBC      |Testing |
  	When user clicks `+ Additional Recipient` button on ECM request
  	When user selects fields in Additional Recipients(s) section on ECM request
    	| Email                     |Position      |
    	| mohit.bambani@nbcuni.com  |0             |
    When user selects fields in Producer Details section on ECM request
     	|Req same as producer  | Producer      | Senior Producer   |
			|No                    | Bambani, Mohit| Bambani, Mohit    |
		When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name  | Days from today   | Time   | Flexible    | To Be Determined   |
		|0      | CNBC - Affiliates          | 4                 | 1:00 PM| No          | No                 |
		When user clicks `+ Show Unit` button on ECM request
    When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name    |
		|1      | CNBC - Biz Day - Projects    |
		When user selects fields in Date & Time Needed section on ECM request
		|Days from today | Time   | Flexible | ASAP|
		| 5              | 4:00 PM| No       | No  | 
    When user selects fields in Sources section on Feed out request
  	| Source Index  | Source          | Qty | Comments  |
		| 0             | CNBC- Stratus   | 5   | Cfast Comm|
		When user selects CNBC-Stratus Slug(s) in Sources section on Feed out request
		| Source Index  | Slug Index   | Slug    |
		| 0             | 0            | Slug 1  |
		When user clicks `+ Stratus Slug` button on Feed out request
		| Source Index  |
		| 0             |
		When user selects CNBC-Stratus Slug(s) in Sources section on Feed out request
		| Source Index  | Slug Index   | Slug    |
		| 0             | 1            | Slug 2  |
  	When user selects Destinations on Feed out request
  	| Destinations                    |
  	| WG01, WG02, WG06, WG08, 30 Rock |
  	When user selects fields in Content Description section on ECM request
		|Content Description|
		| CCD               |
		When user selects fields in Comments section on ECM request
		|Comments |
		|Commenting |
		And user clicks Submit button on request
  	Then user sees modal for successful "Feed Out" request creation
  	Then user clicks on "ok" button
  	When user opens the created request
		When user clicks Edit button on request
		When user switches to `Notes` tab in right container on Request
  	Then user adds 11 notes on request
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	Then user logs out from application
  	Given user opens producer dashboard application
    And user logins with "fulfiller" role
    When user opens the created request
    When user clicks Edit button on request
    When user switches to `Fulfillment` tab on ECM request
    When user selects fields in Feed Out fulfillment
		| Destinations  |Clip count | Media Id|Feed Out Time|
		| CNBC - London |8          | mi-01   |4:00 PM      |
		When user selects fields in Timer in Feed Out fulfillment
		|Hours     | Minutes     | Seconds  |
		| 1        | 1           | 10       |
		When user selects fields in Comments in Feed Out fulfillment
		|Comments     |
		| com         |
		When user selects fields in Status in Feed Out fulfillment
		|Status       |
		| IN PROGRESS |
  	When user switches to `Notes` tab in right container on Request
  	Then user adds 11 notes on request
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	Then user logs out from application
  	Given user opens producer dashboard application
    And user logins with "producer" role
    When user opens the created request
		When user clicks Edit button on request
		When user switches to `Notes` tab in right container on Request
  	Then user edits notes on request randomly
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
		When user switches to `Notes` tab in right container on Request
  	Then user deletes notes on request randomly
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	Then user logs out from application
  	Given user opens producer dashboard application
    And user logins with "fulfiller" role
    When user opens the created request
		When user clicks Edit button on request
		When user switches to `Notes` tab in right container on Request
  	Then user edits notes on request randomly
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
		When user switches to `Notes` tab in right container on Request
  	Then user deletes notes on request randomly
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	
  	@NcxUnifiedToolPhase2 @PSEQA @Logs_065 @Logs_MTD
  Scenario: Logs verification when Requester and Fulfiller adds, edits or deletes notes on MTD Request
  	And user clicks on forms link
  	And user selects "Media Transcoding / Transferring / Duplication" form
  	When user selects fields in General Details section on ECM request
  		|Division  |Slug    |
  		|CNBC      |Testing |
    When user selects fields in Producer Details section on ECM request
     	|Req same as producer  | Producer      | Senior Producer   |
			|No                    | Bambani, Mohit| Bambani, Mohit    |
    When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name  | Days from today   | Time   | Flexible    | To Be Determined   |
		|0      | CNBC - Affiliates          | 4                 | 1:00 PM| No          | No                 |
		When user clicks `+ Show Unit` button on ECM request
    When user selects fields in Show Information section on ECM request
		|Index  | Show Unit or Project Name    |
		|1      | CNBC - Biz Day - Projects    |
		When user selects fields in Date & Time Needed section on ECM request
		|Days from today | Time   | Flexible | ASAP|
		| 5              | 4:00 PM| No       | No  | 
    When user selects fields in Sources section on MTD request
  	| Source Index  | Source  | Source Details  |Time Codes                      | Select Camera Index | Camera Type  |
		| 0             | WG06    | Cfast Comm      |Matching Time Code For All Clips| 0                   | Canon 5D Mark II |
		When user clicks `+ Camera Type` button on ECM request
		| Source Index  |
		| 0             |
    When user selects fields in Sources section on MTD request
  	| Source Index  | Select Camera Index | Camera Type  |
		| 0             | 1                   | Canon C300 Mark II |
  	When user selects fields in Destinations section on MTD request
  	| Destination Index  | Destination  | Destination Details  | Qty |
		| 0                  | Media Shuttle| Cfast Comm           | 3   |
		When user selects fields in Instructions section on MTD request
		|Instructions |
		|Commenting   |
		And user clicks Submit button on request
  	Then user sees modal for successful "Media Transcoding/Transferring/Duplication" request creation
  	And  user clicks on "ok" button
  	When user opens the created request
		When user clicks Edit button on request
		When user switches to `Notes` tab in right container on Request
  	Then user adds 11 notes on request
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	Then user logs out from application
  	Given user opens producer dashboard application
    And user logins with "fulfiller" role
    When user opens the created request
    When user clicks Edit button on request
    When user switches to `Fulfillment` tab on ECM request
    When user selects fields in MTD fulfillment
		| Destinations  |Position|Clip count | Gig size|File formats |
		| Media Shuttle |0       |8          | 5       |.avi, .gif   |
		When user selects fields in Timer in MTD fulfillment
		|Hours     | Minutes     | Seconds  |
		| 20        | 11           | 10       |
		When user selects fields in Comments in MTD fulfillment
		|Comments     |
		| commtd         |
		When user selects fields in Status in MTD fulfillment
		|Status       |
		| IN PROGRESS |
  	When user switches to `Notes` tab in right container on Request
  	Then user adds 11 notes on request
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request
  	Then user logs out from application
  	Given user opens producer dashboard application
    And user logins with "producer" role
    When user opens the created request
		When user clicks Edit button on request
		When user switches to `Notes` tab in right container on Request
  	Then user edits notes on request randomly
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
		When user switches to `Notes` tab in right container on Request
  	Then user deletes notes on request randomly
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	Then user logs out from application
  	Given user opens producer dashboard application
    And user logins with "fulfiller" role
    When user opens the created request
		When user clicks Edit button on request
		When user switches to `Notes` tab in right container on Request
  	Then user edits notes on request randomly
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	When user clicks Edit button on request
		When user switches to `Notes` tab in right container on Request
  	Then user deletes notes on request randomly
  	When user clicks Save button on request
  	Then user clicks on "ok" button
  	When user opens the created request
  	Then user verifies all Logs on request