package com.proof.it.task.service.calculators;

import java.util.Arrays;
import java.util.List;

import com.proof.it.task.model.Policy;
import com.proof.it.task.model.PolicyItem;
import com.proof.it.task.model.enumeration.RiskType;
import com.proof.it.task.service.risks.fire.FireRisk;
import com.proof.it.task.service.risks.water.WaterRisk;
import com.proof.it.task.utils.PolicyBuilder;
import com.proof.it.task.utils.PolicyItemBuilder;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


class PremiumCalculatorTest {

    private static PremiumCalculator premiumCalculator;
    Policy policy;

    @BeforeAll
    public static void initialize() {
        premiumCalculator = new PremiumCalculator(Arrays.asList( new FireRisk(), new WaterRisk()));
    }

    @BeforeEach
    public void setUp() {
        policy = PolicyBuilder.aPolicy().withDefaults().build();
    }


    @Test
    public void calculateFireRisk() {
        policy.getPolicyTargets().get(0).getPolicyItems().get(0).setSumInsured(1d);
        Policy policyResultFire = premiumCalculator.calculate(policy);
        assertEquals(policyResultFire.getPremium(), 0.013);

        policy.getPolicyTargets().get(0).getPolicyItems().get(0).setSumInsured(1000d);
        policyResultFire = premiumCalculator.calculate(policy);
        assertEquals(policyResultFire.getPremium(), 23);
    }

    @Test
    public void calculateWaterRisk() {
        policy.getPolicyTargets().get(0).getPolicyItems().get(0).setSumInsured(1d);
        policy.getPolicyTargets().get(0).getPolicyItems().get(0).setRiskType(RiskType.WATER);
        Policy policyResultFire = premiumCalculator.calculate(policy);
        assertEquals(policyResultFire.getPremium(), 0.1);

        policy.getPolicyTargets().get(0).getPolicyItems().get(0).setSumInsured(1000d);
        policyResultFire = premiumCalculator.calculate(policy);
        assertEquals(policyResultFire.getPremium(), 50);
    }

    @Test
    public void calculateAllRisks() {
        List<PolicyItem> policyItems = Arrays.asList(
                PolicyItemBuilder.aPolicyItem()
                        .riskType(RiskType.FIRE)
                        .sumInsured(100d).build(),
                PolicyItemBuilder.aPolicyItem()
                        .riskType(RiskType.WATER)
                        .sumInsured(8d).build()
        );
        policy.getPolicyTargets().get(0).setPolicyItems(policyItems);
        Policy policyResultAllRisks = premiumCalculator.calculate(policy);
        assertEquals(policyResultAllRisks.getPremium(), 2.10);

        policyItems = Arrays.asList(
                PolicyItemBuilder.aPolicyItem()
                        .riskType(RiskType.FIRE)
                        .sumInsured(500d).build(),
                PolicyItemBuilder.aPolicyItem()
                        .riskType(RiskType.WATER)
                        .sumInsured(100d).build()
        );
        policy.getPolicyTargets().get(0).setPolicyItems(policyItems);
        policyResultAllRisks = premiumCalculator.calculate(policy);
        assertEquals(policyResultAllRisks.getPremium(), 16.50);
    }
}