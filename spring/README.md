# Spring Autowire Demo

## How to build?

```
gradle clean build
```

## How to execute?

```
cd build
java -cp gs-spring-boot-0.1.0.jar
```


## Change default value in xml

```
cd resource/properties
```

## Switch properties 
By changing enum `PropertyID` in `AutowireDemo.java`

```java
String contextName = (new PropertyUtil(PropertyID.ERROR)).getContextNameByID();
```