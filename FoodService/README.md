##Food Service

This is a soap service which lets you find recipes and nutritional values.

####Documentation

* <b>GET RECIPE BY ID</b> 
```public Recipe getRecipe(String recipeId)``` 
	- @PARAMS
		* <b>receipId</b> is the id of a certain recipe
	
	- @RETURN the recipe

* <b>GET RECIPE BY PARAMS</b> 
```public RecipeFinder getRecipes(QueryParams queryParams)``` 
	- @PARAMS
		* <b>queryParams</b> the parameters to search for a recipe. The parameters can space from nutritional values to ingredients.
	
	- @RETURN the recipe

* <b>GET NUTRITIONAL VALUES BY INGREDIENTS</b> 
```public EdamamResponse calculateIngredientsValues(List<String> ingredients)``` 
	- @PARAMS
		* <b>ingredients</b> the list of ingredients
	
	- @RETURN the nutritional values of the ingredients
	
