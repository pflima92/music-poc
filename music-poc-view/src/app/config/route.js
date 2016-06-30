angular.module("Music").config(function ($routeProvider) {
	
	$routeProvider.when("/musics", {
		templateUrl: "app/partials/music.html",
		controller: "musicCtrl"
	});
});