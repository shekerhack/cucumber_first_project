package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.eo.Se;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.*;
import utils.ActionsUtil;
import utils.Driver;
import utils.DropdownHandler;
import utils.Waiter;

public class CarvanaSteps {
    WebDriver driver;
    CarvanaHomePage carvanaHomePage;
    CarFinderPage carFinderPage;
    TryCarFinderPage tryCarFinderPage;
    Sell_TradePage sell_tradePage;
    AutoLoanCalculatorPage autoLoanCalculatorPage;


    @Before
    public void setup() {
        driver = Driver.getDriver();
        carvanaHomePage = new CarvanaHomePage();
        carFinderPage = new CarFinderPage();
        tryCarFinderPage = new TryCarFinderPage();
        sell_tradePage = new Sell_TradePage();
        autoLoanCalculatorPage = new AutoLoanCalculatorPage();


    }

    @Given("user is on {string}")
    public void user_is_on(String url) {
        driver.get(url);

    }

    @When("user clicks on {string} menu item")
    public void user_clicks_on_menu_item(String menuItems) {
        switch (menuItems){
            case "CAR FINDER":
                carvanaHomePage.carFinderLink.click();
                break;
            case "SELL/TRADE":
                carvanaHomePage.sellTradeLink.click();
                break;
            case "AUTO LOAN CALCULATOR":
                carvanaHomePage.autoLoanMenuItem.click();
                break;
        }

    }

    @Then("user should be navigated to {string}")
    public void user_should_be_navigated_to(String url) {
        switch (url){
            case "https://www.carvana.com/help-me-search/":
            case "https://www.carvana.com/help-me-search/qa":
            case "https://www.carvana.com/sell-my-car":
                Assert.assertEquals(url, driver.getCurrentUrl());
                break;
        }

    }

    @Then("user should see {string} text")
    public void user_should_see_text(String headingText) {
        switch (headingText){
            case "https://www.carvana.com/help-me-search/":
            Assert.assertTrue(carFinderPage.heading1.isDisplayed());
            Assert.assertEquals(headingText, carFinderPage.heading1.getText());
            Assert.assertTrue(carFinderPage.heading3.isDisplayed());
            Assert.assertEquals(headingText, carFinderPage.heading3.getText());
               break;
            case "https://www.carvana.com/help-me-search/qa":
                Assert.assertTrue(tryCarFinderPage.headLine.isDisplayed());
                Assert.assertEquals(headingText, tryCarFinderPage.headLine.getText());
                Assert.assertTrue(tryCarFinderPage.subHeading.isDisplayed());
                Assert.assertEquals(headingText, tryCarFinderPage.subHeading.getText());
                break;
            case "https://www.carvana.com/sell-my-car":
                Assert.assertTrue(sell_tradePage.textSellTrade.isDisplayed());
                Assert.assertEquals(headingText, sell_tradePage.textSellTrade.getText());
                Assert.assertTrue(sell_tradePage.textWePickUpCar.isDisplayed());
                Assert.assertEquals(headingText, sell_tradePage.textWePickUpCar.getText());
                Assert.assertTrue(sell_tradePage.didNotFindVinText.isDisplayed());
                Assert.assertEquals(headingText, sell_tradePage.didNotFindVinText.getText());

        }

    }

    @Then("user should see {string} link")
    public void user_should_see_link(String carFinderText) {
        Assert.assertTrue(carFinderPage.tryCarFinderLink.isDisplayed());
        Assert.assertEquals(carFinderText, carFinderPage.tryCarFinderLink.getText());

    }

    @When("user clicks on {string} link")
    public void user_clicks_on_link(String carFinderLink) {
        if("TRY CAR FINDER".equals(carFinderLink)){
            carFinderPage.tryCarFinderLink.click();
        }

    }

    @When("user clicks on {string} button")
    public void user_clicks_on_button(String buttons) {
        switch (buttons){
            case "VIN":
                sell_tradePage.vinButton.click();
                break;
            case "GET MY OFFER":
                sell_tradePage.getMyOfferButton.click();
                break;
        }

    }

    @When("user enters vin number as {string}")
    public void user_enters_vin_number_as(String vinNum) {
        sell_tradePage.vinInputBox.sendKeys(vinNum);

    }

    @When("user hovers over on {string} menu item")
    public void user_hovers_over_on_menu_item(String financingItem) {
        Assert.assertEquals(financingItem, carvanaHomePage.financingMenuItem.getText());
        Waiter.pause(2);
        ActionsUtil.moveToElement(carvanaHomePage.financingMenuItem);

    }

    @When("user enters {string} as {string}")
    public void user_enters_as(String cost, String costPrice) {
        switch (cost) {
            case "Cost of Car I want":
                autoLoanCalculatorPage.cost.sendKeys(costPrice);
                break;
            case "What is Your Down Payment?":
                autoLoanCalculatorPage.downPayment.sendKeys(costPrice);
                break;

        }
    }

    @When("user selects {string} as {string}")
    public void user_selects_as(String creditScoreText, String creditScore) {
        switch (creditScoreText){
            case "What is Your Credit Score?":
                DropdownHandler.selectOptionByVisibleText(autoLoanCalculatorPage.creditScoreDropDown, "Excellent: 780");
                break;
            case "Choose Your Loan Terms":
                DropdownHandler.selectOptionByVisibleText(autoLoanCalculatorPage.loanTerm, "60 Months");
                break;

        }

    }

    @Then("user should see the monthly payment as {string}")
    public void user_should_see_the_monthly_payment_as(String monthlyPay) {
        Assert.assertTrue(autoLoanCalculatorPage.monthlyPayment.isDisplayed());
        Assert.assertEquals(monthlyPay, autoLoanCalculatorPage.monthlyPayment.getText());

    }









}
