<?php
require_once LIB."DB.php";
abstract class Model extends DB{
	private $table;
	private $primaryKey;
	private $arraysys;
	private $defaultOrder;
	protected $belongTo = array();
	protected $primarySerial = true;
	protected $options = array();

	public function __construct($table,$primaryKey){
		$this->table = $table;
		$this->primaryKey = $primaryKey;
		$this->arraysys = array_keys(get_class_vars(__CLASS__));
		if(is_array($primaryKey)){
            $this->defaultOrder = array_values($primaryKey)[0];
        }else{
            $this->defaultOrder = $primaryKey;
        }

	}

    /*
     * Fucntion create
     * Add a new row in the table
     */
	public function create(){
		foreach (get_object_vars($this) as $k => $v){
			if(!in_array($k,$this->arraysys) AND $v !== null AND (is_array($this->primaryKey) OR ($k != $this->primaryKey OR !$this->primarySerial))){
                $varKey[] = $k;
				$varValue[":".$k] = $v;
			}
        }
        
           $date = new DateTime(null, new DateTimeZone('Europe/Paris'));
            if(property_exists($this,"created")){
                if(!in_array("created",$varKey)) {
                    $varKey[] = "created";
                }
                $varValue[":created"] = $date->getTimestamp();
            }
            if(property_exists($this,"updated")){
                        if(!in_array("updated",$varKey)) {
                    $varKey[] = "updated";
                }
                $varValue[":updated"] = $date->getTimestamp();
            }
		$req = "INSERT INTO $this->table (".implode(",",$varKey).") VALUES (:".implode(",:",$varKey).")";
                
                if($this->debug){
                    $debugReq = $req;
                    foreach($varValue as $k => $v){
                        $debugReq = str_replace($k,"'".$v."'",$debugReq);
                    }
                    echo $debugReq."<br />";

                }
        $this->connect();
                $bool = false;
		$res = $this->db->prepare($req);
                try{
//                    foreach($varValue as $k => $v){
//                        if(key_exists(str_replace(":","",$k),$this->options)){
//                            $res->bindParam($k,$v,$this->options[str_replace(":","",$k)]);
//                            unset($varValue[$k]);
//                        }
//                    }
                    if(!empty($varValue)) {
                        foreach ($varValue as $k => $v){
                            $res->bindValue($k,$v);
                        }
                    }
                    $bool = $res->execute();

                }catch (PDOException $e){
                    echo $e->getMessage();
                }
		$this->disconnect();
		return($bool);
	}

    /*
     * Function update
     * Update a row in the table
     */
	public function update(){
		$id = $this->primaryKey;
	    $req = "UPDATE $this->table SET ";
		$varTabs = array();
		$varVals = array();
	    foreach (get_object_vars($this) as $k => $v){
	        if(!in_array($k,$this->arraysys) AND $k != $this->primaryKey){
                $varTabs[] = "$k=:$k";
				$varVals[":".$k] = $v;
            }
        }
        if(property_exists($this,"updated")){
           $date = new DateTime(null, new DateTimeZone('Europe/Paris'));
            $varKey[] = "updated";
            $varVals[":updated"] = $date->getTimestamp();
        }
        if(is_array($id) && count($id) == count( $id)){
            $i = 0;
            foreach($id as $a){
                $varPrimary[] = $a."=:". $a;
                $varVals[":". $a] = $this->$a;
                $i++;
            }
        }else{
            $varPrimary[] = $id."=:".$id;
            $varVals[":".$id] = $this->$id;
        }
		$req = $req.implode(",",$varTabs)." WHERE ".implode(" AND ",$varPrimary);
                if($this->debug){
                    $debugReq = $req;
                    foreach($varVals as $k => $v){
                        $debugReq = str_replace($k,"'".$v."'",$debugReq);
                    }
                    echo $debugReq."<br />";

                }
		$this->connect();
                $bool = false;
		$res = $this->db->prepare($req);
                try{
                    if(!empty($varVals)) {
                        foreach ($varVals as $k => $v){
                            $res->bindValue($k,$v);
                        }
                    }
                    $bool = $res->execute();
                 }catch (PDOException $e){
                    echo $e->getMessage();
                }
		$this->disconnect();
                return($bool);
	}

