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

class MMesh
{
    static public $isValidate = false;

    static public $_TSPEC = array(
        1 => array(
            'var' => 'ID',
            'isRequired' => true,
            'type' => TType::STRING,
        ),
        2 => array(
            'var' => 'Vertices',
            'isRequired' => true,
            'type' => TType::LST,
            'etype' => TType::STRUCT,
            'elem' => array(
                'type' => TType::STRUCT,
                'class' => '\MVector3',
                ),
        ),
        3 => array(
            'var' => 'Triangles',
            'isRequired' => true,
            'type' => TType::LST,
            'etype' => TType::I32,
            'elem' => array(
                'type' => TType::I32,
                ),
        ),
        4 => array(
            'var' => 'UVCoordinates',
            'isRequired' => false,
            'type' => TType::LST,
            'etype' => TType::STRUCT,
            'elem' => array(
                'type' => TType::STRUCT,
                'class' => '\MVector2',
                ),
        ),
        5 => array(
            'var' => 'Properties',
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
    );

    /**
     * @var string
     */
    public $ID = null;
    /**
     * @var \MVector3[]
     */
    public $Vertices = null;
    /**
     * @var int[]
     */
    public $Triangles = null;
    /**
     * @var \MVector2[]
     */
    public $UVCoordinates = null;
    /**
     * @var array
     */
    public $Properties = null;

    public function __construct($vals = null)
    {
        if (is_array($vals)) {
            if (isset($vals['ID'])) {
                $this->ID = $vals['ID'];
            }
            if (isset($vals['Vertices'])) {
                $this->Vertices = $vals['Vertices'];
            }
            if (isset($vals['Triangles'])) {
                $this->Triangles = $vals['Triangles'];
            }
            if (isset($vals['UVCoordinates'])) {
                $this->UVCoordinates = $vals['UVCoordinates'];
            }
            if (isset($vals['Properties'])) {
                $this->Properties = $vals['Properties'];
            }
        }
    }

    public function getName()
    {
        return 'MMesh';
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
                        $xfer += $input->readString($this->ID);
                    } else {
                        $xfer += $input->skip($ftype);
                    }
                    break;
                case 2:
                    if ($ftype == TType::LST) {
                        $this->Vertices = array();
                        $_size70 = 0;
                        $_etype73 = 0;
                        $xfer += $input->readListBegin($_etype73, $_size70);
                        for ($_i74 = 0; $_i74 < $_size70; ++$_i74) {
                            $elem75 = null;
                            $elem75 = new \MVector3();
                            $xfer += $elem75->read($input);
                            $this->Vertices []= $elem75;
                        }
                        $xfer += $input->readListEnd();
                    } else {
                        $xfer += $input->skip($ftype);
                    }
                    break;
                case 3:
                    if ($ftype == TType::LST) {
                        $this->Triangles = array();
                        $_size76 = 0;
                        $_etype79 = 0;
                        $xfer += $input->readListBegin($_etype79, $_size76);
                        for ($_i80 = 0; $_i80 < $_size76; ++$_i80) {
                            $elem81 = null;
                            $xfer += $input->readI32($elem81);
                            $this->Triangles []= $elem81;
                        }
                        $xfer += $input->readListEnd();
                    } else {
                        $xfer += $input->skip($ftype);
                    }
                    break;
                case 4:
                    if ($ftype == TType::LST) {
                        $this->UVCoordinates = array();
                        $_size82 = 0;
                        $_etype85 = 0;
                        $xfer += $input->readListBegin($_etype85, $_size82);
                        for ($_i86 = 0; $_i86 < $_size82; ++$_i86) {
                            $elem87 = null;
                            $elem87 = new \MVector2();
                            $xfer += $elem87->read($input);
                            $this->UVCoordinates []= $elem87;
                        }
                        $xfer += $input->readListEnd();
                    } else {
                        $xfer += $input->skip($ftype);
                    }
                    break;
                case 5:
                    if ($ftype == TType::MAP) {
                        $this->Properties = array();
                        $_size88 = 0;
                        $_ktype89 = 0;
                        $_vtype90 = 0;
                        $xfer += $input->readMapBegin($_ktype89, $_vtype90, $_size88);
                        for ($_i92 = 0; $_i92 < $_size88; ++$_i92) {
                            $key93 = '';
                            $val94 = '';
                            $xfer += $input->readString($key93);
                            $xfer += $input->readString($val94);
                            $this->Properties[$key93] = $val94;
                        }
                        $xfer += $input->readMapEnd();
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
        $xfer += $output->writeStructBegin('MMesh');
        if ($this->ID !== null) {
            $xfer += $output->writeFieldBegin('ID', TType::STRING, 1);
            $xfer += $output->writeString($this->ID);
            $xfer += $output->writeFieldEnd();
        }
        if ($this->Vertices !== null) {
            if (!is_array($this->Vertices)) {
                throw new TProtocolException('Bad type in structure.', TProtocolException::INVALID_DATA);
            }
            $xfer += $output->writeFieldBegin('Vertices', TType::LST, 2);
            $output->writeListBegin(TType::STRUCT, count($this->Vertices));
            foreach ($this->Vertices as $iter95) {
                $xfer += $iter95->write($output);
            }
            $output->writeListEnd();
            $xfer += $output->writeFieldEnd();
        }
        if ($this->Triangles !== null) {
            if (!is_array($this->Triangles)) {
                throw new TProtocolException('Bad type in structure.', TProtocolException::INVALID_DATA);
            }
            $xfer += $output->writeFieldBegin('Triangles', TType::LST, 3);
            $output->writeListBegin(TType::I32, count($this->Triangles));
            foreach ($this->Triangles as $iter96) {
                $xfer += $output->writeI32($iter96);
            }
            $output->writeListEnd();
            $xfer += $output->writeFieldEnd();
        }
        if ($this->UVCoordinates !== null) {
            if (!is_array($this->UVCoordinates)) {
                throw new TProtocolException('Bad type in structure.', TProtocolException::INVALID_DATA);
            }
            $xfer += $output->writeFieldBegin('UVCoordinates', TType::LST, 4);
            $output->writeListBegin(TType::STRUCT, count($this->UVCoordinates));
            foreach ($this->UVCoordinates as $iter97) {
                $xfer += $iter97->write($output);
            }
            $output->writeListEnd();
            $xfer += $output->writeFieldEnd();
        }
        if ($this->Properties !== null) {
            if (!is_array($this->Properties)) {
                throw new TProtocolException('Bad type in structure.', TProtocolException::INVALID_DATA);
            }
            $xfer += $output->writeFieldBegin('Properties', TType::MAP, 5);
            $output->writeMapBegin(TType::STRING, TType::STRING, count($this->Properties));
            foreach ($this->Properties as $kiter98 => $viter99) {
                $xfer += $output->writeString($kiter98);
                $xfer += $output->writeString($viter99);
            }
            $output->writeMapEnd();
            $xfer += $output->writeFieldEnd();
        }
        $xfer += $output->writeFieldStop();
        $xfer += $output->writeStructEnd();
        return $xfer;
    }
}