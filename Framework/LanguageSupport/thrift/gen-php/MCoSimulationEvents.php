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

class MCoSimulationEvents
{
    static public $isValidate = false;

    static public $_TSPEC = array(
        1 => array(
            'var' => 'Events',
            'isRequired' => true,
            'type' => TType::LST,
            'etype' => TType::STRUCT,
            'elem' => array(
                'type' => TType::STRUCT,
                'class' => '\MSimulationEvent',
                ),
        ),
        2 => array(
            'var' => 'SimulationTime',
            'isRequired' => true,
            'type' => TType::DOUBLE,
        ),
        3 => array(
            'var' => 'FrameNumber',
            'isRequired' => true,
            'type' => TType::I32,
        ),
    );

    /**
     * @var \MSimulationEvent[]
     */
    public $Events = null;
    /**
     * @var double
     */
    public $SimulationTime = null;
    /**
     * @var int
     */
    public $FrameNumber = null;

    public function __construct($vals = null)
    {
        if (is_array($vals)) {
            if (isset($vals['Events'])) {
                $this->Events = $vals['Events'];
            }
            if (isset($vals['SimulationTime'])) {
                $this->SimulationTime = $vals['SimulationTime'];
            }
            if (isset($vals['FrameNumber'])) {
                $this->FrameNumber = $vals['FrameNumber'];
            }
        }
    }

    public function getName()
    {
        return 'MCoSimulationEvents';
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
                    if ($ftype == TType::LST) {
                        $this->Events = array();
                        $_size0 = 0;
                        $_etype3 = 0;
                        $xfer += $input->readListBegin($_etype3, $_size0);
                        for ($_i4 = 0; $_i4 < $_size0; ++$_i4) {
                            $elem5 = null;
                            $elem5 = new \MSimulationEvent();
                            $xfer += $elem5->read($input);
                            $this->Events []= $elem5;
                        }
                        $xfer += $input->readListEnd();
                    } else {
                        $xfer += $input->skip($ftype);
                    }
                    break;
                case 2:
                    if ($ftype == TType::DOUBLE) {
                        $xfer += $input->readDouble($this->SimulationTime);
                    } else {
                        $xfer += $input->skip($ftype);
                    }
                    break;
                case 3:
                    if ($ftype == TType::I32) {
                        $xfer += $input->readI32($this->FrameNumber);
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
        $xfer += $output->writeStructBegin('MCoSimulationEvents');
        if ($this->Events !== null) {
            if (!is_array($this->Events)) {
                throw new TProtocolException('Bad type in structure.', TProtocolException::INVALID_DATA);
            }
            $xfer += $output->writeFieldBegin('Events', TType::LST, 1);
            $output->writeListBegin(TType::STRUCT, count($this->Events));
            foreach ($this->Events as $iter6) {
                $xfer += $iter6->write($output);
            }
            $output->writeListEnd();
            $xfer += $output->writeFieldEnd();
        }
        if ($this->SimulationTime !== null) {
            $xfer += $output->writeFieldBegin('SimulationTime', TType::DOUBLE, 2);
            $xfer += $output->writeDouble($this->SimulationTime);
            $xfer += $output->writeFieldEnd();
        }
        if ($this->FrameNumber !== null) {
            $xfer += $output->writeFieldBegin('FrameNumber', TType::I32, 3);
            $xfer += $output->writeI32($this->FrameNumber);
            $xfer += $output->writeFieldEnd();
        }
        $xfer += $output->writeFieldStop();
        $xfer += $output->writeStructEnd();
        return $xfer;
    }
}