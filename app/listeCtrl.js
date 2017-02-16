app.controller('listeCtrl', function ($scope, $rootScope, $location, $routeParams, services) {
	//var medecinID = parseInt($routeParams.medecinID);
    services.getPatients().then(function(data){
        $scope.patients = data.data;
    });
});