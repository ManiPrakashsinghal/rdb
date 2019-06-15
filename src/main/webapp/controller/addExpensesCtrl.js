app.controller('addExpensesCtrl', ['$scope', '$state','share','$http', function($scope, $state,share,$http){
	
	
	/**
	 * date picker*/
	share.showDatePicker("expensesId");
	
	
	$scope.setViewDetailsTab = function(){
		$state.go('officeExpenses');
	};
	
    $scope.obj = {payeeName:"",payeeNameId:"",amount:"",oedDate:"",discription:"",inOutExpenses:""};
    $scope.payeeArr = [];
    
    	$http.get("http://localhost:8090/rdb/getPayeeDetails").then(
			function(res){
				console.log(res);
				$scope.payeeArr = res["data"]["allData"];
			},function(err){
				 console.log("Error"+err);
			});
    
	
	$scope.mode = share.getMode();
	if($scope.mode == "modify"){
		$scope.obj = share.getDetail();
	}else{
		$scope.obj = {payeeName:"",payeeNameId:"",amount:"",oedDate:"",discription:"",inOutExpenses:""};
	}

	$scope.submit = function(){
		
	if($scope.mode == "add"){
		var obj = $scope.obj;
		$http.post("http://localhost:8090/rdb/insertOfficeExpensesDetails",obj).then(
				function(res){
					console.log(res);
					//alert(res.data.message);
					alertS();
				},function(err){
					 console.log("Error"+err);
					 alertE();
				});
		
	}else if($scope.mode == "modify"){
		
		var obj = $scope.obj;
		$http.post("http://localhost:8090/rdb/updateOfficeExpensesDetails",obj).then(
				function(res){
					console.log(res);
					//alert(res.data.message);
					alertS();
				},function(err){
					 console.log("Error"+err);
					 alertE();
				});
	  }
	
  }

	
	
	
}]);