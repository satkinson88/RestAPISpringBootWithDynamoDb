package RestAPISpringBootWithDynamoDb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

/*Spring provides @ControllerAdvice annotation that we can use with any class to define our global exception handler.
The handler methods in Global Controller Advice is same as Controller based exception handler methods and used when
controller class is not able to handle the exception.*/
@ControllerAdvice
public class CustomisedResponseEntityExceptionHandler {
    /*We can define exception handler methods in our controller classes. All we need is to annotate these methods
    with @ExceptionHandler annotation. This annotation takes Exception class as argument. So if we have defined one
    of these for Exception class, then all the exceptions thrown by our request handler method will have handled.
    These exception handler methods are just like other request handler methods and we can build error response
    and respond with different error page.*/
    @ExceptionHandler(EntityNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleDataNotFoundException(EntityNotFoundException ex, WebRequest request) {

        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
}
