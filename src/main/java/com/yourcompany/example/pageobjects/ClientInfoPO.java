package com.yourcompany.example.pageobjects;

import com.braimanm.datainstiller.data.Data;
import com.braimanm.ui.auto.components.SelectComponent;
import com.braimanm.ui.auto.components.WebComponent;
import com.braimanm.ui.auto.utils.WebDriverUtils;
import com.braimanm.uitaf.support.PageObjectModel;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.yourcompany.example.components.DateComponent;
import com.yourcompany.example.components.FileUploadComponent;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;

@XStreamAlias("client-info-page-object")
public class ClientInfoPO extends PageObjectModel {
    private WebComponent firstName;
    private WebComponent lastName;
    private DateComponent dateOfBirth;
    private SelectComponent gender;
    private WebComponent streetAddress;
    private WebComponent country;
    private WebComponent zipCode;
    private WebComponent city;
    private WebComponent occupation;
    private WebComponent hobbies;
    private WebComponent website;
    private FileUploadComponent picture;
    @Data(skip = true)
    private WebComponent submitButton;

    @Step("Populate Client Info form with provided data")
    public void populate() {
        autoFillPage();
    }

    @Step("Click Submit Button")
    public void submit() {
        submitButton.click();
        WebDriverUtils.getWebDriverWait().until(ExpectedConditions.invisibilityOfElementLocated(submitButton.getLocator()));
    }

    //Generate report entry for each populated component
    @Override
    @Step("Populate field \"{0}\" with value \"{1}\"")
    protected void reportForAutoFill(String fieldName, String value) {
        super.reportForAutoFill(fieldName, value);
    }

}
