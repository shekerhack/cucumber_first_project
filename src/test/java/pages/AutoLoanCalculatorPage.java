package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class AutoLoanCalculatorPage {
    public AutoLoanCalculatorPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

   // @FindBy(css = "//span[@class='loan-calculator-field-label'][1]")
   // public WebElement costText;

    @FindBy(css = "input[name='vehiclePrice']")
    public WebElement cost;

    @FindBy(id = "creditBlock")
    public WebElement creditScoreDropDown;

    @FindBy(css = "select[name='loanTerm']")
    public WebElement loanTerm;

    @FindBy(css = "input[name='downPayment']")
    public WebElement downPayment;

    @FindBy(css = "div[class*='is-monthly-display']")
    public WebElement monthlyPayment;
}
