Feature: I should be able to create a user account and then login to that account
  Scenario: As a user I should be able to create a user account on the job website
    Given I am on the landing page user create acct
    When I click on the create new user button create acct
    When I am on the create page sadpath
    When I fill out my username user create enough characters
    When I fill out my password user create with too many characters
    When I click on the Create User acct button sadpath
    Then I am given an error alert for incorrect username and password sadpath