package util;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    static AppiumDriver appiumDriver;
    static Properties properties;
    static DesiredCapabilities capabilities;

    public static AppiumDriver initiliazeAppiumDriver(String browser){
        properties = ConfigReader.getProperties();
        capabilities = new DesiredCapabilities();
        if(browser.equals("Android")){
            capabilities.setCapability("platformName", properties.getProperty("driver.android.platform.name"));
            capabilities.setCapability("udid",properties.getProperty("driver.android.udid"));
            capabilities.setCapability("appPackage",properties.getProperty("driver.android.app.package"));
            capabilities.setCapability("appActivity",properties.getProperty("driver.android.app.activity"));
        } else if (browser.equals("IOS")) {
            capabilities.setCapability("platformName", properties.getProperty("driver.ios.platform.name"));
            capabilities.setCapability("udid",properties.getProperty("driver.ios.udid"));
            capabilities.setCapability("appPackage",properties.getProperty("driver.ios.app.package"));
            capabilities.setCapability("appActivity",properties.getProperty("driver.ios.app.activity"));
        }
        try {
            appiumDriver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        int impWait = Integer.parseInt(properties.getProperty("driver.implicitly.wait"));
        appiumDriver.manage().timeouts().implicitlyWait(impWait, TimeUnit.SECONDS);

        return getAppiumDriver();
    }
    public static AppiumDriver getAppiumDriver(){
        return appiumDriver;
    }


}
