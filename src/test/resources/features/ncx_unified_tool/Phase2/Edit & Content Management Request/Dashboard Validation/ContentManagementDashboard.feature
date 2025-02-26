@ProducerDashboard @Dashboard_Validation
Feature: Validate options and functionality of Content Management Dashboard

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role

  @ContentManagement_Dashboard_Validation
  Scenario Outline: Verifying options and functionality of Content Management Dashboard
    And user opens fulfiller dashboard for "<Form Name>" form
    Then verify Content Management dashboard options and functionality
      | StartDate     | EndDate       | GlobalSearchText | Columns To Be Removed |
      | CurrentDate | CurrentDate+3 | sainath          | Timer,Slug,Division   |

    Examples: 
      | Form Name |
      | Feed Out |