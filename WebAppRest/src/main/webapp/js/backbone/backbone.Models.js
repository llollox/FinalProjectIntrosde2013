HealthProfile = Backbone.Model.extend({
	idAttribute : "id",
	urlRoot : function() {
		return '/person/' + this.get('person_id') + '/healthprofile';
	}
});

Person = Backbone.Model.extend({
	idAttribute : "id",
	urlRoot : '/person',
	initialize : function(options) {
		this.recipes = new RecipeList;
		this.recipes.url = function() {
		    return '/person/' + options.id + '/food';
		};
		this.favourites = new FavouriteFoodList;
		this.favourites.url = function() {
		    return '/person/' + options.id + '/food/favourite';
		};
		this.excludeds = new ExcludedFoodList;
		this.excludeds.url = function() {
		    return '/person/' + options.id + '/food/excluded';
		};
		this.goals = new GoalList;
		this.goals.url = function() {
		    return '/person/' + options.id + '/goal';
		};
		// this.recipes.bind("reset", this.updateCounts);
	}
});

Recipe = Backbone.Model.extend({
	idAttribute : "id",
	urlRoot : function() {
		return '/person/' + this.get('person_id') + '/food';
	}
});

FavouriteFood = Backbone.Model.extend({
	idAttribute : "id",
	urlRoot : function() {
		return '/person/' + this.get('person_id') + '/food/favourite';
	}
});

ExcludedFood = Backbone.Model.extend({
	idAttribute : "id",
	urlRoot : function() {
		return '/person/' + this.get('person_id') + '/food/excluded';
	}
});

Goal = Backbone.Model.extend({
	idAttribute : "id",
	urlRoot : function() {
		return '/person/' + this.get('person_id') + '/goal';
	}
});

Quote = Backbone.Model.extend({
	urlRoot : function() {
		return '/randomQuote/';
	}
});

Exercise = Backbone.Model.extend({
	urlRoot : function() {
		return '/person/' + this.get('person_id') + '/goal/' + this.get('goal_choosen_id') + '/activity/' + this.get('activity_id');
	}
});