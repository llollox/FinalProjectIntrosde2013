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
		this.healthProfileHistory = new HealthProfileHistory;
		this.healthProfileHistory.url = function() {
		    return '/person/' + options.id + '/healthprofile';
		};
		this.healthProfileHistory.bind("reset", this.updateCounts);
	}
});

Bmi = Backbone.Model.extend({
	urlRoot : '/calculate/bmi'
	// initialize : function(options) {
	// 	this.healthProfileHistory = new HealthProfileHistory;
	// 	this.healthProfileHistory.url = function() {
	// 	    return '/person/' + options.id + '/healthprofile';
	// 	};
	// 	this.healthProfileHistory.bind("reset", this.updateCounts);
	// }
});