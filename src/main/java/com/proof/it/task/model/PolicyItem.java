package com.proof.it.task.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.proof.it.task.model.enumeration.RiskType;

public class PolicyItem {

    @NotBlank(message = "Policy item name is mandatory")
    String name;

    @NotNull(message = "Policy item insured sum should be provided")
    @Positive
    Double sumInsured;

    @NotNull(message = "Risk type is mandatory")
    RiskType riskType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSumInsured() {
        return sumInsured;
    }

    public void setSumInsured(Double sumInsured) {
        this.sumInsured = sumInsured;
    }

    public RiskType getRiskType() {
        return riskType;
    }

    public void setRiskType(RiskType riskType) {
        this.riskType = riskType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof PolicyItem)) return false;

        PolicyItem that = (PolicyItem) o;

        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(getName(), that.getName())
                .append(getSumInsured(), that.getSumInsured())
                .append(getRiskType(), that.getRiskType())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37)
                .append(getName())
                .append(getSumInsured())
                .append(getRiskType())
                .toHashCode();
    }
}
