@ProducerDashboard @Dashboard_Validation
Feature: Validate options and functionality of News Gear Dashboard

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role

  @NewsGear_Dashboard_Validation
  Scenario Outline: Verifying options and functionality of News Gear Dashboard
    And user opens fulfiller dashboard for "<Form Name>" form
    Then verify News Gear dashboard options and functionality
      | StartDate     | EndDate       | GlobalSearchText | Columns To Be Removed |
      | CurrentDate+1 | CurrentDate+3 | sainath          | Requester,Status,Show   |

    Examples: 
      | Form Name |
      | News Gear |