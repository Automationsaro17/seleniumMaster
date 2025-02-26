@ProducerDashboard @Dashboard_Validation
Feature: Validate options and functionality of CNBC Crew Resource & Standard Dashboard

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role

  @CNBCCrewResource_Dashboard_Validation
  Scenario Outline: Verifying options and functionality of CNBC Crew Resource Dashboard
    And user opens fulfiller dashboard for "<Form Name>" form
    Then verify CNBC crew resource dashboard options and functionality
      | StartDate     | EndDate       | GlobalSearchText | Columns To Be Removed |
      | CurrentDate+1 | CurrentDate+3 | sainath          | Status,Shoot Status   |

    Examples: 
      | Form Name |
      | CNBC Crew |

  @CNBCCrewStandard_Dashboard_Validation
  Scenario Outline: Verifying options and functionality of CNBC Crew Standard Dashboard
    And user opens fulfiller dashboard for "<Form Name>" form
    And user selects "<Dashboard Name>" view in crew dashboard
    Then verify CNBC crew standard dashboard options and functionality
      | StartDate     | EndDate       | GlobalSearchText | Columns To Be Removed |
      | CurrentDate+1 | CurrentDate+3 | sainath          | Status,Shoot Status   |

    Examples: 
      | Form Name | Dashboard Name |
      | CNBC Crew | Standard       |
