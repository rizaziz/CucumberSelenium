Feature: Check if the calculation is correct

  Scenario Outline: Salary Calculation with DataTables

    Given Click on the 'Salary Calculator' button

    When Fields are filled with following table:
      |Date          |<Date>         |
      |State         |<State>        |
      |Gross         |<Gross>        |
      |PayType       |<PayType>      |
      |PayFrequency  |<PayFrequency> |
      |FilingStatus  |<FilingStatus> |
      |Allowances    |<Allowances>   |

    And Click button 'Calculate'

    But Wait untill the result page loads

    Then Result should be as follows:
      |GrossPay      |<GrossPay>       |
      |FedTax        |<FedTax>         |
      |SSN           |<SSN>            |
      |Medicare      |<Medicare>       |
      |StateTax      |<StateTax>       |

    Examples:

      |Date        |State         |Gross  |PayType          |PayFrequency  |FilingStatus  |Allowances |GrossPay  |FedTax  |SSN     |Medicare  |StateTax |
      |10/01/2016  |Pennsylvania  |100000 |Annually         |Bi-weekly     |Married       |4          |3846.15   |398.46  |238.46  |55.77     |118.08   |
      |10/01/2016  |Pennsylvania  |100000 |Annually         |Bi-weekly     |Married       |4          |3846.15   |398.46  |238.46  |55.77     |118.08   |
      |10/01/2016  |Pennsylvania  |100000 |Annually         |Bi-weekly     |Married       |4          |3846.15   |398.46  |238.46  |55.77     |118.08   |
      |10/01/2016  |Pennsylvania  |100000 |Annually         |Bi-weekly     |Married       |4          |3846.15   |398.46  |238.46  |55.77     |118.08   |
      |10/01/2016  |Pennsylvania  |100000 |Annually         |Bi-weekly     |Married       |4          |3846.15   |398.46  |238.46  |55.77     |118.08   |
      |10/01/2016  |Pennsylvania  |100000 |Annually         |Bi-weekly     |Married       |4          |3846.15   |398.46  |238.46  |55.77     |118.08   |
      #|10/01/2016  |Arizona       |7000   |Pay Per Period   |Monthly       |Single        |0          |7000.00   |1350.73 |434.00  |101.50    |189.00   |

