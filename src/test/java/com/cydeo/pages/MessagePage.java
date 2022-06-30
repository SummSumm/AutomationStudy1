package com.cydeo.pages;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.AfterStep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MessagePage extends BasePage {

    public MessagePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "bx-b-uploadfile-blogPostForm")
    public WebElement uploadfilesButton;

    @FindBy(name = "bxu_files[]")
    public WebElement uploadfilesBox;

    @FindBy(xpath = "//tr[@class='wd-inline-file']")
    public WebElement uploadedFile;

}
