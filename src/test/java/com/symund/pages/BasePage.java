package com.symund.pages;

import com.symund.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage()  { PageFactory.initElements(Driver.get(), this); }

    @FindBy(css = ".avatardiv.avatardiv-shown")
    public WebElement userInfo;

    @FindBy(xpath = "//li[@data-id=\"logout\"]")
    public WebElement logOutBtn;
}
