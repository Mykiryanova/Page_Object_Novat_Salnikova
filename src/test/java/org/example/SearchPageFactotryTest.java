package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SearchPageFactotryTest {
    @Test
    void search(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("incognito");
        driver.get("https://novat.nsk.ru");
        driver.manage().window().maximize();
        RegistrationPageFactory registrationPage = new RegistrationPageFactory(driver);
        registrationPage.registration("masha2410@mail.ru", "zarplata");
        SearchPage searchPage = new SearchPage(driver);
        searchPage.searching("Дон Кихот");
        assertNotEquals ("Найдено: 0",  driver.findElement(By.xpath("//*[@class=\"search-result\"]")).getText());

    }
}