    /*
      * Function read
      * @param $id int
      * Set all attributs of this object by reading in the table with the id given in param
      */
	public function read($id){
        $varTabs = array();
        $varVals = array();
	    if(is_array($id) && count($id) == count($this->primaryKey)){

           $i = 0;
            foreach($id as $a){
                $varTabs[] = $this->primaryKey[$i]."=:".$this->primaryKey[$i];
                $varVals[":".$this->primaryKey[$i]] = $a;
                $i++;
            }
        }else{
            $varTabs[] = "$this->primaryKey=:$this->primaryKey";
            $varVals[":".$this->primaryKey] = $id;
        }
		$req = "SELECT * FROM $this->table WHERE ".implode(" AND ",$varTabs);
	    if($this->debug){
	        $tmp = $req;
	        foreach($varVals as $k => $v){
	            $tmp = str_replace($k,$v,$tmp);
            }
            echo $tmp;
        }
		$this->connect();
        $res = $this->db->prepare($req);
        try{
        $res->execute($varVals);
         }catch (PDOException $e){
                    echo $e->getMessage();
                }
		$this->disconnect();
		if($res){
            $data = $res->fetch(PDO::FETCH_ASSOC);
        }
		if($data == null){
		    $stat = false;
        }else{
		    $stat = true;
            foreach($data as $key => $value){
                $this->$key = $value;
            }
        }
        return($stat);
	}

    /*
     * Function delete
     * @param $id int
     * Delete in the table the row with id given in param
     */
	public function delete($id){
        $varTabs = array();
        $varVals = array();
        $bool = false;
        if(is_array($id) && count($id) == count($this->primaryKey)){
            $i = 0;
            foreach($id as $a){
                $varTabs[] = $this->primaryKey[$i]."=:".$this->primaryKey[$i];
                $varVals[":".$this->primaryKey[$i]] = $a;
                $i++;
            }
        }else{
            $varTabs[] = "$this->primaryKey=:$this->primaryKey";
            $varVals[":".$this->primaryKey] = $id;
        }
		$req = "DELETE FROM $this->table WHERE ".implode(" AND ",$varTabs);
		$this->connect();
        $res = $this->db->prepare($req);
        try{
        $bool = $res->execute($varVals);
         }catch (PDOException $e){
                    echo $e->getMessage();
                }
		$this->disconnect();
        return $bool;
	}

    /*
     * Function readAll
     * @param $cond string sql condition
     * Return all row that match to the condition given in param
     */
	public function readAll($cond = "1=1"){
		$req = "SELECT * FROM $this->table WHERE $cond ORDER BY $this->defaultOrder";
                
                if($this->debug){
		echo $req;

                }
        $this->connect();
        try{
        $res = $this->db->query($req);
         }catch (PDOException $e){
                    echo $e->getMessage();
                }
        $this->disconnect();
        $tmp = array();
        if(@$res) {
            while ($data = $res->fetch(PDO::FETCH_ASSOC)) {
                $tmp[] = $data;
            }
        }
        return($tmp);
	}
	public function postToObj(){
	    foreach($_POST as $k => $v){
	        if(property_exists($this,$k)){
	            $this->$k = $v;
            }
        }
    }
    /*
 * Function getAll
 * Return all atributs of the current object in array
 */
	public function getAll(){
	    $vars = get_object_vars($this);
	    $realVars = array();
        foreach($vars as $k => $v){
            if(!in_array($k,$this->arraysys)){
                $realVars[$k] = $v;
            }
        }
	    return($realVars);
    }
    public function execSql($req){
        
                if($this->debug){
		echo $req;

                }
                $tmp = false;
        $this->connect();
        try{
        $res = $this->db->query($req);
            $tmp = array();
            if($res) {
                while ($data = $res->fetch(PDO::FETCH_ASSOC)) {
                    $tmp[] = $data;
                }
            }else{
                $tmp = false;
            }
         }catch (PDOException $e){
                    echo $e->getMessage();
                }
        $this->disconnect();

        return($tmp);
    }
    public function getBelongTo(){
        return($this->belongTo);
    }
    public function setDefaultOrder($def){
	    $this->defaultOrder = $def;
    }
}

?>