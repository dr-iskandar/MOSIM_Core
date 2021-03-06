package ThriftClients;


import MMIStandard.MCollisionDetectionService;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

public class CollisionDetectionServiceClient implements AutoCloseable {

    private final String address;
    private final int port;
    /// <summary>
    /// The access of the client
    /// </summary>
    public MCollisionDetectionService.Client Access;
    private TTransport transport;

    public CollisionDetectionServiceClient(String address, int port) {
        this.address = address;
        this.port = port;
        this.initialize(true);
    }

    public CollisionDetectionServiceClient(String address, int port, boolean autoOPen) {
        this.address = address;
        this.port = port;
        this.initialize(autoOPen);
    }

    private void initialize(boolean autoOpen) {
        this.transport = new TSocket(this.address, this.port);
        TProtocol protocol = new TCompactProtocol(transport);
        this.Access = new MCollisionDetectionService.Client(protocol);

        if (autoOpen)
            this.start();
    }

    /// <summary>
    /// Starts the client
    /// </summary>
    public void start() {
        try {
            if (!this.transport.isOpen())
                transport.open();
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        transport.close();
    }

}
