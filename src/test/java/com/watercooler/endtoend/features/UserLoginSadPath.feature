Feature: I want to login to the website with my already made account
  Scenario: I should be able to be taken from the landing page to the user page to enter my information
    Given Account is already created and I am on the landing page user login
    When I click on the Sign in to an existing user acct login
    When I am redirected to the login page user acct login
    When I enter my username user acct login
    When I enter my password user acct login too few characters
    When I click on the Login button company login
    Then I am given an alert about my username and password login having too few characters