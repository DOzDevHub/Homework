package com.proof.it.task.model;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.proof.it.task.model.enumeration.PolicyStatus;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Policy {

    @NotBlank(message = "Policy number is mandatory")
    String number;

    @NotNull(message = "Policy status can't be empty")
    PolicyStatus policyStatus;

    Double premium;

    @NotEmpty(message = "Policy should have at least one target")
    List<@NotNull @Valid PolicyTarget> policyTargets;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public PolicyStatus getPolicyStatus() {
        return policyStatus;
    }

    public void setPolicyStatus(PolicyStatus policyStatus) {
        this.policyStatus = policyStatus;
    }

    public Double getPremium() {
        return premium;
    }

    public void setPremium(Double premium) {
        this.premium = premium;
    }

    public List<PolicyTarget> getPolicyTargets() {
        return policyTargets;
    }

    public void setPolicyTargets(List<PolicyTarget> policyTargets) {
        this.policyTargets = policyTargets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Policy)) return false;

        Policy policy = (Policy) o;

        return new EqualsBuilder()
                .append(getNumber(), policy.getNumber())
                .append(getPolicyStatus(), policy.getPolicyStatus())
                .append(getPremium(), policy.getPremium())
                .append(getPolicyTargets(), policy.getPolicyTargets())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getNumber())
                .append(getPolicyStatus())
                .append(getPremium())
                .append(getPolicyTargets())
                .toHashCode();
    }
}
