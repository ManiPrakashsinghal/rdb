var app = angular.module('myApp', ['ui.router', "ui.grid","ui.grid.autoResize","ui.grid.selection"]);
app.controller('myCtrl', ['$scope', function($scope){
	$scope.mobileViewFlag = false;
	$scope.clickOnMobileViewMenu = function(){
		$scope.mobileViewFlag = true;
	}
}]);

