package com.proof.it.task.service.validatiors;

import com.proof.it.task.exception.PolicyValidationException;
import com.proof.it.task.model.Policy;
import com.proof.it.task.model.enumeration.PolicyStatus;
import org.springframework.stereotype.Component;

import static com.proof.it.task.model.Constants.POLICY_NUMBER_REGEX;

@Component
public class PolicyCalculationValidator {

    public void validate(Policy policy) {

        if (policy.getPolicyStatus().equals(PolicyStatus.APPROVED))
            throw new PolicyValidationException("Invalid policy status: Policy is already approved");

        if (!policy.getNumber().matches(POLICY_NUMBER_REGEX)) {
            throw new PolicyValidationException("Invalid policy number format");
        }
    }
}
