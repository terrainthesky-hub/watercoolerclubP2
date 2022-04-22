Feature: As a company, I want to create skill tests so that I can ensure that an applicant has the right skill set.
  Scenario Outline: As a company, I want to create skill tests so that I can ensure that an applicant has the right skill set.
    Given I am on the landing page
    When I input my "<companyId>"
    When I click on the Create Skill Tests button
    When I am on the create skill test page
    When I input the "<firstQuestion>"
    When I input the "<firstAnswer>"
    When I input the "<secondQuestion>"
    When I input the "<secondAnswer>"
    When I input the "<thirdQuestion>"
    When I input the "<thirdAnswer>"
    When I click the finalize button
    When I get an alert telling me that the test was created successfully
    Then I am on the landing page

    Examples:
    | companyId | firstQuestion | firstAnswer | secondQuestion | secondAnswer | thirdQuestion | thirdAnswer |


  Scenario Outline: As a company, I try to create a skill test but I input a question that is too long.
    Given I am on the landing page
    When I input my "<companyId>"
    When I click on the Create Skill Tests button
    When I am on the create skill test page
    When I input the "<firstQuestion>"
    When I input the "<firstAnswer>"
    When I input the "<secondQuestion>"
    When I input the "<secondAnswer>"
    When I input the "<thirdQuestion>"
    When I input the "<thirdAnswer>"
    When I click the finalize button
    Then I get an alert telling me that the first question is too long

    Examples:
    | companyId | firstQuestion | firstAnswer | secondQuestion | secondAnswer | thirdQuestion | thirdAnswer |