package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZBuyPageFactory   {
    private WebDriver driver;

    @FindBy(id = "cookie-accept")
    private WebElement cookie;
    // Афиша
    @FindBy(xpath = "//a[contains(@href, '/afisha/')]")
    private WebElement afisha;

    @FindBy(xpath = "//a[contains(@href, '/buy_now/tickets/2451738/')]")
    private WebElement perfomance;

    @FindBy(name = "Ряд 11 / Место 1")
    private WebElement place;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div/div/div[2]/div[2]/div/form[2]/div/input[4]")
    private WebElement button;

    public ZBuyPageFactory(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void buyTicket() {
        this.afisha.click();
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",perfomance);
        this.perfomance.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.urlContains("/buy_now/tickets/2451738/"));
        this.place.click();
        this.button.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.urlContains("/cart/"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("/html/body/div[2]/div/div/aside/div[7]/a[4]")));


    }

}
