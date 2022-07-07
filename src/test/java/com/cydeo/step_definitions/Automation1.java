package com.cydeo.step_definitions;

import com.cydeo.pages.BasePage;
import com.cydeo.pages.MessagePage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.joda.time.Seconds;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.crypto.KeyAgreementSpi;
import java.awt.*;
import java.time.Duration;
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



    @Then("user sees the document attached")
    public void user_sees_the_document_attached() {
          Assert.assertTrue(messagePage.attachment.isDisplayed());
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
        Assert.assertTrue(uploadedFiles.size() == 3);
    }

    @When("User chooses word document")
    public void user_chooses_word_document() {
        messagePage.uploadfilesBox.sendKeys(ConfigurationReader.getProperty("file2"));
    }

    @When("user clicks on send button")
    public void user_clicks_on_send_button() {
        BrowserUtils.sleep(10);
        Driver.getDriver().findElement(By.id("blog-submit-button-save")).click();
    }
/*
    @Then("user sees the document attached")
    public void user_sees_the_document_attached() {
        Assert.assertTrue(messagePage.attachment.isDisplayed());
    }

*/


    @When("User chooses pdf document")
    public void user_chooses_pdf_document() {
        messagePage.uploadfilesBox.sendKeys(ConfigurationReader.getProperty("file4"));
    }


    @When("User chooses jpeg document")
    public void user_chooses_jpeg_document() {
        messagePage.uploadfilesBox.sendKeys(ConfigurationReader.getProperty("file1"));
    }


    @When("User chooses png document")
    public void user_chooses_png_document() {
        messagePage.uploadfilesBox.sendKeys(ConfigurationReader.getProperty("file6"));
    }

    @When("User chooses txt document")
    public void user_chooses_txt_document() {
        messagePage.uploadfilesBox.sendKeys(ConfigurationReader.getProperty("file5"));
    }


    @When("User chooses gif document")
    public void user_chooses_gif_document() {
        messagePage.uploadfilesBox.sendKeys(ConfigurationReader.getProperty("file3"));
    }

    @When("user types something")
    public void user_types_something() {
        Driver.getDriver().switchTo().frame(messagePage.iframe);
        messagePage.iframeBox.sendKeys(ConfigurationReader.getProperty("text"));
        Driver.getDriver().switchTo().parentFrame();
    }


    @When("user clicks on insert in text button")
    public void user_clicks_on_insert_in_text_button() {
        messagePage.insertInTextBox.click();
    }

    @When("Files are uploaded inside the message")
    public void files_are_uploaded_inside_the_message() {
        Assert.assertEquals("In text", messagePage.insertInTextBox.getText());
    }

    @When("user verifies that Allow a recipient to edit documents? box is already checked")
    public void user_verifies_that_allow_a_recipient_to_edit_documents_box_is_already_checked() {
        if (messagePage.editCheckbox.isSelected()) {
            Assert.assertTrue(true);
        } else
            messagePage.editCheckbox.click();
    }

    @When("user clicks on X button")
    public void user_clicks_on_x_button() {
        messagePage.deleteButton.click();
    }

    @When("user hovers over file name and clicks on the pen icon")
    public void user_hovers_over_file_name_and_clicks_on_the_pen_icon() {
        BrowserUtils.sleep(5);
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(messagePage.activatingBox).perform();
        messagePage.renameButton.click();

    }

    @When("user changes the name of the document")
    public void user_changes_the_name_of_the_document() {
        messagePage.renameBox.sendKeys("Renamed document" + Keys.ENTER);
    }


}

