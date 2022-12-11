package RestAPISpringBootWithDynamoDb.config;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClientBuilder;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*Spring @Configuration annotation indicates that the class has @Bean definition methods. So Spring container
can process the class and generate Spring Beans to be used in the application. Spring @Configuration annotation
allows us to use annotations for dependency injection*/
@Configuration
@EnableDynamoDBRepositories
        (basePackages = "RestAPISpringBootWithDynamoDb.repository")
public class DynamoDbConfig {

    @Value("${amazon.dynamodb.endpoint}")
    private String amazonDynamoDbEndpoint;

    @Value("${amazon.aws.accesskey}")
    private String amazonAWSAccessKey;

    @Value("${amazon.aws.secretkey}")
    private String amazonAWSSecretKey;

    /*Spring @Bean Annotation is applied on a method to specify that it returns a bean to be managed by Spring context.
    Spring Bean annotation is usually declared in Configuration classes methods.

    In Spring, the objects that form the backbone of your application and that are managed by the Spring IoC container (the spring context)
    are called beans.A bean is an object that is instantiated, assembled, and otherwise managed by a Spring IoC container.

    Inversion of Control (IoC) is a process in which an object (bean) defines its dependencies without creating them.
    This object delegates the job of constructing such dependencies to an IoC container.

    IoC is also known as dependency injection (DI). It is a process whereby objects define their dependencies, that is,
    the other objects they work with. The IoC container then injects those dependencies when it creates the bean.
    This process is fundamentally the inverse, hence the name Inversion of Control (IoC), of the bean itself

    Singleton beans are created when the Spring container is created and are destroyed when the container is destroyed.
    Singleton beans are shared; only one instance of a singleton bean is created per Spring container.
    Singleton scope is the default scope for a Spring bean*/
    @Bean
    public AmazonDynamoDB amazonDynamoDB(AWSCredentialsProvider awsCredentialsProvider) {
        AmazonDynamoDB amazonDynamoDB = AmazonDynamoDBAsyncClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(amazonDynamoDbEndpoint, "eu-west-1"))
                .withCredentials(awsCredentialsProvider).build();
        return amazonDynamoDB;
    }

    @Bean
    public AWSCredentialsProvider awsCredentialsProvider() {
        return new AWSStaticCredentialsProvider(new BasicAWSCredentials(amazonAWSAccessKey, amazonAWSSecretKey));
    }
}
