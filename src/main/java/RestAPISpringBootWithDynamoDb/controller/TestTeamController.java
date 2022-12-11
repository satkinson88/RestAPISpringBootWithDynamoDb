package RestAPISpringBootWithDynamoDb.controller;

import RestAPISpringBootWithDynamoDb.entity.TestTeam;
import RestAPISpringBootWithDynamoDb.service.TestTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

/*Spring RestController annotation is a convenience annotation that is itself annotated with @Controller
 and @ResponseBody. This annotation is applied to a class to mark it as a request handler. Spring RestController
 annotation is used to create RESTful web services using Spring MVC. Spring RestController takes care of mapping
 request data to the defined request handler method. Once response body is generated from the handler method,
 it converts it to JSON or XML response.

 In Spring-MVC when you write annotation like @Controller or @RestController, indirectly you are using a Servlet
 called Dispatcher Servlet. Dispatcher Servlet is defined in web.xml file.

 DispatcherServlet acts as the Front Controller for Spring-based web applications. So now what is Front Controller?
 Any request is going to come into our website the front controller is going to stand in front and is going to accept
 all the requests and once the front controller accepts that request then this is the job of the front controller that
 it will make a decision that who is the right controller to handle that request. Servlets run in a servlet container
 which handles the networking side (e.g. parsing an HTTP request, connection handling etc).

 - Spring boot uses Apache Tomcat by default as its servlet container (where servlets run). */


@RestController
public class TestTeamController {

    @Autowired
    TestTeamService testTeamService;

    @GetMapping("/testteam")
    public ResponseEntity<Iterable<TestTeam>> getTestTeamAll() {
        return ResponseEntity.ok(testTeamService.getTestTeamAll());
    }

    @GetMapping("/testteam/{id}")
    public ResponseEntity<Optional<TestTeam>> getTestTeamMember(@PathVariable String id) {
        return ResponseEntity.ok(testTeamService.getTestTeamMember(id));
    }

    @PostMapping("/testteam")
    public ResponseEntity<TestTeam> addTestTeamMember(@RequestBody TestTeam testTeamMember) {
        return ResponseEntity.ok(testTeamService.addTestTeamMember(testTeamMember));
    }

    @PutMapping("/testteam/{id}")
    public ResponseEntity<TestTeam> updateTestTeamMember(@RequestBody TestTeam testTeamMember, @PathVariable String id) {
        return ResponseEntity.ok(testTeamService.updateTestTeamMember(testTeamMember, id));
    }

    @DeleteMapping("/testteam/{id}")
    public ResponseEntity<Map<String, String>> deleteTestTeamMember(@PathVariable String id) {
        Map<String, String> responseMap = new TreeMap<String, String>(Collections.reverseOrder());
        testTeamService.deleteTestTeamMember(id);
        String msg = "The record has been deleted";
        responseMap.put("TestTeam_member_id", id);
        responseMap.put("message_response", msg);
        return ResponseEntity.status(HttpStatus.OK).body(responseMap);
    }

}
