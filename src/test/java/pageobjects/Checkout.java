// filename: pageobjects/Checkout.java

package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import static org.openqa.selenium.support.ui.Select.*;

public class Checkout extends Base {

  private WebDriver driver;
  // Address Fields
  By firstNameField = By.name("firstname");
  By lastNameField = By.name("lastname");
  By address1Field = By.name("streetAddress");
  By address2Field = By.name("streetAddress2");
  By cityField = By.name("city");
  By stateDropdown = By.name("states");
  By stateText = By.linkText("Pennsylvania");
  By zipCodeField = By.name("postalCode");

  // Shipping Options
  By standardShipping = By.cssSelector(".qa-selectable-option-shipping-method-us-std");
  By stdShipping = By.xpath("//*[contains(@class, 'qa-shipping-method-options')]//*[@cssSelector='.qa-selectable-option-shipping-method-us-std']");
  By standardShippingSelected = By.cssSelector(".is-selected.qa-selectable-option-shipping-method-us-std");
  By twoDayShipping = By.cssSelector("");
  By twoDayShippingSelected = By.cssSelector(".");
  By overnightShipping = By.name("");
  By overnightShippingSelected = By.cssSelector("");

  // Payment Options
  By payByCreditCard = By.cssSelector(".qa-selectable-option-payment-method-credit-card");
  By inputCreditCardNumber = By.cssSelector(".qa-input-cardNumber");
  By inputExpirationDate = By.cssSelector(".qa-input-expirationDate");
  By inputSecurityCode = By.cssSelector(".qa-input-securityCode");
  By inputPhoneNumber = By.cssSelector(".qa-input-phoneNumber");
  By payByPayPal = By.cssSelector(".qa-selectable-option-payment-method-paypal");
  By payPalSelected = By.cssSelector(".qa-section-payment-paypal-desc");

  // Final Info
  By emailAddress = By.cssSelector(".qa-input-email"); // anonymous users
  By placeOrder = By.cssSelector(".qa-btn-place-order");
  By placeOrderPayPal = By.cssSelector(".qa-btn-place-order-paypal");

  public Checkout(WebDriver driver) {
    super(driver);
  }

  private void getState(String userState) {
    Select selectList = new Select(find(stateDropdown));
    selectList.selectByVisibleText(userState);
  }

  public void anonShipInfo(String state) {
    type("Test", firstNameField);
    type("User", lastNameField);
    type("666 Second Ave.", address1Field);
    type("Apt. 42", address2Field);
    type("Pittsburgh", cityField);
    click(stateDropdown);
    getState(state);
    type("15218", zipCodeField);
  }

  public void shippingOption() {
    isDisplayed(standardShipping);
    isDisplayed(twoDayShipping);
    isDisplayed(overnightShipping);
    click(stdShipping);
  }

  public void selectPaymentMethod(String paymentMethod) {
    isDisplayed(payByCreditCard);
    isDisplayed(payByPayPal);
    if (paymentMethod.equals("CC")) {
      click(payByCreditCard);
    } else {
      click(payByPayPal);
    }
  }

  // Assertion methods

  public Boolean placeOrderButtonPresent() {
    isDisplayed(placeOrder, 10);
    return isDisplayed(placeOrder);
  }

  public Boolean shipmentTypeSelected() {
    isDisplayed(standardShippingSelected, 1);
    return isDisplayed(standardShippingSelected);
  }

  public Boolean paymentMethodSelected(String paymentMethod) {
    if (paymentMethod.equals("CC")) {
      isDisplayed(inputCreditCardNumber);
      return isDisplayed(inputCreditCardNumber);
    } else {
      isDisplayed(payPalSelected, 1);
      return isDisplayed(payPalSelected);
    }
  }

}