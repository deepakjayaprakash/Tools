# Tools
### Utilities

Has the following things as of now
1. Db Connectors
   - MySql: [MySqlConnector.java](src/main/java/DBClients/MySqlConnector.java)
   - Postgres: Coming up
   - Hikari Pool integration: [Properties file for hikari](src/main/resources/psql.datasource.properties)
   - Redis: used jedis as client, [client code](src/main/java/redis/RedisClient.java)
   - Guava Cache: [Sample code](src/main/java/DBClients/GuavaCache.java)

2. DropWizardServer:
   - Has a basic setup of drop wizard server.
   - [Main application](src/main/java/DropWizard/DropWizardApplication.java)
   - [Sample API](src/main/java/DropWizard/resource/SimpleAPI.java)
 
3. HTTP Utils:
   - Client used: DefaultAsyncHttpClient
   - [Sample code](src/main/java/HTTPUtils/HTTPCaller.java)
   - [Hystrix Integration](src/main/java/HTTPUtils/CommandExecutor.java)

4. Spring:
   - [config file](src/main/resources/application-context.xml)
   - [spring properties file](src/main/resources/spring.properties)



### To build and run via jar
```
mvn clean install
java -cp target/tools-1.0-SNAPSHOT.jar MainClass
```