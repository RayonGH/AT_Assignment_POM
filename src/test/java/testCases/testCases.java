package testCases;

import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.driverFactory;
import pages.adminPage;
import pages.loginPage;
import pages.pimPage;

import java.util.List;

public class testCases extends driverFactory {
    @Test(description = "Check user can search with partial text and obtain matched results")
    public void TestCase_SearchUserWithPartialTextMatch() throws InterruptedException {
        try {
            //open browser
            setUpBrowser("Chrome", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            Thread.sleep(2000);
            //Login page
            loginPage loginPageFactory = new loginPage(driver);
            //login
            loginPageFactory.setTxtInTxtBoxUserName("Admin");
            loginPageFactory.setTxtInTxtBoxPwd("admin123");
            loginPageFactory.clickBtnLogin();
            Thread.sleep(3000);
            //PIM page
            pimPage pimPageFactory = new pimPage(driver);
            //redirect to PIM
            pimPageFactory.clickMenuPIM();
            Thread.sleep(2000);
            //search with partial text
            pimPageFactory.setTxtInTxtBoxEmpName("ch");
            Thread.sleep(2000);
            //check matched autocomplete dropdown list
            String item;
            for (WebElement listItem : pimPageFactory.dropDownList) {
                item = listItem.getText().toLowerCase();
                Assert.assertTrue(item.contains("ch"), item);
            }
            //click 'Search' button
            pimPageFactory.clickBtnSearch();
            Thread.sleep(2000);
            //check matched first name and last name cells of first 3 rows
            String firstName, lastName;
            List<WebElement> first3Rows = pimPageFactory.matchedDataRows.subList(0, 3);
            for (WebElement row : first3Rows) {
                List<WebElement> tableCells = row.findElements(By.className("oxd-table-cell")).subList(2, 4);
                firstName = tableCells.get(0).getText().toLowerCase();
                lastName = tableCells.get(1).getText().toLowerCase();
                Assert.assertTrue(firstName.contains("ch") || lastName.contains("ch"));
            }
        } finally {
            closeBrowser();
        }
    }

    @Test(description = "Check user can add Pay Grade and update data and save")
    public void TestCase_VerifyUserCanAddPayGrades() throws InterruptedException {
        try {
            //open browser
            setUpBrowser("Chrome", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            Thread.sleep(2000);
            //Login page
            loginPage loginPageFactory = new loginPage(driver);
            //login
            loginPageFactory.setTxtInTxtBoxUserName("Admin");
            loginPageFactory.setTxtInTxtBoxPwd("admin123");
            loginPageFactory.clickBtnLogin();
            Thread.sleep(3000);
            //Admin page
            adminPage adminPageFactory = new adminPage(driver);
            //redirect to Admin page
            adminPageFactory.clickMenuAdmin();
            Thread.sleep(2000);
            //Open tab and click on 'PayGrade' menu
            adminPageFactory.clickTabJob();
            Thread.sleep(2000);
            adminPageFactory.clickMenuPayGrade();
            Thread.sleep(2000);
            //add Pay Grade Currency and save Currency
            adminPageFactory.clickBtnAddPayGrade();
            Thread.sleep(2000);
            adminPageFactory.addTxtInCurrencyNameTxtBox("Indian Rupee5");
            adminPageFactory.clickBtnSaveCurrency();
            Thread.sleep(2000);
            //add currency info records by selecting currency and adding min Salary & max Salary
            adminPageFactory.clickBtnAddCurrencyRecord();
            Thread.sleep(1000);
            adminPageFactory.clickInputCurrencyDropdown();
            adminPageFactory.addTxtInInputCurrencyDropdown("i");
            new Actions(driver).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
                    .sendKeys(Keys.ENTER).build().perform();
            Thread.sleep(1000);
            adminPageFactory.setEmpMinSalary("30000");
            adminPageFactory.setEmpMaxSalary("100000");
            Thread.sleep(1000);
            adminPageFactory.clickBtnSubmitSalary();
            Thread.sleep(5000);
            Assert.assertEquals(adminPageFactory.getTxtRecordResult(), "(1) Record Found");
            Assert.assertEquals(adminPageFactory.getCurrencyNameFromTxtCurrencyRecord(), "Indian Rupee");
            Assert.assertEquals(adminPageFactory.getMinSalFromTxtCurrencyRecord(), "30000.00");
            Assert.assertEquals(adminPageFactory.getMaxSalFromTxtCurrencyRecord(), "100000.00");
        } finally {
            closeBrowser();
        }
    }
}
