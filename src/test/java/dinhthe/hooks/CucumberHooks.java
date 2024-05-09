package dinhthe.hooks;

import dinhthe.constants.ConstantGlobal;
import dinhthe.driver.DriverManager;
import dinhthe.helpers.CaptureHelpers;
import dinhthe.helpers.PropertiesHelpers;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class CucumberHooks {
    @BeforeAll
    public static void beforeAll() {
        System.out.println("================ beforeAll ================");
        PropertiesHelpers.loadAllFiles();
        //Khởi chạy Report
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("================ afterAll ================");

    }

    @Before
    public void beforeScenario(Scenario scenario) {
        System.out.println("================ beforeScenario ================");
        //Record video
        //System.out.println(scenario.getName() + " - 123");

        if (ConstantGlobal.RECORD_VIDEO.equals("yes")) {
            CaptureHelpers.startRecord(scenario.getName());
        }

    }

    @After
    public void afterScenario(Scenario scenario) {
        System.out.println("================ afterScenario ================");

        if (ConstantGlobal.RECORD_VIDEO.equals("yes")) {
            CaptureHelpers.stopRecord();
        }

        DriverManager.quit();
    }

    @BeforeStep
    public void beforeStep(Scenario scenario) {
        System.out.println("================ beforeStep ================");
        //Ghi file log4j
        //Ghi log step vào report
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        System.out.println("================ afterStep ================");
        //validate if scenario has failed then Screenshot
//        if (scenario.isFailed()) {
//            CaptureHelpers.takeScreenshot(scenario.getName());
//        }

        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Screenshot Failed");
        }
    }
}
