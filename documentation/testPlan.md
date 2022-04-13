# Test Plan Document
## Technologies Used
- Languages: Java, ProstgreSQL, HTML, CSS, Javascript
- Libraries: Cucumber
- IDE: IntelliJ, Visual Studio Code
- Tertiary Programs: DBeaver, Postman, AWS RDS, AWS EC2, GitHub, Git, GitBash, Zoom

## Deadlines
#### Sprint 1 : Friday, April 15th
#### Sprint 2: Friday, April 22nd
#### Final Deadline: Friday, April 29th

## What Is Being Tested
### Individuals - Login
- Database: check if username+password combination exists and return id of the account
- Positive Service: pass up the returned id to the API
- Negative Service: throw an error/pass failure message to API
- Positive API: pass up the returned id to the front end
- Negative API: pass up information from error to the front end
- Positive Front End: allow user to login
- Negative Front End: show error alert

### Individuals - Logout
- Positive Front End: removes cached data from the browser and redirect to login page

### Individuals - Create Accounts
- Database: check if insert account information into both the username/password table AND the applicant table and return a rowcount for both
- Positive Service: pass success message on correct rowcount to API
- Negative service: throw an error/pass failure message on incorrect rowcount to API
- Positive API: pass success message to the front end
- Negative API: pass up information of error to the front end
- Positive Front End: redirect to main page
- Negative Front End: show error alert

### Individuals - Apply To Jobs
- Database: check if the applicant id with the job id is put into the applied jobs table and return rowcount
- Positive Service: pass success message on correct rowcount to API
- Negative Service: throw an error/pass failure message on incorrect rowcount to API
- Positive API: pass success message to the front end
- Negative API: pass up information of error to the front end
- Positive Front End: show positive alert
- Negative Front End: show error alert

### Individuals - View Jobs Applied To
- Database: return ListArray of applied jobs
- Positive Service: pass list up to API
- Negative Service: pass the information that there is no data up to API
- Positive API: pass list up to front end
- Negative API: pass up information that there is no data up to front end
- Positive Front End: shows applied jobs data
- Negative Front End: shows no data

### Individuals - Search For Jobs
- Database: return ListArray of jobs of given search criteria
- Positive Service: pass list up to API
- Negative Service: pass the information that there is no data up to API
- Positive API: pass list up to front end
- Negative API: pass up information that there is no data up to front end
- Positive Front End: shows applied jobs data
- Negative Front End: shows no data

### Individuals - Do Skills Tests
- Database: return ListArray of available skill tests
- Database: return information for selected skill test
- Database: if passed, put applicant id and skill test id into the passed skill test table
- Positive Service: pass list up to API
- Positive Service: pass selected skill test data to API
- Positive Service: send applicant id and skill test id data to database
- Negative Service: pass the information that there is no data up to API
- Positive API: pass list up to front end
- Positive API: pass selected skill test up to front end
- Negative API: pass up information that there is no data up to front end
- Positive Front End: shows skill test data (list)
- Positive Front End: shows individual skill test data
- Positive Front End: de
- Negative Front End: shows no data

### Individuals - Edit Profile
- Database :
- Positive Service :
- Negative Service :
- Positive API: pass success message to the front end
- Negative API: pass up information of error to the front end
- Negative Front End: show error alert

### Companies - Login
- Database: check if username+password combination exists and return id of the account
- Positive Service: pass up the returned id to the API
- Negative Service: throw an error/pass failure message to API
- Positive API: pass up the returned id to the front end
- Negative API: pass up information from error to the front end
- Positive Front End: allow user to login
- Negative Front End: show error alert

### Companies - Logout
- Positive Front End: removes cached data from the browser and redirect to login page

### Companies - Create Account
- Positive API: pass success message to the front end
- Negative API: pass up information of error to the front end
- Negative Front End: show error alert

### Companies - Edit Profile

### Companies - Post Jobs
- Database :
- Positive Service :
- Negative Service :
- Positive API: pass success message to the front end
- Negative API: pass up information of error to the front end
- Negative Front End: show error alert

### Companies - View Applicants
- Positive API: pass success message to the front end
- Negative API: pass up information of error to the front end
- Negative Front End: show error alert

### Companies - Delete Job Postings
- Database :
- Positive Service :
- Negative Service :
- Positive API: pass success message to the front end
- Negative API: pass up information of error to the front end
- Negative Front End: show error alert

### Companies - Create Skill Tests
- Database :
- Positive Service :
- Negative Service :
- Positive API: pass success message to the front end
- Negative API: pass up information of error to the front end
- Negative Front End: show error alert

## What Is Not Being Tested

### tentative features
#### Individuals
1. Apply to jobs
2. View jobs applied to
3. Search for jobs
4. Do skill tests
5. Put up resume

#### Companies
1. Post jobs
2. Delete job postings
3. Search for people
4. Create skill tests

ind1 + ind2
comp1 + comp2
ind3 + comp3
ind4 + comp4
ind5 
simple login+logout
create accounts for ind + comp