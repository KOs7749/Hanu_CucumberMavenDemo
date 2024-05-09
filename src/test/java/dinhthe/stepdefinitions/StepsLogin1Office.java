package dinhthe.stepdefinitions;

import dinhthe.constants.ConstantGlobal;
import dinhthe.helpers.CaptureHelpers;
import dinhthe.hooks.TestContext;
import dinhthe.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class StepsLogin1Office {

    LoginPage loginPage;

    public StepsLogin1Office(TestContext testContext) {
        loginPage = new LoginPage();
    }

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        loginPage.navigateToUrl();
    }

    @Then("I should see login page UI")
    public void userShouldSeeLoginPageUI() {
        loginPage.UILoginPage();
    }

    @When("I enter my username and password")
    public void iEnterMyUsernameAndPassword() {
        loginPage.enterUserNameAndPassword(ConstantGlobal.USERNAME, ConstantGlobal.PASSWORD);
    }

    @And("I click the Login button")
    public void iClickTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("I should be taken to the dashboard page")
    public void iShouldBeTakenToTheDashboardPage() {
        CaptureHelpers.takeScreenshot("Dashboard page screenshot");
    }

    @And("I should see the {string} menu")
    public void iShouldSeeTheMenu(String arg0) {
        Assert.assertEquals(arg0, "Bang tin", "Menu Bảng tin không tồn tại.");
    }

    @When("I enter username and password invalid")
    public void iEnterUsernameAndPasswordInvalid() {
        loginPage.enterUserNameAndPassword("123", "123");
    }

    @When("I enter invalid username and password correct")
    public void iEnterInvalidUsernameAndCorrectPassword() {
        loginPage.enterUserNameAndPassword("123", ConstantGlobal.PASSWORD);
    }

    @When("I enter correct username and invalid password")
    public void iEnterCorrectUsernameAndInvalidPassword() {
        loginPage.enterUserNameAndPassword(ConstantGlobal.USERNAME, "123");
    }

    @Then("I should see the error message")
    public void iShouldSeeTheErrorMessage() {
        loginPage.verifyLoginFail();
    }

    @And("I should be taken to the Login page")
    public void iShouldBeTakenToTheLoginPage() {
        CaptureHelpers.takeScreenshot("Login page screenshot");
    }

    @When("I enter username and password with SQL injection")
    public void iEnterUsernameAndPasswordWithSQLInjection() {
        loginPage.enterUserNameAndPassword("OR 1=1", "OR 1=1");
    }

    @When("I clicks on the forgot password link")
    public void userClicksOnTheForgotPasswordLink() {
        loginPage.clickLinkableForgotPassword();
    }

    @Then("I should see the recovery password screen")
    public void iShouldSeeTheForgotPasswordScreen() {
        CaptureHelpers.takeScreenshot("Recovery password page screenshot");
    }
}