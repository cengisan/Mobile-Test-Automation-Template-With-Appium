package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.ElementHelper;

import java.time.Duration;
import java.util.List;

public class Pages {

    AppiumDriver appiumDriver;
    WebDriverWait webDriverWait;
    ElementHelper elementHelper;
    By closeAdsButton = new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"com.dmall.mfandroid:id/btnClose\")");
    By categoryButton = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Kategoriler\")");
    By electronicCategoryIcon = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Elektronik\")");
    By telephoneAndAccessoryCategoryIcon = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Telefon & Aksesuarları\")");
    By cellphoneCategoryIcon = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Cep Telefonu\")");
    By filterButton = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Filtrele\")");
    By brandButton = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Marka\")");
    By appleSelectBox = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Apple\")");
    By applyButton = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Uygula\")");
    By modelButton = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Model\")");
    By modelSelectBox = new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"com.dmall.mfandroid:id/nameTV\")");
    By showResultsButton = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Sonuçları Göster\")");
    By productList = new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"com.dmall.mfandroid:id/ivImage\")");
    By addToCartButton = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Sepete Ekle\")");
    By cartIconWithNotification = new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"com.dmall.mfandroid:id/navigation_basket\")");

    public Pages(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        this.webDriverWait = new WebDriverWait(appiumDriver, Duration.ofSeconds(10));
        this.elementHelper = new ElementHelper(appiumDriver);
    }
    public void clicktoAdsCloseButton() {
        appiumDriver.findElement(closeAdsButton).click();
    }
    public void clickToCategoryButton() {
        appiumDriver.findElement(categoryButton).click();
    }
    public void clickToElectronicCategoryIcon() {
        appiumDriver.findElement(electronicCategoryIcon).click();
    }
    public void clickToTelephoneAndAccessoryCategoryIcon() {
        appiumDriver.findElement(telephoneAndAccessoryCategoryIcon).click();
    }
    public void clickToCellphoneCategoryIcon() {
        appiumDriver.findElement(cellphoneCategoryIcon).click();
    }
    public void clickToFilterAndSelectIphoneProMax() {
        appiumDriver.findElement(filterButton).click();
        appiumDriver.findElement(brandButton).click();
        appiumDriver.findElement(appleSelectBox).click();
        appiumDriver.findElement(applyButton).click();
        appiumDriver.findElement(modelButton).click();
        List <WebElement> modelList = appiumDriver.findElements(modelSelectBox);
        modelList.get(4).click();
        appiumDriver.findElement(applyButton).click();
    }
    public void clickToShowResult() {
        appiumDriver.findElement(showResultsButton).click();
    }
    public void clickFirstProduct() {
        List <WebElement> produstList = appiumDriver.findElements(productList);
        produstList.get(0).click();
    }
    public void clickAddToCart() {
        appiumDriver.findElement(addToCartButton).click();
    }
    public void assertToProductIsInTheCart() {
        Assert.assertEquals(appiumDriver.findElement(cartIconWithNotification).getAttribute("content-desc"),"Sepetim, 1 new notification");
    }
}
