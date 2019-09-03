# Zuul

Quick Start For Demo

Start the service as below:

* eureka-client-demo
* eureka-server
* eureka-consumer
* zuul

You would see the Eureka UI with url:

```http request
http://localhost:1001/
```

zuul would create two route rule:
```shell script
/eureka-client/**
/eureka-consumer/**
``` 

---
**NOTE**

eureka-client and eureka-consumer are application name, it would be defined in application.yml file via `spring.application.name`. 

---

Weh post the two urls via browser, it would redirect the same path: `http://localhost:2001/dc`

```http request
http://localhost:1101/eureka-consumer/consumer

http://localhost:1101/eureka-client/dc
```

And it would get the same result:

```shell script
Services: [eureka-consumer, zuul-gateway, eureka-client], Url: http://localhost:2001/dc
```