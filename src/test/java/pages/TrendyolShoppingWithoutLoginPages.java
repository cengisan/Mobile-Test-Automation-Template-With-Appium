package pages;

import enums.SwipeEnum;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;

import java.time.Duration;
import java.util.List;

public class TrendyolShoppingWithoutLoginPages {

    AppiumDriver appiumDriver;
    WebDriverWait webDriverWait;
    ElementHelper elementHelper;
    public TrendyolShoppingWithoutLoginPages(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        this.webDriverWait = new WebDriverWait(appiumDriver, Duration.ofSeconds(10));
        this.elementHelper = new ElementHelper(appiumDriver);
    }

    By toolTipClose = new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"trendyol.com:id/imageViewTooltipClose\")");
    By swipeMenu = new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"trendyol.com:id/recyclerView\")");
    By scrollMenu = new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"trendyol.com:id/recycler_view_search_result\")");
    By menSelectBox = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"ERKEK\")");
    By menuElementsTexts = new AppiumBy.ByAndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\")");
    By electronicCategoryIcon = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Elektronik\")");
    By cellphoneCategoryIcon = new AppiumBy.ByAndroidUIAutomator("new UiSelector().description(\"Cep Telefonu\")");
    By iOSCategoryIcon = new AppiumBy.ByAndroidUIAutomator("new UiSelector().description(\"IOS Telefonlar\")");
    By iOSProductList = new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"trendyol.com:id/constraintLayout\")");
    By addCartButton = new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"trendyol.com:id/primaryButton\")");
    By addCartContinueButton = new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"trendyol.com:id/buttonContinue\")");
    By cartIconNotification = new AppiumBy.ByAndroidUIAutomator("new UiSelector().description(\"Sepetim, 1 yeni bildirim\")");

    public void clickToMenSelectBox() {
        appiumDriver.findElement(menSelectBox).click();
    }

    public void clickToElectronicCategoryIconFromMenu() {
        appiumDriver.findElement(toolTipClose).click();
        List<WebElement> elementTexts = appiumDriver.findElements(menuElementsTexts);
        for (int i = 0; i < elementTexts.size(); i++){
            if (elementTexts.get(i).getText().equals("Elektronik")) {
                appiumDriver.findElement(electronicCategoryIcon).click();
                break;
            }
            else
                elementHelper.swipe(swipeMenu, SwipeEnum.LEFT);
        }
    }

    public void clickToCellphoneCategoryIcon() {
        appiumDriver.findElement(cellphoneCategoryIcon).click();
    }

    public void clickToIosPhonesCategoryIcon() {
        appiumDriver.findElement(iOSCategoryIcon).click();
    }

    public void scrollDownAndClickToSecondProduct() {
        appiumDriver.findElement(toolTipClose).click();
        elementHelper.swipe(scrollMenu, SwipeEnum.DOWN);
        List<WebElement> productList = appiumDriver.findElements(iOSProductList);
        productList.get(2).click();
    }
    public void addProductToCart() {
        appiumDriver.findElement(addCartButton).click();
        appiumDriver.findElement(addCartContinueButton).click();
    }
    public void checkTheCart(String notification) {
        appiumDriver.findElement(toolTipClose).click();
        elementHelper.checkVisible(cartIconNotification);
    }
}

