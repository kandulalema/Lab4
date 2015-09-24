var app = angular.module('LoginPage', [])
//app.controller('LoginController', function ($scope) {
//    
//    //$scope.registers = [];
//    $scope.login = function (user,pwd) {
//        localStorage.setItem("name" , user);
//		localStorage.setItem("pass" , pwd);
////		localStorage.setItem("mobile" , mobile);
////		localStorage.setItem("email" , email);
//        //$scope.registers.push( localStorage.getItem("name") + " registered.");
//    };
//	
//	
//});

app.controller('RegistController' , function ($scope) {
    
    scope.registers = [];
    $scope.register = function (user,pwd, mobile, email) {
        localStorage.setItem("name" , user);
		localStorage.setItem("pass" , pwd);
		localStorage.setItem("mobile" , mobile);
		localStorage.setItem("email" , email);
        $scope.registers.push( localStorage.getItem("name") + " registered.");
    };
	
	
});