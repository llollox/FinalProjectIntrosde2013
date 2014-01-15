##Final Project - Introduction to Service Engineering 2013

###Collaborators
*   Endrit Bajo
*   Francesco Maturi
*   Lorenzo Rigato

###Services REST

*   [Inspirational Quotes](https://github.com/llollox/FinalProjectIntrosde2013/tree/master/inspirationalquotes): This is a simple REST Service written in Ruby On Rails and Deployed on Heroku that provides some Motivational Quotes as a JSON.
*   [Web Server](https://github.com/llollox/FinalProjectIntrosde2013/tree/master/WebAppRest): It gathers all the funcionatlities offered by the other services and merges them in one REST service. The web [client](https://github.com/llollox/FinalProjectIntrosde2013/tree/master/WebAppRest/src/main/webapp), written in backbone.js, calls the webserver and exposes its functionalities.
*   [Suggest Activities Service](https://github.com/llollox/FinalProjectIntrosde2013/tree/master/SuggestedActivitiesService): Given a person and his goals, this webservice suggests what activities the person should perform.

###Services SOAP

*   [Inspirational Quotes Adapter](): This is an adapter to the inspirational quotes service.
*   [Storage Service](): This service provides the apis needed to store data on the database.
*   [Food Service](): The food service, given a list of ingredients, can calculate their nutritional values or suggest recipes based on those ingredients.
*   [CaloriesCalculator](https://github.com/llollox/FinalProjectIntrosde2013/tree/master/CaloriesCalculatorService):  A simple service that implements some formulae to calculate calories stuff (Ideal Weight, Ideal Amount of Calories per day etc.)
