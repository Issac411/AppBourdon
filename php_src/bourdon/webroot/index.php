<?php
function debug($var){
    echo "<pre>";
    print_r($var);
    echo "</pre>";
}
session_start();

//Define all needed constant
$webroot = dirname(str_replace("index.php","",$_SERVER['SCRIPT_NAME']));
if($webroot != "/"){
    $webroot .= "/";
}
//Root path of the app
define("ROOT",dirname(str_replace("index.php","",$_SERVER['SCRIPT_FILENAME']))."/kernel/");
//Webroot path
define("WEBROOT",$webroot);
//Path for web resources ( img,js,css )
define("WEBROOTSRC",str_replace("index.php","",$_SERVER['SCRIPT_FILENAME'])."webroot/");
//path for the app path ( models, views, controllers)
define("APP",ROOT."app/");
//path for parent classes
define("LIB",ROOT."lib/");
//path for config of the app, like Database config
define("CONFIG",APP."config/");

//Subpath for the app
define("MODEL",APP."model/");
define("CONTROLLER",APP."controller/");
define("VIEW",APP."view/");
define("LAYOUT",VIEW."layout/");
//Subpath for the web resources
define("CSS",WEBROOT."css/");
define("JS",WEBROOT."js/");
define("IMG",WEBROOT."img/");
//Define the controller
$from = '/'.preg_quote(WEBROOT, '/').'/';
$tmpreq = preg_replace($from, "", $_SERVER['REQUEST_URI'], 1);
$req = explode("?",$tmpreq)[0];
if(!empty($req)){
    $params = explode('/',$req);
    $controller = str_replace("-","_",ucfirst($params[0]));
}else{
    $controller = "Database";
    $params = array();
}
//Define the method
if(!empty($params[1])){
    $action = str_replace("-","_",$params[1]);
}else{
    $action = "index";
}

$controllerName = $controller;
$controller = $controller."Controller";
$controllerFile = CONTROLLER.$controller.".php";
//Require the controller file
if(file_exists($controllerFile)){
    require_once($controllerFile);
}else{
    $controller = "DatabaseController";
    $controllerFile = CONTROLLER.$controller.".php";
    $action = "index";
    require_once($controllerFile);
}

//Construct the controller
if(class_exists($controller)){
    $controller = new $controller();
}else{
    $controller = "DatabaseController";
    $controllerFile = CONTROLLER.$controller.".php";
    $action = "index";
    require_once($controllerFile);
    $controller = new $controller();
}
//Execute the method
if(method_exists($controller,$action)){
    unset($params[0]);
    unset($params[1]);
    call_user_func_array(array($controller,$action),$params);
}else{
    $controller = "DatabaseController";
    $controllerFile = CONTROLLER.$controller.".php";
    $action = "index";
    require_once($controllerFile);
    $controller = new $controller();
    call_user_func_array(array($controller,$action),$params);
}
?>