package com.thtung.page;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

public class pageObject extends PageObject {
  @FindBy(xpath = "//a[text()='Input Forms']")
  public WebElementFacade sidebarInputForms;

  public void clickInputForms() {
    waitFor(sidebarInputForms).waitUntilVisible().click();
//    find(By.xpath("//a[text()='Input Forms']")).click();
  }

  public void clickSelectInputForm() {
    WebElementFacade btnInputForm = $(By.xpath("//a[text()='Input Forms']"));

//    scrollIntoView(getDriver(), btnNext);
    btnInputForm.waitUntilVisible().click();
  }

  public void clickSelectSimpleForm() {
    WebElementFacade btnSimpleForm = $(By.xpath("//a[text()='Input Forms']/..//a[text()='Simple Form Demo']"));
//    scrollIntoView(getDriver(), btnNext);
    btnSimpleForm.waitUntilVisible().click();
  }

  public void inputRandom(String random) {
    WebElementFacade messageField = $(By.id("user-message"));
    messageField.waitUntilVisible().type(random);
  }
  public void clickShowMeassage() {
    WebElementFacade btnShowMeassage = $(By.xpath("//button[text()='Show Message']"));
//    scrollIntoView(getDriver(), btnNext);
    btnShowMeassage.waitUntilVisible().click();
  }
  public void closePopup() {
    WebElementFacade btnPopup = $(By.id("at-cv-lightbox-close"));
//    scrollIntoView(getDriver(), btnNext);
    btnPopup.waitUntilVisible().click();
  }
  public boolean checkMessageDisplay(String message) {
    WebElementFacade btnVerifyMessage = $(By.xpath(String.format("//span[@id='display' and text()='%s']",message)));
    return btnVerifyMessage.waitUntilVisible().isVisible();


  }
  public void EnterA(String a) {
    WebElementFacade firstField = $(By.id("sum1"));
    firstField.waitUntilEnabled().type(a);
  }
  public void EnterB(String b) {
    WebElementFacade secondField = $(By.id("sum1"));
    secondField.waitUntilEnabled().type(b);
  }
  public void clickGetTotal() {
    WebElementFacade btnGetTotal = $(By.xpath("//button[text()=\"Get Total\"]"));
//    scrollIntoView(getDriver(), btnNext);
    btnGetTotal.waitUntilVisible().click();
  }
}
