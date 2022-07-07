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


    @FindBy(xpath = "(//div[starts-with(@class, 'feed-com-files-title')])[1]")
    public WebElement attachment;

    @FindBy (xpath = "//span[@class='user-name']")
    public WebElement logoutDD;

    @FindBy (xpath = "//a[@href='/auth/?logout=yes&backurl=%2Fstream%2F']")
    public WebElement logoutButton;

    @FindBy (className = "bx-editor-iframe")
    public WebElement iframe;

    @FindBy (xpath = "//body[@contenteditable='true']")
    public WebElement iframeBox;

    @FindBy(xpath = "//span[@class='insert-btn-text']")
    public WebElement insertInTextBox;

    @FindBy(id = "diskuf-edit-rigths-doc")
    public WebElement editCheckbox;

    @FindBy (xpath = "//span[@class='del-but']")
    public WebElement deleteButton;

    @FindBy(xpath = "//span[@class='files-name-edit-btn']")
    public WebElement renameButton;

    @FindBy (xpath = "//input[@class='files-name-edit-inp']")
    public WebElement renameBox;

    @FindBy (xpath = "//td[@class= 'files-name']")
    public WebElement activatingBox;




}
