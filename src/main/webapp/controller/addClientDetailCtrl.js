app.controller('addClientDetailCtrl', ['$scope', '$state', function($scope, $state){
	$scope.setFinanceFlag    = true;
	$scope.setRealEstateFlag = false;
	
	$scope.tabActiveFinance  = true;
	
	$scope.addClientDetail = function(){
		$state.go('addClientDetail');
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