Feature: As an applicant, I want to complete skill tests provided by companies so that I can prove I have the necessary skill set.
  Scenario Outline: As an applicant, I want to complete skill tests provided by companies so that I can prove I have the necessary skill set.
    Given I am on the landing page
    When I input my "<individualId>"
    When I click on the Take Skill Tests button
    When I am on the skill tests page
    When I click on the Take This Skill Test button
    When I am on that skill test's page
    When I fill out the first answer
    When I fill out the second answer
    When I fill out the third answer
    When I click the submit button
    When I get an alert that tells me that I passed
    Then I am on the landing page

  Scenario Outline: As an applicant, I want to complete skill tests but I answer one of the questions incorrectly.

### Negative Acceptance Criteria (Sad Path)
- Given I am on the login page
- When I input my username
- When I input my password
- When I click login
- When I am on the individual main page
- When I click the Profile button
- When I click the Take Skill Tests button
- When I am on the skill test page
- When I answer the first question incorrectly
- When I fill out the second answer
- When I fill out the third answer
- When I hit the submit button
- When I get an alert that tells me that I failed
- Then I am on the main page