package com.proof.it.task.controller;

import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;

import com.proof.it.task.model.Policy;
import com.proof.it.task.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PolicyController {

    @Autowired
    PolicyService policyService;

    @RequestMapping(value = "/calculate", method = RequestMethod.POST)
    public Policy calculatePolicyPremium(@Valid @RequestBody Policy policy) {
        if (policy == null) {
            throw new RuntimeException("Request mapping failed");
        }
        return policyService.calculatePolicyPremium(policy);
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
