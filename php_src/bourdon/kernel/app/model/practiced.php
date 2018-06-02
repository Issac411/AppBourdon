<?php
require_once(LIB."Model.php");
class practiced extends Model
{
    protected $idSpecialisation;
    protected $idCompany;

    public function __construct()
    {
        parent::__construct("practiced", array("idSpecialisation","idCompany"));
        $this->idSpecialisation = null;
        $this->idCompany = null;
    }



    /**
     * @return mixed
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * @param mixed $id
     *
     * @return self
     */
    public function setId($id)
    {
        $this->id = $id;

        return $this;
    }

    /**
     * @return mixed
     */
    public function getIdSpecialisation()
    {
        return $this->idSpecialisation;
    }

    /**
     * @param mixed $idSpecialisation
     *
     * @return self
     */
    public function setIdSpecialisation($idSpecialisation)
    {
        $this->idSpecialisation = $idSpecialisation;

        return $this;
    }

        /**
     * @return mixed
     */
    public function getIdCompany()
    {
        return $this->idCompany;
    }

    /**
     * @param mixed $idCompany
     *
     * @return self
     */
    public function setIdCompany($idCompany)
    {
        $this->idCompany = $idCompany;

        return $this;
    }


}