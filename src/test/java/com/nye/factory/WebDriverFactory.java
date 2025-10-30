package com.nye.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class WebDriverFactory {
    public static WebDriver webDriver;

    public WebDriver getInstance() {
        if (webDriver == null) {
            webDriver = setUpChromeDriver();
        }
        return webDriver;
    }

    public WebDriver setUpChromeDriver() {
        WebDriverManager.chromedriver().setup();
        var options = new ChromeOptions().addArguments("--remote-allow-origins=*");
        return new ChromeDriver(options);
    }

    public void closeWebDriver() {
        if (Objects.nonNull(webDriver)) {
            webDriver.close();
            webDriver.quit();
            webDriver = null;
        }
    }
}
