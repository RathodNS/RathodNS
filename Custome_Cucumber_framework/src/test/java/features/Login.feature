Feature: Login Into VMS Application

	Background:
	    Given user is on the login Page of APplication
	
  @Smoke
  Scenario: Login Into the Application
    Given user enters the username  
    Given user enters the password
    When user clicks on login button
    Then user should land on home page of Application



