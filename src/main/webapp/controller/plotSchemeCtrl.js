app.controller('plotSchemeCtrl', ['$scope', '$state', function($scope, $state){
	$scope.setFinanceFlag    = true;
	$scope.setRealEstateFlag = false;
	$scope.tabActiveFinance  = true;
	
	$scope.users = [
{ scheme: "Suresh Dasari", allplot : " all plot "},
{ scheme: "Suresh Dasari", allplot : " all plot "},
{ scheme: "Suresh Dasari", allplot : " all plot "},
{ scheme: "Suresh Dasari", allplot : " all plot "},
{ scheme: "Suresh Dasari", allplot : " all plot "},
{ scheme: "Suresh Dasari", allplot : " all plot "},
{ scheme: "Suresh Dasari", allplot : " all plot "},
{ scheme: "Suresh Dasari", allplot : " all plot "},
{ scheme: "Suresh Dasari", allplot : " all plot "},
{ scheme: "Suresh Dasari", allplot : " all plot "},
{ scheme: "Suresh Dasari", allplot : " all plot "},
{ scheme: "Suresh Dasari", allplot : " all plot "},
{ scheme: "Suresh Dasari", allplot : " all plot "},
{ scheme: "Suresh Dasari", allplot : " all plot "},
{ scheme: "Suresh Dasari", allplot : " all plot "},
{ scheme: "Suresh Dasari", allplot : " all plot "},
{ scheme: "Suresh Dasari", allplot : " all plot "},
{ scheme: "Suresh Dasari", allplot : " all plot "},
{ scheme: "Suresh Dasari", allplot : " all plot "},

];
	$scope.addPlot = function(){
		$state.go('addPlot');
	};
	
	$scope.addScheme = function(){
		$state.go('addScheme');
	};
	
	$scope.setFinanceTab = function(){
		$scope.setFinanceFlag    = true;
		$scope.setRealEstateFlag = false;
		$scope.tabActiveFinance  = true;
		$scope.tabActiveRealEstate = false;
		$state.go('plotScheme');
	};
	
	$scope.setRealEstateTab = function(){
		$scope.setFinanceFlag    = false;
		$scope.setRealEstateFlag = true;
		$scope.tabActiveFinance  = false;
		$scope.tabActiveRealEstate = true;
		
	};
	$scope.addEmployees = function(){
		$state.go('addEmployess');
	};
	
}]);