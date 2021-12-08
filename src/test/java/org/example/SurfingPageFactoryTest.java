package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SurfingPageFactoryTest {

    @Test
    void surfing() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("incognito");
        driver.get("https://novat.nsk.ru");
        SurfingPageFactory surfingPage = new SurfingPageFactory(driver);
        surfingPage.surfing();
        assertEquals("https://novat.nsk.ru/news/",  driver.getCurrentUrl());
        driver.quit();
    }


}
