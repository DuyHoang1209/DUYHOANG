package com.thtung.page;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

public class pageObject extends PageObject {

  public void goToMobileMenu() {
    WebElementFacade btnMobile = $(By.id("MobileSec"));
    scrollIntoView(getDriver(), btnMobile);
    btnMobile.waitUntilVisible().click();
  }

  public void goToMobileRatePlan() {
    WebElementFacade btnMobileRatePlan = $(By.xpath("//a[contains(text(), 'Mobile Rate Plans')]"));
//    scrollIntoView(getDriver(), btnMobileRatePlan);
    btnMobileRatePlan.waitUntilVisible().click();
  }

  public void clickNextButtonSelectPlanScreen() {
    WebElementFacade btnNext = $(By.xpath("//a[@class='flex-next']"));
//    scrollIntoView(getDriver(), btnNext);
    btnNext.waitUntilVisible().click();
  }

  public void clickGetRs600Plan() {
    WebElementFacade btnGetPlan600 = $(By.id("PostpaidPlan600"));
    scrollByCoordinates(getDriver());
    while (!checkRs600PlanVisibility()) {
      clickNextButtonSelectPlanScreen();
      if (checkRs600PlanVisibility()) {
        btnGetPlan600.click();
        break;
      }
    }
  }

  public boolean checkRs600PlanVisibility() {
    WebElementFacade btnGetPlan600 = $(By.id("PostpaidPlan600"));
    try {
      btnGetPlan600.waitUntilVisible().isVisible();
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public void clickSelectPlanButton() {
    WebElementFacade btnSelectPlan = $(By.xpath("(//*[@id='6214c68bae2b4335b9d9583a'])[1]"));
    scrollIntoView(getDriver(), btnSelectPlan);
    btnSelectPlan.waitUntilVisible().click();
  }

  public boolean checkOTPPopUpVisibility() {
    WebElementFacade btnVerify = $(By.id("o2a-verify-otp"));
    return btnVerify.waitUntilVisible().isVisible();
  }

  public void selectForeignerIdentityVerificationScr() {
    WebElementFacade radioBtnForeigner = $(By.xpath("//label[contains(text(), 'Foreigner')]"));
    radioBtnForeigner.waitUntilVisible().click();
  }

  public void inputPassportNumber(String passportNumber) {
    WebElementFacade passportField = $(By.id("o2a-step2-passport"));
    passportField.waitUntilVisible().type(passportNumber);
  }

  public void inputMobileNumber(String mobileNumber) {
    WebElementFacade mobileNumberField = $(By.id("o2a-step2-enter-mobile-num"));
    mobileNumberField.waitUntilEnabled().type(mobileNumber);
  }

  public void clickContinueButton( ) {
    WebElementFacade continueBtn = $(By.id("continue-button"));
    continueBtn.click();
  }

  public void clickContinueButtonAgain( ) {
    WebElementFacade continueBtn2 = $(By.id("continue-button-2"));
    continueBtn2.click();
  }

  public static void scrollIntoView(WebDriver driver, WebElementFacade we) {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView(true);", we);
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void scrollByCoordinates(WebDriver driver) {
    //scroll with Javascript Executor
    JavascriptExecutor j = (JavascriptExecutor) driver;
    j.executeScript("window.scrollBy(" + 0 + ", " + 650 + ");");
  }
}
