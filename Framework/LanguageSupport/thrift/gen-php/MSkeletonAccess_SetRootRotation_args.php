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

class MSkeletonAccess_SetRootRotation_args
{
    static public $isValidate = false;

    static public $_TSPEC = array(
        1 => array(
            'var' => 'avatarId',
            'isRequired' => false,
            'type' => TType::STRING,
        ),
        2 => array(
            'var' => 'rotation',
            'isRequired' => false,
            'type' => TType::STRUCT,
            'class' => '\MQuaternion',
        ),
    );

    /**
     * @var string
     */
    public $avatarId = null;
    /**
     * @var \MQuaternion
     */
    public $rotation = null;

    public function __construct($vals = null)
    {
        if (is_array($vals)) {
            if (isset($vals['avatarId'])) {
                $this->avatarId = $vals['avatarId'];
            }
            if (isset($vals['rotation'])) {
                $this->rotation = $vals['rotation'];
            }
        }
    }

    public function getName()
    {
        return 'MSkeletonAccess_SetRootRotation_args';
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
                    if ($ftype == TType::STRING) {
                        $xfer += $input->readString($this->avatarId);
                    } else {
                        $xfer += $input->skip($ftype);
                    }
                    break;
                case 2:
                    if ($ftype == TType::STRUCT) {
                        $this->rotation = new \MQuaternion();
                        $xfer += $this->rotation->read($input);
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
        $xfer += $output->writeStructBegin('MSkeletonAccess_SetRootRotation_args');
        if ($this->avatarId !== null) {
            $xfer += $output->writeFieldBegin('avatarId', TType::STRING, 1);
            $xfer += $output->writeString($this->avatarId);
            $xfer += $output->writeFieldEnd();
        }
        if ($this->rotation !== null) {
            if (!is_object($this->rotation)) {
                throw new TProtocolException('Bad type in structure.', TProtocolException::INVALID_DATA);
            }
            $xfer += $output->writeFieldBegin('rotation', TType::STRUCT, 2);
            $xfer += $this->rotation->write($output);
            $xfer += $output->writeFieldEnd();
        }
        $xfer += $output->writeFieldStop();
        $xfer += $output->writeStructEnd();
        return $xfer;
    }
}