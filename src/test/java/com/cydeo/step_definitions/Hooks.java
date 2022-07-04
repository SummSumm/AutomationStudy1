package com.cydeo.step_definitions;

import com.cydeo.pages.MessagePage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Hooks {
    MessagePage messagePage = new MessagePage();

    @After
    public void close() {
        BrowserUtils.sleep(10);
        messagePage.logoutDD.click();
        messagePage.logoutButton.click();
    }


}
