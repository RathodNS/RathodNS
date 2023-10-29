Feature: Login Action

Scenario: Successful Login with Valid Credentials
	Given User is on Login Page
	And User enters "Admin" and "admin123"
	When user clicks on logi button
	Then Message displayed Login Successfully

#Scenario: Successful LogOut
#	When User LogOut from the Application
#	Then Message displayed LogOut Successfully



#Scenario Outline: Successful Login with Valid and inavlid Credentials
#	Given User is on Login Page
#	And User enters "<username>" and "<Password>"
#	When user clicks on logi button
#	Then Message displayed Login Successfully
#	
#	Examples:
#	|username|Password  |
#	|andmn	 |andmin1234|
#	|Admin	 |admin123  |
#	|testuser|testpasswrd|