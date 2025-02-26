@EditStandardFormRequest @ProducerDashboard
Feature: Validate various scenarios related Standard Edit Request

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role

  @EditStandardFormRequest_Basic_Flow
  Scenario Outline: Verify user filling Standard Edit request form
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in Edit request form
      | Slug | NCX Story Name | Division    | Additional Requesters | Is Producer Same as Requestor | Sr Producer  | Talent              |
      | Test |                | Engineering |                       | yes                           | Jeevanandham | test/tesr/test/test |
    When user selects "Standard" edit type in Edit request form
    ##################Standard Edit Request######################################
    When user enters show info Information in Standard Edit request form
      | Show Unit       | Budget Code | Air Date      | Air Time      |
      | CNBC,MSNBC,News |             | CurrentDate+3 | CurrentTime+3 |
    When user enters Show Length in Standard Edit Request form
      | Length Of Show Minutes | Length Of Show Seconds |
      |                      5 |                     55 |
    When user enters Session details info in Standard Edit Request form
      | Location | Edit Start Date | ediusOrAvid | Requested Edit Session Start Time | Edit Time Needed Days | Edit Time Needed Hours | Edit Time Needed Minutes |
      | London   | CurrentDate+15  | EDIUS       | CurrentTime+5                     |                    10 |                     28 |                       44 |
    When user selects type of edit info in Standard Edit Request form
      | Type of Edit                 | Type of Edit Quantity | How Many Versions |
      | Other test hello,Promo,Fixes |                 3,2,5 |                 5 |
    When user selects  Additional Requirements info in Standard Edit Request form
      | Additional Requirements | is Crash Edit |
      | Music,Effects           | Yes           |
    When user selects Final Delivery in Standard Edit Request form
      | Final Delivery       |
      | Digital,Social,hello |
    When user selects Source Material info in Standard Edit Request form
      | Source Material |
      | WG01,WG06       |
    When user enters comments info in Standard Edit Request form
      | Comments                               |
      | Testing info Testing info Testing info |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    And user logs out from application

    ########################################################
    Examples: 
      | Form Name     |
      | Standard Edit |

  @EditStandardFormRequest_different_divisions_location_delivery_TypeofEdit_additionalRequirements_sourceMaterial
  Scenario Outline: Verify user filling Standard Edit request form with different divisions,Location,Delivery,Type of Edit,Additional Requirements,Source Material
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in Edit request form
      | Slug | NCX Story Name | Division   | Additional Requesters | Is Producer Same as Requestor | Sr Producer  | Talent              |
      | Test |                | <Division> |                       | yes                           | Jeevanandham | test/tesr/test/test |
    When user selects "Standard" edit type in Edit request form
    ##################Standard Edit Request######################################
    When user enters show info Information in Standard Edit request form
      | Show Unit       | Budget Code | Air Date      | Air Time      |
      | CNBC,MSNBC,News |             | CurrentDate+3 | CurrentTime+3 |
    When user enters Show Length in Standard Edit Request form
      | Length Of Show Minutes | Length Of Show Seconds |
      |                      5 |                     55 |
    When user enters Session details info in Standard Edit Request form
      | Location   | Edit Start Date | ediusOrAvid | Requested Edit Session Start Time | Edit Time Needed Days | Edit Time Needed Hours | Edit Time Needed Minutes |
      | <Location> | CurrentDate+15  | EDIUS       | CurrentTime+5                     |                    10 |                     28 |                       44 |
    When user selects type of edit info in Standard Edit Request form
      | Type of Edit   | Type of Edit Quantity   | How Many Versions |
      | <Type of Edit> | <Type of Edit Quantity> |                 5 |
    When user selects  Additional Requirements info in Standard Edit Request form
      | Additional Requirements   | is Crash Edit |
      | <Additional Requirements> | Yes           |
    When user selects Final Delivery in Standard Edit Request form
      | Final Delivery   |
      | <Final Delivery> |
    When user selects Source Material info in Standard Edit Request form
      | Source Material   |
      | <Source Material> |
    When user enters comments info in Standard Edit Request form
      | Comments                               |
      | Testing info Testing info Testing info |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    And user logs out from application

    ########################################################
    Examples: 
      | Form Name     | Division         | Location                | Final Delivery       | Type of Edit                          | Type of Edit Quantity | Additional Requirements                            | Source Material                         |
      | Standard Edit | NBC News         | 30 Rock                 | Digital,Social,hello | Package,Promo,Fixes                   |                 3,2,5 | Music,Effects                                      | WG01,WG06                               |
      | Standard Edit | MSNBC            | London                  | Broadcast,Podcast    | Open/Teases, Podcast                  |                   4,6 | Color Correct,Graphics/Stills                      | To Be Ingested, Restoring From Archives |
      | Standard Edit | CNBC             | Los Angeles             | Digital,Social,hello | Package,Promo,Fixes                   |                 3,2,5 | Audio Correct,Additional Requirements Other Tester | WG01,WG06                               |
      | Standard Edit | Acorn            | CNBC - Englewood Cliffs | Broadcast,Podcast    | Digital/Web,VOs/SOTs,Show Build       |                 2,4,6 | Music,Effects                                      | To be Shot,Source Material Other Tester |
      | Standard Edit | Corporate        | Washington              | Digital,Social,hello | Show Update,Type of Edit Other Tester |                   5,8 | Color Correct,Graphics/Stills                      | All, Source Material Other Tester       |
      | Standard Edit | Engineering      | CNBC - Washington DC    | Broadcast,Podcast    | Package,Promo,Fixes                   |                 3,2,5 | Audio Correct,Additional Requirements Other Tester | To Be Ingested, Restoring From Archives |
      | Standard Edit | Entertainment    | 30 Rock                 | Digital,Social,hello | Open/Teases, Podcast                  |                   4,6 | Music,Effects                                      | All, Source Material Other Tester       |
      | Standard Edit | ERG Events       | CNBC - Los Angeles      | Broadcast,Podcast    | Digital/Web,VOs/SOTs,Show Build       |                 2,4,6 | Color Correct,Graphics/Stills                      | WG01,WG06                               |
      | Standard Edit | Facilities       | CNBC - Englewood Cliffs | Digital,Social,hello | Show Update,Type of Edit Other Tester |                   5,8 | Audio Correct,Additional Requirements Other Tester | To be Shot,Source Material Other Tester |
      | Standard Edit | NBC News Studios | CNBC - Washington DC    | Digital,Social,hello | Package,Promo,Fixes                   |                 3,2,5 | Music,Effects                                      | Source Material Other Tester            |
      | Standard Edit | NBC Sports       | Washington              | Broadcast,Podcast    | Open/Teases, Podcast                  |                   4,6 | Color Correct,Graphics/Stills                      | WG01,WG06                               |
      | Standard Edit | News Digital     | Los Angeles             | Digital,Social,hello | Digital/Web,VOs/SOTs,Show Build       |                 2,4,6 | Audio Correct,Additional Requirements Other Tester | All                                     |
      | Standard Edit | Olympics         | CNBC - Los Angeles      | Digital,Social,hello | Show Update,Type of Edit Other Tester |                   5,8 | Music,Effects                                      | To Be Ingested, Restoring From Archives |
      | Standard Edit | Operations       | London                  | Broadcast,Podcast    | Package,Promo,Fixes                   |                 3,2,5 | Color Correct,Graphics/Stills                      | To be Shot,Source Material Other Tester |
      | Standard Edit | Peacock          | CNBC - Washington DC    | Broadcast,Podcast    | Open/Teases, Podcast                  |                   4,6 | Audio Correct,Additional Requirements Other Tester | WG01,WG06                               |
      | Standard Edit | Telemundo        | 30 Rock                 | Digital,Social,hello | Digital/Web,VOs/SOTs,Show Build       |                 2,4,6 | Music,Effects                                      | To be Shot,Source Material Other Tester |
      | Standard Edit | Universal Kids   | CNBC - Englewood Cliffs | Digital,Social,hello | Show Update,Type of Edit Other Tester |                   5,8 | Color Correct,Graphics/Stills                      | To Be Ingested, Restoring From Archives |
