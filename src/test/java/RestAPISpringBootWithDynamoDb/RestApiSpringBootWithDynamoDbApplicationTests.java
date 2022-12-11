package RestAPISpringBootWithDynamoDb;

import RestAPISpringBootWithDynamoDb.model.TestTeam;
import RestAPISpringBootWithDynamoDb.service.TestTeamService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestApiSpringBootWithDynamoDbApplicationTests {

	@Autowired
	private TestTeamService testTeamService;

	@Test
	void contextLoads() {
	}

	@Test
	void testAddTestTeamMember(){
		TestTeam testTeam = new TestTeam();
		testTeam.setId("1234");
		testTeam.setFirstName("Stewart");
		testTeam.setLastName("Atkinson");
		testTeam.setYearsEmployed("5");
		testTeamService.addTestTeamMember(testTeam);
	}

}
