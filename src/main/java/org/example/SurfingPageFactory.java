package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SurfingPageFactory {

    private WebDriver driver;

    @FindBy(id = "cookie-accept")
    private WebElement cookie;

    @FindBy(xpath = "//a[contains(@href, '/theatre/')]")
    private WebElement theatre;

    @FindBy(xpath = "//a[contains(@href, '/afisha/')]")
    private WebElement afisha;

    @FindBy(xpath = "//a[contains(@href, '/news/')]")
    private WebElement news;

    public SurfingPageFactory(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void surfing(){
        this.cookie.click();
        this.theatre.click();
        this.afisha.click();
        this.news.click();
    }
}
