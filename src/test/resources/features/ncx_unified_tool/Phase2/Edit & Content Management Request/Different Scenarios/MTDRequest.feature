@MTDRequest @ProducerDashboard
Feature: Validate various scenarios related MTD Request

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role

  @MTDRequest_Basic_Flow
  Scenario Outline: Verify user filling MTD request form
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in MTD Request form
      | Slug | NCX Story Name | Division    | Additional Requesters | Is Producer Same as Requestor | Sr Producer  | Talent              |
      | Test |                | Engineering |                       | yes                           | Jeevanandham | test/tesr/test/test |
    #| Sainath.Peddina@nbcuni.com,206736124@tfayd.com |
    ##################MTD Request######################################
    When user enters show info Information in MTD Request form
      | Show Unit      | Budget Code | Air Date      | Air Time      |
      | CNBC,MSNBC,News |             | CurrentDate+3 | CurrentTime+3 |
    When user enters Date Needed By and Time Needed By info in MTD Request form
      | Date Needed By | Time Needed By |
      | CurrentDate+10 | CurrentTime+10 |
    When user enters source info in MTD Request form
      | Source          | Source Details                              | Time Codes                                                                           | Camera                    |
      | Hard Drive,WG01 | Test Source Details 1,Test Source Details 2 | Matching Time Code For All Clips, Merging Together Clips Without Retaining Time Code | Canon 5D Mark II,Canon R6 |
    When user selects Final Destination in MTD Request form
      | Destination               | Quantity | Details                                            |
      | Hard Drive,Stratus,Bluray |  5,10,15 | testing Hard Drive,testing Stratus, testing Bluray |
    When user enters Instructions info in MTD Request form
      | Instructions                                                    |
      | Instructions Merging Together Clips Without Retaining Time Code |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    And user logs out from application

    ########################################################
    Examples: 
      | Form Name                                      |
      | Media Transcoding / Transferring / Duplication |

  @MTDRequest_different_divisions_destination_source_quantity_camera
  Scenario Outline: Verify user filling MTD request form with different divisions,Destination,Source,Quantity,Camera
    ############################ user submitting the general details form ############################
    And user clicks on forms link
    And user selects "<Form Name>" form
    And user enters General info in MTD Request form
      | Slug | NCX Story Name | Division   | Additional Requesters | Is Producer Same as Requestor | Sr Producer  | Talent              |
      | Test |                | <Division> |                       | yes                           | Jeevanandham | test/tesr/test/test |
    #| Sainath.Peddina@nbcuni.com,206736124@tfayd.com |
    ##################MTD Request######################################
    When user enters show info Information in MTD Request form
      | Show Unit      | Budget Code | Air Date      | Air Time      |
      | CNBC,MSNBC,News |             | CurrentDate+3 | CurrentTime+3 |
    When user enters Date Needed By and Time Needed By info in MTD Request form
      | Date Needed By | Time Needed By |
      | CurrentDate+10 | CurrentTime+10 |
    When user enters source info in MTD Request form
      | Source   | Source Details                                                    | Time Codes                                                                                                            | Camera   |
      | <Source> | Test Source Details 1,Test Source Details 2,Test Source Details 3 | Matching Time Code For All Clips, Merging Together Clips Without Retaining Time Code,Matching Time Code For All Clips | <Camera> |
    When user selects Final Destination in MTD Request form
      | Destination   | Quantity   | Details                                                                              |
      | <Destination> | <Quantity> | testing test/tesr/test/test,testing test/tesr/test/test, testing test/tesr/test/test |
    When user enters Instructions info in MTD Request form
      | Instructions                                                    |
      | Instructions Merging Together Clips Without Retaining Time Code |
    And user clicks on "Submit" button
    Then user get the Request ID with Request Type from Success message
    And user clicks on "ok" button
    And user logs out from application

    ########################################################
    Examples: 
      | Form Name                                      | Division | Destination               | Source      | Quantity | Camera               |
      | Media Transcoding / Transferring / Duplication | NBC News | Hard Drive,Stratus,Bluray | Cfast,P2,SD |   10,5,8 | Canon R6, Canon C300 |
      | Media Transcoding / Transferring / Duplication | MSNBC            | Media Shuttle,Send This File,CNBC Dropbox | WG01, CF Express, Micro SD            | 2, 5, 7  | Sony F3,Sony F5                           |
      | Media Transcoding / Transferring / Duplication | CNBC             | Hard Drive,Stratus,Bluray                 | WG02, CNBC Dropbox, Hard Drive        | 1,3, 6   | Sony FX3,Sony FX9V                        |
      | Media Transcoding / Transferring / Duplication | Acorn            | Media Shuttle,Send This File,CNBC Dropbox | VHS, CD, Media Shuttle                |    2,4,7 | Panasonic GH4                             |
      | Media Transcoding / Transferring / Duplication | Corporate        | Hard Drive,Stratus,Bluray                 | Cfast,P2,SD                           |    1,4,6 | Panasonic EVA1,Panasonic Varicam          |
      | Media Transcoding / Transferring / Duplication | Engineering      | Media Shuttle,Send This File,CNBC Dropbox | Solid State Drive,Other,We Transfer * |    2,5,8 | GoPro Hero 11, GoPro Hero 10,GoPro Hero 4 |
      | Media Transcoding / Transferring / Duplication | Entertainment    | Hard Drive,Stratus,Bluray                 | WG01, CF Express, Micro SD            | 2, 5, 7  | Sony F3,Sony F5                           |
      | Media Transcoding / Transferring / Duplication | ERG Events       | Media Shuttle,Send This File,CNBC Dropbox | WG02, CNBC Dropbox, Hard Drive        | 1,3, 6   | Sony FX3,Sony FX9V                        |
      | Media Transcoding / Transferring / Duplication | Facilities       | Hard Drive,Stratus,Bluray                 | VHS, CD, Media Shuttle                |    2,4,7 | Panasonic GH4                             |
      | Media Transcoding / Transferring / Duplication | NBC News Studios | Hard Drive,Stratus,Bluray                 | Cfast,P2,SD                           |    1,4,6 | Panasonic EVA1,Panasonic Varicam          |
      | Media Transcoding / Transferring / Duplication | NBC Sports       | Media Shuttle,Send This File,CNBC Dropbox | Solid State Drive,Other,We Transfer * |    2,5,8 | GoPro Hero 11, GoPro Hero 10,GoPro Hero 4 |
      | Media Transcoding / Transferring / Duplication | News Digital     | Hard Drive,Stratus,Bluray                 | WG01, CF Express, Micro SD            | 2, 5, 7  | Sony F3,Sony F5                           |
      | Media Transcoding / Transferring / Duplication | Olympics         | Hard Drive,Stratus,Bluray                 | WG02, CNBC Dropbox, Hard Drive        | 1,3, 6   | Sony FX3,Sony FX9V                        |
      | Media Transcoding / Transferring / Duplication | Operations       | Media Shuttle,Send This File,CNBC Dropbox | VHS, CD, Media Shuttle                |    2,4,7 | Panasonic GH4                             |
      | Media Transcoding / Transferring / Duplication | Peacock          | Media Shuttle,Send This File,CNBC Dropbox | Cfast,P2,SD                           |    1,4,6 | Panasonic EVA1,Panasonic Varicam          |
      | Media Transcoding / Transferring / Duplication | Telemundo        | Hard Drive,Stratus,Bluray                 | Solid State Drive,Other,We Transfer * |    2,5,8 | GoPro Hero 11, GoPro Hero 10,GoPro Hero 4 |
      | Media Transcoding / Transferring / Duplication | Universal Kids   | Hard Drive,Stratus,Bluray                 | WG01, CF Express, Micro SD            | 2, 5, 7  | Sony F3,Sony F5                           |
