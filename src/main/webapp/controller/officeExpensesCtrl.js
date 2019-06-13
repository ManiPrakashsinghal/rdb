app.controller('officeExpensesCtrl', ['$scope', '$state','$http','share', function($scope, $state,$http,share){
	$scope.setFinanceFlag    = true;
	$scope.setRealEstateFlag = false;
	$scope.tabActiveFinance  = true;
	
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
		$state.go('payeeDetails');
	}
	
	
$scope.users= [];
	
	$scope.gridApi;
	$scope.gridOptions = {
		      enableRowSelection: false,
		      enableSelectAll: false,
		      showGridFooter:true,
		      data: $scope.users
		    };
	
	$scope.gridOptions.multiSelect = false;
	
	$scope.gridOptions.onRegisterApi = function(gridApi) {
			$scope.gridApi = gridApi;
	    };
	    
	    $scope.getSelectedRows = function () {
	        var mySelectedRows = $scope.gridApi.selection.getSelectedRows();
	        return mySelectedRows[0];
	    }
	
	
	   $http.post("http://localhost:8090/rdb/getOfficeExpensesDetails",{}).then(
			function(res){
				console.log(res);
				$scope.users = res["data"]["allData"];
				$scope.gridOptions.data = $scope.users;
			},function(err){
				 console.log("Error"+err);
			});
	
	$scope.addEmployees = function(){
		share.setMode("add");
		$state.go('addExpenses');
	};
	
	$scope.modifyEmployees = function(){
		var obj = $scope.getSelectedRows();
		if(obj){
			share.setMode("modify");
			share.setDetail(obj);
			$state.go('addExpenses');
		}else{
			alert("Please select a client");
		}
		
	};
	
	
	
}]);