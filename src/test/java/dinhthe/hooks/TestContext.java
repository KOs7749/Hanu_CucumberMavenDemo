package dinhthe.hooks;

import dinhthe.driver.DriverFactory;
import dinhthe.driver.DriverManager;
import dinhthe.pages.LoginPage;
import dinhthe.utils.LogUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;

public class TestContext {

    private WebDriver driver;
    private LoginPage loginPage;

    public TestContext() {
        ThreadGuard.protect(new DriverFactory().createDriver());
        LogUtils.info("Driver in TestContext: " + getDriver());
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }


    public WebDriver getDriver() {
        return DriverManager.getDriver();
    }
}
