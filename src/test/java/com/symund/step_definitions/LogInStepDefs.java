package com.symund.step_definitions;

import com.symund.pages.DashboardPage;
import com.symund.pages.LoginPage;
import com.symund.utilities.BrowserUtils;
import com.symund.utilities.ConfigurationReader;
import com.symund.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class LogInStepDefs {


    @Given("the user is on login page")
    public void the_user_is_on_the_login_page() {

        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("the user enters valid credentials")
    public void the_user_enters_valid_credentials() {

        new LoginPage().usernameInput.sendKeys(ConfigurationReader.get("username"));
        new LoginPage().passwordInput.sendKeys(ConfigurationReader.get("password"));

    }

    @And("the user click Login button")
    public void theUserClickLoginButton() {

        new LoginPage().loginBtn.click();

       // BrowserUtils.waitFor(2);

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


    @And("username should be seen under Profile icon")
    public void usernameShouldBeSeenUnderProfileIcon() {

        new DashboardPage().userInfo.click();
        Assert.assertTrue(new DashboardPage().username.isDisplayed());

    }

    @When("the user presses Enter key")
    public void theUserEntersValidCredentialsAndPressesKey() {

        new LoginPage().passwordInput.sendKeys(Keys.ENTER);  // Not sure??
    }

    @When("the user enters {string} and {string}")
    public void theUserEntersAnd(String username, String password) {

        new LoginPage().usernameInput.sendKeys(username);
        new LoginPage().passwordInput.sendKeys(password);

    }

    @Then("the user should not be able to login")
    public void theUserShouldNotBeAbleToLogin() {

        String expectedTitle="Dashboard - Symund - QA";

        Assert.assertNotEquals(expectedTitle,Driver.get().getTitle());
    }

    @And("{string} error message should be seen")
    public void messageShouldBeSeen(String msg) {

        String actualMsg= new LoginPage().errorMsg.getText();

        Assert.assertEquals(msg,actualMsg);
    }

    @When("the user left {string} as blank")
    public void theUserLeftAsBlank(String type) {

        if(type.equals("username")) {
            new LoginPage().passwordInput.sendKeys(ConfigurationReader.get("password"));
        }
        else if(type.equals("password")) {
            new LoginPage().usernameInput.sendKeys(ConfigurationReader.get("username"));
        }

    }

    @And("Please fill in this field message for {string} should be seen")
    public void pleaseFillInThisFieldMessageForShouldBeSeen(String msgType) {


        String actualMsg="";

        if(msgType.equals("username")) {
          //  actualMsg = new LoginPage().alertJava(new LoginPage().usernameInput);
            actualMsg = new LoginPage().usernameInput.getAttribute("validationMessage");
        }else if(msgType.equals("password")) {
          //  actualMsg=new LoginPage().alertJava(new LoginPage().passwordInput);
            actualMsg=new LoginPage().passwordInput.getAttribute("validationMessage");
        }

        System.out.println("actualMsg = " + actualMsg);
        Assert.assertEquals("Please fill in this field.", actualMsg);


    }


    @Then("the user can see password in a form of dots by default")
    public void theUserCanSeePasswordInAFormOfDotsByDefault() {

       Assert.assertEquals( "password",new LoginPage().passwordInput.getAttribute("type"));

    }

    @Then("the user should be able to see password explicitly")
    public void theUserShouldBeAbleToSeePasswordExplicitly() {

        Assert.assertEquals( "text",new LoginPage().passwordInput.getAttribute("type"));

    }

    @Then("the link {string} should be displayed on the login page")
    public void theLinkShouldBeDisplayedOnTheLoginPage(String linkName) {

        Assert.assertTrue(new LoginPage().links(linkName).isDisplayed());
        Assert.assertEquals("Forgot password?", new LoginPage().links(linkName).getText());
    }

    @When("the user click {string}")
    public void theUserClick(String linkName) {

        new LoginPage().links(linkName).click();
    }

    @Then("Reset password button should be seen")
    public void buttonShouldBeSeen() {

        BrowserUtils.waitForVisibility(new LoginPage().resetPassword, 3);
        Assert.assertTrue(new LoginPage().resetPassword.isDisplayed());
        Assert.assertEquals("Reset password", new LoginPage().resetPassword.getAttribute("value"));

    }

    @Then("the user should be able to see {string} for {string} field")
    public void theUserShouldBeAbleToSeeForUsernameField(String text, String type) {

        String actualMsg ="";

        if(type.equalsIgnoreCase("Username")) {
            actualMsg = new LoginPage().usernameInput.getAttribute("placeholder");
        }

        else if(type.equalsIgnoreCase("Password")) {
            actualMsg=new LoginPage().passwordInput.getAttribute("placeholder");
        }

        Assert.assertEquals(text, actualMsg);
    }

    @And("the user click user info")
    public void theUserClickUserInfo() {

        new DashboardPage().userInfo.click();

    }

    @And("the user click Log out")
    public void theUserClickLogOut() {
        BrowserUtils.waitForClickablility(new DashboardPage().logOutBtn, 4);
        new DashboardPage().logOutBtn.click();
    }
}
