app.controller('editCtrl', function ($scope, $rootScope, $location, $routeParams, services, patient) {
    var patientID = ($routeParams.patientID) ? parseInt($routeParams.patientID) : 0;
    $rootScope.title = (patientID > 0) ? 'Edit Patient' : 'Add Patient';
    $scope.buttonText = (patientID > 0) ? 'Update Patient' : 'Add New Patient';
      var original = patient.data;
      original._id = patientID;
      $scope.patient = angular.copy(original);
      $scope.patient._id = patientID;

      $scope.isClean = function() {
        return angular.equals(original, $scope.patient);
      }

      $scope.deletePatient = function(patient) {
        $location.path('/');
        if(confirm("Are you sure to delete patient number: "+$scope.patient._id)==true)
        services.deletePatient(patient.patientNumber);
      };

      $scope.savePatient = function(patient) {
        $location.path('/');
        if (patientID <= 0) {
            services.insertPatient(patient);
        }
        else {
            services.updatePatient(patientID, patient);
        }
    };
});