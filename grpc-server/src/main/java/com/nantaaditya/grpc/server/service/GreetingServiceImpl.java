package com.nantaaditya.grpc.server.service;

import com.nantaaditya.grpc.proto.GreetingServiceGrpc;
import com.nantaaditya.grpc.proto.HelloReply;
import com.nantaaditya.grpc.proto.HelloRequest;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

@Slf4j
@GrpcService
public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {

  @Override
  public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
    HelloReply reply = HelloReply.newBuilder()
        .setMessage("Hi " + request.getName())
        .build();
    log.info("#GRPC - server {}", reply);

    if (request.getName().equals("error")) {
      responseObserver.onError(new IllegalArgumentException("invalid parameter"));
    } else {
      responseObserver.onNext(reply);
    }
    responseObserver.onCompleted();
  }
}
