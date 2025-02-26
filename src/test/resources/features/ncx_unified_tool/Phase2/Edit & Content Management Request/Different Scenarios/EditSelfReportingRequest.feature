@EditSelfReportingForm @ProducerDashboard
Feature: Validate various scenarios related Edit Self Reporting request

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role

  @EditSelfReporting_Basic_Flow
  Scenario Outline: Verify user creating Edit Self Reporting request
    ############################ user submitting the form request ############################
    And user selects "<Form Name>" form
    And user enters General info in Edit Self Reporting request form
      | Show Unit | Budget Code |
      | CNBC      |             |
    And user enters Show info in Edit Self Reporting request form
      | Air Date      | Edit Date     |
      | CurrentDate+3 | CurrentDate+7 |
    And user enters Edit Type info in Edit Self Reporting request form
      | Who Is Editing | Type of Edit        | Type of Edit Quantity |
      | Producer       | Package,Promo,Fixes |                 3,2,5 |
    And user enters Location info in Edit Self Reporting request form
      | Location | Room            |
      | London   | LONDON EDIT - 1 |
    And user enters comments info in Edit Self Reporting request form
      | Comments                               |
      | Testing info Testing info Testing info |
    ########################################################
    And user clicks on "Submit" button
    Then user get the Edit Self Reporting Request ID with Request Type from Success message
    And user clicks on "ok" button
    And user logs out from application

    Examples: 
      | Form Name           |
      | Edit Self Reporting |

  @EditSelfReporting_different_whoIsEditing_typeofEdit_location_typeofEditQuantity_room
  Scenario Outline: Verify user creating Edit Self Reporting request form with different combinations of Who Is Editing,Type of Edit,Location,Type of Edit Quantity,Room
    ############################ user submitting the form request ############################
    And user selects "<Form Name>" form
    And user enters General info in Edit Self Reporting request form
      | Show Unit | Budget Code |
      | CNBC      |             |
    And user enters Show info in Edit Self Reporting request form
      | Air Date      | Edit Date     |
      | CurrentDate+3 | CurrentDate+7 |
    And user enters Edit Type info in Edit Self Reporting request form
      | Who Is Editing   | Type of Edit   | Type of Edit Quantity   |
      | <Who Is Editing> | <Type of Edit> | <Type of Edit Quantity> |
    And user enters Location info in Edit Self Reporting request form
      | Location   | Room   |
      | <Location> | <Room> |
    And user enters comments info in Edit Self Reporting request form
      | Comments                               |
      | Testing info Testing info Testing info |
    ########################################################
    And user clicks on "Submit" button
    Then user get the Edit Self Reporting Request ID with Request Type from Success message
    And user clicks on "ok" button
    And user logs out from application

    Examples: 
      | Form Name           | Who Is Editing | Type of Edit                                                                                                  | Location                | Type of Edit Quantity | Room                |
      | Edit Self Reporting | Producer       | Package,Promo,Fixes                                                                                           | 30 Rock                 |                10,5,8 | VM61                |
      | Edit Self Reporting | Editor         | Open/Teases,VOs/SOTs,Podcast                                                                                  | Los Angeles             | 2, 5, 7               | LA - DJ - 1         |
      | Edit Self Reporting | Producer       | Package,Promo,Fixes                                                                                           | CNBC - Englewood Cliffs | 1,3, 6                | Edit07              |
      | Edit Self Reporting | Editor         | Open/Teases,VOs/SOTs,Podcast                                                                                  | Washington              |                 2,4,7 | DC - EDIT 4 (X5004) |
      | Edit Self Reporting | Producer       | Package,Promo,Fixes                                                                                           | 30 Rock                 |                 1,4,6 | VM62                |
      | Edit Self Reporting | Editor         | Open/Teases,VOs/SOTs,Podcast                                                                                  | London                  |                 2,5,8 | LONDON EDIT - 1     |
      | Edit Self Reporting | Producer       | Package,Promo,Fixes                                                                                           | Los Angeles             | 2, 5, 7               | LA - NN - 5         |
      | Edit Self Reporting | Editor         | Open/Teases,VOs/SOTs,Podcast                                                                                  | CNBC - Englewood Cliffs | 1,3, 6                | Edit09              |
      | Edit Self Reporting | Producer       | Package,Promo,Fixes                                                                                           | Washington              |                 2,4,7 | DC - EDIT 5 (X5005) |
      | Edit Self Reporting | Editor         | Package,Promo,Fixes                                                                                           | 30 Rock                 |                 1,4,6 | VM66                |
      | Edit Self Reporting | Producer       | Open/Teases,VOs/SOTs,Podcast                                                                                  | London                  |                 2,5,8 | LONDON EDIT - 2     |
      | Edit Self Reporting | Editor         | Package,Promo,Fixes                                                                                           | Los Angeles             | 2, 5, 7               | LA - DT - 1         |
      | Edit Self Reporting | Producer       | Package,Promo,Fixes                                                                                           | CNBC - Englewood Cliffs | 1,3, 6                | EditDotCom1         |
      | Edit Self Reporting | Editor         | Open/Teases,VOs/SOTs,Podcast                                                                                  | Washington              |                 2,4,7 | DC - EDIT 7 (X5007) |
      | Edit Self Reporting | Producer       | Open/Teases,VOs/SOTs,Podcast                                                                                  | 30 Rock                 |                 1,4,6 | NYEDIT310           |
      | Edit Self Reporting | Editor         | Package,Promo,Fixes                                                                                           | London                  |                 2,5,8 | LONDON EDIT - 3     |
      | Edit Self Reporting | Producer       | Package,Promo,Open/Teases,VOs/SOTs,Podcast,Digital/Web,Fixes,Show Build,Show Update,Other Edit Self Reporting | Los Angeles             | 2, 5, 7,2, 5, 7,2, 5, 7,5               | LA - CNBC - 1       |
