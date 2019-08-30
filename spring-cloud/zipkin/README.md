# Zipkin Quick Start

Application’s need to be “instrumented” to report trace data to Zipkin. This
usually means configuration of a [tracer or instrumentation library](https://zipkin.io/pages/tracers_instrumentation.html). The most
popular ways to report data to Zipkin are via http or Kafka, though many other
options exist, such as Apache ActiveMQ, gRPC and RabbitMQ. The data served to
the UI is stored in-memory, or persistently with a supported backend such as
Apache Cassandra or Elasticsearch.

## Executable jar

The quickest way to get started is to fetch the [latest released server](https://search.maven.org/remote_content?g=io.zipkin&a=zipkin-server&v=LATEST&c=exec) as a self-contained executable jar. Note that the Zipkin server requires minimum JRE 8. For example:

```shell script
curl -sSL https://zipkin.io/quickstart.sh | bash -s
java -jar zipkin.jar
```

## Docker

```shell script
docker run -d -p 9411:9411 openzipkin/zipkin:2.16.2 
```

Once the server is running, you can view traces with the Zipkin UI at `http://localhost:9411/zipkin/`.

To see more detail on [docker hub of openzipkin](https://hub.docker.com/r/openzipkin/zipkin).

## Demo

Start the service/application as below:

* zipkin server
* eureka-consumer-ribbon
* eureka-consumer

### REF

* [openzipkin](https://github.com/openzipkin/zipkin/blob/master/README.md) on Github