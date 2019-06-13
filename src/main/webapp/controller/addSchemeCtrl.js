app.controller('addSchemeCtrl', ['$scope', '$state', function($scope, $state){
	$scope.setViewDetailsTab = function(){
		$state.go('plotScheme');
	};
	
}]);