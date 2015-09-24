angular.module('LoginPage', [])
.controller('LoginController', function ($scope) {
    
    $scope.registers = [];
	$scope.logins = [];
    $scope.login = function (user,pwd) {
		
		if(localStorage.getItem("name") === user){
			$window.location.href = '../homepage.html';
		}
		else{
		$scope.logins.push( user + " not registered.");
		}
//        localStorage.setItem("name" , user);
//		localStorage.setItem("pass" , pwd);
//		localStorage.setItem("mobile" , mobile);
//		localStorage.setItem("email" , email);
        //$scope.registers.push( localStorage.getItem("name") + " registered.");
    };
	
	 $scope.register = function (user,pwd,mobile,email) {
        localStorage.setItem("name" , user);
		localStorage.setItem("pass" , pwd);
		localStorage.setItem("mobile" , mobile);
		localStorage.setItem("email" , email);
        $scope.registers.push( localStorage.getItem("name") + " registered.");
    };
});

//angular.module('LoginPage', [])
//.controller('LoginController', function ($scope) {
//    
//    //$scope.registers = [];
//    $scope.register = function (user,pwd,mobile,email) {
//        localStorage.setItem("name" , user);
//		localStorage.setItem("pass" , pwd);
//		localStorage.setItem("mobile" , mobile);
//		localStorage.setItem("email" , email);
//        //$scope.registers.push( localStorage.getItem("name") + " registered.");
//    };
//});