package com.br.java.carteiradigital.config.validation;

import com.fasterxml.jackson.databind.exc.ValueInstantiationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestControllerAdvice
@Slf4j
public class RestControllerAdviceHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {MethodArgumentNotValidException.class, ValueInstantiationException.class, HttpMessageNotReadableException.class})
    public List<ErrorDTO> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex) {
        log.info("MethodArgumentNotValidException");
        return ex.getBindingResult()
                .getFieldErrors().stream()
                .map(x -> new ErrorDTO(x.getField(),
                        x.getDefaultMessage())
                ).toList();
    }

    @ExceptionHandler(value={IllegalArgumentException.class, IllegalStateException.class})
    public ResponseEntity<ErrorDTO> illegalExceptionHandler(RuntimeException ex) {
        log.info(ex.getCause().toString());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorDTO(ex.getClass().getSimpleName(),
                        ex.getLocalizedMessage()));
    }

    @ExceptionHandler({ApiErrorException.class})
    public ResponseEntity<ErrorDTO> apiErrorExceptionHandler(ApiErrorException ex) {
        log.info("ApiErrorException");
        return ResponseEntity.status(ex.getStatus())
                .body(new ErrorDTO(ex.getError(),
                        ex.getLocalizedMessage()));
    }

    @ExceptionHandler({DataIntegrityViolationException.class})
    @ResponseStatus( HttpStatus.PRECONDITION_FAILED)
    public ResponseEntity<ErrorDTO> dataIntegrityViolationExceptionHandler(
    DataIntegrityViolationException ex) {
        log.info("DataIntegrityViolationException");
        return ResponseEntity.ok(
                new ErrorDTO("email", "n??o pode haver duplicidade no sistema!"));
    }
}
