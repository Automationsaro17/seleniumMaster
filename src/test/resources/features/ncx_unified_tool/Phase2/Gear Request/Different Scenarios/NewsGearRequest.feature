@NewsGearRequest @ProducerDashboard
Feature: Validate various scenarios related News Gear Request

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role

  @NewsGearRequest_Basic_Flow
  Scenario Outline: Verify user filling News Gear request form
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in News Gear form
      | Slug | NCX Story Name | Division    | Additional Requesters | Is Producer Same as Requestor | Sr Producer  | Talent              |
      | Test |                | Engineering |                       | yes                           | Jeevanandham | test/tesr/test/test |
    ############################ user selecting the form ############################
    When user enters Gear User Information in News Gear form
      | Gear User | Mobile Phone |
      |           |   9898989877 |
    When user enters show info Information in News Gear form
      | Show Unit                   | Budget Code | Segment Type |
      | Capital Exchange Livestream |             | Live         |
    When user enters Logistic details Information in News Gear form
      | Location | Pick Up Date   | Pick Up Time  | Return Date    |
      | LA       | CurrentDate+15 | CurrentTime+3 | CurrentDate+19 |
    When user enters Add Gear details Information in News Gear form
      | Type of Gear   | How many | Comments                       |
      | Cameras,Tripod |      4,5 | Testing camera, Testing tripod |
    When user enters Usage deatils Information in News Gear form
      | Is this the gear being used as a hidden camera or microphone? | Is this gear being used outside the US? | Will any wireless audio equipment be used in any NBC studio location? | Is this gear being given to someone outside of NBC Universal to use? | description         |
      | yes                                                           | yes                                     | yes                                                                   | yes                                                                  | testing description |
    When user enters additional Information in News Gear form
      | additional info      |
      | Test additional info |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    And user logs out from application

    ########################################################
    Examples: 
      | Form Name |
      | News Gear |

  @NewsGearRequest_different_divisions_geartype
  Scenario Outline: Verify user filling News Gear request form with different divisions and gear type
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in News Gear form
      | Slug | NCX Story Name | Division   | Additional Requesters | Is Producer Same as Requestor | Sr Producer  | Talent              |
      | Test |                | <Division> |                       | yes                           | Jeevanandham | test/tesr/test/test |
    ############################ user selecting the form ############################
    When user enters Gear User Information in News Gear form
      | Gear User | Mobile Phone |
      |   Solai        |   9898989877 |
    When user enters show info Information in News Gear form
      | Show Unit                   | Budget Code | Segment Type |
      | Capital Exchange Livestream,News |             | Live         |
    When user enters Logistic details Information in News Gear form
      | Location   | Pick Up Date   | Pick Up Time  | Return Date    |
      | <Location> | CurrentDate+15 | CurrentTime+3 | CurrentDate+19 |
    When user enters Add Gear details Information in News Gear form
      | Type of Gear   | How many | Comments                       |
      | <Type of Gear> |      4,5 | Testing camera, Testing tripod |
    When user enters Usage deatils Information in News Gear form
      | Is this the gear being used as a hidden camera or microphone? | Is this gear being used outside the US? | Will any wireless audio equipment be used in any NBC studio location? | Is this gear being given to someone outside of NBC Universal to use? | description         |
      | yes                                                           | yes                                     | yes                                                                   | yes                                                                  | testing description |
    When user enters additional Information in News Gear form
      | additional info      |
      | Test additional info |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    And user logs out from application

    ########################################################
    Examples: 
      | Form Name | Division         | Location | Type of Gear                    |
      | News Gear | NBC News         | NY LIC   | Wireless Audio,Lighting         |
      | News Gear | MSNBC            | LA       | Tracking Microphone Kit,Cameras |
      | News Gear | CNBC             | DC       | Cameras,Tripod                  |
      | News Gear | Acorn            | NY LIC   | Wireless Audio,Lighting         |
      | News Gear | Corporate        | LA       | Cameras,Tripod                  |
      | News Gear | Engineering      | DC       | Tracking Microphone Kit,Cameras |
      | News Gear | Entertainment    | NY LIC   | Cameras,Tripod                  |
      | News Gear | ERG Events       | LA       | Tracking Microphone Kit,Cameras |
      | News Gear | Facilities       | DC       | Wireless Audio,Lighting         |
      | News Gear | NBC News Studios | NY LIC   | Cameras,Tripod                  |
      | News Gear | NBC Sports       | LA       | Wireless Audio,Lighting         |
      | News Gear | News Digital     | DC       | Tracking Microphone Kit,Cameras |
      | News Gear | Olympics         | NY LIC   | Wireless Audio,Lighting         |
      | News Gear | Operations       | LA       | Cameras,Tripod                  |
      | News Gear | Peacock          | DC       | Tracking Microphone Kit,Cameras |
      | News Gear | Telemundo        | NY LIC   | Cameras,Tripod                  |
      | News Gear | Universal Kids   | LA       | Wireless Audio,Lighting         |
