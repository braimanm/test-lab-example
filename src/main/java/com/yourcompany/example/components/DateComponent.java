package com.yourcompany.example.components;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.Keys;
import ui.auto.core.data.DataTypes;
import ui.auto.core.pagecomponent.PageComponent;

public class DateComponent extends PageComponent {
    @Override
    protected void init() {
    }

    @Override
    public void setValue() {
        String[] values = getData().split("-");
        coreElement.sendKeys(values[0] + Keys.ARROW_RIGHT + values[1] + values[2]);
    }

    @Override
    public String getValue() {
        return coreElement.getAttribute("value");
    }

    @Override
    public void validateData(DataTypes dataTypes) {
        Assertions.assertThat(getValue()).isEqualTo(getData(dataTypes));
    }

}
