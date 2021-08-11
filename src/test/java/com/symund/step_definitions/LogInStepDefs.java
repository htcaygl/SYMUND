package com.symund.step_definitions;

import com.symund.pages.DashboardPage;
import com.symund.pages.LoginPage;
import com.symund.utilities.BrowserUtils;
import com.symund.utilities.ConfigurationReader;
import com.symund.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LogInStepDefs {


    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {

        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("the user enters valid credentials")
    public void the_user_enters_valid_credentials() {

        new LoginPage().login(ConfigurationReader.get("username"), ConfigurationReader.get("password"));

    }

    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {

        String expectedTitle="Dashboard - Symund - QA";

        Assert.assertEquals(expectedTitle,Driver.get().getTitle());
    }



    @Given("the user logged in")
    public void the_user_logged_in() {

        Driver.get().get(ConfigurationReader.get("url"));
        new LoginPage().login(ConfigurationReader.get("username"), ConfigurationReader.get("password"));

    }

    @When("the user click user info and click Log out")
    public void the_user_click_user_info_and_click() {

        new DashboardPage().userInfo.click();
        BrowserUtils.waitForClickablility(new DashboardPage().logOutBtn, 4);
        new DashboardPage().logOutBtn.click();

    }

    @Then("the user should be able to log out")
    public void the_user_should_be_able_to_log_out() {

        String expectedTitle="Symund - QA";

        Assert.assertEquals(expectedTitle,Driver.get().getTitle());
    }


    @When("the user click step back button")
    public void the_user_click_step_back_button() {

        Driver.get().navigate().back();
    }

    @Then("the user should not see home page")
    public void the_user_should_not_see_home_page() {

        Assert.assertNotEquals("Dashboard - Symund - QA", Driver.get().getTitle());
    }


}
