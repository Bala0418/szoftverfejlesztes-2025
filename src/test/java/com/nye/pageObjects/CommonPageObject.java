package com.nye.pageObjects;

import com.nye.factory.WebDriverFactory;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

@Component
public class CommonPageObject {
    public CommonPageObject(final WebDriverFactory factory) {
        PageFactory.initElements(factory.getInstance(), this);
    }
}
