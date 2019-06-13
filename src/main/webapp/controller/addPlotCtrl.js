app.controller('allPlotCtrl', ['$scope', '$state', function($scope, $state){
	$scope.setViewDetailsTab = function(){
		$state.go('plotScheme');
	};
	
}]);