# Error Redis en Spring Boot 3


We created a Simple application using Redis and a config Server. Since switching to Spring Boot 3, the application no longer starts and we have the following error: 

```
"MSG": "Redis health check failed", "DATA": "boundedElastic-1 org.springframework.boot.actuate.data.redis.RedisReactiveHealthIndicator Redis health check failed org.springframework.data.redis.RedisConnectionFailureException: Unable to connect to Redis\n at...
```

If we remove the config server and its dependency (spring-cloud-servcices-starter-config-client), everything works fine. We noticed that it was the automatic recovery of credentials that was done more with the right path. 

The new path since spring boot 3 is spring.data.redis while automatic recovery seems to get its information elsewhere.

It is possible to override the redis connection configuration with the correct path but it is no longer automatic and transparent for the developer.

In this example, to make the application work, you must activate the *correctif* profile.
The latter uses the configuration of the *application-correctif.yml* file:

```yaml
spring:
  data:
    redis:
      host: ${spring.redis.host}
      password: ${spring.redis.password}
      port: ${spring.redis.port}
```

Using the dependency [java-cfenv](https://github.com/pivotal-cf/java-cfenv) library, does not solve our problem:

```xml
<dependency>
  <groupId>io.pivotal.cfenv</groupId>
  <artifactId>java-cfenv-boot</artifactId>
  <version>2.4.0</version>
</dependency>
```
