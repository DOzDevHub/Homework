package com.proof.it.task.model;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class PolicyTarget {

    @NotBlank(message = "Policy target name is mandatory")
    String name;

    @NotEmpty(message = "Policy target should have at least one item")
    List<@NotNull @Valid PolicyItem> policyItems;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PolicyItem> getPolicyItems() {
        return policyItems;
    }

    public void setPolicyItems(List<PolicyItem> policyItems) {
        this.policyItems = policyItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof PolicyTarget)) return false;

        PolicyTarget that = (PolicyTarget) o;

        return new EqualsBuilder()
                .append(getName(), that.getName())
                .append(getPolicyItems(), that.getPolicyItems())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getName())
                .append(getPolicyItems())
                .toHashCode();
    }
}
