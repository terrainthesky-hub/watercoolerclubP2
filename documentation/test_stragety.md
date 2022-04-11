# Test Strategy Document
## Naming Conventions
- Branches should be named [name of person facilitating the feature][feature].
- There should be no abbreviations in names unless they are documented.
### Classes
- Class names should be in Pascal case. (ie ExampleClass)
- Class names should start with an identifier to distinguish which feature it is a part of.
  - Individuals Features
    - Apply
    - View
    - Profile
    - IndSearch
    - SkillTest
  - Company
    - Post
    - Delete
    - CreateTest
    - Message
    - CompSearch
- After the identifier, class names should start with a noun such as Color, Button, etc.

### Interfaces
- Interface names should be in Pascal case. (ie ExampleInterface)
- Interface names should start with adjective such as Runnable, Remote, etc.

### Methods
- Method names should be in camel case. (ie exampleMethod)
- Method nam;es should start with a verb, such as print, select, etc.

### Variables
- Variable names should be in camel case. (ie exampleVariable)
- Variable names should NOT start with special characters, such as & or $.
- Avoid using single-character variables, such as x, y, or z.

### Constants
- Constant names should be in screaming snake case (ie YELLOW_BALL).
- Constant names may contain digits, but should not be the first letter.

### Packages
- Package names are in all lowercase, such as java or lang.
- If the name contains multiple words, it should be separated with dots, such as java.util or java.lang.
- Package names should look like backwards web directories (ie com.data.access).

### Documented Abbreviations
- sql = SQL/Structured Query Language/sequel
- dal = data layer
- serl = service layer
- api =
- imp = implementation
- dao = data access object
- sao = service access object
- ind = individual
- comp = company

## Bug Tracking/Solving
- Done through GitHub's Issues tracker. Branches will NOT be made for the sake of bugfixing.
- Title should be [Branch], [File Name], [Line Number]
  - ie dylansBranch, FirstFile, 102
- Comment should include thoughts on what the problem itself is and anything that has been tried to fix it.
- There is no rigid severity meter on the basis that most issues will be collaborated on in a timely manner either way, and since there isn't any prioritizing of one issue over another, there isn't a need for a severity meter.
  - This is also based on the idea that the workflow of this project leans more towards "fix issues in the order they come up" over "there is a pile of bugs we need to fix, which one needs to be fixed first".

## Best Practices
- Get some sleep.
- Take breaks.
- Communicate :clap:
  - Ask for help if you need it! We are here to help each other.
- Main will not be locked down, but do not merge to main without having at least one other person review your code.
  - This will allow for easier documentation editing directly to main.