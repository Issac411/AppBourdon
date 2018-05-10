<?php
require_once(LIB."Model.php");
class importance extends Model
{
    protected $id;
    protected $content;

    public function __construct()
    {
        parent::__construct("importance", "id");
        $this->id = null;
        $this->content = null;
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
     * @return mixed
     */
    public function getContent()
    {
        return $this->content;
    }

    /**
     * @param mixed $content
     *
     * @return self
     */
    public function setContent($content)
    {
        $this->content = $content;

        return $this;
    }
}