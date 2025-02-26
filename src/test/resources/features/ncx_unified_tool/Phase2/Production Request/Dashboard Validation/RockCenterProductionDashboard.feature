@ProducerDashboard @Dashboard_Validation
Feature: Validate options and functionality of Rock Center Production Dashboard

  Background: 
    Given user opens producer dashboard application
    And user logins with "producer" role

  @RockCenterProduction_Dashboard_Validation
  Scenario Outline: Verifying options and functionality of Rock Center Production Dashboard
    And user opens fulfiller dashboard for "<Form Name>" form
    Then verify rock center production dashboard options and functionality
			| StartDate     | EndDate       | GlobalSearchText | Columns To Be Removed |
      | CurrentDate+1 | CurrentDate+3 | sainath          | Request ID,Status     |
    Examples: 
      | Form Name   |
      | Rock Center |
