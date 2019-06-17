## Zone Interview
 1. What type of testing:
 
 - Functional Testing:  We can perform functional testing using the UI (web browser) and see how can 
 	we get the date of next available episode of EastEnders.
 - Such type of scenarios where UI not always same and we cannot run same UI test script to get details should be run though web services. 
 Because , Not every episode is having next available date, and are having different UI. So, we cannot run our test case for all episodes.
 
 -  Some Edge case scenarios should also be tested with timezone : Like same episode is available in US and UK. so we should change our timezone and see if it is showing the correct time and date even after   
 changing timezone.
 
 - See the status of next episode on the same day and also at the time when is it broadcasted live.
 - Once we found a bug, the bug should be logged inside Defect management tools (like JIRA) with proper description, category (UI, Functional) with proper screenshot and details.
 
 