package org.example;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@class=\"additions__link search-icon\"]")
    private WebElement icon;

    @FindBy(name = "q")
    private WebElement search;

    @FindBy(className = "input-search-icon")
    private WebElement button;

    public SearchPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searching(String word) {

        this.icon.click();
        this.search.click();
        this.search.sendKeys(word);
        this.button.click();
    }
}
