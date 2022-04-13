#User Stories
#### Applicants
- As an applicant, I want to create an account so that I can log in and look for jobs.
- As an applicant, I want to log in so that I can search for jobs.
- As an applicant, I want to log out so that nobody else searches for jobs under my name.
- As an applicant, I want to create a profile so that I can send it to companies I am applying for.
- As an applicant, I want to search for jobs to apply for so that I know what jobs are available.
- As an applicant, I want to apply to jobs so that I can become employed.
- As an applicant, I want to complete skill tests provided by companies so that I can prove I have the necessary skill set.
- As an applicant, I want to see what jobs I have already applied for so that I can follow up with companies. 

#### Companies
- As a company, I want to create an account so that I can log in and look for applicants.
- As a company, I want to log in so that I can post jobs.
- As a company, I want to log out so that nobody else posts jobs under our company name.
- As a company, I want to post jobs so that I can attract candidates for the job. 
- As a company, I want to delete jobs I have posted so that I do not get applications for jobs that are no longer open. 
- As a company, I want to view applications I have received so that I can select someone for the job.
- As a company, I want to create skill tests so that I can ensure that an applicant has the right skill set.

# Acceptance Criteria
## User Story: As an applicant, I want to create an account so that I can log in and look for jobs.
### Positive Acceptance Criteria (Happy Path)
- Given I am on the login page
- When I click the Create Individual Account button
- When I am on the create individual account page
- When I create an individual username
- When I create an individual password
- Then I am on the main page

### Negative Acceptance Criteria (Sad Path)
- Given I am on the login page
- When I click the Create Individual Account button
- When I am on the create individual account page
- When I create a username that is already in the database
- When I create an individual password
- Then I get an error that states that the username already exists

### Negative Acceptance Criteria (Sad Path)
- Given I am on the login page
- When I click the Create Individual Account button
- When I am on the create individual account page
- When I create a username that is more than 30 characters
- When I create an individual password
- Then I get an error that states that the username is too long

## User Story: As an applicant, I want to log in so that I can search for jobs.
### Positive Acceptance Criteria (Happy Path)
- Given I am on the login page
- When I input my username
- When I input my password
- When I click login
- Then I am on the individual main page

### Negative Acceptance Criteria (Sad Path)
- Given I am on the login page
- When I input the incorrect username
- When I input my password
- When I click login
- Then I get an error that states my username or password is incorrect

## User Story: As an applicant, I want to log out so that nobody else searches for jobs under my name.
### Positive Acceptance Criteria (Happy Path)
- Given I am on the login page
- When I input my username
- When I input my password
- When I click login
- When I am on the individual main page
- When I click the Profile button
- When I click the individual Logout button
- Then I am on the login page

## User Story: As an applicant, I want to create a profile so that I can send it to companies I am applying for.
### Positive Acceptance Criteria (Happy Path)
- Given I am on the login page
- When I input my username
- When I input my password
- When I click login
- When I am on the individual main page
- When I click the Profile button
- When I click Edit Profile
- When I am on the profile page
- When I input my first name
- When I input my last name
- When I input my phone number
- When I input my email
- When I input my work history
- When I input my references
- When I input my education
- When I hit submit
- When I click ok on the success alert
- Then I am on the main page

### Negative Acceptance Criteria (Sad Path)
- Given I am on the login page
- When I input my username
- When I input my password
- When I click login
- When I am on the individual main page
- When I click the Profile button
- When I click Edit Profile
- When I am on the profile page
- When I input a first name that is longer than 25 characters
- When I input my last name
- When I input my phone number
- When I input my email
- When I input my work history
- When I input my references
- When I input my education
- When I hit submit
- Then I get an alert that states that the inputted first name is too long

## User Story: As an applicant, I want to search for jobs to apply for so that I know what jobs are available.
### Positive Acceptance Criteria (Happy Path)
- Given I am on the login page
- When I input my username
- When I input my password
- When I click login
- When I am on the individual main page
- When I select my location
- When I select my job categories
- When I click the search button
- Then I am on the search results page

## User Story: As an applicant, I want to apply to jobs so that I can become employed.
### Positive Acceptance Criteria (Happy Path)
- Given I am on the login page
- When I input my username
- When I input my password
- When I click login
- When I am on the individual main page
- When I select my location
- When I select my job categories
- When I click the search button
- When I am on the search results page
- When I click on an apply button
- Then I get an alert that says that I applied successfully

## User Story: As an applicant, I want to complete skill tests provided by companies so that I can prove I have the necessary skill set.
### Positive Acceptance Criteria (Happy Path)
- Given I am on the login page
- When I input my username
- When I input my password
- When I click login
- When I am on the individual main page
- When I click the Profile button
- When I click the Take Skill Tests button
- When I am on the skill test page
- When I fill out the first answer
- When I fill out the second answer
- When I fill out the third answer
- When I hit the submit button
- When I get an alert that tells me that I passed
- Then I am on the main page

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

