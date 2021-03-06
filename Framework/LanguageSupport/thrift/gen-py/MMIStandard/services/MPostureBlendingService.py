#
# Autogenerated by Thrift Compiler (0.13.0)
#
# DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
#
#  options string: py
#

from thrift.Thrift import TType, TMessageType, TFrozenDict, TException, TApplicationException
from thrift.protocol.TProtocol import TProtocolException
from thrift.TRecursive import fix_spec

import sys
import MMIStandard.services.MMIServiceBase
import logging
from .ttypes import *
from thrift.Thrift import TProcessor
from thrift.transport import TTransport
all_structs = []


class Iface(MMIStandard.services.MMIServiceBase.Iface):
    def Blend(self, startPosture, targetPosture, weight, mask, properties):
        """
        Parameters:
         - startPosture
         - targetPosture
         - weight
         - mask
         - properties

        """
        pass

    def BlendMany(self, startPosture, targetPosture, weights, mask, properties):
        """
        Parameters:
         - startPosture
         - targetPosture
         - weights
         - mask
         - properties

        """
        pass


class Client(MMIStandard.services.MMIServiceBase.Client, Iface):
    def __init__(self, iprot, oprot=None):
        MMIStandard.services.MMIServiceBase.Client.__init__(self, iprot, oprot)

    def Blend(self, startPosture, targetPosture, weight, mask, properties):
        """
        Parameters:
         - startPosture
         - targetPosture
         - weight
         - mask
         - properties

        """
        self.send_Blend(startPosture, targetPosture, weight, mask, properties)
        return self.recv_Blend()

    def send_Blend(self, startPosture, targetPosture, weight, mask, properties):
        self._oprot.writeMessageBegin('Blend', TMessageType.CALL, self._seqid)
        args = Blend_args()
        args.startPosture = startPosture
        args.targetPosture = targetPosture
        args.weight = weight
        args.mask = mask
        args.properties = properties
        args.write(self._oprot)
        self._oprot.writeMessageEnd()
        self._oprot.trans.flush()

    def recv_Blend(self):
        iprot = self._iprot
        (fname, mtype, rseqid) = iprot.readMessageBegin()
        if mtype == TMessageType.EXCEPTION:
            x = TApplicationException()
            x.read(iprot)
            iprot.readMessageEnd()
            raise x
        result = Blend_result()
        result.read(iprot)
        iprot.readMessageEnd()
        if result.success is not None:
            return result.success
        raise TApplicationException(TApplicationException.MISSING_RESULT, "Blend failed: unknown result")

    def BlendMany(self, startPosture, targetPosture, weights, mask, properties):
        """
        Parameters:
         - startPosture
         - targetPosture
         - weights
         - mask
         - properties

        """
        self.send_BlendMany(startPosture, targetPosture, weights, mask, properties)
        return self.recv_BlendMany()

    def send_BlendMany(self, startPosture, targetPosture, weights, mask, properties):
        self._oprot.writeMessageBegin('BlendMany', TMessageType.CALL, self._seqid)
        args = BlendMany_args()
        args.startPosture = startPosture
        args.targetPosture = targetPosture
        args.weights = weights
        args.mask = mask
        args.properties = properties
        args.write(self._oprot)
        self._oprot.writeMessageEnd()
        self._oprot.trans.flush()

    def recv_BlendMany(self):
        iprot = self._iprot
        (fname, mtype, rseqid) = iprot.readMessageBegin()
        if mtype == TMessageType.EXCEPTION:
            x = TApplicationException()
            x.read(iprot)
            iprot.readMessageEnd()
            raise x
        result = BlendMany_result()
        result.read(iprot)
        iprot.readMessageEnd()
        if result.success is not None:
            return result.success
        raise TApplicationException(TApplicationException.MISSING_RESULT, "BlendMany failed: unknown result")


