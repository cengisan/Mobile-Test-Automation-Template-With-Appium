package util;

import enums.SwipeEnum;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ElementHelper {
    AppiumDriver appiumDriver;
    WebDriverWait webDriverWait;
    Actions action;

    public ElementHelper(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        this.webDriverWait = new WebDriverWait(appiumDriver, Duration.ofSeconds(10));
        this.action = new Actions(appiumDriver);
    }

    public WebElement presenceElement(By key) {
        return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(key));
    }

    public WebElement findElement(By key) {
        return presenceElement(key);
    }

    public void click(By key) {
        findElement(key).click();
    }

    public void sendKey(By key, String text) {
        findElement(key).sendKeys(text);
    }

    public void checkVisible(By key) {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(key));
    }

    public void swipe(By key, SwipeEnum direction) {

        WebElement element = findElement(key);

        if (direction.equals(SwipeEnum.LEFT)){
            int centerY = element.getRect().y + (element.getSize().height / 2);
            double startX = element.getRect().x + (element.getSize().width * 0.9);
            double endX = element.getRect().x + (element.getSize().width * 0.1);
            //Type of pointer input
            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            //Create sequence object to add actions
            Sequence swipe = new Sequence(finger, 1);
            //Move finger into starting position
            swipe.addAction(finger.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), (int) startX, centerY));
            //Finger comes down into contact with screen
            swipe.addAction(finger.createPointerDown(0));
            //Finger moves to en position
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), (int) endX, centerY));
            //Get up finger from screen
            swipe.addAction(finger.createPointerUp(0));
            //Perform the action
            appiumDriver.perform(List.of(swipe));

        } else if (direction.equals(SwipeEnum.RIGHT)) {
            int centerY = element.getRect().y + (element.getSize().height / 2);
            double startX = element.getRect().x + (element.getSize().width * 0.1);
            double endX = element.getRect().x + (element.getSize().width * 0.9);
            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence swipe = new Sequence(finger, 1);
            swipe.addAction(finger.createPointerMove(Duration.ofSeconds(0), PointerInput.Origin.viewport(), (int) startX, centerY));
            swipe.addAction(finger.createPointerDown(0));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), (int) endX, centerY));
            swipe.addAction(finger.createPointerUp(0));
            appiumDriver.perform(List.of(swipe));
        } else if (direction.equals(SwipeEnum.UP)) {
            int centerX = element.getRect().x + (element.getSize().width / 2);
            double startY = element.getRect().y + (element.getSize().height * 0.1);
            double endY = element.getRect().y + (element.getSize().height * 0.9);
            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH,"finger");
            Sequence swipe = new Sequence(finger,1);
            swipe.addAction(finger.createPointerMove(Duration.ofSeconds(0),PointerInput.Origin.viewport(), centerX,(int)startY));
            swipe.addAction(finger.createPointerDown(0));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), centerX, (int)endY));
            swipe.addAction(finger.createPointerUp(0));
            appiumDriver.perform(List.of(swipe));
        } else if (direction.equals(SwipeEnum.DOWN)) {
            int centerX = element.getRect().x + (element.getSize().width / 2);
            double startY = element.getRect().y + (element.getSize().height * 0.9);
            double endY = element.getRect().y + (element.getSize().height * 0.1);
            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH,"finger");
            Sequence swipe = new Sequence(finger,1);
            swipe.addAction(finger.createPointerMove(Duration.ofSeconds(0),PointerInput.Origin.viewport(), centerX,(int)startY));
            swipe.addAction(finger.createPointerDown(0));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), centerX, (int)endY));
            swipe.addAction(finger.createPointerUp(0));
            appiumDriver.perform(List.of(swipe));
        } else {
            throw new RuntimeException("There is no direction as " + direction);
        }
    }
}
