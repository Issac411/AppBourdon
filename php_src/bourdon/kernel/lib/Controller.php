<?php
class Controller{
    protected $vars = array();
    protected $layout = "Default";
    protected $models = array();
    public function __construct(){
        foreach ($this->models as $model){
            $this->loadModel($model);

        }
    }
    /*
     * Function render
     * @param $vue name of the view file
     * Extart all var from $this->vars
     * Show the view includes in the layout
     */
    public function render($vue){
        extract($this->vars);
        ob_start();
        require_once(VIEW.str_replace("controller","",strtolower(get_class($this)))."/".$vue.".php");
        $content_for_layout = ob_get_clean();
        require_once(LAYOUT.$this->layout.".php");
    }
    /*
     * Function loadModel
     * @param $model model name
     * Create the model and put it in $this->$model
     */
    public function loadModel($model){
        require_once (MODEL.$model.".php");
        $this->$model = new $model();
    }
    /*
     * Function set
     * @param $var
     * Merge the var given with $this->vars
     */
    public function set($var){
        $this->vars =  array_merge($this->vars,$var);
    }
}