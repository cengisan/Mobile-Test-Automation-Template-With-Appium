package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.TrendyolFaultyLoginErrorPages;
import util.DriverFactory;

public class TrendyolFaultyLoginErrorStepDefinitions {

    TrendyolFaultyLoginErrorPages trendyolFaultyLoginErrorPages = new TrendyolFaultyLoginErrorPages(DriverFactory.getAppiumDriver());
    @When("Click to My Account icon")
    public void clickToMyAccountIcon() {
        trendyolFaultyLoginErrorPages.clickToMyAccountIcon();
    }

    @When("Click to input boxes and write email and password")
    public void clickToInputBoxesAndWriteAnEmailAndPassword() {
        trendyolFaultyLoginErrorPages.clickToInputBoxesAndWriteAnEmailAndPassword();
    }

    @When("Click to login button")
    public void clickToLoginButton() {
        trendyolFaultyLoginErrorPages.clickToLoginButton();
    }

    @Then("Check {string} message on the screen")
    public void checkMessageOnTheScreen(String errorMessage) {
        trendyolFaultyLoginErrorPages.checkMessageOnTheScreen(errorMessage);
    }
}
