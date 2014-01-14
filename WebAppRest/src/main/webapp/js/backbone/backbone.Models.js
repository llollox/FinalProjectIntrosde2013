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
		this.recipes.bind("reset", this.updateCounts);
	}
});

Recipe = Backbone.Model.extend({
	idAttribute : "id",
	urlRoot : function() {
		return '/person/' + this.get('person_id') + '/food';
	}
});