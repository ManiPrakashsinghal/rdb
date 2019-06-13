app.controller('payeeDetailsCtrl', ['$scope', '$state','$http','share', function($scope, $state,$http,share){
	$scope.setFinanceFlag    = true;
	$scope.setRealEstateFlag = false;
	$scope.tabActiveRealEstate  = true;
	
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
	
	
	$http.get("http://localhost:8090/rdb/getPayeeDetails").then(
			function(res){
				console.log(res);
				$scope.users = res["data"]["allData"];
				$scope.gridOptions.data = $scope.users;
			},function(err){
				 console.log("Error"+err);
			});
	
	$scope.setFinanceTab = function(){
		$scope.setFinanceFlag    = true;
		$scope.setRealEstateFlag = false;
		$scope.tabActiveFinance  = true;
		$scope.tabActiveRealEstate = false;
		$state.go('officeExpenses');
	};
	
	$scope.setRealEstateTab = function(){
		$scope.setFinanceFlag    = false;
		$scope.setRealEstateFlag = true;
		$scope.tabActiveFinance  = false;
		$scope.tabActiveRealEstate = true;
		
	};
	$scope.addEmployees = function(){
		share.setMode("add");
		$state.go('addEmployess');
	};
	
	$scope.modifyEmployees = function(){
		
		var obj = $scope.getSelectedRows();
		if(obj){
			share.setMode("modify");
			share.setDetail(obj);
			$state.go('addEmployess');
		}else{
			alert("Please select a client");
		}
	};
	
}]);