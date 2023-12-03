package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.TrendyolLoginPage;
import util.DriverFactory;

public class TrendyolLoginStepDefinitions {

    TrendyolLoginPage trendyolLoginPage = new TrendyolLoginPage(DriverFactory.getAppiumDriver());


    @When("Click to Men select box")
    public void clickToMenSelectBox() {
        trendyolLoginPage.clickToMenSelectBox();
    }

    @When("Click to electronic category icon from menu")
    public void clickToElectronicCategoryIconFromMenu() {
        trendyolLoginPage.clickToElectronicCategoryIconFromMenu();
    }

    @When("Click to cellphone category icon")
    public void clickToCellphoneCategoryIcon() {
        trendyolLoginPage.clickToCellphoneCategoryIcon();
    }

    @When("Click to IOS Phones category icon")
    public void clickToIosPhonesCategoryIcon() {
        trendyolLoginPage.clickToIosPhonesCategoryIcon();
    }

    @When("Scroll down and click to second product")
    public void scrollDownAndClickToSecondProduct(){
        trendyolLoginPage.scrollDownAndClickToSecondProduct();
    }
    @When("Add product to cart")
    public void addProductToCart(){
        trendyolLoginPage.addProductToCart();
    }
    @Then("Check {string} in the cart")
    public void checkTheCart(String notification){
        trendyolLoginPage.checkTheCart(notification);
    }
}
