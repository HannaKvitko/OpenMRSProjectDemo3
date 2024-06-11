Feature: OpenMRS Demo Login

  Scenario: Invalid login attempts and warnings
    Given the user navigates to the home page
    When the user selects Enter the OpenMRS3 Demo
    When the user enters invalid credentials and clicksLogin
    When the user enters valid credentials
    Then the user logs in successfully

