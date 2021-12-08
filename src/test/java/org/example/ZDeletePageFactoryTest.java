package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ZDeletePageFactoryTest {
    @Test
    void delete() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("incognito");
        driver.get("https://novat.nsk.ru");
        driver.manage().window().maximize();
        RegistrationPageFactory registrationPage = new RegistrationPageFactory(driver);
        registrationPage.registration("masha2410@mail.ru", "zarplata");
        new WebDriverWait(driver, 10).until(ExpectedConditions.urlContains("/cabinet/profile/?backurl=%2F"));
        ZDeletePageFactory deletePageFactory = new ZDeletePageFactory(driver);
        deletePageFactory.deleteTicket();
        assertNotEquals("Ваша корзина (1)", driver.findElement(By.xpath("/html/body/div[2]/div/div/aside/div[7]/a[4]")).getText());

        driver.quit();
    }
}
