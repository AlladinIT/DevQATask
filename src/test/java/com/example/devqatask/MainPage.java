package com.example.devqatask;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    @FindBy(css = "body > header > div > nav > a:nth-child(5)")
    public WebElement internshipTab;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
