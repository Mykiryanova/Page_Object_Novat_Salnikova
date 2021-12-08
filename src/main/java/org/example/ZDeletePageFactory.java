package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZDeletePageFactory {
    private WebDriver driver;

    @FindBy(id = "cookie-accept")
    private WebElement cookie;
    // Корзина
    @FindBy(xpath = "/html/body/div[2]/div/div/aside/div[7]/a[4]")
    private WebElement bag;

    @FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/form/div[2]/div[2]/div[3]/div/a")
    private WebElement delete;

    public ZDeletePageFactory(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void deleteTicket(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", bag);
        this.bag.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.urlContains("/cart/"));
        this.delete.click();

    }
}
