package com.bruno.homeappliance.exceptions;

import com.bruno.homeappliance.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(
            HttpServletRequest request, ResourceNotFoundException exception
    ){
        Instant timestamp = Instant.now();
        HttpStatus status = HttpStatus.NOT_FOUND;
        String message = "The object you were looking for was not found!";
        StandardError standardError = StandardError.builder()
                .timestamp(timestamp)
                .status(status.value())
                .error(exception.getMessage())
                .message(message)
                .path(request.getRequestURI())
                .build();
        return ResponseEntity.status(status).body(standardError);
    }
}
