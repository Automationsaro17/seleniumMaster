@FeedOutRequest @ProducerDashboard
Feature: Validate various scenarios related Feed Out Request

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role

  @FeedOutRequest_Basic_Flow
  Scenario Outline: Verify user filling Feed Out request form
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in Feed Out Request form
      | Slug | NCX Story Name | Division    | Additional Requesters | Additional Recipients           | Is Producer Same as Requestor | Sr Producer  | Talent              |
      | Test |                | Engineering |                       | sainath@gyk.com,sainath@msk.com | yes                           | Jeevanandham | test/tesr/test/test |
    #| Sainath.Peddina@nbcuni.com,206736124@tfayd.com |
    ##################Feed Out Request######################################
    When user enters show info Information in Feed Out Request form
      | Show Unit      | Budget Code | Air Date      | Air Time      |
      | CNBC,MSNBC,News |             | CurrentDate+3 | CurrentTime+3 |
    When user enters Date Needed By and Time Needed By info in Feed Out Request form
      | Date Needed By | Time Needed By |
      | CurrentDate+10 | CurrentTime+10 |
    When user enters source info in Feed Out Request form
      | Source                    | Slug                                | Quantity | Comments                                                  |
      | Tapes,CNBC- Stratus,Tapes | Test Slug 1,Test Slug 2,Test Slug 3 |   10,5,8 | Test Test Tapes, Test Test CNBC- Stratus, Test Test Tapes |
    When user selects Final Destination in Feed Out Request form
      | Final Destination                      |
      | WG01,WG06, 30 Rock, Other destinations |
    When user enters content description info in Feed Out Request form
      | Content Description                                    |
      | Testing info Content Testing info Content Testing info |
    When user enters comments info in Feed Out Request form
      | Comments                               |
      | Testing info Testing info Testing info |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    And user logs out from application

    ########################################################
    Examples: 
      | Form Name |
      | Feed Out  |

  @FeedOutRequest_different_divisions_location_destination
  Scenario Outline: Verify user filling Feed Out request form with different divisions,Destination
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in Feed Out Request form
      | Slug | NCX Story Name | Division   | Additional Requesters | Additional Recipients           | Is Producer Same as Requestor | Sr Producer  | Talent              |
      | Test |                | <Division> |                       | sainath@gyk.com,sainath@msk.com | yes                           | Jeevanandham | test/tesr/test/test |
    #| Sainath.Peddina@nbcuni.com,206736124@tfayd.com |
    ##################Feed Out Request######################################
    When user enters show info Information in Feed Out Request form
      | Show Unit      | Budget Code | Air Date      | Air Time      |
      | CNBC,MSNBC,News |             | CurrentDate+3 | CurrentTime+3 |
    When user enters Date Needed By and Time Needed By info in Feed Out Request form
      | Date Needed By | Time Needed By |
      | CurrentDate+10 | CurrentTime+10 |
    When user enters source info in Feed Out Request form
      | Source                    | Slug                                | Quantity | Comments                                                  |
      | Tapes,CNBC- Stratus,Tapes | Test Slug 1,Test Slug 2,Test Slug 3 |   10,5,8 | Test Test Tapes, Test Test CNBC- Stratus, Test Test Tapes |
    When user selects Final Destination in Feed Out Request form
      | Final Destination   |
      | <Final Destination> |
    When user enters content description info in Feed Out Request form
      | Content Description                                    |
      | Testing info Content Testing info Content Testing info |
    When user enters comments info in Feed Out Request form
      | Comments                               |
      | Testing info Testing info Testing info |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    And user logs out from application

    ########################################################
    Examples: 
      | Form Name | Division         | Final Destination                      |
      | Feed Out  | NBC News         | WG01,WG06, 30 Rock, Other destinations |
      | Feed Out  | MSNBC            | TV-18 - India,CNBC - San Francisco    |
      | Feed Out  | CNBC             | WG01,WG06, 30 Rock, Other destinations |
      | Feed Out  | Acorn            | TV-18 - India,CNBC - San Francisco    |
      | Feed Out  | Corporate        | WG01,WG06, 30 Rock, Other destinations |
      | Feed Out  | Engineering      | TV-18 - India,CNBC - San Francisco    |
      | Feed Out  | Entertainment    | WG01,WG06, 30 Rock, Other destinations |
      | Feed Out  | ERG Events       | TV-18 - India,CNBC - San Francisco    |
      | Feed Out  | Facilities       | WG01,WG06, 30 Rock, Other destinations |
      | Feed Out  | NBC News Studios | WG01,WG06, 30 Rock, Other destinations |
      | Feed Out  | NBC Sports       | TV-18 - India,CNBC - San Francisco    |
      | Feed Out  | News Digital     | WG01,WG06, 30 Rock, Other destinations |
      | Feed Out  | Olympics         | WG01,WG06, 30 Rock, Other destinations |
      | Feed Out  | Operations       | TV-18 - India,CNBC - San Francisco    |
      | Feed Out  | Peacock          | TV-18 - India,CNBC - San Francisco    |
      | Feed Out  | Telemundo        | WG01,WG06, 30 Rock, Other destinations |
      | Feed Out  | Universal Kids   | WG01,WG06, 30 Rock, Other destinations |
