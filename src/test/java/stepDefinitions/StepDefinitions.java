package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Pages;
import util.DriverFactory;

public class StepDefinitions {

    Pages pages = new Pages(DriverFactory.getAppiumDriver());

    @When("Click to ads close button")
    public void ClickToAdsCloseButton() {
        pages.clicktoAdsCloseButton();
    }
    @When("Click to category button")
    public void clickToCategoryButton() {
        pages.clickToCategoryButton();
    }

    @When("Click to electronic category icon")
    public void clickToElectronicCategoryIcon() {
        pages.clickToElectronicCategoryIcon();
    }

    @When("Click to telephone and accessory category icon")
    public void clickToTelephoneAndAccessoryCategoryIcon() {
        pages.clickToTelephoneAndAccessoryCategoryIcon();
    }

    @When("Click to cellphone category icon")
    public void clickToCellphoneCategoryIcon() {
        pages.clickToCellphoneCategoryIcon();
    }

    @When("Click to filter and select iphone15 pro max")
    public void clickToFilterAndSelectIphoneProMax() {
        pages.clickToFilterAndSelectIphoneProMax();
    }

    @When("Click to show result")
    public void clickToShowResult() {
        pages.clickToShowResult();
    }

    @When("Click first product")
    public void clickFirstProduct() {
        pages.clickFirstProduct();
    }

    @When("Click add to cart")
    public void clickAddToCart() {
        pages.clickAddToCart();
    }

    @Then("Assert to product is in the cart")
    public void assertToProductIsInTheCart() {
        pages.assertToProductIsInTheCart();
    }
}