class Processor(MMIStandard.services.MMIServiceBase.Processor, Iface, TProcessor):
    def __init__(self, handler):
        MMIStandard.services.MMIServiceBase.Processor.__init__(self, handler)
        self._processMap["Blend"] = Processor.process_Blend
        self._processMap["BlendMany"] = Processor.process_BlendMany
        self._on_message_begin = None

    def on_message_begin(self, func):
        self._on_message_begin = func

    def process(self, iprot, oprot):
        (name, type, seqid) = iprot.readMessageBegin()
        if self._on_message_begin:
            self._on_message_begin(name, type, seqid)
        if name not in self._processMap:
            iprot.skip(TType.STRUCT)
            iprot.readMessageEnd()
            x = TApplicationException(TApplicationException.UNKNOWN_METHOD, 'Unknown function %s' % (name))
            oprot.writeMessageBegin(name, TMessageType.EXCEPTION, seqid)
            x.write(oprot)
            oprot.writeMessageEnd()
            oprot.trans.flush()
            return
        else:
            self._processMap[name](self, seqid, iprot, oprot)
        return True

    def process_Blend(self, seqid, iprot, oprot):
        args = Blend_args()
        args.read(iprot)
        iprot.readMessageEnd()
        result = Blend_result()
        try:
            result.success = self._handler.Blend(args.startPosture, args.targetPosture, args.weight, args.mask, args.properties)
            msg_type = TMessageType.REPLY
        except TTransport.TTransportException:
            raise
        except TApplicationException as ex:
            logging.exception('TApplication exception in handler')
            msg_type = TMessageType.EXCEPTION
            result = ex
        except Exception:
            logging.exception('Unexpected exception in handler')
            msg_type = TMessageType.EXCEPTION
            result = TApplicationException(TApplicationException.INTERNAL_ERROR, 'Internal error')
        oprot.writeMessageBegin("Blend", msg_type, seqid)
        result.write(oprot)
        oprot.writeMessageEnd()
        oprot.trans.flush()

    def process_BlendMany(self, seqid, iprot, oprot):
        args = BlendMany_args()
        args.read(iprot)
        iprot.readMessageEnd()
        result = BlendMany_result()
        try:
            result.success = self._handler.BlendMany(args.startPosture, args.targetPosture, args.weights, args.mask, args.properties)
            msg_type = TMessageType.REPLY
        except TTransport.TTransportException:
            raise
        except TApplicationException as ex:
            logging.exception('TApplication exception in handler')
            msg_type = TMessageType.EXCEPTION
            result = ex
        except Exception:
            logging.exception('Unexpected exception in handler')
            msg_type = TMessageType.EXCEPTION
            result = TApplicationException(TApplicationException.INTERNAL_ERROR, 'Internal error')
        oprot.writeMessageBegin("BlendMany", msg_type, seqid)
        result.write(oprot)
        oprot.writeMessageEnd()
        oprot.trans.flush()

# HELPER FUNCTIONS AND STRUCTURES


