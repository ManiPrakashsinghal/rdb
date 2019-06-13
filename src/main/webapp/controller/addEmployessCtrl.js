app.controller('addEmployessCtrl', ['$scope', '$state','$http','share', function($scope, $state,$http,share){
	
	$scope.obj = {payeeName:"",otherDetails:""};
	
	$scope.mode = share.getMode();
	if($scope.mode == "modify"){
		$scope.obj = share.getDetail();
	}else{
		$scope.obj = {payeeName:"",otherDetails:""};
	}
	
	$scope.setViewDetailsTab = function(){
		$state.go('payeeDetails');
	};
	
	$scope.submit = function(){
		
	if($scope.mode == "add"){
		var obj = $scope.obj;
		$http.post("http://localhost:8090/rdb/payeeDetailsInsert",obj).then(
				function(res){
					console.log(res);
					//alert(res.data.message);
					$scope.obj = {payeeName:"",otherDetails:""};
					
					alertS();
				},function(err){
					 console.log("Error"+err);
					 alertE();
				});
		
	}else if($scope.mode == "modify"){
		
		var obj = $scope.obj;
		$http.post("http://localhost:8090/rdb/payeeDetailsUpdate",obj).then(
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