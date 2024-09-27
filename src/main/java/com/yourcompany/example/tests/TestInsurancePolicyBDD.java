package com.yourcompany.example.tests;

import com.braimanm.uitaf.testng.TestNGBase;
import com.yourcompany.example.domainobjects.VehicleInsuranceBDD;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static com.braimanm.uitaf.utils.GivenWhenThen.*;

public class TestInsurancePolicyBDD extends TestNGBase {

    @Feature("Insurance Policy")
    @Story("BDD: User creates new insurance policy quote")
    @Parameters("data-set")
    @Description("Given the user is on Vehicle Insurance page\n" +
            "When the user populates the vehicle insurance information page with provided data and clicks next button\n" +
            "And the user populates the client information with provided data and clicks submit button\n" +
            "Then user validates that the summary page contains the expected fields and values")
    @Test
    public void testCreatePolicyQuoteBDD(@Optional("data/random-data.xml") String dataSet){
        VehicleInsuranceBDD user = new VehicleInsuranceBDD(getContext()).fromResource(dataSet);

        Given(user::is_on_vehicle_insurance_page);
        When(user::populates_vehicle_insurance_information);
        And(user::populates_client_information_page);
        Then(user::validates_summary_page_contains_expected_fields_and_values);
    }

}
