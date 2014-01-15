##WebApp Rest Service

This is the Service that interact with the client and all other services.

<!--Hibernate Configuration:
----------------
The database used is in `database/mydb.db`, we need to configure hibernate to find it: please go to 
`src/main/resources/hibernate.cfg.xml` file and at connection url property type the following:

* For Mac users: `jdbc:sqlite:database/mydb.db`
* For Unix users: `jdbc:sqlite:<your_directory>/<path_to_this_project>/database/mydb.db`-->

####Database
We use the Storage Service
<!--The database used is sqlite, it contains all ice hockey 
people from Ontario present in [dbpedia.org](http://dbpedia.org/About).

To fetch and parse data from dbpedia it was used [Apache Jena](http://jena.apache.org/): a free and open source Java framework for building Semantic Web and Linked Data applications. -->

####REST Service
All our services support both json and xml format for response. 
To specify the response format just set the header `Accept: application/json` or `Accept: application/xml` for the type you require.

Here is the list of our rest services:

**GET  /person**

Returns the list of all the people in the database 

**POST  /person**

Creates a new person in our database and returns it with the generated identifier that can be used after to access to that person. The person object you want to create should be passed as body of the request. This method support both json and xml request format. Just set the header `Content-Type: application/json` or `Content-Type: application/xml` . For example the body of a json request could be: `{"firstname":"Francesco","lastname":"Maturi","birthdate":"27-01-1990","height":"1.89","weight":"89.2"}`.

**GET  /person/{p_id}**

Returns the person associated to that specific **p_id**. The person object is returned with the current healthprofile and also le list of healthprofile_ids of that person. If there isn't a person associated with the given **p_id** the response status will be 204 NO_CONTENT.

**PUT  /person/{p_id}**

This method is for updating the person information like firstname, lastname, birthdate or the current weight and height. The updated person object should be passed as body of the request. This method support both json and xml request format. Just set the header `Content-Type: application/json` or `Content-Type: application/xml`. For example the body of a json request could be: `{"firstname":"Francesco","lastname":"Maturi","birthdate":"27-01-1990","height":"1.89","weight":"89.2"}`. If weight and height are also updated will be saved in the healthprofile history the old healthprofile. The person updated will be returned in the body of the response.

**DELETE  /person/{p_id}**

Delete the person identified by that specific **p_id** and also his healthprofile history. This method returns to the caller all the information that are deleted.

**GET  /person/{p_id}/healthprofile**

Returns the specified person with all the data relating to its healthprofile history.

**POST  /person/{p_id}/healthprofile**

Updates the new healthprofile of the specified person. The current healthprofile of this person will be put in his healthprofile history and replaced by the updated data that are given. This method support both json and xml request format. Just set in the headers what you prefer `Content-Type: application/json` or `Content-Type: application/xml`. For example the body of an xml request could be: `<healthProfile><height>1.74</height><weight>70.3</weight></healthProfile>`. The response will be the updated person with all the data relating to its healthprofile history.

**GET  /person/p_id/healthprofile/hp_id**

Returns the specified healthprofile of the specified person. If there isn't an healthprofile identified by **hp_id** associated to the given **p_id** the response will be 204 NO_CONTENT.

**PUT  /person/p_id/healthprofile/hp_id**

Updates weight and height of the specified healthprofile of the specified person. This method support both json and xml request format. Just set in the headers what you prefer `Content-Type: application/json` or `Content-Type: application/xml`. For example the body of an xml request could be: `<healthProfile><height>1.80</height><weight>75.3</weight></healthProfile>`. The response will contains be the updated healthprofile.

**DELETE  /person/p_id/healthprofile/hp_id**

Delete the specified healthprofile. The data removed from the database will be returned in the response.

**GET  /search/birthdate?from=DD-MM-YYYY&to=DD-MM-YYYY**

Returns all the people that have the birthday in the specified range.

**GET  /search/profile?measure={height|weight}&min=MIN&max=MAX**

Returns all the people that are in the specified range of height or weight.

**GET  /search/name?q=TEXT_TO_SEARCH**

Returns the people that have firstname or lastname matching the TEXT_TO_SEARCH 


<hr/>
####Food Api
**GET  /food/recipe/{RECIPE_ID}**

Returns a <b>Receipt</b> object

**GET  /food/recipe?max=MAX_KCAL&min=MIN_KCAL&maxResults=MAX_RESULTS**

Returns a <b>List of Matches</b> which are the recipes found. The parameters are all optionals.

<hr/>

####Calculate Calories Api
**GET  /calculate/idealweight?height=HEIGHT&sex=SEX**

Returns a double that indicates IDEAL WEIGHT.

**GET  /calculate/idealbmi?height=HEIGHT&sex=SEX**

Returns the IDEAL BMI calculated for that person.

**GET  /calculate/bmi?height=HEIGHT&weight=WEIGHT**

Returns the BMI calculated for that person.

**GET  /calculate/bmr?height=HEIGHT&weight=WEIGHT&age=AGE&sex=SEX**

Returns the BMR calculated for that person.

**GET  /calculate/dailycalories?bmr=BMR&exerciseTimesPerWeek=EXERCISETIMESPERWEEK**

Returns the amount of calories needed for that person to maintain his weight and doing this amount of exercise per week.

**GET  /calculate/dailycaloriesmanaged?bmr=BMR&exerciseTimesPerWeek=EXERCISETIMESPERWEEK&weightDifference=WEIGHTDIFFERENCE&days=DAYS**

Returns the amount of calories needed for that person to reach his target weight, doing this amount of exercise per week, in the specified amount of days available.