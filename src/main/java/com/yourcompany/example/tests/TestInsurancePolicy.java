package com.yourcompany.example.tests;

import com.braimanm.uitaf.testng.TestNGBase;
import com.yourcompany.example.domainobjects.VehicleInsuranceDO;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestInsurancePolicy extends TestNGBase {

    @Feature("Insurance Policy")
    @Story("User creates new insurance policy quote")
    @Parameters("data-set")
    @Test
    public void testCreatePolicyQuote(@Optional("data/random-data.xml") String dataSet) {
        VehicleInsuranceDO vehicleInsuranceDO = new VehicleInsuranceDO(getContext()).fromResource(dataSet);
        vehicleInsuranceDO.createNewInsurancePolicy();
        vehicleInsuranceDO.validateSummary();
    }

}
