package com.yourcompany.example.tests;

import com.yourcompany.example.domainobjects.VehicleInsuranceBDD;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ui.auto.core.testng.TestNGBase;
import static ui.auto.core.utils.GivenWhenThen.*;


public class TestInsurancePolicyBDD extends TestNGBase {

    @Features("Insurance Policy")
    @Stories("BDD: User creates new insurance policy quote")
    @Parameters("data-set")
    @Test
    public void testCreatePolicy(@Optional("data/random-data.xml") String dataSet){
        VehicleInsuranceBDD user = new VehicleInsuranceBDD(getContext()).fromResource(dataSet);

        Given(user::is_on_vehicle_insurance_page);
        When(user::populates_vehicle_insurance_information);
        And(user::populates_client_information_page);
        Then(user::validates_summary_page_contains_expected_fields_and_values);
    }

}
