(function () {
  'use strict';

  angular.module("Music").factory("musicApi", function ($http, $localStorage, config) {
	  
		var _persist = function (music, callback) {
			return $http.post(config.baseUrl + "/api/musics", music) 
				.then(function(result){
					callback(null);
				}, function(err){
					callback(err);
				});
		},
		_remove = function (music, callback) {
			
			console.info(music);
			return $http.post(config.baseUrl + "/api/musics/delete", music) 
				.then(function(result){
					callback(null);
				}, function(err){
					callback(err);
				});
		},
		_list = function (callback) {
			return $http.get(config.baseUrl + "/api/musics")
				.then(function(result){
					callback(null, result.data);
				}, function(err){
					console.error(err.status);
					callback(err);
				});
		};

		return {
			
			persist: _persist,
			remove: _remove,
			list : _list
		};
	});
})();
