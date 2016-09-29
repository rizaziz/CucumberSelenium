Feature: Check if the calculation is correct

  Scenario: Salary calculation

    Given click the salary calculator button
    When put checkdate as 10.01.2016
    And put state as Pennsylvania
    And put grosspay as 100000
    And put grosspaytype as Annual
    And put Pay frequency as Bi-weekly
    And put federal finling status as married
    And put number of allowances as 4
    And click on button calculate
    But wait till the result page loads
    Then Bi-weekly gross pay is 3846.15
    And Federal withholding is 398.46
    And Social security is 238.46
    And Medicare is 55.77
    And Pennsylvania tax is 118.08
    And SUI is 2.69
