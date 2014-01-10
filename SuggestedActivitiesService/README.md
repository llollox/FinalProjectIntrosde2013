##Suggested Activities Service

This is a simple SOAP service that provides the best activities for a person keeping in mind his healthprofile.

####Documentation

* <b>GET SUGGESTED ACTIVITIES</b> 
```public Activity[] getSuggestedActivities(HealthProfile hp, Goal[] goalList)``` 
	- @PARAMS
		* <b>goalList</b> is the list of goals that the person has chosen
		* <b>hp</b> is the health profile of the person.
	
	- @RETURN a list of suggested activities for that person based on his health profile and goals choosen.
	
