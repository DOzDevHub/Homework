package com.proof.it.task.service;

import java.util.Arrays;

import com.proof.it.task.model.Policy;
import com.proof.it.task.model.enumeration.PolicyStatus;
import com.proof.it.task.service.calculators.PremiumCalculator;
import com.proof.it.task.service.risks.fire.FireRisk;
import com.proof.it.task.service.risks.water.WaterRisk;
import com.proof.it.task.service.validatiors.PolicyCalculationValidator;
import com.proof.it.task.utils.PolicyBuilder;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class PolicyServiceTest {

    PolicyService policyService;
    PremiumCalculator premiumCalculator;
    PolicyCalculationValidator policyCalculationValidator;
    Policy policy;

    @BeforeEach
    public void setUp() {
        policy = PolicyBuilder.aPolicy().withDefaults().build();

        premiumCalculator = new PremiumCalculator(Arrays.asList(new FireRisk(), new WaterRisk()));
        policyCalculationValidator = new PolicyCalculationValidator();
        policyService = new PolicyService(premiumCalculator, policyCalculationValidator);
}

    @Test
    void calculatePolicyPremium() {
        Policy policyResponse = policyService.calculatePolicyPremium(policy);
        assertEquals(policyResponse.getPolicyStatus(), PolicyStatus.APPROVED);
    }
}