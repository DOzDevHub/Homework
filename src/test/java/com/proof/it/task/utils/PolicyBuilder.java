package com.proof.it.task.utils;


import java.util.ArrayList;
import java.util.List;

import com.proof.it.task.model.Policy;
import com.proof.it.task.model.PolicyTarget;
import com.proof.it.task.model.enumeration.PolicyStatus;

public class PolicyBuilder {

    private Policy policy;

    private PolicyBuilder() {
        policy = new Policy();
    }

    public static PolicyBuilder aPolicy() {
        return new PolicyBuilder();
    }

    public PolicyBuilder policyStatus(PolicyStatus policyStatus) {
        policy.setPolicyStatus(policyStatus);
        return this;
    }

    public PolicyBuilder premium(Double premium) {
        policy.setPremium(premium);
        return this;
    }

    public PolicyBuilder number(String number) {
        policy.setNumber(number);
        return this;
    }

    public PolicyBuilder policyTargets(List<PolicyTarget> policyTargets) {
        policy.setPolicyTargets(policyTargets);
        return this;
    }

    public PolicyBuilder withDefaults() {
        policy = new Policy();
        policy.setPolicyStatus(PolicyStatus.REGISTERED);
        policy.setPremium(0d);
        policy.setNumber("LV19-07-100000-1");

        List<PolicyTarget> policyTargets = new ArrayList<>();
        policyTargets.add(PolicyTargetBuilder.aPolicyTarget().withDefaults().build());
        policy.setPolicyTargets(policyTargets);
        return this;
    }

    public Policy build() {
        return policy;
    }
}
