Feature: Pet API Validation


  Scenario: Verify that User can Create and Modify and Delete Pet
    Given User Create new Pet
    When User update the status of existing Pet with value 'Unavailable'
    Then Verify that Pet Status has been changed to 'Unavailable' Correctly
    When User delete the created new Pet
    Then Verify that the request should be with status code 200