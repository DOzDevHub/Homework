package com.proof.it.task.utils;

import com.proof.it.task.model.PolicyItem;
import com.proof.it.task.model.enumeration.RiskType;

public class PolicyItemBuilder {
    private PolicyItem policyItem;

    private PolicyItemBuilder() {
        policyItem = new PolicyItem();
    }

    public static PolicyItemBuilder aPolicyItem() {
        return new PolicyItemBuilder();
    }

    public PolicyItemBuilder riskType(RiskType riskType) {
        policyItem.setRiskType(riskType);
        return this;
    }

    public PolicyItemBuilder sumInsured(Double sumInsured) {
        policyItem.setSumInsured(sumInsured);
        return this;
    }

    public PolicyItemBuilder name(String name) {
        policyItem.setName(name);
        return this;
    }

    public PolicyItemBuilder withDefaults() {
        policyItem = new PolicyItem();
        policyItem.setRiskType(RiskType.FIRE);
        policyItem.setSumInsured(500d);
        policyItem.setName("TV");
        return this;
    }

    public PolicyItem build() {
        return policyItem;
    }
}
