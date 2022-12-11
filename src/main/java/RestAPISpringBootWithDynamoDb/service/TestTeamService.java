package RestAPISpringBootWithDynamoDb.service;

import RestAPISpringBootWithDynamoDb.model.TestTeam;
import RestAPISpringBootWithDynamoDb.exception.EntityNotFoundException;
import RestAPISpringBootWithDynamoDb.repository.TestTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/*Adding a service layer (TestTeamService class) to implement all the business logic for the CRUD operations.
Spring @Service annotation is used with classes that provide some business functionalities.
Spring context will autodetect these classes when annotation-based configuration and classpath scanning is used.
Also, included custom exception handling for Entity Not Found scenarios.*/
@Service
public class TestTeamService {

    /*Spring @Autowired annotation is used for automatic dependency injection. Spring framework is built on dependency
    injection and we inject the class dependencies through spring bean configuration file.
    Spring Boot introduces the @SpringBootApplication annotation (used on our main method). This single annotation
    is equivalent to using @Configuration, @EnableAutoConfiguration, and @ComponentScan.*/
    @Autowired
    TestTeamRepository testTeamRepository;


    public Iterable<TestTeam> getTestTeamAll() {
        return testTeamRepository.findAll();
    }

    public Optional<TestTeam> getTestTeamMember(String id) {
        Optional<TestTeam> testTeamMember = testTeamRepository.findById(id);
        if (testTeamMember.isPresent()) {
            return testTeamMember;
        } else
            throw new EntityNotFoundException("TestTeam member not found with given id: " + id);
    }

    public TestTeam updateTestTeamMember(TestTeam testTeam, String id) {
        boolean exists = testTeamRepository.existsById(id);
        if (!exists) {
            throw new EntityNotFoundException("TestTeam member not found by id: " + id);
        } else
            testTeam.setId(id);
        return testTeamRepository.save(testTeam);
    }

    public void deleteTestTeamMember(String id) {
        boolean exists = testTeamRepository.existsById(id);
        if (!exists) {
            throw new EntityNotFoundException("TestTeam member not found by id: " + id);
        } else
            testTeamRepository.deleteById(id);
    }

    public TestTeam addTestTeamMember(TestTeam testTeamMember) {
        return testTeamRepository.save(testTeamMember);
    }
}
