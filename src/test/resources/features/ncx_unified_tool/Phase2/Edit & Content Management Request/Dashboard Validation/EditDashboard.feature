@ProducerDashboard @Dashboard_Validation
Feature: Validate options and functionality of Edit Dashboard

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role

  @Edit_Dashboard_Validation
  Scenario Outline: Verifying options and functionality of Edit Dashboard
    And user opens fulfiller dashboard for "<Form Name>" form
    Then verify Edit dashboard options and functionality
      | StartDate     | EndDate       | GlobalSearchText | Columns To Be Removed |
      | CurrentDate+1 | CurrentDate+3 | sainath          | Slug,Division,Location   |

    Examples: 
      | Form Name |
      | Long Edit |