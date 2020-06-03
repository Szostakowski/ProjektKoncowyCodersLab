Feature: Add and delete company data

  Scenario Outline: user can add and delete data
    Given open browser with https://prod-kurs.coderslab.pl
    Then click Sign in
    And log in to customer account
    And check if Sign in is correct
    And go to "add first address"
    And add data to form get <alias>, <address>, <city>, <zipCode>, <country>, <phone>


    Examples:
      | alias           | address           |    city           |  zipCode    |  country      |   phone      |
      | Tester Sp.zo.o  | Progamerska 2/5   |  Śródziemiedzin   |  00-666     | United Kingdom|  +333228899  |




