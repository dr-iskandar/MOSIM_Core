<?php
/**
 * Autogenerated by Thrift Compiler (0.13.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
use Thrift\Base\TBase;
use Thrift\Type\TType;
use Thrift\Type\TMessageType;
use Thrift\Exception\TException;
use Thrift\Exception\TProtocolException;
use Thrift\Protocol\TProtocol;
use Thrift\Protocol\TBinaryProtocolAccelerated;
use Thrift\Exception\TApplicationException;

class MMIAdapter_Initialize_args
{
    static public $isValidate = false;

    static public $_TSPEC = array(
        1 => array(
            'var' => 'avatarDescription',
            'isRequired' => false,
            'type' => TType::STRUCT,
            'class' => '\MAvatarDescription',
        ),
        2 => array(
            'var' => 'properties',
            'isRequired' => false,
            'type' => TType::MAP,
            'ktype' => TType::STRING,
            'vtype' => TType::STRING,
            'key' => array(
                'type' => TType::STRING,
            ),
            'val' => array(
                'type' => TType::STRING,
                ),
        ),
        3 => array(
            'var' => 'mmuID',
            'isRequired' => false,
            'type' => TType::STRING,
        ),
        4 => array(
            'var' => 'sessionID',
            'isRequired' => false,
            'type' => TType::STRING,
        ),
    );

    /**
     * @var \MAvatarDescription
     */
    public $avatarDescription = null;
    /**
     * @var array
     */
    public $properties = null;
    /**
     * @var string
     */
    public $mmuID = null;
    /**
     * @var string
     */
    public $sessionID = null;

    public function __construct($vals = null)
    {
        if (is_array($vals)) {
            if (isset($vals['avatarDescription'])) {
                $this->avatarDescription = $vals['avatarDescription'];
            }
            if (isset($vals['properties'])) {
                $this->properties = $vals['properties'];
            }
            if (isset($vals['mmuID'])) {
                $this->mmuID = $vals['mmuID'];
            }
            if (isset($vals['sessionID'])) {
                $this->sessionID = $vals['sessionID'];
            }
        }
    }

    public function getName()
    {
        return 'MMIAdapter_Initialize_args';
    }


    public function read($input)
    {
        $xfer = 0;
        $fname = null;
        $ftype = 0;
        $fid = 0;
        $xfer += $input->readStructBegin($fname);
        while (true) {
            $xfer += $input->readFieldBegin($fname, $ftype, $fid);
            if ($ftype == TType::STOP) {
                break;
            }
            switch ($fid) {
                case 1:
                    if ($ftype == TType::STRUCT) {
                        $this->avatarDescription = new \MAvatarDescription();
                        $xfer += $this->avatarDescription->read($input);
                    } else {
                        $xfer += $input->skip($ftype);
                    }
                    break;
                case 2:
                    if ($ftype == TType::MAP) {
                        $this->properties = array();
                        $_size23 = 0;
                        $_ktype24 = 0;
                        $_vtype25 = 0;
                        $xfer += $input->readMapBegin($_ktype24, $_vtype25, $_size23);
                        for ($_i27 = 0; $_i27 < $_size23; ++$_i27) {
                            $key28 = '';
                            $val29 = '';
                            $xfer += $input->readString($key28);
                            $xfer += $input->readString($val29);
                            $this->properties[$key28] = $val29;
                        }
                        $xfer += $input->readMapEnd();
                    } else {
                        $xfer += $input->skip($ftype);
                    }
                    break;
                case 3:
                    if ($ftype == TType::STRING) {
                        $xfer += $input->readString($this->mmuID);
                    } else {
                        $xfer += $input->skip($ftype);
                    }
                    break;
                case 4:
                    if ($ftype == TType::STRING) {
                        $xfer += $input->readString($this->sessionID);
                    } else {
                        $xfer += $input->skip($ftype);
                    }
                    break;
                default:
                    $xfer += $input->skip($ftype);
                    break;
            }
            $xfer += $input->readFieldEnd();
        }
        $xfer += $input->readStructEnd();
        return $xfer;
    }

    public function write($output)
    {
        $xfer = 0;
        $xfer += $output->writeStructBegin('MMIAdapter_Initialize_args');
        if ($this->avatarDescription !== null) {
            if (!is_object($this->avatarDescription)) {
                throw new TProtocolException('Bad type in structure.', TProtocolException::INVALID_DATA);
            }
            $xfer += $output->writeFieldBegin('avatarDescription', TType::STRUCT, 1);
            $xfer += $this->avatarDescription->write($output);
            $xfer += $output->writeFieldEnd();
        }
        if ($this->properties !== null) {
            if (!is_array($this->properties)) {
                throw new TProtocolException('Bad type in structure.', TProtocolException::INVALID_DATA);
            }
            $xfer += $output->writeFieldBegin('properties', TType::MAP, 2);
            $output->writeMapBegin(TType::STRING, TType::STRING, count($this->properties));
            foreach ($this->properties as $kiter30 => $viter31) {
                $xfer += $output->writeString($kiter30);
                $xfer += $output->writeString($viter31);
            }
            $output->writeMapEnd();
            $xfer += $output->writeFieldEnd();
        }
        if ($this->mmuID !== null) {
            $xfer += $output->writeFieldBegin('mmuID', TType::STRING, 3);
            $xfer += $output->writeString($this->mmuID);
            $xfer += $output->writeFieldEnd();
        }
        if ($this->sessionID !== null) {
            $xfer += $output->writeFieldBegin('sessionID', TType::STRING, 4);
            $xfer += $output->writeString($this->sessionID);
            $xfer += $output->writeFieldEnd();
        }
        $xfer += $output->writeFieldStop();
        $xfer += $output->writeStructEnd();
        return $xfer;
    }
}
