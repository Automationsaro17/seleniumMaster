@NBCNewsCrewRequest_Nagative @ProducerDashboard @Negative @NBCNewsCrewRequest
Feature: Validate various scenarios related NBC News Crew

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role

  @NBCNewsCrewRequest_Missing_all_field
  Scenario Outline: Verify user submit button without filling any fields in NBC News Crew request form
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    When user clicks on "submit" button
    When user clicks on "ok" button
    Then verify the mandatory sections highlights as incomplete in NBC News Crew form
      | Error sections                                                                                                |
      | GENERAL DETAILS,PRODUCER DETAILS,FIELD CONTACT,SHOW INFO,SHOOT DETAILS,SHOOT SPECS,SHOOT LOCATION,DATE & TIME |
    Then Verify error message is displayed for all mandatory fields in general details section for NBC News Crew form
      | Slug Error    |
      | Enter a value |
    Then Verify error message is displayed for all mandatory fields in producer deatils section for NBC News Crew form
      | Producer Error | Sr Producer Error | Is There An Onsite Producer Error |
      | Select a value | Select a value    | Select a value                    |
    Then Verify error message is displayed for all mandatory fields in field contact section for NBC News Crew form
      | Producer Cell Number Error |
      | Enter a value              |
    Then Verify error message is displayed for all mandatory fields in show info section for NBC News Crew form
      | Show Title Budget Code Error |
      | Select a Budget Code         |
    Then Verify error message is displayed for all mandatory fields in shoot details section In NBC News Crew form
      | Production Type Error | Shoot Description Error |
      | Select a value        | Enter a value           |
    Then Verify error message is displayed for all mandatory fields in shoot specs section In NBC News Crew form
      | Audio Needs Error | Special Conditions Error | Transmission Type Error | Acquisition Specs Error | Drone Shoot Error |
      | Select a value    | Select a value           | Select a value          | Select a value          | Select a value    |
    Then Verify error message is displayed for all mandatory fields in shoot location section In NBC News Crew form
      | Address Error | City Error    | State Error    | Country Error  |
      | Enter a value | Enter a value | Select a value | Select a value |
    Then Verify error message is displayed for all mandatory fields in date & time section In NBC News Crew form
      | Shoot Dates Error | Time Zone Error | Meet Time Error                           | Roll Time Error                         | End Time Error                                 |
      | Select dates      | Select a value  | Must be the same or before the Start Time | Must be the same or after the Meet Time | Must be at least one hour after the Start Time |
    When user clicks on "NBCU Logo" button
    And user logs out from application

    Examples: 
      | Form Name |
      | NBC News  |

  @NBCNewsCrewRequest_Missing_mandatory_field
  Scenario Outline: Verify user submit button with filling only non mandatory fields in NBC News Crew request form
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    Then user enters General info in NBC News Crew form
      | Slug | NCX Story Name | Additional Requesters | Is Producer Same as Requestor | Sr Producer | Is Onsite Producer | Talent              |
      |      |                | Solai                 |                               |             |                    | test/tesr/test/test |
    When user enters field contact Information in NBC News Crew form
      | Field Contact | Phone |
      |               |       |
    When user enters show title Information in NBC News Crew form
      | ShowTitle |
      |           |
    When user enters shoot details Information in NBC News Crew form
      | Production Type | Shoot Status | Shoot Description |
      |                 |              |                   |
    When user enters shoot specs Information in NBC News Crew form
      | Audio Needs | Special Conditions | Transmission Type | Acquisition Specs | Is this a Drone Shoot | Special Gear |
      |             |                    |                   |                   |                       | No           |
    When user enters shoot location Information in NBC News Crew form
      | Shoot Location | Risk Assessment Category | Risk Assessment Type | Risk Arrangements | Risk Approver |
      |                |                          |                      |                   |               |
    When user enters Date & Time Information in NBC News Crew form
      | Shoot Start Date | Shoot End Date | Time Zone | Meet Time | Start Time | End Time |
      |                  |                |           |           |            |          |
    And user clicks on "Submit" button
    When user clicks on "ok" button
    Then verify the mandatory sections highlights as incomplete in NBC News Crew form
      | Error sections                                                                                                |
      | GENERAL DETAILS,PRODUCER DETAILS,FIELD CONTACT,SHOW INFO,SHOOT DETAILS,SHOOT SPECS,SHOOT LOCATION,DATE & TIME |
    Then Verify error message is displayed for all mandatory fields in general details section for NBC News Crew form
      | Slug Error    |
      | Enter a value |
    Then Verify error message is displayed for all mandatory fields in producer deatils section for NBC News Crew form
      | Producer Error | Sr Producer Error | Is There An Onsite Producer Error |
      | Select a value | Select a value    | Select a value                    |
    Then Verify error message is displayed for all mandatory fields in field contact section for NBC News Crew form
      | Producer Cell Number Error |
      | Enter a value              |
    Then Verify error message is displayed for all mandatory fields in show info section for NBC News Crew form
      | Show Title Budget Code Error |
      | Select a Budget Code         |
    Then Verify error message is displayed for all mandatory fields in shoot details section In NBC News Crew form
      | Production Type Error | Shoot Description Error |
      | Select a value        | Enter a value           |
    Then Verify error message is displayed for all mandatory fields in shoot specs section In NBC News Crew form
      | Audio Needs Error | Special Conditions Error | Transmission Type Error | Acquisition Specs Error | Drone Shoot Error |
      | Select a value    | Select a value           | Select a value          | Select a value          | Select a value    |
    Then Verify error message is displayed for all mandatory fields in shoot location section In NBC News Crew form
      | Address Error | City Error    | State Error    | Country Error  |
      | Enter a value | Enter a value | Select a value | Select a value |
    Then Verify error message is displayed for all mandatory fields in date & time section In NBC News Crew form
      | Shoot Dates Error | Time Zone Error | Meet Time Error                           | Roll Time Error                         | End Time Error                                 |
      | Select dates      | Select a value  | Must be the same or before the Start Time | Must be the same or after the Meet Time | Must be at least one hour after the Start Time |
    When user clicks on "NBCU Logo" button
    And user logs out from application

    Examples: 
      | Form Name |
      | NBC News  |

  @NBCNewsCrewRequest_Missing_non_mandatory_field
  Scenario Outline: Verify user submit button with filling only mandatory fields in NBC News Crew request form
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    Then user enters General info in NBC News Crew form
      | Slug | NCX Story Name | Additional Requesters | Is Producer Same as Requestor | Sr Producer  | Is Onsite Producer | Talent |
      | Wind |                |                       | Magesh                        | Jeevanandham | Yes                |        |
    When user enters field contact Information in NBC News Crew form
      | Field Contact | Phone      |
      | Jeevanandham  | 9898989877 |
    When user enters show title Information in NBC News Crew form
      | ShowTitle |
      | NBC News  |
    When user enters shoot details Information in NBC News Crew form
      | Production Type | Shoot Status | Shoot Description   |
      | LIVE - Anchor   | Tent         | test/tesr/test/test |
    When user enters shoot specs Information in NBC News Crew form
      | Audio Needs   | Special Conditions | Transmission Type | Acquisition Specs | Is this a Drone Shoot | Special Gear |
      | Complex Audio | Weather concern    | LIVEU             | Defer to Crew     | No                    |              |
    When user enters shoot location Information in NBC News Crew form
      | Shoot Location | Risk Assessment Category | Risk Assessment Type | Risk Arrangements | Risk Approver |
      | Miami Bureau   |                          |                      |                   |               |
    When user enters Date & Time Information in NBC News Crew form
      | Shoot Start Date | Shoot End Date | Time Zone | Meet Time     | Start Time    | End Time      |
      | CurrentDate+6    | CurrentDate+9  | PT        | CurrentTime+1 | CurrentTime+2 | CurrentTime+3 |
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
      | NBC News  |

  @NBCNewsCrewRequest_no_Missing_field
  Scenario Outline: Verify user submit button with filling all fields in NBC News Crew request form
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    Then user enters General info in NBC News Crew form
      | Slug | NCX Story Name | Additional Requesters | Is Producer Same as Requestor | Sr Producer  | Is Onsite Producer | Talent              |
      | Wind |                | Solai                 | Magesh                        | Jeevanandham | Yes                | test/tesr/test/test |
    When user enters field contact Information in NBC News Crew form
      | Field Contact | Phone      |
      | Jeevanandham  | 9898989877 |
    When user enters show title Information in NBC News Crew form
      | ShowTitle |
      | NBC News  |
    When user enters shoot details Information in NBC News Crew form
      | Production Type | Shoot Status | Shoot Description   |
      | LIVE - Anchor   | Tent         | test/tesr/test/test |
    When user enters shoot specs Information in NBC News Crew form
      | Audio Needs   | Special Conditions | Transmission Type | Acquisition Specs | Is this a Drone Shoot | Special Gear |
      | Complex Audio | Weather concern    | LIVEU             | Defer to Crew     | No                    | No           |
    When user enters shoot location Information in NBC News Crew form
      | Shoot Location | Risk Assessment Category | Risk Assessment Type | Risk Arrangements | Risk Approver |
      | Miami Bureau   |                          |                      |                   |               |
    When user enters Date & Time Information in NBC News Crew form
      | Shoot Start Date | Shoot End Date | Time Zone | Meet Time     | Start Time    | End Time      |
      | CurrentDate+6    | CurrentDate+9  | PT        | CurrentTime+1 | CurrentTime+2 | CurrentTime+3 |
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
      | NBC News  |
