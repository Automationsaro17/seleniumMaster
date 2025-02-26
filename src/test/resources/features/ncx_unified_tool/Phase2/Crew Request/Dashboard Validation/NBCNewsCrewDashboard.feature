@ProducerDashboard @Dashboard_Validation
Feature: Validate options and functionality of NBC News Crew Resource & Standard Dashboard

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role

  @NBCNewsCrewResource_Dashboard_Validation
  Scenario Outline: Verifying options and functionality of NBC News Crew Resource Dashboard
    And user opens fulfiller dashboard for "<Form Name>" form
    Then verify NBC News crew resource dashboard options and functionality
      | StartDate     | EndDate       | GlobalSearchText | Columns To Be Removed |
      | CurrentDate+1 | CurrentDate+3 | sainath          | Status,Shoot Status   |

    Examples: 
      | Form Name |
      | NBC News  |

  @NBCNewsCrewStandard_Dashboard_Validation
  Scenario Outline: Verifying options and functionality of NBC News Crew Standard Dashboard
    And user opens fulfiller dashboard for "<Form Name>" form
    And user selects "<Dashboard Name>" view in crew dashboard
    Then verify NBC News crew standard dashboard options and functionality
      | StartDate     | EndDate       | GlobalSearchText | Columns To Be Removed |
      | CurrentDate+1 | CurrentDate+3 | sainath          | Status,Shoot Status   |

    Examples: 
      | Form Name | Dashboard Name |
      | NBC News  | Standard       |
