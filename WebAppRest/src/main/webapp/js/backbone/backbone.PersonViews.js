var PersonList = Backbone.View.extend({
	el : '.page',
	render : function() {
		var that = this;
		var persons = new People();
		persons.fetch({
			success : function(people) {
				var filtersTemplate = _.template($('#filters-template').html(),
						{});
				that.$el.html(filtersTemplate);

				var template = _.template($('#people-list-template').html(), {
					people : people.models
				});
				that.$el.find("div#peopleList").html(template);
			}
		});
	},
	events : {
		'submit form.searchForm' : 'search'
	},
	search : function(ev) {
		var that = this;

		var searchValues = $(ev.currentTarget).serializeObject();

		if (searchValues.condition == "measure") {

			var measureSearch = new MeasureSearch();

			measure = new String(searchValues.measure);
			max = new String(searchValues.max);
			min = new String(searchValues.min);

			measureSearch.fetch({
				data : $.param({
					measure : measure,
					min : min,
					max : max
				}),
				success : function(filteredPeople) {
					var template = _.template(
							$('#people-list-template').html(), {
								people : filteredPeople.models
							});
					that.$el.find("div#peopleList").html(template);
				}
			});
		} else if (searchValues.condition == "birthdate") {

			var birthdateSearch = new BirthdateSearch();

			from = new String(searchValues.from);
			to = new String(searchValues.to);

			birthdateSearch.fetch({
				data : $.param({
					from : from,
					to : to
				}),
				success : function(filteredPeople) {
					var template = _.template(
							$('#people-list-template').html(), {
								people : filteredPeople.models
							});
					that.$el.find("div#peopleList").html(template);
				}
			});
		} else {
			this.render(); // all people selected!
		}

		return false;
	},
	searchName : function(options){
		var that = this;
		var name = options.name;
		
		var nameSearch = new NameSearch();
		nameSearch.fetch({
			data : $.param({
				q : name
			}),
			success : function(filteredPeople) {
				var template = _.template(
						$('#people-list-template').html(), {
							people : filteredPeople.models
						});
				that.$el.find("div#peopleList").html(template);
			}
		});
		
	}
});

var EditPerson = Backbone.View.extend({
	el : '.page',
	render : function(options) {
		var that = this;
		if (options.id) {  // edit form
			that.person = new Person({ id : options.id });
			that.person.fetch({
				success : function(person) {
					var template = _.template($('#new-person-template').html(),{person : person });
					that.$el.html(template);
				}
			});
		} else {  // new form
			var template = _.template($('#new-person-template').html(), { person : null });
			this.$el.html(template);
		}
	},
	events : {
		'submit .new-person-form' : 'savePerson',
		'click .deletePerson' : 'deletePerson',
		'submit .favouriteFoodForm' : 'saveFavouriteFood',
		'submit .excludedFoodForm' : 'saveExcludedFood',
		'submit .setGoalsForm' : 'setGoals',
		'submit .exerciseForm' : 'addExercise'
	},
	savePerson : function(ev) {
		personDetails = $(ev.currentTarget).serializeObject();
		var person = new Person();
		person.save(personDetails, {
			success : function(user) {
				var id = personDetails.id ? personDetails.id : user.get('id');
				router.navigate('#/showPerson/'+ id, {trigger : true});
			}
		});
		return false;
	},

	deletePerson : function(options) {
		var person = null;
		
		if(options.id)
			person = new Person({id : options.id}); //from delete button of list
		else
			person = this.person; //from delete button of edit profile
		
		person.destroy({
			success : function() {
				router.navigate('', {trigger : true});
			}
		});
		return false;
	},
	showPerson : function(options) {
		var that = this;
		var person = new Person({
			id : options.id
		});
		person.fetch({
			success : function(person) {
				var template = _.template($('#show-person-hp-template').html(), {
			 					person : person,
			 					healthProfileHistory : person.get('healthprofilehistory'),
								healthProfile : person.get('extendedhealthprofile')
						});
				that.$el.html(template);
			}
		});
	},
	food : function(options){
		var that = this;
		var person = new Person({ id : options.id});
		
		person.fetch({
			success : function(person) {
				person.recipes.fetch({
          success : function(recipes) {
          	person.favourites.fetch({
          		success : function(favourites){
          			person.excludeds.fetch({
          				success : function(excludeds){
		          			var template = _.template($('#show-person-food-template').html(), {
										  recipes : recipes.models,
										  person : person,
										  favouriteFood : favourites.models,
										  excludedFood : excludeds.models
				            });

				            that.$el.html(template);
          				}
      					});
          		}
          	});
          }
      	});
			}
		});
	},
	goal : function(options){
		var that = this;
		var person = new Person({
			id : options.id
		});
		person.fetch({
			success : function(person) {
				var quote = new Quote();
				quote.fetch({
					success : function(quote){
						person.goals.fetch({
							success : function(goals){
								var template = _.template($('#show-person-goal-template').html(), {
				 					person : person,
				 					quote : quote.attributes.content,
				 					goals : goals.models
								});
								that.$el.html(template);
							}
						});
					}
				});
			}
		});
	},
	saveFavouriteFood : function(ev){
		var favouriteFoodDetails = $(ev.currentTarget).serializeObject();
		var person_id = favouriteFoodDetails.person_id;
		var favouriteFood = new FavouriteFood();
		favouriteFood.save(favouriteFoodDetails, {
			success : function(favouriteFood) {
				$('#favouriteFoodModal').modal('hide');
				router.navigate('#/showPerson/'+ person_id + "/food", {trigger : true});
			}
		});
		return false;
	},
	saveExcludedFood : function(ev){
		var excludedFoodDetails = $(ev.currentTarget).serializeObject();
		var person_id = excludedFoodDetails.person_id;
		var excludedFood = new ExcludedFood();
		excludedFood.save(excludedFoodDetails, {
			success : function(excludedFood) {
				$('#excludedFoodModal').modal('hide');
				router.navigate('#/showPerson/'+ person_id + "/food", {trigger : true});
			}
		});
		return false;
	},
	deleteFavouriteFood : function(options) {
		var favouriteFood = new FavouriteFood({
				person_id : options.id,
				id : options.food_id
			});
		
		favouriteFood.destroy({
			success : function() {
				router.navigate('showPerson/' + options.id +"/food", {
					trigger : true
				});
			}
		});
		return false;
	},
	deleteExcludedFood : function(options) {
		var excludedFood = new ExcludedFood({
				person_id : options.id,
				id : options.food_id
			});
		
		excludedFood.destroy({
			success : function() {
				router.navigate('showPerson/' + options.id +"/food", {
					trigger : true
				});
			}
		});
		return false;
	},
	setGoals : function(ev){
		var goalsDetails = $(ev.currentTarget).serializeObject();
		var person_id = goalsDetails.person_id;
		var goal = new Goal();
		goal.save(goalsDetails, {
			success : function(goal) {
				$('#setGoalsModal').modal('hide');
				router.navigate('#/showPerson/'+ person_id + "/goal", {trigger : true});
			}
		});
		return false;
	},
	addExercise : function(ev){
		var exerciseDetails = $(ev.currentTarget).serializeObject();
		var person_id = exerciseDetails.person_id;
		var exercise = new Exercise();
		exercise.save(exerciseDetails, {
			success : function(exercise) {
				$('#exerciseModal').modal('hide');
				router.navigate('#/showPerson/'+ person_id + "/goal", {trigger : true});
			}
		});
		return false;
	}
});
