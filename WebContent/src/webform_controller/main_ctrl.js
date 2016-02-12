var ctlMain = angular.module('webapp',[ 'restangular', 'ngRoute','ui.bootstrap']);

ctlMain.config(){
	$routeProvider.when('#/MainApp', {
		templateUrl : 'fragments/webappfragment.html',
		controller : 'MainCtrl'
	})
}
