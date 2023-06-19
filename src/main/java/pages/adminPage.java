package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;

import java.util.List;

public class adminPage {
    WebDriver driver;

    public adminPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //elements
    @FindBy(xpath = "//a[@href='/web/index.php/admin/viewAdminModule']")
    public WebElement menuAdmin;
    @FindAll(@FindBy(className = "oxd-topbar-body-nav-tab-item"))
    public List<WebElement> tabs;
    @FindBys({@FindBy(className = "oxd-dropdown-menu"), @FindBy(className = "oxd-topbar-body-nav-tab-link")})
    public List<WebElement> jobTabMenus;
    @FindBys({@FindBy(className = "orangehrm-header-container"), @FindBy(className = "oxd-button")})
    public WebElement btnAddPayGrade;
    @FindBys({@FindBy(className = "oxd-form-row"), @FindBy(className = "oxd-input")})
    public WebElement txtBoxCurrencyName;
    @FindBys({@FindBy(className = "orangehrm-card-container"), @FindBy(className = "oxd-form-actions"), @FindBy(css = "button[type='submit']")})
    public WebElement btnSaveCurrency;
    @FindBys({@FindBy(className = "orangehrm-paper-container"), @FindBy(className = "oxd-button")})
    public WebElement btnAddCurrencyRecord;
    @FindBy(className = "oxd-select-text-input")
    public WebElement inputCurrencyDropdown;
    @FindAll({@FindBy(className = "oxd-grid-item")})
    public List<WebElement> inputsSalary;
    @FindAll({@FindBy(css = "button[type='submit']")})
    public List<WebElement> submitButtons;
    @FindBys({@FindBy(className = "orangehrm-horizontal-padding"), @FindBy(className = "oxd-text")})
    public WebElement txtRecordResult;
    @FindBys({@FindBy(className = "orangehrm-container"), @FindBy(className = "oxd-table-cell")})
    public List<WebElement> txtCurrencyRecord;

    public void clickMenuAdmin() {
        menuAdmin.click();
    }

    public void clickTabJob() {
        tabs.get(1).click();
    }

    public void clickMenuPayGrade() {
        jobTabMenus.get(1).click();
    }

    public void clickBtnAddPayGrade() {
        btnAddPayGrade.click();
    }

    public void addTxtInCurrencyNameTxtBox(String text) {
        txtBoxCurrencyName.sendKeys(text);
    }

    public void clickBtnSaveCurrency() {
        btnSaveCurrency.click();
    }

    public void clickBtnAddCurrencyRecord() {
        btnAddCurrencyRecord.click();
    }

    public void clickInputCurrencyDropdown() {
        inputCurrencyDropdown.click();
    }

    public void addTxtInInputCurrencyDropdown(String text) {
        inputCurrencyDropdown.sendKeys(text);
    }

    public void setEmpMinSalary(String text) {
        WebElement txtBoxMinSal = inputsSalary.get(2).findElement(By.className("oxd-input"));
        txtBoxMinSal.sendKeys(text);
    }

    public void setEmpMaxSalary(String text) {
        WebElement txtBoxMaxSal = inputsSalary.get(3).findElement(By.className("oxd-input"));
        txtBoxMaxSal.sendKeys(text);
    }

    public void clickBtnSubmitSalary() {
        submitButtons.get(1).click();
    }

    public String getTxtRecordResult() {
        return txtRecordResult.getText();
    }

    public String getCurrencyNameFromTxtCurrencyRecord() {
        return txtCurrencyRecord.get(1).getText();
    }

    public String getMinSalFromTxtCurrencyRecord() {
        return txtCurrencyRecord.get(2).getText();
    }

    public String getMaxSalFromTxtCurrencyRecord() {
        return txtCurrencyRecord.get(3).getText();
    }
}
