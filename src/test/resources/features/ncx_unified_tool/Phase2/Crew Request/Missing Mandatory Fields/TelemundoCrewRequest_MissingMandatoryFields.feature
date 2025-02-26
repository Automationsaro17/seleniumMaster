@TelemundoCrewRequest_Nagative @ProducerDashboard @Negative @TelemundoCrewRequest
Feature: Validate various scenarios related Telemundo Crew

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role

  @TelemundoCrewRequest_Missing_all_field
  Scenario Outline: Verify user submit button without filling any fields in Telemundo Crew request form
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    When user clicks on "submit" button
    When user clicks on "ok" button
    Then verify the mandatory sections highlights as incomplete in Telemundo Crew form
      | Error sections                                                                                                |
      | GENERAL DETAILS,PRODUCER DETAILS,FIELD CONTACT,SHOW INFO,SHOOT DETAILS,SHOOT SPECS,SHOOT LOCATION,DATE & TIME |
    Then Verify error message is displayed for all mandatory fields in general details section for Telemundo Crew form
      | Slug Error    |
      | Enter a value |
    Then Verify error message is displayed for all mandatory fields in producer deatils section for Telemundo Crew form
      | Producer Error | Sr Producer Error | Is There An Onsite Producer Error |
      | Select a value | Select a value    | Select a value                    |
    Then Verify error message is displayed for all mandatory fields in field contact section for Telemundo Crew form
      | Producer Cell Number Error |
      | Enter a value              |
    Then Verify error message is displayed for all mandatory fields in show info section for Telemundo Crew form
      | Show Title Budget Code Error |
      | Select a Budget Code         |
    Then Verify error message is displayed for all mandatory fields in shoot details section In Telemundo Crew form
      | Production Type Error | Shoot Description Error |
      | Select a value        | Enter a value           |
    Then Verify error message is displayed for all mandatory fields in shoot specs section In Telemundo Crew form
      | Audio Needs Error | Special Conditions Error | Transmission Type Error | Acquisition Specs Error | Drone Shoot Error |
      | Select a value    | Select a value           | Select a value          | Select a value          | Select a value    |
    Then Verify error message is displayed for all mandatory fields in shoot location section In Telemundo Crew form
      | Address Error | City Error    | State Error    | Country Error  |
      | Enter a value | Enter a value | Select a value | Select a value |
    Then Verify error message is displayed for all mandatory fields in date & time section In Telemundo Crew form
      | Shoot Dates Error | Time Zone Error | Meet Time Error                           | Roll Time Error                         | End Time Error                                 |
      | Select dates      | Select a value  | Must be the same or before the Start Time | Must be the same or after the Meet Time | Must be at least one hour after the Start Time |
    When user clicks on "NBCU Logo" button
    And user logs out from application

    Examples: 
      | Form Name |
      | Telemundo News|

  @TelemundoCrewRequest_Missing_mandatory_field
  Scenario Outline: Verify user submit button with filling only non mandatory fields in Telemundo Crew request form
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    Then user enters General info in Telemundo Crew form
      | Slug | NCX Story Name | Additional Requesters | Is Producer Same as Requestor | Sr Producer | Is Onsite Producer | Talent              |
      |      |                | Solai                 |                               |             |                    | test/tesr/test/test |
    When user enters field contact Information in Telemundo Crew form
      | Field Contact | Phone |
      |               |       |
    When user enters show title Information in Telemundo Crew form
      | ShowTitle |
      |           |
    When user enters shoot details Information in Telemundo Crew form
      | Production Type | Shoot Status | Shoot Description |
      |                 |              |                   |
    When user enters shoot specs Information in Telemundo Crew form
      | Audio Needs | Special Conditions | Transmission Type | Is this a Drone Shoot | iPad Prompter Required | Special Gear |
      |             |                    |                   |                       | No                     | No           |
    When user enters shoot location Information in Telemundo Crew form
      | Shoot Location | Risk Assessment Category | Risk Assessment Type | Risk Arrangements | Risk Approver |
      |                |                          |                      |                   |               |
    When user enters Date & Time Information in Telemundo Crew form
      | Shoot Start Date | Shoot End Date | Time Zone | Meet Time | Start Time | End Time |
      |                  |                |           |           |            |          |
    And user clicks on "Submit" button
    When user clicks on "ok" button
    Then verify the mandatory sections highlights as incomplete in Telemundo Crew form
      | Error sections                                                                                                |
      | GENERAL DETAILS,PRODUCER DETAILS,FIELD CONTACT,SHOW INFO,SHOOT DETAILS,SHOOT SPECS,SHOOT LOCATION,DATE & TIME |
    Then Verify error message is displayed for all mandatory fields in general details section for Telemundo Crew form
      | Slug Error    |
      | Enter a value |
    Then Verify error message is displayed for all mandatory fields in producer deatils section for Telemundo Crew form
      | Producer Error | Sr Producer Error | Is There An Onsite Producer Error |
      | Select a value | Select a value    | Select a value                    |
    Then Verify error message is displayed for all mandatory fields in field contact section for Telemundo Crew form
      | Producer Cell Number Error |
      | Enter a value              |
    Then Verify error message is displayed for all mandatory fields in show info section for Telemundo Crew form
      | Show Title Budget Code Error |
      | Select a Budget Code         |
    Then Verify error message is displayed for all mandatory fields in shoot details section In Telemundo Crew form
      | Production Type Error | Shoot Description Error |
      | Select a value        | Enter a value           |
    Then Verify error message is displayed for all mandatory fields in shoot specs section In Telemundo Crew form
      | Audio Needs Error | Special Conditions Error | Transmission Type Error | Acquisition Specs Error | Drone Shoot Error |
      | Select a value    | Select a value           | Select a value          | Select a value          | Select a value    |
    Then Verify error message is displayed for all mandatory fields in shoot location section In Telemundo Crew form
      | Address Error | City Error    | State Error    | Country Error  |
      | Enter a value | Enter a value | Select a value | Select a value |
    Then Verify error message is displayed for all mandatory fields in date & time section In Telemundo Crew form
      | Shoot Dates Error | Time Zone Error | Meet Time Error                           | Roll Time Error                         | End Time Error                                 |
      | Select dates      | Select a value  | Must be the same or before the Start Time | Must be the same or after the Meet Time | Must be at least one hour after the Start Time |
    When user clicks on "NBCU Logo" button
    And user logs out from application

    Examples: 
      | Form Name      |
      | Telemundo News |

  @TelemundoCrewRequest_Missing_non_mandatory_field
  Scenario Outline: Verify user submit button with filling only mandatory fields in Telemundo Crew request form
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    Then user enters General info in Telemundo Crew form
      | Slug | NCX Story Name | Additional Requesters | Is Producer Same as Requestor | Sr Producer  | Is Onsite Producer | Talent |
      | Wind |                |                       | Magesh                        | Jeevanandham | Yes                |        |
    When user enters field contact Information in Telemundo Crew form
      | Field Contact | Phone      |
      | Jeevanandham  | 9898989877 |
    When user enters show title Information in Telemundo Crew form
      | ShowTitle |
      | CNBC      |
    When user enters shoot details Information in Telemundo Crew form
      | Production Type | Shoot Status | Shoot Description   |
      | LIVE - Anchor   | Tent         | test/tesr/test/test |
    When user enters shoot specs Information in Telemundo Crew form
      | Audio Needs   | Special Conditions | Transmission Type | Is this a Drone Shoot | iPad Prompter Required | Special Gear |
      | Complex Audio | Weather concern    | LIVEU             | No                    |                        |              |
    When user enters shoot location Information in Telemundo Crew form
      | Shoot Location | Risk Assessment Category | Risk Assessment Type | Risk Arrangements | Risk Approver |
      | Miami Bureau   |                          |                      |                   |               |
    When user enters Date & Time Information in Telemundo Crew form
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
      | Form Name      |
      | Telemundo News |

  @TelemundoCrewRequest_no_Missing_field
  Scenario Outline: Verify user submit button with filling all fields in Telemundo Crew request form
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    Then user enters General info in Telemundo Crew form
      | Slug | NCX Story Name | Additional Requesters | Is Producer Same as Requestor | Sr Producer  | Is Onsite Producer | Talent              |
      | Wind |                | Solai                 | Magesh                        | Jeevanandham | Yes                | test/tesr/test/test |
    When user enters field contact Information in Telemundo Crew form
      | Field Contact | Phone      |
      | Jeevanandham  | 9898989877 |
    When user enters show title Information in Telemundo Crew form
      | ShowTitle |
      | CNBC      |
    When user enters shoot details Information in Telemundo Crew form
      | Production Type | Shoot Status | Shoot Description   |
      | LIVE - Anchor   | Tent         | test/tesr/test/test |
    When user enters shoot specs Information in Telemundo Crew form
      | Audio Needs   | Special Conditions | Transmission Type | Is this a Drone Shoot | iPad Prompter Required | Special Gear |
      | Complex Audio | Weather concern    | LIVEU             | No                    | No                     | No           |
    When user enters shoot location Information in Telemundo Crew form
      | Shoot Location | Risk Assessment Category | Risk Assessment Type | Risk Arrangements | Risk Approver |
      | Miami Bureau   |                          |                      |                   |               |
    When user enters Date & Time Information in Telemundo Crew form
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
      | Form Name      |
      | Telemundo News |
