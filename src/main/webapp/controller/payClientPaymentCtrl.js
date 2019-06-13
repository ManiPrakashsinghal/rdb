app.controller('payClientPaymentCtrl', ['$scope', '$state', function($scope, $state){
	$scope.setViewDetailsTab = function(){
		$state.go('payment');
	};
	
}]);