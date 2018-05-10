<?php
require_once(LIB."Model.php");
class commercial extends Model
{
    protected $id;
    protected $nickName;
    protected $name;
    protected $address1;
    protected $address2;
    protected $pc;
    protected $city;

    public function __construct()
    {
        parent::__construct("commercial", "id");
        $this->id = null;
        $this->nickName = null;
        $this->name = null;
        $this->address1 = null;
        $this->address2 = null;
        $this->pc = null;
        $this->city = null;
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
    public function getNickName()
    {
        return $this->nickName;
    }

    /**
     * @param mixed $nickName
     *
     * @return self
     */
    public function setNickName($nickName)
    {
        $this->nickName = $nickName;

        return $this;
    }

    /**
     * @return mixed
     */
    public function getName()
    {
        return $this->name;
    }

    /**
     * @param mixed $name
     *
     * @return self
     */
    public function setName($name)
    {
        $this->name = $name;

        return $this;
    }

    /**
     * @return mixed
     */
    public function getAddress1()
    {
        return $this->address1;
    }

    /**
     * @param mixed $address1
     *
     * @return self
     */
    public function setAddress1($address1)
    {
        $this->address1 = $address1;

        return $this;
    }

    /**
     * @return mixed
     */
    public function getAddress2()
    {
        return $this->address2;
    }

    /**
     * @param mixed $address2
     *
     * @return self
     */
    public function setAddress2($address2)
    {
        $this->address2 = $address2;

        return $this;
    }

    /**
     * @return mixed
     */
    public function getPc()
    {
        return $this->pc;
    }

    /**
     * @param mixed $pc
     *
     * @return self
     */
    public function setPc($pc)
    {
        $this->pc = $pc;

        return $this;
    }

    /**
     * @return mixed
     */
    public function getCity()
    {
        return $this->city;
    }

    /**
     * @param mixed $city
     *
     * @return self
     */
    public function setCity($city)
    {
        $this->city = $city;

        return $this;
    }
}