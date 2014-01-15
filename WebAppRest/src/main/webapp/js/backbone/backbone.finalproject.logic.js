$(document).ready(function(){
	var personList = new PersonList();
	var editPerson = new EditPerson();
	var editHealthProfile = new EditHealthProfile();

	$.ajaxPrefilter(function(options, originalOptions, jqXR) {
		options.url = "http://10.22.35.241:5900"
				+ options.url;
	});

	var Router = Backbone.Router
			.extend({
				routes : {
					'' : "home",
					'newPerson' : "editPerson",
					'editPerson/:id' : "editPerson",
					'deletePerson/:id' : "deletePerson",
					'showPerson/:id' : "showPerson",
					'showPerson/:id/food' : "showPersonFood",
					'showPerson/:id/goal' : "showPersonGoal",
					'editPerson/:id/editHealthProfile/:healthprofile_id' : "editHealthProfile",
					'editPerson/:id/editHealthProfile' : "editHealthProfile",
					'editPerson/:id/deleteHealthProfile/:healthprofile_id' : "deleteHealthProfile",
					'editPerson/:id/deleteFavouriteFood/:food_id' : "deleteFavouriteFood",
					'editPerson/:id/deleteExcludedFood/:food_id' : "deleteExcludedFood",
					'searchName?q=:name' : "searchName",
					'searchName?q=' : "searchName"
				}
			});

	router = new Router();
	router.on('route:home', function() {
		$(".page").html("<center><img src='img/loading.gif' class='img-loading' /></center>");
		personList.render();
	});
	router.on('route:editPerson', function(id) {
		editPerson.render({
			id : id
		});
	});
	router.on('route:deletePerson', function(id) {
		editPerson.deletePerson({
			id : id
		});
	});
	router.on('route:showPerson', function(id) {
		$(".page").html("<center><img src='img/loading.gif' class='img-loading' /></center>");
		editPerson.showPerson({
			id : id
		});
	});
	router.on('route:showPersonFood', function(id) {
		$(".page").html("<center><img src='img/loading.gif' class='img-loading' /></center>");
		editPerson.food({ id : id });
	});
	router.on('route:showPersonGoal', function(id) {
		$(".page").html("<center><img src='img/loading.gif' class='img-loading' /></center>");
		editPerson.goal({ id : id });
	});
	router.on('route:editHealthProfile', function(id, healthprofile_id) {
		editHealthProfile.render({
			id : id,
			healthprofile_id : healthprofile_id
		});
	});
	router.on('route:deleteHealthProfile', function(id, healthprofile_id) {
		editHealthProfile.deleteHealthProfile({
			id : id,
			healthprofile_id : healthprofile_id
		});
	});
	router.on('route:searchName', function(name) {
		$(".page").find("div#peopleList").html("<center><img src='img/loading.gif' class='img-loading' /></center>");
		personList.searchName({ name : name });
	});
	router.on('route:deleteFavouriteFood', function(id, food_id) {
		editPerson.deleteFavouriteFood({
			id : id,
			food_id : food_id
		});
	});
	router.on('route:deleteExcludedFood', function(id, food_id) {
		editPerson.deleteExcludedFood({
			id : id,
			food_id : food_id
		});
	});
	Backbone.history.start();
});