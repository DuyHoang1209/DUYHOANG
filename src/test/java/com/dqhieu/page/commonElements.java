package com.dqhieu.page;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.FindBy;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class commonElements extends PageObject {

    @FindBy(xpath = "//a[contains(text(), 'Input Forms')]")
    public WebElementFacade sb_inputForm;

    @FindBy(xpath = "//a[contains(text(), 'Simple Form Demo')]")
    public WebElementFacade sb_simpleFormDemo;

    @FindBy(id = "at-cv-lightbox-close")
    public WebElementFacade closePopupBtn;

    @FindBy(id = "user-message")
    public WebElementFacade messageField;

    @FindBy(xpath = "//button[text()='Show Message']")
    public WebElementFacade showMessageButton;

    @FindBy(id = "display")
    public WebElementFacade verifyMessage;

    @FindBy(id = "sum1")
    public WebElementFacade firstField;

    @FindBy(id = "sum2")
    public WebElementFacade secondField;

    @FindBy(xpath = "//button[text()='Get Total']")
    public WebElementFacade getTotalButton;

    @FindBy(id = "displayvalue")
    public WebElementFacade verifyGetTotal;

    public void clickInputForm(){
        sb_inputForm.waitUntilVisible().click();
    }

    public void clickSimpleForm(){
        sb_simpleFormDemo.waitUntilVisible().click();
    }

    public void closeAdsPopup() {
        closePopupBtn.waitUntilVisible().click();
    }

//    public void clickOnSidebarMenu(String sidebarMenu) {
////        waitFor(closePopupBtn).waitUntilNotVisible();
//        find(By.xpath(String.format("//li[@class='tree-branch']//a[contains(text(), '%s')]", sidebarMenu))).waitUntilClickable().click();
//    }
    public void enterYourMessage(){
        Random generator = new Random();
        int i = generator.nextInt(99);

        String s = RandomStringUtils.randomAlphabetic(2).toLowerCase(Locale.ROOT);

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy ");
        Date date = new Date();
        String currentDate= dateFormat.format(date);

        messageField.waitUntilVisible().sendKeys(String.format("%02d", i)+s+currentDate);

    }
    public void showMessage(){
        showMessageButton.waitUntilVisible().click();
    }
    public boolean verifyMessage(){
        return verifyMessage.waitUntilVisible().isDisabled();
    }
    public void EnterA(String a){
        firstField.waitUntilVisible().sendKeys(a);
    }
    public void EnterB(String b){
        secondField.waitUntilVisible().sendKeys(b);
    }
    public void getTotal(){
        getTotalButton.waitUntilVisible().click();
    }
    public boolean verifyTotal(){
        return verifyGetTotal.waitUntilVisible().isDisplayed();
    }
}