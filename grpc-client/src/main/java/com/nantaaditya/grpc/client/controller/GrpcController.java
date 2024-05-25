package com.nantaaditya.grpc.client.controller;

import com.nantaaditya.grpc.proto.GreetingServiceGrpc.GreetingServiceBlockingStub;
import com.nantaaditya.grpc.proto.HelloRequest;
import java.util.Map;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GrpcController {

  @GrpcClient("greetingService")
  private GreetingServiceBlockingStub greetingServiceStub;

  @GetMapping(value = "/api/greeting/{name}",
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  public Map<String, String> greeting(@PathVariable String name) {
    return Map.of("response", greetingServiceStub.sayHello(
        HelloRequest.newBuilder().setName(name).build()
    ).getMessage());
  }
}
