package pages;

import cucumber.api.java.eo.Se;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class Sell_TradePage {
    public Sell_TradePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = ".hHVkqZ ")
    public WebElement textSellTrade;

    @FindBy(css = ".dJRkut")
    public WebElement textWePickUpCar;

    @FindBy(css = "button[data-cv-test='VINToggle']")
    public WebElement vinButton;

    @FindBy(css = "input[aria-labelledby='VIN']")
    public WebElement vinInputBox;

    @FindBy(css = ".fDtGMt")
    public WebElement getMyOfferButton;

    @FindBy(css = ".sc-fTFLOO ")
    public WebElement didNotFindVinText;
}
