(function () {
  'use strict';

  angular.module("Music").controller("musicCtrl", function($scope, $uibModal, musicApi) {
	  
	  function loadData(callback){
		
		  musicApi.list(function(err, result){

			  $scope.musics = result;
			  if(callback) callback();
		  });
	  }
	  
	  function alert(type, message){
		  $scope.alerts = [ { type: type, msg: message } ];
	  }
	  
	  function openModal(action, item, thenResult){
		  
		  var actions = {
				 'A' : 'Nova Música',
				 'E' : 'Editar Música',
				 'R' : 'Remover Música'
		  };
		  
		  var modalInstance = $uibModal.open({
		      
		      templateUrl: 'app/partials/musicModal.html',
		      controller: 'musicModalCtrl',
		      resolve: {
		          data: function(){
		        	return {
		        		action : action,
		        		title : actions[action],
		        		item : item || {}
		        	};  
		          } 
		      }
		  });
		  modalInstance.result.then(thenResult);
	  }
	  
	  $scope.registry = function(){
		  
		  openModal('A', {}, function(music){
			  
			  musicApi.persist(music, function(err) {
				  
				  if(err){
					  alert('danger', 'Ocorreu um erro.');
					  return;
				  }
				  
				  loadData(function(){
					  
					  alert('success', 'Sua música foi registrada com sucesso')
				  });
			  });
		  });
	  }
	  $scope.edit = function(music){
		  
		  var targetMusic = angular.copy(music);
		  openModal('E', targetMusic, function(result){
			  
			  musicApi.persist(result, function(err, resp) {
				  
				  if(err){
					  alert('danger', 'Ocorreu um erro.');
					  return;
				  }
				  
				  loadData(function(){
					  
					  alert('success', 'Sua música foi alterada com sucesso');
				  });
			  });
		  });
	  }
	  
	  $scope.remove = function(music){
		  
		  openModal('R', music, function(result){
			  
			  musicApi.remove(music, function(resp){
				  
				  loadData(function(){
					  
					  alert('success', 'Sua música foi removida com sucesso')
				  });
			  });
		  });
	  }
	  $scope.closeAlert = function(index) {
		  $scope.alerts.splice(index, 1);
	  };

	  $scope.alerts = [];
	  loadData();
  });
})();
