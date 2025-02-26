#@NBCBreakingNewsCrewRequest @ProducerDashboard @END_TO_END
#Feature: Validate various scenarios related NBC Breaking News Crew
#
  #Background: 
    #Given user opens producer dashboard application
    #And user logins with "producer" role
#
  #@NBCBreakingNewsCrewRequest_e2e @SEVERITY=CRITICAL @CrewE2E
  #Scenario Outline: Verify user filling NBC Breaking News Crew Request form
    #And user clicks on forms link
    #And user selects "<Form Name>" form
    #Then user enters General info in NBC Breaking News Crew form
      #| Slug | NCX Story Name | Additional Requesters | Is Producer Same as Requestor | Sr Producer  | Is Onsite Producer | Talent              |
      #| Wind |                | Solai                 | Magesh                        | Jeevanandham | Yes                | test/tesr/test/test |
    #When user enters field contact Information in NBC Breaking News Crew form
      #| Field Contact | Phone      |
      #| Jeevanandham  | 9898989877 |
    #When user enters show title Information in NBC Breaking News Crew form
      #| ShowTitle |
      #| CNBC      |
    #When user enters shoot details Information in NBC Breaking News Crew form
      #| Shoot Description   |
      #| test/tesr/test/test |
    #When user enters shoot specs Information in NBC Breaking News Crew form
      #| Transmission Type | Is this a Drone Shoot |
      #| LIVEU             | No                    |
    #When user enters shoot location Information in NBC Breaking News Crew form
      #| Shoot Location | Risk Assessment Category | Risk Assessment Type | Risk Arrangements | Risk Approver |
      #| Miami Bureau   |                          |                      |                   |               |
    #When user enters Date & Time Information in NBC Breaking News Crew form
      #| Time Zone | Meet Time     | Start Time    | End Time      |
      #| PT        | CurrentTime+4 | CurrentTime+5 | CurrentTime+6 |
    #And user clicks on "Submit" button
    #Then user get the Request ID with Request Type from Success message
    #And user clicks on "ok" button
    ###################################################################################################
    #And verify submitted "<Form Name>" is present in my request page with "NEW" status
    #And verify "background color" of "NEW" status is "Pink" in my request page
    #When user searches request in my request page
    #And user click edit link of the request in "My Request page"
    ########################## user adding notes as requester ############################
    #When user verifies logs are displaying in Log section
    #When user click "Notes" tab in request form page
    #And user enters add notes details in Notes section
      #| Notes Info       |
      #| testr  requester |
    #And user clicks on "save" button
    #And verify submitted "<Form Name>" is present in my request page with "REVISED" status
    #And verify "background color" of "REVISED" status is "Orange" in my request page
    #When user clicks on "NBCU Logo" button
    #And user logs out from application
    ############################ user logging in as fulfiller and modifying the form request ############################
    #Given user opens producer dashboard application
    #And user logins with "fulfiller" role
    #And user opens fulfiller dashboard for "<Form Name>" form
    #When user searches request in fulfiller dashboard
    #Then verify "<Form Name>" is present in fulfiller dashboard with "REVISED" status
    #And verify "background color" of "REVISED" status is "Orange" in fullfiller dashboard
    #And user click edit link of the request in "fulfiller page"
    #When user verifies logs are displaying in Log section
    #When user enters shoot location Information in NBC Breaking News Crew form
      #| Shoot Location | Risk Assessment Category | Risk Assessment Type | Risk Arrangements | Risk Approver |
      #| Chicago Bureau |                          |                      |                   |               |
    ########################## user adding notes as fulfiller ############################
    #When user click "Notes" tab in request form page
    #And user enters add notes details in Notes section
      #| Notes Info       |
      #| testr  fulfiller |
    #When user clicks on "save" button
    #And user opens fulfiller dashboard for "<Form Name>" form
    #When user searches request in fulfiller dashboard
    #Then verify "<Form Name>" is present in fulfiller dashboard with "REVISED" status
    #And verify "background color" of "REVISED" status is "Orange" in fullfiller dashboard
    ############################ Efforting the form request ############################
    #And user click edit link of the request in "fulfiller page"
    #When user verifies logs are displaying in Log section
    #Then user click "fulfillment" tab in request form page
    #When user enters shoot specs in NBC Breaking News crew fulfillment section
      #| Primary Camera Type | Media Format | Video Specs |
      #| Specialty           | HDV          | 1080/24P    |
    #And user changes status to "EFFORTING"
    #And user clicks on "save" button
    #And user opens fulfiller dashboard for "<Form Name>" form
    #And user searches request in fulfiller dashboard
    #Then verify "<Form Name>" is present in fulfiller dashboard with "EFFORTING" status
    #And verify "background color" of "EFFORTING" status is "Blue" in fullfiller dashboard
    ############################ ROFR the form request ############################
    #And user click edit link of the request in "fulfiller page"
    #When user verifies logs are displaying in Log section
    #Then user click "fulfillment" tab in request form page
    #When user changes status to "ROFR"
    #When user clicks on "save" button
    #And user opens fulfiller dashboard for "<Form Name>" form
    #When user searches request in fulfiller dashboard
    #Then verify "<Form Name>" is present in fulfiller dashboard with "ROFR" status
    #And verify "background color" of "ROFR" status is "Blue" in fullfiller dashboard
    ############################ Booked the form request ############################
    #And user click edit link of the request in "fulfiller page"
    #When user verifies logs are displaying in Log section
    #Then user click "fulfillment" tab in request form page
    #When user changes status to "BOOKED"
    #When user clicks on "save" button
    #And user opens fulfiller dashboard for "<Form Name>" form
    #Then user clicks "Fulfilled" requests dropdown in Crew Dashboard
    #When user searches request in fulfiller dashboard
    #Then verify "<Form Name>" is present in fulfiller dashboard with "BOOKED" status
    #And verify "background color" of "BOOKED" status is "Green" in fullfiller dashboard
    #And user logs out from application
    ############################ user logging in as producer and modifying the request  ############################
    #Given user opens producer dashboard application
    #And user logins with "producer" role
    #When user searches request in my request page
    #And user click edit link of the request in "My Request page"
    #When user verifies logs are displaying in Log section
    #When user enters shoot location Information in NBC Breaking News Crew form
      #| Shoot Location | Risk Assessment Category | Risk Assessment Type | Risk Arrangements | Risk Approver |
      #| White House    |                          |                      |                   |               |
    #When user clicks on "save" button
    #And verify submitted "<Form Name>" is present in my request page with "REVISED" status
    #And verify "background color" of "REVISED" status is "Orange" in my request page
    #When user clicks on "NBCU Logo" button
    ############################ user submitting cancel request ############################
    #When user searches request in my request page
    #And user click edit link of the request in "My Request page"
    #When user verifies logs are displaying in Log section
    #When user clicks on "cancel request" button
    #And verify "cancel request" alert message
      #| Cancel Request Alert Message                                                                                               |
      #| Are you sure you want to cancel this request? All cancellations are pending until confirmed by fulfillment teams |
    #And click "Yes" on "cancel request" alert message
    #Then verify request is "Cancellation Requested" successfully
    #When user clicks on "NBCU Logo" button
    #When user searches request in my request page
    #And verify submitted "<Form Name>" is present in my request page with "CONFIRM CANCELLATION" status
    #And verify "background color" of "CONFIRM CANCELLATION" status is "Grey" in my request page
    #And user logs out from application
    ############################ user logging in as fulfiller and cancelled the form request ############################
    #Given user opens producer dashboard application
    #And user logins with "fulfiller" role
    #And user opens fulfiller dashboard for "<Form Name>" form
    #Then user clicks "Active" requests dropdown in Crew Dashboard
    #When user searches request in fulfiller dashboard
    #Then verify "<Form Name>" is present in fulfiller dashboard with "CONFIRM CANCELLATION" status
    #And verify "background color" of "CONFIRM CANCELLATION" status is "Grey" in fullfiller dashboard
    #And user click edit link of the request in "fulfiller page"
    #When user verifies logs are displaying in Log section
    #When user clicks on "confirm cancel request" button
    #And verify "confirm cancellation" alert message
      #| Confirm Cancellation Alert Message           |
      #| Are you sure you want to cancel this request |
    #And click "yes" on "confirm cancellation" alert message
    #Then verify request is "Cancelled" successfully
    #And user opens fulfiller dashboard for "<Form Name>" form
    #Then user clicks "Cancelled" requests dropdown in Crew Dashboard
    #And user searches request in fulfiller dashboard
    #Then verify "<Form Name>" is present in fulfiller dashboard with "CANCELLED" status
    #And verify "background color" of "CANCELLED" status is "Black" in fullfiller dashboard
    #Then user click on request ID link of the request
    #When user verifies logs are displaying in Log section
#
    #Examples: 
      #| Form Name         |
      #| NBC Breaking News |
