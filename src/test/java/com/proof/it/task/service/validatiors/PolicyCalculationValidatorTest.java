package com.proof.it.task.service.validatiors;

import com.proof.it.task.exception.PolicyValidationException;
import com.proof.it.task.model.Policy;
import com.proof.it.task.model.enumeration.PolicyStatus;
import com.proof.it.task.utils.PolicyBuilder;
import org.junit.jupiter.api.*;

class PolicyCalculationValidatorTest {

    private static PolicyCalculationValidator policyCalculationValidator;
    Policy policy;

    @BeforeAll
    public static void initialize() {
        policyCalculationValidator = new PolicyCalculationValidator();
    }

    @BeforeEach
    public void setUp() {
        policy = PolicyBuilder.aPolicy().withDefaults().build();
    }

    @Test
    public void validateSuccess() {
        policyCalculationValidator.validate(policy);
    }

    @Test
    public void validateInvalidPolicyStatus() {
        policy.setPolicyStatus(PolicyStatus.APPROVED);

        Assertions.assertThrows(PolicyValidationException.class, () -> {
            policyCalculationValidator.validate(policy);
        });
    }

    @Test
    public void validateInvalidPolicyNumberFormat() {
        policy.setNumber("LV19-07-100a00-1");
        Assertions.assertThrows(PolicyValidationException.class, () -> {
            policyCalculationValidator.validate(policy);
        });
    }
}