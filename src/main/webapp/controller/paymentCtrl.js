app.controller('paymentCtrl', ['$scope', '$state', function($scope, $state){
	$scope.setFinanceFlag    = true;
	$scope.setRealEstateFlag = false;
	$scope.tabActiveFinance  = true;
	
	$scope.users = [
{ name: "Suresh Dasari", age: 30, location: 'Chennai' },
{ name: "Rohini Alavala", age: 29, location: 'Chennai' },
{ name: "Suresh Dasari", age: 30, location: 'Chennai' },
{ name: "Rohini Alavala", age: 29, location: 'Chennai' },
{ name: "Suresh Dasari", age: 30, location: 'Chennai' },
{ name: "Rohini Alavala", age: 29, location: 'Chennai' },
{ name: "Suresh Dasari", age: 30, location: 'Chennai' },
{ name: "Rohini Alavala", age: 29, location: 'Chennai' },
{ name: "Suresh Dasari", age: 30, location: 'Chennai' },
{ name: "Rohini Alavala", age: 29, location: 'Chennai' },
{ name: "Suresh Dasari", age: 30, location: 'Chennai' },
{ name: "Rohini Alavala", age: 29, location: 'Chennai' },
{ name: "Suresh Dasari", age: 30, location: 'Chennai' },
{ name: "Rohini Alavala", age: 29, location: 'Chennai' },
{ name: "Suresh Dasari", age: 30, location: 'Chennai' },
{ name: "Rohini Alavala", age: 29, location: 'Chennai' },
];
	$scope.payClient = function(){
		$state.go('payClientPayment');
	};
	
	
	$scope.setFinanceTab = function(){
		$scope.setFinanceFlag    = true;
		$scope.setRealEstateFlag = false;
		$scope.tabActiveFinance  = true;
		$scope.tabActiveRealEstate = false;
	};
	
	$scope.setRealEstateTab = function(){
		$scope.setFinanceFlag    = false;
		$scope.setRealEstateFlag = true;
		$scope.tabActiveFinance  = false;
		$scope.tabActiveRealEstate = true;
		
	}
}]);