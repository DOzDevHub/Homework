package com.proof.it.task.utils;

import java.util.ArrayList;
import java.util.List;

import com.proof.it.task.model.PolicyItem;
import com.proof.it.task.model.PolicyTarget;

public class PolicyTargetBuilder {

    private PolicyTarget policyTarget;

    private PolicyTargetBuilder() {
        policyTarget = new PolicyTarget();
    }

    public static PolicyTargetBuilder aPolicyTarget() {
        return new PolicyTargetBuilder();
    }

    public PolicyTargetBuilder name(String name) {
        policyTarget.setName(name);
        return this;
    }

    public PolicyTargetBuilder policyItems(List<PolicyItem> policyItems) {
        policyTarget.setPolicyItems(policyItems);
        return this;
    }

    public PolicyTargetBuilder withDefaults() {
        policyTarget = new PolicyTarget();
        policyTarget.setName("Flat");

        List<PolicyItem> policyItems = new ArrayList<>();
        policyItems.add(PolicyItemBuilder.aPolicyItem().withDefaults().build());
        policyTarget.setPolicyItems(policyItems);
        return this;
    }

    public PolicyTarget build() {
        return policyTarget;
    }

}
