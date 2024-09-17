package com.tinnova.veiculos.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ExceptionResponseHandler {

    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleNotFoundException(NotFoundException ex,
                                                                           HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;

        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), "Not Found", status.value(),
                ex.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(exceptionResponse);
    }
}
