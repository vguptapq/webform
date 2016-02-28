var webApp = angular.module('webApp',['restangular', 'ngRoute','ui.bootstrap']);

webApp.config(function($routeProvider){
	$routeProvider.when('/', {
		templateUrl : 'fragments/webappfragment.html',
		controller : 'MainCtrl'
	});
});

webApp.run(function($rootScope, $location, Restangular, $window) {

	$rootScope.loginToken = {
		token : ''
	};

	$rootScope.roles = {
		roles : []
	};

});