class Blend_args(object):
    """
    Attributes:
     - startPosture
     - targetPosture
     - weight
     - mask
     - properties

    """


    def __init__(self, startPosture=None, targetPosture=None, weight=None, mask=None, properties=None,):
        self.startPosture = startPosture
        self.targetPosture = targetPosture
        self.weight = weight
        self.mask = mask
        self.properties = properties

    def read(self, iprot):
        if iprot._fast_decode is not None and isinstance(iprot.trans, TTransport.CReadableTransport) and self.thrift_spec is not None:
            iprot._fast_decode(self, iprot, [self.__class__, self.thrift_spec])
            return
        iprot.readStructBegin()
        while True:
            (fname, ftype, fid) = iprot.readFieldBegin()
            if ftype == TType.STOP:
                break
            if fid == 1:
                if ftype == TType.STRUCT:
                    self.startPosture = MMIStandard.avatar.ttypes.MAvatarPostureValues()
                    self.startPosture.read(iprot)
                else:
                    iprot.skip(ftype)
            elif fid == 2:
                if ftype == TType.STRUCT:
                    self.targetPosture = MMIStandard.avatar.ttypes.MAvatarPostureValues()
                    self.targetPosture.read(iprot)
                else:
                    iprot.skip(ftype)
            elif fid == 3:
                if ftype == TType.DOUBLE:
                    self.weight = iprot.readDouble()
                else:
                    iprot.skip(ftype)
            elif fid == 4:
                if ftype == TType.MAP:
                    self.mask = {}
                    (_ktype192, _vtype193, _size191) = iprot.readMapBegin()
                    for _i195 in range(_size191):
                        _key196 = iprot.readI32()
                        _val197 = iprot.readDouble()
                        self.mask[_key196] = _val197
                    iprot.readMapEnd()
                else:
                    iprot.skip(ftype)
            elif fid == 5:
                if ftype == TType.MAP:
                    self.properties = {}
                    (_ktype199, _vtype200, _size198) = iprot.readMapBegin()
                    for _i202 in range(_size198):
                        _key203 = iprot.readString().decode('utf-8') if sys.version_info[0] == 2 else iprot.readString()
                        _val204 = iprot.readString().decode('utf-8') if sys.version_info[0] == 2 else iprot.readString()
                        self.properties[_key203] = _val204
                    iprot.readMapEnd()
                else:
                    iprot.skip(ftype)
            else:
                iprot.skip(ftype)
            iprot.readFieldEnd()
        iprot.readStructEnd()

    def write(self, oprot):
        if oprot._fast_encode is not None and self.thrift_spec is not None:
            oprot.trans.write(oprot._fast_encode(self, [self.__class__, self.thrift_spec]))
            return
        oprot.writeStructBegin('Blend_args')
        if self.startPosture is not None:
            oprot.writeFieldBegin('startPosture', TType.STRUCT, 1)
            self.startPosture.write(oprot)
            oprot.writeFieldEnd()
        if self.targetPosture is not None:
            oprot.writeFieldBegin('targetPosture', TType.STRUCT, 2)
            self.targetPosture.write(oprot)
            oprot.writeFieldEnd()
        if self.weight is not None:
            oprot.writeFieldBegin('weight', TType.DOUBLE, 3)
            oprot.writeDouble(self.weight)
            oprot.writeFieldEnd()
        if self.mask is not None:
            oprot.writeFieldBegin('mask', TType.MAP, 4)
            oprot.writeMapBegin(TType.I32, TType.DOUBLE, len(self.mask))
            for kiter205, viter206 in self.mask.items():
                oprot.writeI32(kiter205)
                oprot.writeDouble(viter206)
            oprot.writeMapEnd()
            oprot.writeFieldEnd()
        if self.properties is not None:
            oprot.writeFieldBegin('properties', TType.MAP, 5)
            oprot.writeMapBegin(TType.STRING, TType.STRING, len(self.properties))
            for kiter207, viter208 in self.properties.items():
                oprot.writeString(kiter207.encode('utf-8') if sys.version_info[0] == 2 else kiter207)
                oprot.writeString(viter208.encode('utf-8') if sys.version_info[0] == 2 else viter208)
            oprot.writeMapEnd()
            oprot.writeFieldEnd()
        oprot.writeFieldStop()
        oprot.writeStructEnd()

    def validate(self):
        return

    def __repr__(self):
        L = ['%s=%r' % (key, value)
             for key, value in self.__dict__.items()]
        return '%s(%s)' % (self.__class__.__name__, ', '.join(L))

    def __eq__(self, other):
        return isinstance(other, self.__class__) and self.__dict__ == other.__dict__

    def __ne__(self, other):
        return not (self == other)
all_structs.append(Blend_args)
Blend_args.thrift_spec = (
    None,  # 0
    (1, TType.STRUCT, 'startPosture', [MMIStandard.avatar.ttypes.MAvatarPostureValues, None], None, ),  # 1
    (2, TType.STRUCT, 'targetPosture', [MMIStandard.avatar.ttypes.MAvatarPostureValues, None], None, ),  # 2
    (3, TType.DOUBLE, 'weight', None, None, ),  # 3
    (4, TType.MAP, 'mask', (TType.I32, None, TType.DOUBLE, None, False), None, ),  # 4
    (5, TType.MAP, 'properties', (TType.STRING, 'UTF8', TType.STRING, 'UTF8', False), None, ),  # 5
)


class Blend_result(object):
    """
    Attributes:
     - success

    """


    def __init__(self, success=None,):
        self.success = success

    def read(self, iprot):
        if iprot._fast_decode is not None and isinstance(iprot.trans, TTransport.CReadableTransport) and self.thrift_spec is not None:
            iprot._fast_decode(self, iprot, [self.__class__, self.thrift_spec])
            return
        iprot.readStructBegin()
        while True:
            (fname, ftype, fid) = iprot.readFieldBegin()
            if ftype == TType.STOP:
                break
            if fid == 0:
                if ftype == TType.STRUCT:
                    self.success = MMIStandard.avatar.ttypes.MAvatarPostureValues()
                    self.success.read(iprot)
                else:
                    iprot.skip(ftype)
            else:
                iprot.skip(ftype)
            iprot.readFieldEnd()
        iprot.readStructEnd()

    def write(self, oprot):
        if oprot._fast_encode is not None and self.thrift_spec is not None:
            oprot.trans.write(oprot._fast_encode(self, [self.__class__, self.thrift_spec]))
            return
        oprot.writeStructBegin('Blend_result')
        if self.success is not None:
            oprot.writeFieldBegin('success', TType.STRUCT, 0)
            self.success.write(oprot)
            oprot.writeFieldEnd()
        oprot.writeFieldStop()
        oprot.writeStructEnd()

    def validate(self):
        return

    def __repr__(self):
        L = ['%s=%r' % (key, value)
             for key, value in self.__dict__.items()]
        return '%s(%s)' % (self.__class__.__name__, ', '.join(L))

    def __eq__(self, other):
        return isinstance(other, self.__class__) and self.__dict__ == other.__dict__

    def __ne__(self, other):
        return not (self == other)
