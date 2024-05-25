package com.nantaaditya.grpc.server.configuration;

import io.grpc.Status;
import net.devh.boot.grpc.server.advice.GrpcAdvice;
import net.devh.boot.grpc.server.advice.GrpcExceptionHandler;

@GrpcAdvice
public class GrpcErrorHandler {

  @GrpcExceptionHandler
  public Status handleInvalidArgument(IllegalArgumentException e) {
    return Status.INVALID_ARGUMENT
        .withDescription("invalid request")
        .withCause(e);
  }
}
