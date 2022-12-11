package RestAPISpringBootWithDynamoDb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//The entry point of the spring boot application is the class containing @SpringBootApplication annotation and the static main method.
@SpringBootApplication
public class RestApiSpringBootWithDynamoDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestApiSpringBootWithDynamoDbApplication.class, args);
    }

}