all_structs.append(Blend_result)
Blend_result.thrift_spec = (
    (0, TType.STRUCT, 'success', [MMIStandard.avatar.ttypes.MAvatarPostureValues, None], None, ),  # 0
)


class BlendMany_args(object):
    """
    Attributes:
     - startPosture
     - targetPosture
     - weights
     - mask
     - properties

    """


    def __init__(self, startPosture=None, targetPosture=None, weights=None, mask=None, properties=None,):
        self.startPosture = startPosture
        self.targetPosture = targetPosture
        self.weights = weights
        self.mask = mask
        self.properties = properties

    def read(self, iprot):
        if iprot._fast_decode is not None and isinstance(iprot.trans, TTransport.CReadableTransport) and self.thrift_spec is not None:
            iprot._fast_decode(self, iprot, [self.__class__, self.thrift_spec])
            return
        iprot.readStructBegin()
        while True:
            (fname, ftype, fid) = iprot.readFieldBegin()
            if ftype == TType.STOP:
                break
            if fid == 1:
                if ftype == TType.STRUCT:
                    self.startPosture = MMIStandard.avatar.ttypes.MAvatarPostureValues()
                    self.startPosture.read(iprot)
                else:
                    iprot.skip(ftype)
            elif fid == 2:
                if ftype == TType.STRUCT:
                    self.targetPosture = MMIStandard.avatar.ttypes.MAvatarPostureValues()
                    self.targetPosture.read(iprot)
                else:
                    iprot.skip(ftype)
            elif fid == 3:
                if ftype == TType.LIST:
                    self.weights = []
                    (_etype212, _size209) = iprot.readListBegin()
                    for _i213 in range(_size209):
                        _elem214 = iprot.readDouble()
                        self.weights.append(_elem214)
                    iprot.readListEnd()
                else:
                    iprot.skip(ftype)
            elif fid == 4:
                if ftype == TType.MAP:
                    self.mask = {}
                    (_ktype216, _vtype217, _size215) = iprot.readMapBegin()
                    for _i219 in range(_size215):
                        _key220 = iprot.readI32()
                        _val221 = iprot.readDouble()
                        self.mask[_key220] = _val221
                    iprot.readMapEnd()
                else:
                    iprot.skip(ftype)
            elif fid == 5:
                if ftype == TType.MAP:
                    self.properties = {}
                    (_ktype223, _vtype224, _size222) = iprot.readMapBegin()
                    for _i226 in range(_size222):
                        _key227 = iprot.readString().decode('utf-8') if sys.version_info[0] == 2 else iprot.readString()
                        _val228 = iprot.readString().decode('utf-8') if sys.version_info[0] == 2 else iprot.readString()
                        self.properties[_key227] = _val228
                    iprot.readMapEnd()
                else:
                    iprot.skip(ftype)
            else:
                iprot.skip(ftype)
            iprot.readFieldEnd()
        iprot.readStructEnd()

    def write(self, oprot):
        if oprot._fast_encode is not None and self.thrift_spec is not None:
            oprot.trans.write(oprot._fast_encode(self, [self.__class__, self.thrift_spec]))
            return
        oprot.writeStructBegin('BlendMany_args')
        if self.startPosture is not None:
            oprot.writeFieldBegin('startPosture', TType.STRUCT, 1)
            self.startPosture.write(oprot)
            oprot.writeFieldEnd()
        if self.targetPosture is not None:
            oprot.writeFieldBegin('targetPosture', TType.STRUCT, 2)
            self.targetPosture.write(oprot)
            oprot.writeFieldEnd()
        if self.weights is not None:
            oprot.writeFieldBegin('weights', TType.LIST, 3)
            oprot.writeListBegin(TType.DOUBLE, len(self.weights))
            for iter229 in self.weights:
                oprot.writeDouble(iter229)
            oprot.writeListEnd()
            oprot.writeFieldEnd()
        if self.mask is not None:
            oprot.writeFieldBegin('mask', TType.MAP, 4)
            oprot.writeMapBegin(TType.I32, TType.DOUBLE, len(self.mask))
            for kiter230, viter231 in self.mask.items():
                oprot.writeI32(kiter230)
                oprot.writeDouble(viter231)
            oprot.writeMapEnd()
            oprot.writeFieldEnd()
        if self.properties is not None:
            oprot.writeFieldBegin('properties', TType.MAP, 5)
            oprot.writeMapBegin(TType.STRING, TType.STRING, len(self.properties))
            for kiter232, viter233 in self.properties.items():
                oprot.writeString(kiter232.encode('utf-8') if sys.version_info[0] == 2 else kiter232)
                oprot.writeString(viter233.encode('utf-8') if sys.version_info[0] == 2 else viter233)
            oprot.writeMapEnd()
            oprot.writeFieldEnd()
        oprot.writeFieldStop()
        oprot.writeStructEnd()

    def validate(self):
        return

    def __repr__(self):
        L = ['%s=%r' % (key, value)
             for key, value in self.__dict__.items()]
        return '%s(%s)' % (self.__class__.__name__, ', '.join(L))

    def __eq__(self, other):
        return isinstance(other, self.__class__) and self.__dict__ == other.__dict__

    def __ne__(self, other):
        return not (self == other)
