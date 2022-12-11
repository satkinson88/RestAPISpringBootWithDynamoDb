package RestAPISpringBootWithDynamoDb.service;

import RestAPISpringBootWithDynamoDb.entity.TestTeam;
import RestAPISpringBootWithDynamoDb.exception.EntityNotFoundException;
import RestAPISpringBootWithDynamoDb.repository.TestTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

/*Adding a service layer (TestTeamService class) to implement all the business logic for the CRUD operations.
Also, included custom exception handling for Entity Not Found scenarios.*/
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
