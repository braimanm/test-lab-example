package com.yourcompany.example.components;

import com.braimanm.ui.auto.data.DataTypes;
import com.braimanm.ui.auto.pagecomponent.PageComponent;
import com.braimanm.ui.auto.utils.WebDriverUtils;
import org.assertj.core.api.Assertions;

public class DateComponent extends PageComponent {
    @Override
    protected void init() {
    }

    @Override
    public void setValue() {
        WebDriverUtils.getJSExecutor()
                .executeScript("arguments[0].value = arguments[1];", coreElement, getData());
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
