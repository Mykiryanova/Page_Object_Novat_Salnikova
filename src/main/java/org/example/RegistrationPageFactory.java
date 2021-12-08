package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPageFactory {
    private WebDriver driver;

    @FindBy(id = "cookie-accept")
    private WebElement cookie;
// Локаторы для осуществления аутентификации
    @FindBy(xpath = "//a[contains(text(),'Личный кабинет')]")
    private WebElement menuLK;

    @FindBy(xpath = "//*[@id=\"auth-form\"]/div[1]/input")
    private WebElement login;

    @FindBy(xpath = "//*[@id=\"auth-form\"]/div[2]/input")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"forgot-form\"]/div/input[2]")
    private WebElement submit;

    // Локаторы для перехода в перcональные данные, чтобы проверить, что мы зашли на нужнный аккаунт
    @FindBy(xpath = "//a[contains(@href, '/cabinet/profile/?backurl=%2F')]")
    private WebElement cabinet;

    @FindBy(xpath = "//a[contains(text(),'Персональные данные')]")
    private WebElement personalInfo;

    public RegistrationPageFactory(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void registration(String login, String password) {
        this.cookie.click();
        this.menuLK.click();
        this.login.click();
        this.login.sendKeys(login);
        this.password.click();
        this.password.sendKeys(password);
        this.submit.click();
        this.cabinet.click();

    }

    public void proverka(){

        this.personalInfo.click();

    }
}
