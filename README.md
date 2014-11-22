# Lowes.com Selenium Tests

This project contains the framework and test cases for testing Lowes.com with
Selenium.

## Usage

This guide assumes you have a newer version of Eclipse with Maven integration
(suggested Eclipse for Java EE Developers 4.3 Kepler or later, which comes
pre-packaged with Maven integraion).

1. Complete each section of our [maven setup guide](http://vmlnxgit.lowes.com/shared/maven-setup/tree/master)
1. Clone this repository
  * In Eclipse: Use the Git Repository Exploring view and paste the repository
URI (from the main project page in the browser) into the wizard
1. Import the project into Eclipse
  1. File -> Import... -> Maven -> Existing Maven Projects
  1. Navigate to the location where you cloned the repository, select the
```pom.xml``` for ```com.lowes.qa:lowes-qa-selenium:{version}```, and finish the wizard
1. Configure the application
1. Run the tests (see below)

## Configuration

The application configuration can be found at
```src/main/resources/global-settings.properties```.

By default, the tests will run locally.  You can use a remote grid by
specifying the following arguments:

* SELENIUM_HOST
* SELENIUM_PORT
* SAUCE_ONDEMAND_BROWSERS
* SAUCE_USER_NAME (SauceLabs only)
* SAUCE_API_KEY (SauceLabs only)

Example (POC Grid):

```
mvn clean surefire-report:report -DSELENIUM_HOST=172.29.152.46 -DSELENIUM_PORT=4444 -DSAUCE_ONDEMAND_BROWSERS=[{"browser":"chrome","browser-version":"26","platform":"WINDOWS","os":"WINDOWS"}]
```

Example (SauceLabs):

```
mvn clean surefire-report:report -DSELENIUM_HOST=ondemand.saucelabs.com -DSELENIUM_PORT=80 -DSAUCE_ONDEMAND_BROWSERS=[{"os":"Windows 2012 R2","platform":"XP","browser":"chrome","browser-version":"26"}] -DSAUCE_USER_NAME=userid -DSAUCE_API_KEY=mysupersecretapikey
```

When running tests locally, certain browsers require a path to their drivers
be defined.  This repository includes some drivers.  Edit the paths in the 
application configuration based on your operating system.

## Running Tests

All tests are executed with the JUnit runner.  Currently, each test class maps
to a sheet in ```src/main/resources/datatables/```.  The test methods set the
test case to execute from the sheet.

### Eclipse

Eclipse has a built in JUnit runner.  This runner can execute a one or many
test classes or individual test methods from a class.

Executing test classes:

1. Select the class(es)
1. Right-click on the selection
1. Run As -> JUnit Test

Executing a single test method:

1. Open the test class containing the method
1. Click on the method name to highlight it
1. Right-click on the method name
1. Run As -> JUnit Test

### Maven

Maven uses the Surefire plugin to run tests.  By default, the plugin executes
all test classes with the naming convention ```Test*.java``` or
```*Test.java```.  To run all the tests, execute ```mvn clean surefire-report:report```.
HTML reports are generated in the ```target``` folder.

Maven can also execute a subset of tests at the class and method level.  For
examples and more details, visit the Surefire plugin documentation on
[running a single test](http://maven.apache.org/surefire/maven-surefire-plugin/examples/single-test.html).

