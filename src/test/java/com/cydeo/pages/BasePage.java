package com.cydeo.pages;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//input[@type='text']")
   public  WebElement userNameBox;

    @FindBy (xpath = "//input[@type='password']")
    public WebElement passwordBox;

    @FindBy (className = "login-btn")
    public WebElement loginButton;


    public void login() {
       Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Faker faker = new Faker();
        userNameBox.sendKeys("hr" + faker.numerify("##") + "@cybertekschool.com");
        passwordBox.sendKeys("UserUser");
        loginButton.click();
    }

    @FindBy (id = "feed-add-post-form-tab-message")
    public WebElement messageBox;

    public void messageBoxClick () {
        messageBox.click();
    }





}
