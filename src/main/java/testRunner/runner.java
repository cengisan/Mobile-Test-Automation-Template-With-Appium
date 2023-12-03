package testRunner;

import io.appium.java_client.AppiumDriver;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import util.DriverFactory;

@CucumberOptions(
        features = {"src/test/java/features"},
        glue = {"stepDefinitions", "util"},
        tags = "@TrendyolLogin",
        plugin = {
                "summary", "pretty", "html:reports/cucumberReport/Report.html"
        }
)
public class runner extends AbstractTestNGCucumberTests {
    static AppiumDriver appiumDriver = DriverFactory.getAppiumDriver();
}
