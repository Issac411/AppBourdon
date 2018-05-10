<?php
require_once(LIB."Model.php");
class specialisation extends Model
{
    protected $id;
    protected $libelle;
    protected $code;

    public function __construct()
    {
        parent::__construct("specialisation", "id");
        $this->id = null;
        $this->libelle = null;
        $this->code = null;
    }

    /**
     * @return null
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * @param null $id
     */
    public function setId($id)
    {
        $this->id = $id;
    }

    /**
     * @return null
     */
    public function getLibelle()
    {
        return $this->libelle;
    }

    /**
     * @param null $libelle
     */
    public function setLibelle($libelle)
    {
        $this->libelle = $libelle;
    }

    /**
     * @return null
     */
    public function getCode()
    {
        return $this->code;
    }

    /**
     * @param null $libelle
     */
    public function setCode($code)
    {
        $this->code = $code;
    }

}