package com.dailycodebuffer.spring.boot.tutorial.exception;


import com.dailycodebuffer.spring.boot.tutorial.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class RestResponsesStatusExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<ErrorMessage> getDepartmentNotFoundException(DepartmentNotFoundException exception, WebRequest request){
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, "The Department with the specific id is not found in the database");  // new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return  ResponseEntity.status((HttpStatus.NOT_FOUND)).body(message);
    }

//    @ExceptionHandler(value = DepartmentNotFoundException.class)
//    public ResponseEntity<Object> exception(DepartmentNotFoundException exception) {
//        return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
//    }
}
