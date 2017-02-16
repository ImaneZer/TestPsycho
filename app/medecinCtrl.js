app.controller('medecinCtrl', function ($scope, $rootScope, $routeParams, $location, $http, Data) {
    //initially set those objects to null to avoid undefined error
    $scope.ajoutPat = {email:'',password:'',nom:'',telephone:'',adresse:'',prenom:'',id:'', id_medecin:''};
    $scope.ajoutPatient = function (patient) {
        Data.post('ajoutPat', {
            patient: patient
        }).then(function (results) {
            Data.toast(results);
            if (results.status == "Succès") {
                $location.path('dashboard');
            }
        });
    };
});