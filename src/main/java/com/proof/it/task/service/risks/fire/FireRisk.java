package com.proof.it.task.service.risks.fire;

import com.proof.it.task.model.enumeration.RiskType;
import com.proof.it.task.service.risks.RiskInterface;
import org.springframework.stereotype.Component;

import static com.proof.it.task.model.Constants.COEFFICIENT_POINT_100;

@Component
public class FireRisk implements RiskInterface {

    @Override
    public RiskType getType() {
        return RiskType.FIRE;
    }

    @Override
    public Double calculateRiskCoefficient(Double sumInsured) {
        if (sumInsured <= COEFFICIENT_POINT_100) {
            return 0.013;
        } else {
            return 0.023;
        }
    }
}
