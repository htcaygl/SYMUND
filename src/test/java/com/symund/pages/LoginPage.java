package com.symund.pages;

import com.symund.utilities.ConfigurationReader;
import com.symund.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() { PageFactory.initElements(Driver.get(), this); }


    @FindBy(id = "user")
    public WebElement usernameInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(id="submit-form")
    public WebElement loginBtn;


    public void login(String username,String password) {

       usernameInput.sendKeys(username);
       passwordInput.sendKeys(password);
       loginBtn.click();

    }

}
