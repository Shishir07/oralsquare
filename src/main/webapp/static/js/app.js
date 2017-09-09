'use strict';

var app = angular.module('myApp',["ngRoute"]);


app.config(function($routeProvider) {
	//$locationProvider.hashPrefix('!');

    $routeProvider.
      when('/home', {
        templateUrl: 'static/home.html'
      }).
      when('/book', {
    	  templateUrl: 'static/form.html'
      }).
      otherwise({
          redirectTo: '/home'
      });
	});

    