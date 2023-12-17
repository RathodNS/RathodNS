Feature: Dashboard

	Background:
	Given user is on the login Page of APplication
  Given user enters the username  
  Given user enters the password
  When user clicks on login button
  Then user should land on home page of Application
  
  Scenario: Verify Admin Has Nationaloities Section
  When user clicks on Admin menu from left panel
  Then User Management page should be displayed
  When user Selects Nationalities from the available option
  Then User should be navigated to Nationalities page
  When user clicks on Add nationality button
  Then Verify user gets option to enter the nationlaity
  

 
