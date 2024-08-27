package com.yourcompany.example.domainobjects;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.yourcompany.example.pageobjects.ClientInfoPO;
import com.yourcompany.example.pageobjects.SummaryPO;
import com.yourcompany.example.pageobjects.VehicleInfoPO;
import ui.auto.core.support.DomainObjectModel;
import ui.auto.core.support.TestContext;
import ui.auto.core.pagecomponent.AliasedData;

@XStreamAlias("vehicle-insurance-domain-object")
public class VehicleInsuranceDO extends DomainObjectModel {
    private AliasedData appUrl;
    private VehicleInfoPO vehicleInfoPO;
    private ClientInfoPO clientInfoPO;
    private SummaryPO summaryPO;

    private VehicleInsuranceDO() {}

    public VehicleInsuranceDO(TestContext context) {
        this.context = context;
    }

    private void navigate() {
        getDriver().get(appUrl.getData());
    }

    public void createNewInsurancePolicy() {
        navigate();

        vehicleInfoPO.initPage(getContext());
        vehicleInfoPO.populate();
        vehicleInfoPO.next();

        clientInfoPO.initPage(getContext());
        clientInfoPO.populate();
        clientInfoPO.submit();
    }

    public void validateSummary() {
        summaryPO.initPage(getContext());
        summaryPO.validate();
    }
}
