var app = angular.module('myApp', ['ngRoute', 'ngAnimate', 'toaster']);

app.factory("services", ['$http', function($http) {
  var serviceBase = 'services/'
    var obj = {};
    obj.getPatients = function(medecinID){
        return $http.get(serviceBase + 'patients?id=' + medecinID);
    }
    /*obj.getMedecin = function(medecinID){
        return $http.get(serviceBase + 'medecin?id=' + medecinID);
    }*/
    /*
    obj.updatePatient = function (id,patient) {
        return $http.post(serviceBase + 'updatePatient', {id:id, patient:patient}).then(function (status) {
            return status.data;
        });
    };

    obj.deletePatient = function (id) {
        return $http.delete(serviceBase + 'deletePatient?id=' + id).then(function (status) {
            return status.data;
        });
    };*/

    return obj;   
}]);

app.config(['$routeProvider',
  function ($routeProvider) {
        $routeProvider.
        when('/login', {
            title: 'Login',
            templateUrl: 'partials/login.html',
            controller: 'authCtrl'
        })
           .when('/logout', {
                title: 'Logout',
                templateUrl: 'partials/login.html',
                controller: 'authCtrl'
            })
            .when('/signup', {
                title: 'Signup',
                templateUrl: 'partials/signup.html',
                controller: 'authCtrl'
            })
            .when('/test', {
                title: 'test',
                templateUrl: 'partials/patientTest.html',
            })
            .when('/dashboard/:medecinID', {
                title: 'Dashboard',
                templateUrl: 'partials/dashboard.html',
                controller: 'listeCtrl',
                resolve: {
            patients: function(services, $route,$routeParams){
            var medecinID = parseInt($routeParams.medecinID);
            return services.getPatients(medecinID);
            }
            }
            })
            .when('/ajoutPat', {
                title: 'AjoutPatient',
                templateUrl: 'partials/ajoutPatient.html',
                controller: 'medecinCtrl'
            })
            .when('/', {
                title: 'Login',
                templateUrl: 'partials/login.html',
                controller: 'authCtrl',
                role: '0'
            })
            .otherwise({
                redirectTo: '/login'
            });
  }])
    .run(function ($rootScope, $location, Data) {
        $rootScope.$on("$routeChangeStart", function (event, next, current) {
            $rootScope.authenticated = false;
            Data.get('session').then(function (results) {
                if (results.id) {
                    $rootScope.authenticated = true;
                    $rootScope.id = results.id;
                    $rootScope.nom = results.nom;
                    $rootScope.email = results.email;
                } else {
                    var nextUrl = next.$$route.originalPath;
                    if (nextUrl == '/signup' || nextUrl == '/login') {

                    } else {
                        $location.path("/login");
                    }
                }
            });
        });
    })