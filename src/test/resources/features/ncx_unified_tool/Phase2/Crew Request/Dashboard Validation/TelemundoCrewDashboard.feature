@ProducerDashboard @Dashboard_Validation
Feature: Validate options and functionality of Telemundo News Crew Resource & Standard Dashboard

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role

  @TelemundoNewsCrewResource_Dashboard_Validation
  Scenario Outline: Verifying options and functionality of Telemundo News Crew Resource Dashboard
    And user opens fulfiller dashboard for "<Form Name>" form
    Then verify Telemundo News crew resource dashboard options and functionality
      | StartDate     | EndDate       | GlobalSearchText | Columns To Be Removed |
      | CurrentDate+1 | CurrentDate+3 | sainath          | Status,Shoot Status   |

    Examples: 
      | Form Name      |
      | Telemundo News |

  @TelemundoNewsCrewStandard_Dashboard_Validation
  Scenario Outline: Verifying options and functionality of Telemundo News Crew Standard Dashboard
    And user opens fulfiller dashboard for "<Form Name>" form
    And user selects "<Dashboard Name>" view in crew dashboard
    Then verify Telemundo News crew standard dashboard options and functionality
      | StartDate     | EndDate       | GlobalSearchText | Columns To Be Removed |
      | CurrentDate+1 | CurrentDate+3 | sainath          | Status,Shoot Status   |

    Examples: 
      | Form Name      | Dashboard Name |
      | Telemundo News | Standard       |
