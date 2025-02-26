@NewsGearRequest_Nagative @ProducerDashboard @Negative @NewsGearRequest
Feature: Validate various scenarios related News Gear

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role

  @NewsGearRequest_Missing_all_field
  Scenario Outline: Verify user submit button without filling any fields in News Gear request form
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    When user clicks on "submit" button
    When user clicks on "ok" button
    Then verify the mandatory sections highlights as incomplete in News Gear form
      | Error sections                                                                       |
      | GENERAL DETAILS,PRODUCER DETAILS,GEAR USER,SHOW INFO,LOCATION,DATE & TIME,GEAR,USAGE |
    Then Verify error message is displayed for all mandatory fields in general details section for News Gear form
      | Slug Error    | Division Error |
      | Enter a value | Select a value |
    Then Verify error message is displayed for all mandatory fields in producer deatils section for News Gear form
      | Producer Error | Sr Producer Error |
      | Select a value | Select a value    |
    Then Verify error message is displayed for all mandatory fields in field contact section for News Gear form
      | Gear User Cell Number Error |
      | Enter a value               |
    Then Verify error message is displayed for all mandatory fields in show info section for News Gear form
      | Segment Type Error | Show Unit or Project Name Error        | Budget Code Error    |
      | Select a value     | Select at least one show from the list | Select a Budget Code |
    Then Verify error message is displayed for all mandatory fields in location date & time section In News Gear form
      | Location Error | Pick Up Date Error                      | Pick Up Time Error | Return Date Error                       |
      | Select a value | Select a date that has not yet occurred | Enter a value      | Select a date that has not yet occurred |
    Then Verify error message is displayed for all mandatory fields in usage section In News Gear form
      | Hidden Camera Micro Error | Outside Us Error | NBC Studio Location Error | Outsider Error | Description Error |
      | Select a value            | Select a value   | Select a value            | Select a value | Enter a value     |
    When user clicks on "NBCU Logo" button
    And user logs out from application

    Examples: 
      | Form Name |
      | News Gear |

  @NewsGearRequest_Missing_mandatory_field
  Scenario Outline: Verify user submit button with filling only non mandatory fields in News Gear request form
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in News Gear form
      | Slug | NCX Story Name | Division | Additional Requesters | Is Producer Same as Requestor | Sr Producer | Talent              |
      |      |                |          | Solai                 |                               |             | test/tesr/test/test |
    ############################ user selecting the form ############################
    When user enters Gear User Information in News Gear form
      | Gear User | Mobile Phone |
      |           |              |
    When user enters show info Information in News Gear form
      | Show Unit | Budget Code | Segment Type |
      |           |             |              |
    When user enters Logistic details Information in News Gear form
      | Location | Pick Up Date | Pick Up Time | Return Date |
      |          |              |              |             |
    When user enters Add Gear details Information in News Gear form
      | Type of Gear | How many | Comments |
      |              |          |          |
    When user enters Usage deatils Information in News Gear form
      | Is this the gear being used as a hidden camera or microphone? | Is this gear being used outside the US? | Will any wireless audio equipment be used in any NBC studio location? | Is this gear being given to someone outside of NBC Universal to use? | description |
      |                                                               |                                         |                                                                       |                                                                      |             |
    When user enters additional Information in News Gear form
      | additional info      |
      | Test additional info |
    And user clicks on "Submit" button
    When user clicks on "ok" button
    Then verify the mandatory sections highlights as incomplete in News Gear form
      | Error sections                                                                       |
      | GENERAL DETAILS,PRODUCER DETAILS,GEAR USER,SHOW INFO,LOCATION,DATE & TIME,GEAR,USAGE |
    Then Verify error message is displayed for all mandatory fields in general details section for News Gear form
      | Slug Error    | Division Error |
      | Enter a value | Select a value |
    Then Verify error message is displayed for all mandatory fields in producer deatils section for News Gear form
      | Producer Error | Sr Producer Error |
      | Select a value | Select a value    |
    Then Verify error message is displayed for all mandatory fields in field contact section for News Gear form
      | Gear User Cell Number Error |
      | Enter a value               |
    Then Verify error message is displayed for all mandatory fields in show info section for News Gear form
      | Segment Type Error | Show Unit or Project Name Error        | Budget Code Error    |
      | Select a value     | Select at least one show from the list | Select a Budget Code |
    Then Verify error message is displayed for all mandatory fields in location date & time section In News Gear form
      | Location Error | Pick Up Date Error                      | Pick Up Time Error | Return Date Error                       |
      | Select a value | Select a date that has not yet occurred | Enter a value      | Select a date that has not yet occurred |
    Then Verify error message is displayed for all mandatory fields in usage section In News Gear form
      | Hidden Camera Micro Error | Outside Us Error | NBC Studio Location Error | Outsider Error | Description Error |
      | Select a value            | Select a value   | Select a value            | Select a value | Enter a value     |
    When user clicks on "NBCU Logo" button
    And user logs out from application

    Examples: 
      | Form Name |
      | News Gear |

  @NewsGearRequest_Missing_non_mandatory_field
  Scenario Outline: Verify user submit button with filling only mandatory fields in News Gear request form
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in News Gear form
      | Slug | NCX Story Name | Division    | Additional Requesters | Is Producer Same as Requestor | Sr Producer  | Talent |
      | Test |                | Engineering |                       | yes                           | Jeevanandham |        |
    ############################ user selecting the form ############################
    When user enters Gear User Information in News Gear form
      | Gear User    | Mobile Phone |
      | Jeevanandham |  32453543343 |
    When user enters show info Information in News Gear form
      | Show Unit                   | Budget Code | Segment Type |
      | Capital Exchange Livestream,News |             | Live         |
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
      | additional info |
      |                 |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    And verify submitted "<Form Name>" is present in my request page with "NEW" status
    And verify "background color" of "NEW" status is "Pink" in my request page
    When user searches request in my request page
    And user click edit link of the request in "My Request page"
    When user clicks on "NBCU Logo" button
    And user logs out from application

    Examples: 
      | Form Name |
      | News Gear |

  @NewsGearRequest_no_Missing_field
  Scenario Outline: Verify user submit button with filling all fields in News Gear request form
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in News Gear form
      | Slug | NCX Story Name | Division    | Additional Requesters | Is Producer Same as Requestor | Sr Producer  | Talent              |
      | Test |                | Engineering | Solai                 | yes                           | Jeevanandham | test/tesr/test/test |
    ############################ user selecting the form ############################
    When user enters Gear User Information in News Gear form
      | Gear User    | Mobile Phone |
      | Jeevanandham |   9898989877 |
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
    And verify submitted "<Form Name>" is present in my request page with "NEW" status
    When user searches request in my request page
    And user click edit link of the request in "My Request page"
    When user clicks on "NBCU Logo" button
    And user logs out from application

    Examples: 
      | Form Name |
      | News Gear |
