@FileIngestRequest @ProducerDashboard
Feature: Validate various scenarios related File Ingest Request

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role

  @FileIngestRequest_Basic_Flow
  Scenario Outline: Verify user filling File Ingest request form
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in File Ingest Request form
      | Slug | NCX Story Name | Division    | Additional Requesters | Additional Recipients           | Is Producer Same as Requestor | Sr Producer  | Talent              |
      | Test |                | Engineering |                       | sainath@gyk.com,sainath@msk.com | yes                           | Jeevanandham | test/tesr/test/test |
    #| Sainath.Peddina@nbcuni.com,206736124@tfayd.com |
    ##################File Ingest Request######################################
    When user enters show info Information in File Ingest Request form
      | Show Unit      | Budget Code | Air Date      | Air Time      |
      | CNBC,MSNBC,News |             | CurrentDate+3 | CurrentTime+3 |
    When user enters Date Needed By and Time Needed By info in File Ingest Request form
      | Date Needed By | Time Needed By |
      | CurrentDate+10 | CurrentTime+10 |
    When user enters source info in File Ingest Request form
      | Source      | Quantity | Comments                                    | Camera               |
      | Cfast,P2,SD |   10,5,8 | Test Test Cfast, Test Test P2, Test Test SD | Canon R6, Canon C300 |
    When user selects Final Destination in File Ingest Request form
      | Final Destination |
      | WG01,WG06         |
    When user enters content description info in File Ingest Request form
      | Content Description                                    |
      | Testing info Content Testing info Content Testing info |
    When user enters comments info in File Ingest Request form
      | Comments                               |
      | Testing info Testing info Testing info |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    And user logs out from application

    ########################################################
    Examples: 
      | Form Name   |
      | File Ingest |

  @FileIngestRequest_different_divisions_destination_source_quantity_camera
  Scenario Outline: Verify user filling File Ingest request form with different divisions,Destination,Source,Quantity,Camera
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in File Ingest Request form
      | Slug | NCX Story Name | Division   | Additional Requesters | Additional Recipients           | Is Producer Same as Requestor | Sr Producer  | Talent              |
      | Test |                | <Division> |                       | sainath@gyk.com,sainath@msk.com | yes                           | Jeevanandham | test/tesr/test/test |
    #| Sainath.Peddina@nbcuni.com,206736124@tfayd.com |
    ##################File Ingest Request######################################
    When user enters show info Information in File Ingest Request form
      | Show Unit      | Budget Code | Air Date      | Air Time      |
      | CNBC,MSNBC,News |             | CurrentDate+3 | CurrentTime+3 |
    When user enters Date Needed By and Time Needed By info in File Ingest Request form
      | Date Needed By | Time Needed By |
      | CurrentDate+10 | CurrentTime+10 |
    When user enters source info in File Ingest Request form
      | Source   | Quantity   | Comments                                         | Camera   |
      | <Source> | <Quantity> | Test Test Test , Test Test Test , Test Test Test | <Camera> |
    When user selects Final Destination in File Ingest Request form
      | Final Destination   |
      | <Final Destination> |
    When user enters content description info in File Ingest Request form
      | Content Description                                    |
      | Testing info Content Testing info Content Testing info |
    When user enters comments info in File Ingest Request form
      | Comments                               |
      | Testing info Testing info Testing info |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    And user logs out from application

    ########################################################
    Examples: 
      | Form Name   | Division | Final Destination | Source      | Quantity | Camera               |
      | File Ingest | NBC News | WG01,WG06         | Cfast,P2,SD |   10,5,8 | Canon R6, Canon C300 |
      | File Ingest | MSNBC            | WG08,Nimbus,DC Network News | CF Card, CF Express, Micro SD        | 2, 5, 7  | Sony F3,Sony F5                           |
      | File Ingest | CNBC             | WG01,WG06                   | XDCAM DISC, SXS Card, Hard Drive     | 1,3, 6   | Sony FX3,Sony FX9V                        |
      | File Ingest | Acorn            | WG08,Nimbus,DC Network News | VHS, CD, Media Shuttle               |    2,4,7 | Panasonic GH4                             |
      | File Ingest | Corporate        | WG01,WG06                   | Bureau NAS, Producer Mailbox, Remote |    1,4,6 | Panasonic EVA1,Panasonic Varicam          |
      | File Ingest | Engineering      | WG08,Nimbus,DC Network News | Solid State Drive,Other,We Transfer  |    2,5,8 | GoPro Hero 11, GoPro Hero 10,GoPro Hero 4 |
      | File Ingest | Entertainment    | WG01,WG06                   | CF Card, CF Express, Micro SD        | 2, 5, 7  | Sony F3,Sony F5                           |
      | File Ingest | ERG Events       | WG08,Nimbus,DC Network News | XDCAM DISC, SXS Card, Hard Drive     | 1,3, 6   | Sony FX3,Sony FX9V                        |
      | File Ingest | Facilities       | WG01,WG06                   | VHS, CD, Media Shuttle               |    2,4,7 | Panasonic GH4                             |
      | File Ingest | NBC News Studios | WG01,WG06                   | Bureau NAS, Producer Mailbox, Remote |    1,4,6 | Panasonic EVA1,Panasonic Varicam          |
      | File Ingest | NBC Sports       | WG08,Nimbus,DC Network News | Solid State Drive,Other,We Transfer  |    2,5,8 | GoPro Hero 11, GoPro Hero 10,GoPro Hero 4 |
      | File Ingest | News Digital     | WG01,WG06                   | CF Card, CF Express, Micro SD        | 2, 5, 7  | Sony F3,Sony F5                           |
      | File Ingest | Olympics         | WG01,WG06                   | XDCAM DISC, SXS Card, Hard Drive     | 1,3, 6   | Sony FX3,Sony FX9V                        |
      | File Ingest | Operations       | WG08,Nimbus,DC Network News | VHS, CD, Media Shuttle               |    2,4,7 | Panasonic GH4                             |
      | File Ingest | Peacock          | WG08,Nimbus,DC Network News | Bureau NAS, Producer Mailbox, Remote |    1,4,6 | Panasonic EVA1,Panasonic Varicam          |
      | File Ingest | Telemundo        | WG01,WG06                   | Solid State Drive,Other,We Transfer  |    2,5,8 | GoPro Hero 11, GoPro Hero 10,GoPro Hero 4 |
      | File Ingest | Universal Kids   | WG01,WG06                   | CF Card, CF Express, Micro SD        | 2, 5, 7  | Sony F3,Sony F5                           |
