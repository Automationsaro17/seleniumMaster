@ProducerDashboard @Dashboard_Validation
Feature: Validate options and functionality of Digital Journalist DJ Shoot Crew Resource & Standard Dashboard

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role

  @DigitalJournalistDJShootCrewResource_Dashboard_Validation
  Scenario Outline: Verifying options and functionality of Digital Journalist DJ Shoot Crew Resource Dashboard
    And user opens fulfiller dashboard for "<Form Name>" form
    Then verify Digital Journalist DJ Shoot crew resource dashboard options and functionality
      | StartDate     | EndDate       | GlobalSearchText | Columns To Be Removed |
      | CurrentDate+1 | CurrentDate+3 | sainath          | Status,Shoot Status   |

    Examples: 
      | Form Name                     |
      | Digital Journalist / DJ Shoot |

  @DigitalJournalistDJShootCrewStandard_Dashboard_Validation
  Scenario Outline: Verifying options and functionality of Digital Journalist DJ Shoot Crew Standard Dashboard
    And user opens fulfiller dashboard for "<Form Name>" form
    And user selects "<Dashboard Name>" view in crew dashboard
    Then verify Digital Journalist DJ Shoot crew standard dashboard options and functionality
      | StartDate     | EndDate       | GlobalSearchText | Columns To Be Removed |
      | CurrentDate+1 | CurrentDate+3 | sainath          | Status,Shoot Status   |

    Examples: 
      | Form Name                     | Dashboard Name |
      | Digital Journalist / DJ Shoot | Standard       |
