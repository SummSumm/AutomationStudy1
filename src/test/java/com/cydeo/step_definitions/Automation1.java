package com.cydeo.step_definitions;

import com.cydeo.pages.BasePage;
import com.cydeo.pages.MessagePage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
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

    @When("user clicks on send button")
    public void user_clicks_on_send_button() {
        BrowserUtils.sleep(5);
        Driver.getDriver().findElement(By.id("blog-submit-button-save")).click();
    }

    @Then("user sees the document attached")
    public void user_sees_the_document_attached() {
        BrowserUtils.sleep(10);
        Assert.assertTrue(messagePage.attachment.isDisplayed());
    }

    @When("User chooses word document")
    public void user_chooses_word_document() {
        messagePage.uploadfilesBox.sendKeys(ConfigurationReader.getProperty("file2"));
    }

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

    @Then("user sees the inserted document attached")
    public void userSeesTheInsertedDocumentAttached() {
        BrowserUtils.sleep(10);
        Assert.assertTrue((messagePage.Insertedattachment.isDisplayed()) || (messagePage.Insertedattachment2.isDisplayed()));
    }

    @When("user verifies that Allow a recipient to edit documents? box is already checked")
    public void user_verifies_that_allow_a_recipient_to_edit_documents_box_is_already_checked() {
        if (messagePage.editCheckbox.isSelected()) {
            Assert.assertTrue(true);
        } else
            messagePage.editCheckbox.click();
    }

    @Then("user can click on the edit button")
    public void userCanClickOnTheEditButton() {
        BrowserUtils.sleep(10);
        Assert.assertTrue(messagePage.editButton.isEnabled());
    }

    @When("user clicks on X button")
    public void user_clicks_on_x_button() {
        messagePage.deleteButton.click();
    }

    @Then("user does not see the document attached")
    public void userDoesNotSeeTheDocumentAttached() {
        BrowserUtils.sleep(5);
        Assert.assertFalse(messagePage.attachment.isDisplayed());
    }

    @When("user hovers over file name and clicks on the pen icon")
    public void user_hovers_over_file_name_and_clicks_on_the_pen_icon() {
        BrowserUtils.sleep(5);
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(messagePage.activatingBox).perform();
        messagePage.renameButton.click();
    }

    @And("user changes the {string} of the document")
    public void userChangesTheOfTheDocument(String string) {
        messagePage.renameBox.sendKeys(string + Keys.ENTER);
    }

    @Then("user sees the new document {string}")
    public void userSeesTheNewDocument(String string) {
        BrowserUtils.sleep(5);
        String fileName = messagePage.attachment.getText();
        Assert.assertTrue(fileName.contains(string));
    }
}

