package com.symund.pages;

import com.symund.utilities.ConfigurationReader;
import com.symund.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.get(), this);
    }


    @FindBy(id = "user")
    public WebElement usernameInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(id = "submit-form")
    public WebElement loginBtn;

    @FindBy(css = ".warning.wrongPasswordMsg")
    public WebElement errorMsg;

    @FindBy(id="reset-password-submit")
    public WebElement resetPassword;


    public void login(String username, String password) {

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();

    }

    // it retrieves Webelement dynamically
    public WebElement links(String linkName) {

        int i = 0;
        switch (linkName) {
            case "Eye Icon":
                i=1;
                break;
            case "Forgot password?":
                i=2;
                break;

            case "Log in with a device":
                i=3;
                break;
        }

        return Driver.get().findElement(By.xpath("(//a[@id='lost-password']/..//a)["+i+"]"));
    }

//    public String alertJava(WebElement field){
//        JavascriptExecutor js = (JavascriptExecutor)Driver.get();
//
//
//      //  WebElement field = usernameInput;
//        Boolean is_valid = (Boolean)js.executeScript("return arguments[0].checkValidity();", field);
//        String message = (String)js.executeScript("return arguments[0].validationMessage;", field);
//
//        return message;
//    }
}
