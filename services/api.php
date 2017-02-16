<?php
 	require_once("Rest.inc.php");
	class API extends REST {
		public $data = "";
		
		const DB_SERVER = "localhost";
		const DB_USER = "root";
		const DB_PASSWORD = "067486725";
		const DB = "testPsy";

		private $db = NULL;
		private $mysqli = NULL;
		public function __construct(){
			parent::__construct();				// Init parent contructor
			$this->dbConnect();					// Initiate Database connection
		}
		
		/*
		 *  Connect to Database
		*/
		private function dbConnect(){
			$this->mysqli = new mysqli(self::DB_SERVER, self::DB_USER, self::DB_PASSWORD, self::DB);
		}
		
		/*
		 * Dynmically call the method based on the query string
		 */
		public function processApi(){

			$func = strtolower(trim(str_replace("/","",$_REQUEST['x'])));
			if((int)method_exists($this,$func) > 0)
				$this->$func();
			else
				$this->response('',404); // If the method not exist with in this class "Page not found".
		}
		
		public function patients(){
			//console.log($id);
			session_start();
			if($this->get_request_method() != "GET"){
				$this->response('',406);
			}
			$id = $_SESSION['id'];
			$query="SELECT p.id, p.nom, p.prenom, p.email, p.telephone, p.adresse FROM patient p WHERE p.id_medecin = $id";
			$r = $this->mysqli->query($query) or die($this->mysqli->error.__LINE__);

			if($r->num_rows > 0){
				$result = array();
				while($row = $r->fetch_assoc()){
					$result[] = $row;
				}
				$this->response($this->json($result), 200); // send user details
			}

		}
		
		private function medecin(){
			//$_SESSION['id']=	
			if($this->get_request_method() != "GET"){
				$this->response('',406);
			}
			$id = (int)$this->_request['id'];	
				$query="SELECT distinct m.id, m.nom, m.prenom, m.email, m.adresse, m.telephone,FROM medecin m where m.id=$id";
				$r = $this->mysqli->query($query) or die($this->mysqli->error.__LINE__);
				if($r->num_rows > 0) {
					$result = $r->fetch_assoc();	
					$this->response($this->json($result), 200);
				}
			$this->response('',204);	// If no records "No Content" status
		}
		/*private function updatePatient(){
			if($this->get_request_method() != "POST"){
				$this->response('',406);
			}
			$patient = json_decode(file_get_contents("php://input"),true);
			$id = (int)$patient['id'];
			$column_names = array('patientName', 'email', 'city', 'address', 'country');
			$keys = array_keys($patient['patient']);
			$columns = '';
			$values = '';
			foreach($column_names as $desired_key){ // Check the patient received. If key does not exist, insert blank into the array.
			   if(!in_array($desired_key, $keys)) {
			   		$$desired_key = '';
				}else{
					$$desired_key = $patient['patient'][$desired_key];
				}
				$columns = $columns.$desired_key."='".$$desired_key."',";
			}
			$query = "UPDATE patients SET ".trim($columns,',')." WHERE patientNumber=$id";
			if(!empty($patient)){
				$r = $this->mysqli->query($query) or die($this->mysqli->error.__LINE__);
				$success = array('status' => "Success", "msg" => "Patient ".$id." Updated Successfully.", "data" => $patient);
				$this->response($this->json($success),200);
			}else
				$this->response('',204);	// "No Content" status
		}*/
		
		/*private function deletePatient(){
			if($this->get_request_method() != "DELETE"){
				$this->response('',406);
			}
			$id = (int)$this->_request['id'];
			if($id > 0){				
				$query="DELETE FROM patients WHERE patientNumber = $id";
				$r = $this->mysqli->query($query) or die($this->mysqli->error.__LINE__);
				$success = array('status' => "Success", "msg" => "Successfully deleted one record.");
				$this->response($this->json($success),200);
			}else
				$this->response('',204);	// If no records "No Content" status
		}*/
		
		/*
		 *	Encode array into JSON
		*/
		private function json($data){
			if(is_array($data)){
				return json_encode($data);
			}
		}
	}
	
	// Initiiate Library
	
	$api = new API;
	$api->processApi();
?>