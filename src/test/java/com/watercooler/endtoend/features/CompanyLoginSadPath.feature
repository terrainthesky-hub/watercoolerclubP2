Feature: I want to login to the website with my already made account
  Scenario: I should be able to be taken from the landing page to the user page to enter my information
    Given Acct is already created and I am on the landing page company login
    When I click on the Sign in to an existing company acct
    When I am redirected to the login acct page company login
    When I enter my username company login with too many characters
    When I enter my password company login acct
    When I click on the Login button company login
    Then I am given a warning about there  being too few characters in username and password