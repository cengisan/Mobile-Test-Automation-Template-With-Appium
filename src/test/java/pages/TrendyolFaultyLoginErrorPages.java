package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;

import java.time.Duration;

public class TrendyolFaultyLoginErrorPages {

    AppiumDriver appiumDriver;
    ElementHelper elementHelper;
    WebDriverWait webDriverWait;
    public TrendyolFaultyLoginErrorPages(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        this.elementHelper = new ElementHelper(appiumDriver);
        this.webDriverWait = new WebDriverWait(appiumDriver, Duration.ofSeconds(10));
    }

    By toolTipClose = new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"trendyol.com:id/imageViewTooltipClose\")");
    By myAccountIcon = new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"trendyol.com:id/tab_account\")");
    By emailInputBox = new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"trendyol.com:id/editTextEmail\")");
    By passwordInputBox = new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"trendyol.com:id/editTextPassword\")");
    By loginButton = new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"trendyol.com:id/buttonLogin\")");
    String errorMessageId = "trendyol.com:id/snackbar_text";

    public void clickToMyAccountIcon() {
        elementHelper.click(toolTipClose);
        elementHelper.click(myAccountIcon);
    }

    public void clickToInputBoxesAndWriteAnEmailAndPassword() {
        elementHelper.sendKey(emailInputBox,"automation@gmail.com");
        elementHelper.sendKey(passwordInputBox,"invalidPassword");
    }

    public void clickToLoginButton() {
        elementHelper.click(loginButton);
    }

    public void checkMessageOnTheScreen(String errorMessage) {
        elementHelper.checkVisible(By.id(errorMessageId));
    }
}
