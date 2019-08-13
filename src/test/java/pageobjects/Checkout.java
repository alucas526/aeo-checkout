// filename: pageobjects/Checkout.java

package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Checkout extends Base {

  // Address Fields
  private By firstNameField = By.name("firstname");
  private By lastNameField = By.name("lastname");
  private By address1Field = By.name("streetAddress");
  private By address2Field = By.name("streetAddress2");
  private By cityField = By.name("city");
  private By stateDropdown = By.name("states");
  private By zipCodeField = By.name("postalCode");

  // Shipping Options
  private By standardShipping = By.cssSelector(".qa-shipping-method-us-std");
  private By standardShippingSelected = By.cssSelector(".is-selected.qa-selectable-option-shipping-method-us-std");
  private By twoDayShipping = By.cssSelector(".qa-shipping-method-us-2dy");
  private By twoDayShippingSelected = By.cssSelector(".is-selected.qa-selectable-option-shipping-method-us-2dy");
  private By overnightShipping = By.name(".qa-shipping-method-us-ont");
  private By overnightShippingSelected = By.cssSelector(".is-selected.qa-selectable-option-shipping-method-us-ont");

  // Payment Options
  private By payByCreditCard = By.cssSelector(".qa-selectable-option-payment-method-credit-card");
  private By inputCreditCardNumber = By.name("cardNumber");
  private By inputExpirationDate = By.name("expirationDate");
  private By inputSecurityCode = By.name("securityCode");
  private By inputPhoneNumber = By.name("phoneNumber");
  private By payByPayPal = By.cssSelector(".qa-selectable-option-payment-method-paypal");
  private By payPalSelected = By.cssSelector(".qa-section-payment-paypal-desc");

  // Final Info
  private By inputEmailAddress = By.name("email"); // anonymous users
  private By placeOrderCCButton = By.cssSelector(".qa-btn-place-order");
  private By placeOrderPayPalButton = By.cssSelector(".qa-btn-place-order-paypal");

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
    type("alucas+testaeo@gmail.com", inputEmailAddress);
  }

  public void shippingOption(String shipSpeed) {
    isDisplayed(standardShipping, 1);
    isDisplayed(twoDayShipping, 1);
    isDisplayed(overnightShipping, 1);
    if (shipSpeed.equals("standard")) {
      click(standardShipping);
    } else if (shipSpeed.equals("2dy")) {
      click(twoDayShipping);
    } else if (shipSpeed.equals("ont")) {
      click(overnightShipping);
    }
  }

  public void selectPaymentMethod(String paymentMethod) {
    isDisplayed(payByCreditCard);
    isDisplayed(payByPayPal);
    if (paymentMethod.equals("PayPal")) {
      click(payByPayPal);
    } else {
      click(payByCreditCard);
    }
  }

  public void enterPaymentInfo(String paymentMethod, String expirationDate, String securityCode) {
    if (paymentMethod.equals("PayPal")) {
      isDisplayed(placeOrderPayPalButton);
      click(placeOrderPayPalButton);
    } else {
      isDisplayed(inputCreditCardNumber, 10);
      isDisplayed(inputExpirationDate);
      isDisplayed(inputSecurityCode);
      isDisplayed(inputPhoneNumber);
      isDisplayed(placeOrderCCButton);
      type(paymentMethod, inputCreditCardNumber);
      type(paymentMethod, inputCreditCardNumber);
      type(expirationDate, inputExpirationDate);
      type(securityCode, inputSecurityCode);
      type("412-555-1212", inputPhoneNumber);
      click(placeOrderCCButton);
    }
  }

  // Assertion methods

  public Boolean placeOrderButtonPresent() {
    isDisplayed(placeOrderCCButton, 10);
    return isDisplayed(placeOrderCCButton);
  }

  public Boolean shipmentTypeSelected() {
    isDisplayed(standardShippingSelected, 1);
    return isDisplayed(standardShippingSelected);
  }

  public Boolean paymentMethodSelected(String paymentMethod) {
    if (paymentMethod.equals("PayPal")) {
      isDisplayed(payPalSelected, 1);
      return isDisplayed(payPalSelected);
    } else {
      isDisplayed(inputCreditCardNumber);
      return isDisplayed(inputCreditCardNumber);
    }
  }

}
