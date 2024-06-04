Feature: OpenMRS Demo Login Functionality


  Scenario: Successful login with valid credentials



    Given Navigate to webpage
    When user clicks on the DEMO button
    Then user selects Explore OpenMRS 3
    And click on Enter OpenMRS 3 and navigate to the login page
    Then user enters the username "Admin"
    Then user click on Continue button
    Then user enters password "Admin123"
    And user should be able click on Login button

