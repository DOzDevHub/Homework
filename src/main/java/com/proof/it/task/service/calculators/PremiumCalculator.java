package com.proof.it.task.service.calculators;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

import com.proof.it.task.model.Policy;
import com.proof.it.task.model.PolicyItem;
import com.proof.it.task.model.enumeration.RiskType;
import com.proof.it.task.service.risks.RiskInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PremiumCalculator {

    private static final Logger LOGGER = LoggerFactory.getLogger(PremiumCalculator.class);

    private EnumMap<RiskType, RiskInterface> riskTypeInterfaces;

    public PremiumCalculator(List<RiskInterface> riskInterfaces) {
        this.riskTypeInterfaces = new EnumMap<>(RiskType.class);
        if (riskInterfaces != null) {
            riskInterfaces.forEach(p -> this.riskTypeInterfaces.put(p.getType(), p));
        } else {
            LOGGER.error("No risks were added to the service!");
        }
    }

    public Policy calculate(Policy policy) {

        List<PolicyItem> policyItems = new ArrayList<>();
        policy.getPolicyTargets().forEach(pT -> policyItems.addAll(pT.getPolicyItems()));

        Double sum = riskTypeInterfaces.keySet().stream()
                .mapToDouble(riskType -> calculateRisk(policyItems, riskType))
                .sum();

        policy.setPremium(sum);

        return policy;
    }

    private Double calculateRisk(List<PolicyItem> policyItems, RiskType riskType) {

        Double riskSum = policyItems.stream()
                .filter(pI -> pI.getRiskType().equals(riskType))
                .map(PolicyItem::getSumInsured)
                .mapToDouble(Double::doubleValue).sum();

        Double coefficient = getRiskInterface(riskType).calculateRiskCoefficient(riskSum);

        return riskSum * coefficient;
    }


    private RiskInterface getRiskInterface(RiskType riskType) {
        return riskTypeInterfaces.get(riskType);
    }
}
