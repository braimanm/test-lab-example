package com.yourcompany.example.pageobjects;

import com.braimanm.datainstiller.data.Data;
import com.braimanm.ui.auto.components.SelectComponent;
import com.braimanm.ui.auto.components.WebComponent;
import com.braimanm.ui.auto.utils.WebDriverUtils;
import com.braimanm.uitaf.support.PageObjectModel;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.yourcompany.example.components.DateComponent;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@XStreamAlias("vehicle-info-page-object")
public class VehicleInfoPO extends PageObjectModel {
    @FindBy(css = "select#vehicleType")
    private SelectComponent vehicleType;
    @FindBy(css = "select#make")
    private SelectComponent make;
    @FindBy(css = "input#enginePerformance")
    private WebComponent enginePerformance;
    @FindBy(css = "input#dateOfManufacture")
    private DateComponent manufacturerDate;
    @FindBy(css = "input#numberOfSeats")
    private WebComponent seats;
    @FindBy(css = "select#fuelType")
    private SelectComponent fuelType;
    @FindBy(css = "input#listPrice")
    private WebComponent listPrice;
    @FindBy(css = "input#licensePlateNumber")
    private WebComponent licensePlate;
    @FindBy(css = "input#annualMileage")
    private WebComponent annualMileage;
    //Truck related fields
    @FindBy(css = "input#payload")
    private WebComponent payload;
    @FindBy(css = "input#totalWeight")
    private WebComponent totalWeight;
    //Motorcycle related fields
    @FindBy(css = "input#model")
    private WebComponent model;
    @FindBy(css = "input#cylinderCapacity")
    private WebComponent cylinderCapacity;
    @Data(skip = true)
    private WebComponent nextButton;

    @Step("Populate Vehicle Info form with provided data")
    public void populate() {
        autoFillPage();
    }

    @Step("Click Next Button")
    public void next() {
        nextButton.click();
        WebDriverUtils.getWebDriverWait().until(ExpectedConditions.invisibilityOfElementLocated(nextButton.getLocator()));
    }

    //Generate report entry for each populated component
    @Override
    @Step("Populate field \"{0}\" with value \"{1}\"")
    protected void reportForAutoFill(String fieldName, String value) {
        super.reportForAutoFill(fieldName, value);
    }

}
