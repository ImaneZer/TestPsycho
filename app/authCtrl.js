
function createCookie(name,value,days) {
    if (days) {
        var date = new Date();
        date.setTime(date.getTime()+(days*24*60*60*1000));
        var expires = "; expires="+date.toGMTString();
    }
    else var expires = "";
    document.cookie = name+"="+value+expires+"; path=/";
}
app.controller('authCtrl', function ($scope, $rootScope, $routeParams, $location, $http, Data) {
    //initially set those objects to null to avoid undefined error
    $scope.login = {id: '', email:'',password:'',type:''};
    $scope.signup = {};
    $scope.doLogin = function (customer) {
        Data.post('login', {
            customer: customer
        }).then(function (results) {
            Data.toast(results);
            if (results.status == "Succès" && results.type == "medecin") {
                $location.path('dashboard/'+results.id);
            }
            else if (results.status == "Succès" && results.type == "patient") {
                document.location.href="../TestPsycho/partials/patientTest.html";
                createCookie('id_patient',results.id, 7);
            }
        });
    };
    $scope.signup = {email:'',password:'',nom:'',telephone:'',adresse:'',prenom:'',id:''};
    $scope.signUp = function (customer) {
        Data.post('signUp', {
            customer: customer
        }).then(function (results) {
            Data.toast(results);
            if (results.status == "Succès") {
                $location.path('dashboard');
            }
        });
    };
    $scope.logout = function () {
        Data.get('logout').then(function (results) {
            Data.toast(results);
            $location.path('login');
        });
    }
});