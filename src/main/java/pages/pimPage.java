package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class pimPage {
    WebDriver driver;

    public pimPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //elements
    @FindBy(xpath = "//a[@href='/web/index.php/pim/viewPimModule']")
    public WebElement menuPIM;
    @FindBy(css = "[placeholder='Type for hints...']")
    public WebElement txtBoxEmpName;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement btnSearch;
    @FindAll(@FindBy(className = "oxd-autocomplete-dropdown"))
    public List<WebElement> dropDownList;
    @FindBys({@FindBy(className = "oxd-table-body"), @FindBy(className = "oxd-table-row")})
    public List<WebElement> matchedDataRows;

    //methods
    public void clickMenuPIM() {
        menuPIM.click();
    }

    public void setTxtInTxtBoxEmpName(String text) {
        txtBoxEmpName.sendKeys(text);
    }

    public void clickBtnSearch() {
        btnSearch.click();
    }
}

