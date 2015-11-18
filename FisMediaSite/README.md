# 2 small steps to run

A, Running project

	I, Run on eclipse
		
		1, Import to your IDE with Maven plugin
		
		2, Right click on project -> Run as -> Maven build...
		
		3, On Goals input field type in: clean install tomcat7:run
		
		4, Apply and Run
		
		5, On browser go to localhost:8080/FisMediaSite

	II, Running using maven

		1, Install 	maven
		
		2, Go to FisMediaSite folder and open cmd
		
		3, Type: "mvn clean install tomcat7:run"
		
		4, Hit enter

		5, On browser go to localhost:8080/FisMediaSite

B, Connecting to database
	
	I, Import database
		
		1, Open MySQL Workbench
		
		2, Go to: Server -> Data Import
		
		3, Choose Import from Self-Contained File
		
		4, Choose the path to "longlive.sql" file (LongLive/FisMediaSite/Database)
		
		5, Click "Start Import" and wait until end (2 seconds :D)
		
		6, Refresh Schemas tab
		
		6, Then you should see "longlive" database in your "Schemas" tab
		
	II, Create default user to connect to the "longlive" database

		1, On MySQL Workbench screen 
		
		2, Navigate to "Management" tab

		3, Click: Users and Privileges -> Add Account

		4, Login Name: longlive, Password: longlive
		
		5, Limit to Hosts Matching: localhost

		6, On "Administrative Roles" tab choose all Roles

		7, Click Apply

	III, Test Connecting

		1, Go to login popup
		
		2, Login with a account in the "longlive" database
		
		3, If the browser redirect to "Profile Page", That means successful!!!