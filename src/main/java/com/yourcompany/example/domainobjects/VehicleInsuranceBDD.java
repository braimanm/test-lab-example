package com.yourcompany.example.domainobjects;

import com.braimanm.ui.auto.context.WebDriverContext;
import com.braimanm.ui.auto.pagecomponent.AliasedData;
import com.braimanm.uitaf.support.DomainObjectModel;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.yourcompany.example.pageobjects.ClientInfoPO;
import com.yourcompany.example.pageobjects.SummaryPO;
import com.yourcompany.example.pageobjects.VehicleInfoPO;
import io.qameta.allure.Param;
import io.qameta.allure.Step;
import static io.qameta.allure.model.Parameter.Mode.*;

@XStreamAlias("vehicle-insurance-domain-object")
public class VehicleInsuranceBDD extends DomainObjectModel {
    private AliasedData appUrl;
    private VehicleInfoPO vehicleInfoPO;
    private ClientInfoPO clientInfoPO;
    private SummaryPO summaryPO;

    private VehicleInsuranceBDD() {}

    public VehicleInsuranceBDD(WebDriverContext context) {
        this.context = context;
    }

    @Step("{0} the user is on Vehicle Insurance page")
    public void is_on_vehicle_insurance_page(@Param(mode = HIDDEN) String gwt) {
        getDriver().get(appUrl.getData());
    }

    @Step("{0} the user populates the vehicle insurance information page with provided data and clicks next button")
    public void populates_vehicle_insurance_information(@Param(mode = HIDDEN) String gwt) {
        vehicleInfoPO.initPage(getContext());
        vehicleInfoPO.populate();
        vehicleInfoPO.next();
    }

    @Step("{0} the user populates the client information with provided data and clicks submit button")
    public void populates_client_information_page(@Param(mode = HIDDEN) String gwt) {
        clientInfoPO.initPage(getContext());
        clientInfoPO.populate();
        clientInfoPO.submit();
    }

    @Step("{0} user validates that the summary page contains the expected fields and values")
    public void validates_summary_page_contains_expected_fields_and_values(@Param(mode = HIDDEN) String gwt) {
        hideStepParams();
        summaryPO.initPage(getContext());
        summaryPO.validate();
    }


}
