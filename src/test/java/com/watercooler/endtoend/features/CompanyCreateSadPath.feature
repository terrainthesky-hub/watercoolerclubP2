Feature: I should be able to create a Company account and then login to that account
  Scenario: As a Company I should be able to create a Company account on the job website
    Given I am on the landing page comp acct
    When I click on the create new comp button
    When I am on the create company acct page
    When I fill out my username create acct with too few characters
    When I fill out my password create acct
    When I click on the Create Company acct button
    Then I get a warning about username and password being too few