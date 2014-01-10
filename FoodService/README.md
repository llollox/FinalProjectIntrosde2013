FoodService
==========

This is a soap service that retrieves, from several API around the Web, information about food like recipes, calories, diets and ingredients.

####Documentation

* <b>GET RECIPE</b> ```public Receipt getRecipe(String recipeId)``` 
	- @PARAMS
		* <b>recipeId</b> is the recipeId of Yummly. 
	
	- @RETURN
		* <b>Recipe</b> is the recipe object or <b>null</b> if the recipeId matches anything. 

* <b>GET RECIPES</b> ```public double getIdealWeight(double height)``` 
	- @PARAMS
		* <b>height</b> is the height of the person, you can pass both in meters or centimeters. 
	
	- @RETURN is a double that indicates ideal weight.
	
	The ideal weight is 52 kg + 1.9kg for each inch of height over 152.4cm (1 inch = 2.54cm).