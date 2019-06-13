app.controller('employeesCtrl', ['$scope', '$state', function($scope, $state){

	$scope.users = [
{ payee: "Suresh Dasari", amount: 30, date: 'Chennai', discription : 'other'},
{ payee: "Suresh Dasari", amount: 30, date: 'Chennai', discription : 'other'},
{ payee: "Suresh Dasari", amount: 30, date: 'Chennai', discription : 'other'},
{ payee: "Suresh Dasari", amount: 30, date: 'Chennai', discription : 'other'},
{ payee: "Suresh Dasari", amount: 30, date: 'Chennai', discription : 'other'},
{ payee: "Suresh Dasari", amount: 30, date: 'Chennai', discription : 'other'},
{ payee: "Suresh Dasari", amount: 30, date: 'Chennai', discription : 'other'},
{ payee: "Suresh Dasari", amount: 30, date: 'Chennai', discription : 'other'},
{ payee: "Suresh Dasari", amount: 30, date: 'Chennai', discription : 'other'},
{ payee: "Suresh Dasari", amount: 30, date: 'Chennai', discription : 'other'},
{ payee: "Suresh Dasari", amount: 30, date: 'Chennai', discription : 'other'},
{ payee: "Suresh Dasari", amount: 30, date: 'Chennai', discription : 'other'},
{ payee: "Suresh Dasari", amount: 30, date: 'Chennai', discription : 'other'},
{ payee: "Suresh Dasari", amount: 30, date: 'Chennai', discription : 'other'},
{ payee: "Suresh Dasari", amount: 30, date: 'Chennai', discription : 'other'},
{ payee: "Suresh Dasari", amount: 30, date: 'Chennai', discription : 'other'},

];
	$scope.addEmployees = function(){
		$state.go('addEmployess');
	};
	
}]);