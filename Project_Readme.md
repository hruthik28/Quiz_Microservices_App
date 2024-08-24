**Quiz Application**

1. Service-Registry
    - To enable Eureka server add annotation 
        ```java
        @EnableEurekaServer
        ```
    - By default eureka server runs on port 8761
    - To not auto register or fetch and also all microservices with hostname starting with local host will be registered in eureka server when it is started
        ```
        eureka.instance.hostname=localhost
        eureka.client.fetch-registry=false
        eureka.client.register-with-eureka=false
        ```
    - To register microservice to Eureka server, add eureka client dependency in pom.xml

2. Open Feign
   - To call question service from quiz service with rest template
   - step 1: add annotation in sprinboot application
      ```@EnableFeignClients```
   - step 2: create a feign package and an interface and annotate it and mention the service to connect to 
        ```@FeignClient("QUESTION-SERVICE")```
   - step 3:Put all the methods that needs to be called in question service in quizInterface