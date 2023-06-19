package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

public class loginPage {
    WebDriver driver;

    public loginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //elements
    @FindBy(name = "username")
    public WebElement txtBoxUserName;
    @FindBy(name = "password")
    public WebElement txtBoxPwd;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement btnLogin;

    //methods
    public void setTxtInTxtBoxUserName(String text) {
        txtBoxUserName.sendKeys(text);
    }

    public void setTxtInTxtBoxPwd(String text) {
        txtBoxPwd.sendKeys(text);
    }

    public void clickBtnLogin() {
        btnLogin.click();
    }
}
