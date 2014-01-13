$(document).ready(function(){
	var personList = new PersonList();
	var editPerson = new EditPerson();
	var editHealthProfile = new EditHealthProfile();

	$.ajaxPrefilter(function(options, originalOptions, jqXR) {
		options.url = "http://192.168.1.6:5900"
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
					'editPerson/:id/editHealthProfile/:healthprofile_id' : "editHealthProfile",
					'editPerson/:id/editHealthProfile' : "editHealthProfile",
					'editPerson/:id/deleteHealthProfile/:healthprofile_id' : "deleteHealthProfile",
					'searchName?q=:name' : "searchName",
					'searchName?q=' : "searchName"
				}
			});

	router = new Router();
	router.on('route:home', function() {
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
		editPerson.showPerson({
			id : id
		});
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
	Backbone.history.start();
});