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
	
	
	share.showDatePicker("fromDate");
	share.showDatePicker("toDate");
	
	 $scope.payees = [];
	 $http.get("http://localhost:8090/rdb/getPayeeDetails",{}).then(
				function(res){
					console.log(res);
					$scope.payees = res["data"]["allData"];
				},function(err){
					 console.log("Error"+err);
				});
	
$scope.users= [];
	
	$scope.gridApi;
	$scope.gridOptions = {
		      enableRowSelection: false,
		      enableSelectAll: false,
		      showGridFooter:true,
		      columnDefs : [
		                    { field : 'sno', displayName : 'S.No',width:70},
		                    { field : 'payeeName', displayName : 'Payee Name'},
		                    { field : 'amount',    displayName : 'Amount'},
		                    { field : 'inOutExpenses',    displayName : 'Expenses'},
		                    { field : 'oedDate',    displayName : 'Date'},
		                    { field : 'discription',    displayName : 'Discription'}
		        ],
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
				
				$scope.users.forEach( function( row, index){
					  row.sno = index+1;
				});
				
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
	
  $scope.getDetails = function(){
		
	  obj = {
			  "fromDate":$scope.fromDate,
			  "toDate":$scope.toDate,
			  "payeeNameId":$scope.payeeId
	  }
	  
		 $http.post("http://localhost:8090/rdb/getOfficeExpensesDetails",obj).then(
					function(res){
						console.log(res);
						$scope.users = res["data"]["allData"];
						
						$scope.users.forEach( function( row, index){
							  row.sno = index+1;
						});
						
						$scope.gridOptions.data = $scope.users;
			
					},function(err){
						 console.log("Error"+err);
					});
	 }
	 
	
	
	
}]);