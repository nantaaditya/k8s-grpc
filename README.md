# Getting Started

### Create RPC from proto file
```shell
cd grpc-proto
mvn clean install
```

### Running Server
```shell
cd grpc-server
mvn spring-boot:run
```

### Running Client
```shell
cd grpc-client
mvn spring-boot:run
```

### Running on Docker
```shell
# create jar file
cd grpc-server
mvn install

cd grpc-client
mvn install

# create docker image
cd grpc-server
docker build --rm -f .docker/Dockerfile -t nantaaditya/grpc-server:0.0.1 .

cd grpc-client
docker build --rm -f .docker/Dockerfile -t nantaaditya/grpc-client:0.0.1 .
```

### Running on K8s
```shell
kubectl apply -f .k8s
```