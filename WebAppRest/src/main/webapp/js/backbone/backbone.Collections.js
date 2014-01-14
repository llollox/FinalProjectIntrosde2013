var BirthdateSearch = Backbone.Collection.extend({
	url : '/search/birthdate',
	parse : function(response) {
		if (response) {
			return response.person;
		} else
			return null;
	}
});

var MeasureSearch = Backbone.Collection.extend({
	url : '/search/profile',
	parse : function(response) {
		if (response) {
			return response.person;
		} else
			return null;
	}
});

var NameSearch = Backbone.Collection.extend({
	url : '/search/name',
	parse : function(response) {
		if (response) {
			return response.person;
		} else
			return null;
	}
});

People = Backbone.Collection.extend({
	model : Person,
	url : '/person',
	parse : function(response) {
		if (response) {
			return response.person;
		} else
			return null;
	}
});

HealthProfileHistory = Backbone.Collection.extend({
	model : HealthProfile,
	parse : function(response) {
		if (response)
			return response.healthProfile;
		else
			return null;
	}
});

RecipeList = Backbone.Collection.extend({
	model : Recipe,
	parse : function(response) {
		if (response)
			return response.matches;
		else
			return null;
	}
});

FavouriteFoodList = Backbone.Collection.extend({
	model : FavouriteFood,
	parse : function(response) {
		if (response)
			return response.favouriteFood;
		else
			return null;
	}
});

ExcludedFoodList = Backbone.Collection.extend({
	model : ExcludedFood,
	parse : function(response) {
		if (response)
			return response.excludedFood;
		else
			return null;
	}
});

