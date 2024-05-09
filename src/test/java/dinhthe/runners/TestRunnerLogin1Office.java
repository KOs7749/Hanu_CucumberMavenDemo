package dinhthe.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/resources/features/1Office/Login1Office.feature",
        glue = {
                "dinhthe.stepdefinitions",
                "dinhthe.common",
                "dinhthe.hooks"
        },
        plugin = {
                "dinhthe.hooks.CucumberListener",
                "pretty",
                "html:target/cucumber-reports/TestRunnerLogin1Office.html",
                "json:target/cucumber-reports/TestRunnerLogin1Office.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        })

@Test
public class TestRunnerLogin1Office extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}