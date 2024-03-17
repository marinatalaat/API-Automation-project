Feature: Create new Pet


  Scenario: Create Pet with new info
    Given User Create new Pet
    Then User update the status of existing Pet with value 'new value'
    Then User should check on the updated status value
    Then User delete the created new Pet and the request should be with status code 200