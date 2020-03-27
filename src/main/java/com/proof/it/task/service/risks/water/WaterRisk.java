package com.proof.it.task.service.risks.water;

import com.proof.it.task.model.enumeration.RiskType;
import com.proof.it.task.service.risks.RiskInterface;
import org.springframework.stereotype.Component;

import static com.proof.it.task.model.Constants.COEFFICIENT_POINT_10;

@Component
public class WaterRisk implements RiskInterface {

    @Override
    public RiskType getType() {
        return RiskType.WATER;
    }

    @Override
    public Double calculateRiskCoefficient(Double sumInsured) {
        if (sumInsured < COEFFICIENT_POINT_10) {
            return 0.1;
        } else {
            return 0.05;
        }
    }
}
