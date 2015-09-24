app.controller('weatherctrl', function ($scope, $http) {
$scope.getWeather = function () {
$http.get('http://api.wunderground.com/api/36b799dc821d5836/conditions/q/MO/Kansas%20City.json').success(function (data) {
    //prompt(data);
    temp = data.current_observation.temp_f;
    icon = data.current_observation.icon_url;
    weather = data.current_observation.weather;
    console.log(temp);
    prompt(temp);
    $scope.currenttemp = temp;
    $scope.currenticon = icon;
    $scope.currentweather = weather;
    
}) 
}
});  

