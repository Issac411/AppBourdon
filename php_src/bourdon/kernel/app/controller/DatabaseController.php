<?php
require_once(LIB."Controller.php");
class DatabaseController extends Controller{

    public function __construct(){
        $this->models = array("specialisation","company","importance","commercial");
        parent::__construct();


    }
  public function index(){
    echo "problème d'appel";
  }
/*
09/05
Boutte
Permet de gérer le CRUD pour chaque table, une fonction par table
return un res au format Json
*/
  public function specialisation($act = null,$param = null,$param2 = null,$param3 = null){      // $act = read ou delete par exemple
        $data = array();
        switch($act){
            case "read":
                if(!empty($param) && $this->specialisation->read($param)){      // si il y a un paramètre et que l'objet courrant peut se peupler
                    $data = $this->specialisation->getAll();
                }else {
                    $data["res"] = $this->specialisation->readAll();            // sinon, on read tout
                }
                break;
            case "create":
                if(!empty($param) && !empty($param2)){
                    $this->specialisation->setLibelle(urldecode($param));       // définition des attributs
                    $this->specialisation->setCode(urldecode($param2));
                    $data['res'] = $this->specialisation->create();
                }
                break;
            case "delete":
                if(!empty($param) && $this->specialisation->read($param)){  // si l'element n'existe pas, on essaie même pas de le supprimer
                    $data['res'] = $this->specialisation->delete($param);
                } else {
                    $data['res'] = false;
                }
                break;
            case "update":
                if(!empty($param) && $this->specialisation->read($param) && !empty($param2)){
                    $this->specialisation->setLibelle(urldecode($param2));
                    $data['res'] = $this->specialisation->update();
                }
                break;
            default:
                break;
        }
        $this->set(array("data" => $data));
        $this->render("json");
  }

/*
10/05
Boutte/Matthieu
Permet de gérer le CRUD pour chaque table, une fonction par table
return un res au format Json
*/
  public function company($act = null,$param = null,$param2 = null,$param3 = null,$param4 = null,$param5 = null,$param6 = null,$param7 = null,$param8 = null,$param9 = null,$param10 = null,$param11 = null){
        $data = array();
        switch($act){
            case "read":
                if(!empty($param) && $this->company->read($param)){      // si il y a un paramètre et que l'objet courrant peut se peupler
                    $data = $this->company->getAll();
                }else {
                    $data["res"] = $this->company->readAll();            // sinon, on read tout
                }
                break;
            case "create":
                if(!empty($param) && !empty($param2) && !empty($param3) && !empty($param4)){
                    $this->company->setName(urldecode($param));       // définition des attributs
                    $this->company->setAddress1(urldecode($param2));
                    $this->company->setInterName(urldecode($param3));
                    $this->company->setInterNickName(urldecode($param4));
                    $data['res'] = $this->company->create();
                }
                break;
            case "delete":
                if(!empty($param) && $this->company->read($param)){ 
                    $data['res'] = $this->company->delete($param);
                } else {
                    $data['res'] = false;
                }
                break;
            case "update":
                if(!empty($param) && $this->company->read($param) && !empty($param2)){
                    $this->company->setName(urldecode($param2));
                    $this->company->setAddress1(urldecode($param3));
                    $this->company->setAddress2(urldecode($param4));
                    $this->company->setPc(urldecode($param5));
                    $this->company->setNum(urldecode($param6));
                    $this->company->setFax(urldecode($param7));
                    $this->company->setInterName(urldecode($param8));
                    $this->company->setInterNickName(urldecode($param9));
                    $this->company->setInterNum(urldecode($param10));
                    $this->company->setInterFax(urldecode($param11));
                    $data['res'] = $this->company->update();
                }
                break;
            default:
                break;
        }
        $this->set(array("data" => $data));
        $this->render("json");
  }

/*
10/05
Boutte/Matthieu
Permet de gérer le CRUD pour chaque table, une fonction par table
return un res au format Json
*/
  public function importance($act = null,$param = null,$param2 = null){
        $data = array();
        switch($act){
            case "read":
                if(!empty($param) && $this->importance->read($param)){      // si il y a un paramètre et que l'objet courrant peut se peupler
                    $data = $this->importance->getAll();
                }else {
                    $data["res"] = $this->importance->readAll();            // sinon, on read tout
                }
                break;
            case "create":
                if(!empty($param)){
                    $this->importance->setContent(urldecode($param));       // définition des attributs
                    $data['res'] = $this->importance->create();
                }
                break;
            case "delete":
                if(!empty($param) && $this->importance->read($param)){ 
                    $data['res'] = $this->importance->delete($param);
                } else {
                    $data['res'] = false;
                }
                break;
            case "update":
                if(!empty($param) && $this->importance->read($param) && !empty($param2)){
                    $this->importance->setContent(urldecode($param2));
                    $data['res'] = $this->importance->update();
                }
                break;
            default:
                break;
        }
        $this->set(array("data" => $data));
        $this->render("json");
  }

/*
10/05
Boutte/Matthieu
Permet de gérer le CRUD pour chaque table, une fonction par table
return un res au format Json
*/
  public function commercial($act = null,$param = null,$param2 = null,$param3 = null,$param4 = null,$param5 = null,$param6 = null,$param7 = null){
        $data = array();
        switch($act){
            case "read":
                if(!empty($param) && $this->commercial->read($param)){      // si il y a un paramètre et que l'objet courrant peut se peupler
                    $data = $this->commercial->getAll(); 
                }else {
                    $data["res"] = $this->commercial->readAll();            // sinon, on read tout
                }
                break;
            case "create":
                if(!empty($param) && !empty($param2) && !empty($param3) && !empty($param4) && !empty($param5) && !empty($param6)){
                    $this->commercial->setNickName(urldecode($param));
                    $this->commercial->setName(urldecode($param2));
                    $this->commercial->setAddress1(urldecode($param3));
                    $this->commercial->setAddress2(urldecode($param4));
                    $this->commercial->setPc(urldecode($param5));
                    $this->commercial->setCity(urldecode($param6));
                    $data['res'] = $this->commercial->create();
                }
                break;
            case "delete":
                if(!empty($param) && $this->commercial->read($param)){ 
                    $data['res'] = $this->commercial->delete($param);
                } else {
                    $data['res'] = false;
                }
                break;
            case "update":
                if(!empty($param) && $this->commercial->read($param) && !empty($param2) && !empty($param3) && !empty($param4) && !empty($param5) && !empty($param6) && !empty($param7)){

                    $this->commercial->setNickName(urldecode($param));
                    $this->commercial->setName(urldecode($param2));
                    $this->commercial->setAddress1(urldecode($param3));
                    $this->commercial->setAddress2(urldecode($param4));
                    $this->commercial->setPc(urldecode($param5));
                    $this->commercial->setCity(urldecode($param6));

                    $data['res'] = $this->commercial->update();
                }
                break;
            default:
                break;
        }
        $this->set(array("data" => $data));
        $this->render("json");
  }


// il manque practiced et entry à réaliser sur ce modèle.








}