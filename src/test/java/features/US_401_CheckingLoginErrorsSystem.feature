Feature: OpenMRS Demo Login

  Scenario: Invalid login attempts and warnings
    Given the user navigates to the home page
    When the user selects "DEMO"  "Explore OpenMRS 2"  "Enter the OpenMRS 2 Demo"
    Then the user is on the login page
    When the user enters invalid credentials and clicks "Login"
    Then the user sees a "You must choose a location!" warning
    When the user selects "Inpatient Ward" and enters invalid credentials again
    Then the user sees an "Invalid username/password" warning
    When the user enters valid credentials
    Then the user logs in successfully

