(function () {
  'use strict';

  angular.module("Music").controller("musicModalCtrl", function($scope, $uibModalInstance, data) {
	  
	  $scope.data = data;
	  
	  $scope.submit = function () {
		  
		  $uibModalInstance.close($scope.data.item);
	  };
	  $scope.cancel = function () {
		  
	    $uibModalInstance.dismiss('cancel');
	  };
  });
})();