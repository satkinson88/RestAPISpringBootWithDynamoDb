package RestAPISpringBootWithDynamoDb.repository;

import RestAPISpringBootWithDynamoDb.entity.TestTeam;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/*@EnableScan annotation - the repository implementation will be registered as a component in the Spring container.*/
@EnableScan
/*Spring @Repository annotation is used to indicate that the class provides the mechanism for storage,
retrieval, search, update and delete operation on objects.*/
@Repository
/*CrudRepository allows us to build communication with the database easily.*/
public interface TestTeamRepository extends CrudRepository<TestTeam, String> {
}
