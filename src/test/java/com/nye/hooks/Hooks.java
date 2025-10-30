package com.nye.hooks;

import com.nye.factory.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;

public class Hooks {

    @Autowired
    private WebDriverFactory factory;

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) factory.getInstance()).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Screenshot on failure", "image/png",
                    new java.io.ByteArrayInputStream(screenshot), ".png");
        }
    }
}