package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class CarvanaHomePage {
    public CarvanaHomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "a[data-cv-test='headerCarFinderLink']")
    public WebElement carFinderLink;

    @FindBy(css = "a[data-cv-test='headerTradesLink']")
    public WebElement sellTradeLink;

    @FindBy(css = "div[data-cv-test='headerFinanceDropdown']")   //span[class*='HeaderFinancingstyles__MenuTitle-sc-3g0y8k-3']
    public WebElement financingMenuItem;

    @FindBy(css = "a[data-cv-test='headerFinanceLoanCalc']")
    public WebElement autoLoanMenuItem;
}
