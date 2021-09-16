
package com.dailycodebuffer.spring.boot.tutorial.exception;


import org.springframework.http.HttpStatus;

public class DepartmentNotFoundException extends  Exception{
 String message ="The product with the specific id is not found";
    public DepartmentNotFoundException() {
    }

    public DepartmentNotFoundException(String message) {
        super(message);
    }

    public DepartmentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DepartmentNotFoundException(Throwable cause) {
        super(cause);
    }

    public DepartmentNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public DepartmentNotFoundException(String message, HttpStatus notFound) {
    }
}
