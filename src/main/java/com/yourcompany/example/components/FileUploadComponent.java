package com.yourcompany.example.components;

import com.braimanm.ui.auto.data.DataTypes;
import com.braimanm.ui.auto.pagecomponent.PageComponent;
import com.braimanm.ui.auto.utils.WebDriverUtils;
import org.apache.commons.io.FileUtils;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class FileUploadComponent extends PageComponent {
    private Path filePath;

    @Override
    protected void init() {
        filePath = FileSystems.getDefault().getPath(getData());
    }

    @Override
    public void setValue() {
        InputStream is  = this.getClass().getClassLoader().getResourceAsStream(getData());
        if (is == null) throw new RuntimeException("Resource file '" + getData() + "' was not found");
        File file = filePath.getFileName().toFile();
        try {
            FileUtils.copyInputStreamToFile(is, file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        coreElement.sendKeys(file.getAbsolutePath());
    }

    @Override
    public String getValue() {
        JavascriptExecutor js = WebDriverUtils.getJSExecutor();
        String fileName = (String) js.executeScript("return arguments[0].files[0].name;", coreElement);
        return filePath.getParent() + "/" + fileName;
    }

    @Override
    public void validateData(DataTypes dataTypes) {
        Assertions.assertThat(getValue()).isEqualTo(getData(dataTypes));
    }

}
