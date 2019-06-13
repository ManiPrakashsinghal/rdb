angular.module('myApp').config(function($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise('/dashboard');

    $stateProvider
        .state('client', {
            url: '/client',
            templateUrl: 'client.html'
        })
		.state('dashboard', {
            url: '/dashboard',
            templateUrl: 'dashboard.html'
        })
        .state('addClient', {
            url: '/addClient',
            templateUrl: 'addClient.html'
        })
        .state('addClientDetail', {
            url: '/addClientDetail',
            templateUrl: 'addClientDetail.html'
        })
        .state('officeExpenses', {
            url: '/officeExpenses',
            templateUrl: 'officeExpenses.html'
        })
        .state('addEmployess', {
            url: '/addEmployess',
            templateUrl: 'addEmployess.html'
        })
        .state('payeeDetails', {
            url: '/payeeDetails',
            templateUrl: 'payeeDetails.html'
        })
        .state('addExpenses', {
            url: '/addExpenses',
            templateUrl: 'addExpenses.html'
        })
        .state('changePassword', {
            url: '/changePassword',
            templateUrl: 'changePassword.html'
        })
        .state('payment', {
            url: '/payment',
            templateUrl: 'payment.html'
        })
        .state('payClientPayment', {
            url: '/payClientPayment',
            templateUrl: 'payClientPayment.html'
        })
        .state('plotScheme', {
            url: '/plotScheme',
            templateUrl: 'plotScheme.html'
        })
        .state('addPlot', {
            url: '/addPlot',
            templateUrl: 'addPlot.html'
        })
        .state('addScheme', {
            url: '/addScheme',
            templateUrl: 'addScheme.html'
        })
        
       
        
});