## User Story: As an applicant, I want to see what jobs I have already applied for so that I can follow up with companies. 
### Positive Acceptance Criteria (Happy Path)
- Given I am on the login page
- When I input my username
- When I input my password
- When I click login
- When I am on the individual main page
- When I click the Profile button
- When I click on the View Applications button
- Then I am on the my applications page

##User Story: As a company, I want to create an account so that I can log in and look for applicants.
### Positive Acceptance Criteria (Happy Path)
- Given I am on the login page
- When I click the Create Company Account button
- When I am on the create company account page
- When I create a company username
- When I create a company password
- Then I am on the individual main page
- 
### Negative Acceptance Criteria (Sad Path)
- Given I am on the login page
- When I click the Create company Account button
- When I am on the create company account page
- When I create a username that is already in the database
- When I create a company password
- Then I get an error that states that the username already exists

### Negative Acceptance Criteria (Sad Path)
- Given I am on the login page
- When I click the Create Company Account button
- When I am on the create company account page
- When I create a username that is more than 30 characters
- When I create a company password
- Then I get an error that states that the username is too long

## User Story: As a company, I want to log in so that I can post jobs.
### Positive Acceptance Criteria (Happy Path)
- Given I am on the login page
- When I input my username
- When I input my password
- When I click login
- Then I am on the company main page

### Negative Acceptance Criteria (Sad Path)
- Given I am on the login page
- When I input the incorrect username
- When I input my password
- When I click login
- Then I get an error that states my username or password is incorrect

## User Story: As a company, I want to log out so that nobody else posts jobs under our company name.
### Positive Acceptance Criteria (Happy Path)
- Given I am on the login page
- When I input my username
- When I input my password
- When I click login
- When I am on the company main page
- When I click the Company button
- When I click the company Logout button
- Then I am on the login page

## User Story: As a company, I want to post jobs so that I can attract candidates for the job.
### Positive Acceptance Criteria (Happy Path)
- Given I am on the login page
- When I input my username
- When I input my password
- When I click login
- When I am on the company main page
- When I click the Company button
- When I click on the Post Job button
- When I am on the post job page
- When I enter the job title
- When I select the job type
- When I enter the job description
- When I select the job location
- When I enter the relevant skills description
- When I click the post button
- When I get an alert that tells me the post was successful
- Then I am on the company main page

### Negative Acceptance Criteria (Sad Path)
- Given I am on the login page
- When I input my username
- When I input my password
- When I click login
- When I am on the company main page
- When I click the Company button
- When I click on the Post Job button
- When I am on the post job page
- When I enter a job title that is more than 25 characters
- When I select the job type
- When I enter the job description
- When I select the job location
- When I enter the relevant skills description
- When I click the post button
- Then I get an alert that tells me the job title is too long

## User Story: As a company, I want to delete jobs I have posted so that I do not get applications for jobs that are no longer open.
### Positive Acceptance Criteria (Happy Path)
- Given I am on the login page
- When I input my username
- When I input my password
- When I click login
- When I am on the company main page
- When I click the Company button
- When I click on the View Postings
- When I am on the view postings page
- When I click the delete button
- When I get an alert that tells me the deletion was successful
- Then I am on the company main page

## User Story: As a company, I want to view applications I have received so that I can select someone for the job.
### Positive Acceptance Criteria (Happy Path)
- Given I am on the login page
- When I input my username
- When I input my password
- When I click login
- When I am on the company main page
- When I click the Company button
- When I click on the View Postings
- When I am on the view postings page
- When I click on the view candidates button
- Then I am on the application list page

## User Story: As a company, I want to create skill tests so that I can ensure that an applicant has the right skill set.
### Positive Acceptance Criteria (Happy Path)
- Given I am on the login page
- When I input my username
- When I input my password
- When I click login
- When I am on the company main page
- When I click the Company button
- When I click the Create Skill Tests button
- When I am on the create skill test page
- When I input the first question
- When I input the first answer
- When I input the second question
- When I input the second answer
- When I input the third question
- When I input the third answer
- When I click the finalize button
- When I get an alert telling me that the test was created successfully
- Then I am on the company main page

### Negative Acceptance Criteria (Sad Path)
- Given I am on the login page
- When I input my username
- When I input my password
- When I click login
- When I am on the company main page
- When I click the Company button
- When I click the Create Skill Tests button
- When I am on the create skill test page
- When I a first question that is over 100 characters
- When I input the first answer
- When I input the second question
- When I input the second answer
- When I input the third question
- When I input the third answer
- When I click the finalize button
- Then I get an alert telling me that the first question is too long