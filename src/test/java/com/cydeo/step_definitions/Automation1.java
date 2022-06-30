package com.cydeo.step_definitions;

import com.cydeo.pages.BasePage;
import com.cydeo.pages.MessagePage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Automation1 {

    MessagePage messagePage = new MessagePage();
    BasePage basePage = new BasePage();

    @Given("user is on homepage")
    public void user_is_on_homepage() {
        messagePage.login();
    }

    @Given("user clicks on Message")
    public void user_clicks_on_message() {
        messagePage.messageBoxClick();
    }

    @When("User clicks on the Upload Files and Images box")
    public void user_clicks_on_the_upload_files_and_images_box() {
        messagePage.uploadfilesButton.click();

    }

    @When("User chooses three files from their computer")
    public void user_chooses_three_files_from_their_computer() {
        messagePage.uploadfilesBox.sendKeys(ConfigurationReader.getProperty("file1"));
        messagePage.uploadfilesBox.sendKeys(ConfigurationReader.getProperty("file2"));
        messagePage.uploadfilesBox.sendKeys(ConfigurationReader.getProperty("file3"));
    }


    @Then("Files are uploaded as attachments for the message")
    public void files_are_uploaded_as_attachments_for_the_message() {
        BrowserUtils.sleep(5);
        List<WebElement> uploadedFiles = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
             uploadedFiles.add(messagePage.uploadedFile);

        }
        Assert.assertTrue(uploadedFiles.size()==3);
        Driver.getDriver().close();
    }


}
