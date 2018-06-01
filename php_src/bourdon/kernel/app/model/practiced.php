<?php
require_once(LIB."Model.php");
class practiced extends Model
{
    protected $idspecialisation;
    protected $idcompany;

    public function __construct()
    {
        parent::__construct("practiced", array("idSpecialisation","idCompany"));
        $this->idspecialisation = null;
        $this->idcompany = null;
    }




    /**
     * @return mixed
     */
    public function getIdSpecialisation()
    {
        return $this->idspecialisation;
    }

    /**
     * @param mixed $idSpecialisation
     *
     * @return self
     */
    public function setIdSpecialisation($idSpecialisation)
    {
        $this->idspecialisation = $idspecialisation;

        return $this;
    }

        /**
     * @return mixed
     */
    public function getIdCompany()
    {
        return $this->idcompany;
    }

    /**
     * @param mixed $idSpecialisation
     *
     * @return self
     */
    public function setIdCompany($idSpecialisation)
    {
        $this->idcompany = $idspecialisation;

        return $this;
    }
}