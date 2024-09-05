package com.yourcompany.example.domainobjects;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.yourcompany.example.pageobjects.ClientInfoPO;
import com.yourcompany.example.pageobjects.SummaryPO;
import com.yourcompany.example.pageobjects.VehicleInfoPO;
import ru.yandex.qatools.allure.annotations.Step;
import ui.auto.core.pagecomponent.AliasedData;
import ui.auto.core.support.DomainObjectModel;
import ui.auto.core.support.TestContext;

@XStreamAlias("vehicle-insurance-domain-object")
public class VehicleInsuranceBDD extends DomainObjectModel {
    private AliasedData appUrl;
    private VehicleInfoPO vehicleInfoPO;
    private ClientInfoPO clientInfoPO;
    private SummaryPO summaryPO;

    private VehicleInsuranceBDD() {}

    public VehicleInsuranceBDD(TestContext context) {
        this.context = context;
    }

    @Step("{0} the user is on Vehicle Insurance page")
    public void is_on_vehicle_insurance_page(String gwt) {
        getDriver().get(appUrl.getData());
    }

    @Step("{0} the user populates the vehicle insurance information page with provided data and clicks next button")
    public void populates_vehicle_insurance_information(String gwt) {
        vehicleInfoPO.initPage(getContext());
        vehicleInfoPO.populate();
        vehicleInfoPO.next();
    }

    @Step("{0} the user populates the client information with provided data and clicks submit button")
    public void populates_client_information_page(String gwt) {
        clientInfoPO.initPage(getContext());
        clientInfoPO.populate();
        clientInfoPO.submit();
    }

    @Step("{0} user validates that the summary page contains the expected fields and values")
    public void validates_summary_page_contains_expected_fields_and_values(String gwt) {
        summaryPO.initPage(getContext());
        summaryPO.validate();
    }


}
