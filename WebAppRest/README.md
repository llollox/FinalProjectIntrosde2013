##WebApp Rest Service

This is the Service that interact with the client and all other services. It is a REST service, and all the API are available both in json and in xml.

To specify the response format just set the header `Accept: application/json` or `Accept: application/xml` for the type you require.

Here is the list of our rest services:

<hr/>

### Person

**GET**  ```/person```

Returns the list of all the people in the database

**GET**  ```/person/{p_id}```

Returns the person associated to that specific **p_id**. The person object is returned with the current healthprofile and also le list of healthprofile_ids of that person. If there isn't a person associated with the given **p_id** the response status will be 204 NO_CONTENT.

**POST**  ```/person```

Creates a new person in our database and returns it with the generated identifier that can be used after to access to that person. The person object you want to create should be passed as body of the request. This method support both json and xml request format. Just set the header `Content-Type: application/json` or `Content-Type: application/xml` . For example the body of a json request could be: `{"firstname":"Francesco","lastname":"Maturi","birthdate":"27-01-1990","height":"1.89","weight":"89.2"}`.

**PUT**  ```/person/{p_id}```

This method is for updating the person information like firstname, lastname, birthdate or the current weight and height. The updated person object should be passed as body of the request. This method support both json and xml request format. Just set the header `Content-Type: application/json` or `Content-Type: application/xml`. For example the body of a json request could be: `{"firstname":"Francesco","lastname":"Maturi","birthdate":"27-01-1990","height":"1.89","weight":"89.2"}`. If weight and height are also updated will be saved in the healthprofile history the old healthprofile. The person updated will be returned in the body of the response.

**DELETE**  ```/person/{p_id}```

Delete the person identified by that specific **p_id** and also his healthprofile history. This method returns to the caller all the information that are deleted.

<hr/>

### Health Profile

**GET**  ```/person/{p_id}/healthprofile```

Returns the specified person with all the data relating to its healthprofile history.

**GET**  ```/person/{p_id}/healthprofile/{hp_id}```

Returns the specified healthprofile of the specified person. If there isn't an healthprofile identified by **hp_id** associated to the given **p_id** the response will be 204 NO_CONTENT.

**POST**  ```/person/{p_id}/healthprofile```

Updates the new healthprofile of the specified person. The current healthprofile of this person will be put in his healthprofile history and replaced by the updated data that are given. This method support both json and xml request format. Just set in the headers what you prefer `Content-Type: application/json` or `Content-Type: application/xml`. For example the body of an xml request could be: `<healthProfile><height>1.74</height><weight>70.3</weight></healthProfile>`. The response will be the updated person with all the data relating to its healthprofile history.

**PUT**  ```/person/{p_id}/healthprofile/{hp_id}```

Updates weight and height of the specified healthprofile of the specified person. This method support both json and xml request format. Just set in the headers what you prefer `Content-Type: application/json` or `Content-Type: application/xml`. For example the body of an xml request could be: `<healthProfile><height>1.80</height><weight>75.3</weight></healthProfile>`. The response will contains be the updated healthprofile.

**DELETE**  ```/person/{p_id}/healthprofile/{hp_id}```

Delete the specified healthprofile. The data removed from the database will be returned in the response.

<hr/>

### Activity

**GET**  ```/activity```

Returns the list of all the activities in the database

**GET**  ```/activity/{id}```

Returns the activity associated to that specific **id**. If there isn't an activity associated with the given **id** the response status will be 204 NO_CONTENT.

**POST**  ```/activity```

Creates a new activity in our database and returns it with the generated identifier that can be used after to access to that activity. The activity object you want to create should be passed as body of the request. This method support both json and xml request format. Just set the header `Content-Type: application/json` or `Content-Type: application/xml` . For example the body of a json request could be: `{"description":"corri","value":"120"}`.

**PUT**  ```/activity/{id}```

This method is for updating the activity information like description and value. The updated activity object should be passed as body of the request. This method support both json and xml request format. Just set the header `Content-Type: application/json` or `Content-Type: application/xml`.

**DELETE**  ```/activity/{id}```

Delete the activity identified by that specific **id**.


<hr/>

### Search

**GET**  ```/search/birthdate?from=YYYY-MM-DD&to=YYYY-MM-DD```

Returns all the people that have the birthday in the specified range.

**GET**  ```/search/profile?measure={height|weight}&min=MIN&max=MAX```

Returns all the people that are in the specified range of height or weight.

**GET**  ```/search/name?q=TEXT_TO_SEARCH```

Returns the people that have firstname or lastname matching the TEXT_TO_SEARCH 

<hr/>
### Food
**GET**  ```/food/recipe/{RECIPE_ID}```

Returns a <b>Receipt</b> object

**GET**  ```/food/recipe?max=MAX_KCAL&min=MIN_KCAL&maxResults=MAX_RESULTS```

Returns a <b>List of Matches</b> which are the recipes found. The parameters are all optionals.

<hr/>

### Calculate Calories

**GET**  ```/calculate/idealweight?height=HEIGHT&sex=SEX```

Returns a double that indicates IDEAL WEIGHT.

**GET**  ```/calculate/idealbmi?height=HEIGHT&sex=SEX```

Returns the IDEAL BMI calculated for that person.

**GET**  ```/calculate/bmi?height=HEIGHT&weight=WEIGHT```

Returns the BMI calculated for that person.

**GET**  ```/calculate/bmr?height=HEIGHT&weight=WEIGHT&age=AGE&sex=SEX```

Returns the BMR calculated for that person.

**GET**  ```/calculate/dailycalories?bmr=BMR&exerciseTimesPerWeek=EXERCISETIMESPERWEEK```

Returns the amount of calories needed for that person to maintain his weight and doing this amount of exercise per week.

**GET**  ```/calculate/dailycaloriesmanaged?bmr=BMR&exerciseTimesPerWeek=EXERCISETIMESPERWEEK&weightDifference=WEIGHTDIFFERENCE&days=DAYS```

Returns the amount of calories needed for that person to reach his target weight, doing this amount of exercise per week, in the specified amount of days available.
