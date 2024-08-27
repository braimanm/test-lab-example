package com.yourcompany.example.pageobjects;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.yourcompany.example.components.DateComponent;
import com.yourcompany.example.components.FileUploadComponent;
import datainstiller.data.Data;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.allure.annotations.Step;
import ui.auto.core.components.SelectComponent;
import ui.auto.core.components.WebComponent;
import ui.auto.core.support.PageObjectModel;
import ui.auto.core.utils.WebHelper;


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
        WebHelper.getWebDriverWait().until(ExpectedConditions.invisibilityOfElementLocated(submitButton.getLocator()));
    }

    //Generate report entry for each populated component
    @Step("Populate field \"{0}\" with value \"{1}\"")
    @Override
    protected void reportForAutoFill(String fieldName, String value) {}

}
