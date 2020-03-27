package com.proof.it.task.service;

import com.proof.it.task.model.Policy;
import com.proof.it.task.model.enumeration.PolicyStatus;
import com.proof.it.task.service.calculators.PremiumCalculator;
import com.proof.it.task.service.validatiors.PolicyCalculationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PolicyService {

    PremiumCalculator premiumCalculator;
    PolicyCalculationValidator policyCalculationValidator;

    @Autowired
    public PolicyService(PremiumCalculator premiumCalculator, PolicyCalculationValidator policyCalculationValidator){
        this.premiumCalculator = premiumCalculator;
        this.policyCalculationValidator = policyCalculationValidator;
    }

    public Policy calculatePolicyPremium(Policy policy) {
        policyCalculationValidator.validate(policy);
        premiumCalculator.calculate(policy);
        policy.setPolicyStatus(PolicyStatus.APPROVED);
        return policy;
    }
}
