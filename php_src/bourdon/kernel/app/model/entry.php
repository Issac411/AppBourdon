<?php
require_once(LIB."Model.php");
class entry extends Model
{
    protected $id;
    protected $idcompany;
    protected $idcommercial;
    protected $idimportance;
    protected $date;
    protected $comment;
    protected $duration;
    protected $status;

    public function __construct()
    {
        parent::__construct("entry", "id");
        $this->id = null;
        $this->idcompany = null;
        $this->idcommercial = null;
        $this->idimportance = null;
        $this->date = null;
        $this->comment = null;
        $this->duration = null;
        $this->status = null;
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
    public function getIdcompany()
    {
        return $this->idcompany;
    }

    /**
     * @param null $idcompany
     */
    public function setIdcompany($idcompany)
    {
        $this->idcompany = $idcompany;
    }

    /**
     * @return null
     */
    public function getIdcommercial()
    {
        return $this->idcommercial;
    }

    /**
     * @param null $idcommercial
     */
    public function setIdcommercial($idcommercial)
    {
        $this->idcommercial = $idcommercial;
    }

    /**
     * @return null
     */
    public function getIdimportance()
    {
        return $this->idimportance;
    }

    /**
     * @param null $idimportance
     */
    public function setIdimportance($idimportance)
    {
        $this->idimportance = $idimportance;
    }

    /**
     * @return null
     */
    public function getDate()
    {
        return $this->date;
    }

    /**
     * @param null $date
     */
    public function setDate($date)
    {
        $this->date = $date;
    }

    /**
     * @return null
     */
    public function getComment()
    {
        return $this->comment;
    }

    /**
     * @param null $comment
     */
    public function setComment($comment)
    {
        $this->comment = $comment;
    }

    /**
     * @return null
     */
    public function getDuration()
    {
        return $this->duration;
    }

    /**
     * @param null $duration
     */
    public function setDuration($duration)
    {
        $this->duration = $duration;
    }

    /**
     * @return null
     */
    public function getStatus()
    {
        return $this->status;
    }

    /**
     * @param null $status
     */
    public function setStatus($status)
    {
        $this->status = $status;
    }





}