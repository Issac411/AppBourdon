<?php
require_once(LIB."Model.php");
class company extends Model
{
    protected $id;
    protected $name;
    protected $address1;
    protected $address2;
    protected $city;
    protected $pc;
    protected $num;
    protected $fax;
    protected $mail;
    protected $intername;
    protected $internickname;
    protected $internum;
    protected $interfax;
    protected $intermail;

    public function __construct()
    {
        parent::__construct("company", "id");
        $this->id = null;
        $this->name = null;
        $this->address1 = null;
        $this->address2 = null;
        $this->city = null;
        $this->pc = null;
        $this->num = null;
        $this->fax = null;
        $this->mail = null;
        $this->intername = null;
        $this->internickname = null;
        $this->internum = null;
        $this->interfax = null;
        $this->intermail = null;
    }


    /**
     * @return mixed
     */
    public function getMail()
    {
        return $this->id;
    }

    /**
     * @param mixed $id
     *
     * @return self
     */
    public function setMail($id)
    {
        $this->mail = $mail;

        return $this;
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
    public function getNum()
    {
        return $this->num;
    }

    /**
     * @param mixed $num
     *
     * @return self
     */
    public function setNum($num)
    {
        $this->num = $num;

        return $this;
    }

    /**
     * @return mixed
     */
    public function getFax()
    {
        return $this->fax;
    }

    /**
     * @param mixed $fax
     *
     * @return self
     */
    public function setFax($fax)
    {
        $this->fax = $fax;

        return $this;
    }

    /**
     * @return mixed
     */
    public function getintername()
    {
        return $this->intername;
    }

    /**
     * @param mixed $intername
     *
     * @return self
     */
    public function setintername($intername)
    {
        $this->intername = $intername;

        return $this;
    }

    /**
     * @return mixed
     */
    public function getinternickname()
    {
        return $this->internickname;
    }

    /**
     * @param mixed $internickname
     *
     * @return self
     */
    public function setinternickname($internickname)
    {
        $this->internickname = $internickname;

        return $this;
    }

    /**
     * @return mixed
     */
    public function getinternum()
    {
        return $this->internum;
    }

    /**
     * @param mixed $internum
     *
     * @return self
     */
    public function setinternum($internum)
    {
        $this->internum = $internum;

        return $this;
    }

    /**
     * @return mixed
     */
    public function getinterfax()
    {
        return $this->interfax;
    }

    /**
     * @param mixed $interfax
     *
     * @return self
     */
    public function setinterfax($interfax)
    {
        $this->interfax = $interfax;

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

    /**
     * @return mixed
     */
    public function getintermail()
    {
        return $this->intermail;
    }

    /**
     * @param mixed $intermail
     *
     * @return self
     */
    public function setintermail($intermail)
    {
        $this->intermail = $intermail;

        return $this;
    }
}