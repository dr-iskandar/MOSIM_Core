// This autogenerated skeleton file illustrates how to build a server.
// You should copy it to another filename to avoid overwriting it.

#include "MPathPlanningService.h"
#include <thrift/protocol/TBinaryProtocol.h>
#include <thrift/server/TSimpleServer.h>
#include <thrift/transport/TServerSocket.h>
#include <thrift/transport/TBufferTransports.h>

using namespace ::apache::thrift;
using namespace ::apache::thrift::protocol;
using namespace ::apache::thrift::transport;
using namespace ::apache::thrift::server;

using namespace  ::MMIStandard;

class MPathPlanningServiceHandler : virtual public MPathPlanningServiceIf {
 public:
  MPathPlanningServiceHandler() {
    // Your initialization goes here
  }

  void ComputePath( ::MMIStandard::MPathConstraint& _return, const  ::MMIStandard::MVector& start, const  ::MMIStandard::MVector& goal, const std::vector< ::MMIStandard::MSceneObject> & sceneObjects, const std::map<std::string, std::string> & properties) {
    // Your implementation goes here
    printf("ComputePath\n");
  }

  void ComputePathDirection( ::MMIStandard::MVector& _return, const  ::MMIStandard::MVector& current, const  ::MMIStandard::MVector& goal, const std::vector< ::MMIStandard::MSceneObject> & sceneObject, const std::map<std::string, std::string> & properties) {
    // Your implementation goes here
    printf("ComputePathDirection\n");
  }

};

int main(int argc, char **argv) {
  int port = 9090;
  ::std::shared_ptr<MPathPlanningServiceHandler> handler(new MPathPlanningServiceHandler());
  ::std::shared_ptr<TProcessor> processor(new MPathPlanningServiceProcessor(handler));
  ::std::shared_ptr<TServerTransport> serverTransport(new TServerSocket(port));
  ::std::shared_ptr<TTransportFactory> transportFactory(new TBufferedTransportFactory());
  ::std::shared_ptr<TProtocolFactory> protocolFactory(new TBinaryProtocolFactory());

  TSimpleServer server(processor, serverTransport, transportFactory, protocolFactory);
  server.serve();
  return 0;
}
