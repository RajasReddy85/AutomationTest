## This is the exercise from Mercator
Test done by Raj Chintareddy
Project was developed on mac os with Java8

### Implementation
Page Object Model is used to implement this project

1. BasePage: src/test/java/mercator/driver/BasePage.java
   Chromedriver is instantiated here
2. Pages: src/test/java/mercator/pages/*.java
   Pages are defined here
3. Runner: src/test/java/mercator/runner/Runner.java
   this is to run the scenarios, step definition path is mentioned in glue.
4. Steps: src/test/java/mercator/steps/AutomationPracticeSteps.java
   All the cucumber steps are defined in this file.
5. test.properties (src/test/resources/properties/test.properties)
   All the properties like host timeouts are defined here.

### How to Run: 
We can run these tests in windows and mac.
We can use the runner file Runner.java to test, tags are already defined.

1. Using IDE - Right Click on the Runner file and select Run.
2. Using terminal
   >cd {projectFolder}
   >mvn compile
   >mvn test
