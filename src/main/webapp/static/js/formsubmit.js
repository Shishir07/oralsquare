'use strict';

angular.module('myApp').controller('FormCtrl', ['$scope','$http' ,'$window', function($scope,$http,$window ) {
	    
		
	    $scope.submitForm = function() {
	    	  $http({
	    	  method  : 'POST',
	    	  url     : '/rest/formsubmit',
	    	  params    : $scope.formData,  // pass in data as strings
	    	  headers : { 'Content-Type': 'application/x-www-form-urlencoded' }  // set the headers so angular passing info as form data (not request payload)
	    	 })
	    	 
	    	 .then(function (data, status, headers, config) {
	 		    	alert("The doctor will contact you Regarding Your Query! Have a great day"); 
	 		    	$window.location.href = '#';
	 			},function (data, status, headers, config) { 
	 				alert("Sorry! The request could not be processed due to some technical error! Please Refresh and try after some time"); 
	 				$window.location.href = '#';
	 			}
	 		  );
	    };
	
	
}]);