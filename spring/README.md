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

# About autowire

1. If autowire set as 'byName', you should add all the property of bean.
   * To compare `properties/BeanCorrect.xml` and `properties/BeanTest1.xml`, and switch properties to executing the application to know more detail.
  