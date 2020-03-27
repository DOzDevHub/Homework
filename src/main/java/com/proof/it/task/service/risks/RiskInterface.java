package com.proof.it.task.service.risks;

import com.proof.it.task.model.enumeration.RiskType;

public interface RiskInterface {

    RiskType getType();

    Double calculateRiskCoefficient(Double sumInsured);
}
