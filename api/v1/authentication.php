<?php 
$app->get('/session', function() {
    $db = new DbHandler();
    $session = $db->getSession();
    $response["id"] = $session['id'];
    $response["nom"] = $session['nom'];
    $response["email"] = $session['email'];
    echoResponse(200, $session);
});

//ici les if des radios Medecin et Patient
$app->post('/login', function() use ($app) {
    require_once 'passwordHash.php';
    $r = json_decode($app->request->getBody());
    verifyRequiredParams(array('email', 'password','type'),$r->customer);
    $response = array();
    $db = new DbHandler();
    $type = $r->customer->type;
    $password = $r->customer->password;
    $email = $r->customer->email;
    if($type == "medecin"){
    $user = $db->getOneRecord("select id,nom,prenom,email,password,telephone,adresse from medecin where email='$email'");
}
    else if($type == "patient"){
     $user = $db->getOneRecord("select id,nom,prenom,email,password,telephone,adresse from patient where email='$email'");
    }
    if ($user != NULL) {
        if(passwordHash::check_password($user['password'],$password)){
        $response['status'] = "Succès";
        $response['message'] = 'Connexion avec succès';
        $response['id'] = $user['id'];
        $response['nom'] = $user['nom'];
        $response['prenom'] = $user['prenom'];
        $response['email'] = $user['email'];
        $response['password'] = $user['password'];
        $response['telephone'] = $user['telephone'];
        $response['adresse'] = $user['adresse'];
        $response['type'] = $type;
        if (!isset($_SESSION)) {
            session_start();
        }
        $_SESSION['id'] = $user['id'];
        $_SESSION['email'] = $user['email'];
        $_SESSION['nom'] = $user['nom'];
        } else {
            $response['status'] = "Erreur";
            $response['message'] = 'Connexion erronée, invalides informations';
        }
    }else {
            $response['status'] = "Erreur";
            $response['message'] = 'Aucun utilisateur n\'est enregistré';
        }
    echoResponse(200, $response);

});
$app->post('/signUp', function() use ($app) {
    $response = array();
    $r = json_decode($app->request->getBody());
    verifyRequiredParams(array('email', 'nom', 'password','prenom','adresse', 'telephone'),$r->customer);
    require_once 'passwordHash.php';
    $db = new DbHandler();
    $telephone = $r->customer->telephone;
    $nom = $r->customer->nom;
    $email = $r->customer->email;
    $adresse = $r->customer->adresse;
    $password = $r->customer->password;
    $isUserExists = $db->getOneRecord("select id,nom,prenom,email,password,telephone,adresse from medecin where email='$email'");
    if(!$isUserExists){
        $r->customer->password = passwordHash::hash($password);
        $tabble_name = "medecin";
        $column_names = array('nom', 'prenom', 'email', 'password', 'telephone','adresse');
        $result = $db->insertIntoTable($r->customer, $column_names, $tabble_name);
        if ($result != NULL) {
            $response["status"] = "Succès";
            $response["message"] = "Utilisateur est créé avec succès";
            $response["id"] = $result;
            if (!isset($_SESSION)) {
                session_start();
            }
            $_SESSION['id'] = $response["id"];
            $_SESSION['nom'] = $nom;
            $_SESSION['email'] = $email;
            echoResponse(200, $response);
        } else {
            $response["status"] = "Erreur";
            $response["message"] = "Création d'utilisateur a été échoué";
            echoResponse(201, $response);
        }            
    }else{
        $response["status"] = "Erreur";
        $response["message"] = "Un utilisateur est déja enregistré avec cet Email";
        echoResponse(201, $response);
    }
});
$app->get('/logout', function() {
    $db = new DbHandler();
    $session = $db->destroySession();
    $response["status"] = "Info";
    $response["message"] = "Déconnexion réussite";
    echoResponse(200, $response);
});

$app->post('/ajoutPat', function() use ($app) {
    $db = new DbHandler();
    $session = $db->getSession();
    $response = array();
    $r = json_decode($app->request->getBody());
    verifyRequiredParams(array('email', 'nom', 'password','prenom','adresse', 'telephone'),$r->patient);
    require_once 'passwordHash.php';
    $db = new DbHandler();
    $telephone = $r->patient->telephone;
    $nom = $r->patient->nom;
    $email = $r->patient->email;
    $adresse = $r->patient->adresse;
    $password = $r->patient->password;
    $r->patient->id_medecin = $session['id'];
    $isUserExists = $db->getOneRecord("select id,nom,prenom,email,password,telephone,adresse from patient where email='$email'");
    if(!$isUserExists){
        $r->patient->password = passwordHash::hash($password);
        $tabble_name = "patient";
        $column_names = array('nom', 'prenom', 'email', 'password', 'telephone','adresse','id_medecin');
        $result = $db->insertIntoTable($r->patient, $column_names, $tabble_name);
        if ($result != NULL) {
            $response["status"] = "Succès";
            $response["message"] = "Patient est créé avec succès";
            $response["id"] = $result;
            echoResponse(200, $response);
        } else {
            $response["status"] = "Erreur";
            $response["message"] = "Création du patient a été échoué";
            echoResponse(201, $response);
        }            
    }else{
        $response["status"] = "Erreur";
        $response["message"] = "Un patient est déja enregistré avec cet Email";
        echoResponse(201, $response);
    }
});


?>