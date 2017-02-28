
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
                $location.path('dashboard');
            }
            else if (results.status == "Succès" && results.type == "patient") {
                document.location.href="../TestPsycho/partials/listTests.html";
                createCookie('id_medecin',results.id_medecin, 7);
                createCookie('nom_medecin',results.nom_medecin, 7);
                createCookie('prenom_medecin',results.prenom_medecin, 7);
                createCookie('email_medecin',results.email_medecin, 7);
                createCookie('telephone_medecin',results.telephone_medecin, 7);
                createCookie('adresse_medecin',results.adresse_medecin, 7);

                createCookie('id_patient',results.id, 7);
                createCookie('nom_patient',results.nom, 7);
                createCookie('prenom_patient',results.prenom, 7);
                createCookie('email_patient',results.email, 7);
                createCookie('telephone_patient',results.telephone, 7);
                createCookie('adresse_patient',results.adresse, 7);
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