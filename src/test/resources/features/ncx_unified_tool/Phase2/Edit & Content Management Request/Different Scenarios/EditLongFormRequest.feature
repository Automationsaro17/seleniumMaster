@EditLongFormRequest @ProducerDashboard
Feature: Validate various scenarios related Long Edit Request

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role

  @EditLongFormRequest_Basic_Flow
  Scenario Outline: Verify user filling Long Edit request form
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in Edit request form
      | Slug | NCX Story Name | Division    | Additional Requesters | Is Producer Same as Requestor | Sr Producer  | Talent              |
      | Test |                | Engineering |                       | yes                           | Jeevanandham | test/tesr/test/test |
    When user selects "Long Form" edit type in Edit request form
    ##################LongForm Edit Request######################################
    When user enters show info Information in Long Edit request form
      | Show Unit       | Budget Code | Air Date      | Air Time      | Date of First Screening |
      | CNBC,MSNBC,News |             | CurrentDate+3 | CurrentTime+3 | CurrentDate+5           |
    When user enters Show Length in Long Edit Request form
      | Length Of Show No of Acts | Length Of Show Hours | Length Of Show Minutes | Length Of Show Seconds |
      |                         8 |                    4 |                      5 |                     55 |
    When user enters Session details info in Long Edit Request form
      | Location | Edit Start Date | ediusOrAvid | No Of Editors | Edit Time Needed Weeks | Edit Time Needed Days | Edit Time Needed Hours |
      | London   | CurrentDate+15  | EDIUS       |             5 |                     10 |                    28 |                     12 |
    When user selects Final Delivery in Long Edit Request form
      | Final Delivery       |
      | Digital,Social,hello |
    When user enters asst producer info in Long Edit Request form
      | Asst Producer same as Requester |
      | Yes                             |
    When user enters Additional Recipients info in Long Edit Request form
      | Additional Recipients           |
      | sainath@gyk.com,sainath@msk.com |
    When user enters comments info in Long Edit Request form
      | Comments                               |
      | Testing info Testing info Testing info |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    And user logs out from application

    ########################################################
    Examples: 
      | Form Name |
      | Long Edit |

  @EditLongFormRequest_different_divisions_Location_Delivery
  Scenario Outline: Verify user filling Long Edit request form with different divisions, Location, Delivery
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in Edit request form
      | Slug | NCX Story Name | Division   | Additional Requesters | Is Producer Same as Requestor | Sr Producer  | Talent              |
      | Test |                | <Division> |                       | yes                           | Jeevanandham | test/tesr/test/test |
    When user selects "Long Form" edit type in Edit request form
    ##################LongForm Edit Request######################################
    When user enters show info Information in Long Edit request form
      | Show Unit       | Budget Code | Air Date      | Air Time      | Date of First Screening |
      | CNBC,MSNBC,News |             | CurrentDate+3 | CurrentTime+3 | CurrentDate+5           |
    When user enters Show Length in Long Edit Request form
      | Length Of Show No of Acts | Length Of Show Hours | Length Of Show Minutes | Length Of Show Seconds |
      |                         8 |                    4 |                      5 |                     55 |
    When user enters Session details info in Long Edit Request form
      | Location   | Edit Start Date | ediusOrAvid | No Of Editors | Edit Time Needed Weeks | Edit Time Needed Days | Edit Time Needed Hours |
      | <Location> | CurrentDate+15  | EDIUS       |             5 |                     10 |                    28 |                     12 |
    When user selects Final Delivery in Long Edit Request form
      | Final Delivery   |
      | <Final Delivery> |
    When user enters asst producer info in Long Edit Request form
      | Asst Producer same as Requester |
      | Yes                             |
    When user enters Additional Recipients info in Long Edit Request form
      | Additional Recipients           |
      | sainath@gyk.com,sainath@msk.com |
    When user enters comments info in Long Edit Request form
      | Comments                               |
      | Testing info Testing info Testing info |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    And user logs out from application

    ########################################################
    Examples: 
      | Form Name | Division         | Location                | Final Delivery       |
      | Long Edit | NBC News         | 30 Rock                 | Digital,Social,hello |
      | Long Edit | MSNBC            | London                  | Broadcast,Podcast    |
      | Long Edit | CNBC             | Los Angeles             | Digital,Social,hello |
      | Long Edit | Acorn            | CNBC - Englewood Cliffs | Broadcast,Podcast    |
      | Long Edit | Corporate        | Washington              | Digital,Social,hello |
      | Long Edit | Engineering      | CNBC - Washington DC    | Broadcast,Podcast    |
      | Long Edit | Entertainment    | 30 Rock                 | Digital,Social,hello |
      | Long Edit | ERG Events       | CNBC - Los Angeles      | Broadcast,Podcast    |
      | Long Edit | Facilities       | CNBC - Englewood Cliffs | Digital,Social,hello |
      | Long Edit | NBC News Studios | CNBC - Washington DC    | Digital,Social,hello |
      | Long Edit | NBC Sports       | Washington              | Broadcast,Podcast    |
      | Long Edit | News Digital     | Los Angeles             | Digital,Social,hello |
      | Long Edit | Olympics         | CNBC - Los Angeles      | Digital,Social,hello |
      | Long Edit | Operations       | London                  | Broadcast,Podcast    |
      | Long Edit | Peacock          | CNBC - Washington DC    | Broadcast,Podcast    |
      | Long Edit | Telemundo        | 30 Rock                 | Digital,Social,hello |
      | Long Edit | Universal Kids   | CNBC - Englewood Cliffs | Digital,Social,hello |
