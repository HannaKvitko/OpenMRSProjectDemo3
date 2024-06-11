Feature: Patient Management for OpenMRS

  Scenario: Searching Patient List
    Given The doctor successfully accesses the homepage as an admin
    When  The doctor clicks on the find patient button
    Then  The doctor successfully searches for a patient using name, ID, or surname
    And   The doctor should see and click on the search result
    Then  The doctor sees medical history, appointments, and other information after clicking the search result
    And   The doctor should see "No matching records found" after searching for an old patient