all_structs.append(BlendMany_args)
BlendMany_args.thrift_spec = (
    None,  # 0
    (1, TType.STRUCT, 'startPosture', [MMIStandard.avatar.ttypes.MAvatarPostureValues, None], None, ),  # 1
    (2, TType.STRUCT, 'targetPosture', [MMIStandard.avatar.ttypes.MAvatarPostureValues, None], None, ),  # 2
    (3, TType.LIST, 'weights', (TType.DOUBLE, None, False), None, ),  # 3
    (4, TType.MAP, 'mask', (TType.I32, None, TType.DOUBLE, None, False), None, ),  # 4
    (5, TType.MAP, 'properties', (TType.STRING, 'UTF8', TType.STRING, 'UTF8', False), None, ),  # 5
)


class BlendMany_result(object):
    """
    Attributes:
     - success

    """


    def __init__(self, success=None,):
        self.success = success

    def read(self, iprot):
        if iprot._fast_decode is not None and isinstance(iprot.trans, TTransport.CReadableTransport) and self.thrift_spec is not None:
            iprot._fast_decode(self, iprot, [self.__class__, self.thrift_spec])
            return
        iprot.readStructBegin()
        while True:
            (fname, ftype, fid) = iprot.readFieldBegin()
            if ftype == TType.STOP:
                break
            if fid == 0:
                if ftype == TType.LIST:
                    self.success = []
                    (_etype237, _size234) = iprot.readListBegin()
                    for _i238 in range(_size234):
                        _elem239 = MMIStandard.avatar.ttypes.MAvatarPostureValues()
                        _elem239.read(iprot)
                        self.success.append(_elem239)
                    iprot.readListEnd()
                else:
                    iprot.skip(ftype)
            else:
                iprot.skip(ftype)
            iprot.readFieldEnd()
        iprot.readStructEnd()

    def write(self, oprot):
        if oprot._fast_encode is not None and self.thrift_spec is not None:
            oprot.trans.write(oprot._fast_encode(self, [self.__class__, self.thrift_spec]))
            return
        oprot.writeStructBegin('BlendMany_result')
        if self.success is not None:
            oprot.writeFieldBegin('success', TType.LIST, 0)
            oprot.writeListBegin(TType.STRUCT, len(self.success))
            for iter240 in self.success:
                iter240.write(oprot)
            oprot.writeListEnd()
            oprot.writeFieldEnd()
        oprot.writeFieldStop()
        oprot.writeStructEnd()

    def validate(self):
        return

    def __repr__(self):
        L = ['%s=%r' % (key, value)
             for key, value in self.__dict__.items()]
        return '%s(%s)' % (self.__class__.__name__, ', '.join(L))

    def __eq__(self, other):
        return isinstance(other, self.__class__) and self.__dict__ == other.__dict__

    def __ne__(self, other):
        return not (self == other)
all_structs.append(BlendMany_result)
BlendMany_result.thrift_spec = (
    (0, TType.LIST, 'success', (TType.STRUCT, [MMIStandard.avatar.ttypes.MAvatarPostureValues, None], False), None, ),  # 0
)
fix_spec(all_structs)
del all_structs

