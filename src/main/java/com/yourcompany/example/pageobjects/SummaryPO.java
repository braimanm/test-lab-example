package com.yourcompany.example.pageobjects;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ui.auto.core.components.WebComponent;
import ui.auto.core.data.DataTypes;
import ui.auto.core.pagecomponent.PageComponent;
import ui.auto.core.support.PageObjectModel;
import ui.auto.core.utils.WebHelper;

public class SummaryPO extends PageObjectModel {
    //Vehicle Info related fields
    @FindBy(xpath = "//strong[.='Type of Vehicle:']/../span")
    private WebComponent vehicleType;
    @FindBy(xpath = "//strong[.='Make:']/../span")
    private WebComponent make;
    @FindBy(xpath = "//strong[.='Engine Performance [kW]:']/../span")
    private WebComponent enginePerformance;
    @FindBy(xpath = "//strong[.='Date of Manufacture:']/../span")
    private WebComponent manufacturerDate;
    @FindBy(xpath = "//strong[.='Number of Seats:']/../span")
    private WebComponent seats;
    @FindBy(xpath = "//strong[.='Fuel Type:']/../span")
    private WebComponent fuelType;
    @FindBy(xpath = "//strong[.='List Price [$]:']/../span")
    private WebComponent listPrice;
    @FindBy(xpath = "//strong[.='License Plate Number:']/../span")
    private WebComponent licensePlate;
    @FindBy(xpath = "//strong[.='Annual Mileage [mi]:']/../span")
    private WebComponent annualMileage;
    //Truck related fields
    @FindBy(xpath = "//strong[.=':']/../span")
    private WebComponent payload;
    @FindBy(xpath = "//strong[.=':']/../span")
    private WebComponent totalWeight;
    //Motorcycle related fields
    @FindBy(xpath = "//strong[.=':']/../span")
    private WebComponent model;
    @FindBy(xpath = "//strong[.=':']/../span")
    private WebComponent cylinderCapacity;

    //Client Info related fields
    @FindBy(xpath = "//strong[.='First Name:']/../span")
    private WebComponent firstName;
    @FindBy(xpath = "//strong[.='Last Name:']/../span")
    private WebComponent lastName;
    @FindBy(xpath = "//strong[.='Date of Birth:']/../span")
    private WebComponent dateOfBirth;
    @FindBy(xpath = "//strong[.='Gender:']/../span")
    private WebComponent gender;
    @FindBy(xpath = "//strong[.='Street Address:']/../span")
    private WebComponent streetAddress;
    @FindBy(xpath = "//strong[.='Country:']/../span")
    private WebComponent country;
    @FindBy(xpath = "//strong[.='Zip Code:']/../span")
    private WebComponent zipCode;
    @FindBy(xpath = "//strong[.='City:']/../span")
    private WebComponent city;
    @FindBy(xpath = "//strong[.='Occupation:']/../span")
    private WebComponent occupation;
    @FindBy(xpath = "//strong[.='Hobbies:']/../span")
    private WebComponent hobbies;
    @FindBy(xpath = "//strong[.='Website:']/../span")
    private WebComponent website;
    @FindBy(xpath = "//strong[.='Picture:']/../span")
    private WebComponent picture;

    @Step("Validate Summary Page")
    public void validate() {
        enumerateFields((pageComponent, field) -> {
            if (pageComponent.getData() != null) {
                reportForValidation(field.getName(), pageComponent.getData());
                pageComponent.validateData(DataTypes.Data);
            } else {
                validateFieldIsNotDisplayed(field.getName(), pageComponent);
            }
        });
    }

    @Step("Validate that the \"{0}\" field has the value \"{1}\"")
    private void reportForValidation(String name, String value) {
    }

    @Step("Validate that the \"{0}\" field is hidden")
    private void validateFieldIsNotDisplayed(String fieldName, PageComponent component) {
        Assertions.assertThat(WebHelper.isDisplayed(component))
                .withFailMessage("Field " + fieldName + " is displayed but should be hidden!").isFalse();
    }

}
