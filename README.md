## Zone Interview
Simple boilerplate to kick start your testng-cucumber maven java project with some additional features like "CucumberOptions": tags, glue, screenshots, set environment/browser methods
## Features
* Crisp & Clear maven folder structures
* Extensive methods in CucumberRunner class
* CucumberOptions with detailed explanation of using "tags", "glue"
* Screenshots on failure feature in **CucumberRunner** class
* TestNG Annotations/hooks like "BeforeSuite", "AfterClass", "AfterMethod" etc.
* Descriptive pom.xml and testng.xml
* Methods for running tests in Firefox and Chrome browsers

## To Get Started

#### Pre-requisites
1. Java installed in the system
2. Maven installed in the system

#### Run Scripts
* Fork this repo, keep the folder the structure intact
* Run the following maven command from command line 
```
mvn clean compile test
```
* The scripts should run successfully in **Chrome** browser as it is defined in the **config.properties** file.
* Target folder should be created with cucumber-html-report and surefire-reports.
* **Test_Output** folder should be created with the default testng reports

#### Writing Features
```
 Feature: To search testng in google
  
	@TestngScenario
  	Scenario: Testng Google
  		Given I am on "bbc one" home page  	
 		When I search and select programme "EastEnders" 		
	  	And Select the latest available episodes from the programme page	
	  	Then I click on programme website link to navigate to "EastEnders" programme page 	  	
	  	And I print on console the next avaiable episode date of "EastEnders"
```


#### Writing Step Definitions

```

	@When("^I search and select programme \"([^\"]*)\"$")
	public void i_search_and_select_programme(String programmeName) throws Throwable {
		home.searchAndSelectProgramme(programmeName);
	}
```


#### Cucumber Options

```
 @CucumberOptions(
      	strict = true,
      	monochrome = true,
      	features = {"src/test/resources/features/"},
      	glue = "stepdefinition",
      	plugin = {"pretty", "html:target/cucumber-html-report" },
      	tags={"@Regression,@JunitScenario,@TestngScenario"}
        )
```


#### Screenshot Hooks/Annotations

```
 @AfterMethod(alwaysRun = true)
     	public void tearDownr(ITestResult result) throws IOException {
     		if (result.isSuccess()) {
     			File imageFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
     			String failureImageFileName = result.getMethod().getMethodName()
     					+ new SimpleDateFormat("MM-dd-yyyy_HH-ss").format(new GregorianCalendar().getTime()) + ".png";
     			File failureImageFile = new File(System.getProperty("user.dir") + "//screenshots//" + failureImageFileName);
     			FileUtils.copyFile(imageFile, failureImageFile);
     		}
     	}
```


#### HTML Reports
Default cucumber HTML reports are generated which can be customized according to specific needs
##### Success Cucumber Reports

![report1](./images/report1.png)
![report2](./images/report2.png)
![report3](./images/report3.png)
# Zone-InterviewTask
