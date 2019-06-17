Feature: To search testng in google
  
@TestngScenario
  Scenario: Testng Google
  	Given I am on "bbc one" home page  	
 		When I search and select programme "EastEnders" 		
  	And Select the latest available episodes from the programme page	
  	Then I click on programme website link to navigate to "EastEnders" programme page 	  	
  	And I print on console the next avaiable episode date of "EastEnders"